package no.nav.domain.pensjon.regler.beregning2011;

import java.io.Serializable;
import java.util.Date;

public class FremskrivingsDetaljer implements Serializable {
    private Date justeringTomDato;
    private double justeringsfaktor;
    private double teller;
    private double nevner;
    private int arskull;

}
