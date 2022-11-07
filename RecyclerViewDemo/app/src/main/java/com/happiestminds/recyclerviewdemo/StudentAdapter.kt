package com.happiestminds.recyclerviewdemo

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(val dataSet: MutableList<Student>,
                     val action: (Student, Int)->Unit)
    : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView = itemView.findViewById<TextView>(R.id.nameT)
        val marksTextView = itemView.findViewById<TextView>(R.id.marksT)
        val rollTextView = itemView.findViewById<TextView>(R.id.rollT)
    }

    // called by recyclerView when views to be created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        // inflate list item layout, create viewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,
            false)
        Log.d("StudentAdapter", "onCreatedViewHolder called")
        return StudentViewHolder(view)
    }

    // called by RecyclerView when data to be bound to views
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        Log.d("StudentAdapter", "onBindViewHolder called $position")
        val std = dataSet[position]
        holder.nameTextView.text = std.name
        holder.rollTextView.text = "Roll NO:${std.rollNo}"
        holder.marksTextView.text = "Marks: ${std.marks}"


        holder.itemView.setOnClickListener {
            action(std, holder.adapterPosition)
        }

        val cardV = holder.itemView as CardView

        when (std.marks){
            in 75..100 -> cardV.setCardBackgroundColor(Color.MAGENTA)
            in 65..75 -> cardV.setCardBackgroundColor(Color.BLUE)
            in 55..65 -> cardV.setCardBackgroundColor(Color.YELLOW)
            in 35 .. 55 -> cardV.setCardBackgroundColor(Color.DKGRAY)
            else -> cardV.setCardBackgroundColor(Color.RED)

        }
    }

    override fun getItemCount() = dataSet.size

}