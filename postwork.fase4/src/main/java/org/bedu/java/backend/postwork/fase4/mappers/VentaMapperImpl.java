package org.bedu.java.backend.postwork.fase4.mappers;

import lombok.AllArgsConstructor;
import org.bedu.java.backend.postwork.fase4.persistence.entities.Venta;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class VentaMapperImpl implements VentaMapper{
    private ClienteMapper clienteMapper;
    private ProductoMapper productoMapper;
    @Override
    public Venta ventaModelToVentaEntity(org.bedu.java.backend.postwork.fase4.model.Venta ventaModel) {
        if (ventaModel == null){
            return null;
        }
        Venta ventaDb = new Venta();
        ventaDb.setVentaId(ventaModel.getVentaId());
        ventaDb.setCliente(clienteMapper.clienteModelToClienteEntity(ventaModel.getCliente()));
        ventaDb.setProductos(ventaModel.getProductos().stream().map(producto -> productoMapper.productoModelToProductoEntity(producto)).collect(Collectors.toList()));
        ventaDb.setFechaCreacion(ventaModel.getFechaCreacion());
        ventaDb.setMonto(ventaModel.getMonto());

        return ventaDb;
    }

    @Override
    public org.bedu.java.backend.postwork.fase4.model.Venta ventaEntityToVentaModel(Venta venta) {
        if (venta == null){
            return null;
        }
        org.bedu.java.backend.postwork.fase4.model.Venta ventaModel = new org.bedu.java.backend.postwork.fase4.model.Venta();
        ventaModel.setVentaId(venta.getVentaId());
        ventaModel.setCliente(clienteMapper.clienteEntityToClienteModel(venta.getCliente()));
        ventaModel.setProductos(venta.getProductos().stream().map(producto -> productoMapper.productoEntityToProductoModel(producto)).collect(Collectors.toList()));
        ventaModel.setMonto(venta.getMonto());
        ventaModel.setFechaCreacion(venta.getFechaCreacion());
        return ventaModel;
    }
}
