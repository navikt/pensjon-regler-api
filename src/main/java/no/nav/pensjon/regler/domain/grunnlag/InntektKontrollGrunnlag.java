package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.beregning2011.BeregnetUtbetalingsperiode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static no.nav.pensjon.regler.domain.util.DateCopyUtil.copyDate;
import static no.nav.pensjon.regler.domain.util.ListUtil.deepCopyList;

public class InntektKontrollGrunnlag implements Serializable {

    private static final long serialVersionUID = 3478461748227337266L;

    /** Inneholder faktiske inntekter mottatt av bruker hittil i år. */
    private List<FaktiskInntektsgrunnlag> faktiskeInntekterBrukerListe = new ArrayList<FaktiskInntektsgrunnlag>();

    /** Inneholder faktiske inntekter mottatt av EPS hittil i år. */
    private List<FaktiskInntektsgrunnlag> faktiskeInntekterEPSListe = new ArrayList<FaktiskInntektsgrunnlag>();

    /** Inneholder forventede inntekter for bruker fra Inntektskomponenten. */
    private List<Inntektsgrunnlag> forventetInntektBrukerListe = new ArrayList<Inntektsgrunnlag>();

    /** Inneholder forventede inntekter for EPS fra Inntektskomponenten. */
    private List<Inntektsgrunnlag> forventetInntektEPSListe = new ArrayList<Inntektsgrunnlag>();

    /**
     * En liste med hva som er beregnet utbetalt av ytelser hittil i år for søker.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeBrukerListe = new ArrayList<BeregnetUtbetalingsperiode>();

    /**
     * En liste med hva som er beregnet utbetalt av ytelser hittil i år for EPS.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeEPSListe = new ArrayList<BeregnetUtbetalingsperiode>();

    /** Angir hvilken måned som kontrolleres. */
    private Date kontrolldato;

    public InntektKontrollGrunnlag() {
    }

    public InntektKontrollGrunnlag(InntektKontrollGrunnlag inntektKontrollGrunnlag) {
        kontrolldato = copyDate(inntektKontrollGrunnlag.kontrolldato);

        faktiskeInntekterBrukerListe = deepCopyList(inntektKontrollGrunnlag.faktiskeInntekterBrukerListe);
        faktiskeInntekterEPSListe = deepCopyList(inntektKontrollGrunnlag.faktiskeInntekterEPSListe);
        forventetInntektBrukerListe = deepCopyList(inntektKontrollGrunnlag.forventetInntektBrukerListe);
        forventetInntektEPSListe = deepCopyList(inntektKontrollGrunnlag.forventetInntektEPSListe);
        beregnetUtbetalingsperiodeBrukerListe = deepCopyList(inntektKontrollGrunnlag.beregnetUtbetalingsperiodeBrukerListe);
        beregnetUtbetalingsperiodeEPSListe = deepCopyList(inntektKontrollGrunnlag.beregnetUtbetalingsperiodeEPSListe);
    }

    public List<FaktiskInntektsgrunnlag> getFaktiskeInntekterBrukerListe() {
        return faktiskeInntekterBrukerListe;
    }

    public FaktiskInntektsgrunnlag[] getFaktiskeInntekterBrukerListeAsArray() {
        return getFaktiskeInntekterBrukerListe() != null
                ? getFaktiskeInntekterBrukerListe().toArray(new FaktiskInntektsgrunnlag[getFaktiskeInntekterBrukerListe().size()])
                : new FaktiskInntektsgrunnlag[0];
    }

    public void setFaktiskeInntekterBrukerListe(List<FaktiskInntektsgrunnlag> faktiskeInntekterBrukerListe) {
        this.faktiskeInntekterBrukerListe = faktiskeInntekterBrukerListe;
    }

    public List<FaktiskInntektsgrunnlag> getFaktiskeInntekterEPSListe() {
        return faktiskeInntekterEPSListe;
    }

    public FaktiskInntektsgrunnlag[] getFaktiskeInntekterEPSListeAsArray() {
        return getFaktiskeInntekterEPSListe() != null
                ? getFaktiskeInntekterEPSListe().toArray(new FaktiskInntektsgrunnlag[getFaktiskeInntekterEPSListe().size()])
                : new FaktiskInntektsgrunnlag[0];
    }

    public void setFaktiskeInntekterEPSListe(List<FaktiskInntektsgrunnlag> faktiskeInntekterEPSListe) {
        this.faktiskeInntekterEPSListe = faktiskeInntekterEPSListe;
    }

    public List<Inntektsgrunnlag> getForventetInntektBrukerListe() {
        return forventetInntektBrukerListe;
    }

    public Inntektsgrunnlag[] getForventetInntektBrukerListeAsArray() {
        return getForventetInntektBrukerListe() != null
                ? getForventetInntektBrukerListe().toArray(new Inntektsgrunnlag[getForventetInntektBrukerListe().size()])
                : new Inntektsgrunnlag[0];
    }

    public void setForventetInntektBrukerListe(List<Inntektsgrunnlag> forventetInntektBrukerListe) {
        this.forventetInntektBrukerListe = forventetInntektBrukerListe;
    }

    public List<Inntektsgrunnlag> getForventetInntektEPSListe() {
        return forventetInntektEPSListe;
    }

    public Inntektsgrunnlag[] getForventetInntektEPSListeAsArray() {
        return getForventetInntektEPSListe() != null
                ? getForventetInntektEPSListe().toArray(new Inntektsgrunnlag[getForventetInntektEPSListe().size()])
                : new Inntektsgrunnlag[0];
    }

    public void setForventetInntektEPSListe(List<Inntektsgrunnlag> forventetInntektEPSListe) {
        this.forventetInntektEPSListe = forventetInntektEPSListe;
    }

    public List<BeregnetUtbetalingsperiode> getBeregnetUtbetalingsperiodeBrukerListe() {
        return beregnetUtbetalingsperiodeBrukerListe;
    }

    public BeregnetUtbetalingsperiode[] getBeregnetUtbetalingsperiodeBrukerListeAsArray() {
        return getBeregnetUtbetalingsperiodeBrukerListe() != null
                ? getBeregnetUtbetalingsperiodeBrukerListe().toArray(new BeregnetUtbetalingsperiode[getBeregnetUtbetalingsperiodeBrukerListe().size()])
                : new BeregnetUtbetalingsperiode[0];
    }

    public void setBeregnetUtbetalingsperiodeBrukerListe(List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeBrukerListe) {
        this.beregnetUtbetalingsperiodeBrukerListe = beregnetUtbetalingsperiodeBrukerListe;
    }

    public List<BeregnetUtbetalingsperiode> getBeregnetUtbetalingsperiodeEPSListe() {
        return beregnetUtbetalingsperiodeEPSListe;
    }

    public BeregnetUtbetalingsperiode[] getBeregnetUtbetalingsperiodeEPSListeAsArray() {
        return beregnetUtbetalingsperiodeEPSListe != null
                ? beregnetUtbetalingsperiodeEPSListe.toArray(new BeregnetUtbetalingsperiode[beregnetUtbetalingsperiodeEPSListe.size()])
                : new BeregnetUtbetalingsperiode[0];
    }

    public void setBeregnetUtbetalingsperiodeEPSListe(List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeEPSListe) {
        this.beregnetUtbetalingsperiodeEPSListe = beregnetUtbetalingsperiodeEPSListe;
    }

    public Date getKontrolldato() {
        return kontrolldato;
    }

    public void setKontrolldato(Date kontrolldato) {
        this.kontrolldato = kontrolldato;
    }

}
