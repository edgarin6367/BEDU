package org.bedu.java.backend.postwork.fase4.mappers;

import org.bedu.java.backend.postwork.fase4.persistence.entities.Cliente;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;




@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente clienteModelToClienteEntity(org.bedu.java.backend.postwork.fase4.model.Cliente clienteModel);

    org.bedu.java.backend.postwork.fase4.model.Cliente clienteEntityToClienteModel(Cliente cliente);
}