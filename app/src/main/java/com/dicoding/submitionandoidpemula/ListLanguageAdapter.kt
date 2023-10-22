package com.dicoding.submitionandoidpemula

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListLanguageAdapter(private val listLanguage: ArrayList<Language>) : RecyclerView.Adapter<ListLanguageAdapter.ListViewHolder>()  {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_language, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listLanguage.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listLanguage[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailLanguage::class.java).apply {
                putExtra("EXTRA_PHOTO", photo)
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_DESCRIPTION", description)
            }
            context.startActivity(intent)
        }
    }
}