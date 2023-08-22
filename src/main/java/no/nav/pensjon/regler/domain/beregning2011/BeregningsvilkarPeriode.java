package no.nav.pensjon.regler.domain.beregning2011;


import no.nav.pensjon.regler.domain.util.DateCompareUtil;
import no.nav.pensjon.regler.domain.vedtak.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Magnus Bakken (Accenture), PK-10597, PKPYTON-1063, PK-9695, PKPYTON-923
 * @author Swiddy de Louw (Capgemini), PK-8704,PKPYTON-563
 * Husk at når du legger til nye "smarte metoder" som f.eks set/getInntektEtterUforhet(), at dette må gjøres også i VilkarsVedtak som da
 * agerer på seneste fomDato i beregningsvilkarperiodeListe.
 * @author Steinar Hjellvik (Decisive) - PK-11391, PKPYTON-1447 Rettet feil i copy constructor. Den var ikke nullpointer safe ved kall til dypKopi metode.
 */

public class BeregningsvilkarPeriode implements Serializable, Comparable<BeregningsvilkarPeriode> {

    private static final long serialVersionUID = -5083292525147237144L;

    /**
     * Fom dato for perioden de angitte beregningsvilkår og vilkår gjelder for
     */

    private Date fomDato;

    /**
     * Tom dato for perioden de angitte beregningsvilkår og vilkår gjelder for
     */

    private Date tomDato;

    /**
     * Liste av beregningsvilkår til bruk ved beregning av uføretrygd.
     */
    private List<AbstraktBeregningsvilkar> beregningsvilkarListe;

    /**
     * Liste av vilkår til bruk ved beregning av uføretrygd.
     */
    private List<AbstraktVilkar> vilkarListe;

    /**
     * PREG variabel for å markere perioden at beregningsgrunnlagOrdiner er konvertert.
     */
    private boolean PREG_konvertertOrdiner;

    /**
     * PREG variabel for å markere perioden at beregningsgrunnlagYrkesskade er konvertert.
     */
    private boolean PREG_konvertertYrkesskade;

    /**
     * PREG variabel som angir hvorvidt perioden er av betydning for uføretrygdopptjening. Hvis satt er ufgFom/ufgTom relevante.
     */
    private boolean PREG_uforetrygdOpptjening;

    /**
     * PREG variabel som angir hvilket år denne periodens uføregrad gjelder fra mht. opptjening fra uføretrygd.
     */
    private Date PREG_ufgFom;

    /**
     * PREG variabel som angir hvilket år denne periodens uføregrad gjelder til mht. opptjening fra uføretrygd.
     */
    private Date PREG_ufgTom;

    /**
     * PREG variabel som angir om perioden representerer et opphør eller en gjenoppliving av uføreytelsen.
     */
    private int PREG_opphorEllerGjenopplivingType;

    public BeregningsvilkarPeriode() {
        super();
        beregningsvilkarListe = new ArrayList<AbstraktBeregningsvilkar>();
        vilkarListe = new ArrayList<AbstraktVilkar>();
    }

    public BeregningsvilkarPeriode(Date fomDato, Date tomDato, List<AbstraktBeregningsvilkar> beregningsvilkarListe, List<AbstraktVilkar> vilkarListe) {
        this();
        this.fomDato = fomDato;
        this.tomDato = tomDato;
        this.beregningsvilkarListe = beregningsvilkarListe;
        this.vilkarListe = vilkarListe;
    }

