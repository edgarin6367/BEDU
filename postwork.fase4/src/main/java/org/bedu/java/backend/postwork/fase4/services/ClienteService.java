package org.bedu.java.backend.postwork.fase4.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bedu.java.backend.postwork.fase4.mappers.ClienteMapper;
import org.bedu.java.backend.postwork.fase4.persistence.entities.Cliente;
import org.bedu.java.backend.postwork.fase4.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService {

    private   ClienteRepository repository;

    private  ClienteMapper mapper;


    public org.bedu.java.backend.postwork.fase4.model.Cliente guardaCliente(org.bedu.java.backend.postwork.fase4.model.Cliente cliente) {
        return mapper.clienteEntityToClienteModel(
                repository.save(mapper.clienteModelToClienteEntity(cliente))
        );
    }

    public List<org.bedu.java.backend.postwork.fase4.model.Cliente> obtenClientes(){
        return repository.findAll().stream().map(cliente -> mapper.clienteEntityToClienteModel(cliente)).collect(Collectors.toList());
    }

    public Optional<org.bedu.java.backend.postwork.fase4.model.Cliente> obtenCliente(long idCliente) {
        return repository.findById(idCliente)
                .map(cliente -> Optional.of(mapper.clienteEntityToClienteModel(cliente)))
                .orElse(Optional.empty());
    }

    public void eliminaCliente(long idcliente){
        repository.deleteById(idcliente);
    }

    public org.bedu.java.backend.postwork.fase4.model.Cliente actualizaCliente(org.bedu.java.backend.postwork.fase4.model.Cliente cliente){
        return mapper.clienteEntityToClienteModel(
                repository.save(mapper.clienteModelToClienteEntity(cliente))
        );
    }

    public long cuenteClientes(){
        return repository.count();
    }
}