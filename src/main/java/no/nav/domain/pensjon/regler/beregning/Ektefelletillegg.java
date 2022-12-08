package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.kode.AvkortingsArsakCti;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.util.ArrayList;
import java.util.List;

/*
 * Ektefelletillegg
 */

public class Ektefelletillegg extends Ytelseskomponent {

    

    /**
     * Fribeløpet
     */
    private int fribelop;

    /**
     * Summen av inntektene som kan bli lagt til grunn ved avkorting, selv når det ikke fører til avkorting.
     */
    private int samletInntektAvkort;

    /**
     * Angir om tillegget er avkortet.
     */
    private boolean avkortet;

    /**
     * Årsaken(e) til avkorting. Satt dersom avkortet er true.
     */
    private List<AvkortingsArsakCti> arsaksList = new ArrayList<AvkortingsArsakCti>();

    /**
     * Angir minste pensjonsnivåsats for ektefelletillegget
     */
    private double mpnSatsFT;

    /**
     * Den anvendte trygdetiden i beregningen av tillegget. Kan være forskjellig fra Beregningen.tt_anv
     */
    private int tt_anv;

    /**
     * Nedtrappingsgrad brukt ved utfasing av forsørgingstillegg fom 2023.
     */
    private int forsorgingstilleggNiva = 100;

    /**
     * Telleren i proratabrøken for EØS-avtaleberegnet tillegg
     */
    private int proratateller;

    /**
     * Telleren i proratabrøken for EØS-avtaleberegnet tillegg
     */
    private int proratanevner;

    /**
     * Flagg som forteller om ektefelletillegget er skattefritt.
     * Ektefelletillegg som utbetales til AFP og alderspensjonister skal utbetales skattefritt for de
     * som mottar ektefelletillegg pr 31. desember 2010. Fritaket gjelder ikke for de som mister
     * ektefelletillegget for ett eller flere inntektsår etter desember 2010, men senere får det tilbake.
     * Skattefritaket skal ikke gjelde alderspensjonister som tilstås ektefelletillegg med virkning tidligst
     * 1. januar 2011
     */
    private boolean skattefritak;

    public Ektefelletillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("ET");
        setFormelKode(new FormelKodeCti("ETx"));
    }

}
