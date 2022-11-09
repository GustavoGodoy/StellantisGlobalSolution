package com.fiap.gstelanttis.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_ambiente")
public class Ambiente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private String bairro;
    @NotNull
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String temperatura;
    @NotNull
    @Column(name = "qualidade_ar")
    @JsonProperty(namespace = "qualidade_ar")
    private String qualidadeAr;
}
