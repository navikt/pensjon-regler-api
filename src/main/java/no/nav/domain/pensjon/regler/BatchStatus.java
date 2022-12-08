package no.nav.domain.pensjon.regler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Beskriver resultatet for en g-omregning.
 * Hvert element i resultatlisten fra en g-omregning har en instans av dette objektet.
 * 
 * @author utvikler
 */
public class BatchStatus implements Serializable {


    private boolean statusOK;

    /**
     * Liste av merknader. Beskriver hvorfor g-omregningen feilet for det gjeldende objektet.
     * Dersom statusOK er true finnes ingen merknader.
     */
    protected List<Merknad> merknadListe;


}
