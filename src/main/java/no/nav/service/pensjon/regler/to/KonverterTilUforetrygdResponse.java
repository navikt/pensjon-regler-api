package no.nav.service.pensjon.regler.to;

import no.stelvio.common.transferobject.ServiceResponse;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsgrunnlagKonvertert;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;
import no.nav.domain.pensjon.regler.beregning2011.EktefelletilleggUT;
import no.nav.domain.pensjon.regler.beregning2011.OvergangsinfoUPtilUT;

/**
 * @author Magnus Bakken (Accenture) - PK-7799 - Utvidet response med konverterte beregningsgrunnlag.
 * @author Swiddy de Louw (Capgemini) - PK-8712 - Utvidet response med OvergangsinfoUPtilUT
 */

public class KonverterTilUforetrygdResponse extends ServiceResponse {

    private static final long serialVersionUID = -5755180768635179987L;

    private BeregningsgrunnlagKonvertert beregningsgrunnlagKonvertertOrdinertHjemme;

    private BeregningsgrunnlagKonvertert beregningsgrunnlagKonvertertYrkesskadeHjemme;

    private BeregningsresultatUforetrygd beregningsresultatUforetrygd;

    private Pakkseddel pakkseddel;

    private OvergangsinfoUPtilUT overgangsinfoUPtilUT;

    public KonverterTilUforetrygdResponse() {
        super();
    }

    public KonverterTilUforetrygdResponse(BeregningsgrunnlagKonvertert beregningsgrunnlagKonvertertOrdinertHjemme,
            BeregningsgrunnlagKonvertert beregningsgrunnlagKonvertertYrkesskadeHjemme,
            BeregningsresultatUforetrygd beregningsresultatUforetrygd,
            Pakkseddel pakkseddel, EktefelletilleggUT konvertertEktefelletillegg, OvergangsinfoUPtilUT overgangsinfoUPtilUT) {
        super();
        this.beregningsgrunnlagKonvertertOrdinertHjemme = beregningsgrunnlagKonvertertOrdinertHjemme;
        this.beregningsgrunnlagKonvertertYrkesskadeHjemme = beregningsgrunnlagKonvertertYrkesskadeHjemme;
        this.beregningsresultatUforetrygd = beregningsresultatUforetrygd;
        this.pakkseddel = pakkseddel;
        this.overgangsinfoUPtilUT = overgangsinfoUPtilUT;
    }

    public BeregningsgrunnlagKonvertert getBeregningsgrunnlagKonvertertOrdinertHjemme() {
        return beregningsgrunnlagKonvertertOrdinertHjemme;
    }

    public void setBeregningsgrunnlagKonvertertOrdinertHjemme(BeregningsgrunnlagKonvertert beregningsgrunnlagKonvertertOrdinertHjemme) {
        this.beregningsgrunnlagKonvertertOrdinertHjemme = beregningsgrunnlagKonvertertOrdinertHjemme;
    }

    public BeregningsgrunnlagKonvertert getBeregningsgrunnlagKonvertertYrkesskadeHjemme() {
        return beregningsgrunnlagKonvertertYrkesskadeHjemme;
    }

    public void setBeregningsgrunnlagKonvertertYrkesskadeHjemme(BeregningsgrunnlagKonvertert beregningsgrunnlagKonvertertYrkesskadeHjemme) {
        this.beregningsgrunnlagKonvertertYrkesskadeHjemme = beregningsgrunnlagKonvertertYrkesskadeHjemme;
    }

    public BeregningsresultatUforetrygd getBeregningsresultatUforetrygd() {
        return beregningsresultatUforetrygd;
    }

    public void setBeregningsresultatUforetrygd(BeregningsresultatUforetrygd beregningsresultatUforetrygd) {
        this.beregningsresultatUforetrygd = beregningsresultatUforetrygd;
    }

    public Pakkseddel getPakkseddel() {
        return pakkseddel;
    }

    public void setPakkseddel(Pakkseddel pakkseddel) {
        this.pakkseddel = pakkseddel;
    }

    /**
     * @return the overgangsinfoUPtilUT
     */
    public OvergangsinfoUPtilUT getOvergangsinfoUPtilUT() {
        return overgangsinfoUPtilUT;
    }

    /**
     * @param overgangsinfoUPtilUT the overgangsinfoUPtilUT to set
     */
    public void setOvergangsinfoUPtilUT(OvergangsinfoUPtilUT overgangsinfoUPtilUT) {
        this.overgangsinfoUPtilUT = overgangsinfoUPtilUT;
    }

}