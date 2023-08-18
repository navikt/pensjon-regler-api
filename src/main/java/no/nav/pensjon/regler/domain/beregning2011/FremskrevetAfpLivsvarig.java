package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

public class FremskrevetAfpLivsvarig extends AfpLivsvarig implements Regulering {
    private static final long serialVersionUID = -1652354210819048783L;

    private double reguleringsfaktor;
    private int gap;
    private double gjennomsnittligUttaksgradSisteAr;

    public FremskrevetAfpLivsvarig() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("FREM_AFP_LIVSVARIG");
    }

    public FremskrevetAfpLivsvarig(double reguleringsfaktor, int gap, double gjennomsnittligUttaksgradSisteAr) {
        this();
        this.reguleringsfaktor = reguleringsfaktor;
        this.gap = gap;
        this.gjennomsnittligUttaksgradSisteAr = gjennomsnittligUttaksgradSisteAr;
    }

    public FremskrevetAfpLivsvarig(FremskrevetAfpLivsvarig fremskrevetAfpLivsvarig) {
        this();
        reguleringsfaktor = fremskrevetAfpLivsvarig.reguleringsfaktor;
        gap = fremskrevetAfpLivsvarig.gap;
        gjennomsnittligUttaksgradSisteAr = fremskrevetAfpLivsvarig.gjennomsnittligUttaksgradSisteAr;
    }

    @Override
    public int getGap() {
        return gap;
    }

    @Override
    public void setGap(int gap) {
        this.gap = gap;
    }

    @Override
    public double getReguleringsfaktor() {
        return reguleringsfaktor;
    }

    @Override
    public void setReguleringsfaktor(double reguleringsfaktor) {
        this.reguleringsfaktor = reguleringsfaktor;
    }

    public double getGjennomsnittligUttaksgradSisteAr() {
        return gjennomsnittligUttaksgradSisteAr;
    }

    public void setGjennomsnittligUttaksgradSisteAr(double gjennomsnittligUttaksgradSisteAr) {
        this.gjennomsnittligUttaksgradSisteAr = gjennomsnittligUttaksgradSisteAr;
    }

}
