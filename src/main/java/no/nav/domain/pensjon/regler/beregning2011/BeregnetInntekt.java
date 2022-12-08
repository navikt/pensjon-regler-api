package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;

public class BeregnetInntekt implements Serializable {


    /** Sum av ytelse og andre inntekter for relevant bruker. */
    private int forventetInntekt;

    /** Faktisk utbetalt ytelse og fremskrevet ytelse fra folketrygden ved virk
     * som inngår i avkortning av barnetillegg. */
    private double ytelseFolketrygd;

    /** Faktisk utbetalt ytelse og fremskrevet ytelse som ikke er en del av folketrygden
     * ved virk som inngår i avkortning av barnetillegg. Feks. AFP privat  */
    private double ytelseIkkeFolketrygd;

    /** Sum av relevante inntekter fra inntektskomponenten. */
    private double inntektIK;

    /** Høyeste av akkumulert arbeidsinntekt hittil i år og forventet arbeidsinntekt. */
    private double inntektArbeid;

    /** Høyeste av akkumulert andre ytelser hittil i år og forventet andre ytelser. */
    private double andreYtelser;



}
