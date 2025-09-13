package com.example.assessment1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.activityViewModels

class CafeAdapter (
    private val cafes: MutableList<Cafe>,
    private val vm : CafesViewModel
) : RecyclerView.Adapter<CafeAdapter.CafeViewHolder>() {

    class CafeViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val title: TextView = view.findViewById(R.id.cafeTitle)
        val category: TextView = view.findViewById(R.id.cafeCategory)
        val image: ImageView = view.findViewById(R.id.cafeImage)

        val favouriteBtn: ImageButton = view.findViewById(R.id.favouriteBtn)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CafeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cafe, parent, false)
        return CafeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CafeViewHolder, position: Int) {
        val cafe = cafes[position]
        holder.title.text = cafe.title
        holder.category.text = cafe.category
        holder.image.setImageResource(cafe.imageID)

        holder.favouriteBtn.setImageResource(
            if (cafe.isFavourited) R.drawable.filled_heart else R.drawable.empty_heart
        )

        holder.favouriteBtn.setOnClickListener {
            vm.toggleFavourite(cafe)

            holder.favouriteBtn.setImageResource(
                if (cafe.isFavourited) R.drawable.filled_heart else R.drawable.empty_heart
            )
            if (cafe.isFavourited) {
                Toast.makeText(holder.itemView.context, "${cafe.title} added to favourites", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(holder.itemView.context, "${cafe.title} removed from favourites", Toast.LENGTH_SHORT).show()
            }

        }

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, CafeDetailsActivity::class.java)
            intent.putExtra("cafe", cafe)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int = cafes.size

    fun updateList(newCafes: List<Cafe>) {
        cafes.clear()
        cafes.addAll(newCafes)
        notifyDataSetChanged()
    }
}