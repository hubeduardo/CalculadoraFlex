package br.com.ferreira.calculadoraflex.ui.utils

import com.google.firebase.database.FirebaseDatabase
class DatabaseUtil {
    companion object {
        private val firebaseDatabase: FirebaseDatabase =
            FirebaseDatabase.getInstance()
        init {
            firebaseDatabase.setPersistenceEnabled(true)
        }
        fun getDatabase() : FirebaseDatabase {
            return firebaseDatabase
        }
    }
}