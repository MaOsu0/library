package pl.javastart.library.exception;

public class NoSuchFileTypeExpection extends RuntimeException {
    public NoSuchFileTypeExpection(String message) {
        super(message);
    }
}
