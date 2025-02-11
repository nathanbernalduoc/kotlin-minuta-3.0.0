package com.nathanbernal.minutanutricional

import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import com.nathanbernal.minutanutricional.models.Platos

data class MenuServicio (

    val menuId: Int = 0,
    val semanaId: Int = 0,
    val nombre: String = "",
    val descripcion: String = "",
    val imagenUri: String = "") {

}

data class PlatoServicio (
    val platoId: Int = 0,
    val menuId: Int = 0,
    val nombre: String = "",
    val descripcion: String = "",
    val imagenUri: Int = 1) {

}

data class SemanaServicio (
    val menuList: List<MenuServicio> = listOf(),
    val platoList: List<PlatoServicio> = listOf()
)

class ServidorMinuta {
    private val databaseMenu: DatabaseReference = Firebase.database.reference.child("menu")
    private val databasePlato: DatabaseReference = Firebase.database.reference.child("plato")

    fun enviarDatosMenu(menuData: Map<String, MenuServicio>) {
        databaseMenu.setValue(menuData).addOnSuccessListener {
            println("Datos enviados")
        }.addOnFailureListener { error ->
            println("Error al enviar los datos: ${error.message}")
        }
    }

    fun enviarDatosPlato(platoData: Map<String, PlatoServicio>) {
        databasePlato.setValue(platoData).addOnSuccessListener {
            println("Datos enviados")
        }.addOnFailureListener { error ->
            println("Error al enviar los datos: ${error.message}")
        }
    }

    fun crearDatoMenu(): Map<String, MenuServicio> {
        return mapOf(
            "Semana 1" to MenuServicio(
                1,
                1,
                "Semana 1",
                "Empezamos la semana",
                "https://img.freepik.com/foto-gratis/feliz-lunes-espanol_52683-99564.jpg"
            ),
            "Semana 2" to MenuServicio(
                2,
                2,
                "Semana 2",
                "Vamos bien!",
                "https://cdn.pensador.com/es/imagenes/feliz_martes-og.jpg"
            ),
            "Semana 3" to MenuServicio(
                3,
                3,
                "Semana 3",
                "Ya estamos en marcha!",
                "https://cdn.pensador.com/es/imagenes/feliz_martes-og.jpg"
            ),
            "Semana 4" to MenuServicio(
                4,
                4,
                "Semana 4",
                "Enfrentando desafíos!",
                "https://cdn.pensador.com/es/imagenes/feliz_martes-og.jpg"
            ),
            "Semana 5" to MenuServicio(
                5,
                5,
                "Semana 5",
                "Estamos casi casi!",
                "https://cdn.pensador.com/es/imagenes/feliz_martes-og.jpg"
            ),
        )
    }

    fun crearDatoPlato(): Map<String, PlatoServicio> {
        return mapOf(
            "1" to PlatoServicio(
                1,
                1,
                "Arroz con Huevo",
                "Porción de arroz con un huevo frito y sal",
                R.drawable.plato_aa
            ),
            "2" to PlatoServicio(
                1,
                1,
                "Porotos con riendas",
                "Fideos con porotos en caldo de zapallo",
                R.drawable.plato_aa
            ),
            "3" to PlatoServicio(
                1,
                1,
                "Filete a lo pobre",
                "1/4 de filete sobre una cama de papas fritas con huevo frito y cebolla",
                R.drawable.plato_aa
            ),
            "4" to PlatoServicio(
                1,
                1,
                "Ensalada de Quinoa",
                "Mezcla de Quinoa con pepino, tomate cherry y semillas",
                R.drawable.plato_aa
            ),
            "5" to PlatoServicio(
                1,
                1,
                "Estofado de pavo",
                "Pavo a la cacerola con papas cocidas y cebolla",
                R.drawable.plato_aa
            ),
        )
    }

}