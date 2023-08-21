package no.nav.pensjon.regler.domain.beregning2011;


import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.Omsorgsopptjening;
import no.nav.pensjon.regler.domain.grunnlag.OpptjeningTypeMapping;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.util.ListUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Magnus Bakken (Accenture), PK-9491
 * @author Swiddy de Louw (Capgemini), PK-7973 PKPYTON-526
 * @author Swiddy de Louw (Capgemini), PK-8704,PKPYTON-563
 */

public class OpptjeningUT implements Comparable<OpptjeningUT>, Serializable, Omsorgsopptjening {

    private static final long serialVersionUID = -8575336399253330768L;

    /**
     * Angir om avkortet mot 6*grunnbel�p ved virk.
     */

    private double avkortetBelop;

    /**
     * Angir om et av de tre �rene som er brukt.
     */

    private boolean brukt;

    /**
     * Angir om det er inntekt i avtaleland som ang�r den konvensjon som beregningsgrunnlaget inng�r i.
     */

    private boolean inntektIAvtaleland;

    /**
     * Inntekten for et �r ganget med forholdet mellom grunnbel�pet ved virk
     * og gjennomsnittlig grunnbel�p for inntekts�ret.
     */

    private double justertBelop;

    /**
     * Pensjonsgivende inntekt.
     */

    private int pgi;

    /**
     * Gjennomsnittlig G for inntekts�ret.
     */

    private int veietG;

    /**
     * Hvilket �rstall.
     */

    private int ar;

    private List<Merknad> merknadListe = new ArrayList<Merknad>();


    private FormelKodeCti formelkode;

    /**
     * Opptjeningsgaranti ved f�rstegangstjeneste.
     */

    private int forstegangstjeneste;

    /**
     * Beregnet inntekt for �ret.
     */

    private int belop;

    /**
     * Minste bel�p for fastsettelse av justert PGI.
     */

    private int garantiBelop;

    /**
     * Angir om det finnes omsorgsopptjening for �ret.
     */

    private boolean omsorgsar;

    /**
     * Pensjonsgivende inntekt justert i henhold til
     * gjennomsnittlig stillingsprosent for �ret.
     */

    private int justertPGI;

    /**
     * Opptjening fra uf�repensjon eller uf�retrygd
     */

    private double uforeopptjening;

    /**
     * Inneholder alle inntektstyper for dette �ret
     */
    private List<OpptjeningTypeMapping> PREG_opptjeningTypeListe = new ArrayList<OpptjeningTypeMapping>();

    /**
     * Maks uf�regrad for dette �ret.
     */
    private int PREG_maksUforegrad;

    /**
     * Maks yrkesskadegrad for dette �ret.
     */
    private int PREG_maksYrkesskadegrad;

    public OpptjeningUT() {
        super();
    }

    public OpptjeningUT(OpptjeningUT opptjeningUT) {
        this();
        avkortetBelop = opptjeningUT.avkortetBelop;
        brukt = opptjeningUT.brukt;
        justertBelop = opptjeningUT.justertBelop;
        pgi = opptjeningUT.pgi;
        veietG = opptjeningUT.veietG;
        ar = opptjeningUT.ar;
        forstegangstjeneste = opptjeningUT.forstegangstjeneste;
        belop = opptjeningUT.belop;
        garantiBelop = opptjeningUT.garantiBelop;
        omsorgsar = opptjeningUT.omsorgsar;
        inntektIAvtaleland = opptjeningUT.isInntektIAvtaleland();
        if (opptjeningUT.merknadListe != null) {
            for (Merknad m : opptjeningUT.merknadListe) {
                merknadListe.add(new Merknad(m));
            }
        }
        if (opptjeningUT.PREG_opptjeningTypeListe != null) {
            PREG_opptjeningTypeListe = ListUtil.deepCopyReflection(opptjeningUT.PREG_opptjeningTypeListe);
        }
        if (opptjeningUT.formelkode != null) {
            formelkode = new FormelKodeCti(opptjeningUT.getFormelkode());
        }
        justertPGI = opptjeningUT.justertPGI;
        uforeopptjening = opptjeningUT.uforeopptjening;
        PREG_maksUforegrad = opptjeningUT.PREG_maksUforegrad;
        PREG_maksYrkesskadegrad = opptjeningUT.PREG_maksYrkesskadegrad;
    }

    /**
     * Constructor for � initialisere felter som brukes av interface Omsorgsopptjening.
     * Opprettet av hensyn til testbarhet.
     * 
     * @param opptjeningsar
     * @param verdi
     * @param omsorg
     * @param inntektIAvtaleland
     */
    public OpptjeningUT(int opptjeningsar, double verdi, boolean omsorg, boolean inntektIAvtaleland) {
        this();
        ar = opptjeningsar;
        avkortetBelop = verdi;
        omsorgsar = omsorg;
        this.inntektIAvtaleland = inntektIAvtaleland;
    }

