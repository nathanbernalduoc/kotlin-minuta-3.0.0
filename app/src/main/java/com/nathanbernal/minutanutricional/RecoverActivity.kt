package com.nathanbernal.minutanutricional

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.nathanbernal.minutanutricional.models.Usuarios

class RecoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recover)

        val btnRecuperar = findViewById<Button>(R.id.btnRecuperar)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnRecuperar.setOnClickListener {

            val email = findViewById<EditText>(R.id.loginEmail)
            val loginForm = LoginActivity()

            if (!loginForm.checkMail(email.text.toString())) {
                Toast.makeText(this, "El email proporcionado es incorecto.", Toast.LENGTH_SHORT).show()
            } else if (email.text.isEmpty() || email.text.isBlank()) {
                Toast.makeText(this, "Para proceder con la recuperación se requiere un mail de usuario", Toast.LENGTH_SHORT).show()
            } else {
                var usuario = Usuarios.getUsuario(email.text.toString());
                if (usuario.equals()) {
                    Toast.makeText(this, "Su contraseña es " + usuario.password, Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                } else {
                    Toast.makeText(this, "El usuario " + email.text.toString(), Toast.LENGTH_SHORT).show()
                }


            }
        }

        btnVolver.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }

}