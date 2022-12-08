package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.Merknad;

import java.io.Serializable;
import java.util.*;

public class Poengrekke implements Serializable {



    /**
     * Antall poeng�r totalt. Kan v�re ikke v�re over 40.
     */
    private int pa;

    /**
     * Antall poeng�r f�r 1992.
     */
    private int pa_f92;

    /**
     * Antall poeng�r etter 1991.
     */
    private int pa_e91;

    /**
     * Faktiske poeng�r i Norge.
     */
    private int pa_fa_norge;

    /**
     * Tidligere pensjonsgivende inntekt.
     */
    private int tpi;

    /**
     * Liste av Poengtall
     */
    private List<Poengtall> poengtallListe;

    /**
     * Samlet antall poeng�r i Norge.
     */
    private int pa_no;

    /**
     * Framtidig pensjonspoengtall. Brukes ved beregning av
     * uf�repensjon,gjenlevendepensjon og AFP.
     */
    private FramtidigPensjonspoengtall fpp;

    /**
     * Framtidig pensjonspoengtall, basert p� omregnet poengrekke. Brukes ved
     * beregning av uf�repensjon og gjenlevendepensjon.
     */
    private FramtidigPensjonspoengtall fpp_omregnet;

    /**
     * Siste poeng�r med framtidig pensjonspoeng.
     */
    private int siste_fpp_aar;

    /**
     * Tidligere pensjonsgivende inntekt, beregnet som en faktor.
     */
    private double tpi_faktor;

    /**
     * Brutto antall framtidige poeng�r i norden.
     */
    private int pa_nordisk_framt_brutto;

    /**
     * Netto antall framtidige poeng�r i norden.
     */
    private int pa_nordisk_framt_netto;

    /**
     * Poengtall ut fra antatt �rlig inntekt.
     */
    private double paa;

    /**
     * Faktiske poeng�r i Norden.
     */
    private int pa_fa_norden;

    /**
     * Teoretiske poeng�r E�S. Dette begrepet brukes ved beregning av
     * tilleggspensjon etter E�S-reglene eller ved beregning etter de bilaterale
     * avtalene. Ved pro rata beregningen fastsettes det teoretiske antallet
     * poeng�r som det antall �r vedkommende ville f�tt dersom all opptjening i
     * E�S-land hadde v�rt opptjent i Norge
     */
    private int pa_eos_teoretisk;

    /**
     * Pro-rata poeng�r E�S. Poeng�r som ikke skal inng� i pro-rata beregning er
     * utelatt.
     */
    private int pa_eos_pro_rata;

    /**
     * Teller i pro-rata br�k.
     */
    private int pa_pro_rata_teller;

    /**
     * Nevner i pro-rata br�k.
     */
    private int pa_pro_rata_nevner;

    /**
     * Antall fremtidige poeng�r.
     */
    private int fpa;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;

	/**
	* Flagg som viser om oppustert grunnlag fra pensjonsberegning fra TP-ordning er benyttet
	*/
	private boolean AfpTpoUpGrunnlagAnvendt;
	
	/**
	* Det oppjusterte uf�repensjonsgrunnlaget fra TP-ordningen som ble brukt i beregning av TPI
	*/
	private int AfpTpoUpGrunnlagOppjustert;
	
	/**
	* TPI beregnet etter hovedregelen
	*/
	private int tpiEtterHovedregel;


}
