package org.wilmer.actividad3.WmscExcepciones;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.wilmer.actividad3.wmscModelos.WmscError;

@ControllerAdvice
public class WmscGloblaExecepciones {

    @ExceptionHandler(WmscBusinessException.class)
    public ResponseEntity<WmscError> handleException(WmscBusinessException e) {
        WmscError error = new WmscError(e.getCode(), e.getMessage());
        return new ResponseEntity<>(error, e.getStatus());
    }
    @ExceptionHandler(WmscRequestException.class)
    public ResponseEntity<WmscError> handleException(WmscRequestException e) {
        WmscError error = new WmscError(e.getCode(), e.getMessage());
        return new ResponseEntity<>(error, e.getStatus());
    }
}
