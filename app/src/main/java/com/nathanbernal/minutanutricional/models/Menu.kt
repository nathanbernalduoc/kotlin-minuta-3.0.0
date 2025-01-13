package com.nathanbernal.minutanutricional.models

data class Menu (
    val menuId: Int,
    val semanaId: Int,
    val nombre: String,
    val descripcion: String,
    val imgUri: String) {
    companion object {
        private val listaMenu = mutableListOf<Menu>()

        fun addMenu(menu: Menu) {
            listaMenu.add(menu)
        }

        fun getMenuList(): List<Menu> {
            return listaMenu
        }

        fun getMenu(menuId: Int): Menu? {
            return listaMenu.find { it.menuId.equals(menuId) }
        }

        fun getMenuSemana(semanaId: Int): List<Menu> {
            return listaMenu.filter { it.semanaId.equals(semanaId) }
        }

    }
}