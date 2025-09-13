package com.example.assessment1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.activityViewModels

class CafeAdapter (
    private val cafes: List<Cafe>,
    private val context: Context
) : RecyclerView.Adapter<CafeAdapter.CafeViewHolder>() {

    class CafeViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val title: TextView = view.findViewById(R.id.cafeTitle)
        val category: TextView = view.findViewById(R.id.cafeCategory)
        val image: ImageView = view.findViewById(R.id.cafeImage)

        val favouriteBtn: ToggleButton = view.findViewById(R.id.favouriteBtn)
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

        holder.favouriteBtn.setOnCheckedChangeListener(null)
        holder.favouriteBtn.isChecked = cafe.isFavourited

        holder.favouriteBtn.setOnCheckedChangeListener { _, isChecked ->
            cafe.isFavourited = isChecked

            if (isChecked) {
                Toast.makeText(holder.itemView.context, "${cafe.title} added to favourites", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(holder.itemView.context, "${cafe.title} removed from favourites", Toast.LENGTH_SHORT).show()
            }

        }

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, CafeDetailsActivity::class.java)
            intent.putExtra("cafeIndex", position)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int = cafes.size
}