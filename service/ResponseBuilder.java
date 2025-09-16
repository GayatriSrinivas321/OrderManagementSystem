public class ResponseBuilder {
 public static <T> ResponseEntity<ResponseEntity<T>> buildSuccess(T data, String message) {
        return new ResponseEntity<>(
                new ResponseEntity<>(HttpStatus.OK, message, data),
                HttpStatus.OK
        );
    }


    public static <T> ResponseEntity<ResponseEntity<T>> buildError(String message, HttpStatus status) {
        return new ResponseEntity<>(
                new ResponseEntity<>(status, message, null),
                status
        );
    }
}
