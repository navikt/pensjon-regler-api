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
     * Angir det sluttpoengtall som ordin�rt beregningsgrunnlag er omregnet fra.
     * Ang�r kun beregning av avd�de i sammenheng med nytt UT_GJT.
     */
    private double sluttpoengtall;


}
