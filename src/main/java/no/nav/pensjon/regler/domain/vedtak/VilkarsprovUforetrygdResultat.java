package no.nav.pensjon.regler.domain.vedtak;

import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd;

/**
 * @author Magnus Bakken (Accenture), PK-10597
 */
public class VilkarsprovUforetrygdResultat extends AbstraktVilkarsprovResultat {

    private static final long serialVersionUID = 1724250925176675170L;

    /**
     * Beregning av uf�retrygden ved vilk�rspr�ving av halv minsteytelse.
     */
    private BeregningsresultatUforetrygd beregningsresultatUforetrygd;

    /**
     * Beregnet halv minsteytelse;
     */
    private int halvMinsteytelse;

    public VilkarsprovUforetrygdResultat() {
        super();
    }

    /**
     * Kopi-konstrukt�r.
     */
    public VilkarsprovUforetrygdResultat(VilkarsprovUforetrygdResultat resultat) {
        super();
        this.beregningsresultatUforetrygd = new BeregningsresultatUforetrygd(resultat.beregningsresultatUforetrygd);
        this.halvMinsteytelse = resultat.halvMinsteytelse;
    }

    public VilkarsprovUforetrygdResultat(BeregningsresultatUforetrygd beregningsresultatUforetrygd, int halvMinsteytelse) {
        super();
        this.beregningsresultatUforetrygd = beregningsresultatUforetrygd;
        this.halvMinsteytelse = halvMinsteytelse;
    }

    public BeregningsresultatUforetrygd getBeregningsresultatUforetrygd() {
        return beregningsresultatUforetrygd;
    }

    public void setBeregningsresultatUforetrygd(BeregningsresultatUforetrygd beregningsresultatUforetrygd) {
        this.beregningsresultatUforetrygd = beregningsresultatUforetrygd;
    }

    /**
     * @return beregnet halv minsteytelse.
     */
    public int getHalvMinsteytelse() {
        return halvMinsteytelse;
    }

    /**
     * @param halvMinsteytelse den nye halve minsteytelsen.
     */
    public void setHalvMinsteytelse(int halvMinsteytelse) {
        this.halvMinsteytelse = halvMinsteytelse;
    }
}
