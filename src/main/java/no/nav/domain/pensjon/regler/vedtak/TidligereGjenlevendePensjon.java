package no.nav.domain.pensjon.regler.vedtak;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class TidligereGjenlevendePensjon extends AbstraktBeregningsvilkar {

    /**
     * Angir om bruker mottok GJP som følge av avdødes dødsfall.
     */
    private boolean sokerMottokGJPForAvdod;

    /**
     * Angir om avdøde hadde inntekt på minst 1G før dødsfall
     */
    private boolean arligPGIMinst1G;


}
