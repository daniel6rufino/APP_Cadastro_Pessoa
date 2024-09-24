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
import com.example.cadastro.ui.PessoaViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import com.example.cadastro.data.Pessoa

@Composable
fun CadastroPessoaScreen(viewModel: PessoaViewModel) {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var pessoaSelecionada: Pessoa? by remember { mutableStateOf(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") }
        )
        TextField(
            value = idade,
            onValueChange = { idade = it },
            label = { Text("Idade") }
        )
        TextField(
            value = cpf,
            onValueChange = { cpf = it },
            label = { Text("CPF") }
        )
        
        Button(
            onClick = {
                if (nome.isNotEmpty() && idade.isNotEmpty() && cpf.isNotEmpty()) {
                    if (pessoaSelecionada == null) {
                        
                        viewModel.inserirPessoa(nome, idade.toInt(), cpf)
                    } else {
                        
                        val pessoaAtualizada = pessoaSelecionada!!.copy(nome = nome, idade = idade.toInt(), cpf = cpf)
                        viewModel.atualizarPessoa(pessoaAtualizada)
                        pessoaSelecionada = null
                    }

                    nome = ""
                    idade = ""
                    cpf = ""
                }
            }
        ) {
            Text(if (pessoaSelecionada == null) "Cadastrar Pessoa" else "Atualizar Pessoa")
        }

        // Mostrar a lista de pessoas cadastradas
        val pessoas by viewModel.todasAsPessoas.collectAsState(initial = emptyList())
        LazyColumn {
            items(pessoas) { pessoa ->
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("Nome: ${pessoa.nome}, Idade: ${pessoa.idade}, CPF: ${pessoa.cpf}")
                    
                    Button(onClick = { viewModel.deletarPessoa(pessoa) }) {
                        Text("Deletar")
                    }
                    
                    Button(onClick = {
                        nome = pessoa.nome
                        idade = pessoa.idade.toString()
                        cpf = pessoa.cpf
                        pessoaSelecionada = pessoa
                    }) {
                        Text("Editar")
                    }
                }
            }
        }
    }
}
