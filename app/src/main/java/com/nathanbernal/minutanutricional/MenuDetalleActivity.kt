package com.nathanbernal.minutanutricional

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.nathanbernal.minutanutricional.models.Menus

class MenuDetalleActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    var menus:ArrayList<Menus> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_detalle)

        val adapter = MyListAdapter(this, menus)
        listView = findViewById(R.id.list)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, position, id -> {
                Toast.makeText(this, "Title = Title${position + 1}", Toast.LENGTH_LONG).show()
            }
        }

        setDataList()

    }

    fun setDataList() {
        menus.add(Menus(
            1,
            1,
            "Plato #1",
            "Prueba",
            R.drawable.plato_aa
        ))
        menus.add(Menus(
            2,
            1,
            "Plato #2",
            "Prueba",
            R.drawable.plato_aa
        ))
        menus.add(Menus(
            3,
            2,
            "Plato #3",
            "Prueba",
            R.drawable.plato_aa
        ))
        menus.add(Menus(
            4,
            3,
            "Plato #4",
            "Prueba",
            R.drawable.plato_aa
        ))
        menus.add(Menus(
            5,
            3,
            "Plato #5",
            "Prueba",
            R.drawable.plato_aa
        ))
    }

}