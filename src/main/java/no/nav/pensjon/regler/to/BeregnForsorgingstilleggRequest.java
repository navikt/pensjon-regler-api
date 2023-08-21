package no.nav.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import no.nav.pensjon.regler.domain.beregning.Beregning;
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat;
import no.nav.pensjon.regler.domain.beregning2011.BeregnetUtbetalingsperiode;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAlderspensjon2011;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsresultatUforetrygd;
import no.nav.pensjon.regler.domain.beregning2011.EktefelletilleggUT;
import no.nav.pensjon.regler.domain.grunnlag.EtteroppgjorGrunnlag;
import no.nav.pensjon.regler.domain.kode.BarnetilleggRegelverkCti;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

/**
 * Objektet inneholder requesten for tjenesten BeregnForsorgingstillegg
 * 
 * @author Kenneth Fjelleng (Capgemini) PK-7106
 * @author Aasmund Nordstoga (Accenture) PK-9028
 * @author Aasmund Nordstoga (Accenture) PK-20773
 */
public class BeregnForsorgingstilleggRequest extends ServiceRequest {

    private static final long serialVersionUID = 8864544986202456302L;

    /**
     * Beskriver hvilke regler som skal benyttes i beregning av BT for UT etter 01.01.2016
     */
    private BarnetilleggRegelverkCti barnetilleggRegelverkCti;

    /**
     * En liste med hva som er beregnet utbetalt av ytelser hittil i år.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListeBruker = new ArrayList<BeregnetUtbetalingsperiode>();

    /**
     * En liste med hva som er beregnet utbetalt av ytelser hittil i år.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListeEPS = new ArrayList<BeregnetUtbetalingsperiode>();

    /**
     * Dersom søker har uførepensjon og dersom beregning 1967.
     */
    private Beregning beregningSoker;

    /**
     * Dersom søker har ApfPrivat skal beregningsresultatet sendes inn.
     */
    private BeregningsResultatAfpPrivat beregningsResultatAfpPrivatSoker;

    /**
     * Dersom søkers EPS har ApfPrivat skal dennes beregningsresultat sendes inn.
     */
    private BeregningsResultatAfpPrivat beregningsResultatAfpPrivatTilstotende;

    /**
     * Beregningen ved virkningstidspunkt. Vil inneholde en AldersberegningKapittel19,
     * som igjen inneholder MinstePensjonsnivå, Basispensjon, Restpensjon, PensjonUnderUtbetaling
     * og BeregningsInformasjon.
     */
    private AbstraktBeregningsResultat beregningsResultatAlderspensjonSoker;

    /**
     * Dersom søker har EPS som mottar alderspensjon etter reglene med virk etter 01.01.2011
     * skal dennes pensjon sendes inn.
     */
    private AbstraktBeregningsResultat beregningsResultatAlderspensjonTilstotende;

    /**
     * Beregningsresultatet fra uføretrygdberegningen for søker
     */
    private BeregningsresultatUforetrygd beregningsResultatUforetrygdSoker;

    /**
     * Dersom EPS har sakstype UP og virkningsdatoen er f.o.m. 01.01.2015
     */
    private BeregningsresultatUforetrygd beregningsresultatUforetrygdTilstotende;

    /**
     * Dersom søker har EPS som mottar pensjon(UP, AP,AFP) etter reglene med virk før 01.01.2011
     * skal dennes pensjon sendes inn.
     */
    private Beregning beregningTilstotende;

    /**
     * Ektefelletillegg for uføretrygd for søker
     */
    private EktefelletilleggUT ektefelletilleggUT;

    private boolean etteroppgjor;

    private EtteroppgjorGrunnlag etteroppgjorGrunnlag;

    /**
     * Kravhodet til beregningen.
     */
    private Kravhode kravhode;

    /**
     * Liste av vilkårsvedtak for ytelser som skal beregnes.
     */
    private List<VilkarsVedtak> vilkarsvedtakListe = new ArrayList<VilkarsVedtak>();

    /**
     * Virkningstidspunkt for søknad om forsørgingstillegg.
     */
    private Date virk;

    public BeregnForsorgingstilleggRequest() {
        super();
    }

