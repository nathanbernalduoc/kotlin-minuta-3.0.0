package com.nathanbernal.minutanutricional.models

import android.view.Menu
import androidx.recyclerview.widget.ListAdapter

data class Platos (
    val platoId: Int,
    val menuId: Int,
    val nombre: String,
    val descripcion: String,
    val imgResource: Int) {
    companion object {
        private val listaPlatos = mutableListOf<Platos>()

        fun addPlato(plato: Platos) {
            listaPlatos.add(plato)
        }

        fun getPlatosList(): List<Platos> {
            return listaPlatos
        }

        fun getMenu(platoId: Int): Platos? {
            return listaPlatos.find { it.menuId.equals(platoId) }
        }

        fun getPlatoMenu(menuId: Int): List<Platos> {
            return listaPlatos.filter { it.platoId.equals(menuId) }
        }

    }
}