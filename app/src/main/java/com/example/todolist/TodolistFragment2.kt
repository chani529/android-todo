package com.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.FragmentTodolistOneBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TodolistFragment2 : Fragment() {

    private var _binding: FragmentTodolistOneBinding? = null
    private lateinit var adapter: TodoAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTodolistOneBinding.inflate(inflater, container, false)

        _binding?.todoList?.layoutManager=GridLayoutManager(activity,2)
        adapter = TodoAdapter()
        _binding?.todoList?.adapter = adapter
        TodoDataClass.setTodoAdapter(adapter)
        return binding.root

    }
    fun getAdapter(): TodoAdapter {
        return adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}