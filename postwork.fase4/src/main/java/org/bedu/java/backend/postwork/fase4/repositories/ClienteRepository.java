package org.bedu.java.backend.postwork.fase4.repositories;

import org.bedu.java.backend.postwork.fase4.persistence.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}