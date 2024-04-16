package co.edu.eam.unilocal.actividades

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import co.edu.eam.unilocal.R
import co.edu.eam.unilocal.databinding.ActivityAdministradorBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class AdministradorActivity : AppCompatActivity(), OnNavigationItemSelectedListener {

    lateinit var binding:ActivityAdministradorBinding
    private lateinit var sh: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAdministradorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.button2.setOnClickListener{
            confirmLogout();
        }
    }
    private fun confirmLogout() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmar Cierre de Sesión")
        builder.setMessage("¿Estás seguro de que deseas cerrar sesión?")
        builder.setPositiveButton("Sí") { dialog, which ->
            cerrarSesion()
        }
        builder.setNegativeButton("Cancelar") { dialog, which ->
        }

        val dialog = builder.create()
        dialog.show()
    }
    fun cerrarSesion(){
        val spe = sh.edit()
        spe.clear()
        spe.commit()
        finish()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_cerrar_sesion -> confirmLogout()
        }

        item.isChecked = true

        return true

    }
}