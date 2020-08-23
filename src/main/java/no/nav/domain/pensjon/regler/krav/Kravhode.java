package no.nav.domain.pensjon.regler.krav;

import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.grunnlag.Uttaksgrad;
import no.nav.domain.pensjon.regler.kode.AfpOrdningTypeCti;
import no.nav.domain.pensjon.regler.kode.KravVelgTypeCti;
import no.nav.domain.pensjon.regler.kode.RegelverkTypeCti;
import no.nav.domain.pensjon.regler.kode.SakTypeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kravhode utgjør, sammen med en liste av VilkarsVedtak, hele inndata for
 * de fleste regeltjenestene.
 *
 * @author Magnus Bakken (Accenture), PK-10597
 * @author Dag Brenna (Accenture), PK-15267
 */
public class Kravhode implements Serializable {

    private static final long serialVersionUID = 913074293687419008L;
    /**
     * Liste av personer som inngår som datagrunnlag.
     * Nøyaktig en person i listen må ha rollen "SOKER".
     */
    private List<Persongrunnlag> persongrunnlagListe;

    /**
     * Liste av krav søkeren fremmer.
     */
    private List<Kravlinje> kravlinjeListe;
    /**
     * Angir type AFPordning.
     */
    private AfpOrdningTypeCti afpOrdning;

    /**
     * Angir om søker skal ha afptillegg.
     */
    private boolean afptillegg;
    /*
     * Angir om opptjeningen fra det 65 året skal brukes som opptjening i det 66 år fram til brukeren fyller 70 år.
     * Settes av Regelmotoren første gang.
     */
    private boolean brukOpptjeningFra65I66Aret;
    /**
     * Angir detaljering i kravet,brukes i barnepensjon.
     */
    private KravVelgTypeCti kravVelgType;

    /**
     * Angir om personen som kravet gjelder har bodd eller arbeidet utenlands:
     */
    private boolean boddEllerArbeidetIUtlandet;

    /**
     * Flagg som angir om brukerens far har bodd eller arbeidet i utlandet.
     */
    private boolean boddArbeidUtlandFar;

    /**
     * Flagg som angir om brukerens mor har bodd eller arbeidet i utlandet.
     */
    private boolean boddArbeidUtlandMor;

    /**
     * Flagg som angir om brukerens avdøde E/P/S har bodd eller arbeidet i utlandet.
     */
    private boolean boddArbeidUtlandAvdod;

    private List<Uttaksgrad> uttaksgradListe;

    private RegelverkTypeCti regelverkTypeCti;
    /**
     * Angir siste sakstype før overgang til AP.
     */
    private SakTypeCti sisteSakstypeForAP;

    /**
     * Angir om ektefellen mottar pensjon.
     * Innført ifm CR140475. BeregnYtelse blir kalt med flagget ektefelleMottarPensjon i Request-objektet.
     * Det flagget blir overført til PREG_epsMottarPensjon i startBeregnYtelse slik at det blir med inn
     * til initPREG(kravhode, ..). initPREG utvides til å kalle en ny funksjon settEpsMottarPensjon som
     * setter flagget tilknyttet.mottarPensjon lik ektefelleMottarPensjon i Request-objektet.
     * Dermed kan regelsettet TilknyttetHarPensjonRS i støttefunksjoner kun bytte innholdet til å bruke
     * tilknyttet.mottarPensjon istedet for å se etter PENF inntekt osv.
     */
    private boolean PREG_epsMottarPensjon;

	/*
	* Felt for å tre p_satsGP fra SisteAldersberegning2011.basispensjon.gp.p_satsGP  inn til BestemPsatsGPRS
	* i forbindelse med kall tilBER 3152 RevurderingOpptjening. Innført ifm PK15267/PEN6372
	 */
	private double overstyrendeP_satsGP;

    /*
    * Angir om barnetilleggsgrunnlag er på nytt format (Gjelder per i dag uføretrygd).
     */
    private boolean btVurderingsperiodeBenyttet;

