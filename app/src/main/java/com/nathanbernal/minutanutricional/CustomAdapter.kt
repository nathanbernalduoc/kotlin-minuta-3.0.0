package com.nathanbernal.minutanutricional

import android.provider.ContactsContract.Contacts
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nathanbernal.minutanutricional.models.Menu

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val menuId = arrayOf(1,2,3,4)

    val titles = arrayOf("A","B","C","D")

    val details = arrayOf(
        "A",
        "B",
        "C",
        "D"
    )

    val images = intArrayOf(
        R.drawable.plato_aa,
        R.drawable.plato_aa,
        R.drawable.plato_aa,
        R.drawable.plato_aa,
    )

    val menu = Menu

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        var v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_menu_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])

    }

    override fun getItemCount(): Int {
        return titles.size;
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {

            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener {
                System.out.println("Title "+R.id.item_title.toString())
            }
        }
    }

}