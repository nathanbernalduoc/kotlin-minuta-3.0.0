package com.nathanbernal.minutanutricional.models

class Ingrediente (val ingredienteId:Int, val menuId:Int, val ingrediente:String) {

    companion object {
        private val listaIngredientes = mutableListOf<Ingrediente>()

        fun addIngrediente(ingrediente: Ingrediente) {
            listaIngredientes.add(ingrediente)
        }

        fun getIngrediente(ingredienteId: Int): Ingrediente? {
            return listaIngredientes.find { it.ingredienteId.equals(ingredienteId) }
        }
        fun getIngredienteMenu(menuId: Int): List<Ingrediente> {
            return listaIngredientes.filter { it.menuId.equals(menuId)}
        }
    }

}