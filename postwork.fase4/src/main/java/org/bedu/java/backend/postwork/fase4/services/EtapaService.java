package org.bedu.java.backend.postwork.fase4.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.postwork.fase4.mappers.EtapaMapper;
import org.bedu.java.backend.postwork.fase4.model.Etapa;
import org.bedu.java.backend.postwork.fase4.repositories.EtapaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EtapaService {
    private  EtapaRepository repository;
    private  EtapaMapper mapper;

    public org.bedu.java.backend.postwork.fase4.model.Etapa guardaEtapa(org.bedu.java.backend.postwork.fase4.model.Etapa etapa) {
        return mapper.etapaEntityToEtapaModel(
                repository.save(mapper.etapaModelToEtapaEntity(etapa))
        );
    }

    public List<org.bedu.java.backend.postwork.fase4.model.Etapa> obtenEtapas(){
        return repository.findAll().stream().map(etapa -> mapper.etapaEntityToEtapaModel(etapa)).collect(Collectors.toList());
    }

    public Optional<org.bedu.java.backend.postwork.fase4.model.Etapa> obtenEtapa(long idEtapa) {
        return repository.findById(idEtapa)
                .map(etapa -> Optional.of(mapper.etapaEntityToEtapaModel(etapa)))
                .orElse(Optional.empty());
    }

    public void eliminaEtapa(long idEtapa){
        repository.deleteById(idEtapa);
    }

    public org.bedu.java.backend.postwork.fase4.model.Etapa actualizaEtapa(org.bedu.java.backend.postwork.fase4.model.Etapa etapa){
        return mapper.etapaEntityToEtapaModel(
                repository.save(mapper.etapaModelToEtapaEntity(etapa))
        );
    }

    public long cuenteEtapas(){
        return repository.count();
    }
}