package no.nav.service.pensjon.regler.to;


import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;

public class BeregnForsorgingstilleggResponse extends ServiceResponse {


    /**
     * Pakkseddel for beregningene.
     */
    private Pakkseddel pakkseddel = new Pakkseddel(true, true);

    /**
     * Kopi av Brukerens originale beregning tillagt eventuelt nye ytelseskomponenter.
     * Vil bli returnert som resultat dersom denne kommer inn som input.
     */
    private Beregning beregningSoker;

    /**
     * Det overordnete objektet som inneholder hele resultatet av beregningen tillagt eventuelt
     * nye ytelseskomponenter. Vil bli returnert som resultat dersom det ikke kom noen
     * type:Beregning som input.
     */
    private AbstraktBeregningsResultat beregningsResultatSoker;

}
