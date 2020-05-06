package kz.iitu.mukhtar.electricity.exceptions;

import org.postgresql.util.PSQLException;
import org.postgresql.util.PSQLState;

public class BillNotFoundException extends PSQLException {
    public BillNotFoundException() {
        super("Bill not found", PSQLState.DATA_ERROR);
    }

    public BillNotFoundException(String s) {
        super(s, PSQLState.DATA_ERROR);
    }
}
