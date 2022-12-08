package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

/**
 * @author Ingleiv Johansen (Accenture) - PK-7250
 * @author Lars Hartvigsen (Decisive) - PK-20946
 */
public class BarnetilleggSerkullsbarnUT extends AbstraktBarnetilleggUT implements Serializable {

	/**
     * Brukers gjenlevendetillegg før justering.
     */
    private int brukersGjenlevendetilleggForJustering;

    public BarnetilleggSerkullsbarnUT() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_TSB");
        setFormelKode(new FormelKodeCti("BTx"));
    }

}
