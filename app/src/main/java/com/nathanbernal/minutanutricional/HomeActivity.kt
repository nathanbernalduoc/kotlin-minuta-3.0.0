package com.nathanbernal.minutanutricional

import android.app.LocaleConfig
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.snap
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.nathanbernal.minutanutricional.models.Menus

class HomeActivity : AppCompatActivity() {

    private var menuList: ArrayList<Menus> = ArrayList<Menus>()
    var adapter: CustomAdapter = CustomAdapter(Menus.getMenuList())
    private lateinit var context: Context
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        enableEdgeToEdge()

        database = FirebaseDatabase.getInstance().getReference("menu")

        setDataList()

        //menuList = obtenerDatosMenu()

        setContentView(R.layout.activity_home)
        var adapter = CustomAdapter(menuList)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun obtenerDatosMenu(): ArrayList<Menus> {

        val menuRef = database.child("/")

        menuRef.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (sem in snapshot.children) {
                        Log.d("FOREACH ", sem.key.toString())
                        Log.d("FOREACH ", sem.child("nombre").getValue().toString())
                        Log.d("FOREACH ", sem.child("menuId").getValue().toString())

                        menuList.add(Menus(
                            sem.child("menuId").getValue().toString().toInt(),
                            sem.child("semanaId").getValue().toString().toInt(),
                            sem.child("nombre").getValue().toString(),
                            sem.child("descripcion").getValue().toString(),
                            R.drawable.plato_aa //sem.child("imagenUri").getValue().toString(),
                        ))
                    }

                } else {
                    Log.d("Menu Api", "No se encontraron datos")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Error Menu", "Error al obtener datos de semana ${error.message}")
            }

        })

        return menuList

    }

    fun goDetail(view: View?) {
        adapter.setOnItemClickListener {
            System.out.println("Resultado del click "+it.menuId)
            Toast.makeText(this, "Menu "+it.menuId, Toast.LENGTH_SHORT).show()
            System.out.println("Resultado del click "+it.menuId)
        }
        val intent = Intent(this, PlatosActivity::class.java)
        startActivity(intent)

    }

    fun setDataList() {

        menuList = obtenerDatosMenu()

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