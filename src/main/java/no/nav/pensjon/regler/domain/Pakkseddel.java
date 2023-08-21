package no.nav.pensjon.regler.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Denne klassen representerer en pakkseddel som leveres sammen med resultatet
 * fra en regeltjeneste.
 */
public class Pakkseddel implements Serializable {

    private static final long serialVersionUID = -8620468253527033228L;
    /**
     * Angir en totalvurdering for innholdet i resultatet som returneres.
     * Dersom <code>resultatOK</code> er <code>true</code> betyr dette at PREG anser resultatet som fullstendig,
     * og kan brukes videre i prosessflyten. <code>false</code> betyr at PREG anser resultatet som ufullstendig, og at det må
     * sendes til saksbehandler for manuell behandling.
     * For PEN vil resultatOK brukes til å avgjøre om resultatet skal lagres eller ikke.
     */
    private boolean kontrollTjenesteOk = true;

    private boolean annenTjenesteOk = true;
    /**
     * Liste av merknader. Beskriver hvordan PREG kom frem til <code>kontrollTjenesteOk</code>.
     */
    protected List<Merknad> merknadListe = new ArrayList<Merknad>();

    /**
     * Hvilken versjon av PREG som er i bruk.
     */
    private String PREG_version;

    /**
     * Hvilken type testsatstabell som er i bruk.
     */
    private String PREG_TestSatstabellType;

    /**
     * Hvilken versjon av satstabeller som er i bruk.
     */
    private String PREG_satstabellVersion;


    public Pakkseddel(boolean kontrollTjenesteOk, boolean annenTjenesteOk) {
        this();
        this.kontrollTjenesteOk = kontrollTjenesteOk;
        this.annenTjenesteOk = annenTjenesteOk;
    }

    public Pakkseddel() {
        super();
    }

    public Pakkseddel(Pakkseddel pakkseddel) {
        super();
        kontrollTjenesteOk = pakkseddel.kontrollTjenesteOk;
        annenTjenesteOk = pakkseddel.annenTjenesteOk;
        PREG_version = pakkseddel.PREG_version;
        PREG_TestSatstabellType = pakkseddel.PREG_TestSatstabellType;
        PREG_satstabellVersion = pakkseddel.PREG_satstabellVersion;
        if (pakkseddel.merknadListe != null) {
            for (Merknad merknad : pakkseddel.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    public boolean isAnnenTjenesteOk() {
        return annenTjenesteOk;
    }

    public void setAnnenTjenesteOk(boolean annenTjenesteOk) {
        this.annenTjenesteOk = annenTjenesteOk;
    }

    public boolean isKontrollTjenesteOk() {
        return kontrollTjenesteOk;
    }

    public void setKontrollTjenesteOk(boolean kontrollTjenesteOk) {
        this.kontrollTjenesteOk = kontrollTjenesteOk;
    }

    public String getPREG_version() {
        return PREG_version;
    }

    public void setPREG_version(String PREG_version) {
        this.PREG_version = PREG_version;
    }

    public String getPREG_TestSatstabellType() {
        return PREG_TestSatstabellType;
    }

    public void setPREG_TestSatstabellType(String PREG_TestSatstabellType) {
        this.PREG_TestSatstabellType = PREG_TestSatstabellType;
    }

    public String getPREG_satstabellVersion() {
        return PREG_satstabellVersion;
    }

    public void setPREG_satstabellVersion(String PREG_satstabellVersion) {
        this.PREG_satstabellVersion = PREG_satstabellVersion;
    }
}
