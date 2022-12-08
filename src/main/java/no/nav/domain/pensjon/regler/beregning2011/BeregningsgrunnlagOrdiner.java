package no.nav.domain.pensjon.regler.beregning2011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class BeregningsgrunnlagOrdiner extends AbstraktBeregningsgrunnlag {

    

    private List<OpptjeningUT> opptjeningUTListe;

    private int nasjonaltSnitt;

    /**
     * Angir det sluttpoengtall som ordinært beregningsgrunnlag er omregnet fra.
     * Angår kun beregning av avdøde i sammenheng med nytt UT_GJT.
     */
    private double sluttpoengtall;


}
