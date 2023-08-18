package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.kode.GrunnlagKildeCti;
import no.nav.pensjon.regler.domain.kode.OpptjeningTypeCti;
import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Opptjeningsgrunnlag
 * 
 * @author Swiddy de Louw PK-7973 PKPYTON-526
 */

public class Opptjeningsgrunnlag implements Comparable<Opptjeningsgrunnlag>, Serializable {

    private static final long serialVersionUID = -1725263167316447273L;

    /**
     * År for opptjeningen.
     */
    private int ar;

    /**
     * Pensjonsgivende inntekt.
     */
    private int pi;

    /**
     * Anvendt pensjonsgivende inntekt.Redusert pi etter 1/3-regelen.
     * Brukes ved beregning av poengtallene.<br>
     * <code>0 =< pia <= 8.33G (som int)</code>
     */
    private int pia;

    /**
     * Beregnet pensjonspoeng.
     */
    private double pp;

    /**
     * Angir type opptjening. Se K_OPPTJN_T.
     * Pr september 2007 så tabellen slik ut:
     * OSFE Omsorg for syke/funksjonshemmede/eldre
     * OBO7H Omsorg for barn over 7 år med hjelpestønad sats 3 eller 4
     * OBU7 Omsorg for barn under 7 år
     * PPI Pensjonsgivende inntekt
     */
    private OpptjeningTypeCti opptjeningType;

    /**
     * Maks uføregrad for dette året
     */
    private int maksUforegrad;
    /**
     * Angir om opptjeningsgrunnlaget brukes somm grunnlag på kravet.
     */
    private boolean bruk;
    /**
     * Kilden til opptjeningsgrunnlaget.
     */
    private GrunnlagKildeCti grunnlagKilde;

    /*
     * Inneholder alle inntektstyper for dette året
     */
    private List<OpptjeningTypeMapping> opptjeningTypeListe;

    /**
     * Copy Constructor
     * 
     * @param opptjeningsgrunnlag a <code>Opptjeningsgrunnlag</code> object
     */
    public Opptjeningsgrunnlag(Opptjeningsgrunnlag opptjeningsgrunnlag) {
        ar = opptjeningsgrunnlag.ar;
        pi = opptjeningsgrunnlag.pi;
        pia = opptjeningsgrunnlag.pia;
        pp = opptjeningsgrunnlag.pp;
        if (opptjeningsgrunnlag.opptjeningType != null) {
            opptjeningType = new OpptjeningTypeCti(opptjeningsgrunnlag.opptjeningType);
        }
        maksUforegrad = opptjeningsgrunnlag.maksUforegrad;
        bruk = opptjeningsgrunnlag.bruk;
        if (opptjeningsgrunnlag.grunnlagKilde != null) {
            grunnlagKilde = new GrunnlagKildeCti(opptjeningsgrunnlag.grunnlagKilde);
        }
        opptjeningTypeListe = new ArrayList<OpptjeningTypeMapping>();
        if (opptjeningsgrunnlag.opptjeningTypeListe != null) {
            for (OpptjeningTypeMapping o : opptjeningsgrunnlag.opptjeningTypeListe) {
                opptjeningTypeListe.add(new OpptjeningTypeMapping(o));
            }
        }
    }

    public Opptjeningsgrunnlag(int ar, int pi, int pia, double pp, OpptjeningTypeCti opptjeningType, int maksUforegrad, boolean bruk, GrunnlagKildeCti grunnlagKilde,
                               List<OpptjeningTypeMapping> opptjeningTypeListe) {
        super();
        this.ar = ar;
        this.pi = pi;
        this.pia = pia;
        this.pp = pp;
        this.opptjeningType = opptjeningType;
        this.maksUforegrad = maksUforegrad;
        this.bruk = bruk;
        this.grunnlagKilde = grunnlagKilde;
        this.opptjeningTypeListe = opptjeningTypeListe;
    }

    public Opptjeningsgrunnlag() {
        super();
        bruk = true;
        opptjeningTypeListe = new ArrayList<OpptjeningTypeMapping>();
    }

    /**
     * @return Returns the ar.
     */
    public int getAr() {
        return ar;
    }

    /**
     * @param ar The aar to set.
     */
    public void setAr(int ar) {
        this.ar = ar;
    }

    /**
     * @return Returns the opptjeningTypeCti.
     */
    public OpptjeningTypeCti getOpptjeningType() {
        return opptjeningType;
    }

    /**
     * @param opptjeningTypeCti The opptjeningTypeCti to set.
     */
    public void setOpptjeningType(OpptjeningTypeCti opptjeningTypeCti) {
        opptjeningType = opptjeningTypeCti;
    }

    /**
     * @return Returns the pp.
     */
    public double getPp() {
        return pp;
    }

    /**
     * @param pp The pp to set.
     */
    public void setPp(double pp) {
        this.pp = pp;
    }

    /**
     * @return Returns the pi.
     */
    public int getPi() {
        return pi;
    }

    /**
     * @param pi The pi to set.
     */
    public void setPi(int pi) {
        this.pi = pi;
    }

    /**
     * @return Returns the pia.
     */
    public int getPia() {
        return pia;
    }

    /**
     * @param pia The pia to set.
     */
    public void setPia(int pia) {
        this.pia = pia;
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

    public int getMaksUforegrad() {
        return maksUforegrad;
    }

    public void setMaksUforegrad(int maksUforegrad) {
        this.maksUforegrad = maksUforegrad;
    }

    /**
     * @return the opptjeningTypeListe
     */
    public List<OpptjeningTypeMapping> getOpptjeningTypeListe() {
        return opptjeningTypeListe;
    }

    /**
     * Read only property for opptjeningTypeListe as array
     * 
     * @return array of OpptjeningTypeMapping
     */
    public OpptjeningTypeMapping[] getOpptjeningTypeMappingListeAsArray() {
        return opptjeningTypeListe != null ? opptjeningTypeListe.toArray(new OpptjeningTypeMapping[opptjeningTypeListe.size()]) : new OpptjeningTypeMapping[0];
    }

    /**
     * @param aOpptjeningTypeListe the opptjeningTypeListe to set
     */
    public void setOpptjeningTypeListe(List<OpptjeningTypeMapping> aOpptjeningTypeListe) {
        opptjeningTypeListe = aOpptjeningTypeListe;
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Opptjeningsgrunnlag opptjeningsgrunnlag) {
        return ar - opptjeningsgrunnlag.getAr();
    }

}
