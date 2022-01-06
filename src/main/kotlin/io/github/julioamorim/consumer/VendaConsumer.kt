package io.github.julioamorim.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.julioamorim.model.Venda
import io.github.julioamorim.service.VendaService
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.http.annotation.Body

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class VendaConsumer(
    private val objectMapper: ObjectMapper,
    private val vendaService: VendaService
) {

    @Topic("msvendas")
    fun receberVenda(@KafkaKey id: String, vendaJSON: String) {
        val venda = objectMapper.readValue(vendaJSON, Venda::class.java)
        vendaService.create(venda)
        println(venda)
    }
}