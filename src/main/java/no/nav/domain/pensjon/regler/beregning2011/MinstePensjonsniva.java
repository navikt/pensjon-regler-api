package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.MinstepenNivaCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Kopi av PEN 28/8/2009 - ruller tilbake til PREG domenemodell
 * 
 * @author Ørnulf Moen
 */

public class MinstePensjonsniva implements Serializable {
    

    private double belop;
    private double sats;
    private int benyttetYug;
    private int pro_rata_teller_mnd;
    private int pro_rata_nevner_mnd;
    private double pro_rata_brok;
    private FormelKodeCti formelKode;

    /** Minstepensjonsnivå. Kan være lav, ordinær og forhøyet. Benytter tabellen */
    private MinstepenNivaCti satsType;

    private List<Merknad> merknadListe = new ArrayList<Merknad>();

    private double PREG_belopIkkeProratisert;
    private int faktisk_tt_avtaleland_mnd;

    public MinstePensjonsniva() {
        super();
        setFormelKode(new FormelKodeCti("MPNx"));
    }

}
