package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.Date;

public class PersonOpptjeningsgrunnlag implements Serializable {

    
    /**
     * Brukes ikke av PREG
     */
    private String fnr;
    /**
     * Opptjeningen det skal beregnes pensjonspoeng for.
     * Feltene ar, opptjeningType er p�krevd. Dersom opptjeningType er lik PPI s� er pi ogs� p�krevd.
     */
    private Opptjeningsgrunnlag opptjening;
    /**
     * Brukers f�dselsdato
     */
    private Date fodselsdato;


}
