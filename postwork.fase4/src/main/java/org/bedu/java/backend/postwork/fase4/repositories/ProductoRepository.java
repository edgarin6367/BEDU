package org.bedu.java.backend.postwork.fase4.repositories;

import org.bedu.java.backend.postwork.fase4.persistence.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}