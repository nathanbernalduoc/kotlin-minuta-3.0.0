package com.nathanbernal.minutanutricional

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nathanbernal.minutanutricional.models.Menus
import com.nathanbernal.minutanutricional.models.Platos

class PlatosListActivity : AppCompatActivity() {

    private var platosList: ArrayList<Platos> = ArrayList<Menus>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        enableEdgeToEdge()

        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        setDataList()
        var adapter = CustomAdapter(platosList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    fun setDataList() {
        platosList.add(Menus(
            1,
            1,
            "Semana 1",
            "Prueba",
            R.drawable.plato_aa
        ))
        platosList.add(Menus(
            2,
            1,
            "Semana 2",
            "Prueba",
            R.drawable.plato_aa
        ))
        platosList.add(Menus(
            3,
            2,
            "Semana 3",
            "Prueba",
            R.drawable.plato_aa
        ))
        platosList.add(Menus(
            4,
            3,
            "Semana 4",
            "Prueba",
            R.drawable.plato_aa
        ))
        platosList.add(Menus(
            5,
            3,
            "Semana #5",
            "Prueba",
            R.drawable.plato_aa
        ))
    }

}