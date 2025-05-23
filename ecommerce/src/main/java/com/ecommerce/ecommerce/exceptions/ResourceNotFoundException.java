@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends TuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}