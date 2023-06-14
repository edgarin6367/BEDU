package org.bedu.java.backend.postwork.fase4.mappers;

import org.bedu.java.backend.postwork.fase4.persistence.entities.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapperImpl implements ClienteMapper{
    @Override
    public Cliente clienteModelToClienteEntity(org.bedu.java.backend.postwork.fase4.model.Cliente clienteModel) {
        if(clienteModel == null){
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setId(clienteModel.getId());
        cliente.setDireccion(clienteModel.getDireccion());
        cliente.setNombre(clienteModel.getNombre());
        cliente.setCorreoContacto(clienteModel.getCorreoContacto());
        cliente.setNumeroEmpleados(clienteModel.getNumeroEmpleados());

        return cliente;
    }

    @Override
    public org.bedu.java.backend.postwork.fase4.model.Cliente clienteEntityToClienteModel(Cliente cliente) {
        if(cliente == null){
            return null;
        }
        org.bedu.java.backend.postwork.fase4.model.Cliente clienteModel = new org.bedu.java.backend.postwork.fase4.model.Cliente();
        clienteModel.setId(cliente.getId());
        clienteModel.setDireccion(cliente.getDireccion());
        clienteModel.setNombre(cliente.getNombre());
        clienteModel.setCorreoContacto(cliente.getCorreoContacto());
        clienteModel.setNumeroEmpleados(cliente.getNumeroEmpleados());

        return clienteModel;
    }
}
