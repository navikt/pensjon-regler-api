package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.GuiPrompt;
import no.nav.domain.pensjon.regler.kode.GrunnlagKildeCti;
import no.nav.domain.pensjon.regler.kode.InntektTypeCti;
import no.nav.domain.pensjon.regler.util.Copyable;
import no.nav.domain.pensjon.regler.util.DateCompareUtil;
import no.nav.domain.pensjon.regler.util.ToStringUtil;

import java.io.Serializable;
import java.util.Date;

public class Inntektsgrunnlag implements Comparable<Inntektsgrunnlag>, Serializable, Copyable<Inntektsgrunnlag> {

    private static final long serialVersionUID = 8356887987852527326L;

    /*
     * Unik identifikator for Inntektsgrunnlag. Endres ikke av regelmotoren,
     * men Inntektsgrunnlag med null id kan opprettes av batchtjenestene,
     * derfor settes den til typen wrapperobjekt Long i stedet for primitiven long.
     */
    private Long inntektsgrunnlagId;

    /**
     * Inntektens størrelse, i hele kroner.
     */
    @GuiPrompt(prompt = "Inntekt")
    private int belop;

    /**
     * Kode som angir type inntekt. Se K_INNTEKT_T.
     * Pr september 2007 så tabellen slik ut:
     * FPI Forventet arbeidsinntekt
     * FKI Forventet kapitalinntekt
     * PENT Forventet tjenestepensjonsinntekt (ikke folketrygd)
     * FBI Forventet bidrag o.l
     * HYPF Hypotetisk forventet arbeidsinntekt
     * HYPF2G Hypotetisk forventet arbeidsinntekt 2G
     * PGI Foreløpig pensjonsgivende inntekt
     * IMFU Inntekt Mnd Før Uttak
     * PENF Pensjonsinntekt fra folketrygden
     * ARBLTO Arbeidsinntekt (Lønn og trekk)
     * ARBLIGN Arbeidsinntekt (Ligning)
     * PENSKD Pensjonsinntekt (ikke folketrygd)
     * KAP Kapitalinntekt
     */
    @GuiPrompt(prompt = "Inntektstype")
    private InntektTypeCti inntektType;

    /**
     * fra-og-med dato for gyldigheten av inntektsgrunnlaget.
     */
    @GuiPrompt(prompt = "Fra og med dato")
    private Date fom;

    /**
     * til-og-med dato for gyldigheten av inntektsgrunnlaget.
     */
    @GuiPrompt(prompt = "Til og med dato")
    private Date tom;

    /**
     * Angir om inntektsgrunnlaget brukes som grunnlag på kravet.
     */
    private boolean bruk;

    /**
     * Kilden til inntektsgrunnlaget.
     */
    private GrunnlagKildeCti grunnlagKilde;

    /**
     * Copy Constructor
     * 
     * @param inntektsgrunnlag a <code>Inntektsgrunnlag</code> object
     */
    public Inntektsgrunnlag(Inntektsgrunnlag inntektsgrunnlag) {
        if (inntektsgrunnlag.inntektsgrunnlagId != null) {
            inntektsgrunnlagId = new Long(inntektsgrunnlag.inntektsgrunnlagId);
        }
        belop = inntektsgrunnlag.belop;
        if (inntektsgrunnlag.inntektType != null) {
            inntektType = new InntektTypeCti(inntektsgrunnlag.inntektType);
        }
        if (inntektsgrunnlag.fom != null) {
            fom = (Date) inntektsgrunnlag.fom.clone();
        }
        if (inntektsgrunnlag.tom != null) {
            tom = (Date) inntektsgrunnlag.tom.clone();
        }
        bruk = inntektsgrunnlag.bruk;
        if (inntektsgrunnlag.grunnlagKilde != null) {
            grunnlagKilde = new GrunnlagKildeCti(inntektsgrunnlag.grunnlagKilde);
        }
    }

    /**
     * Copy constructor
     * Brukes i spesialtilfeller der vi vil opprette et inntektsgrunnlag fra Blaze hvor ID skal være null.
     * Dette brukes i enkelte batchtjenester, og kan ikke gjøres direkte i Blaze fordi Long blir mappet til integer.
     * 
     * @param inntektsgrunnlag
     * @param inntektsgrunnlagIdNull
     */
    public Inntektsgrunnlag(Inntektsgrunnlag inntektsgrunnlag, boolean inntektsgrunnlagIdNull) {
        this(inntektsgrunnlag);
        if (inntektsgrunnlagIdNull) {
            inntektsgrunnlagId = null;
        }

    }

    public Inntektsgrunnlag(Long inntektsgrunnlagId, int belop, InntektTypeCti inntektType, Date fom, Date tom, boolean bruk, GrunnlagKildeCti grunnlagKilde) {
        this();
        this.inntektsgrunnlagId = inntektsgrunnlagId;
        this.belop = belop;
        this.inntektType = inntektType;
        this.fom = fom;
        this.tom = tom;
        this.bruk = bruk;
        this.grunnlagKilde = grunnlagKilde;
    }

    /**
     * private boolean kopiertFraGammeltKrav;
     */

    public Inntektsgrunnlag() {
        super();
        bruk = true;
    }

    /**
     * @return Returns the belop.
     */
    public int getBelop() {
        return belop;
    }

    /**
     * @param belop The belop to set.
     */
    public void setBelop(int belop) {
        this.belop = belop;
    }

    /**
     * @return Returns the type.
     */
    public InntektTypeCti getInntektType() {
        return inntektType;
    }

    /**
     * @param type The type to set.
     */
    public void setInntektType(InntektTypeCti inntektTypeCti) {
        inntektType = inntektTypeCti;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
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

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Inntektsgrunnlag inntektsgrunnlag) {
        return DateCompareUtil.compareTo(getFom(), inntektsgrunnlag.getFom());
    }

    public Long getInntektsgrunnlagId() {
        return inntektsgrunnlagId;
    }

    public void setInntektsgrunnlagId(Long inntektsgrunnlagId) {
        this.inntektsgrunnlagId = inntektsgrunnlagId;
    }

    public boolean isInntektsgrunnlagIdNull() {
        if (inntektsgrunnlagId == null) {
            return true;
        }
        return false;
    }

    @Override
    public Inntektsgrunnlag deepCopy() {
        return new Inntektsgrunnlag(this);
    }

}
