package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.AvkortingsArsakCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstraktBarnetillegg extends Ytelseskomponent implements Serializable {
    private static final long serialVersionUID = 755786287179046212L;

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
    private int nedtrappingsgrad = 100;

    /**
     * �rsaken(e) til avkorting. Satt dersom avkortet er true.
     */
    private List<AvkortingsArsakCti> avkortingsArsakList = new ArrayList<AvkortingsArsakCti>();

    protected AbstraktBarnetillegg() {
        super();
    }

    /**
     * Lager en deep copy - kopi av objektet
     * 
     * @param ab
     */
    protected AbstraktBarnetillegg(AbstraktBarnetillegg ab) {
        super(ab);
        antallBarn = ab.getAntallBarn();
        avkortet = ab.isAvkortet();
        btDiff_eos = ab.getBtDiff_eos();
        fribelop = ab.getFribelop();
        mpnSatsFT = ab.getMpnSatsFT();
        proratanevner = ab.getProratanevner();
        proratateller = ab.getProratateller();
        samletInntektAvkort = ab.getSamletInntektAvkort();
        tt_anv = ab.getTt_anv();
        nedtrappingsgrad = ab.nedtrappingsgrad;
        if (ab.avkortingsArsakList != null) {
            for (AvkortingsArsakCti arsak : ab.avkortingsArsakList) {
                avkortingsArsakList.add(new AvkortingsArsakCti(arsak.getKode()));
            }
        }
    }

    public int getAntallBarn() {
        return antallBarn;
    }

    public int getBtDiff_eos() {
        return btDiff_eos;
    }

    public int getFribelop() {
        return fribelop;
    }

    public double getMpnSatsFT() {
        return mpnSatsFT;
    }

    public int getProratanevner() {
        return proratanevner;
    }

    public int getProratateller() {
        return proratateller;
    }

    public int getSamletInntektAvkort() {
        return samletInntektAvkort;
    }

    public int getTt_anv() {
        return tt_anv;
    }

    public boolean isAvkortet() {
        return avkortet;
    }

    public void setAntallBarn(int antallBarn) {
        this.antallBarn = antallBarn;
    }

    public void setAvkortet(boolean avkortet) {
        this.avkortet = avkortet;
    }

    public void setBtDiff_eos(int btDiff_eos) {
        this.btDiff_eos = btDiff_eos;
    }

    public void setFribelop(int fribelop) {
        this.fribelop = fribelop;
    }

    public void setMpnSatsFT(double mpnSatsFT) {
        this.mpnSatsFT = mpnSatsFT;
    }

    public void setProratanevner(int proratanevner) {
        this.proratanevner = proratanevner;
    }

    public void setProratateller(int proratateller) {
        this.proratateller = proratateller;
    }

    public void setSamletInntektAvkort(int samletInntektAvkort) {
        this.samletInntektAvkort = samletInntektAvkort;
    }

    public void setTt_anv(int tt_anv) {
        this.tt_anv = tt_anv;
    }

    public List<AvkortingsArsakCti> getAvkortingsArsakList() {
        return avkortingsArsakList;
    }

    public AvkortingsArsakCti[] getArsaksListeAsArray() {
        return avkortingsArsakList != null ? avkortingsArsakList.toArray(new AvkortingsArsakCti[avkortingsArsakList.size()]) : new AvkortingsArsakCti[0];
    }
    public int getNedtrappingsgrad() {
        return nedtrappingsgrad;
    }

    public void setNedtrappingsgrad(int nedtrappingsgrad) {
        this.nedtrappingsgrad = nedtrappingsgrad;
    }

    public void setAvkortingsArsakList(List<AvkortingsArsakCti> arsaksList) {
        avkortingsArsakList = arsaksList;
    }
}
