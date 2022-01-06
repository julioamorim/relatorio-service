package io.github.julioamorim.repository

import com.mongodb.client.result.InsertOneResult
import com.mongodb.reactivestreams.client.MongoClient
import io.github.julioamorim.model.Venda
import jakarta.inject.Singleton
import org.reactivestreams.Publisher


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