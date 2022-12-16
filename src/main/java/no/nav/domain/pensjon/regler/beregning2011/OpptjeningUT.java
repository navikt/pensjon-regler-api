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
     * Angir om avkortet mot 6*grunnbel�p ved virk.
     */
    private double avkortetBelop;

    /**
     * Angir om et av de tre �rene som er brukt.
     */
    private boolean brukt;

    /**
     * Angir om det er inntekt i avtaleland som ang�r den konvensjon som beregningsgrunnlaget inng�r i.
     */
    private boolean inntektIAvtaleland;

    /**
     * Inntekten for et �r ganget med forholdet mellom grunnbel�pet ved virk
     * og gjennomsnittlig grunnbel�p for inntekts�ret.
     */
    private double justertBelop;

    /**
     * Pensjonsgivende inntekt.
     */
    private int pgi;

    /**
     * Gjennomsnittlig G for inntekts�ret.
     */
    private int veietG;

    /**
     * Hvilket �rstall.
     */
    private int ar;

    private List<Merknad> merknadListe = new ArrayList<Merknad>();

    private FormelKodeCti formelkode;

    /**
     * Opptjeningsgaranti ved f�rstegangstjeneste.
     */
    private int forstegangstjeneste;

    /**
     * Beregnet inntekt for �ret.
     */
    private int belop;

    /**
     * Minste bel�p for fastsettelse av justert PGI.
     */
    private int garantiBelop;

    /**
     * Angir om det finnes omsorgsopptjening for �ret.
     */
    private boolean omsorgsar;

    /**
     * Pensjonsgivende inntekt justert i henhold til
     * gjennomsnittlig stillingsprosent for �ret.
     */
    private int justertPGI;

    /**
     * Opptjening fra uf�repensjon eller uf�retrygd
     */
    private double uforeopptjening;


}
