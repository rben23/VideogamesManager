package exceptions;

public class UploadFailed extends Exception {
    public UploadFailed() {
        super("ERROR: Subida fallida");
    }
}
