package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;
import java.util.Date;

/**
 * Angir informasjon om stillingsprosent
 * 
 * @author Swiddy de Louw (Capgemini), PK-7973 PKPYTON-526
 */

public class Arbeidsforholdsgrunnlag implements Serializable {



    /**
     * Fom dato for arbeidsforholdet.
     */
    private Date fomDato;

    /**
     * Tom dato for arbeidsforholdet.
     */
    private Date tomDato;

    /**
     * Stillingsandel i prosent.
     */
    private int stillingsprosent;

    /**
     * Navn på arbeidsgiver.
     */
    private String arbeidsgiver;

    /**
     * Arbeidsgivers juridiske organisasjonsnummer.
     */
    private String orgNummer;

}
