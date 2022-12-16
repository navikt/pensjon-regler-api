package no.nav.domain.pensjon.regler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Denne klassen representerer en pakkseddel som leveres sammen med resultatet
 * fra en regeltjeneste.
 */
public class Pakkseddel implements Serializable {


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

    public Pakkseddel(boolean kontrollTjenesteOk, boolean annenTjenesteOk) {
        this.kontrollTjenesteOk = kontrollTjenesteOk;
        this.annenTjenesteOk = annenTjenesteOk;
    }

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

}
