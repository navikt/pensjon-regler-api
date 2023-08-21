package no.nav.pensjon.regler.domain.beregning2011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeregningsgrunnlagOrdiner extends AbstraktBeregningsgrunnlag {

    private static final long serialVersionUID = 8408663631045755322L;


    private List<OpptjeningUT> opptjeningUTListe;


    private int nasjonaltSnitt;

    /**
     * Angir det sluttpoengtall som ordinært beregningsgrunnlag er omregnet fra.
     * Angår kun beregning av avdøde i sammenheng med nytt UT_GJT.
     */
    private double sluttpoengtall;

    public BeregningsgrunnlagOrdiner() {
        super();
        opptjeningUTListe = new ArrayList<OpptjeningUT>();
    }

    public BeregningsgrunnlagOrdiner(BeregningsgrunnlagOrdiner beregningsgrunnlagOrdinaer) {
        super(beregningsgrunnlagOrdinaer);
        opptjeningUTListe = new ArrayList<OpptjeningUT>();
        nasjonaltSnitt = beregningsgrunnlagOrdinaer.nasjonaltSnitt;
        this.sluttpoengtall = beregningsgrunnlagOrdinaer.sluttpoengtall;
        if (beregningsgrunnlagOrdinaer.opptjeningUTListe != null) {
            for (OpptjeningUT opptjeningUT : beregningsgrunnlagOrdinaer.opptjeningUTListe) {
                opptjeningUTListe.add(new OpptjeningUT(opptjeningUT));
            }
        }
    }

    public List<OpptjeningUT> getOpptjeningUTListe() {
        return opptjeningUTListe;
    }

    public void setOpptjeningUTListe(List<OpptjeningUT> opptjeningUTListe) {
        this.opptjeningUTListe = opptjeningUTListe;
    }

    public int getNasjonaltSnitt() {
        return nasjonaltSnitt;
    }

    public void setNasjonaltSnitt(int nasjonaltSnitt) {
        this.nasjonaltSnitt = nasjonaltSnitt;
    }

    public double getSluttpoengtall() {
        return sluttpoengtall;
    }

    public void setSluttpoengtall(double sluttpoengtall) {
        this.sluttpoengtall = sluttpoengtall;
    }
}
