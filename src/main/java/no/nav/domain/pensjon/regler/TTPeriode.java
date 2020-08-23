package no.nav.domain.pensjon.regler;

import no.nav.domain.pensjon.regler.kode.GrunnlagKildeCti;
import no.nav.domain.pensjon.regler.kode.LandCti;
import no.nav.domain.pensjon.regler.util.DateCompareUtil;
import no.nav.domain.pensjon.regler.util.ToStringUtil;

import java.io.Serializable;
import java.util.Date;

public class TTPeriode implements Comparable<TTPeriode>, Serializable {

    private static final long serialVersionUID = -6452030217210545498L;

    /**
     * Fra-og-med dato for perioden.
     */
    @GuiPrompt(prompt = "Fra og med dato")
    private Date fom;

    /**
     * Til-og-med dato for perioden.
     */
    @GuiPrompt(prompt = "Til og med dato")
    private Date tom;

    /**
     * Skal bruker ha poeng for hele året i fom-datoen
     */
    @GuiPrompt(prompt = "Poeng i innår")
    private boolean poengIInnAr;

    /**
     * Skal bruker ha poeng for hele året i tom-datoen
     */
    @GuiPrompt(prompt = "Poeng i utår")
    private boolean poengIUtAr;

    /**
     * Hvilket land perioden er opptjent i.
     */
    @GuiPrompt(prompt = "Land")
    private LandCti land;

    /**
     * Om det skal regnes pro rata. Gjelder ved utenlandssaker.
     */
    @GuiPrompt(prompt = "Ikke pro rata")
    private boolean ikkeProRata;

    /**
     * Angir om trygdetidsperioden brukes somm grunnlag på kravet.
     */
    private boolean bruk;

    /**
     * Kilden til trygdetidsperioden.
     */
    private GrunnlagKildeCti grunnlagKilde;

    /**
     * Copy Constructor
     * 
     * @param tTPeriode
     * a <code>TTPeriode</code> object
     */
    public TTPeriode(TTPeriode tTPeriode) {
        if (tTPeriode.fom != null) {
            fom = (Date) tTPeriode.fom.clone();
        }
        if (tTPeriode.tom != null) {
            tom = (Date) tTPeriode.tom.clone();
        }
        poengIInnAr = tTPeriode.poengIInnAr;
        poengIUtAr = tTPeriode.poengIUtAr;
        if (tTPeriode.land != null) {
            land = new LandCti(tTPeriode.land);
        }
        ikkeProRata = tTPeriode.ikkeProRata;
        bruk = tTPeriode.bruk;
        if (tTPeriode.grunnlagKilde != null) {
            grunnlagKilde = new GrunnlagKildeCti(tTPeriode.grunnlagKilde);
        }
    }

    public TTPeriode() {
        super();
        bruk = true;
    }

    public TTPeriode(Date fom, Date tom, boolean poengIInnAr, boolean poengIUtAr, LandCti land, boolean ikkeProRata, boolean bruk, GrunnlagKildeCti grunnlagKilde) {
        super();
        this.fom = fom;
        this.tom = tom;
        this.poengIInnAr = poengIInnAr;
        this.poengIUtAr = poengIUtAr;
        this.land = land;
        this.ikkeProRata = ikkeProRata;
        this.bruk = bruk;
        this.grunnlagKilde = grunnlagKilde;
    }

    public Date getFom() {
        return fom;
    }

    public void setFom(Date fom) {
        this.fom = fom;
    }

    public Date getTom() {
        return tom;
    }

    public void setTom(Date tom) {
        this.tom = tom;
    }

    public LandCti getLand() {
        return land;
    }

    public void setLand(LandCti land) {
        this.land = land;
    }

    public boolean isPoengIInnAr() {
        return poengIInnAr;
    }

    public void setPoengIInnAr(boolean poengIInnAr) {
        this.poengIInnAr = poengIInnAr;
    }

    public boolean isPoengIUtAr() {
        return poengIUtAr;
    }

    public void setPoengIUtAr(boolean poengIUtAr) {
        this.poengIUtAr = poengIUtAr;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public boolean isBruk() {
        return bruk;
    }

    public void setBruk(boolean bruk) {
        this.bruk = bruk;
    }

    public GrunnlagKildeCti getGrunnlagKilde() {
        return grunnlagKilde;
    }

    public void setGrunnlagKilde(GrunnlagKildeCti grunnlagKilde) {
        this.grunnlagKilde = grunnlagKilde;
    }

    public boolean isIkkeProRata() {
        return ikkeProRata;
    }

    public void setIkkeProRata(boolean ikkeProRata) {
        this.ikkeProRata = ikkeProRata;
    }

    @Override
    public int compareTo(TTPeriode ttperiode) {
        return DateCompareUtil.compareTo(getFom(), ttperiode.getFom());
    }
}
