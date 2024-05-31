package com.example.dd.advice;

import com.example.dd.exceptions.CloudStorageException;
import com.example.dd.exceptions.NotFoundById;
import com.example.dd.exceptions.NotFoundByUserNameException;
import com.example.dd.exceptions.WrongCardType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({NotFoundByUserNameException.class})
    public ResponseEntity<Object> handleUserNameNotFoundException(NotFoundByUserNameException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());

    }
    @ExceptionHandler({NotFoundById.class})
    public ResponseEntity<Object> handleIdNotfoundException(NotFoundById exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    @ExceptionHandler({WrongCardType.class})
    public ResponseEntity<Object>handleWrongTypeCard(WrongCardType wrongCardType){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(wrongCardType.getMessage());
    }
    @ExceptionHandler({CloudStorageException.class})
    public ResponseEntity<Object>handleCloudStorageException(CloudStorageException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
