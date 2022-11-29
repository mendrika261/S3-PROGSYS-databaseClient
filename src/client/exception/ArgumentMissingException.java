package client.exception;

import client.display.Color;

public class ArgumentMissingException extends Exception {
    public ArgumentMissingException() {
        super(Color.YELLOW + "\n\tDes arguments doivent être mentionné: le host et le port" + Color.RESET);
        setStackTrace(new StackTraceElement[]{});
    }
}
