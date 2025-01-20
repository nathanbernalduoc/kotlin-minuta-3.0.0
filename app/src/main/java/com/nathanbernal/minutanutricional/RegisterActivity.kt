package com.nathanbernal.minutanutricional

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.nathanbernal.minutanutricional.models.Usuarios
import kotlin.system.exitProcess

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val btn = findViewById<Button>(R.id.btnRegistrar)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        btnVolver.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))

        }

        btnRegistrar.setOnClickListener {

            val email = findViewById<EditText>(R.id.loginEmail)
            val password = findViewById<EditText>(R.id.loginPassword)
            val nombre = findViewById<EditText>(R.id.loginNombre)

            val loginForm = LoginActivity()
            if (!loginForm.checkMail(email.text.toString())) {

                Toast.makeText(this, "El email proporcionado es incorecto.", Toast.LENGTH_SHORT).show()

            } else if (email.equals("") || password.equals("") || nombre.equals("")) {

                Toast.makeText(this, "Para proceder todos los datos son obligatorios.", Toast.LENGTH_SHORT).show()
                finish()

            } else {

                var cantidad = Usuarios.getUusarioList().count()
                var usuario = Usuarios(
                    cantidad,
                    email.text.toString(),
                    password.text.toString(),
                    nombre.text.toString()
                )

                Usuarios.addUsuario(usuario)
                System.out.println(Usuarios)
                Toast.makeText(this, "Se ha almacenado el nuevo usuario.", Toast.LENGTH_SHORT)
                    .show()
                startActivity(Intent(this, LoginActivity::class.java))

            }
        }

    }
}