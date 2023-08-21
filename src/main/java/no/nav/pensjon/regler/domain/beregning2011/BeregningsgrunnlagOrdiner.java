package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class BeregningsgrunnlagOrdiner extends AbstraktBeregningsgrunnlag {

    private static final long serialVersionUID = 8408663631045755322L;

    @GuiPrompt(prompt = "Opptjening uf�retrygd")
    private List<OpptjeningUT> opptjeningUTListe;

    @GuiPrompt(prompt = "Nasjonalt snitt")
    private int nasjonaltSnitt;

    /**
     * Angir det sluttpoengtall som ordin�rt beregningsgrunnlag er omregnet fra.
     * Ang�r kun beregning av avd�de i sammenheng med nytt UT_GJT.
     */
    @GuiPrompt(prompt = "Sluttpoengtall som ordin�rt beregningsgrunnlag er omregnet fra")
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

    public OpptjeningUT[] getOpptjeningUTListeAsArray() {
        return opptjeningUTListe != null ? opptjeningUTListe.toArray(new OpptjeningUT[opptjeningUTListe.size()]) : new OpptjeningUT[0];
    }

    public OpptjeningUT[] retrieveOpptjeningUTListeAsArray() {
        return getOpptjeningUTListeAsArray();
    }

    /**
     * Returnerer array med OpptjeningUT sortert med st�rste f�rst etter:
     * 1. avkortetBelop
     * 2. �r
     * Original liste blir ikke endret.
     * 
     * @return
     */
    public OpptjeningUT[] sortertOpptjeningUTListeAsArray() {
        ArrayList<OpptjeningUT> sortertOpptjeningUTListe = new ArrayList<OpptjeningUT>(opptjeningUTListe);
        Collections.sort(sortertOpptjeningUTListe);
        return sortertOpptjeningUTListe.toArray(new OpptjeningUT[sortertOpptjeningUTListe.size()]);
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
