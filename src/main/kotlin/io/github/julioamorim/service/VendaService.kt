package io.github.julioamorim.service

import io.github.julioamorim.model.Venda
import io.github.julioamorim.repository.VendaRepository
import jakarta.inject.Singleton

@Singleton
class VendaService(
    private val vendaRepository: VendaRepository
) {
    
    fun create(venda: Venda) {
        vendaRepository.create(venda)
    }
}