package org.bedu.java.backend.postwork.fase4.mappers;

import org.bedu.java.backend.postwork.fase4.persistence.entities.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapperImpl implements ProductoMapper{
    @Override
    public Producto productoModelToProductoEntity(org.bedu.java.backend.postwork.fase4.model.Producto productoModel) {
        if (productoModel == null){
            return null;
        }
        Producto producto = new Producto();
        producto.setId(productoModel.getId());
        producto.setCategoria(productoModel.getCategoria());
        producto.setPrecio(productoModel.getPrecio());
        producto.setFechaCreacion(productoModel.getFechaCreacion());
        producto.setNumeroRegistro(productoModel.getNumeroRegistro());
        producto.setNombre(productoModel.getNombre());
        return producto;
    }

    @Override
    public org.bedu.java.backend.postwork.fase4.model.Producto productoEntityToProductoModel(Producto producto) {
        if (producto == null){
            return null;
        }
        org.bedu.java.backend.postwork.fase4.model.Producto prodModel = org.bedu.java.backend.postwork.fase4.model.Producto.builder().build();
        prodModel.setId(producto.getId());
        prodModel.setCategoria(producto.getCategoria());
        prodModel.setPrecio(producto.getPrecio());
        prodModel.setFechaCreacion(producto.getFechaCreacion());
        prodModel.setNumeroRegistro(producto.getNumeroRegistro());
        prodModel.setNombre(producto.getNombre());
        return prodModel;
    }
}
