package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.FormelKodeCti;

import java.io.Serializable;

/**
 * @author Aasmund Nordstoga (Accenture) PK-5549
 */
public class Skattekompensertbelop implements Serializable {

    

    private double faktor;

    private FormelKodeCti formelKode;

    private double arsbelop;

    private Justertbelop justertbelop;

    private double tillegg;


}
