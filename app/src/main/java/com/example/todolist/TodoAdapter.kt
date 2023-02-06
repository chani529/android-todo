package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TodoItemBinding

class TodoAdapter():RecyclerView.Adapter<ViewHolder>() {

    private var datalist = TodoDataClass.todolist

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TodoItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, this)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
    fun getAdapter() :RecyclerView.Adapter<ViewHolder> {
        return this
    }

}

class ViewHolder(private val binding: TodoItemBinding,var adapter: TodoAdapter) : RecyclerView.ViewHolder(binding.root) {

    fun bind(get: String) {
        binding.todo.text = get
        binding.deleteButton.setOnClickListener(View.OnClickListener() {
            var position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                TodoDataClass.removeItem(position)
                adapter.notifyItemRemoved(position)
            }
        })
    }

}