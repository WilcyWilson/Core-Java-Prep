package javaprepfirstscope;

import java.io.Serial;

public class TableException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public TableException(String message) {
        super(message);
    }
}
