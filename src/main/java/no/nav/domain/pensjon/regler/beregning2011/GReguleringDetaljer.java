package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;
import java.util.Date;

public class GReguleringDetaljer implements Serializable {

    private Date justeringTomDato;
    private double justeringsfaktor;
    private int forrigeG;
    private int gjeldendeG;

}
