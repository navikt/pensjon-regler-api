package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning2011.*
import no.nav.pensjon.regler.domain.grunnlag.EtteroppgjorGrunnlag
import no.nav.pensjon.regler.domain.kode.BarnetilleggRegelverkCti
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak
import java.util.*

/**
 * Objektet inneholder requesten for tjenesten BeregnForsorgingstillegg
 */
class BeregnForsorgingstilleggRequest {
    /**
     * Beskriver hvilke regler som skal benyttes i beregning av BT for UT etter 01.01.2016
     */
    var barnetilleggRegelverkCti: BarnetilleggRegelverkCti? = null

    /**
     * En liste med hva som er beregnet utbetalt av ytelser hittil i år.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    var beregnetUtbetalingsperiodeListeBruker: List<BeregnetUtbetalingsperiode> = ArrayList()

    /**
     * En liste med hva som er beregnet utbetalt av ytelser hittil i år.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    var beregnetUtbetalingsperiodeListeEPS: List<BeregnetUtbetalingsperiode> = ArrayList()

    /**
     * Dersom søker har uførepensjon og dersom beregning 1967.
     */
    var beregningSoker: Beregning? = null

    /**
     * Dersom søker har ApfPrivat skal beregningsresultatet sendes inn.
     */
    var beregningsResultatAfpPrivatSoker: BeregningsResultatAfpPrivat? = null

    /**
     * Dersom søkers EPS har ApfPrivat skal dennes beregningsresultat sendes inn.
     */
    var beregningsResultatAfpPrivatTilstotende: BeregningsResultatAfpPrivat? = null

    /**
     * Beregningen ved virkningstidspunkt. Vil inneholde en AldersberegningKapittel19,
     * som igjen inneholder MinstePensjonsnivå, Basispensjon, Restpensjon, PensjonUnderUtbetaling
     * og BeregningsInformasjon.
     */
    var beregningsResultatAlderspensjonSoker: AbstraktBeregningsResultat? = null

    /**
     * Dersom søker har EPS som mottar alderspensjon etter reglene med virk etter 01.01.2011
     * skal dennes pensjon sendes inn.
     */
    var beregningsResultatAlderspensjonTilstotende: AbstraktBeregningsResultat? = null

    /**
     * Beregningsresultatet fra uføretrygdberegningen for søker
     */
    var beregningsResultatUforetrygdSoker: BeregningsresultatUforetrygd? = null

    /**
     * Dersom EPS har sakstype UP og virkningsdatoen er f.o.m. 01.01.2015
     */
    var beregningsresultatUforetrygdTilstotende: BeregningsresultatUforetrygd? = null

    /**
     * Dersom søker har EPS som mottar pensjon(UP, AP,AFP) etter reglene med virk før 01.01.2011
     * skal dennes pensjon sendes inn.
     */
    var beregningTilstotende: Beregning? = null

    /**
     * Ektefelletillegg for uføretrygd for søker
     */
    var ektefelletilleggUT: EktefelletilleggUT? = null
    var isEtteroppgjor = false
    var etteroppgjorGrunnlag: EtteroppgjorGrunnlag? = null

    /**
     * Kravhodet til beregningen.
     */
    var kravhode: Kravhode? = null

    /**
     * Liste av vilkårsvedtak for ytelser som skal beregnes.
     */
    var vilkarsvedtakListe: List<VilkarsVedtak> = ArrayList()

    /**
     * Virkningstidspunkt for søknad om forsærgingstillegg.
     */
    var virk: Date? = null

    constructor() : super()
    constructor(
        vilkarsvedtakListe: List<VilkarsVedtak>,
        beregnetUtbetalingsperiodeListeBruker: List<BeregnetUtbetalingsperiode>,
        beregnetUtbetalingsperiodeListeEPS: List<BeregnetUtbetalingsperiode>,
        kravhode: Kravhode?,
        beregningsResultatAlderspensjonSoker: AbstraktBeregningsResultat?,
        beregningSoker: Beregning?,
        beregningsResultatAfpPrivatSoker: BeregningsResultatAfpPrivat?,
        virk: Date?,
        beregningTilstotende: Beregning?,
        beregningsResultatAlderspensjonTilstotende: BeregningsResultatAlderspensjon2011?,
        beregningsResultatAfpPrivatTilstotende: BeregningsResultatAfpPrivat?
    ) : super() {
        this.vilkarsvedtakListe = vilkarsvedtakListe
        this.beregnetUtbetalingsperiodeListeBruker = beregnetUtbetalingsperiodeListeBruker
        this.beregnetUtbetalingsperiodeListeEPS = beregnetUtbetalingsperiodeListeEPS
        this.kravhode = kravhode
        this.beregningsResultatAlderspensjonSoker = beregningsResultatAlderspensjonSoker
        this.beregningSoker = beregningSoker
        this.beregningsResultatAfpPrivatSoker = beregningsResultatAfpPrivatSoker
        this.virk = virk
        this.beregningTilstotende = beregningTilstotende
        this.beregningsResultatAlderspensjonTilstotende = beregningsResultatAlderspensjonTilstotende
        this.beregningsResultatAfpPrivatTilstotende = beregningsResultatAfpPrivatTilstotende
    }

    companion object {
        private const val serialVersionUID = 8864544986202456302L
    }
}