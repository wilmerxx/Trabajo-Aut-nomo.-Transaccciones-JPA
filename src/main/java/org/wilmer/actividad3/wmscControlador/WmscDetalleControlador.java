package org.wilmer.actividad3.wmscControlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wilmer.actividad3.WmscExcepciones.WmscRequestException;
import org.wilmer.actividad3.wmscModelos.WmscDetalleFactura;
import org.wilmer.actividad3.wmscModelos.WmscError;
import org.wilmer.actividad3.wmscServicios.WmscDetalleServicio;

import java.util.List;
@RestController
@RequestMapping("/api/v1/detalle")
public class WmscDetalleControlador {
    @Autowired
    private WmscDetalleServicio wmscDetalleServicio;
    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<WmscDetalleFactura> wmscDetalleFacturas = wmscDetalleServicio.listar();
            return new ResponseEntity<>(wmscDetalleFacturas, HttpStatus.OK);
        } catch (WmscRequestException e) {
            return ResponseEntity.status(e.getStatus()).body(new WmscError(e.getCode(), e.getMessage()));
        }
    }
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody WmscDetalleFactura wmscDetalleFacturas) {
       try {
           WmscDetalleFactura wmscDetalleFacturas1 = wmscDetalleServicio.crear(wmscDetalleFacturas);
           return new ResponseEntity<>(wmscDetalleFacturas1, HttpStatus.CREATED);
       } catch (WmscRequestException e) {
            return ResponseEntity.status(e.getStatus()).body(new WmscError(e.getCode(), e.getMessage()));
       }
    }
    @PutMapping
    public ResponseEntity<?> actualizar(@RequestBody WmscDetalleFactura wmscDetalleFacturas) {
        try {
            WmscDetalleFactura wmscDetalleFacturas1 = wmscDetalleServicio.actualizar(wmscDetalleFacturas);
            return new ResponseEntity<>(wmscDetalleFacturas1, HttpStatus.OK);
        } catch (WmscRequestException e) {
           return ResponseEntity.status(e.getStatus()).body(new WmscError(e.getCode(), e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id) {
        try {
            wmscDetalleServicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (WmscRequestException e) {
            return ResponseEntity.status(e.getStatus()).body(new WmscError(e.getCode(), e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {
        try {
            WmscDetalleFactura wmscDetalleFacturas = wmscDetalleServicio.buscarPorId(id);
            return new ResponseEntity<>(wmscDetalleFacturas, HttpStatus.OK);
        } catch (WmscRequestException e) {
            return ResponseEntity.status(e.getStatus()).body(new WmscError(e.getCode(), e.getMessage()));
        }
    }
}
