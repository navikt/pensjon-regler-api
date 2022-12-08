package no.nav.domain.pensjon.regler.beregning;


import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;
import no.nav.domain.pensjon.regler.util.formula.Formel;

import java.util.HashMap;

/*
 * Tilleggspensjon
 */

public class Tilleggspensjon extends Ytelseskomponent {

    /**
     * Det ordinære sluttpoengtallet.
     */
    protected Sluttpoengtall spt;

    /**
     * Sluttpoengtallet for yrkesskaden.Denne blir utfylt dersom det foreligger
     * yrkesskadegrunnlag i persongrunnlaget. ypt.pt er beregnet på grunnlag av
     * a) tilhørende poengtall (ypt.poengrekke.poengtallListe ) eller b) paa (
     * poeng etter antatt årlig inntekt ). Poengtall-listen er da tom. I alle
     * tilfeller er YPT.pt >= SPT.pt. Det vanligste tilfellet hvor YPT.pt >
     * SPT.pt skyldes yrkessadegrunnlag.antattArligInntekt.
     */
    protected Sluttpoengtall ypt;

    /**
     * Sluttpoengtallet for overkompensasjon.
     */
    protected Sluttpoengtall opt;

    /**
     * Den skiltes del av avdødes tilleggspensjon. Angis i prosent.
     */
    protected int skiltesDelAvAdodesTP;


    /**
     * Map av formler brukt i beregning av Tilleggspensjon.
     */
    private HashMap<String, Formel> formelMap;

    public Tilleggspensjon() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("TP");
        setFormelKode(new FormelKodeCti("TPx"));
        formelMap = new HashMap<>();
    }
}


