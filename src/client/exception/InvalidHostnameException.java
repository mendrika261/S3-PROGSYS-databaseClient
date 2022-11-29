package client.exception;

import client.display.Color;

public class InvalidHostnameException extends Exception {
    public InvalidHostnameException() {
        super(Color.YELLOW + "\n\tLe host spécifié n'est pas valide, entrer un ipv4" + Color.RESET);
        setStackTrace(new StackTraceElement[]{});
    }
}