    public BeregnForsorgingstilleggRequest(List<VilkarsVedtak> vilkarsvedtakListe, List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListeBruker,
            List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListeEPS, Kravhode kravhode,
            AbstraktBeregningsResultat beregningsResultatAlderspensjonSoker, Beregning beregningSoker,
            BeregningsResultatAfpPrivat beregningsResultatAfpPrivatSoker, Date virk,
            Beregning beregningTilstotende, BeregningsResultatAlderspensjon2011 beregningsResultatAlderspensjonTilstotende,
            BeregningsResultatAfpPrivat beregningsResultatAfpPrivatTilstotende) {
        super();
        this.vilkarsvedtakListe = vilkarsvedtakListe;
        this.beregnetUtbetalingsperiodeListeBruker = beregnetUtbetalingsperiodeListeBruker;
        this.beregnetUtbetalingsperiodeListeEPS = beregnetUtbetalingsperiodeListeEPS;
        this.kravhode = kravhode;
        this.beregningsResultatAlderspensjonSoker = beregningsResultatAlderspensjonSoker;
        this.beregningSoker = beregningSoker;
        this.beregningsResultatAfpPrivatSoker = beregningsResultatAfpPrivatSoker;
        this.virk = virk;
        this.beregningTilstotende = beregningTilstotende;
        this.beregningsResultatAlderspensjonTilstotende = beregningsResultatAlderspensjonTilstotende;
        this.beregningsResultatAfpPrivatTilstotende = beregningsResultatAfpPrivatTilstotende;
    }

    public BarnetilleggRegelverkCti getBarnetilleggRegelverkCti() {
        return barnetilleggRegelverkCti;
    }

    public List<BeregnetUtbetalingsperiode> getBeregnetUtbetalingsperiodeListeBruker() {
        return beregnetUtbetalingsperiodeListeBruker;
    }

    /**
     * Read only property for beregnetUtbetalingsperiodeListeBruker as array
     * 
     * @return array of BeregnetUtbetalingPeriode
     */
    public BeregnetUtbetalingsperiode[] getBeregnetUtbetalingsperiodeListeBrukerAsArray() {
        return beregnetUtbetalingsperiodeListeBruker != null ? beregnetUtbetalingsperiodeListeBruker.toArray(new BeregnetUtbetalingsperiode[beregnetUtbetalingsperiodeListeBruker.size()])
                : new BeregnetUtbetalingsperiode[0];
    }

    public List<BeregnetUtbetalingsperiode> getBeregnetUtbetalingsperiodeListeEPS() {
        return beregnetUtbetalingsperiodeListeEPS;
    }

    /**
     * Read only property for beregnetUtbetalingsperiodeListeEPS as array
     * 
     * @return array of BeregnetUtbetalingPeriode
     */
    public BeregnetUtbetalingsperiode[] getBeregnetUtbetalingsperiodeListeEPSAsArray() {
        return beregnetUtbetalingsperiodeListeEPS != null ? beregnetUtbetalingsperiodeListeEPS.toArray(new BeregnetUtbetalingsperiode[beregnetUtbetalingsperiodeListeEPS.size()])
                : new BeregnetUtbetalingsperiode[0];
    }

    public Beregning getBeregningSoker() {
        return beregningSoker;
    }

    public BeregningsResultatAfpPrivat getBeregningsResultatAfpPrivatSoker() {
        return beregningsResultatAfpPrivatSoker;
    }

    public BeregningsResultatAfpPrivat getBeregningsResultatAfpPrivatTilstotende() {
        return beregningsResultatAfpPrivatTilstotende;
    }

    public AbstraktBeregningsResultat getBeregningsResultatAlderspensjonSoker() {
        return beregningsResultatAlderspensjonSoker;
    }

    public AbstraktBeregningsResultat getBeregningsResultatAlderspensjonTilstotende() {
        return beregningsResultatAlderspensjonTilstotende;
    }

    public BeregningsresultatUforetrygd getBeregningsResultatUforetrygdSoker() {
        return beregningsResultatUforetrygdSoker;
    }

    public BeregningsresultatUforetrygd getBeregningsresultatUforetrygdTilstotende() {
        return beregningsresultatUforetrygdTilstotende;
    }

    public Beregning getBeregningTilstotende() {
        return beregningTilstotende;
    }

