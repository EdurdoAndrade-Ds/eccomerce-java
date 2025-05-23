@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<Stirng> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    public ResponseEntity<String> handleValidation(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Erro de validação: " + ex.getBindingResult()).getAllErros().get(0). getDefaultMessage();
    }
}