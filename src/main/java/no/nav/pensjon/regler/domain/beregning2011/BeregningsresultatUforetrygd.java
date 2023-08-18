package no.nav.pensjon.regler.domain.beregning2011;

/**
 * @author Aasmund Nordstoga (Acenture) - PKFEIL-2605
 * @author Tatyana Lochehina PK-13673
 * @author Swiddy de Louw PK-16620
 * @author Lars Hartvigsen PK-20946
 */
public class BeregningsresultatUforetrygd extends AbstraktBeregningsResultat {
    private static final long serialVersionUID = -1774279935543161993L;

    /**
     * Resultat av uføretrygdberegningen
     */
    private Uforetrygdberegning uforetrygdberegning;

    public BeregningsresultatUforetrygd() {
        super();
    }

    public BeregningsresultatUforetrygd(BeregningsresultatUforetrygd ur) {
        super(ur);
        if (ur.uforetrygdberegning != null) {
            uforetrygdberegning = new Uforetrygdberegning(ur.uforetrygdberegning, true);
        }
    }

    public Uforetrygdberegning getUforetrygdberegning() {
        return uforetrygdberegning;
    }

    public void setUforetrygdberegning(Uforetrygdberegning uforetrygdberegning) {
        this.uforetrygdberegning = uforetrygdberegning;
    }

}
