package com.nathanbernal.minutanutricional

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nathanbernal.minutanutricional.models.Menus
import com.nathanbernal.minutanutricional.models.Platos

class PlatosActivity : AppCompatActivity() {

    private var platoList: ArrayList<Platos> = ArrayList<Platos>()
    var adapter: CustomAdapterPlatos = CustomAdapterPlatos(Platos.getPlatosList())
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_platos)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        setDataList()
        var adapter = CustomAdapterPlatos(platoList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

    fun setDataList() {
        platoList.add(
            Platos(
                1,
                1,
                "Arroz con Huevo",
                "Porción de arroz con un huevo frito y sal",
                R.drawable.plato_aa
            )
        )
        platoList.add(
            Platos(
                1,
                1,
                "Porotos con riendas",
                "Fideos con porotos en caldo de zapallo",
                R.drawable.plato_aa
            )
        )
        platoList.add(
            Platos(
                1,
                1,
                "Filete a lo pobre",
                "1/4 de filete sobre una cama de papas fritas con huevo frito y cebolla",
                R.drawable.plato_aa
            )
        )
        platoList.add(
            Platos(
                1,
                1,
                "Ensalada de Quinoa",
                "Mezcla de Quinoa con pepino, tomate cherry y semillas",
                R.drawable.plato_aa
            )
        )
        platoList.add(
            Platos(
                1,
                1,
                "Estofado de pavo",
                "Pavo a la cacerola con papas cocidas y cebolla",
                R.drawable.plato_aa
            )
        )
    }
}