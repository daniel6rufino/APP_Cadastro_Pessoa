package com.example.cadastro

import android.app.Application
import com.example.cadastro.data.AppDatabase

class CadastroApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
