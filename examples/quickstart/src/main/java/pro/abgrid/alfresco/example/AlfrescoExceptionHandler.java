package pro.abgrid.alfresco.example;

import pro.abgrid.alfresco.exception.AlfrescoApiException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.io.IOException;

@RestControllerAdvice
public class AlfrescoExceptionHandler {

    @ExceptionHandler(AlfrescoApiException.class)
    public ResponseEntity<ApiError> handleAlfresco(AlfrescoApiException ex, HttpServletRequest request) {
        int status = ex.getStatus() == null ? HttpStatus.BAD_GATEWAY.value() : ex.getStatus().value();
        String message = ex.getBriefSummary() == null ? ex.getMessage() : ex.getBriefSummary();

        return ResponseEntity.status(status).body(new ApiError(
                status,
                ex.getErrorKey(),
                message,
                ex.getLogId(),
                request.getRequestURI()
        ));
    }

    @ExceptionHandler({MissingServletRequestParameterException.class, MissingServletRequestPartException.class})
    public ResponseEntity<ApiError> handleBadRequest(Exception ex, HttpServletRequest request) {
        return error(HttpStatus.BAD_REQUEST, "invalid-request", ex.getMessage(), request);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ApiError> handleUploadTooLarge(MaxUploadSizeExceededException ex,
                                                         HttpServletRequest request) {
        return error(HttpStatus.CONTENT_TOO_LARGE, "upload-too-large",
                "Uploaded file exceeds the configured multipart size limit", request);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ApiError> handleIo(IOException ex, HttpServletRequest request) {
        return error(HttpStatus.BAD_REQUEST, "upload-io-error", ex.getMessage(), request);
    }

    private static ResponseEntity<ApiError> error(HttpStatus status, String errorKey, String message,
                                                   HttpServletRequest request) {
        return ResponseEntity.status(status).body(new ApiError(
                status.value(), errorKey, message, null, request.getRequestURI()
        ));
    }

    public record ApiError(int status, String errorKey, String message, String alfrescoLogId, String path) {
    }
}
