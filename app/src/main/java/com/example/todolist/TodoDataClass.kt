package com.example.todolist

class TodoDataClass {

    companion object {
        var todolist = arrayListOf<String>("할일 1", "할일 2")
        var adapter : TodoAdapter? = null
        fun addItem(item : String) {
            todolist.add(item)
        }
        fun removeItem(position : Int) {
            todolist.removeAt(position)
        }

        fun setTodoAdapter(todoAdapter : TodoAdapter){
            adapter = todoAdapter
        }
    }

}