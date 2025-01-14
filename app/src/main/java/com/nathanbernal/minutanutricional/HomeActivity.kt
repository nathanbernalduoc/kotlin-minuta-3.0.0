package com.nathanbernal.minutanutricional

import android.app.LocaleConfig
import android.content.Context
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

class HomeActivity : AppCompatActivity() {

    private var menuList: ArrayList<Menus> = ArrayList<Menus>()
    var adapter: CustomAdapter = CustomAdapter(Menus.getMenuList())
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        enableEdgeToEdge()

        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        setDataList()
        var adapter = CustomAdapter(menuList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    fun goDetail(view: View?) {
        startActivity(Intent(this, PlatosActivity::class.java))
        adapter.setOnItemClickListener {
            System.out.println("Resultado del click "+it.menuId)
            //Toast.makeText(this, "Menu "+it.menuId, Toast.LENGTH_SHORT).show()
            System.out.println("Resultado del click "+it.menuId)
        }

    }

    fun setDataList() {
        menuList.add(Menus(
            1,
            1,
            "Semana 1",
            "Prueba",
            R.drawable.plato_aa
        ))
        menuList.add(Menus(
            2,
            1,
            "Semana 2",
            "Iniciando la semana",
            R.drawable.plato_aa
        ))
        menuList.add(Menus(
            3,
            2,
            "Semana 3",
            "Ya estamos en marcha!",
            R.drawable.plato_aa
        ))
        menuList.add(Menus(
            4,
            3,
            "Semana 4",
            "Enfrentando desafíos",
            R.drawable.plato_aa
        ))
        menuList.add(Menus(
            5,
            3,
            "Semana #5",
            "Estamos casi casi!",
            R.drawable.plato_aa
        ))
    }

}