package org.bedu.java.backend.postwork.fase4.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.postwork.fase4.mappers.ProductoMapper;
import org.bedu.java.backend.postwork.fase4.model.Producto;
import org.bedu.java.backend.postwork.fase4.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductoService {
    private  ProductoRepository repository;
    private  ProductoMapper mapper;

    public org.bedu.java.backend.postwork.fase4.model.Producto guardaProducto(org.bedu.java.backend.postwork.fase4.model.Producto producto) {
        return mapper.productoEntityToProductoModel(
                repository.save(mapper.productoModelToProductoEntity(producto))
        );
    }

    public List<Producto> obtenProductos(){
        return repository.findAll().stream().map(Producto -> mapper.productoEntityToProductoModel(Producto)).collect(Collectors.toList());
    }

    public Optional<org.bedu.java.backend.postwork.fase4.model.Producto> obtenProducto(long idProducto) {
        return repository.findById(idProducto)
                .map(producto -> Optional.of(mapper.productoEntityToProductoModel(producto)))
                .orElse(Optional.empty());
    }

    public void eliminaProducto(long idProducto){
        repository.deleteById(idProducto);
    }

    public org.bedu.java.backend.postwork.fase4.model.Producto actualizaProducto(org.bedu.java.backend.postwork.fase4.model.Producto producto){
        return mapper.productoEntityToProductoModel(
                repository.save(mapper.productoModelToProductoEntity(producto))
        );
    }

    public long cuenteProductos(){
        return repository.count();
    }
}