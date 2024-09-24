package com.example.cadastro.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cadastro.data.Pessoa
import com.example.cadastro.data.PessoaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PessoaViewModel(private val repository: PessoaRepository) : ViewModel() {

    val todasAsPessoas = repository.todasAsPessoas

    fun inserirPessoa(nome: String, idade: Int, cpf: String) {
        val pessoa = Pessoa(nome = nome, idade = idade, cpf = cpf)
        viewModelScope.launch {
            repository.inserir(pessoa)
        }
    }

    fun deletarPessoa(pessoa: Pessoa) {
        viewModelScope.launch {
            repository.deletar(pessoa)
        }
    }

    fun atualizarPessoa(pessoa: Pessoa) {
        viewModelScope.launch {
            repository.atualizar(pessoa)
        }
    }
}
