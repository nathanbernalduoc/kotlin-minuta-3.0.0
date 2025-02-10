package com.nathanbernal.minutanutricional

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import com.airbnb.lottie.LottieAnimationView
import com.nathanbernal.minutanutricional.models.Usuarios
import java.util.regex.Matcher

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val mp = MediaPlayer.create(this, R.raw.riser_intro)
        val btn = findViewById<Button>(R.id.btnIniciar)
        val btnRegistro = findViewById<Button>(R.id.btnNuevo)
        val btnRecordar = findViewById<Button>(R.id.btnRecordar)

        btnRegistro.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnRecordar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnRecordar.setOnClickListener {
            startActivity(Intent(this, RecoverActivity::class.java))
        }

        btn.setOnClickListener {
            val email = findViewById<EditText>(R.id.loginEmail)
            val pass = findViewById<EditText>(R.id.loginPassword)

            if (!checkMail(email.text.toString())) {
                Toast.makeText(this, "El email proporcionado es incorrecto..", Toast.LENGTH_SHORT).show()
            } else if (!checkLogin(email.text.toString(), pass.text.toString())) {
                Toast.makeText(this, "Las credenciales proporcionadas no son válidas.", Toast.LENGTH_SHORT).show()
            } else {
                mp.start()
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }

        val animationView = findViewById<LottieAnimationView>(R.id.intro_img)
        animationView.resumeAnimation()

        var usuario: Usuarios = Usuarios(1, "nathanbernal@gmail.com", "123", "Nathan Bernal")
        Usuarios.addUsuario(usuario)

        // INSERCIÓN INICIAL DE DATOS

        /*
        val servidorMinuta = ServidorMinuta()
        val dataMenu =servidorMinuta.crearDatoMenu()
        servidorMinuta.enviarDatosMenu(dataMenu)
        */

    }

    fun checkLogin(email:String, pass:String): Boolean {

        if (email.isBlank() || email.isEmpty() || pass.isBlank() || pass.isEmpty()) {
            return false
        } else {
            val user = Usuarios.getUsuario(email.trim())
            if (user != null && user.password.equals(pass)) {
                return true
            } else {
                return false
            }
        }

    }

    fun checkMail(email: String): Boolean {
        var pat:java.util.regex.Pattern = java.util.regex.Pattern.compile("[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}")
        var compare:Matcher = pat.matcher(email)
        return compare.find()
    }

}