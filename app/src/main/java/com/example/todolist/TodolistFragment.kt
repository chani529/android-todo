package com.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.FragmentTodolistBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TodolistFragment : Fragment() {

    private var _binding: FragmentTodolistBinding? = null
    private lateinit var adapter: TodoAdapter
    private lateinit var mainActivity: MainActivity

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        println(mainActivity)
        FragmentManager.

        _binding = FragmentTodolistBinding.inflate(inflater, container, false)
        //===== 테스트를 위한 더미 데이터 생성 ===================
        val todoDataList : ArrayList<String> = ArrayList()
        for (i in 1..2){
            todoDataList.add("할일 $i")
        }
        _binding?.todoList?.layoutManager=LinearLayoutManager(activity)
        adapter = TodoAdapter(todoDataList)
        _binding?.todoList?.adapter = adapter

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}