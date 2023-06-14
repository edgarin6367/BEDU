package org.bedu.java.backend.postwork.fase4.services;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.postwork.fase4.mappers.VentaMapper;
import org.bedu.java.backend.postwork.fase4.model.Venta;
import org.bedu.java.backend.postwork.fase4.repositories.VentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VentaService {
    private  VentaRepository repository;
    private  VentaMapper mapper;

    public org.bedu.java.backend.postwork.fase4.model.Venta guardaVenta(org.bedu.java.backend.postwork.fase4.model.Venta Venta) {
        return mapper.ventaEntityToVentaModel(
                repository.save(mapper.ventaModelToVentaEntity(Venta))
        );
    }

    public List<Venta> obtenVentas(){
        return repository.findAll().stream().map(venta -> mapper.ventaEntityToVentaModel(venta)).collect(Collectors.toList());
    }

    public Optional<org.bedu.java.backend.postwork.fase4.model.Venta> obtenVenta(long idVenta) {
        return repository.findById(idVenta)
                .map(venta -> Optional.of(mapper.ventaEntityToVentaModel(venta)))
                .orElse(Optional.empty());
    }

    public void eliminaVenta(long idVenta){
        repository.deleteById(idVenta);
    }

    public org.bedu.java.backend.postwork.fase4.model.Venta actualizaVenta(org.bedu.java.backend.postwork.fase4.model.Venta venta){
        return mapper.ventaEntityToVentaModel(
                repository.save(mapper.ventaModelToVentaEntity(venta))
        );
    }

    public long cuenteVentas(){
        return repository.count();
    }
}