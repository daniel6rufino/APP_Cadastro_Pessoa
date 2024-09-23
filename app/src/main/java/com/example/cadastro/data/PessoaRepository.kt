package com.example.cadastro.data

import kotlinx.coroutines.flow.Flow

class PessoaRepository(private val pessoaDao: PessoaDao) {

    val todasAsPessoas: Flow<List<Pessoa>> = pessoaDao.getAllPessoas()

    suspend fun inserir(pessoa: Pessoa) {
        pessoaDao.insert(pessoa)
    }
}
