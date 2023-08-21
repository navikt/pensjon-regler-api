package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

public class AfpKompensasjonstillegg extends Ytelseskomponent {
    private static final long serialVersionUID = -1468562071036162079L;

    private int referansebelop;
    private int reduksjonsbelop;
    private double forholdstallKompensasjonstillegg;

    public AfpKompensasjonstillegg(Ytelseskomponent ytelseskomponent, int referansebelop, int reduksjonsbelop, double forholdstallKompensasjonstillegg) {
        super(ytelseskomponent);
        this.referansebelop = referansebelop;
        this.reduksjonsbelop = reduksjonsbelop;
        this.forholdstallKompensasjonstillegg = forholdstallKompensasjonstillegg;
    }

    public AfpKompensasjonstillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("AFP_KOMP_TILLEGG");
    }

    public AfpKompensasjonstillegg(AfpKompensasjonstillegg aAfpKompensasjonstillegg) {
        super(aAfpKompensasjonstillegg);
        referansebelop = aAfpKompensasjonstillegg.referansebelop;
        reduksjonsbelop = aAfpKompensasjonstillegg.reduksjonsbelop;
        forholdstallKompensasjonstillegg = aAfpKompensasjonstillegg.forholdstallKompensasjonstillegg;
    }

    public double getForholdstallKompensasjonstillegg() {
        return forholdstallKompensasjonstillegg;
    }

    public void setForholdstallKompensasjonstillegg(double forholdstallKompensasjonstillegg) {
        this.forholdstallKompensasjonstillegg = forholdstallKompensasjonstillegg;
    }

    public int getReduksjonsbelop() {
        return reduksjonsbelop;
    }

    public void setReduksjonsbelop(int reduksjonsbelop) {
        this.reduksjonsbelop = reduksjonsbelop;
    }

    public int getReferansebelop() {
        return referansebelop;
    }

    public void setReferansebelop(int referansebelop) {
        this.referansebelop = referansebelop;
    }

}
