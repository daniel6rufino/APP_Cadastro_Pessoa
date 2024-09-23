package com.example.cadastro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.cadastro.ui.theme.CadastroTheme
import com.example.cadastro.ui.CadastroPessoaScreen
import com.example.cadastro.ui.PessoaViewModel
import com.example.cadastro.ui.PessoaViewModelFactory
import com.example.cadastro.data.PessoaDatabase
import com.example.cadastro.data.PessoaRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            PessoaDatabase::class.java, "pessoa-database"
        ).build()

        val pessoaDao = db.pessoaDao()
        val repository = PessoaRepository(pessoaDao)
        val viewModel = ViewModelProvider(this, PessoaViewModelFactory(repository)).get(PessoaViewModel::class.java)

        setContent {
            CadastroTheme {
                CadastroPessoaScreen(viewModel = viewModel)
            }
        }
    }
}
