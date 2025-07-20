package femcloudapi.exeptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ErrorResponse buildErrorResponse(String message, int status, String errorCode, String path) {
        return new ErrorResponse(message, status, errorCode, path);
    }

    private static final String GENERIC_ERROR_MESSAGE = "Internal server error";

    @ExceptionHandler(QuoteNotFoundException.class)
    public ResponseEntity<ErrorResponse> quoteNotFound(QuoteNotFoundException exception, HttpServletRequest request) {
        ErrorResponse error = buildErrorResponse(
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                ErrorCode.PRODUCT_NOT_FOUND.name(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException exception, HttpServletRequest request) {
        String message = exception.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .orElse("Invalid input");

        ErrorResponse error = buildErrorResponse(
                message,
                HttpStatus.BAD_REQUEST.value(),
                ErrorCode.VALIDATION_ERROR.name(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericError(Exception exception, HttpServletRequest request) {
        ErrorResponse error = buildErrorResponse(
                GENERIC_ERROR_MESSAGE,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ErrorCode.INTERNAL_ERROR.name(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
