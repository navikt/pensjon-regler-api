package no.nav.pensjon.regler.domain.beregning2011;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ørnulf Moen, Decisive, Pensjonsprosjektet
 * @author Lars Hartvigsen (Decisive) - PK-12169 HL3 2015
 * @author Magnus Bakken (Accenture), PK-20716
 */

public class AldersberegningKapittel19 extends Beregning2011 {
    private static final long serialVersionUID = -3021189432802198099L;

    private Basispensjon restpensjon;
    private Basispensjon basispensjon;

    /**
     * Basispensjon regnet uten gjenlevenderettighet.
     */
    private Basispensjon basispensjonUtenGJR;

    /**
     * Restpensjon regnet uten gjenlevenderettighet.
     */
    private Basispensjon restpensjonUtenGJR;

    private double forholdstall;
    private List<FtDtArsak> ftBenyttetArsakListe;

    public AldersberegningKapittel19() {
        super();
        ftBenyttetArsakListe = new ArrayList<FtDtArsak>();
    }

    public AldersberegningKapittel19(AldersberegningKapittel19 b) {
        super(b);

        if (b.restpensjon != null) {
            restpensjon = new Basispensjon(b.restpensjon);
        }
        if (b.basispensjon != null) {
            basispensjon = new Basispensjon(b.basispensjon);
        }
        if (b.restpensjonUtenGJR != null) {
            restpensjonUtenGJR = new Basispensjon(b.restpensjonUtenGJR);
        }
        if (b.basispensjonUtenGJR != null) {
            basispensjonUtenGJR = new Basispensjon(b.basispensjonUtenGJR);
        }
        forholdstall = b.forholdstall;
        if (b.ftBenyttetArsakListe != null) {
            ftBenyttetArsakListe = new ArrayList<FtDtArsak>();
            for(FtDtArsak ftdt:b.ftBenyttetArsakListe) {
                ftBenyttetArsakListe.add(new FtDtArsak(ftdt));
            }
        }
    }

    public Basispensjon getRestpensjon() {
        return restpensjon;
    }

    public void setRestpensjon(Basispensjon restpensjon) {
        this.restpensjon = restpensjon;
    }

    public Basispensjon getBasispensjon() {
        return basispensjon;
    }

    public void setBasispensjon(Basispensjon basispensjon) {
        this.basispensjon = basispensjon;
    }

    public Basispensjon getRestpensjonUtenGJR() {
        return restpensjonUtenGJR;
    }

    public void setRestpensjonUtenGJR(Basispensjon restpensjonUtenGJR) {
        this.restpensjonUtenGJR = restpensjonUtenGJR;
    }

    public Basispensjon getBasispensjonUtenGJR() {
        return basispensjonUtenGJR;
    }

    public void setBasispensjonUtenGJR(Basispensjon basispensjonUtenGJR) {
        this.basispensjonUtenGJR = basispensjonUtenGJR;
    }

    public double getForholdstall() {
        return forholdstall;
    }

    public void setForholdstall(double forholdstall) {
        this.forholdstall = forholdstall;
    }

    public List<FtDtArsak> getFtBenyttetArsakListe() {
        return ftBenyttetArsakListe;
    }

    public void setFtBenyttetArsakListe(List<FtDtArsak> ftBenyttetArsakListe) {
        this.ftBenyttetArsakListe = ftBenyttetArsakListe;
    }
}
