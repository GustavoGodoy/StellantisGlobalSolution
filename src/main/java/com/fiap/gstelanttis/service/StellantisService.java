package com.fiap.gstelanttis.service;


import com.fiap.gstelanttis.models.Regional;
import com.fiap.gstelanttis.models.Veiculo;
import com.fiap.gstelanttis.respositories.RegionalRepository;
import com.fiap.gstelanttis.respositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StellantisService implements IStellantisService {

    @Autowired
    public RegionalRepository _regionalRepo;
    @Autowired
    public VeiculoRepository _veiculoRepo;

    public ResponseEntity saveVeiculo(Veiculo veiculo){
        try {
            Regional regional = new Regional();
            regional.setData(LocalDate.now());
            List<Veiculo> veiculos = new ArrayList<>();
            veiculos.add(_veiculoRepo.save(veiculo));
            regional.setVeiculos(veiculos);
            _regionalRepo.save(regional);
            return ResponseEntity.ok(veiculo.toString() + regional.toString());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
