package io.github.julioamorim.repository

import com.mongodb.client.MongoClient

import io.github.julioamorim.model.Venda
import jakarta.inject.Singleton


@Singleton
class VendaRepository(
    private val mongoClient: MongoClient
) {

    fun create(venda: Venda) {
        getConnection().insertOne(venda)
    }

    fun getConnection() = mongoClient
        .getDatabase("vendas")
        .getCollection("venda", Venda::class.java)

}