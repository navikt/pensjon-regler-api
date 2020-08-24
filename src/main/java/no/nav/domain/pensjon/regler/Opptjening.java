package no.nav.domain.pensjon.regler;

import no.nav.domain.pensjon.regler.beregning.Poengtall;
import no.nav.domain.pensjon.regler.beregning2011.LonnsvekstInformasjon;

import java.io.Serializable;

/**
 * Dataholderklasse for opptjening. Objektet vil være både input og output fra regeltjenester.
 */
public class Opptjening implements Serializable {
    private static final long serialVersionUID = -7637804722246159101L;

    private int ar;
    private double opptjeningsgrunnlag;
    private double anvendtOpptjeningsgrunnlag;
    private double arligOpptjening;
    private LonnsvekstInformasjon lonnsvekstInformasjon;
    private double pSatsOpptjening;
    private Poengtall poengtall;
    private double inntektUtenDagpenger;
    private Uforeopptjening uforeOpptjening;
    private double dagpenger;
    private double dagpengerFiskerOgFangstmenn;
    private double omsorg;
    private double forstegangstjeneste;
    private double arligOpptjeningOmsorg;
    private double arligOpptjeningUtenOmsorg;
    private double PREG_antFgtMnd;
    private double PREG_samletDagpenger;
    private double PREG_samletUtbetalteDagpenger;
    private double PREG_samletFerietillegg;
    private double PREG_samletBarnetillegg;

    public Opptjening() {
        super();
    }

    public Opptjening(Opptjening o) {
        ar = o.ar;
        opptjeningsgrunnlag = o.opptjeningsgrunnlag;
        anvendtOpptjeningsgrunnlag = o.anvendtOpptjeningsgrunnlag;
        arligOpptjening = o.arligOpptjening;

        if (o.lonnsvekstInformasjon != null) {
            lonnsvekstInformasjon = new LonnsvekstInformasjon(o.lonnsvekstInformasjon);
        }
        if (o.poengtall != null) {
            poengtall = new Poengtall(o.poengtall);
        }
        pSatsOpptjening = o.pSatsOpptjening;
        inntektUtenDagpenger = o.inntektUtenDagpenger;
        if (o.uforeOpptjening != null) {
            uforeOpptjening = new Uforeopptjening(o.uforeOpptjening);
        }
        dagpenger = o.dagpenger;
        dagpengerFiskerOgFangstmenn = o.dagpengerFiskerOgFangstmenn;
        omsorg = o.omsorg;
        forstegangstjeneste = o.forstegangstjeneste;
        arligOpptjeningOmsorg = o.arligOpptjeningOmsorg;
        arligOpptjeningUtenOmsorg = o.arligOpptjeningUtenOmsorg;
        PREG_antFgtMnd = o.PREG_antFgtMnd;
        PREG_samletDagpenger = o.PREG_samletDagpenger;
        PREG_samletUtbetalteDagpenger = o.PREG_samletUtbetalteDagpenger;
        PREG_samletFerietillegg = o.PREG_samletFerietillegg;
        PREG_samletBarnetillegg = o.PREG_samletBarnetillegg;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public double getOpptjeningsgrunnlag() {
        return opptjeningsgrunnlag;
    }

    public void setOpptjeningsgrunnlag(double opptjeningsgrunnlag) {
        this.opptjeningsgrunnlag = opptjeningsgrunnlag;
    }

    public double getAnvendtOpptjeningsgrunnlag() {
        return anvendtOpptjeningsgrunnlag;
    }

    public void setAnvendtOpptjeningsgrunnlag(double anvendtOpptjeningsgrunnlag) {
        this.anvendtOpptjeningsgrunnlag = anvendtOpptjeningsgrunnlag;
    }

    public double getArligOpptjening() {
        return arligOpptjening;
    }

    public void setArligOpptjening(double arligOpptjening) {
        this.arligOpptjening = arligOpptjening;
    }

    public LonnsvekstInformasjon getLonnsvekstInformasjon() {
        return lonnsvekstInformasjon;
    }

    public void setLonnsvekstInformasjon(LonnsvekstInformasjon lonnsvekstInformasjon) {
        this.lonnsvekstInformasjon = lonnsvekstInformasjon;
    }

    public double getpSatsOpptjening() {
        return pSatsOpptjening;
    }

    public void setpSatsOpptjening(double pSatsOpptjening) {
        this.pSatsOpptjening = pSatsOpptjening;
    }

    public Poengtall getPoengtall() {
        return poengtall;
    }

    public void setPoengtall(Poengtall poengtall) {
        this.poengtall = poengtall;
    }

    public double getInntektUtenDagpenger() {
        return inntektUtenDagpenger;
    }

    public void setInntektUtenDagpenger(double inntektUtenDagpenger) {
        this.inntektUtenDagpenger = inntektUtenDagpenger;
    }

    public Uforeopptjening getUforeOpptjening() {
        return uforeOpptjening;
    }

    public void setUforeOpptjening(Uforeopptjening uforeOpptjening) {
        this.uforeOpptjening = uforeOpptjening;
    }

    public double getDagpenger() {
        return dagpenger;
    }

    public void setDagpenger(double dagpenger) {
        this.dagpenger = dagpenger;
    }

    public double getDagpengerFiskerOgFangstmenn() {
        return dagpengerFiskerOgFangstmenn;
    }

    public void setDagpengerFiskerOgFangstmenn(double dagpengerFiskerOgFangstmenn) {
        this.dagpengerFiskerOgFangstmenn = dagpengerFiskerOgFangstmenn;
    }

    public double getOmsorg() {
        return omsorg;
    }

    public void setOmsorg(double omsorg) {
        this.omsorg = omsorg;
    }

    public double getForstegangstjeneste() {
        return forstegangstjeneste;
    }

    public void setForstegangstjeneste(double forstegangstjeneste) {
        this.forstegangstjeneste = forstegangstjeneste;
    }

    public double getArligOpptjeningOmsorg() {
        return arligOpptjeningOmsorg;
    }

    public void setArligOpptjeningOmsorg(double arligOpptjeningOmsorg) {
        this.arligOpptjeningOmsorg = arligOpptjeningOmsorg;
    }

    public double getArligOpptjeningUtenOmsorg() {
        return arligOpptjeningUtenOmsorg;
    }

    public void setArligOpptjeningUtenOmsorg(double arligOpptjeningUtenOmsorg) {
        this.arligOpptjeningUtenOmsorg = arligOpptjeningUtenOmsorg;
    }

    public double getPREG_antFgtMnd() {
        return PREG_antFgtMnd;
    }

    public void setPREG_antFgtMnd(double fgtMnd) {
        PREG_antFgtMnd = fgtMnd;
    }

    public double getPREG_samletBarnetillegg() {
        return PREG_samletBarnetillegg;
    }

    public void setPREG_samletBarnetillegg(double barnetillegg) {
        PREG_samletBarnetillegg = barnetillegg;
    }

    public double getPREG_samletDagpenger() {
        return PREG_samletDagpenger;
    }

    public void setPREG_samletDagpenger(double dagpenger) {
        PREG_samletDagpenger = dagpenger;
    }

    public double getPREG_samletFerietillegg() {
        return PREG_samletFerietillegg;
    }

    public void setPREG_samletFerietillegg(double ferietillegg) {
        PREG_samletFerietillegg = ferietillegg;
    }

    public double getPREG_samletUtbetalteDagpenger() {
        return PREG_samletUtbetalteDagpenger;
    }

    public void setPREG_samletUtbetalteDagpenger(double utbetalteDagpenger) {
        PREG_samletUtbetalteDagpenger = utbetalteDagpenger;
    }

}
