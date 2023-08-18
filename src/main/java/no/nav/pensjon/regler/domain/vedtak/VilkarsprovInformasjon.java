package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.beregning2011.AfpLivsvarig;
import no.nav.pensjon.regler.domain.beregning2011.FremskrevetAfpLivsvarig;
import no.nav.pensjon.regler.domain.beregning2011.FremskrevetPensjonUnderUtbetaling;
import no.nav.pensjon.regler.domain.beregning2011.PensjonUnderUtbetaling;

import java.io.Serializable;

public abstract class VilkarsprovInformasjon implements Serializable {
    private static final long serialVersionUID = -938173667013485492L;

    private boolean ektefelleInntektOver2g = false;
    private boolean flyktning = false;
    private FremskrevetPensjonUnderUtbetaling fullPensjonVed67;
    private PensjonUnderUtbetaling pensjonVedUttak;
    private FremskrevetAfpLivsvarig fremskrevetAfpLivsvarig;
    private AfpLivsvarig afpLivsvarigVedUttak;
    private boolean afpLivsvarigBrukt;
    private double fremskrevetPensjonVed67;
    private double samletPensjonVed67PerAr;

    public VilkarsprovInformasjon() {
        super();
    }

    public VilkarsprovInformasjon(VilkarsprovInformasjon vi) {
        this();
        ektefelleInntektOver2g = vi.ektefelleInntektOver2g;
        flyktning = vi.flyktning;
        if (vi.fullPensjonVed67 != null) {
            fullPensjonVed67 = new FremskrevetPensjonUnderUtbetaling(vi.fullPensjonVed67);
        }
        if (vi.pensjonVedUttak != null) {
            pensjonVedUttak = new PensjonUnderUtbetaling(vi.pensjonVedUttak);
        }
        if (vi.fremskrevetAfpLivsvarig != null) {
            fremskrevetAfpLivsvarig = new FremskrevetAfpLivsvarig(vi.fremskrevetAfpLivsvarig);
        }
        if (vi.afpLivsvarigVedUttak != null) {
            afpLivsvarigVedUttak = new AfpLivsvarig(vi.afpLivsvarigVedUttak);
        }
        afpLivsvarigBrukt = vi.afpLivsvarigBrukt;
        fremskrevetPensjonVed67 = vi.fremskrevetPensjonVed67;
        samletPensjonVed67PerAr = vi.samletPensjonVed67PerAr;
    }

    public boolean isAfpLivsvarigBrukt() {
        return afpLivsvarigBrukt;
    }

    public void setAfpLivsvarigBrukt(boolean afpLivsvarigBrukt) {
        this.afpLivsvarigBrukt = afpLivsvarigBrukt;
    }

    public AfpLivsvarig getAfpLivsvarigVedUttak() {
        return afpLivsvarigVedUttak;
    }

    public void setAfpLivsvarigVedUttak(AfpLivsvarig afpLivsvarigVedUttak) {
        this.afpLivsvarigVedUttak = afpLivsvarigVedUttak;
    }

    public boolean isEktefelleInntektOver2g() {
        return ektefelleInntektOver2g;
    }

    public void setEktefelleInntektOver2g(boolean ektefelleInntektOver2g) {
        this.ektefelleInntektOver2g = ektefelleInntektOver2g;
    }

    public double getFremskrevetPensjonVed67() {
        return fremskrevetPensjonVed67;
    }

    public void setFremskrevetPensjonVed67(double fremskrevetPensjonVed67) {
        this.fremskrevetPensjonVed67 = fremskrevetPensjonVed67;
    }

    public boolean isFlyktning() {
        return flyktning;
    }

    public void setFlyktning(boolean flyktning) {
        this.flyktning = flyktning;
    }

    public FremskrevetAfpLivsvarig getFremskrevetAfpLivsvarig() {
        return fremskrevetAfpLivsvarig;
    }

    public void setFremskrevetAfpLivsvarig(FremskrevetAfpLivsvarig fremskrevetAfpLivsvarig) {
        this.fremskrevetAfpLivsvarig = fremskrevetAfpLivsvarig;
    }

    public FremskrevetPensjonUnderUtbetaling getFullPensjonVed67() {
        return fullPensjonVed67;
    }

    public void setFullPensjonVed67(FremskrevetPensjonUnderUtbetaling fullPensjonVed67) {
        this.fullPensjonVed67 = fullPensjonVed67;
    }

    public PensjonUnderUtbetaling getPensjonVedUttak() {
        return pensjonVedUttak;
    }

    public void setPensjonVedUttak(PensjonUnderUtbetaling pensjonVedUttak) {
        this.pensjonVedUttak = pensjonVedUttak;
    }

    public double getSamletPensjonVed67PerAr() {
        return samletPensjonVed67PerAr;
    }

    public void setSamletPensjonVed67PerAr(double samletPensjonVed67PerAr) {
        this.samletPensjonVed67PerAr = samletPensjonVed67PerAr;
    }

}
