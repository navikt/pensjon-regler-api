package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.grunnlag.Beholdninger;
import no.nav.pensjon.regler.domain.trygdetid.Brok;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ørnulf Moen (Decisive), Pensjonsprosjektet
 * @author Lars Hartvigsen (Decisive), PK-9169
 * @author Tatyana Lochehina PK-9502
 */
public class AldersberegningKapittel20 extends Beregning2011 {
    private static final long serialVersionUID = 2374125061527454385L;

    private double delingstall;
    private Beholdninger beholdninger;
    private PensjonUnderUtbetaling pensjonUnderUtbetaling;
    private List<FtDtArsak> dtBenyttetArsakListe;

    /**
     * De faktiske beholdningene som ble brukt i beregningen ved førstegangsuttaket
     */
    private Beholdninger beholdningerForForsteuttak;

    /**
     * Anvendt proratabrøk i trygdeavtaleberegninger.
     */
    private Brok prorataBrok;

    private String PREG_avtaleBeregningsmetode;

    public AldersberegningKapittel20() {
        super();
        dtBenyttetArsakListe = new ArrayList<FtDtArsak>();
    }

    public AldersberegningKapittel20(AldersberegningKapittel20 b) {
        super(b);
        delingstall = b.delingstall;
        if (b.beholdninger != null) {
            beholdninger = new Beholdninger(b.beholdninger);
        }
        if (b.dtBenyttetArsakListe != null) {
            dtBenyttetArsakListe = new ArrayList<>();
            for (FtDtArsak ftdt : b.dtBenyttetArsakListe) {
                dtBenyttetArsakListe.add(new FtDtArsak(ftdt));
            }
        }
        if (b.beholdningerForForsteuttak != null) {
            beholdningerForForsteuttak = new Beholdninger(b.beholdningerForForsteuttak);
        }
        prorataBrok = b.prorataBrok;
        pensjonUnderUtbetaling = b.pensjonUnderUtbetaling;
        PREG_avtaleBeregningsmetode = b.PREG_avtaleBeregningsmetode;
    }

    public double getDelingstall() {
        return delingstall;
    }

    public void setDelingstall(double delingstall) {
        this.delingstall = delingstall;
    }

    public Beholdninger getBeholdninger() {
        return beholdninger;
    }

    public void setBeholdninger(Beholdninger beholdninger) {
        this.beholdninger = beholdninger;
    }

    public List<FtDtArsak> getDtBenyttetArsakListe() {
        return dtBenyttetArsakListe;
    }

    public void setDtBenyttetArsakListe(List<FtDtArsak> dtBenyttetArsakListe) {
        this.dtBenyttetArsakListe = dtBenyttetArsakListe;
    }

    public FtDtArsak[] getDtBenyttetArsakListeAsArray() {
        return dtBenyttetArsakListe != null ? dtBenyttetArsakListe.toArray(new FtDtArsak[dtBenyttetArsakListe.size()]) : new FtDtArsak[0];
    }

    public Beholdninger getBeholdningerForForsteuttak() {
        return beholdningerForForsteuttak;
    }

    public void setBeholdningerForForsteuttak(Beholdninger beholdningerForForsteuttak) {
        this.beholdningerForForsteuttak = beholdningerForForsteuttak;
    }

    public Brok getProrataBrok() {
        return prorataBrok;
    }

    public void setProrataBrok(Brok prorataBrok) {
        this.prorataBrok = prorataBrok;
    }

    public PensjonUnderUtbetaling getPensjonUnderUtbetaling() {
        return pensjonUnderUtbetaling;
    }

    public void setPensjonUnderUtbetaling(PensjonUnderUtbetaling pensjonUnderUtbetaling) {
        this.pensjonUnderUtbetaling = pensjonUnderUtbetaling;
    }

    public String getPREG_avtaleBeregningsmetode() {
        return PREG_avtaleBeregningsmetode;
    }

    public void setPREG_avtaleBeregningsmetode(String PREG_avtaleBeregningsmetode) {
        this.PREG_avtaleBeregningsmetode = PREG_avtaleBeregningsmetode;
    }
}
