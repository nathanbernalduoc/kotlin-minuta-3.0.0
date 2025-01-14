package com.nathanbernal.minutanutricional

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nathanbernal.minutanutricional.models.Menus

class MyListAdapter (
    val context:Activity,
    val menus:ArrayList<Menus>
):ArrayAdapter<Menus?>(context, R.layout.my_list, menus as List<Menus>) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.my_list, null, true)

        val titleText = rowView.findViewById<TextView>(R.id.platoTitle)
        val subTitleText = rowView.findViewById<TextView>(R.id.platoDetail)
        //val imgView = rowView.findViewById<ImageView>(R.id.pla)

        System.out.println("Nombre "+menus[position].nombre)

        titleText.text = menus[position].nombre
        subTitleText.text = menus[position].descripcion
        System.out.println("Image resource "+menus[position].imgResource)
        //imgView.setImageResource(R.drawable.plato_aa)

        return super.getView(position, convertView, parent)

    }


}