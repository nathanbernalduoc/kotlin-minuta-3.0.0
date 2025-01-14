package com.nathanbernal.minutanutricional

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nathanbernal.minutanutricional.models.Platos

class CustomAdapterPlatos(private val platosList: List<Platos>): RecyclerView.Adapter<CustomAdapterPlatos.ViewHolder>() {
    val onItemClick: ((Platos) -> Unit)? = null
    private var listener: ((Platos) -> Unit)? = null

    fun setOnItemClickListener(f: (Platos) -> Unit) {
        listener = f
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_menu_layout, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = platosList[i].nombre
        viewHolder.itemDetail.text = platosList[i].descripcion
        viewHolder.itemImage.setImageResource(platosList[i].imgResource)
    }

    override fun getItemCount(): Int {
        return platosList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
            /*
            * Se puede tocar el card para seleccionar semana
            */
            itemView.setOnClickListener {
                listener?.invoke(platosList[adapterPosition])
                System.out.println("Position "+adapterPosition+" / "+platosList[adapterPosition].nombre)
            }

        }
    }



}