package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.AvkortingsArsakCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstraktBarnetillegg extends Ytelseskomponent implements Serializable {

    /**
     * Antall barn i kullet.
     */
    private int antallBarn;

    /**
     * Angir om tillegget er avkortet.
     */
    private boolean avkortet;

    /**
     * Differansetillegg ved barnetillegg. Anvendes dersom primært land for BT er et annet EØS land
     */
    private int btDiff_eos;

    /**
     * Anvendt fribeløp.
     */
    private int fribelop;

    /**
     * Angir minste pensjonsnivåsats for ektefelletillegget
     */
    private double mpnSatsFT;

    /**
     * Nevneren i proratabrøken for EØS-avtaleberegnet tillegg
     */
    private int proratanevner;

    /**
     * Telleren i proratabrøken for EØS-avtaleberegnet tillegg
     */
    private int proratateller;
    /**
     * Summen av inntektene som kan bli lagt til grunn ved avkorting, selv når det ikke fører til avkorting.
     */
    private int samletInntektAvkort;

    /**
     * Den anvendte trygdetiden i beregningen av tillegget. Kan være forskjellig fra tt_anv.
     */
    private int tt_anv;

    /**
     * Nedtrappingsgrad brukt ved utfasing av forsørgingstillegg fom 2023.
     */
    private int forsorgingstilleggNiva = 100;

    /**
     * Årsaken(e) til avkorting. Satt dersom avkortet er true.
     */
    private List<AvkortingsArsakCti> avkortingsArsakList = new ArrayList<AvkortingsArsakCti>();

}
