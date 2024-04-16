package co.edu.eam.unilocal.actividades

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import co.edu.eam.unilocal.R

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        supportActionBar?.hide()


        val sharedPreferences = getSharedPreferences("sesion", Context.MODE_PRIVATE)

        val nombreUsuario = sharedPreferences.getString("nombre_usuario", "")
        val nicknameUsuario = sharedPreferences.getString("nickname_usuario", "")
        val correoUsuario = sharedPreferences.getString("correo_usuario", "")

        val nombreTextView = findViewById<TextView>(R.id.nombreUsuario)
        val nicknameTextView = findViewById<TextView>(R.id.nicknameUsuario)
        val correoTextView = findViewById<TextView>(R.id.correoUsuario)

        nombreTextView.text = nombreUsuario
        nicknameTextView.text = nicknameUsuario
        correoTextView.text = correoUsuario

        val editarPerfilButton = findViewById<View>(R.id.botonEditarPerfil)

        editarPerfilButton.setOnClickListener {
            val intent = Intent(this, EditarPerfilActivity::class.java)
            startActivity(intent)
        }
    }
}