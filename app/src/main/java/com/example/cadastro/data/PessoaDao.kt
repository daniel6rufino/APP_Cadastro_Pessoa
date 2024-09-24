package com.example.cadastro.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import com.example.cadastro.data.Pessoa

@Dao
interface PessoaDao {
    @Insert
    suspend fun insert(pessoa: Pessoa)

    @Query("SELECT * FROM pessoa")
    fun getAllPessoas(): Flow<List<Pessoa>>

    @Delete
    suspend fun delete(pessoa: Pessoa)

    @Update
    suspend fun update(pessoa: Pessoa)
}