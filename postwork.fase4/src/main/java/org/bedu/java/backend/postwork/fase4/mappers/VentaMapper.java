package org.bedu.java.backend.postwork.fase4.mappers;

import org.bedu.java.backend.postwork.fase4.model.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    Venta ventaModelToVentaEntity(Venta ventaModel);

    Venta ventaEntityToVentaModel(Venta venta);
}