package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.kode.BarnepensjonEOSKapittelCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Trygdeavtaledetaljer implements Serializable {
    private static final long serialVersionUID = -2694249303389917447L;
    /**
     * Angir om arbeidsinntekten er på minst 1G på uføre-/dødstidspunktet.
     */
    private Boolean arbeidsinntektMinst1G;
    /**
     * Liste med poengår i avtaleland av typen PoengarManuell
     */
    private List<PoengarManuell> poengarListe;
    /**
     * Faktisk trygdetid i andre EØS-land for alternativ pro rata beregning
     */
    private AntallArOgMnd ftt_andreEOSLand;
    /**
     * Faktisk trygdetid garantitillegg
     */
    private AntallArOgMnd ftt_garanti;
    /**
     * Faktisk trygdetid annet nordisk land
     */
    private AntallArOgMnd ftt_annetNordiskLand;
    /**
     * Sum pensjon i andre avtaleland
     */
    private int sumPensjonAndreAvtaleland;
    /**
     * Inntektsprøvet pensjon fra annet avtaleland
     */
    private Boolean inntektsprovetPensjonAvtaleland;
    /**
     * Art.10 anvendes på grunnpensjon
     */
    private Boolean erArt10BruktGP;
    /**
     * Art.10 anvendes på tilleggspensjon
     */
    private Boolean erArt10BruktTP;
    /**
     * Antall faktiske poengår i annet nordisk land
     */
    private int fpa_nordisk;
    /**
     * Angir hvilket kapittel (3 eller 8) i forordning 1408/71 barnepensjon skal beregnes etter ved EØS-saker.
     */
    private BarnepensjonEOSKapittelCti barnepensjonForordning1408_71;

    /**
     * Copy Constructor
     * 
     * @param trygdeavtaledetaljer a <code>Trygdeavtaledetaljer</code> object
     */
    public Trygdeavtaledetaljer(Trygdeavtaledetaljer trygdeavtaledetaljer) {
        if (trygdeavtaledetaljer.arbeidsinntektMinst1G != null) {
            arbeidsinntektMinst1G = new Boolean(trygdeavtaledetaljer.arbeidsinntektMinst1G);
        }
        poengarListe = new ArrayList<PoengarManuell>();
        if (trygdeavtaledetaljer.poengarListe != null) {
            for (PoengarManuell poengarManuell : trygdeavtaledetaljer.poengarListe) {
                poengarListe.add(new PoengarManuell(poengarManuell));
            }
        }
        if (trygdeavtaledetaljer.ftt_andreEOSLand != null) {
            ftt_andreEOSLand = new AntallArOgMnd(trygdeavtaledetaljer.ftt_andreEOSLand);
        }
        if (trygdeavtaledetaljer.ftt_garanti != null) {
            ftt_garanti = new AntallArOgMnd(trygdeavtaledetaljer.ftt_garanti);
        }
        if (trygdeavtaledetaljer.ftt_annetNordiskLand != null) {
            ftt_annetNordiskLand = new AntallArOgMnd(trygdeavtaledetaljer.ftt_annetNordiskLand);
        }
        sumPensjonAndreAvtaleland = trygdeavtaledetaljer.sumPensjonAndreAvtaleland;
        if (trygdeavtaledetaljer.inntektsprovetPensjonAvtaleland != null) {
            inntektsprovetPensjonAvtaleland = new Boolean(trygdeavtaledetaljer.inntektsprovetPensjonAvtaleland);
        }
        if (trygdeavtaledetaljer.erArt10BruktGP != null) {
            erArt10BruktGP = new Boolean(trygdeavtaledetaljer.erArt10BruktGP);
        }
        if (trygdeavtaledetaljer.erArt10BruktTP != null) {
            erArt10BruktTP = new Boolean(trygdeavtaledetaljer.erArt10BruktTP);
        }
        fpa_nordisk = trygdeavtaledetaljer.fpa_nordisk;
        if (trygdeavtaledetaljer.barnepensjonForordning1408_71 != null) {
            barnepensjonForordning1408_71 = new BarnepensjonEOSKapittelCti(trygdeavtaledetaljer.barnepensjonForordning1408_71);
        }
    }

    public Trygdeavtaledetaljer() {
        super();
        poengarListe = new ArrayList<PoengarManuell>();
    }

    public Trygdeavtaledetaljer(Boolean arbeidsinntektMinst1G, List<PoengarManuell> poengarListe, AntallArOgMnd ftt_andreEOSLand, AntallArOgMnd ftt_garanti,
                                AntallArOgMnd ftt_annetNordiskLand, int sumPensjonAndreAvtaleland, Boolean inntektsprovetPensjonAvtaleland, Boolean erArt10BruktGP,
                                Boolean erArt10BruktTP, int fpa_nordisk, BarnepensjonEOSKapittelCti barnepensjonForordning1408_71) {
        super();
        this.arbeidsinntektMinst1G = arbeidsinntektMinst1G;
        this.poengarListe = poengarListe;
        this.ftt_andreEOSLand = ftt_andreEOSLand;
        this.ftt_garanti = ftt_garanti;
        this.ftt_annetNordiskLand = ftt_annetNordiskLand;
        this.sumPensjonAndreAvtaleland = sumPensjonAndreAvtaleland;
        this.inntektsprovetPensjonAvtaleland = inntektsprovetPensjonAvtaleland;
        this.erArt10BruktGP = erArt10BruktGP;
        this.erArt10BruktTP = erArt10BruktTP;
        this.fpa_nordisk = fpa_nordisk;
        this.barnepensjonForordning1408_71 = barnepensjonForordning1408_71;
    }

    public Boolean getArbeidsinntektMinst1G() {
        return arbeidsinntektMinst1G;
    }

    public void setArbeidsinntektMinst1G(Boolean arbeidsinntektMinst1G) {
        this.arbeidsinntektMinst1G = arbeidsinntektMinst1G;
    }

    public Boolean getErArt10BruktGP() {
        return erArt10BruktGP;
    }

    public void setErArt10BruktGP(Boolean erArt10BruktGP) {
        this.erArt10BruktGP = erArt10BruktGP;
    }

    public Boolean getErArt10BruktTP() {
        return erArt10BruktTP;
    }

    public void setErArt10BruktTP(Boolean erArt10BruktTP) {
        this.erArt10BruktTP = erArt10BruktTP;
    }

    public int getFpa_nordisk() {
        return fpa_nordisk;
    }

    public void setFpa_nordisk(int fpa_nordisk) {
        this.fpa_nordisk = fpa_nordisk;
    }

    public AntallArOgMnd getFtt_andreEOSLand() {
        return ftt_andreEOSLand;
    }

    public void setFtt_andreEOSLand(AntallArOgMnd ftt_andreEOSLand) {
        this.ftt_andreEOSLand = ftt_andreEOSLand;
    }

    public AntallArOgMnd getFtt_annetNordiskLand() {
        return ftt_annetNordiskLand;
    }

    public void setFtt_annetNordiskLand(AntallArOgMnd ftt_annetNordiskLand) {
        this.ftt_annetNordiskLand = ftt_annetNordiskLand;
    }

    public AntallArOgMnd getFtt_garanti() {
        return ftt_garanti;
    }

    public void setFtt_garanti(AntallArOgMnd ftt_garanti) {
        this.ftt_garanti = ftt_garanti;
    }

    public Boolean getInntektsprovetPensjonAvtaleland() {
        return inntektsprovetPensjonAvtaleland;
    }

    public void setInntektsprovetPensjonAvtaleland(Boolean inntektsprovetPensjonAvtaleland) {
        this.inntektsprovetPensjonAvtaleland = inntektsprovetPensjonAvtaleland;
    }

    public List<PoengarManuell> getPoengarListe() {
        return poengarListe;
    }

    public void setPoengarListe(List<PoengarManuell> poengarListe) {
        this.poengarListe = poengarListe;
    }

    /**
     * @deprecated
     * @return Returns the poengarListe as array.
     */
    @Deprecated
    public PoengarManuell[] retrievePoengarListeAsArray() {
        return poengarListe.toArray(new PoengarManuell[0]);
    }

    /**
     * Read only property for poengarListe as array.
     * 
     * @return array of PoengarManuell
     */
    public PoengarManuell[] getPoengarListeAsArray() {
        return poengarListe != null ? poengarListe.toArray(new PoengarManuell[poengarListe.size()]) : new PoengarManuell[0];
    }

    public int getSumPensjonAndreAvtaleland() {
        return sumPensjonAndreAvtaleland;
    }

    public void setSumPensjonAndreAvtaleland(int sumPensjonAndreAvtaleland) {
        this.sumPensjonAndreAvtaleland = sumPensjonAndreAvtaleland;
    }

    public BarnepensjonEOSKapittelCti getBarnepensjonForordning1408_71() {
        return barnepensjonForordning1408_71;
    }

    public void setBarnepensjonForordning1408_71(BarnepensjonEOSKapittelCti barnepensjonForordning1408_71) {
        this.barnepensjonForordning1408_71 = barnepensjonForordning1408_71;
    }
}
