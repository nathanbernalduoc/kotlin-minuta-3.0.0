package com.nathanbernal.minutanutricional.models

import androidx.recyclerview.widget.ListAdapter

data class Usuarios (
    val usuarioId: Int,
    val email:String,
    val password:String,
    val nombre:String) {

    companion object {
        private val usuarioList = mutableListOf<Usuarios>()

        fun addUsuario(usuario: Usuarios) {
            usuarioList.add(usuario)
        }

        fun getUusarioList(): List<Usuarios> {
            return usuarioList
        }

        fun getUsuarioId(usuarioId: Int): Usuarios? {
            return usuarioList.find { it.usuarioId.equals(usuarioId) }
        }

        fun getUsuario(email: String): Usuarios? {
            return usuarioList.find { it.email.equals(email.trim()) }
        }

    }
}