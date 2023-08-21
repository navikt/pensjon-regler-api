package no.nav.pensjon.regler.domain.beregning2011;


import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.kode.BeregningArsakCti;
import no.nav.pensjon.regler.domain.kode.BorMedTypeCti;
import no.nav.pensjon.regler.domain.kode.SivilstandTypeCti;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public abstract class AbstraktBeregningsResultat implements Serializable {
    private static final long serialVersionUID = -1720992049569505219L;


    private Date virkFom;


    private PensjonUnderUtbetaling pensjonUnderUtbetaling;


    private int uttaksgrad;
    /**
     * Snittet av uttaksgradene i perioden fra (virk bakover i tid til 1 mai) og til (virk fremover i tid til 1 mai).
     */


    private SivilstandTypeCti brukersSivilstand;


    private BorMedTypeCti benyttetSivilstand;


    private BeregningArsakCti beregningArsak;


    private LonnsvekstInformasjon lonnsvekstInformasjon;

    private List<Merknad> merknadListe = new Vector<Merknad>();


    private double gjennomsnittligUttaksgradSisteAr;

     /**
     * PREG versjonsnummer.
     */
    private String PREG_versjon;

    protected AbstraktBeregningsResultat() {
        super();
    }

    protected AbstraktBeregningsResultat(AbstraktBeregningsResultat r) {
        super();
        if (r.virkFom != null) {
            virkFom = (Date) r.virkFom.clone();
        }
        if (r.pensjonUnderUtbetaling != null) {
            pensjonUnderUtbetaling = new PensjonUnderUtbetaling(r.pensjonUnderUtbetaling);
        }
        if (r.brukersSivilstand != null) {
            brukersSivilstand = new SivilstandTypeCti(r.brukersSivilstand);
        }
        if (r.benyttetSivilstand != null) {
            benyttetSivilstand = new BorMedTypeCti(r.benyttetSivilstand);
        }
        if (r.beregningArsak != null) {
            beregningArsak = new BeregningArsakCti(r.beregningArsak);
        }
        if (r.lonnsvekstInformasjon != null) {
            lonnsvekstInformasjon = new LonnsvekstInformasjon(r.lonnsvekstInformasjon);
        }
        uttaksgrad = r.uttaksgrad;
        gjennomsnittligUttaksgradSisteAr = r.gjennomsnittligUttaksgradSisteAr;

        if (r.merknadListe != null) {
            for (Merknad merknad : r.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
        PREG_versjon = r.PREG_versjon;
    }

    public double getGjennomsnittligUttaksgradSisteAr() {
        return gjennomsnittligUttaksgradSisteAr;
    }

    public void setGjennomsnittligUttaksgradSisteAr(double gjennomsnittligUttaksgradSisteAr) {
        this.gjennomsnittligUttaksgradSisteAr = gjennomsnittligUttaksgradSisteAr;
    }

    /**
     * @return the uttaksgrad
     */
    public int getUttaksgrad() {
        return uttaksgrad;
    }

    /**
     * @param uttaksgrad the uttaksgrad to set
     */
    public void setUttaksgrad(int uttaksgrad) {
        this.uttaksgrad = uttaksgrad;
    }

    public LonnsvekstInformasjon getLonnsvekstInformasjon() {
        return lonnsvekstInformasjon;
    }

    public void setLonnsvekstInformasjon(LonnsvekstInformasjon lonnsvekstInformasjon) {
        this.lonnsvekstInformasjon = lonnsvekstInformasjon;
    }

    public PensjonUnderUtbetaling getPensjonUnderUtbetaling() {
        return pensjonUnderUtbetaling;
    }

    public void setPensjonUnderUtbetaling(PensjonUnderUtbetaling pensjonUnderUtbetaling) {
        this.pensjonUnderUtbetaling = pensjonUnderUtbetaling;
    }

    public BorMedTypeCti getBenyttetSivilstand() {
        return benyttetSivilstand;
    }

    public void setBenyttetSivilstand(BorMedTypeCti benyttetSivilstand) {
        this.benyttetSivilstand = benyttetSivilstand;
    }

    public BeregningArsakCti getBeregningArsak() {
        return beregningArsak;
    }

    public void setBeregningArsak(BeregningArsakCti beregningArsak) {
        this.beregningArsak = beregningArsak;
    }

    public SivilstandTypeCti getBrukersSivilstand() {
        return brukersSivilstand;
    }

    public void setBrukersSivilstand(SivilstandTypeCti brukersSivilstand) {
        this.brukersSivilstand = brukersSivilstand;
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    /**
     * @deprecated
     * @return
     */
    @Deprecated
    public Merknad[] retrieveMerknadListeAsArray() {
        return merknadListe.toArray(new Merknad[0]);
    }

    /**
     * Read only property for merknadListe as array.
     * 
     * @return array of Merknad
     */
    public Merknad[] getMerknadListeAsArray() {
        return merknadListe != null ? merknadListe.toArray(new Merknad[merknadListe.size()]) : new Merknad[0];
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    public Date getVirkFom() {
        return virkFom;
    }

    public void setVirkFom(Date virkFom) {
        this.virkFom = virkFom;
    }

    public String getPREG_versjon() {
        return PREG_versjon;
    }

    public void setPREG_versjon(String PREG_versjon) {
        this.PREG_versjon = PREG_versjon;
    }
}
