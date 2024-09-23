package com.example.cadastro.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CadastroPessoaScreen(viewModel: PessoaViewModel) {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") }
        )
        TextField(
            value = idade,
            onValueChange = { idade = it },
            label = { Text("Idade") },  
        )
        TextField(
            value = cpf,
            onValueChange = { cpf = it },
            label = { Text("CPF") }
        )
        Button(
            onClick = {
                if (nome.isNotEmpty() && idade.isNotEmpty() && cpf.isNotEmpty()) {
                    viewModel.inserirPessoa(nome, idade.toInt(), cpf)
                }
            }
        ) {
            Text("Cadastrar Pessoa")
        }

        // Mostrar a lista de pessoas cadastradas
        val pessoas by viewModel.todasAsPessoas.collectAsState(initial = emptyList())
        LazyColumn {
            items(pessoas) { pessoa ->
                Text("Nome: ${pessoa.nome}, Idade: ${pessoa.idade}, CPF: ${pessoa.cpf}")
            }
        }
    }
}
