package org.bedu.java.backend.postwork.fase4.mappers;

import lombok.AllArgsConstructor;
import org.bedu.java.backend.postwork.fase4.persistence.entities.Visita;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VisitaMapperImpl implements VisitaMapper{
    private ClienteMapper clienteMapper;
    @Override
    public Visita visitaModelToVisitaEntity(org.bedu.java.backend.postwork.fase4.model.Visita visitaModel) {
        if (visitaModel == null){
            return null;
        }
        Visita visita = new Visita();
        visita.setId(visitaModel.getId());
        visita.setDireccion(visitaModel.getDireccion());
        visita.setCliente(clienteMapper.clienteModelToClienteEntity(visitaModel.getCliente()));
        visita.setVendedor(visita.getVendedor());
        visita.setFechaProgramada(visitaModel.getFechaProgramada());
        visita.setProposito(visita.getProposito());

        return visita;
    }

    @Override
    public org.bedu.java.backend.postwork.fase4.model.Visita visitaEntityToVisitaModel(Visita visita) {
        if (visita == null){
            return null;
        }
        org.bedu.java.backend.postwork.fase4.model.Visita visitaModel = new org.bedu.java.backend.postwork.fase4.model.Visita();
        visitaModel.setId(visita.getId());
        visitaModel.setDireccion(visita.getDireccion());
        visitaModel.setCliente(clienteMapper.clienteEntityToClienteModel(visita.getCliente()));
        visitaModel.setVendedor(visita.getVendedor());
        visitaModel.setFechaProgramada(visita.getFechaProgramada());
        visitaModel.setProposito(visita.getProposito());
        return visitaModel;
    }
}