    /**
     * Copy constructor.
     * NB: Liste av vilkar og beregningsvilkar kan inneholde innslag som er null.
     * Derfor null sjekk før kall til dypKopi.
     * 
     * @param bvp
     */
    public BeregningsvilkarPeriode(BeregningsvilkarPeriode bvp) {
        this();
        if (bvp.fomDato != null) {
            fomDato = (Date) bvp.fomDato.clone();
        }
        if (bvp.tomDato != null) {
            tomDato = (Date) bvp.tomDato.clone();
        }
        if (bvp.beregningsvilkarListe != null) {
            for (AbstraktBeregningsvilkar bv : bvp.beregningsvilkarListe) {
                if (bv != null) {
                    beregningsvilkarListe.add(bv.dypKopi(bv));
                }
            }
        }
        if (bvp.vilkarListe != null) {
            for (AbstraktVilkar vk : bvp.vilkarListe) {
                if (vk != null) {
                    vilkarListe.add(vk.dypKopi(vk));
                }
            }
        }
        PREG_konvertertOrdiner = bvp.PREG_konvertertOrdiner;
        PREG_konvertertYrkesskade = bvp.PREG_konvertertYrkesskade;
        PREG_uforetrygdOpptjening = bvp.PREG_uforetrygdOpptjening;
        PREG_ufgFom = bvp.PREG_ufgFom;
        PREG_ufgTom = bvp.PREG_ufgTom;
    }

    /**
     * @return the fomDato
     */
    public Date getFomDato() {
        return fomDato;
    }

    /**
     * @param fomDato the fomDato to set
     */
    public void setFomDato(Date fomDato) {
        this.fomDato = fomDato;
    }

    /**
     * @return the tomDato
     */
    public Date getTomDato() {
        return tomDato;
    }

    /**
     * @param tomDato the tomDato to set
     */
    public void setTomDato(Date tomDato) {
        this.tomDato = tomDato;
    }

    /**
     * @return the beregningsvilkarListe
     */
    public List<AbstraktBeregningsvilkar> getBeregningsvilkarListe() {
        return beregningsvilkarListe;
    }

    /**
     * @param beregningsvilkarListe the beregningsvilkarListe to set
     */
    public void setBeregningsvilkarListe(List<AbstraktBeregningsvilkar> beregningsvilkarListe) {
        this.beregningsvilkarListe = beregningsvilkarListe;
    }

    /**
     * @return the vilkarListe
     */
    public List<AbstraktVilkar> getVilkarListe() {
        return vilkarListe;
    }

    /**
     * @param vilkarListe the vilkarListe to set
     */
    public void setVilkarListe(List<AbstraktVilkar> vilkarListe) {
        this.vilkarListe = vilkarListe;
    }

    @SuppressWarnings("unchecked")
    private <T extends AbstraktBeregningsvilkar> T hentBeregningsvilkar(Class<T> classOfBeregningsvilkar) {
        for (AbstraktBeregningsvilkar bvilk : beregningsvilkarListe) {
            if (classOfBeregningsvilkar.isInstance(bvilk)) {
                return (T) bvilk;
            }
        }
        return null;
    }

