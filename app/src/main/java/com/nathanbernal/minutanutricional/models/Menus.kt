package com.nathanbernal.minutanutricional.models

import android.view.Menu

data class Menus (

    val menuId: Int,
    val semanaId: Int,
    val nombre: String,
    val descripcion: String,
    val imgResource: Int) {

    companion object {
        private val listaMenus = mutableListOf<Menus>()

        fun addMenu(menu: Menus) {
            listaMenus.add(menu)
        }

        fun getMenuList(): List<Menus> {
            return listaMenus
        }

        fun getMenu(menuId: Int): Menus? {
            return listaMenus.find { it.menuId.equals(menuId) }
        }

        fun getMenuSemana(semanaId: Int): List<Menus> {
            return listaMenus.filter { it.semanaId.equals(semanaId) }
        }

    }
}