package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.kode.AvkortingsArsakCti;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

import java.util.ArrayList;
import java.util.List;

/*
 * Ektefelletillegg
 */

public class Ektefelletillegg extends Ytelseskomponent {

    private static final long serialVersionUID = -2250297845903930169L;

    /**
     * Fribeløpet
     */
    @GuiPrompt(prompt = "Fribeløp")
    private int fribelop;

    /**
     * Summen av inntektene som kan bli lagt til grunn ved avkorting, selv når det ikke fører til avkorting.
     */
    @GuiPrompt(prompt = "Sum inntekt ved avkorting")
    private int samletInntektAvkort;

    /**
     * Angir om tillegget er avkortet.
     */
    @GuiPrompt(prompt = "Avkortet")
    private boolean avkortet;

    /**
     * Årsaken(e) til avkorting. Satt dersom avkortet er true.
     */
    @GuiPrompt(prompt = "Årsak til avkorting")
    private List<AvkortingsArsakCti> arsaksList = new ArrayList<AvkortingsArsakCti>();

    /**
     * Angir minste pensjonsnivåsats for ektefelletillegget
     */
    @GuiPrompt(prompt = "Minste pensjonsnivå sats for ektefelletillegg")
    private double mpnSatsFT;

    /**
     * Den anvendte trygdetiden i beregningen av tillegget. Kan være forskjellig fra Beregningen.tt_anv
     */
    @GuiPrompt(prompt = "Anvendt trygdetid")
    private int tt_anv;

    /**
     * Nedtrappingsgrad brukt ved utfasing av forsørgingstillegg fom 2023.
     */
    private int forsorgingstilleggNiva = 100;

    /**
     * Telleren i proratabrøken for EØS-avtaleberegnet tillegg
     */
    @GuiPrompt(prompt = "Pro rata teller")
    private int proratateller;

    /**
     * Telleren i proratabrøken for EØS-avtaleberegnet tillegg
     */
    @GuiPrompt(prompt = "Pro rata nevner")
    private int proratanevner;

    /**
     * Flagg som forteller om ektefelletillegget er skattefritt.
     * Ektefelletillegg som utbetales til AFP og alderspensjonister skal utbetales skattefritt for de
     * som mottar ektefelletillegg pr 31. desember 2010. Fritaket gjelder ikke for de som mister
     * ektefelletillegget for ett eller flere inntektsår etter desember 2010, men senere får det tilbake.
     * Skattefritaket skal ikke gjelde alderspensjonister som tilstås ektefelletillegg med virkning tidligst
     * 1. januar 2011
     */
    @GuiPrompt(prompt = "Skattefritak")
    private boolean skattefritak;

    /**
     * Copy Constructor
     * 
     * @param ektefelletillegg a <code>Ektefelletillegg</code> object
     */
    public Ektefelletillegg(Ektefelletillegg ektefelletillegg) {
        super(ektefelletillegg);
        fribelop = ektefelletillegg.fribelop;
        samletInntektAvkort = ektefelletillegg.samletInntektAvkort;
        avkortet = ektefelletillegg.avkortet;
        mpnSatsFT = ektefelletillegg.mpnSatsFT;
        tt_anv = ektefelletillegg.tt_anv;
        forsorgingstilleggNiva = ektefelletillegg.forsorgingstilleggNiva;
        proratanevner = ektefelletillegg.proratanevner;
        proratateller = ektefelletillegg.proratateller;
        skattefritak = ektefelletillegg.skattefritak;
        arsaksList = new ArrayList<AvkortingsArsakCti>();
        for (AvkortingsArsakCti arsak : ektefelletillegg.arsaksList) {
            arsaksList.add(new AvkortingsArsakCti(arsak.getKode()));
        }
    }

    public Ektefelletillegg(int fribelop, int samletInntektAvkort) {
        this();
        this.fribelop = fribelop;
        this.samletInntektAvkort = samletInntektAvkort;
    }

    public Ektefelletillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("ET");
        setFormelKode(new FormelKodeCti("ETx"));
    }

    public int getFribelop() {
        return fribelop;
    }

    public void setFribelop(int fribelop) {
        this.fribelop = fribelop;
    }

    public int getSamletInntektAvkort() {
        return samletInntektAvkort;
    }

    public void setSamletInntektAvkort(int samletInntektAvkort) {
        this.samletInntektAvkort = samletInntektAvkort;
    }

    public List<AvkortingsArsakCti> getArsaksList() {
        return arsaksList;
    }

    /**
     * Read only property for arsaksListe as array
     * 
     * @return array of AvkortingsArsak
     */
    public AvkortingsArsakCti[] getArsaksListeAsArray() {
        return arsaksList != null ? arsaksList.toArray(new AvkortingsArsakCti[arsaksList.size()]) : new AvkortingsArsakCti[0];
    }

    public void setArsaksList(List<AvkortingsArsakCti> arsaksList) {
        this.arsaksList = arsaksList;
    }

    public boolean isAvkortet() {
        return avkortet;
    }

    public void setAvkortet(boolean avkortet) {
        this.avkortet = avkortet;
    }

    public double getMpnSatsFT() {
        return mpnSatsFT;
    }

    public void setMpnSatsFT(double mpnSatsFT) {
        this.mpnSatsFT = mpnSatsFT;
    }

    public int getProratanevner() {
        return proratanevner;
    }

    public void setProratanevner(int proratanevner) {
        this.proratanevner = proratanevner;
    }

    public int getProratateller() {
        return proratateller;
    }

    public void setProratateller(int proratateller) {
        this.proratateller = proratateller;
    }

    public int getTt_anv() {
        return tt_anv;
    }

    public void setTt_anv(int tt_anv) {
        this.tt_anv = tt_anv;
    }

    public void setSkattefritak(boolean skattefritak) {
        this.skattefritak = skattefritak;
    }

    public boolean isSkattefritak() {
        return skattefritak;
    }

    public int getForsorgingstilleggNiva() {
        return forsorgingstilleggNiva;
    }

    public void setForsorgingstilleggNiva(int forsorgingstilleggNiva) {
        this.forsorgingstilleggNiva = forsorgingstilleggNiva;
    }
}
