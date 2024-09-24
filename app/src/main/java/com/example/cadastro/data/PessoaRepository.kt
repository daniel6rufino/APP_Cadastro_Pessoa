package com.example.cadastro.data

import com.example.cadastro.data.Pessoa
import com.example.cadastro.data.PessoaDao
import kotlinx.coroutines.flow.Flow

class PessoaRepository(private val pessoaDao: PessoaDao) {

    val todasAsPessoas: Flow<List<Pessoa>> = pessoaDao.getAllPessoas()

    suspend fun inserir(pessoa: Pessoa) {
        pessoaDao.insert(pessoa)
    }

    suspend fun deletar(pessoa: Pessoa) {
        pessoaDao.delete(pessoa)
    }

    suspend fun atualizar(pessoa: Pessoa) {
        pessoaDao.update(pessoa)
    }
}
