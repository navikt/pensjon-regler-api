package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.beregning.Poengrekke;
import no.nav.pensjon.regler.domain.grunnlag.AfpOpptjening;

public class AfpPrivatBeregning extends Beregning2011 {
    private static final long serialVersionUID = 4869820243136226443L;

    private AfpLivsvarig afpLivsvarig;
    private AfpKompensasjonstillegg afpKompensasjonstillegg;
    private AfpKronetillegg afpKronetillegg;
    private AfpOpptjening afpOpptjening;

    public AfpPrivatBeregning() {
        super();
    }

    public AfpPrivatBeregning(AfpLivsvarig afpLivsvarig, AfpKompensasjonstillegg afpKompensasjonstillegg, AfpKronetillegg afpKronetillegg, double gjennomsnittligUttaksgradSisteAr,
                              AfpOpptjening afpOpptjening, Poengrekke poengrekke) {
        super();
        this.afpLivsvarig = afpLivsvarig;
        this.afpKompensasjonstillegg = afpKompensasjonstillegg;
        this.afpKronetillegg = afpKronetillegg;
        this.afpOpptjening = afpOpptjening;
    }

    public AfpPrivatBeregning(AfpPrivatBeregning aAfpPrivatBeregning) {
        super(aAfpPrivatBeregning);
        if (aAfpPrivatBeregning.afpLivsvarig != null) {
            afpLivsvarig = new AfpLivsvarig(aAfpPrivatBeregning.afpLivsvarig);
        }
        if (aAfpPrivatBeregning.afpKompensasjonstillegg != null) {
            afpKompensasjonstillegg = new AfpKompensasjonstillegg(aAfpPrivatBeregning.afpKompensasjonstillegg);
        }
        if (aAfpPrivatBeregning.afpKronetillegg != null) {
            afpKronetillegg = new AfpKronetillegg(aAfpPrivatBeregning.afpKronetillegg);
        }
        if (aAfpPrivatBeregning.afpOpptjening != null) {
            afpOpptjening = new AfpOpptjening(aAfpPrivatBeregning.afpOpptjening);
        }
    }

    public AfpKompensasjonstillegg getAfpKompensasjonstillegg() {
        return afpKompensasjonstillegg;
    }

    public void setAfpKompensasjonstillegg(AfpKompensasjonstillegg afpKompensasjonstillegg) {
        this.afpKompensasjonstillegg = afpKompensasjonstillegg;
    }

    public AfpKronetillegg getAfpKronetillegg() {
        return afpKronetillegg;
    }

    public void setAfpKronetillegg(AfpKronetillegg afpKronetillegg) {
        this.afpKronetillegg = afpKronetillegg;
    }

    public AfpLivsvarig getAfpLivsvarig() {
        return afpLivsvarig;
    }

    public void setAfpLivsvarig(AfpLivsvarig afpLivsvarig) {
        this.afpLivsvarig = afpLivsvarig;
    }

    public AfpOpptjening getAfpOpptjening() {
        return afpOpptjening;
    }

    public void setAfpOpptjening(AfpOpptjening afpOpptjening) {
        this.afpOpptjening = afpOpptjening;
    }
}
