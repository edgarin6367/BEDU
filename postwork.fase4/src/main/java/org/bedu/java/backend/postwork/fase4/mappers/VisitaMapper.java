package org.bedu.java.backend.postwork.fase4.mappers;

import org.bedu.java.backend.postwork.fase4.model.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(Visita visitaModel);

    Visita visitaEntityToVisitaModel(Visita visita);
}