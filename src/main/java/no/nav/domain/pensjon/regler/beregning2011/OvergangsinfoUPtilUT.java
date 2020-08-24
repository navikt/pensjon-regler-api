package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;
import no.nav.domain.pensjon.regler.kode.MinstepensjonTypeCti;
import no.nav.domain.pensjon.regler.kode.ResultatKildeCti;
import no.nav.domain.pensjon.regler.trygdetid.AnvendtTrygdetid;

import java.io.Serializable;

/**
 * Informasjon mht overgang fra UP til UT
 * 
 * @author Swiddy de Louw - Capgemini- PK-8712
 * @author Swiddy de Louw - Capgemini- PK-7113
 */

public class OvergangsinfoUPtilUT implements Serializable {

    private static final long serialVersionUID = 5825797284703536907L;

    /**
     * Konvertert beregningsgrunnlag for Ordinær beregning
     */
    @GuiPrompt(prompt = "Konvertert beregningsgrunnlag for ordinær beregning")
    private BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagOrdiner;

    /**
     * Konvertert beregningsgrunnlag for Yrkesskade beregning
     */
    @GuiPrompt(prompt = "Konvertert beregningsgrunnlag for yrkesskade beregning")
    private BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagYrkesskade;

    /**
     * Uføretrygd ektefelletilleg
     */
    @GuiPrompt(prompt = "Ektefelletillegg uføretrygd")
    private EktefelletilleggUT ektefelletilleggUT;

    /**
     * Inntektsgrense for Friintektsdato
     */
    @GuiPrompt(prompt = "Inntektsgrense for friinntektsdato")
    private int inntektsgrenseorFriinntektsdato;

    /**
     * Konvertert beregningsgrunnlag for gjenlevendetillegg hvis fastsatt
     */
    @GuiPrompt(prompt = "Konvertert beregningsgrunnlag for gjenlevendetillegg")
    private BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagGJT;

    /**
     * Anvendt trygdetid fra konvertert uførepensjon
     */
    @GuiPrompt(prompt = "Anvendt trygdetid fra konvertert uførepensjon")
    private AnvendtTrygdetid anvendtTrygdetidUP;

    /**
     * Anvendt trygdetid fra hjemmeberegningen til konvertert uførepensjon
     */
    @GuiPrompt(prompt = "Anvendt trygdetid fra hjemmeberegning til konvertert uførepensjon")
    private AnvendtTrygdetid anvendtTrygdetidUPHjemme;

    /**
     * Egen anvendt trygdetid fra UP
     */
    @GuiPrompt(prompt = "Egen anvendt trygdetid fra uførepensjon")
    private AnvendtTrygdetid anvendtTrygdetidUP_egen;


    /**
     * Hvorvidt utbetalt uførepensjonen per 31.12.2014 ble definert som minstepensjon.
     */
    @GuiPrompt(prompt = " Hvorvidt utbetalt uførepensjonen per 31.12.2014 ble definert som minstepensjon")
    private MinstepensjonTypeCti minstepensjonType;


    /**
     * Hvorvidt utbetalt uførepensjonen per 31.12.2014 ble manuelt overstyrt eller ikke.
     */
    @GuiPrompt(prompt = "Hvorvidt utbetalt uførepensjonen per 31.12.2014 ble manuelt overstyrt eller ikke")
    private ResultatKildeCti resultatKilde;

    /**
     * Netto særtillegg i utbetalt uførepensjonen per 31.12.2014.
     */
    @GuiPrompt(prompt = " Netto særtillegg i utbetalt uførepensjonen per 31.12.2014")
    private int sertilleggNetto;

    /**
     * Default constructor
     */
    public OvergangsinfoUPtilUT() {
        super();
    }

