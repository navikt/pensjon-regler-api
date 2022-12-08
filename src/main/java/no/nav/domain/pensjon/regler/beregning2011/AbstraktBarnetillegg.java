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
     * Differansetillegg ved barnetillegg. Anvendes dersom prim�rt land for BT er et annet E�S land
     */
    private int btDiff_eos;

    /**
     * Anvendt fribel�p.
     */
    private int fribelop;

    /**
     * Angir minste pensjonsniv�sats for ektefelletillegget
     */
    private double mpnSatsFT;

    /**
     * Nevneren i proratabr�ken for E�S-avtaleberegnet tillegg
     */
    private int proratanevner;

    /**
     * Telleren i proratabr�ken for E�S-avtaleberegnet tillegg
     */
    private int proratateller;
    /**
     * Summen av inntektene som kan bli lagt til grunn ved avkorting, selv n�r det ikke f�rer til avkorting.
     */
    private int samletInntektAvkort;

    /**
     * Den anvendte trygdetiden i beregningen av tillegget. Kan v�re forskjellig fra tt_anv.
     */
    private int tt_anv;

    /**
     * Nedtrappingsgrad brukt ved utfasing av fors�rgingstillegg fom 2023.
     */
    private int forsorgingstilleggNiva = 100;

    /**
     * �rsaken(e) til avkorting. Satt dersom avkortet er true.
     */
    private List<AvkortingsArsakCti> avkortingsArsakList = new ArrayList<AvkortingsArsakCti>();

}
