package org.bedu.java.backend.postwork.fase4.persistence.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Table(name = "ETAPAS")
@Entity
@NoArgsConstructor
public class Etapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long etapaId;

    private String nombre;

    @Column(unique = true, nullable = false)
    private Integer orden;
}