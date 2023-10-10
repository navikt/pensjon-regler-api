package no.nav.pensjon.regler.domain.vedtak

import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd

class VilkarsprovUforetrygdResultat : AbstraktVilkarsprovResultat() {
    /**
     * Beregning av uføretrygden ved vilkårsprøving av halv minsteytelse.
     */
    var beregningsresultatUforetrygd: BeregningsresultatUforetrygd? = null

    /**
     * Beregnet halv minsteytelse;
     */
    var halvMinsteytelse = 0

}