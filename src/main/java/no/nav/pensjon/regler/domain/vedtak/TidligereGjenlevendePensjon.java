package no.nav.pensjon.regler.domain.vedtak;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class TidligereGjenlevendePensjon extends AbstraktBeregningsvilkar {

    private static final long serialVersionUID = 6145199066378557700L;

    /**
     * Angir om bruker mottok GJP som f�lge av avd�des d�dsfall.
     */
    private boolean sokerMottokGJPForAvdod;

    /**
     * Angir om avd�de hadde inntekt p� minst 1G f�r d�dsfall
     */
    private boolean arligPGIMinst1G;

    public boolean isSokerMottokGJPForAvdod() {
        return sokerMottokGJPForAvdod;
    }

    public void setSokerMottokGJPForAvdod(boolean sokerMottokGJPForAvdod) {
        this.sokerMottokGJPForAvdod = sokerMottokGJPForAvdod;
    }

    public TidligereGjenlevendePensjon() {
        super();
    }

    public TidligereGjenlevendePensjon(TidligereGjenlevendePensjon tidligereGjenlevendePensjon) {
        super(tidligereGjenlevendePensjon);
        this.sokerMottokGJPForAvdod = tidligereGjenlevendePensjon.sokerMottokGJPForAvdod;
    }

    public boolean isArligPGIMinst1G() {
        return arligPGIMinst1G;
    }

    public void setArligPGIMinst1G(boolean arligPGIMinst1G) {
        this.arligPGIMinst1G = arligPGIMinst1G;
    }

    @Override
    public AbstraktBeregningsvilkar dypKopi(AbstraktBeregningsvilkar abstraktBeregningsvilkar) {
        TidligereGjenlevendePensjon tidligereGjenlevendePensjon = null;
        if(abstraktBeregningsvilkar.getClass() == TidligereGjenlevendePensjon.class) {
            tidligereGjenlevendePensjon = new TidligereGjenlevendePensjon((TidligereGjenlevendePensjon) abstraktBeregningsvilkar);
        }
        return tidligereGjenlevendePensjon;
    }
}
