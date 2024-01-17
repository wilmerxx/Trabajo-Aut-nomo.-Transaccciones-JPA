package org.wilmer.actividad3.wmscControlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wilmer.actividad3.WmscExcepciones.WmscBusinessException;
import org.wilmer.actividad3.WmscExcepciones.WmscRequestException;
import org.wilmer.actividad3.wmscModelos.WmscError;
import org.wilmer.actividad3.wmscModelos.WmscFactura;
import org.wilmer.actividad3.wmscServicios.WmscFacturaServicio;

import java.util.List;
@RestController
@RequestMapping("/api/v1/factura")
public class WmscFacturaControlador {
    @Autowired
    private WmscFacturaServicio wmscFacturaServicio;
    @GetMapping
    public ResponseEntity<?> listar() {
       try {
           List<WmscFactura> wmscFacturas = wmscFacturaServicio.listar();
           return new ResponseEntity<>(wmscFacturas, HttpStatus.OK);
         } catch (WmscRequestException e) {
           return  ResponseEntity.status(e.getStatus()).body(new WmscError(e.getCode(), e.getMessage()));
         }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> crear(@RequestBody WmscFactura wmscFactura) {
        try {
            return new ResponseEntity<>(wmscFacturaServicio.crear(wmscFactura), HttpStatus.CREATED);
        } catch (WmscRequestException e) {
            return  ResponseEntity.status(e.getStatus()).body(new WmscError(e.getCode(), e.getMessage()));
        }
    }
    @PostMapping("/crearError")
    public ResponseEntity<?> crearError(@RequestBody WmscFactura wmscFactura) {
        try {
            return new ResponseEntity<>(wmscFacturaServicio.crear(wmscFactura), HttpStatus.CREATED);
        } catch (WmscBusinessException e) {
            return  ResponseEntity.status(e.getStatus()).body(new WmscError(e.getCode(), e.getMessage()));
        }
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizar(@RequestBody WmscFactura wmscFactura) {
        try {
            return new ResponseEntity<>(wmscFacturaServicio.actualizar(wmscFactura), HttpStatus.OK);
        } catch (WmscRequestException e) {
            return  ResponseEntity.status(e.getStatus()).body(new WmscError(e.getCode(), e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id) {
        try {
            wmscFacturaServicio.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (WmscRequestException e) {
            return  ResponseEntity.status(e.getStatus()).body(new WmscError(e.getCode(), e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(wmscFacturaServicio.buscarPorId(id), HttpStatus.OK);
        } catch (WmscRequestException e) {
            return ResponseEntity.status(e.getStatus()).body(new WmscError(e.getCode(), e.getMessage()));
        }
    }

}
