package com.fiap.gstelanttis.service;

import com.fiap.gstelanttis.models.Veiculo;
import com.fiap.gstelanttis.respositories.RegionalRepository;
import com.fiap.gstelanttis.respositories.VeiculoRepository;
import org.springframework.http.ResponseEntity;

public interface IStellantisService {

    public ResponseEntity saveVeiculo(Veiculo veiculo);
}