    private <T extends AbstraktBeregningsvilkar> void settBeregningsvilkar(Class<T> classOfBeregningsvilkar, T beregningsvilkar) {
        AbstraktBeregningsvilkar old = hentBeregningsvilkar(classOfBeregningsvilkar);
        if (old != null) {
            beregningsvilkarListe.remove(old);
        }
        if (beregningsvilkar != null) {
            beregningsvilkarListe.add(beregningsvilkar);
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends AbstraktVilkar> T hentVilkar(Class<T> classOfVilkar) {
        for (AbstraktVilkar vilk : vilkarListe) {
            if (classOfVilkar.isInstance(vilk)) {
                return (T) vilk;
            }
        }
        return null;
    }

    private <T extends AbstraktVilkar> void settVilkar(Class<T> classOfVilkar, T vilkar) {
        AbstraktVilkar old = hentVilkar(classOfVilkar);
        if (old != null) {
            vilkarListe.remove(old);
        }
        if (vilkar != null) {
            vilkarListe.add(vilkar);
        }
    }

    /**
     * @return trygdetidberegningsvilkår på beregningsvilkårlisten, null hvis det ikke finnes.
     */
    public TrygdetidBeregningsvilkar getTrygdetidBeregningsvilkar() {
        return hentBeregningsvilkar(TrygdetidBeregningsvilkar.class);
    }

    /**
     * Legg til nytt trygdetidberegningsvilkår i listen av beregningsvilkår, erstatter eksisterende beregningsvilkartrygdetidvilkår om det finnes.
     * 
     * @param trygdetidBeregningsvilkar nytt trygdetidberegningsvilkår som skal legges til.
     */
    public void setTrygdetidBeregningsvilkar(TrygdetidBeregningsvilkar trygdetidBeregningsvilkar) {
        settBeregningsvilkar(TrygdetidBeregningsvilkar.class, trygdetidBeregningsvilkar);
    }

    public Uforegrad getUforegrad() {
        return hentBeregningsvilkar(Uforegrad.class);
    }

    public void setUforegrad(Uforegrad uforegrad) {
        settBeregningsvilkar(Uforegrad.class, uforegrad);
    }

    public Uforetidspunkt getUforetidspunkt() {
        return hentBeregningsvilkar(Uforetidspunkt.class);
    }

    public void setUforetidspunkt(Uforetidspunkt uforetidspunkt) {
        settBeregningsvilkar(Uforetidspunkt.class, uforetidspunkt);
    }

    public Yrkesskadegrad getYrkesskadegrad() {
        return hentBeregningsvilkar(Yrkesskadegrad.class);
    }

    public void setYrkesskadegrad(Yrkesskadegrad yrkesskadegrad) {
        settBeregningsvilkar(Yrkesskadegrad.class, yrkesskadegrad);
    }

    public Skadetidspunkt getSkadetidspunkt() {
        return hentBeregningsvilkar(Skadetidspunkt.class);
    }

    public void setSkadetidspunkt(Skadetidspunkt skadetidspunkt) {
        settBeregningsvilkar(Skadetidspunkt.class, skadetidspunkt);
    }

    public InntektVedSkadetidspunktet getInntektVedSkadetidspunktet() {
        return hentBeregningsvilkar(InntektVedSkadetidspunktet.class);
    }

    public void setInntektVedSkadetidspunktet(InntektVedSkadetidspunktet inntektVedSkadetidspunktet) {
        settBeregningsvilkar(InntektVedSkadetidspunktet.class, inntektVedSkadetidspunktet);
    }

    public InntektForUforhet getInntektForUforhet() {
        return hentBeregningsvilkar(InntektForUforhet.class);
    }

    public void setInntektForUforhet(InntektForUforhet inntektForUforhet) {
        settBeregningsvilkar(InntektForUforhet.class, inntektForUforhet);
    }

    public InntektEtterUforhet getInntektEtterUforhet() {
        return hentBeregningsvilkar(InntektEtterUforhet.class);
    }

    public void setInntektEtterUforhet(InntektEtterUforhet inntektEtterUforhet) {
        settBeregningsvilkar(InntektEtterUforhet.class, inntektEtterUforhet);
    }

    public UngUfor getUngUfor() {
        return hentVilkar(UngUfor.class);
    }

    public void setUngUfor(UngUfor ungUfor) {
        settVilkar(UngUfor.class, ungUfor);
    }

    public Yrkesskade getYrkesskade() {
        return hentVilkar(Yrkesskade.class);
    }

    public void setYrkesskade(Yrkesskade yrkesskade) {
        settVilkar(Yrkesskade.class, yrkesskade);
    }

    public FortsattMedlemskap getFortsattMedlemskap() {
        return hentVilkar(FortsattMedlemskap.class);
    }

    public void setFortsattMedlemskap(FortsattMedlemskap fortsattMedlemskap) {
        settVilkar(FortsattMedlemskap.class, fortsattMedlemskap);
    }

    public ForutgaendeMedlemskap getForutgaendeMedlemskap() {
        return hentVilkar(ForutgaendeMedlemskap.class);
    }

    public void setForutgaendeMedlemskap(ForutgaendeMedlemskap forutgaendeMedlemskap) {
        settVilkar(ForutgaendeMedlemskap.class, forutgaendeMedlemskap);
    }

    public MedlemskapForUTEtterTrygdeavtaler getMedlemskapForUTEtterTrygdeavtaler() {
        return hentVilkar(MedlemskapForUTEtterTrygdeavtaler.class);
    }

    public void setMedlemskapForUTEtterTrygdeavtaler(MedlemskapForUTEtterTrygdeavtaler medlemskapForUTEtterTrygdeavtaler) {
        settVilkar(MedlemskapForUTEtterTrygdeavtaler.class, medlemskapForUTEtterTrygdeavtaler);
    }

    public RettTilEksportEtterTrygdeavtaler getRettTilEksportEtterTrygdeavtaler() {
        return hentVilkar(RettTilEksportEtterTrygdeavtaler.class);
    }

    public void setRettTilEksportEtterTrygdeavtaler(RettTilEksportEtterTrygdeavtaler rettTilEksportEtterTrygdeavtaler) {
        settVilkar(RettTilEksportEtterTrygdeavtaler.class, rettTilEksportEtterTrygdeavtaler);
    }

    public RettTilGjenlevendetillegg getRettTilGjenlevendetillegg() {
        return hentVilkar(RettTilGjenlevendetillegg.class);
    }

    public void setRettTilGjenlevendetillegg(RettTilGjenlevendetillegg rettTilGjenlevendetillegg) {
        settVilkar(RettTilGjenlevendetillegg.class, rettTilGjenlevendetillegg);
    }

    public Alderspensjon2011VedDod getAlderspensjon2011VedDod() {
        return hentBeregningsvilkar(Alderspensjon2011VedDod.class);
    }

    public void setAlderspensjon2011VedDod(Alderspensjon2011VedDod alderspensjon2011VedDod) {
        settBeregningsvilkar(Alderspensjon2011VedDod.class, alderspensjon2011VedDod);
    }

    public TidligereGjenlevendePensjon getTidligereGjenlevendePensjon() {
        return hentBeregningsvilkar(TidligereGjenlevendePensjon.class);
    }

    public void setTidligereGjenlevendePensjon(TidligereGjenlevendePensjon tidligereGjenlevendePensjon) {
        settBeregningsvilkar(TidligereGjenlevendePensjon.class, tidligereGjenlevendePensjon);
    }

    @Override
    public int compareTo(BeregningsvilkarPeriode bvp) {
        return DateCompareUtil.compareTo(getFomDato(), bvp.getFomDato());
    }

    public boolean isPREG_konvertertOrdiner() {
        return PREG_konvertertOrdiner;
    }

    public void setPREG_konvertertOrdiner(boolean pREG_konvertertOrdiner) {
        PREG_konvertertOrdiner = pREG_konvertertOrdiner;
    }

    public boolean isPREG_konvertertYrkesskade() {
        return PREG_konvertertYrkesskade;
    }

    public void setPREG_konvertertYrkesskade(boolean pREG_konvertertYrkesskade) {
        PREG_konvertertYrkesskade = pREG_konvertertYrkesskade;
    }

    public boolean isPREG_uforetrygdOpptjening() {
        return PREG_uforetrygdOpptjening;
    }

    public void setPREG_uforetrygdOpptjening(boolean pREG_uforetrygdOpptjening) {
        PREG_uforetrygdOpptjening = pREG_uforetrygdOpptjening;
    }

    public Date getPREG_ufgFom() {
        return PREG_ufgFom;
    }

    public void setPREG_ufgFom(Date pREG_ufgFom) {
        PREG_ufgFom = pREG_ufgFom;
    }

    public Date getPREG_ufgTom() {
        return PREG_ufgTom;
    }

    public void setPREG_ufgTom(Date pREG_ufgTom) {
        PREG_ufgTom = pREG_ufgTom;
    }

    public int getPREG_opphorEllerGjenopplivingType() {
        return PREG_opphorEllerGjenopplivingType;
    }

    public void setPREG_opphorEllerGjenopplivingType(int PREG_opphorEllerGjenopplivingType) {
        this.PREG_opphorEllerGjenopplivingType = PREG_opphorEllerGjenopplivingType;
    }
}
