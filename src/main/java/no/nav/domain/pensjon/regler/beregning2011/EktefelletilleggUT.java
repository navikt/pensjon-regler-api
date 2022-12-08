package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ektefelletillegg;
import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/* PREG domeneklasse for ytelseskomponent Ektefelletillegg Uf�retrygd
 *
 * @author Magnus Bakken - PKFEIL-3285: Feilretting av kopikonstrukt�r.
 * @author Swiddy de Louw - PKYTON-369 PK-6582 / PK-7106
 */

public class EktefelletilleggUT extends Ytelseskomponent {

    

    /**
     * �rsbel�p for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;

    /**
     * Akkumulert netto hittil i �ret eksklusiv m�ned for beregningsperiodens fomDato.
     */
    private int nettoAkk;

    /**
     * gjenst�ende bel�p brukeren har rett p� for �ret som beregningsperioden starter,
     * og inkluderer m�neden det beregnes fra.
     */
    private int nettoRestAr;

    /**
     * Inntektsavkortningsbel�p per �r, f�r justering med differansebel�p
     */
    private int avkortningsbelopPerAr;

	/**
	 * netto ektefelletillegg per m�ned f�r konvertering * 12
	 */
    private double etForSkattekomp;

	/**
	 * brukers oppjusterte uf�repensjon f�r skattekompensasjon
	 */
    private double upForSkattekomp;

    public EktefelletilleggUT() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_ET");
    }

}
