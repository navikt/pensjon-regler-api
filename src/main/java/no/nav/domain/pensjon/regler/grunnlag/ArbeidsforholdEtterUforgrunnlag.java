package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lars Hartviksen (Decisive), PK-6985
 * @author Aasmund Nordstoga (Accenture) - PK-16378, PKPYTON-1754
 */
public class ArbeidsforholdEtterUforgrunnlag implements Serializable {


    /**
     * Fom date for arbeidsforholdet.
     */
    private Date fomDato;

    /**
     * Work load.
     */
    private int stillingsprosent;

    /**
     * if it is lasting facilitated work
     */
    private boolean varigTilrettelagtArbeid;

}