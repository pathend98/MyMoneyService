package dev.hend.MyMoneyService.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, final WebRequest req) {
        String detail = String.format(
                "Failed to find resource `%s` with identifier `%s`", ex.getResourceName(), ex.getIdentifier());
        ProblemDetail problemDetail = super.createProblemDetail(ex, HttpStatus.NOT_FOUND, detail, null, null, req);
        return handleExceptionInternal(ex, problemDetail, new HttpHeaders(), HttpStatus.NOT_FOUND, req);
    }
}
