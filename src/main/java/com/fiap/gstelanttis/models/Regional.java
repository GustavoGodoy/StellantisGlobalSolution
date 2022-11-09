package com.fiap.gstelanttis.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_regional")
public class Regional {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate data;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "veiculos_id")
    private List<Veiculo> veiculos;

    public Regional (List<Veiculo> veiculo){
        this.data = LocalDate.now();
        this.veiculos = veiculo;
    }
}
