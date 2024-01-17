package org.wilmer.actividad3.WmscExcepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class WmscBusinessException  extends RuntimeException{
    private String code;
    private HttpStatus status;
    public WmscBusinessException(String code, String message , HttpStatus status){
        super(message);
        this.code = code;
        this.status = status;
    }
}
