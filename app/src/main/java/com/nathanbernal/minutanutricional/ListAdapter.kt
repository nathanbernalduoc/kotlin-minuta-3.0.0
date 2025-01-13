package com.nathanbernal.minutanutricional

import android.content.Context
import android.graphics.ColorSpace.Model
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter (val context:Context, var resource: Int, var items: List<Model>):ArrayAdapter<Model>(context, resource, items) {

    override fun getView(position: Int, converView: View?, parent: ViewGroup?): View {

        val layoutInflater:LayoutInflater = LayoutInflater.from(context)
        val view:View = layoutInflater.inflate(resource, null)
        val imageView:ImageView = view.findViewById(R.id.iconIv)
        val textView:TextView = view.findViewById(R.id.titleTv)
        val textView2:TextView = view.findViewById(R.id.descTv)

        var mItems:Model = items[position]

        imageView.setImageDrawable(context.resources.getDrawable(R.drawable.plato_aa))
        textView.text = "Titulo plato";
        textView2.text = "Descripción plato"

        return view

    }

}