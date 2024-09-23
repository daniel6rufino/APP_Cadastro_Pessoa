package com.example.cadastro.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pessoa")
data class Pessoa(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val idade: Int,
    val cpf: String
) 