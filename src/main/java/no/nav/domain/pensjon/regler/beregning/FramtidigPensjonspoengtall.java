package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.Merknad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        poengtallListe = new ArrayList<Poengtall>();
        if (framtidigPensjonspoengtall.poengtallListe != null) {
            for (Poengtall poengtall : framtidigPensjonspoengtall.poengtallListe) {
                poengtallListe.add(new Poengtall(poengtall));
            }
        }
        merknadListe = new ArrayList<Merknad>();
        if (framtidigPensjonspoengtall.merknadListe != null) {
            for (Merknad merknad : framtidigPensjonspoengtall.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
    }

    public FramtidigPensjonspoengtall() {
        super();
        poengtallListe = new ArrayList<Poengtall>();
        merknadListe = new ArrayList<Merknad>();
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
     * @deprecated
     * @return Returns the pt as array.
     */
    @Deprecated
    public Poengtall[] retrievePoengtallListeAsArray() {
        return poengtallListe.toArray(new Poengtall[0]);
    }

    /**
     * Read only property for poengtallListe as array.
     * 
     * @return array of Poengtall
     */
    public Poengtall[] getPoengtallListeAsArray() {
        return poengtallListe != null ? poengtallListe.toArray(new Poengtall[poengtallListe.size()]) : new Poengtall[0];
    }

    /**
     * @deprecated
     * @return Returns the pt as array, sorted by poeng (pp).
     */
    @Deprecated
    public Poengtall[] retrieveSortertPoengtallListeAsArray() {
        ArrayList<Poengtall> sortedPt = new ArrayList<Poengtall>(poengtallListe);
        Collections.sort(sortedPt, Collections.reverseOrder());
        return sortedPt.toArray(new Poengtall[0]);
    }

    /**
     * Read only property for poengtallListe as sorted array.
     * 
     * @return array of Poengtall, sorted by poeng (pp).
     */
    public Poengtall[] getSortertPoengtallListeAsArray() {
        if (poengtallListe != null) {
            ArrayList<Poengtall> sortedPt = new ArrayList<Poengtall>(poengtallListe);
            Collections.sort(sortedPt, Collections.reverseOrder());
            return sortedPt.toArray(new Poengtall[sortedPt.size()]);
        } else {
            return new Poengtall[0];
        }
    }

    public Poengtall[] poengtallListeSortertPaaPoengaar(){
        if (poengtallListe != null) {
            List<Poengtall> poengtallList = new ArrayList<Poengtall>(poengtallListe);
            Comparator<Poengtall> comparator = (p1, p2) -> {
                if (p2.getAr() == p1.getAr()) {
                    return 0;
                } else if (p2.getAr() < p1.getAr()) {
                    return -1;
                } else {
                    return 1;
                }
            };
            Collections.sort(poengtallList, comparator);
            return poengtallList.toArray(new Poengtall[poengtallList.size()]);
        } else {
            return new Poengtall[0];
        }
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
     * @deprecated
     * @return Returns the merknad as array.
     */
    @Deprecated
    public Merknad[] retrieveMerknadListeAsArray() {
        return merknadListe.toArray(new Merknad[0]);
    }

    /**
     * Read only property for merknadListe.
     * 
     * @return array of Merknad
     */
    public Merknad[] getMerknadListeAsArray() {
        return merknadListe != null ? merknadListe.toArray(new Merknad[merknadListe.size()]) : new Merknad[0];
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     * 
     * @return a <code>String</code> representation
     *         of this object.
     */
    @Override
    public String toString() {
        final String TAB = "    ";

        StringBuilder retValue = new StringBuilder();

        retValue.append("FramtidigPensjonspoengtall ( ").append(super.toString()).append(TAB).append("pt = ").append(pt).append(TAB).append("poengtallListe = ")
                .append(poengtallListe).append(TAB).append("merknadListe = ").append(merknadListe).append(TAB).append(" )");

        return retValue.toString();
    }

}
