package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

public class MinstenivatilleggIndividuelt extends Ytelseskomponent {
    private static final long serialVersionUID = -7552803118992528430L;

    private MinstePensjonsniva mpn;
    private Garantipensjonsniva garPN;
    private double samletPensjonForMNT;

    public MinstenivatilleggIndividuelt() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("MIN_NIVA_TILL_INDV");
    }

    public MinstenivatilleggIndividuelt(MinstenivatilleggIndividuelt mnt) {
        super(mnt);
        samletPensjonForMNT = mnt.samletPensjonForMNT;
        if (mnt.mpn != null) {
            mpn = new MinstePensjonsniva(mnt.mpn);
        }
        if (garPN != null) {
            garPN = new Garantipensjonsniva(mnt.garPN);
        }
    }

    public MinstePensjonsniva getMpn() {
        return mpn;
    }

    public void setMpn(MinstePensjonsniva mpn) {
        this.mpn = mpn;
    }

    public Garantipensjonsniva getGarPN() {
        return garPN;
    }

    public void setGarPN(Garantipensjonsniva garPN) {
        this.garPN = garPN;
    }

    public double getSamletPensjonForMNT() {
        return samletPensjonForMNT;
    }

    public void setSamletPensjonForMNT(double samletPensjonForMNT) {
        this.samletPensjonForMNT = samletPensjonForMNT;
    }

}
