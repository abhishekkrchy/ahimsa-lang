package ahimsa.parmo.dharmah;

public class AhimsaError extends RuntimeException {
    public AhimsaError(Throwable throwable) {
        super(throwable);
    }

    public AhimsaError(String message) {
        super(message);
    }
}
