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
     * Feltene ar, opptjeningType er påkrevd. Dersom opptjeningType er lik PPI så er pi også påkrevd.
     */
    private Opptjeningsgrunnlag opptjening;
    /**
     * Brukers fødselsdato
     */
    private Date fodselsdato;


}
