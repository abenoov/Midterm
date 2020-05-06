package kz.iitu.mukhtar.electricity.exceptions;

import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;

public class CheckNotFoundException extends PSQLException {
    public CheckNotFoundException() {
        super("Check not found", PSQLState.DATA_ERROR);
    }

    public CheckNotFoundException(String s) {
        super(s, PSQLState.DATA_ERROR);
    }
}
