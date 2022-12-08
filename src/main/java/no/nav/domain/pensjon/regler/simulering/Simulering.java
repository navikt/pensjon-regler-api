/*
 * Created on Jan 10, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package no.nav.domain.pensjon.regler.simulering;

import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.kode.AfpOrdningTypeCti;
import no.nav.domain.pensjon.regler.kode.SimuleringTypeCti;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Simulering
 */
public class Simulering implements Serializable {

    

    /**
     * Type simulering
     */
    private SimuleringTypeCti simuleringType;

    /**
     * Type AFP ordning
     */
    private AfpOrdningTypeCti afpOrdning;

    /**
     * Dato for når bruker ønsker å simulere uttak av pensjon fra.
     */
    private Date uttaksdato;

    /**
     * Liste av tilknyttede personer.
     */
    private List<Persongrunnlag> persongrunnlagListe;

    private List<VilkarsVedtak> vilkarsvedtakliste;

}
