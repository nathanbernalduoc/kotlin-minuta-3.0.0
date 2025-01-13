package com.nathanbernal.minutanutricional.models

data class Preparacion (val preparacionId:Int, val menuId:Int, val paso:String) {
    companion object {
        private val listaPreparacion = mutableListOf<Preparacion>()

        fun addPreparacion(preparacion: Preparacion) {
            listaPreparacion.add(preparacion)
        }

        fun getPreparacion(preparacionId: Int): Preparacion? {
            return listaPreparacion.find { it.preparacionId.equals(preparacionId) }
        }

        fun getPreparacionMenu(menuId: Int): List<Preparacion> {
            return listaPreparacion.filter { it.menuId.equals(menuId) }
        }
    }
}
