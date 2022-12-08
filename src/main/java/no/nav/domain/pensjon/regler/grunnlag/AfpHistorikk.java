package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.AfpOrdningTypeCti;

import java.io.Serializable;
import java.util.Date;

public class AfpHistorikk implements Serializable {

    /**
     * Fremtidig pensjonspoeng
     */
    private double afpFpp;

    private Date virkFom;

    private Date virkTom;

    private int afpPensjonsgrad;

    private AfpOrdningTypeCti afpOrdning;

}
