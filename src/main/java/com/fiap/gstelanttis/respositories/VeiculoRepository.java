package com.fiap.gstelanttis.respositories;

import com.fiap.gstelanttis.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}