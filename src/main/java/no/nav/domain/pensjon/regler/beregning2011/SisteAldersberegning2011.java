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
    private static final long serialVersionUID = 1951890960976338107L;

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

    public SisteAldersberegning2011() {
        super();
    }

    public SisteAldersberegning2011(SisteAldersberegning2011 sb) {
        super(sb);
        if (sb.regelverkType != null) {
            regelverkType = new RegelverkTypeCti(sb.regelverkType);
        }
        if (sb.basispensjon != null) {
            basispensjon = new Basispensjon(sb.basispensjon);
        }
        if (sb.restpensjon != null) {
            restpensjon = new Basispensjon(sb.restpensjon);
        }
        if (sb.pensjonUnderUtbetaling != null) {
            pensjonUnderUtbetaling = new PensjonUnderUtbetaling(sb.pensjonUnderUtbetaling);
        }
        if (sb.pensjonUnderUtbetaling2025AltKonv != null) {
            pensjonUnderUtbetaling2025AltKonv = new PensjonUnderUtbetaling(sb.pensjonUnderUtbetaling2025AltKonv);
        }
        if (sb.beholdninger != null) {
            beholdninger = new Beholdninger(sb.beholdninger);
        }
        if (sb.beholdningerAltKonv != null) {
            beholdningerAltKonv = new Beholdninger(sb.beholdningerAltKonv);
        }
        if (sb.eps != null) {
            eps = new Persongrunnlag(sb.eps);
        }
        epsMottarPensjon = sb.epsMottarPensjon;
        if (sb.vilkarsvedtakEktefelletillegg != null) {
            vilkarsvedtakEktefelletillegg = new VilkarsVedtak(sb.vilkarsvedtakEktefelletillegg);
        }
        if (sb.avdodesPersongrunnlag != null) {
            avdodesPersongrunnlag = new Persongrunnlag(sb.avdodesPersongrunnlag);
        }
        gjenlevenderettAnvendt = sb.gjenlevenderettAnvendt;
        anvendtGjenlevenderettVedtak = sb.anvendtGjenlevenderettVedtak;
        if (sb.beregningsMetode != null) {
            beregningsMetode = new BeregningMetodeTypeCti(sb.beregningsMetode);
        }
        tt_anv_kap_20 = sb.tt_anv_kap_20;
        tt_anv_kap_20AltKonv = sb.tt_anv_kap_20AltKonv;
        if (sb.prorataBrok_kap_20 != null) {
            prorataBrok_kap_20 = new Brok(sb.prorataBrok_kap_20);
        }
        if (sb.prorataBrok_kap_20AltKonv != null) {
            prorataBrok_kap_20AltKonv = new Brok(sb.prorataBrok_kap_20AltKonv);
        }
    }

    public RegelverkTypeCti getRegelverkType() {
        return regelverkType;
    }

    public void setRegelverkType(RegelverkTypeCti regelverkType) {
        this.regelverkType = regelverkType;
    }

    public Basispensjon getBasispensjon() {
        return basispensjon;
    }

    public void setBasispensjon(Basispensjon basispensjon) {
        this.basispensjon = basispensjon;
    }

    public Basispensjon getRestpensjon() {
        return restpensjon;
    }

    public void setRestpensjon(Basispensjon restpensjon) {
        this.restpensjon = restpensjon;
    }

    public PensjonUnderUtbetaling getPensjonUnderUtbetaling() {
        return pensjonUnderUtbetaling;
    }

    public void setPensjonUnderUtbetaling(PensjonUnderUtbetaling pensjonUnderUtbetaling) {
        this.pensjonUnderUtbetaling = pensjonUnderUtbetaling;
    }

    public Beholdninger getBeholdninger() {
        return beholdninger;
    }

    public void setBeholdninger(Beholdninger beholdninger) {
        this.beholdninger = beholdninger;
    }

    public Persongrunnlag getEps() {
        return eps;
    }

    public void setEps(Persongrunnlag eps) {
        this.eps = eps;
    }

    public boolean isEpsMottarPensjon() {
        return epsMottarPensjon;
    }

    public void setEpsMottarPensjon(boolean epsMottarPensjon) {
        this.epsMottarPensjon = epsMottarPensjon;
    }

    public VilkarsVedtak getVilkarsvedtakEktefelletillegg() {
        return vilkarsvedtakEktefelletillegg;
    }

    public void setVilkarsvedtakEktefelletillegg(VilkarsVedtak vilkarsvedtakEktefelletillegg) {
        this.vilkarsvedtakEktefelletillegg = vilkarsvedtakEktefelletillegg;
    }

    public Persongrunnlag getAvdodesPersongrunnlag() {
        return avdodesPersongrunnlag;
    }

    public void setAvdodesPersongrunnlag(Persongrunnlag avdodesPersongrunnlag) {
        this.avdodesPersongrunnlag = avdodesPersongrunnlag;
    }

    public boolean isGjenlevenderettAnvendt() {
        return gjenlevenderettAnvendt;
    }

    public void setGjenlevenderettAnvendt(boolean gjenlevenderettAnvendt) {
        this.gjenlevenderettAnvendt = gjenlevenderettAnvendt;
    }

    public VilkarsVedtak getAnvendtGjenlevenderettVedtak() {
        return anvendtGjenlevenderettVedtak;
    }

    public void setAnvendtGjenlevenderettVedtak(VilkarsVedtak anvendtGjenlevenderettVedtak) {
        this.anvendtGjenlevenderettVedtak = anvendtGjenlevenderettVedtak;
    }

    public int getTt_anv_kap_20() {
        return tt_anv_kap_20;
    }

    public void setTt_anv_kap_20(int tt_anv_kap_20) {
        this.tt_anv_kap_20 = tt_anv_kap_20;
    }

    public PensjonUnderUtbetaling getPensjonUnderUtbetaling2025AltKonv() {
        return pensjonUnderUtbetaling2025AltKonv;
    }

    public void setPensjonUnderUtbetaling2025AltKonv(PensjonUnderUtbetaling pensjonUnderUtbetaling2025AltKonv) {
        this.pensjonUnderUtbetaling2025AltKonv = pensjonUnderUtbetaling2025AltKonv;
    }

    public Beholdninger getBeholdningerAltKonv() {
        return beholdningerAltKonv;
    }

    public void setBeholdningerAltKonv(Beholdninger beholdningerAltKonv) {
        this.beholdningerAltKonv = beholdningerAltKonv;
    }

    public BeregningMetodeTypeCti getBeregningsMetode() {
        return beregningsMetode;
    }

    public void setBeregningsMetode(BeregningMetodeTypeCti beregningsMetode) {
        this.beregningsMetode = beregningsMetode;
    }

    public Brok getProrataBrok_kap_20() {
        return prorataBrok_kap_20;
    }

    public void setProrataBrok_kap_20(Brok prorataBrok_kap_20) {
        this.prorataBrok_kap_20 = prorataBrok_kap_20;
    }

    public int getTt_anv_kap_20AltKonv() {
        return tt_anv_kap_20AltKonv;
    }

    public void setTt_anv_kap_20AltKonv(int tt_anv_kap_20AltKonv) {
        this.tt_anv_kap_20AltKonv = tt_anv_kap_20AltKonv;
    }

    public Brok getProrataBrok_kap_20AltKonv() {
        return prorataBrok_kap_20AltKonv;
    }

    public void setProrataBrok_kap_20AltKonv(Brok prorataBrok_kap_20AltKonv) {
        this.prorataBrok_kap_20AltKonv = prorataBrok_kap_20AltKonv;
    }
}
