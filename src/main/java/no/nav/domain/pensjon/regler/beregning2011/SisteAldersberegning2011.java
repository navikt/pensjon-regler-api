package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.grunnlag.Beholdninger;
import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.kode.BeregningMetodeTypeCti;
import no.nav.domain.pensjon.regler.kode.RegelverkTypeCti;
import no.nav.domain.pensjon.regler.trygdetid.Brok;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

/**
 * Beregning på nytt regelverk
 * Denne benyttes av 2011, 2016 og 2025
 * For 2016 vil alle feltene være aktuelle
 * 
 * @author PREG
 * @author Stian Kroknes (Accenture) - PENPORT-250
 * @author Stian Kroknes (Accenture) Rullet tilbake PENPORT-250
 */
public class SisteAldersberegning2011 extends SisteBeregning {


    private RegelverkTypeCti regelverkType; // Dene benyttes for å avgjøre om det er på 2011, 2016 eller 2025.
    private Basispensjon basispensjon; // 2011
    private Basispensjon restpensjon; // 2011
    private PensjonUnderUtbetaling pensjonUnderUtbetaling;
    private PensjonUnderUtbetaling pensjonUnderUtbetaling2025AltKonv; // PensjonUnderUtbetaling for tapende konvensjon i siste aldersberegning.
    private Beholdninger beholdninger; // 2025
    private Beholdninger beholdningerAltKonv; // Beholdninger for tapende konvensjon i siste aldersberegning.
    private Persongrunnlag eps;
    private boolean epsMottarPensjon;
    private VilkarsVedtak vilkarsvedtakEktefelletillegg;
    private Persongrunnlag avdodesPersongrunnlag;
    private boolean gjenlevenderettAnvendt;
    private VilkarsVedtak anvendtGjenlevenderettVedtak;
    private BeregningMetodeTypeCti beregningsMetode;
    private int tt_anv_kap_20;
    private Brok prorataBrok_kap_20;
    private int tt_anv_kap_20AltKonv;
    private Brok prorataBrok_kap_20AltKonv;

}
