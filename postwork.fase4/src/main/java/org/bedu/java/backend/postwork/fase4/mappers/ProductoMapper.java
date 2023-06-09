package org.bedu.java.backend.postwork.fase4.mappers;

import org.bedu.java.backend.postwork.fase4.persistence.entities.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto productoModelToProductoEntity(org.bedu.java.backend.postwork.fase4.model.Producto productoModel);

    org.bedu.java.backend.postwork.fase4.model.Producto productoEntityToProductoModel(Producto producto);
}