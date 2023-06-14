package org.bedu.java.backend.postwork.fase4.mappers;

import org.bedu.java.backend.postwork.fase4.persistence.entities.Venta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    Venta ventaModelToVentaEntity(org.bedu.java.backend.postwork.fase4.model.Venta ventaModel);

    org.bedu.java.backend.postwork.fase4.model.Venta ventaEntityToVentaModel(Venta venta);
}