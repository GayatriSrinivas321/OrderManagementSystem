public class ResponseEntity<T> {
    
    String status;
    int code;
    String message;
    Object data;
    LocalDateTime timestamp;
    
    public ResponseEntity(HttpStatus status, String message, T data) {
        this.status = status.value();
        this.message = message;
        this.data = data;
    }
    
}
