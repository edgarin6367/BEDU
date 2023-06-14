package org.bedu.java.backend.postwork.fase4.mappers;

import org.bedu.java.backend.postwork.fase4.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente clienteModelToClienteEntity(Cliente clienteModel);

    Cliente clienteEntityToClienteModel(Cliente cliente);
}
