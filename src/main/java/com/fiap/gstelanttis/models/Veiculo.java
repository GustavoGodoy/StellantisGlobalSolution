package com.fiap.gstelanttis.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_veiculo")
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private String marca;
    @NotNull
    private String modelo;
    @NotNull
    private String placa;
    @NotNull
    private int quilometragem;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente;


}
