package com.nathanbernal.minutanutricional

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.nathanbernal.minutanutricional.models.Menus
import com.nathanbernal.minutanutricional.models.Platos

class PlatosActivity : AppCompatActivity() {

    private var platoList: ArrayList<Platos> = ArrayList<Platos>()
    var adapter: CustomAdapterPlatos = CustomAdapterPlatos(Platos.getPlatosList())
    private lateinit var context: Context
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_platos)

        Log.d("PLATOS", "Firebase connect...")
        database = FirebaseDatabase.getInstance().getReference("plato")
        Log.d("PLATOS", "Firebase connect DONE")

        //setDataList()
        obtenerDatosPlato()


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = CustomAdapterPlatos(platoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    private fun obtenerDatosPlato() {

        Log.d("PLATOS", "Activando API")
        val platoRef = database.child("/")

        platoRef.addListenerForSingleValueEvent(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                Log.d("[obtenerDatosPlato]", "RECUPERANDO DATOS...")

                Log.d("[obtenerDatosPlato]", snapshot.exists().toString())
                if (snapshot.exists()) {

                    Log.d("[obtenerDatosPlato]", snapshot.children.toString())
                    for (sem in snapshot.children) {

                        Log.d("[obtenerDatosPlato]", "Plato nombre "+sem.child("nombre").getValue().toString())

                        platoList.add(Platos(
                            sem.child("platoId").getValue().toString().toInt(),
                            sem.child("menuId").getValue().toString().toInt(),
                            sem.child("nombre").getValue().toString(),
                            sem.child("descripcion").getValue().toString(),
                            R.drawable.plato_aa //sem.child("imagenUri").getValue().toString(),
                        ))

                    }

                    Log.d("[Obtener datos]", platoList.toString())
                    adapter = CustomAdapterPlatos(platoList)
                    var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                    recyclerView.adapter = adapter

                } else {
                    Log.d("[Plato Api]", "No se encontraron datos")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("[Error Plato]", "Error al obtener datos de plato ${error.message}")
            }

        })

        Log.d("[PLATO-OUT]", platoList.count().toString())

    }

    fun goDetail(view: View?) {
        startActivity(Intent(this, HomeActivity::class.java))
        adapter.setOnItemClickListener {
            System.out.println("Resultado del click "+it.menuId)
            System.out.println("Resultado del click "+it.menuId)
        }

    }

}