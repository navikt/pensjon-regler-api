package no.nav.domain.pensjon.regler;

import no.nav.domain.pensjon.regler.beregning.Poengtall;
import no.nav.domain.pensjon.regler.beregning2011.LonnsvekstInformasjon;

import java.io.Serializable;

/**
 * Dataholderklasse for opptjening. Objektet vil være både input og output fra regeltjenester.
 */
public class Opptjening implements Serializable {
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

}
