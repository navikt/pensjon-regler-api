package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Magnus Bakken (Accenture), PK-9491
 * @author Swiddy de Louw (Capgemini), PK-7973 PKPYTON-526
 * @author Swiddy de Louw (Capgemini), PK-8704,PKPYTON-563
 */

public class OpptjeningUT implements Serializable {


    /**
     * Angir om avkortet mot 6*grunnbeløp ved virk.
     */
    private double avkortetBelop;

    /**
     * Angir om et av de tre årene som er brukt.
     */
    private boolean brukt;

    /**
     * Angir om det er inntekt i avtaleland som angår den konvensjon som beregningsgrunnlaget inngår i.
     */
    private boolean inntektIAvtaleland;

    /**
     * Inntekten for et år ganget med forholdet mellom grunnbeløpet ved virk
     * og gjennomsnittlig grunnbeløp for inntektsåret.
     */
    private double justertBelop;

    /**
     * Pensjonsgivende inntekt.
     */
    private int pgi;

    /**
     * Gjennomsnittlig G for inntektsåret.
     */
    private int veietG;

    /**
     * Hvilket årstall.
     */
    private int ar;

    private List<Merknad> merknadListe = new ArrayList<Merknad>();

    private FormelKodeCti formelkode;

    /**
     * Opptjeningsgaranti ved førstegangstjeneste.
     */
    private int forstegangstjeneste;

    /**
     * Beregnet inntekt for året.
     */
    private int belop;

    /**
     * Minste beløp for fastsettelse av justert PGI.
     */
    private int garantiBelop;

    /**
     * Angir om det finnes omsorgsopptjening for året.
     */
    private boolean omsorgsar;

    /**
     * Pensjonsgivende inntekt justert i henhold til
     * gjennomsnittlig stillingsprosent for året.
     */
    private int justertPGI;

    /**
     * Opptjening fra uførepensjon eller uføretrygd
     */
    private double uforeopptjening;


}
