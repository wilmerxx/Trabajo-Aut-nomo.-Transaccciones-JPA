package org.wilmer.actividad3.wmscRepositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wilmer.actividad3.wmscModelos.WmscDetalleFactura;
import org.wilmer.actividad3.wmscModelos.WmscFactura;
@Repository
public interface WmscFacturaRepositorio extends JpaRepository<WmscFactura, Long> {
}
