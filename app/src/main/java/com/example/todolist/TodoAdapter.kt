package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TodoItemBinding

class TodoAdapter(var datalist:MutableList<String>):RecyclerView.Adapter<ViewHolder>() {

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

}

class ViewHolder(private val binding: TodoItemBinding,var adapter: TodoAdapter) : RecyclerView.ViewHolder(binding.root) {


    fun bind(get: String) {
        binding.todo.text = get
        binding.deleteButton.setOnClickListener(View.OnClickListener() {
            println("TTTT")
            var position = adapterPosition
            println(this)
            println(adapter)
            if(position != RecyclerView.NO_POSITION){
                adapter.datalist.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
        })
    }

}