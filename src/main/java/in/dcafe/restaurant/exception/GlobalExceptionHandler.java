package in.dcafe.restaurant.exception;

import jakarta.persistence.NoResultException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleIllegalArgumentException(
            IllegalArgumentException exception, final HttpServletRequest request) {
        return problemDetail(ProblemDetail.forStatus(HttpStatus.BAD_REQUEST), exception, request);
    }

    @ExceptionHandler(NoResultException.class)
    public ProblemDetail handleNoResultException(
            NoResultException exception, final HttpServletRequest request) {
        return problemDetail(ProblemDetail.forStatus(HttpStatus.NOT_FOUND), exception, request);
    }

    public ProblemDetail problemDetail(ProblemDetail problemDetail, Exception exception, HttpServletRequest request) {
        problemDetail.setDetail(exception.getMessage());
        problemDetail.setType(URI.create(exception.getClass().getName()));
        problemDetail.setInstance(URI.create(request.getRequestURI()));
        return problemDetail;
    }

}