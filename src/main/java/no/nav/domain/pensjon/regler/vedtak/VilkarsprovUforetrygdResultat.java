package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;

/**
 * @author Magnus Bakken (Accenture), PK-10597
 */
public class VilkarsprovUforetrygdResultat extends AbstraktVilkarsprovResultat {

    /**
     * Beregning av uf�retrygden ved vilk�rspr�ving av halv minsteytelse.
     */
    private BeregningsresultatUforetrygd beregningsresultatUforetrygd;

    /**
     * Beregnet halv minsteytelse;
     */
    private int halvMinsteytelse;

}
