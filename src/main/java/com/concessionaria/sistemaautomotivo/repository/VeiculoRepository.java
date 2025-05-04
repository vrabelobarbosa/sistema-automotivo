package com.concessionaria.sistemaautomotivo.repository;

import com.concessionaria.sistemaautomotivo.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}