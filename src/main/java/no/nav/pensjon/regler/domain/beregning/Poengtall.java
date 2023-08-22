package no.nav.pensjon.regler.domain.beregning;

import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.Omsorgsopptjening;
import no.nav.pensjon.regler.domain.kode.BeregningMetodeTypeCti;
import no.nav.pensjon.regler.domain.kode.PoengtallTypeCti;
import no.nav.pensjon.regler.domain.util.ToStringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Poengtall implements Comparable<Poengtall>, Serializable, Omsorgsopptjening {

    private static final long serialVersionUID = -2666083737239303009L;

    /**
     * Pensjonspoeng,
     */
    private double pp;

    /**
     * Anvendt pensjonsgivende inntekt.
     */
    private int pia;

    /**
     * Pensjonsgivende inntekt.
     */
    private int pi;

    /**
     * Året for dette poengtallet
     */
    private int ar;

    /**
     * Angir om poengtallet er brukt i beregningen av sluttpoengtall.
     */
    private boolean bruktIBeregning;

    /**
     * Veiet grunnbeløp
     */
    private int gv;

    /**
     * Poengtalltype.
     */
    private PoengtallTypeCti poengtallType;

    /**
     * Maks uføregrad for dette året
     */
    private int maksUforegrad;

    /**
     * Året regnet som poengår.
     */
    private boolean PREG_poengar;

    /**
     * Året regnet som poengår iht. trygdeavtale.
     */
    private boolean PREG_poengarUtland;

    /**
     * Poengtall uten garanti. Internt bruk i PREG.
     */
    private double PREG_pp_fa;

    /**
     * Gradert poengtall. Internt bruk i PREG.
     */
    private double PREG_pp_gradert;

    /**
     * Omregnet poengtall. Internt bruk i PREG.
     */
    private double PREG_pp_omregnet;

    /**
     * Uførepensjon faktor (grad). Internt bruk i PREG.
     */
    private double PREG_up_faktor;

    /**
     * Yrkesskadepensjon faktor (grad). Internt bruk i PREG.
     */
    private double PREG_ysk_faktor;

    /**
     * Angir om året er et uføreår.
     */
    private boolean uforear;

    /**
     * Angir om poengtallet er blitt avkortet i henhold til regler for f92.
     * Benyttes i sammenheng med beregning av FPP. Internt bruk i PREG.
     */
    private boolean PREG_avkortet;

    /**
     * Angir om poengtallet er i et omsorgsår
     */
    private boolean PREG_omsorg;
    /**
     * Angir hvilken beregningsmetode (folketrygd, eøs, nordisk, ...) det
     * opptjente poenget forbindes med. Internt bruk i PREG.
     */
    private BeregningMetodeTypeCti PREG_beregningsmetode;

    private boolean PREG_omregnet;

    private boolean PREG_ikkeProrata;

    private boolean PREG_ikkeAlternativProrata;

    /**
     * Brutto pensjonspoeng.
     */
    private double PREG_brp;

    /**
     * Faktiske brutto pensjonspoeng. Ikke oppjustert av omsorgspoeng.
     */
    private double PREG_brp_fa;
    /**
     * Angir om året beregnes tilsvarende uførestartår. Gjelder historiske uføreperioder.
     */
    private boolean PREG_tilsvarerUforear;
    /**
     * Angir den effektive FPP som blir godskrevet i året.
     */
    private double PREG_effektivFPP;
    /**
     * Angir den effektive PAA som blir godskrevet i året.
     */
    private double PREG_effektivPAA;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;

    /**
     * Copy Constructor
     *
     * @param poengtall a <code>Poengtall</code> object
     */
    public Poengtall(Poengtall poengtall) {
        pp = poengtall.pp;
        pia = poengtall.pia;
        pi = poengtall.pi;
        ar = poengtall.ar;
        bruktIBeregning = poengtall.bruktIBeregning;
        gv = poengtall.gv;
        if (poengtall.poengtallType != null) {
            poengtallType = new PoengtallTypeCti(poengtall.poengtallType);
        }
        maksUforegrad = poengtall.maksUforegrad;
        PREG_pp_fa = poengtall.PREG_pp_fa;
        PREG_pp_gradert = poengtall.PREG_pp_gradert;
        PREG_pp_omregnet = poengtall.PREG_pp_omregnet;
        PREG_up_faktor = poengtall.PREG_up_faktor;
        PREG_ysk_faktor = poengtall.PREG_ysk_faktor;
        uforear = poengtall.uforear;
        PREG_avkortet = poengtall.PREG_avkortet;
        PREG_omsorg = poengtall.PREG_omsorg;
        if (poengtall.PREG_beregningsmetode != null) {
            PREG_beregningsmetode = new BeregningMetodeTypeCti(poengtall.PREG_beregningsmetode);
        }
        PREG_omregnet = poengtall.PREG_omregnet;
        PREG_ikkeProrata = poengtall.PREG_ikkeProrata;
        PREG_ikkeAlternativProrata = poengtall.PREG_ikkeAlternativProrata;
        PREG_brp = poengtall.PREG_brp;
        PREG_brp_fa = poengtall.PREG_brp_fa;
        PREG_tilsvarerUforear = poengtall.PREG_tilsvarerUforear;
        PREG_effektivFPP = poengtall.PREG_effektivFPP;
        PREG_effektivPAA = poengtall.PREG_effektivPAA;
        merknadListe = new ArrayList<Merknad>();
        if (poengtall.merknadListe != null) {
            for (Merknad merknad : poengtall.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
    }

    public Poengtall(double pp, int pia, int pi, int ar, boolean bruktIBeregning, int gv, PoengtallTypeCti poengtallType, int maksUforegrad) {
        this();
        this.pp = pp;
        this.pia = pia;
        this.pi = pi;
        this.ar = ar;
        this.bruktIBeregning = bruktIBeregning;
        this.gv = gv;
        this.poengtallType = poengtallType;
        if (poengtallType != null && poengtallType.getKode() != null) {
            PREG_omsorg = poengtallType.getKode().equals("J") || poengtallType.getKode().equals("K") || poengtallType.getKode().equals("L");
        }
        this.maksUforegrad = maksUforegrad;
    }

    public Poengtall() {
        super();
        merknadListe = new ArrayList<Merknad>();
    }

    public int getAr() {
        return ar;
    }

    /**
     * @param ar The ar to set.
     */
    public void setAr(int ar) {
        this.ar = ar;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getVerdi() {
        return getPp();
    }

    @Override
    public double getJustertBelop() {
        return 0;
    }

    @Override
    public void setJustertBelop(double justertBelop) {
        //Her skal intet skje.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOmsorg() {
        return isPREG_omsorg();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getOpptjeningsar() {
        return getAr();
    }

    /**
     * @return Returns the brukt_i_beregning.
     */
    public boolean getBruktIBeregning() {
        return bruktIBeregning;
    }

    /**
     * @param brukt_i_beregning The brukt_i_beregning to set.
     */
    public void setBruktIBeregning(boolean brukt_i_beregning) {
        bruktIBeregning = brukt_i_beregning;
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
     * @return Returns the merknad.
     */
    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    /**
     * @param merknad The merknad to set.
     */
    public void setMerknadListe(List<Merknad> merknad) {
        merknadListe = merknad;
    }

    /**
     * @return Returns the gv.
     */
    public int getGv() {
        return gv;
    }

    /**
     * @param gv The gv to set.
     */
    public void setGv(int gv) {
        this.gv = gv;
    }

    /**
     * @return Returns the poengtallType.
     */
    public PoengtallTypeCti getPoengtallType() {
        return poengtallType;
    }

    /**
     * @param poengtallTypeCti The poengtallTypeCti to set.
     */
    public void setPoengtallType(PoengtallTypeCti poengtallTypeCti) {
        poengtallType = poengtallTypeCti;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Poengtall o) {
        Poengtall p = o;
        return Double.compare(pp, p.pp); // increasing order
        //return Double.compare(p.pp, this.pp); // descending order
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public double getPREG_pp_fa() {
        return PREG_pp_fa;
    }

    public void setPREG_pp_fa(double preg_pp_fa) {
        PREG_pp_fa = preg_pp_fa;
    }

    public int getMaksUforegrad() {
        return maksUforegrad;
    }

    public boolean getPREG_poengar() {
        return PREG_poengar;
    }

    public void setPREG_poengar(boolean PREG_poengar) {
        this.PREG_poengar = PREG_poengar;
    }

    public void setMaksUforegrad(int maksUforegrad) {
        this.maksUforegrad = maksUforegrad;
    }

    public double getPREG_pp_gradert() {
        return PREG_pp_gradert;
    }

    public void setPREG_pp_gradert(double preg_pp_gradert) {
        PREG_pp_gradert = preg_pp_gradert;
    }

    public double getPREG_pp_omregnet() {
        return PREG_pp_omregnet;
    }

    public void setPREG_pp_omregnet(double preg_pp_omregnet) {
        PREG_pp_omregnet = preg_pp_omregnet;
    }

    public boolean isUforear() {
        return uforear;
    }

    public void setUforear(boolean uforear) {
        this.uforear = uforear;
    }

    public double getPREG_up_faktor() {
        return PREG_up_faktor;
    }

    public void setPREG_up_faktor(double preg_up_faktor) {
        PREG_up_faktor = preg_up_faktor;
    }

    public double getPREG_ysk_faktor() {
        return PREG_ysk_faktor;
    }

    public void setPREG_ysk_faktor(double preg_ysk_faktor) {
        PREG_ysk_faktor = preg_ysk_faktor;
    }

    public boolean isPREG_avkortet() {
        return PREG_avkortet;
    }

    public void setPREG_avkortet(boolean preg_avkortet) {
        PREG_avkortet = preg_avkortet;
    }

    public BeregningMetodeTypeCti getPREG_beregningsmetode() {
        return PREG_beregningsmetode;
    }

    public void setPREG_beregningsmetode(BeregningMetodeTypeCti type) {
        PREG_beregningsmetode = type;
    }

    public boolean isPREG_omregnet() {
        return PREG_omregnet;
    }

    public void setPREG_omregnet(boolean preg_omregnet) {
        PREG_omregnet = preg_omregnet;
    }

    public boolean isPREG_ikkeAlternativProrata() {
        return PREG_ikkeAlternativProrata;
    }

    public void setPREG_ikkeAlternativProrata(boolean alternativProrata) {
        PREG_ikkeAlternativProrata = alternativProrata;
    }

    public boolean isPREG_ikkeProrata() {
        return PREG_ikkeProrata;
    }

    public void setPREG_ikkeProrata(boolean prorata) {
        PREG_ikkeProrata = prorata;
    }

    public double getPREG_brp() {
        return PREG_brp;
    }

    public void setPREG_brp(double preg_brp) {
        PREG_brp = preg_brp;
    }

    public double getPREG_brp_fa() {
        return PREG_brp_fa;
    }

    public void setPREG_brp_fa(double preg_brp_fa) {
        PREG_brp_fa = preg_brp_fa;
    }

    public boolean isPREG_omsorg() {
        return PREG_omsorg;
    }

    public void setPREG_omsorg(boolean preg_omsorg) {
        PREG_omsorg = preg_omsorg;
    }

    public double getPREG_effektivFPP() {
        return PREG_effektivFPP;
    }

    public void setPREG_effektivFPP(double preg_effektivfpp) {
        PREG_effektivFPP = preg_effektivfpp;
    }

    public double getPREG_effektivPAA() {
        return PREG_effektivPAA;
    }

    public void setPREG_effektivPAA(double preg_effektivpaa) {
        PREG_effektivPAA = preg_effektivpaa;
    }

    public boolean isPREG_tilsvarerUforear() {
        return PREG_tilsvarerUforear;
    }

    public void setPREG_tilsvarerUforear(boolean uforear) {
        PREG_tilsvarerUforear = uforear;
    }

    public boolean isInntektIAvtaleland() {
        return false;
    }

    /**
     * Trengs for å implementere Omsorgsopptjening
     */
    public void setInntektIAvtaleland(boolean inntektIAvtaleland) {
        //Skal ikke gjøre noe.
    }

    public boolean isPREG_poengarUtland() {
        return PREG_poengarUtland;
    }

    public void setPREG_poengarUtland(boolean PREG_poengarUtland) {
        this.PREG_poengarUtland = PREG_poengarUtland;
    }

}
