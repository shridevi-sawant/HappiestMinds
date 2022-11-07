package com.happiestminds.webcommdemo

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class PlaceAdapter(
    private val values: List<Place>, val action: (Place)->Unit
) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // rendering xml
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_item,
                parent, false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = values[position]
        holder.nameTextView.text = place.name
        holder.cityTextView.text = place.city
        holder.cCodeTextView.text = place.cCode
        holder.stateTextView.text = place.state

        holder.itemView.setOnClickListener {
            action(place)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView = view.findViewById<TextView>(R.id.nameT)
        val cityTextView = view.findViewById<TextView>(R.id.cityT)
        val stateTextView = view.findViewById<TextView>(R.id.stateT)
        val cCodeTextView = view.findViewById<TextView>(R.id.codeT)
    }

}