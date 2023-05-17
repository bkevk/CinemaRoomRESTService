package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(OutOfBoundException.class)
    public ResponseEntity<Object> handleOutOfBounds(OutOfBoundException e, WebRequest request){
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("error", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(AlreadyPurchasedException.class)
    public ResponseEntity<Object> handleAlreadyPurchased(AlreadyPurchasedException e, WebRequest request){
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("error", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(WrongToken.class)
    public ResponseEntity<Object> wrongToken(WrongToken e, WebRequest request){
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("error", e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);

    }
}
