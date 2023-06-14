package org.bedu.java.backend.postwork.fase4.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.postwork.fase4.mappers.VisitaMapper;
import org.bedu.java.backend.postwork.fase4.model.Visita;
import org.bedu.java.backend.postwork.fase4.repositories.VisitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VisitaService {
    private  VisitaRepository repository;
    private  VisitaMapper mapper;

    public org.bedu.java.backend.postwork.fase4.model.Visita guardaVisita(org.bedu.java.backend.postwork.fase4.model.Visita visita) {
        return mapper.visitaEntityToVisitaModel(
                repository.save(mapper.visitaModelToVisitaEntity(visita))
        );
    }

    public List<org.bedu.java.backend.postwork.fase4.model.Visita> obtenVisitas(){
        return repository.findAll().stream().map(visita -> mapper.visitaEntityToVisitaModel(visita)).collect(Collectors.toList());
    }

    public Optional<org.bedu.java.backend.postwork.fase4.model.Visita> obtenVisita(long idVisita) {
        return repository.findById(idVisita)
                .map(visita -> Optional.of(mapper.visitaEntityToVisitaModel(visita)))
                .orElse(Optional.empty());
    }

    public void eliminaVisita(long idVisita){
        repository.deleteById(idVisita);
    }

    public org.bedu.java.backend.postwork.fase4.model.Visita actualizaVisita(org.bedu.java.backend.postwork.fase4.model.Visita visita){
        return mapper.visitaEntityToVisitaModel(
                repository.save(mapper.visitaModelToVisitaEntity(visita))
        );
    }

    public long cuenteVisitas(){
        return repository.count();
    }
}