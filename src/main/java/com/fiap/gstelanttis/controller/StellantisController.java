package com.fiap.gstelanttis.controller;

import com.fiap.gstelanttis.models.Veiculo;
import com.fiap.gstelanttis.respositories.RegionalRepository;
import com.fiap.gstelanttis.respositories.VeiculoRepository;
import com.fiap.gstelanttis.service.IStellantisService;
import com.fiap.gstelanttis.service.StellantisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(path = "api/")
@CrossOrigin(allowedHeaders = "*")
public class StellantisController {

    @Autowired
    private StellantisService stellantisService;

    @Autowired
    private RegionalRepository repository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping(path = "/veiculo")
    public ResponseEntity getAllVeiculos(){
        return ResponseEntity.ok(veiculoRepository.findAll());
    }
    @GetMapping(path = "/veiculo/{id}")
    public ResponseEntity getVeiculoById(@PathVariable Long id){
        return veiculoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/regional")
    public ResponseEntity getAllRegionais(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping(path = "/veiculo")
    public ResponseEntity postVeiculo(@RequestBody Veiculo veiculo){
        return ResponseEntity.status(HttpStatus.CREATED).body(stellantisService.saveVeiculo(veiculo));
    }
    @PutMapping(path = "/veiculo/{id}")
    public ResponseEntity updateVeiculo(@RequestBody Veiculo veiculo){
        return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.save(veiculo));
    }

    @DeleteMapping(path = "/veiculo/{id}")
    public ResponseEntity deleteVeiculo(@PathVariable long id){
        veiculoRepository.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}