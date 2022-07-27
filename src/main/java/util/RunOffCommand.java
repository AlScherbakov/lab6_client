package util;

class RunOffCommandException extends RuntimeException{

    public RunOffCommandException() {
    }

    public RunOffCommandException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
