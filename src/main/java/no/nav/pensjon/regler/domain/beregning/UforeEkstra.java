package no.nav.pensjon.regler.domain.beregning;


import no.nav.pensjon.regler.domain.grunnlag.EosEkstra;
import no.nav.pensjon.regler.domain.kode.FppGarantiKodeCti;
import no.nav.pensjon.regler.domain.kode.InntektKode1Cti;
import no.nav.pensjon.regler.domain.kode.InntektKode2Cti;

import java.io.Serializable;

/**
 * Denne klassen inneholder spesielle data fra en beregning av uførepensjon.
 */
public class UforeEkstra implements Serializable {

    private static final long serialVersionUID = -4208304424814592625L;

    /**
     * Beskriver hvordan inntektstaket (tak) er beregnet. Se K_INNTEKT1_T
     * LONN_TILSK
     * YRKE_30_50
     * GRADERT_95_50
     * KOMB_VURD_11_12
     * INT_NIV_UF - default
     * UFOR_100
     * REAK_UF_50
     * UNT_VENT
     * UFGRAD_50
     * UFGRAD_50_REAK
     * YRKODE_18_HJEMMV
     */

    private InntektKode1Cti inntektkode1;

    /**
     * Beskriver om inntektstaket (tak) inneholder et fribeløp eller ikke.
     * INT_IKKE_BER - default
     * OPPJ_INNT_U_FRI_U_TK
     * OPPJ_INNT_M_FRI_U_TK
     * OPPJ_INNT_U_FRI_M_TK
     * OPPJ_INNT_M_FRI_M_TK
     * INT_U_FRI_GML_REGL
     * INT_M_FRI_GML_REGL
     */

    private InntektKode2Cti inntektkode2;

    /**
     * Inntektstak ved uførepensjon.Angir den høyeste pensjonsgivende inntekt uførepensjonisten
     * kan ha uten at uføregraden skal revurderes.
     */

    private int tak;

    /**
     * Inntektsgrense før friinntektsdato ved uførepensjon.
     * Angir den høyeste pensjonsgivende inntekt uførepensjonisten kan ha før friinntektsdato uten at uføregraden skal revurderes.
     */

    private int inntektsgrenseForFriinntektsdato;

    /**
     * Fremtidig pensjonspoengtall.
     */

    private double fpp;

    /**
     * Framtidige pensjonspoengtall garanti, f.eks ung ufør har i dag en garanti på 3.3. i FPP.
     */

    private double fppGaranti;

    /**
     * Kode for fpp_garanti.<br>
     * <code>UNG_UF_VEN_R_T_33_PP = UNG UFØR SOM VENTER PÅ RETT TIL 3.3 PENSJONSPOENG</code><br>
     * <code>UNG_UF_MR_33_PO = UNG UFØR MED RETT TIL 3.3 PENSJONSPOENG</code><br>
     * <code>UNG_UF_VEN = ung ufør som venter, og som ble ufør 20 år gammel</code><br>
     * <code>UNG_UF_MR_33_FR_92 = Ung ufør med rett til 3.3 poeng fra 0592</code><br>
     * <code>UNG_UF_FOR_67 = unge uføre før 1967</code>
     */

    private FppGarantiKodeCti fppGarantiKode;

    /**
     * Antall godskrevet framtidig poengtall, ikke full framtidig godskriving.
     */

    private int redusertAntFppAr;

    /**
     * Uforeperioden som skal benyttes i historikken hvis/når Uføregrunnlaget blir historisk.
     */

    private BeregningUforeperiode uforeperiode;

    /**
     * Uforeperioden for ysk som skal benyttes i historikken hvis/når Uføregrunnlaget blir historisk.
     */

    private BeregningUforeperiode uforeperiodeYSK;

    /**
     * Informasjon ang EØS beregning. Objektet sparer på data for bruk ved konvertering til AP.
     * På UforeEkstra benyttes feltet kun som transport til toppnoden.
     */
    private EosEkstra PREG_eosEkstra;

    /**
     * Angir om bruker fyller vilkårende for å kunne få ung ufør garanti.
     * Brukes i BeregningsInformasjon.
     * Settes av "Ung Ufør Ruleset Template".OpprettUforeEkstra.
     */
    private boolean PREG_vurdertUngUfor;

