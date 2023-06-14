package org.bedu.java.backend.postwork.fase4.mappers;

import org.bedu.java.backend.postwork.fase4.persistence.entities.Visita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitaMapper {
    Visita visitaModelToVisitaEntity(org.bedu.java.backend.postwork.fase4.model.Visita visitaModel);

    org.bedu.java.backend.postwork.fase4.model.Visita visitaEntityToVisitaModel(Visita visita);
}