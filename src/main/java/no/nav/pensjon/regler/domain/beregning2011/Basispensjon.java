package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.kode.FormelKodeCti;

import java.io.Serializable;

/**
 * Kopi av PEN 28/8/2009 - ruller tilbake til PREG domenemodell
 * 
 * @author Ørnulf Moen
 */

public class Basispensjon implements Serializable {
    private static final long serialVersionUID = 3847817774769851489L;

    /** Utgjør summen av basisgrunnpensjon, basistilleggspensjon og i basispensjonstillegg. */
    private double totalbelop;

    /** Basisgrunnpensjon slik det er definert i nytt regelverk på gammel opptjening (kapittel 19). */
    private BasisGrunnpensjon gp;

    /** Basistilleggspensjon slik det er definert i nytt regelverk på gammel opptjening (kapittel 19). */
    private BasisTilleggspensjon tp;

    /** Basispensjonstillegg slik det er definert i nytt regelverk på gammel opptjening (kapittel 19). */
    private BasisPensjonstillegg pt;

    /** Formelkode kun for bruk for restpensjon **/
    private FormelKodeCti formelKode;

    public Basispensjon() {
        super();
        setFormelKode(new FormelKodeCti("ResPx"));
    }

    public Basispensjon(Basispensjon bp) {
        this();
        totalbelop = bp.totalbelop;
        if (bp.gp != null) {
            gp = new BasisGrunnpensjon(bp.gp);
        }
        if (bp.tp != null) {
            tp = new BasisTilleggspensjon(bp.tp);
        }
        if (bp.pt != null) {
            pt = new BasisPensjonstillegg(bp.pt);
        }
        if (bp.formelKode != null) {
            formelKode = new FormelKodeCti(bp.formelKode.getKode());
        }
    }

    public BasisGrunnpensjon getGp() {
        return gp;
    }

    public void setGp(BasisGrunnpensjon gp) {
        this.gp = gp;
    }

    public BasisPensjonstillegg getPt() {
        return pt;
    }

    public void setPt(BasisPensjonstillegg pt) {
        this.pt = pt;
    }

    public double getTotalbelop() {
        return totalbelop;
    }

    public void setTotalbelop(double totalbelop) {
        this.totalbelop = totalbelop;
    }

    public BasisTilleggspensjon getTp() {
        return tp;
    }

    public void setTp(BasisTilleggspensjon tp) {
        this.tp = tp;
    }

    public FormelKodeCti getFormelKode() {
        return formelKode;
    }

    public void setFormelKode(FormelKodeCti formelKode) {
        this.formelKode = formelKode;
    }

}
