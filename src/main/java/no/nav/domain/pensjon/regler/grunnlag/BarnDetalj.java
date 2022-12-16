package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.PenPerson;

import java.io.Serializable;
import java.util.Date;

public class BarnDetalj implements Serializable {

    
    /**
     * Angir barnets andre forelder enn søker.
     */
    private PenPerson annenForelder;
    /**
     * Angir om barnet bor med en begge foreldre.
     * "true" betyr fellesbarn, "false" betyr særkullsbarn.
     */
    private boolean borMedBeggeForeldre;
    /**
     * Fra-og-med dato for når barnet bor sammen med begge foreldrene.
     */
    private Date borFomDato;
    /**
     * Til-og-med dato for når barnet bor sammen med begge foreldrene.
     */
    private Date borTomDato;

    /**
     * Angir om barnet har hatt inntekt over 1G.
     */
    private boolean inntektOver1G;
    /**
     * Angir hvorvidt barnet er under utdanning.
     */
    private boolean underUtdanning;

}
