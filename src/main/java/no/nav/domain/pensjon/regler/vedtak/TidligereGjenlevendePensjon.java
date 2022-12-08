package no.nav.domain.pensjon.regler.vedtak;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class TidligereGjenlevendePensjon extends AbstraktBeregningsvilkar {

    /**
     * Angir om bruker mottok GJP som f�lge av avd�des d�dsfall.
     */
    private boolean sokerMottokGJPForAvdod;

    /**
     * Angir om avd�de hadde inntekt p� minst 1G f�r d�dsfall
     */
    private boolean arligPGIMinst1G;


}