    /**
     * Copy Constructor
     * 
     * @param kravhode a <code>Kravhode</code> object
     */
    public Kravhode(Kravhode kravhode) {
        persongrunnlagListe = new ArrayList<Persongrunnlag>();
        if (kravhode.persongrunnlagListe != null) {
            for (Persongrunnlag persongrunnlag : kravhode.persongrunnlagListe) {
                persongrunnlagListe.add(new Persongrunnlag(persongrunnlag));
            }
        }
        kravlinjeListe = new ArrayList<Kravlinje>();
        if (kravhode.kravlinjeListe != null) {
            for (Kravlinje kravlinje : kravhode.kravlinjeListe) {
                kravlinjeListe.add(new Kravlinje(kravlinje));
            }
        }
        if (kravhode.afpOrdning != null) {
            afpOrdning = new AfpOrdningTypeCti(kravhode.afpOrdning);
        }
        afptillegg = kravhode.afptillegg;
        brukOpptjeningFra65I66Aret = kravhode.brukOpptjeningFra65I66Aret;
        if (kravhode.kravVelgType != null) {
            kravVelgType = new KravVelgTypeCti(kravhode.kravVelgType);
        }
        boddEllerArbeidetIUtlandet = kravhode.boddEllerArbeidetIUtlandet;
        boddArbeidUtlandFar = kravhode.boddArbeidUtlandFar;
        boddArbeidUtlandMor = kravhode.boddArbeidUtlandFar;
        boddArbeidUtlandAvdod = kravhode.boddArbeidUtlandAvdod;

        uttaksgradListe = new ArrayList<Uttaksgrad>();
        if (kravhode.uttaksgradListe != null) {
            for (Uttaksgrad uttaksgrad : kravhode.uttaksgradListe) {
                uttaksgradListe.add(new Uttaksgrad(uttaksgrad));
            }
            sorterUttaksgradListe();
        }
        regelverkTypeCti = kravhode.regelverkTypeCti;
        sisteSakstypeForAP = kravhode.sisteSakstypeForAP;
        PREG_epsMottarPensjon = kravhode.PREG_epsMottarPensjon;
		overstyrendeP_satsGP = kravhode.overstyrendeP_satsGP;
        btVurderingsperiodeBenyttet = kravhode.btVurderingsperiodeBenyttet;
    }

    public Kravhode(List<Persongrunnlag> persongrunnlagListe, List<Kravlinje> kravlinjeListe, AfpOrdningTypeCti afpOrdning, boolean afptillegg, boolean brukOpptjeningFra65I66Aret,
                    KravVelgTypeCti kravVelgType, boolean boddEllerArbeidetIUtlandet, List<Uttaksgrad> uttaksgradListe, boolean vurdereTrygdeavtale,
                    RegelverkTypeCti regelverkTypeCti, SakTypeCti sisteSakstypeForAP) {
        super();
        this.persongrunnlagListe = persongrunnlagListe;
        this.kravlinjeListe = kravlinjeListe;
        this.afpOrdning = afpOrdning;
        this.afptillegg = afptillegg;
        this.brukOpptjeningFra65I66Aret = brukOpptjeningFra65I66Aret;
        this.kravVelgType = kravVelgType;
        this.boddEllerArbeidetIUtlandet = boddEllerArbeidetIUtlandet;
        this.uttaksgradListe = uttaksgradListe;
        this.regelverkTypeCti = regelverkTypeCti;
        this.sisteSakstypeForAP = sisteSakstypeForAP;
        sorterUttaksgradListe();
    }

    public Kravhode() {
        super();
        persongrunnlagListe = new ArrayList<Persongrunnlag>();
        kravlinjeListe = new ArrayList<Kravlinje>();
        uttaksgradListe = new ArrayList<Uttaksgrad>();
        sorterUttaksgradListe();
    }

    public List<Persongrunnlag> getPersongrunnlagListe() {
        return persongrunnlagListe;
    }

    public void setPersongrunnlagListe(List<Persongrunnlag> persongrunnlagListe) {
        this.persongrunnlagListe = persongrunnlagListe;
    }

    /**
     * @deprecated
     * @return Returns the persongrunnlagListe as array.
     */
    @Deprecated
    public Persongrunnlag[] retrievePersongrunnlagListeAsArray() {
        return persongrunnlagListe != null ? persongrunnlagListe.toArray(new Persongrunnlag[persongrunnlagListe.size()]) : new Persongrunnlag[0];
    }

    /**
     * Read only property for persongrunnlagListe as array.
     *
     * @return array of Persongrunnlag
     */
    public Persongrunnlag[] getPersongrunnlagListeAsArray() {
        return persongrunnlagListe != null ? persongrunnlagListe.toArray(new Persongrunnlag[persongrunnlagListe.size()]) : new Persongrunnlag[0];
    }

    /**
     * Samme som getPersongrunnlagListeAsArray, men med annet navn slik at Blaze forstår dette som en metode.
     * Workaround når man ønsker å sjekke persongrunnlagliste as array flere ganger. (Brukt i BEF145)
     *
     * @return array med Persongrunnlag
     */
    public Persongrunnlag[] hentPersongrunnlagListeAsArray() {
        return getPersongrunnlagListeAsArray();
    }

    public List<Kravlinje> getKravlinjeListe() {
        return kravlinjeListe;
    }

    public void setKravlinjeListe(List<Kravlinje> kravlinjeListe) {
        this.kravlinjeListe = kravlinjeListe;
    }

    /**
     * @deprecated
     * @return Returns the persongrunnlagListe as array.
     */
    @Deprecated
    public Kravlinje[] retrieveKravlinjeListeAsArray() {
        return kravlinjeListe.toArray(new Kravlinje[0]);
    }

    /**
     * Read only property for kravlinjeListe as array.
     *
     * @return array of Kravlinje
     */
    public Kravlinje[] getKravlinjeListeAsArray() {
        return kravlinjeListe != null ? kravlinjeListe.toArray(new Kravlinje[kravlinjeListe.size()]) : new Kravlinje[0];
    }

