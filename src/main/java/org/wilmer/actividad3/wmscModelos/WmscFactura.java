package org.wilmer.actividad3.wmscModelos;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "wmsc_id")
public class WmscFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wmsc_id;
    private String wmsc_nombre;
    private String wmsc_fecha;
    private String wmsc_direccion;
    private int wmsc_numeroFactura;
    @OneToMany(mappedBy = "wmscFactura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WmscDetalleFactura> wmscDetalleFacturaList;
}
