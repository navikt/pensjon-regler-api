package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;

public class BeregnetInntekt implements Serializable {


    /** Sum av ytelse og andre inntekter for relevant bruker. */
    private int forventetInntekt;

    /** Faktisk utbetalt ytelse og fremskrevet ytelse fra folketrygden ved virk
     * som inng�r i avkortning av barnetillegg. */
    private double ytelseFolketrygd;

    /** Faktisk utbetalt ytelse og fremskrevet ytelse som ikke er en del av folketrygden
     * ved virk som inng�r i avkortning av barnetillegg. Feks. AFP privat  */
    private double ytelseIkkeFolketrygd;

    /** Sum av relevante inntekter fra inntektskomponenten. */
    private double inntektIK;

    /** H�yeste av akkumulert arbeidsinntekt hittil i �r og forventet arbeidsinntekt. */
    private double inntektArbeid;

    /** H�yeste av akkumulert andre ytelser hittil i �r og forventet andre ytelser. */
    private double andreYtelser;



}
