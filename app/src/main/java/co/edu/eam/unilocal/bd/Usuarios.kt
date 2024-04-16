package co.edu.eam.unilocal.bd

import co.edu.eam.unilocal.modelo.Usuario

object Usuarios {

    private val lista:ArrayList<Usuario> = ArrayList()

    init {

        lista.add( Usuario(1, "Julian", "julian21", "julian21@email.com", "1234") )
        lista.add( Usuario(2, "Andres", "andresM", "andres@email.com", "1234") )
        lista.add( Usuario(3, "Michelle", "MichelleP", "Michelle@email.com", "1234") )

    }

    fun listar():ArrayList<Usuario>{
        return lista
    }

    fun agregar(usuario: Usuario){
        lista.add(usuario)
    }

    fun obtener(id:Int): Usuario?{
        return lista.firstOrNull { u -> u.id == id }
    }


}