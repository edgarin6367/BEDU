package org.bedu.java.backend.postwork.fase4.mappers;

import org.bedu.java.backend.postwork.fase4.model.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto productoModelToProductoEntity(Producto productoModel);

    Producto productoEntityToProductoModel(Producto producto);
}