package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.Merknad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Framtidig pensjonspoengtall.
 * Brukes ved beregning av uførepensjon,gjenlevendepensjon og AFP.
 */
public class FramtidigPensjonspoengtall implements Serializable {

    private static final long serialVersionUID = -7599496235848708292L;

    /**
     * Poengtallet
     */
    private double pt;
    /**
     * Poengtallene som ligger til grunn for poengtallet.
     */
    private List<Poengtall> poengtallListe;
    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;
    /**
     * Omregnet poengtall etter 1991. Intern PREG variabel.
     */
    private double PREG_pt_e91;

    /**
     * Copy Constructor
     *
     * @param framtidigPensjonspoengtall a <code>FramtidigPensjonspoengtall</code> object
     */
    public FramtidigPensjonspoengtall(FramtidigPensjonspoengtall framtidigPensjonspoengtall) {
        pt = framtidigPensjonspoengtall.pt;
        poengtallListe = new ArrayList<>();
        if (framtidigPensjonspoengtall.poengtallListe != null) {
            for (Poengtall poengtall : framtidigPensjonspoengtall.poengtallListe) {
                poengtallListe.add(new Poengtall(poengtall));
            }
        }
        merknadListe = new ArrayList<>();
        if (framtidigPensjonspoengtall.merknadListe != null) {
            for (Merknad merknad : framtidigPensjonspoengtall.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
    }

    public FramtidigPensjonspoengtall() {
        super();
        poengtallListe = new ArrayList<>();
        merknadListe = new ArrayList<>();
    }

    public FramtidigPensjonspoengtall(double poengtall, List<Poengtall> poengtallListe) {
        super();
        pt = poengtall;
        this.poengtallListe = poengtallListe;
    }

    public double getPt() {
        return pt;
    }

    public void setPt(double poengtall) {
        pt = poengtall;
    }

    public double getPREG_pt_e91() {
        return PREG_pt_e91;
    }

    public void setPREG_pt_e91(double preg_pt_e91) {
        PREG_pt_e91 = preg_pt_e91;
    }

    public List<Poengtall> getPoengtallListe() {
        return poengtallListe;
    }

    public void setPoengtallListe(List<Poengtall> poengtallListe) {
        this.poengtallListe = poengtallListe;
    }

    /**
     * @return Returns the merknad.
     */
    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    /**
     * @param merknad The merknad to set.
     */
    public void setMerknadListe(List<Merknad> merknad) {
        merknadListe = merknad;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation
     * of this object.
     */
    @Override
    public String toString() {
        final String TAB = "    ";

        return "FramtidigPensjonspoengtall ( " + super.toString() + TAB + "pt = " + pt + TAB + "poengtallListe = " +
                poengtallListe + TAB + "merknadListe = " + merknadListe + TAB + " )";
    }

}
