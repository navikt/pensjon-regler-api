package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;
import no.nav.domain.pensjon.regler.beregning2011.BeregnetUtbetalingsperiode;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAfpPrivat;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAlderspensjon2011;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;
import no.nav.domain.pensjon.regler.beregning2011.EktefelletilleggUT;
import no.nav.domain.pensjon.regler.grunnlag.EtteroppgjorGrunnlag;
import no.nav.domain.pensjon.regler.kode.BarnetilleggRegelverkCti;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

/**
 * Objektet inneholder requesten for tjenesten BeregnForsorgingstillegg
 * 
 * @author Kenneth Fjelleng (Capgemini) PK-7106
 * @author Aasmund Nordstoga (Accenture) PK-9028
 * @author Aasmund Nordstoga (Accenture) PK-20773
 */
public class BeregnForsorgingstilleggRequest extends ServiceRequest {

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

}
