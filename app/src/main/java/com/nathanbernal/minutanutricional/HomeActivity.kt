package com.nathanbernal.minutanutricional

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.nathanbernal.minutanutricional.models.Menus

class HomeActivity : AppCompatActivity() {

    private var menuList: ArrayList<Menus> = ArrayList<Menus>()
    lateinit var adapter: CustomAdapter // = CustomAdapter(Menus.getMenuList())
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        enableEdgeToEdge()

        Log.d("[main]", "CARGANDO FIREBASE...")
        database = FirebaseDatabase.getInstance().getReference("menu")
        Log.d("[main]", "FIREBASE CARGADO...")

        // CREACIÖN DE PLATOS
        //val servidorMinuta = ServidorMinuta()
        //val platos = servidorMinuta.crearDatoPlato()
        //servidorMinuta.enviarDatosPlato(platos)

        setContentView(R.layout.activity_home)

        obtenerDatosMenu()

        adapter = CustomAdapter(menuList)
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun obtenerDatosMenu() {

        val menuRef = database.child("/")

        menuRef.addListenerForSingleValueEvent(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                Log.d("[obtenerDatosMenu]", "RECUPERANDO DATOS...")

                if (snapshot.exists()) {

                    for (sem in snapshot.children) {

                        menuList.add(Menus(
                            sem.child("menuId").getValue().toString().toInt(),
                            sem.child("semanaId").getValue().toString().toInt(),
                            sem.child("nombre").getValue().toString(),
                            sem.child("descripcion").getValue().toString(),
                            R.drawable.plato_aa //sem.child("imagenUri").getValue().toString(),
                        ))

                    }

                    Log.d("[Obtener datos]", menuList.toString())
                    adapter = CustomAdapter(menuList)
                    var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                    //recyclerView.layoutManager = LinearLayoutManager(this)
                    recyclerView.adapter = adapter

                } else {
                    Log.d("[Menu Api]", "No se encontraron datos")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("[Error Menu]", "Error al obtener datos de semana ${error.message}")
            }

        })

        Log.d("[MENU-OUT]", menuList.count().toString())

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

}