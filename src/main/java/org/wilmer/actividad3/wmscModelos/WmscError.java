package org.wilmer.actividad3.wmscModelos;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class WmscError {
    private String code;
    private String message;
    public WmscError(String code, String message){
        super();
        this.code = code;
        this.message = message;
    }
}
