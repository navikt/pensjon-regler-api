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
     * En liste med hva som er beregnet utbetalt av ytelser hittil i �r.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListeBruker = new ArrayList<BeregnetUtbetalingsperiode>();

    /**
     * En liste med hva som er beregnet utbetalt av ytelser hittil i �r.
     * Listen inneholder et sett med kontinuerlige ikke-overlappende perioder
     */
    private List<BeregnetUtbetalingsperiode> beregnetUtbetalingsperiodeListeEPS = new ArrayList<BeregnetUtbetalingsperiode>();

    /**
     * Dersom s�ker har uf�repensjon og dersom beregning 1967.
     */
    private Beregning beregningSoker;

    /**
     * Dersom s�ker har ApfPrivat skal beregningsresultatet sendes inn.
     */
    private BeregningsResultatAfpPrivat beregningsResultatAfpPrivatSoker;

    /**
     * Dersom s�kers EPS har ApfPrivat skal dennes beregningsresultat sendes inn.
     */
    private BeregningsResultatAfpPrivat beregningsResultatAfpPrivatTilstotende;

    /**
     * Beregningen ved virkningstidspunkt. Vil inneholde en AldersberegningKapittel19,
     * som igjen inneholder MinstePensjonsniv�, Basispensjon, Restpensjon, PensjonUnderUtbetaling
     * og BeregningsInformasjon.
     */
    private AbstraktBeregningsResultat beregningsResultatAlderspensjonSoker;

    /**
     * Dersom s�ker har EPS som mottar alderspensjon etter reglene med virk etter 01.01.2011
     * skal dennes pensjon sendes inn.
     */
    private AbstraktBeregningsResultat beregningsResultatAlderspensjonTilstotende;

    /**
     * Beregningsresultatet fra uf�retrygdberegningen for s�ker
     */
    private BeregningsresultatUforetrygd beregningsResultatUforetrygdSoker;

    /**
     * Dersom EPS har sakstype UP og virkningsdatoen er f.o.m. 01.01.2015
     */
    private BeregningsresultatUforetrygd beregningsresultatUforetrygdTilstotende;

    /**
     * Dersom s�ker har EPS som mottar pensjon(UP, AP,AFP) etter reglene med virk f�r 01.01.2011
     * skal dennes pensjon sendes inn.
     */
    private Beregning beregningTilstotende;

    /**
     * Ektefelletillegg for uf�retrygd for s�ker
     */
    private EktefelletilleggUT ektefelletilleggUT;

    private boolean etteroppgjor;

    private EtteroppgjorGrunnlag etteroppgjorGrunnlag;

    /**
     * Kravhodet til beregningen.
     */
    private Kravhode kravhode;

    /**
     * Liste av vilk�rsvedtak for ytelser som skal beregnes.
     */
    private List<VilkarsVedtak> vilkarsvedtakListe = new ArrayList<VilkarsVedtak>();

    /**
     * Virkningstidspunkt for s�knad om fors�rgingstillegg.
     */
    private Date virk;

}