    /**
     * @deprecated
     * @return
     */
    @Deprecated
    public Uttaksgrad[] retrieveUttaksgradListeAsArray() {
        return uttaksgradListe.toArray(new Uttaksgrad[0]);
    }

    /**
     * Read only property for uttaksgradListe as array.
     *
     * @return array of Uttaksgrad
     */
    public Uttaksgrad[] getUttaksgradListeAsArray() {
        return uttaksgradListe != null ? uttaksgradListe.toArray(new Uttaksgrad[uttaksgradListe.size()]) : new Uttaksgrad[0];
    }

    /**
     * Sorterer på nyeste fomDato - denne blir uttaksgradListe.get(0)
     */
    private void sorterUttaksgradListe() {
        if (uttaksgradListe != null) {
            Collections.sort(uttaksgradListe, Collections.reverseOrder());
        }
        return;
    }

    public Uttaksgrad[] sortertUttaksgradListe() {
        sorterUttaksgradListe();
        return uttaksgradListe.toArray(new Uttaksgrad[0]);
    }

    public AfpOrdningTypeCti getAfpOrdning() {
        return afpOrdning;
    }

    public void setAfpOrdning(AfpOrdningTypeCti afpOrdning) {
        this.afpOrdning = afpOrdning;
    }

    public boolean isAfptillegg() {
        return afptillegg;
    }

    public void setAfptillegg(boolean afptillegg) {
        this.afptillegg = afptillegg;
    }

    public boolean isBrukOpptjeningFra65I66Aret() {
        return brukOpptjeningFra65I66Aret;
    }

    public void setBrukOpptjeningFra65I66Aret(boolean brukOpptjeningFra65I66Aret) {
        this.brukOpptjeningFra65I66Aret = brukOpptjeningFra65I66Aret;
    }

    public KravVelgTypeCti getKravVelgType() {
        return kravVelgType;
    }

    public void setKravVelgType(KravVelgTypeCti kravVelgType) {
        this.kravVelgType = kravVelgType;
    }

    public boolean isBoddEllerArbeidetIUtlandet() {
        return boddEllerArbeidetIUtlandet;
    }

    public void setBoddEllerArbeidetIUtlandet(boolean boddEllerArbeidetIUtlandet) {
        this.boddEllerArbeidetIUtlandet = boddEllerArbeidetIUtlandet;
    }

    public boolean isBoddArbeidUtlandAvdod() {
        return boddArbeidUtlandAvdod;
    }

    public void setBoddArbeidUtlandAvdod(boolean boddArbeidUtlandAvdod) {
        this.boddArbeidUtlandAvdod = boddArbeidUtlandAvdod;
    }

    public boolean isBoddArbeidUtlandFar() {
        return boddArbeidUtlandFar;
    }

    public void setBoddArbeidUtlandFar(boolean boddArbeidUtlandFar) {
        this.boddArbeidUtlandFar = boddArbeidUtlandFar;
    }

    public boolean isBoddArbeidUtlandMor() {
        return boddArbeidUtlandMor;
    }

    public void setBoddArbeidUtlandMor(boolean boddArbeidUtlandMor) {
        this.boddArbeidUtlandMor = boddArbeidUtlandMor;
    }

    public List<Uttaksgrad> getUttaksgradListe() {
        return uttaksgradListe;
    }

    public void setUttaksgradListe(List<Uttaksgrad> uttaksgradListe) {
        this.uttaksgradListe = uttaksgradListe;
        sorterUttaksgradListe();
    }

    public RegelverkTypeCti getRegelverkTypeCti() {
        return regelverkTypeCti;
    }

    public void setRegelverkTypeCti(RegelverkTypeCti regelverkTypeCti) {
        this.regelverkTypeCti = regelverkTypeCti;
    }

    public SakTypeCti getSisteSakstypeForAP() {
        return sisteSakstypeForAP;
    }

    public void setSisteSakstypeForAP(SakTypeCti sisteSakstypeForAP) {
        this.sisteSakstypeForAP = sisteSakstypeForAP;
    }

    public boolean isPREG_epsMottarPensjon() {
        return PREG_epsMottarPensjon;
    }

    public void setPREG_epsMottarPensjon(boolean mottarPensjon) {
        PREG_epsMottarPensjon = mottarPensjon;
    }
	public double getOverstyrendeP_satsGP() {
		return overstyrendeP_satsGP;
	}

	public void setOverstyrendeP_satsGP(double overstyrendeP_satsGP) {
		this.overstyrendeP_satsGP = overstyrendeP_satsGP;
	}

    public boolean isBtVurderingsperiodeBenyttet() {
        return btVurderingsperiodeBenyttet;
    }

    public void setBtVurderingsperiodeBenyttet(boolean btVurderingsperiodeBenyttet) {
        this.btVurderingsperiodeBenyttet = btVurderingsperiodeBenyttet;
    }

}
