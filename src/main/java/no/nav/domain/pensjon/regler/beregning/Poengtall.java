package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.Omsorgsopptjening;
import no.nav.domain.pensjon.regler.kode.BeregningMetodeTypeCti;
import no.nav.domain.pensjon.regler.kode.PoengtallTypeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Poengtall implements Serializable {

    

    /**
     * Pensjonspoeng,
     */
    private double pp;

    /**
     * Anvendt pensjonsgivende inntekt.
     */
    private int pia;

    /**
     * Pensjonsgivende inntekt.
     */
    private int pi;

    /**
     * Året for dette poengtallet
     */
    private int ar;

    /**
     * Angir om poengtallet er brukt i beregningen av sluttpoengtall.
     */
    private boolean bruktIBeregning;

    /**
     * Veiet grunnbeløp
     */
    private int gv;

    /**
     * Poengtalltype.
     */
    private PoengtallTypeCti poengtallType;

    /**
     * Maks uføregrad for dette året
     */
    private int maksUforegrad;

    /**
     * Angir om året er et uføreår.
     */
    private boolean uforear;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;

}
