package no.nav.pensjon.regler.domain.grunnlag;

import java.io.Serializable;
import java.util.Date;

public class PersonOpptjeningsgrunnlag implements Serializable {

    private static final long serialVersionUID = -8230746812048664603L;
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

    /**
     * Copy Constructor
     * 
     * @param personOpptjeningsgrunnlag a <code>PersonOpptjeningsgrunnlag</code> object
     */
    public PersonOpptjeningsgrunnlag(PersonOpptjeningsgrunnlag personOpptjeningsgrunnlag) {
        fnr = personOpptjeningsgrunnlag.fnr;
        if (personOpptjeningsgrunnlag.opptjening != null) {
            opptjening = new Opptjeningsgrunnlag(personOpptjeningsgrunnlag.opptjening);
        }
        if (personOpptjeningsgrunnlag.fodselsdato != null) {
            fodselsdato = (Date) personOpptjeningsgrunnlag.fodselsdato.clone();
        }
    }

    public PersonOpptjeningsgrunnlag() {
        super();
    }

    public PersonOpptjeningsgrunnlag(String fnr, Opptjeningsgrunnlag opptjening, Date fodselsdato) {
        super();
        this.fnr = fnr;
        this.opptjening = opptjening;
        this.fodselsdato = fodselsdato;
    }

    public String getFnr() {
        return fnr;
    }

    public void setFnr(String fnr) {
        this.fnr = fnr;
    }

    public Date getFodselsdato() {
        return fodselsdato;
    }

    public void setFodselsdato(Date fodselsdato) {
        this.fodselsdato = fodselsdato;
    }

    public Opptjeningsgrunnlag getOpptjening() {
        return opptjening;
    }

    public void setOpptjening(Opptjeningsgrunnlag opptjening) {
        this.opptjening = opptjening;
    }
}
