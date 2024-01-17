package org.wilmer.actividad3.WmscExcepciones;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class WmscRequestException extends RuntimeException{

    private String code;
    private String message;
    private HttpStatus status;
    public WmscRequestException(String code, String message , HttpStatus status){
        super();
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
