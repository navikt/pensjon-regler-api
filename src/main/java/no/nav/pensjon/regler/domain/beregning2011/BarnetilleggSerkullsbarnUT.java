package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

import java.io.Serializable;

/**
 * @author Ingleiv Johansen (Accenture) - PK-7250
 * @author Lars Hartvigsen (Decisive) - PK-20946
 */
public class BarnetilleggSerkullsbarnUT extends AbstraktBarnetilleggUT implements Serializable {

    private static final long serialVersionUID = -2197770710503560569L;
	
	/**
     * Brukers gjenlevendetillegg før justering.
     */
	// @GuiPrompt(prompt = "Brukers gjenlevendetillegg")
    private int brukersGjenlevendetilleggForJustering;

    public BarnetilleggSerkullsbarnUT() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("UT_TSB");
        setFormelKode(new FormelKodeCti("BTx"));
		
    }

    /**
     * Copy Constructor
     * 
     * @param barnetilleggFellesbarnUT an instance of {@link BarnetilleggSerkullsbarnUT} to copy values from
     */
    public BarnetilleggSerkullsbarnUT(BarnetilleggSerkullsbarnUT barnetilleggFellesbarnUT) {
        super(barnetilleggFellesbarnUT);
		brukersGjenlevendetilleggForJustering = barnetilleggFellesbarnUT.brukersGjenlevendetilleggForJustering;
		
    }
	
	public int getBrukersGjenlevendetilleggForJustering() {
		return brukersGjenlevendetilleggForJustering;
    }
	
	public void setBrukersGjenlevendetilleggForJustering(int brukersGjenlevendetilleggForJustering) {
       this.brukersGjenlevendetilleggForJustering = brukersGjenlevendetilleggForJustering;
    }
}
