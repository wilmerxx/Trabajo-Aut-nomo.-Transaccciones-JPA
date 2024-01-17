package org.wilmer.actividad3.wmscModelos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WmscDetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wmsc_id;
    private String wmsc_Producto_nombre;
    private int wmsc_Producto_cantidad;
    private double wmsc_Producto_precio;
    private double wmsc_Producto_total;
    // Muchos detalles de factura pueden tener una factura
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "wmsc_factura_id", nullable = false, referencedColumnName = "wmsc_id")
    @JsonBackReference
    private WmscFactura wmscFactura;
}