    /**
     * Constructor using fields
     * 
     * @param konvertertBeregningsgrunnlagOrdiner
     * @param konvertertBeregningsgrunnlagYrkesskade
     * @param ektefelletilleggUT
     * @param inntektsgrenseorFriinntektsdato
     *
     */
    public OvergangsinfoUPtilUT(BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagOrdiner, BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagYrkesskade,
                                EktefelletilleggUT ektefelletilleggUT, int inntektsgrenseorFriinntektsdato, BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagGJT,
                                AnvendtTrygdetid anvendtTrygdetidUP, AnvendtTrygdetid anvendtTrygdetidUPHjemme,MinstepensjonTypeCti minstepensjonType,ResultatKildeCti resultatKilde,
                                int sertilleggNetto) {
        this();
        this.konvertertBeregningsgrunnlagOrdiner = konvertertBeregningsgrunnlagOrdiner;
        this.konvertertBeregningsgrunnlagYrkesskade = konvertertBeregningsgrunnlagYrkesskade;
        this.ektefelletilleggUT = ektefelletilleggUT;
        this.inntektsgrenseorFriinntektsdato = inntektsgrenseorFriinntektsdato;
        this.konvertertBeregningsgrunnlagGJT = konvertertBeregningsgrunnlagGJT;
        this.anvendtTrygdetidUP = anvendtTrygdetidUP;
        this.anvendtTrygdetidUPHjemme = anvendtTrygdetidUPHjemme;
        this.minstepensjonType = minstepensjonType;
        this.resultatKilde = resultatKilde;
        this.sertilleggNetto = sertilleggNetto;
    }

    /**
     * Copy constructor
     */
    public OvergangsinfoUPtilUT(OvergangsinfoUPtilUT o) {
        this();
        if (o.ektefelletilleggUT != null) {
            ektefelletilleggUT = new EktefelletilleggUT(o.ektefelletilleggUT);
        }
        inntektsgrenseorFriinntektsdato = o.inntektsgrenseorFriinntektsdato;

        if (o.konvertertBeregningsgrunnlagOrdiner != null) {
            konvertertBeregningsgrunnlagOrdiner = new BeregningsgrunnlagKonvertert(o.konvertertBeregningsgrunnlagOrdiner);
        }
        if (o.konvertertBeregningsgrunnlagYrkesskade != null) {
            konvertertBeregningsgrunnlagYrkesskade = new BeregningsgrunnlagKonvertert(o.konvertertBeregningsgrunnlagYrkesskade);
        }
        if (o.konvertertBeregningsgrunnlagGJT != null) {
            konvertertBeregningsgrunnlagGJT = new BeregningsgrunnlagKonvertert(o.konvertertBeregningsgrunnlagGJT);
        }
        if(o.anvendtTrygdetidUP != null) {
            anvendtTrygdetidUP = new AnvendtTrygdetid(o.anvendtTrygdetidUP);
        }
        if(o.anvendtTrygdetidUPHjemme != null) {
            anvendtTrygdetidUPHjemme = new AnvendtTrygdetid(o.anvendtTrygdetidUPHjemme);
        }

        if(o.anvendtTrygdetidUP_egen != null) {
            anvendtTrygdetidUP_egen = new AnvendtTrygdetid(o.anvendtTrygdetidUP_egen);
        }

        if(o.minstepensjonType != null) {
            minstepensjonType = new MinstepensjonTypeCti(o.minstepensjonType);
        }

        if(o.resultatKilde != null) {
            resultatKilde = new ResultatKildeCti(o.resultatKilde);
        }
    }

    /**
     * @return the konvertertBeregningsgrunnlagOrdiner
     */
    public BeregningsgrunnlagKonvertert getKonvertertBeregningsgrunnlagOrdiner() {
        return konvertertBeregningsgrunnlagOrdiner;
    }

    /**
     * @param konvertertBeregningsgrunnlagOrdiner the konvertertBeregningsgrunnlagOrdiner to set
     */
    public void setKonvertertBeregningsgrunnlagOrdiner(BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagOrdiner) {
        this.konvertertBeregningsgrunnlagOrdiner = konvertertBeregningsgrunnlagOrdiner;
    }

