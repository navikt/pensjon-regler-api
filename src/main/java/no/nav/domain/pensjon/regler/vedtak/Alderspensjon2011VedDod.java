package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.kode.YtelseVedDodCti;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class Alderspensjon2011VedDod extends AbstraktBeregningsvilkar {

    private static final long serialVersionUID = 8391493933135735409L;

    /**
     * Angir hvilken ytelse avdøde hadde før død.
     */
    private YtelseVedDodCti ytelseVedDod;

    public Alderspensjon2011VedDod() {
        super();
    }

    public Alderspensjon2011VedDod(Alderspensjon2011VedDod alderspensjon2011VedDod) {
        super(alderspensjon2011VedDod);
        if (alderspensjon2011VedDod.ytelseVedDod != null){
            this.ytelseVedDod = new YtelseVedDodCti(alderspensjon2011VedDod.ytelseVedDod);
        }
    }

    public YtelseVedDodCti getYtelseVedDod() {
        return ytelseVedDod;
    }

    public void setYtelseVedDod(YtelseVedDodCti ytelseVedDod) {
        this.ytelseVedDod = ytelseVedDod;
    }

    @Override
    public AbstraktBeregningsvilkar dypKopi(AbstraktBeregningsvilkar abstraktBeregningsvilkar) {
        Alderspensjon2011VedDod alderspensjon2011VedDod = null;
        if(abstraktBeregningsvilkar.getClass() == Alderspensjon2011VedDod.class) {
            alderspensjon2011VedDod = new Alderspensjon2011VedDod((Alderspensjon2011VedDod) abstraktBeregningsvilkar);
        }
        return alderspensjon2011VedDod;
    }
}
