package no.nav.pensjon.regler.to;

import java.util.ArrayList;
import java.util.List;


import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning2011.InntektsberegningsResultat;
import no.nav.pensjon.regler.domain.vedtak.AbstraktBeregningsvilkar;
import no.nav.pensjon.regler.domain.vedtak.InntektEtterUforhet;
import no.nav.pensjon.regler.domain.vedtak.InntektForUforhet;
import no.nav.pensjon.regler.domain.vedtak.Uforegrad;
import no.nav.pensjon.regler.domain.vedtak.Uforetidspunkt;

/**
 * @author Magnus Bakken (Accenture), PK-9491
 * @author Lars Hartviksen (Decisive), PK-7048
 */
public class BeslutningsstotteResponse extends ServiceResponse {

    private static final long serialVersionUID = 6035506415221235150L;

    private List<AbstraktBeregningsvilkar> beregningsvilkarListe;

    private Pakkseddel pakkseddel;

    /** Resultat av beregning av forventet inntekt */
    private InntektsberegningsResultat inntektsberegningsResultat;

    public BeslutningsstotteResponse() {
        super();
        beregningsvilkarListe = new ArrayList<AbstraktBeregningsvilkar>();
    }

    public BeslutningsstotteResponse(List<AbstraktBeregningsvilkar> beregningsvilkarListe, Pakkseddel pakkseddel) {
        super();
        this.beregningsvilkarListe = beregningsvilkarListe;
        this.pakkseddel = pakkseddel;
    }

    public InntektEtterUforhet getInntektEtterUforhet() {
        for (AbstraktBeregningsvilkar beregningsvilkar : beregningsvilkarListe) {
            if (beregningsvilkar instanceof InntektEtterUforhet) {
                return (InntektEtterUforhet) beregningsvilkar;
            }
        }
        return null;
    }

    public InntektForUforhet getInntektForUforhet() {
        for (AbstraktBeregningsvilkar beregningsvilkar : beregningsvilkarListe) {
            if (beregningsvilkar instanceof InntektForUforhet) {
                return (InntektForUforhet) beregningsvilkar;
            }
        }
        return null;
    }

    public Uforegrad getUforegrad() {
        for (AbstraktBeregningsvilkar beregningsvilkar : beregningsvilkarListe) {
            if (beregningsvilkar instanceof Uforegrad) {
                return (Uforegrad) beregningsvilkar;
            }
        }
        return null;
    }

    /**
     * @return uføretidspunktet i resultatet, null hvis det ikke finnes.
     */
    public Uforetidspunkt getUforetidspunkt() {
        for (AbstraktBeregningsvilkar beregningsvilkar : beregningsvilkarListe) {
            if (beregningsvilkar instanceof Uforetidspunkt) {
                return (Uforetidspunkt) beregningsvilkar;
            }
        }
        return null;
    }

    public InntektsberegningsResultat getInntektsberegningsResultat() {
        return inntektsberegningsResultat;
    }

    public void setInntektsberegningsResultat(InntektsberegningsResultat inntektsberegningsResultat) {
        this.inntektsberegningsResultat = inntektsberegningsResultat;
    }

    public AbstraktBeregningsvilkar[] retrieveBeregningsvilkarsListeAsArray() {
        return beregningsvilkarListe != null ? beregningsvilkarListe.toArray(new AbstraktBeregningsvilkar[beregningsvilkarListe.size()]) : new AbstraktBeregningsvilkar[0];
    }

    public List<AbstraktBeregningsvilkar> getBeregningsvilkarListe() {
        return beregningsvilkarListe;
    }

    public void setBeregningsvilkarListe(List<AbstraktBeregningsvilkar> beregningsvilkarListe) {
        this.beregningsvilkarListe = beregningsvilkarListe;
    }

    public Pakkseddel getPakkseddel() {
        return pakkseddel;
    }

    public void setPakkseddel(Pakkseddel pakkseddel) {
        this.pakkseddel = pakkseddel;
    }
}
