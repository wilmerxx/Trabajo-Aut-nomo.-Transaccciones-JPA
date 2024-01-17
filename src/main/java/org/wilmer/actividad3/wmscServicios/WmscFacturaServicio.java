package org.wilmer.actividad3.wmscServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wilmer.actividad3.WmscExcepciones.WmscRequestException;
import org.wilmer.actividad3.wmscModelos.WmscDetalleFactura;
import org.wilmer.actividad3.wmscModelos.WmscFactura;
import org.wilmer.actividad3.wmscRepositorios.WmscFacturaRepositorio;

import java.util.List;

@Service
@Transactional
public class WmscFacturaServicio {
    @Autowired
    private WmscFacturaRepositorio wmscFacturaRepositorio;
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<WmscFactura> listar() {
         //utilizar excepciones si no esta inicializado
       if ( wmscFacturaRepositorio.findAll().isEmpty() || wmscFacturaRepositorio.findAll() == null) {
           throw new WmscRequestException("p-233","No hay registros de facturas", HttpStatus.BAD_REQUEST);
       }
         return wmscFacturaRepositorio.findAll();
    }
    public WmscFactura crear(WmscFactura wmscFactura) {
        if (wmscFactura.getWmscDetalleFacturaList() == null) {
            throw new WmscRequestException("p-500","No se puede crear una factura sin detalles", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        List<WmscDetalleFactura> detalles = wmscFactura.getWmscDetalleFacturaList();
        detalles.forEach(detalle -> detalle.setWmscFactura(wmscFactura));
        wmscFactura.setWmscDetalleFacturaList(detalles);
        if (wmscFactura.getWmsc_nombre() == null) {
            throw new WmscRequestException("p-234","No se puede crear una factura sin un nombre", HttpStatus.BAD_REQUEST);
        }
        return wmscFacturaRepositorio.save(wmscFactura);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public WmscFactura actualizar(WmscFactura wmscFactura) {
        if (wmscFactura.getWmsc_nombre() == null) {
            throw new WmscRequestException("p-234","No se puede actualizar una factura sin un nombre", HttpStatus.BAD_REQUEST);
        }
        return wmscFacturaRepositorio.save(wmscFactura);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public void eliminar(Long id) {
        wmscFacturaRepositorio.deleteById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public WmscFactura buscarPorId(Long id) {
        return wmscFacturaRepositorio.findById(id).orElseThrow(() -> new WmscRequestException("p-234","No se encontró la factura con id: " + id, HttpStatus.BAD_REQUEST));
    }
}