    /**
     * Copy Constructor
     * 
     * @param uforeEkstra a <code>UforeEkstra</code> object
     */
    public UforeEkstra(UforeEkstra uforeEkstra) {
        if (uforeEkstra.inntektkode1 != null) {
            inntektkode1 = new InntektKode1Cti(uforeEkstra.inntektkode1);
        }
        if (uforeEkstra.inntektkode2 != null) {
            inntektkode2 = new InntektKode2Cti(uforeEkstra.inntektkode2);
        }
        tak = uforeEkstra.tak;
        inntektsgrenseForFriinntektsdato = uforeEkstra.inntektsgrenseForFriinntektsdato;
        fpp = uforeEkstra.fpp;
        fppGaranti = uforeEkstra.fppGaranti;
        if (uforeEkstra.fppGarantiKode != null) {
            fppGarantiKode = new FppGarantiKodeCti(uforeEkstra.fppGarantiKode);
        }
        redusertAntFppAr = uforeEkstra.redusertAntFppAr;
        if (uforeEkstra.uforeperiode != null) {
            uforeperiode = new BeregningUforeperiode(uforeEkstra.uforeperiode);
        }
        if (uforeEkstra.uforeperiodeYSK != null) {
            uforeperiodeYSK = new BeregningUforeperiode(uforeEkstra.uforeperiodeYSK);
        }
        if (uforeEkstra.PREG_eosEkstra != null) {
            PREG_eosEkstra = new EosEkstra(uforeEkstra.PREG_eosEkstra);
        }
        PREG_vurdertUngUfor = uforeEkstra.PREG_vurdertUngUfor;
    }

    public UforeEkstra() {
        super();
        inntektkode1 = new InntektKode1Cti("INT_NIV_UF");
        inntektkode2 = new InntektKode2Cti("INT_IKKE_BER");
    }

    public UforeEkstra(InntektKode1Cti inntektkode1, InntektKode2Cti inntektkode2, int tak, int inntektsgrenseForFriinntektsdato, double fpp, double fppGaranti,
                       FppGarantiKodeCti fppGarantiKode, int redusertAntFppAr, BeregningUforeperiode uforeperiode, BeregningUforeperiode uforeperiodeYSK) {
        super();
        this.inntektkode1 = inntektkode1;
        this.inntektkode2 = inntektkode2;
        this.tak = tak;
        this.inntektsgrenseForFriinntektsdato = inntektsgrenseForFriinntektsdato;
        this.fpp = fpp;
        this.fppGaranti = fppGaranti;
        this.fppGarantiKode = fppGarantiKode;
        this.redusertAntFppAr = redusertAntFppAr;
        this.uforeperiode = uforeperiode;
        this.uforeperiodeYSK = uforeperiodeYSK;
    }

    public InntektKode1Cti getInntektkode1() {
        return inntektkode1;
    }

    public void setInntektkode1(InntektKode1Cti inntektkode1) {
        this.inntektkode1 = inntektkode1;
    }

    public InntektKode2Cti getInntektkode2() {
        return inntektkode2;
    }

    public void setInntektkode2(InntektKode2Cti inntektkode2) {
        this.inntektkode2 = inntektkode2;
    }

    public int getTak() {
        return tak;
    }

    public void setTak(int tak) {
        this.tak = tak;
    }

    public int getInntektsgrenseForFriinntektsdato() {
        return inntektsgrenseForFriinntektsdato;
    }

    public void setInntektsgrenseForFriinntektsdato(int inntektsgrenseForFriinntektsdato) {
        this.inntektsgrenseForFriinntektsdato = inntektsgrenseForFriinntektsdato;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     * 
     * @return a <code>String</code> representation
     *         of this object.
     */
    @Override
    public String toString() {
        final String TAB = "    ";

        StringBuilder retValue = new StringBuilder();

        retValue.append("UforeEkstra ( ").append(super.toString()).append(TAB).append("inntektkode1 = ").append(inntektkode1).append(TAB).append("inntektkode2 = ")
                .append(inntektkode2).append(TAB).append("tak = ").append(tak).append(TAB).append(" )");

        return retValue.toString();
    }

    public double getFpp() {
        return fpp;
    }

    public void setFpp(double fpp) {
        this.fpp = fpp;
    }

    public double getFppGaranti() {
        return fppGaranti;
    }

    public void setFppGaranti(double fppGaranti) {
        this.fppGaranti = fppGaranti;
    }

    public FppGarantiKodeCti getFppGarantiKode() {
        return fppGarantiKode;
    }

    public void setFppGarantiKode(FppGarantiKodeCti fppGarantiKode) {
        this.fppGarantiKode = fppGarantiKode;
    }

    public int getRedusertAntFppAr() {
        return redusertAntFppAr;
    }

    public void setRedusertAntFppAr(int redusertAntFppAr) {
        this.redusertAntFppAr = redusertAntFppAr;
    }

    public BeregningUforeperiode getUforeperiode() {
        return uforeperiode;
    }

    public void setUforeperiode(BeregningUforeperiode uforeperiode) {
        this.uforeperiode = uforeperiode;
    }

    public BeregningUforeperiode getUforeperiodeYSK() {
        return uforeperiodeYSK;
    }

    public void setUforeperiodeYSK(BeregningUforeperiode uforeperiodeYSK) {
        this.uforeperiodeYSK = uforeperiodeYSK;
    }

    public EosEkstra getPREG_eosEkstra() {
        return PREG_eosEkstra;
    }

    public void setPREG_eosEkstra(EosEkstra ekstra) {
        PREG_eosEkstra = ekstra;
    }

    public boolean isPREG_vurdertUngUfor() {
        return PREG_vurdertUngUfor;
    }

    public void setPREG_vurdertUngUfor(boolean ungUfor) {
        PREG_vurdertUngUfor = ungUfor;
    }

}