    /**
     * @return the konvertertBeregningsgrunnlagYrkesskade
     */
    public BeregningsgrunnlagKonvertert getKonvertertBeregningsgrunnlagYrkesskade() {
        return konvertertBeregningsgrunnlagYrkesskade;
    }

    /**
     * @param konvertertBeregningsgrunnlagYrkesskade the konvertertBeregningsgrunnlagYrkesskade to set
     */
    public void setKonvertertBeregningsgrunnlagYrkesskade(BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagYrkesskade) {
        this.konvertertBeregningsgrunnlagYrkesskade = konvertertBeregningsgrunnlagYrkesskade;
    }

    /**
     * @return the ektefelletilleggUT
     */
    public EktefelletilleggUT getEktefelletilleggUT() {
        return ektefelletilleggUT;
    }

    /**
     * @param ektefelletilleggUT the ektefelletilleggUT to set
     */
    public void setEktefelletilleggUT(EktefelletilleggUT ektefelletilleggUT) {
        this.ektefelletilleggUT = ektefelletilleggUT;
    }

    /**
     * @return the inntektsgrenseorFriinntektsdato
     */
    public int getInntektsgrenseorFriinntektsdato() {
        return inntektsgrenseorFriinntektsdato;
    }

    /**
     * @param inntektsgrenseorFriinntektsdato the inntektsgrenseorFriinntektsdato to set
     */
    public void setInntektsgrenseorFriinntektsdato(int inntektsgrenseorFriinntektsdato) {
        this.inntektsgrenseorFriinntektsdato = inntektsgrenseorFriinntektsdato;
    }

    /**
     * @return the konvertertBeregningsgrunnlagGJT
     */
    public BeregningsgrunnlagKonvertert getKonvertertBeregningsgrunnlagGJT() {
        return konvertertBeregningsgrunnlagGJT;
    }

    /**
     * @param konvertertBeregningsgrunnlagGJT the konvertertBeregningsgrunnlagGJT to set
     */
    public void setKonvertertBeregningsgrunnlagGJT(BeregningsgrunnlagKonvertert konvertertBeregningsgrunnlagGJT) {
        this.konvertertBeregningsgrunnlagGJT = konvertertBeregningsgrunnlagGJT;
    }

    public AnvendtTrygdetid getAnvendtTrygdetidUP() {
        return anvendtTrygdetidUP;
    }

    public void setAnvendtTrygdetidUP(AnvendtTrygdetid anvendtTrygdetidUP) {
        this.anvendtTrygdetidUP = anvendtTrygdetidUP;
    }

    public AnvendtTrygdetid getAnvendtTrygdetidUPHjemme() {
        return anvendtTrygdetidUPHjemme;
    }

    public void setAnvendtTrygdetidUPHjemme(AnvendtTrygdetid anvendtTrygdetidUPHjemme) {
        this.anvendtTrygdetidUPHjemme = anvendtTrygdetidUPHjemme;
    }


    public AnvendtTrygdetid getAnvendtTrygdetidUP_egen() {
        return anvendtTrygdetidUP_egen;
    }

    public void setAnvendtTrygdetidUP_egen(AnvendtTrygdetid anvendtTrygdetidUP_egen) {
        this.anvendtTrygdetidUP_egen = anvendtTrygdetidUP_egen;
    }

    public MinstepensjonTypeCti getMinstepensjonType() {
        return minstepensjonType;
    }

    public void setMinstepensjonType(MinstepensjonTypeCti minstepensjonType) {
        this.minstepensjonType = minstepensjonType;
    }

    public ResultatKildeCti getResultatKilde() {
        return resultatKilde;
    }

    public void setResultatKilde(ResultatKildeCti resultatKilde) {
        this.resultatKilde = resultatKilde;
    }

    public int getSertilleggNetto() {
        return sertilleggNetto;
    }

    public void setSertilleggNetto(int sertilleggNetto) {
        this.sertilleggNetto = sertilleggNetto;
    }
}
