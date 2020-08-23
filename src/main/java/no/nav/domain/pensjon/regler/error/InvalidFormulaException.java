package no.nav.domain.pensjon.regler.error;

public class InvalidFormulaException extends RuntimeException {

    public InvalidFormulaException() {
        super();
    }

    public InvalidFormulaException(String msg ) {
        super(msg);
    }

}
