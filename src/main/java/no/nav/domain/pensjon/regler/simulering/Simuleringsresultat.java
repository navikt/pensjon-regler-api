package no.nav.domain.pensjon.regler.simulering;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.kode.VilkarsvedtakResultatCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hele resultatet av en simulering.
 */
public class Simuleringsresultat implements Serializable {

    /**
     * Status på vedtaket
     */
    private VilkarsvedtakResultatCti status;

    /**
     * Beregningen
     */
    private Beregning beregning;

    /**
     * Virkningstidspunkt
     */
    private Date virk;

    /**
     * Liste av merknader
     */
    private List<Merknad> merknadListe;


}
