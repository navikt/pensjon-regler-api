package no.nav.pensjon.regler.to;


import no.nav.pensjon.regler.domain.Pakkseddel;
import no.nav.pensjon.regler.domain.beregning.Beregning;
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat;

public class BeregnForsorgingstilleggResponse extends ServiceResponse {

    private static final long serialVersionUID = 3391055995042373077L;

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

    public BeregnForsorgingstilleggResponse() {
        super();
    }

    public BeregnForsorgingstilleggResponse(Pakkseddel pakkseddel, Beregning beregningSoker, AbstraktBeregningsResultat beregningsResultatSoker) {
        super();
        this.pakkseddel = pakkseddel;
        this.beregningSoker = beregningSoker;
        this.beregningsResultatSoker = beregningsResultatSoker;
    }

    public Beregning getBeregningSoker() {
        return beregningSoker;
    }

    public void setBeregningSoker(Beregning beregningSoker) {
        this.beregningSoker = beregningSoker;
    }

    public Pakkseddel getPakkseddel() {
        return pakkseddel;
    }

    public void setPakkseddel(Pakkseddel pakkseddel) {
        this.pakkseddel = pakkseddel;
    }

    public AbstraktBeregningsResultat getBeregningsResultatSoker() {
        return beregningsResultatSoker;
    }

    public void setBeregningsResultatSoker(AbstraktBeregningsResultat beregningsResultatSoker) {
        this.beregningsResultatSoker = beregningsResultatSoker;
    }
}
