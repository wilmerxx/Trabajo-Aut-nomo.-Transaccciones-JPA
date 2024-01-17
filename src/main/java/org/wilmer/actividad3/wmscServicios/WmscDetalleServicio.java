package org.wilmer.actividad3.wmscServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wilmer.actividad3.WmscExcepciones.WmscRequestException;
import org.wilmer.actividad3.wmscModelos.WmscDetalleFactura;
import org.wilmer.actividad3.wmscModelos.WmscFactura;
import org.wilmer.actividad3.wmscRepositorios.WmscDetalleRepositorio;

import java.util.List;

@Service
@Transactional
public class WmscDetalleServicio {

    @Autowired
    private WmscDetalleRepositorio wmscDetalleRepositorio;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<WmscDetalleFactura> listar() {
        if (wmscDetalleRepositorio.findAll().isEmpty()) {
            throw new WmscRequestException("p-233","No hay registros de detalles de factura", HttpStatus.BAD_REQUEST);
        }
        return wmscDetalleRepositorio.findAll();
    }
    @Transactional(propagation = Propagation.NESTED, readOnly = true)
    public WmscDetalleFactura crear(WmscDetalleFactura wmscDetalleFactura) {
        if(wmscDetalleFactura.getWmscFactura() == null) {
            throw new WmscRequestException("p-234","No se puede crear un detalle de factura sin una factura", HttpStatus.BAD_REQUEST);
        }
        if (wmscDetalleFactura.getWmsc_Producto_nombre() == null) {
            throw new WmscRequestException("p-234","No se puede crear un detalle de factura sin un producto", HttpStatus.BAD_REQUEST);
        }
        return wmscDetalleRepositorio.save(wmscDetalleFactura);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public WmscDetalleFactura actualizar(WmscDetalleFactura wmscDetalleFactura) {
        if (wmscDetalleFactura.getWmscFactura() == null) {
            throw new WmscRequestException("p-234","No se puede actualizar un detalle de factura sin una factura", HttpStatus.BAD_REQUEST);
        }
        if (wmscDetalleFactura.getWmsc_Producto_nombre() == null) {
            throw new WmscRequestException("p-234","No se puede actualizar un detalle de factura sin un producto", HttpStatus.BAD_REQUEST);
        }
        return wmscDetalleRepositorio.save(wmscDetalleFactura);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public void eliminar(Long id) {
        wmscDetalleRepositorio.deleteById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public WmscDetalleFactura buscarPorId(Long id) {
        return wmscDetalleRepositorio.findById(id).orElseThrow(() -> new WmscRequestException("p-234","No se encontró el detalle de factura con id: " + id, HttpStatus.BAD_REQUEST));
    }

}
