package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.List;


import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.InntektsberegningsResultat;
import no.nav.domain.pensjon.regler.vedtak.AbstraktBeregningsvilkar;
import no.nav.domain.pensjon.regler.vedtak.InntektEtterUforhet;
import no.nav.domain.pensjon.regler.vedtak.InntektForUforhet;
import no.nav.domain.pensjon.regler.vedtak.Uforegrad;
import no.nav.domain.pensjon.regler.vedtak.Uforetidspunkt;

/**
 * @author Magnus Bakken (Accenture), PK-9491
 * @author Lars Hartviksen (Decisive), PK-7048
 */
public class BeslutningsstotteResponse extends ServiceResponse {


    private List<AbstraktBeregningsvilkar> beregningsvilkarListe;

    private Pakkseddel pakkseddel;

    /** Resultat av beregning av forventet inntekt */
    private InntektsberegningsResultat inntektsberegningsResultat;

}
