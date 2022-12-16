package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.FormelKodeCti;

import java.io.Serializable;

/**
 * @author Aasmund Nordstoga (Accenture) PK-5549
 */
public class Overgangsbelop implements Serializable {



    private FormelKodeCti formelKode;

    private int gpBrutto;

    private double gpSats;

    private double overgangsbelop;

    private int stBrutto;

    private int tpBrutto;

}
