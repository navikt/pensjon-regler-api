package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.kode.YrkeYrkesskadeCti;
import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * Grunnlagsdata for yrkesskade. Denne er et tillegg til Uforegrunnlag. Hvis
 * dette objektet finnes (!=null) må det finnes et Uforegrunnlag. Dersom dette
 * objektet er null og Uforegrunnlaget != null betyr det at personen ikke har
 * yrkesskade.
 */
public class Yrkesskadegrunnlag implements Serializable {

    private static final long serialVersionUID = 5541265776710096836L;

    /**
     * Dato for skadetidspunkt.
     */
    private Date yst;

    /**
     * Uføregrad ved yrkesskade, heltall 0-100.Kan ikke være større enn
     * uføregraden(ufg).For avdød pga yrkesskade settes yug til 100.
     */
    private int yug;

    /**
     * Angir om yrkesskaden skyldes yrkessykdom.
     */
    private boolean yrkessykdom;

    /**
     * Det er en minimumsgaranti mht poengtall for som gjelder for spesielle
     * yrkesgrupper, f.eks fiskere,fangstmenn, militære,ungdom under utdanning
     * osv.
     */
    private YrkeYrkesskadeCti yrke;

    /**
     * Bruker forsørget av avdød iht paragraf 17-12.2
     */
    private boolean brukerForsorgetAvAvdod;

    /**
     * Antatt årlig inntekt på skadetidspunktet.
     */
    private int antattArligInntekt;

    /**
     * Angir om yrkesskadegrunnlaget brukes som grunnlag på kravet.
     */
    private boolean bruk;

    /**
     * Copy Constructor
     * 
     * @param yrkesskadegrunnlag a <code>Yrkesskadegrunnlag</code> object
     */
    public Yrkesskadegrunnlag(Yrkesskadegrunnlag yrkesskadegrunnlag) {
        if (yrkesskadegrunnlag.yst != null) {
            yst = (Date) yrkesskadegrunnlag.yst.clone();
        }
        yug = yrkesskadegrunnlag.yug;
        yrkessykdom = yrkesskadegrunnlag.yrkessykdom;
        if (yrkesskadegrunnlag.yrke != null) {
            yrke = new YrkeYrkesskadeCti(yrkesskadegrunnlag.yrke);
        }
        brukerForsorgetAvAvdod = yrkesskadegrunnlag.brukerForsorgetAvAvdod;
        antattArligInntekt = yrkesskadegrunnlag.antattArligInntekt;
        bruk = yrkesskadegrunnlag.bruk;
    }

    public Yrkesskadegrunnlag(Date yst, int yug, boolean yrkessykdom, YrkeYrkesskadeCti yrke, boolean brukerForsorgetAvAvdod, int antattArligInntekt, boolean bruk) {
        super();
        this.yst = yst;
        this.yug = yug;
        this.yrkessykdom = yrkessykdom;
        this.yrke = yrke;
        this.brukerForsorgetAvAvdod = brukerForsorgetAvAvdod;
        this.antattArligInntekt = antattArligInntekt;
        this.bruk = bruk;
    }

    public Yrkesskadegrunnlag() {
        super();
        bruk = true;
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public int getAntattArligInntekt() {
        return antattArligInntekt;
    }

    public void setAntattArligInntekt(int antattArligInntekt) {
        this.antattArligInntekt = antattArligInntekt;
    }

    public boolean isBruk() {
        return bruk;
    }

    public void setBruk(boolean bruk) {
        this.bruk = bruk;
    }

    public boolean isBrukerForsorgetAvAnnen() {
        return brukerForsorgetAvAvdod;
    }

    public void setBrukerForsorgetAvAnnen(boolean brukerForsorgetAvAvdod) {
        this.brukerForsorgetAvAvdod = brukerForsorgetAvAvdod;
    }

    public YrkeYrkesskadeCti getYrke() {
        return yrke;
    }

    public void setYrke(YrkeYrkesskadeCti yrke) {
        this.yrke = yrke;
    }

    public boolean isYrkessykdom() {
        return yrkessykdom;
    }

    public void setYrkessykdom(boolean yrkessykdom) {
        this.yrkessykdom = yrkessykdom;
    }

    public Date getYst() {
        return yst;
    }

    public void setYst(Date yst) {
        this.yst = yst;
    }

    public int getYug() {
        return yug;
    }

    public void setYug(int yug) {
        this.yug = yug;
    }

}