    /**
     * Constructor for � initialisere felter som brukes av interface Omsorgsopptjening.
     * Opprettet av hensyn til testbarhet.
     * 
     * @param opptjeningsar
     * @param verdi
     * @param omsorg
     * @param inntektIAvtaleland
     * @param justertBelop
     */
    public OpptjeningUT(int opptjeningsar, double verdi, boolean omsorg, boolean inntektIAvtaleland, double justertBelop) {
        this();
        ar = opptjeningsar;
        avkortetBelop = verdi;
        omsorgsar = omsorg;
        this.inntektIAvtaleland = inntektIAvtaleland;
        this.justertBelop = justertBelop;
    }

    public boolean isBrukt() {
        return brukt;
    }

    public void setBrukt(boolean brukt) {
        this.brukt = brukt;
    }

    public int getPgi() {
        return pgi;
    }

    public void setPgi(int pgi) {
        this.pgi = pgi;
    }

    public double getAvkortetBelop() {
        return avkortetBelop;
    }

    public void setAvkortetBelop(double avkortetBelop) {
        this.avkortetBelop = avkortetBelop;
    }

    @Override
    public double getJustertBelop() {
        return justertBelop;
    }

    @Override
    public void setJustertBelop(double justertBelop) {
        this.justertBelop = justertBelop;
    }

    public int getVeietG() {
        return veietG;
    }

    public void setVeietG(int veietG) {
        this.veietG = veietG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getOpptjeningsar() {
        return getAr();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getVerdi() {
        return getAvkortetBelop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOmsorg() {
        return isOmsorgsar();
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    public FormelKodeCti getFormelkode() {
        return formelkode;
    }

    public void setFormelkode(FormelKodeCti formelkode) {
        this.formelkode = formelkode;
    }

    public int getForstegangstjeneste() {
        return forstegangstjeneste;
    }

    public void setForstegangstjeneste(int forstegangstjeneste) {
        this.forstegangstjeneste = forstegangstjeneste;
    }

    /*
     * Sorter med st�rste avkortetBelop f�rst. Dersom avkortetBelop
     * er lik sorteres st�rste �r f�rst.
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(OpptjeningUT o) {
        if (Double.compare(o.avkortetBelop, avkortetBelop) == 0) {
            if (o.justertBelop == justertBelop) {
                if (o.ar == ar) {
                    return 0;
                } else if (o.ar < ar) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (o.justertBelop < justertBelop) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return Double.compare(o.avkortetBelop, avkortetBelop);
        }
    }

    public int getBelop() {
        return belop;
    }

    public void setBelop(int belop) {
        this.belop = belop;
    }

    /**
     * @return Minste bel�p for fastsettelse av justert PGI.
     */
    public int getGarantiBelop() {
        return garantiBelop;
    }

    /**
     * @param garantiBelop Nytt minste bel�p for fastsettelse av justert PGI.
     */
    public void setGarantiBelop(int garantiBelop) {
        this.garantiBelop = garantiBelop;
    }

    public boolean isOmsorgsar() {
        return omsorgsar;
    }

    public void setOmsorgsar(boolean omsorgsar) {
        this.omsorgsar = omsorgsar;
    }

    /**
     * @return the justertPGI
     */
    public int getJustertPGI() {
        return justertPGI;
    }

    /**
     * @param justertPGI the justertPGI to set
     */
    public void setJustertPGI(int justertPGI) {
        this.justertPGI = justertPGI;
    }

    /**
     * @return the uforeopptjening
     */
    public double getUforeopptjening() {
        return uforeopptjening;
    }

    /**
     * @param uforeopptjening the uforeopptjening to set
     */
    public void setUforeopptjening(double uforeopptjening) {
        this.uforeopptjening = uforeopptjening;
    }

    public List<OpptjeningTypeMapping> getPREG_opptjeningTypeListe() {
        return PREG_opptjeningTypeListe;
    }

    public void setPREG_opptjeningTypeListe(List<OpptjeningTypeMapping> PREG_opptjeningTypeListe) {
        this.PREG_opptjeningTypeListe = PREG_opptjeningTypeListe;
    }

    @Override
    public boolean isInntektIAvtaleland() {
        return inntektIAvtaleland;
    }

    @Override
    public void setInntektIAvtaleland(boolean inntektIAvtaleland) {
        this.inntektIAvtaleland = inntektIAvtaleland;
    }

    public int getPREG_maksUforegrad() {
        return PREG_maksUforegrad;
    }

    public void setPREG_maksUforegrad(int PREG_maksUforegrad) {
        this.PREG_maksUforegrad = PREG_maksUforegrad;
    }

    public int getPREG_maksYrkesskadegrad() {
        return PREG_maksYrkesskadegrad;
    }

    public void setPREG_maksYrkesskadegrad(int PREG_maksYrkesskadegrad) {
        this.PREG_maksYrkesskadegrad = PREG_maksYrkesskadegrad;
    }

}
