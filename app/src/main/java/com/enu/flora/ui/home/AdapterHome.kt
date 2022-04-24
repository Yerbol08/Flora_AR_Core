package com.enu.flora.ui.home

import ItemsHome
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enu.flora.R

class AdapterHome(private val list: List<ItemsHome>, var context: Context):RecyclerView.Adapter<AdapterHome.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHome.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: AdapterHome.ViewHolder, position: Int) {
        val itemsHome = list[position]
        holder.imageView.setImageResource(itemsHome.image)
        holder.textView.setText(itemsHome.text)
        holder.imageView.setOnClickListener(View.OnClickListener {
            var intent: Intent = Intent(context, InfoActivity::class.java)
            intent.putExtra("name", itemsHome.text)
            intent.putExtra("image", itemsHome.image)
            intent.putExtra("position", position)
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder (ItemView: View):RecyclerView.ViewHolder(ItemView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.txtViewFlower)
    }
}