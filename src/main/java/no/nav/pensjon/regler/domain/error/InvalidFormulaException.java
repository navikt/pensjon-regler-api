package no.nav.pensjon.regler.domain.error;

public class InvalidFormulaException extends RuntimeException {

    public InvalidFormulaException() {
        super();
    }

    public InvalidFormulaException(String msg ) {
        super(msg);
    }

}
