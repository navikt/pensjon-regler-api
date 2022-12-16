package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ektefelletillegg;
import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/* PREG domeneklasse for ytelseskomponent Ektefelletillegg Uføretrygd
 *
 * @author Magnus Bakken - PKFEIL-3285: Feilretting av kopikonstruktør.
 * @author Swiddy de Louw - PKYTON-369 PK-6582 / PK-7106
 */

public class EktefelletilleggUT extends Ytelseskomponent {

    

    /**
     * Årsbeløp for delytelsen fra tidligere vedtak (fra tilsvarende beregningsperiode)
     */
    private int tidligereBelopAr;

    /**
     * Akkumulert netto hittil i året eksklusiv måned for beregningsperiodens fomDato.
     */
    private int nettoAkk;

    /**
     * gjenstående beløp brukeren har rett på for året som beregningsperioden starter,
     * og inkluderer måneden det beregnes fra.
     */
    private int nettoRestAr;

    /**
     * Inntektsavkortningsbeløp per år, før justering med differansebeløp
     */
    private int avkortningsbelopPerAr;

	/**
	 * netto ektefelletillegg per måned før konvertering * 12
	 */
    private double etForSkattekomp;

	/**
	 * brukers oppjusterte uførepensjon før skattekompensasjon
	 */
    private double upForSkattekomp;

    public EktefelletilleggUT() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_ET");
    }

}
