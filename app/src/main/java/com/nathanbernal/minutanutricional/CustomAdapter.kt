package com.nathanbernal.minutanutricional

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nathanbernal.minutanutricional.models.Menus

class CustomAdapter(private val menuList: List<Menus>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    val onItemClick: ((Menus) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_menu_layout, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = menuList[i].nombre
        viewHolder.itemDetail.text = menuList[i].descripcion
        viewHolder.itemImage.setImageResource(menuList[i].imgResource)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
            itemImage.setOnClickListener {
                onItemClick?.invoke(menuList[adapterPosition])
                System.out.println("Position "+adapterPosition+" / "+menuList[adapterPosition].nombre)
            }
        }
    }



}