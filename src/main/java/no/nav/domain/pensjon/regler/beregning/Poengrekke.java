package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.Merknad;

import java.io.Serializable;
import java.util.*;

public class Poengrekke implements Serializable {



    /**
     * Antall poengår totalt. Kan være ikke være over 40.
     */
    private int pa;

    /**
     * Antall poengår før 1992.
     */
    private int pa_f92;

    /**
     * Antall poengår etter 1991.
     */
    private int pa_e91;

    /**
     * Faktiske poengår i Norge.
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
     * Samlet antall poengår i Norge.
     */
    private int pa_no;

    /**
     * Framtidig pensjonspoengtall. Brukes ved beregning av
     * uførepensjon,gjenlevendepensjon og AFP.
     */
    private FramtidigPensjonspoengtall fpp;

    /**
     * Framtidig pensjonspoengtall, basert på omregnet poengrekke. Brukes ved
     * beregning av uførepensjon og gjenlevendepensjon.
     */
    private FramtidigPensjonspoengtall fpp_omregnet;

    /**
     * Siste poengår med framtidig pensjonspoeng.
     */
    private int siste_fpp_aar;

    /**
     * Tidligere pensjonsgivende inntekt, beregnet som en faktor.
     */
    private double tpi_faktor;

    /**
     * Brutto antall framtidige poengår i norden.
     */
    private int pa_nordisk_framt_brutto;

    /**
     * Netto antall framtidige poengår i norden.
     */
    private int pa_nordisk_framt_netto;

    /**
     * Poengtall ut fra antatt årlig inntekt.
     */
    private double paa;

    /**
     * Faktiske poengår i Norden.
     */
    private int pa_fa_norden;

    /**
     * Teoretiske poengår EØS. Dette begrepet brukes ved beregning av
     * tilleggspensjon etter EØS-reglene eller ved beregning etter de bilaterale
     * avtalene. Ved pro rata beregningen fastsettes det teoretiske antallet
     * poengår som det antall år vedkommende ville fått dersom all opptjening i
     * EØS-land hadde vært opptjent i Norge
     */
    private int pa_eos_teoretisk;

    /**
     * Pro-rata poengår EØS. Poengår som ikke skal inngå i pro-rata beregning er
     * utelatt.
     */
    private int pa_eos_pro_rata;

    /**
     * Teller i pro-rata brøk.
     */
    private int pa_pro_rata_teller;

    /**
     * Nevner i pro-rata brøk.
     */
    private int pa_pro_rata_nevner;

    /**
     * Antall fremtidige poengår.
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
	* Det oppjusterte uførepensjonsgrunnlaget fra TP-ordningen som ble brukt i beregning av TPI
	*/
	private int AfpTpoUpGrunnlagOppjustert;
	
	/**
	* TPI beregnet etter hovedregelen
	*/
	private int tpiEtterHovedregel;


}
