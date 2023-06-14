package org.bedu.java.backend.postwork.fase4.mappers;

import org.bedu.java.backend.postwork.fase4.persistence.entities.Etapa;
import org.springframework.stereotype.Component;

@Component
public class EtapaMapperImpl implements EtapaMapper{
    @Override
    public Etapa etapaModelToEtapaEntity(org.bedu.java.backend.postwork.fase4.model.Etapa etapaModel) {
        if (etapaModel == null){
            return null;
        }

        Etapa etapaDb = new Etapa();
        etapaDb.setEtapaId(etapaModel.getEtapaId());
        etapaDb.setNombre(etapaModel.getNombre());
        etapaDb.setOrden(etapaModel.getOrden());

        return etapaDb;
    }

    @Override
    public org.bedu.java.backend.postwork.fase4.model.Etapa etapaEntityToEtapaModel(Etapa etapa) {
        if (etapa == null){
        return null;
        }
        org.bedu.java.backend.postwork.fase4.model.Etapa etapaModel = new org.bedu.java.backend.postwork.fase4.model.Etapa();
        etapaModel.setEtapaId(etapa.getEtapaId());
        etapaModel.setNombre(etapa.getNombre());
        etapaModel.setOrden(etapa.getOrden());
        return etapaModel;
    }
}