    public EktefelletilleggUT getEktefelletilleggUT() {
        return ektefelletilleggUT;
    }

    public EtteroppgjorGrunnlag getEtteroppgjorGrunnlag() {
        return etteroppgjorGrunnlag;
    }

    public Kravhode getKravhode() {
        return kravhode;
    }

    public List<VilkarsVedtak> getVilkarsvedtakListe() {
        return vilkarsvedtakListe;
    }

    /**
     * Read only property for vilkarsvedtakListe as array
     * 
     * @return array of VilkarsVedtak
     */
    public VilkarsVedtak[] getVilkarsvedtakListeAsArray() {
        return vilkarsvedtakListe != null ? vilkarsvedtakListe.toArray(new VilkarsVedtak[vilkarsvedtakListe.size()]) : new VilkarsVedtak[0];
    }

    public Date getVirk() {
        return virk;
    }

    public boolean isEtteroppgjor() {
        return etteroppgjor;
    }

    public void setBarnetilleggRegelverkCti(BarnetilleggRegelverkCti barnetilleggRegelverkCti) {
        this.barnetilleggRegelverkCti = barnetilleggRegelverkCti;
    }

    public void setBeregnetUtbetalingsperiodeListeBruker(List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListeBruker) {
        this.beregnetUtbetalingsperiodeListeBruker = beregnetUtbetalingsperiodeListeBruker;
    }

    public void setBeregnetUtbetalingsperiodeListeEPS(List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListeEPS) {
        this.beregnetUtbetalingsperiodeListeEPS = beregnetUtbetalingsperiodeListeEPS;
    }

    public void setBeregningSoker(Beregning beregningSoker) {
        this.beregningSoker = beregningSoker;
    }

    public void setBeregningsResultatAfpPrivatSoker(
            BeregningsResultatAfpPrivat beregningsResultatAfpPrivatSoker) {
        this.beregningsResultatAfpPrivatSoker = beregningsResultatAfpPrivatSoker;
    }

    public void setBeregningsResultatAfpPrivatTilstotende(
            BeregningsResultatAfpPrivat beregningsResultatAfpPrivatTilstotende) {
        this.beregningsResultatAfpPrivatTilstotende = beregningsResultatAfpPrivatTilstotende;
    }

    public void setBeregningsResultatAlderspensjonSoker(
            AbstraktBeregningsResultat beregningsResultatAlderspensjonSoker) {
        this.beregningsResultatAlderspensjonSoker = beregningsResultatAlderspensjonSoker;
    }

    public void setBeregningsResultatAlderspensjonTilstotende(
            AbstraktBeregningsResultat beregningsResultatAlderspensjonTilstotende) {
        this.beregningsResultatAlderspensjonTilstotende = beregningsResultatAlderspensjonTilstotende;
    }

    public void setBeregningsResultatUforetrygdSoker(BeregningsresultatUforetrygd beregningsResultatUforetrygdSoker) {
        this.beregningsResultatUforetrygdSoker = beregningsResultatUforetrygdSoker;
    }

    public void setBeregningsresultatUforetrygdTilstotende(BeregningsresultatUforetrygd beregningsresultatUforetrygdTilstotende) {
        this.beregningsresultatUforetrygdTilstotende = beregningsresultatUforetrygdTilstotende;
    }

    public void setBeregningTilstotende(Beregning beregningTilstotende) {
        this.beregningTilstotende = beregningTilstotende;
    }

    public void setEktefelletilleggUT(EktefelletilleggUT ektefelletilleggUT) {
        this.ektefelletilleggUT = ektefelletilleggUT;
    }

    public void setEtteroppgjor(boolean etteroppgjor) {
        this.etteroppgjor = etteroppgjor;
    }

    public void setEtteroppgjorGrunnlag(EtteroppgjorGrunnlag etteroppgjorGrunnlag) {
        this.etteroppgjorGrunnlag = etteroppgjorGrunnlag;
    }

    public void setKravhode(Kravhode kravhode) {
        this.kravhode = kravhode;
    }

    public void setVilkarsvedtakListe(List<VilkarsVedtak> vilkarsvedtakListe) {
        this.vilkarsvedtakListe = vilkarsvedtakListe;
    }

    public void setVirk(Date virk) {
        this.virk = virk;
    }
}
