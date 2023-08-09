package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;
import no.nav.domain.pensjon.regler.beregning.*;
import no.nav.domain.pensjon.regler.beregning.penobjekter.*;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.util.formula.IFormelProvider;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Objektet inneholder den faktiske pensjonen under utbetaling, samt en liste
 * over delytelsene som denne består av.
 * 
 * @author Ørnulf Moen
 */
public class PensjonUnderUtbetaling implements Serializable {
    private static final long serialVersionUID = 9006003125077854045L;

    /**
     * property change variabler
     */
    private transient PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private static final HashMap<Class<?>, String> properties = finnProperties();

    /**
     * Månedsbeløp netto, summen av alle delytelsene i ytelseskomponenter. Disse er
     * avrundet hver for seg til nærmeste krone. Dette medfører at
     * avrund(totalbelopNettoAr/12) vil kunne være forskjellig fra totalbelopNetto.
     */
    @GuiPrompt(prompt = "Sum netto per måned")
    private int totalbelopNetto;

    /**
     * Årlig netto beløp under utbetaling
     */
    @GuiPrompt(prompt = "Sum netto per år")
    private double totalbelopNettoAr;

    /**
     * Angir sum brutto per måned.
     */
    @GuiPrompt(prompt = "Sum brutto per måned")
    private int totalbelopBrutto;

    /**
     * Angir sum brutto per år.
     */
    @GuiPrompt(prompt = "Sum brutto per år")
    private double totalbelopBruttoAr;

    /**
     * Indikerer hvilken beregningsformel som ble brukt.
     */
    @GuiPrompt(prompt = "Formel")
    private FormelKodeCti formelKode;

    @GuiPrompt(prompt = "Regulering fratrekk")
    private double pubReguleringFratrekk;

    private List<Ytelseskomponent> ytelseskomponenter = new ArrayList<Ytelseskomponent>();

    /**
     * TemporarYtelseskomponent PREG_tpiYtelse Eksisterer kun inne i regulering
     */
    private TemporarYtelseskomponent PREG_tpiYtelse;

    /**
     * Metode som benyttes av XStream og Java-serialisering for å
     * initialisere felt vi hopper over p.g.a sykliske avhengigheter.
     */
    private Object readResolve() throws ObjectStreamException {
        pcs = new PropertyChangeSupport(this);
        return this;
    }

    public PensjonUnderUtbetaling() {
        super();
        pcs = new PropertyChangeSupport(this);
        setFormelKode(new FormelKodeCti("BPUx"));
    }

    public PensjonUnderUtbetaling(PensjonUnderUtbetaling pub) {
        super();
        pcs = new PropertyChangeSupport(this);
        totalbelopNetto = pub.totalbelopNetto;
        totalbelopNettoAr = pub.totalbelopNettoAr;
        totalbelopBrutto = pub.totalbelopBrutto;
        totalbelopBruttoAr = pub.totalbelopBruttoAr;
        if (pub.formelKode != null) {
            formelKode = new FormelKodeCti(pub.formelKode);
        }
        pubReguleringFratrekk = pub.pubReguleringFratrekk;
        ytelseskomponenter = new ArrayList<Ytelseskomponent>();
        if (pub.ytelseskomponenter != null) {
            for (Ytelseskomponent yk : pub.getYtelseskomponenter()) {
                Class<? extends Ytelseskomponent> clazz = yk.getClass();
                try {
                    Constructor<? extends Ytelseskomponent> constructor = clazz.getConstructor(new Class[] {clazz});
                    ytelseskomponenter.add(constructor.newInstance(yk));
                } catch (InvocationTargetException e) {
                    //Vil kastes hvis copy constructor f.eks. ledet til nullpointerexception.
                    Throwable cause = e.getCause();
                    if (cause instanceof RuntimeException) {
                        throw (RuntimeException) cause;
                    } else {
                        throw new RuntimeException(e);
                    }
                } catch (Exception e) {
                    //Vil kastes hvis f.eks. copy constructor ikke finnes for ytelseskomponenten.
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public List<Ytelseskomponent> getYtelseskomponenter() {
        return ytelseskomponenter;
    }

    public void setYtelseskomponenter(List<Ytelseskomponent> delytelser) {
        List<Ytelseskomponent> old = delytelser;
        ytelseskomponenter = delytelser;
        pcs.firePropertyChange("ytelseskomponenterAsArray", old, delytelser);
    }

    public int getTotalbelopNetto() {
        return totalbelopNetto;
    }

    public void setTotalbelopNetto(int totalbelopNetto) {
        this.totalbelopNetto = totalbelopNetto;
    }

    public double getTotalbelopNettoAr() {
        return totalbelopNettoAr;
    }

    public void setTotalbelopNettoAr(double totalbelopNettoAr) {
        this.totalbelopNettoAr = totalbelopNettoAr;
    }

    public int getTotalbelopBrutto() {
        return totalbelopBrutto;
    }

    public void setTotalbelopBrutto(int totalbelopBrutto) {
        this.totalbelopBrutto = totalbelopBrutto;
    }

    public double getTotalbelopBruttoAr() {
        return totalbelopBruttoAr;
    }

    public void setTotalbelopBruttoAr(double totalbelopBruttoAr) {
        this.totalbelopBruttoAr = totalbelopBruttoAr;
    }

    public double getPubReguleringFratrekk() {
        return pubReguleringFratrekk;
    }

    public void setPubReguleringFratrekk(double pubReguleringFratrekk) {
        this.pubReguleringFratrekk = pubReguleringFratrekk;
    }

    /**
     * @return
     * @deprecated
     */
    @Deprecated
    public Ytelseskomponent[] retrieveYtelseskomponenterAsArray() {
        return ytelseskomponenter.toArray(new Ytelseskomponent[0]);
    }

    /**
     * Read only property for ytelseskomponenter as array.
     * 
     * @return array of Ytelseskomponent
     */
    public Ytelseskomponent[] getYtelseskomponenterAsArray() {
        return ytelseskomponenter != null ? ytelseskomponenter.toArray(new Ytelseskomponent[ytelseskomponenter.size()]) : new Ytelseskomponent[0];
    }

    public FormelKodeCti getFormelKode() {
        return formelKode;
    }

    public void setFormelKode(FormelKodeCti formelKode) {
        this.formelKode = formelKode;
    }

    public Grunnpensjon getGrunnpensjon() {
        return hentYtelseskomponent(Grunnpensjon.class);
    }

    public void setGrunnpensjon(Grunnpensjon g) {
        fjernEllerLeggTilYtelseskomponent(Grunnpensjon.class, g);
    }

    public Tilleggspensjon getTilleggspensjon() {
        return hentYtelseskomponent(Tilleggspensjon.class);
    }

    public void setTilleggspensjon(Tilleggspensjon t) {
        fjernEllerLeggTilYtelseskomponent(Tilleggspensjon.class, t);
    }

    public Pensjonstillegg getPensjonstillegg() {
        return hentYtelseskomponent(Pensjonstillegg.class);
    }

    public void setPensjonstillegg(Pensjonstillegg p) {
        fjernEllerLeggTilYtelseskomponent(Pensjonstillegg.class, p);
    }

    public UforetrygdOrdiner getUforetrygdOrdiner() {
        return hentYtelseskomponent(UforetrygdOrdiner.class);
    }

    public void setUforetrygdOrdiner(UforetrygdOrdiner u) {
        fjernEllerLeggTilYtelseskomponent(UforetrygdOrdiner.class, u);
    }

    public MinstenivatilleggPensjonistpar getMinstenivatilleggPensjonistpar() {
        return hentYtelseskomponent(MinstenivatilleggPensjonistpar.class);
    }

    public void setMinstenivatilleggPensjonistpar(MinstenivatilleggPensjonistpar m) {
        fjernEllerLeggTilYtelseskomponent(MinstenivatilleggPensjonistpar.class, m);
    }

    public MinstenivatilleggIndividuelt getMinstenivatilleggIndividuelt() {
        return hentYtelseskomponent(MinstenivatilleggIndividuelt.class);
    }

    public void setMinstenivatilleggIndividuelt(MinstenivatilleggIndividuelt m) {
        fjernEllerLeggTilYtelseskomponent(MinstenivatilleggIndividuelt.class, m);
    }

    public Garantipensjon getGarantipensjon() {
        return hentYtelseskomponent(Garantipensjon.class);
    }

    public void setGarantipensjon(Garantipensjon g) {
        fjernEllerLeggTilYtelseskomponent(Garantipensjon.class, g);
    }

    public Inntektspensjon getInntektspensjon() {
        return hentYtelseskomponent(Inntektspensjon.class);
    }

    public void setInntektspensjon(Inntektspensjon i) {
        fjernEllerLeggTilYtelseskomponent(Inntektspensjon.class, i);
    }

    public Garantitillegg getGarantitillegg() {
        return hentYtelseskomponent(Garantitillegg.class);
    }

    public void setGarantitillegg(Garantitillegg g) {
        fjernEllerLeggTilYtelseskomponent(Garantitillegg.class, g);
    }

    public Gjenlevendetillegg getGjenlevendetillegg() {
        return hentYtelseskomponent(Gjenlevendetillegg.class);
    }

    public void setGjenlevendetillegg(Gjenlevendetillegg g) {
        fjernEllerLeggTilYtelseskomponent(Gjenlevendetillegg.class, g);
    }

    public AfpLivsvarig getAfpLivsvarig() {
        return hentYtelseskomponent(AfpLivsvarig.class);
    }

    public void setAfpLivsvarig(AfpLivsvarig a) {
        fjernEllerLeggTilYtelseskomponent(AfpLivsvarig.class, a);
    }

    public AfpKronetillegg getAfpKronetillegg() {
        return hentYtelseskomponent(AfpKronetillegg.class);
    }

    public void setAfpKronetillegg(AfpKronetillegg a) {
        fjernEllerLeggTilYtelseskomponent(AfpKronetillegg.class, a);
    }

    public AfpKompensasjonstillegg getAfpKompensasjonstillegg() {
        return hentYtelseskomponent(AfpKompensasjonstillegg.class);
    }

    public void setAfpKompensasjonstillegg(AfpKompensasjonstillegg a) {
        fjernEllerLeggTilYtelseskomponent(AfpKompensasjonstillegg.class, a);
    }

    public Skjermingstillegg getSkjermingstillegg() {
        return hentYtelseskomponent(Skjermingstillegg.class);
    }

    public void setSkjermingstillegg(Skjermingstillegg s) {
        fjernEllerLeggTilYtelseskomponent(Skjermingstillegg.class, s);
    }

    public Sertillegg getSertillegg() {
        return hentYtelseskomponent(Sertillegg.class);
    }

    public void setSertillegg(Sertillegg s) {
        fjernEllerLeggTilYtelseskomponent(Sertillegg.class, s);
    }

    public Ventetillegg getVentetillegg() {
        return hentYtelseskomponent(Ventetillegg.class);
    }

    public void setVentetillegg(Ventetillegg v) {
        fjernEllerLeggTilYtelseskomponent(Ventetillegg.class, v);
    }

    public Familietillegg getFamilietillegg() {
        return hentYtelseskomponent(Familietillegg.class);
    }

    public void setFamilietillegg(Familietillegg f) {
        fjernEllerLeggTilYtelseskomponent(Familietillegg.class, f);
    }

    public FasteUtgifterTillegg getFasteUtgifterTillegg() {
        return hentYtelseskomponent(FasteUtgifterTillegg.class);
    }

    public void setFasteUtgifterTillegg(FasteUtgifterTillegg f) {
        fjernEllerLeggTilYtelseskomponent(FasteUtgifterTillegg.class, f);
    }

    public BarnetilleggSerkullsbarn getBarnetilleggSerkullsbarn() {
        return hentYtelseskomponent(BarnetilleggSerkullsbarn.class);
    }

    public void setBarnetilleggSerkullsbarn(BarnetilleggSerkullsbarn b) {
        fjernEllerLeggTilYtelseskomponent(BarnetilleggSerkullsbarn.class, b);
    }

    public BarnetilleggSerkullsbarnUT getBarnetilleggSerkullsbarnUT() {
        return hentYtelseskomponent(BarnetilleggSerkullsbarnUT.class);
    }

    public void setBarnetilleggSerkullsbarnUT(BarnetilleggSerkullsbarnUT b) {
        fjernEllerLeggTilYtelseskomponent(BarnetilleggSerkullsbarnUT.class, b);
    }

    public BarnetilleggFellesbarn getBarnetilleggFellesbarn() {
        return hentYtelseskomponent(BarnetilleggFellesbarn.class);
    }

    public void setBarnetilleggFellesbarn(BarnetilleggFellesbarn b) {
        fjernEllerLeggTilYtelseskomponent(BarnetilleggFellesbarn.class, b);
    }

    public BarnetilleggFellesbarnUT getBarnetilleggFellesbarnUT() {
        return hentYtelseskomponent(BarnetilleggFellesbarnUT.class);
    }

    public void setBarnetilleggFellesbarnUT(BarnetilleggFellesbarnUT b) {
        fjernEllerLeggTilYtelseskomponent(BarnetilleggFellesbarnUT.class, b);
    }

    public Ektefelletillegg getEktefelletillegg() {
        return hentYtelseskomponent(Ektefelletillegg.class);
    }

    public void setEktefelletillegg(Ektefelletillegg e) {
        fjernEllerLeggTilYtelseskomponent(Ektefelletillegg.class, e);
    }

    public EktefelletilleggUT getEktefelletilleggUT() {
        return hentYtelseskomponent(EktefelletilleggUT.class);
    }

    public void setEktefelletilleggUT(EktefelletilleggUT e) {
        fjernEllerLeggTilYtelseskomponent(EktefelletilleggUT.class, e);
    }

    public FremskrevetAfpLivsvarig getFremskrevetAfpLivsvarig() {
        return hentYtelseskomponent(FremskrevetAfpLivsvarig.class);
    }

    public void setFremskrevetAfpLivsvarig(FremskrevetAfpLivsvarig f) {
        fjernEllerLeggTilYtelseskomponent(FremskrevetAfpLivsvarig.class, f);
    }

    public Paragraf_8_5_1_tillegg getParagraf_8_5_1_tillegg() {
        return hentYtelseskomponent(Paragraf_8_5_1_tillegg.class);
    }

    public void setParagraf_8_5_1_tillegg(Paragraf_8_5_1_tillegg p) {
        fjernEllerLeggTilYtelseskomponent(Paragraf_8_5_1_tillegg.class, p);
    }

    public AfpTillegg getAfpTillegg() {
        return hentYtelseskomponent(AfpTillegg.class);
    }

    public void setAfpTillegg(AfpTillegg a) {
        fjernEllerLeggTilYtelseskomponent(AfpTillegg.class, a);
    }

    public Garantitillegg_Art_27 getGarantitillegg_Art_27() {
        return hentYtelseskomponent(Garantitillegg_Art_27.class);
    }

    public void setGarantitillegg_Art_27(Garantitillegg_Art_27 g) {
        fjernEllerLeggTilYtelseskomponent(Garantitillegg_Art_27.class, g);
    }

    public Garantitillegg_Art_50 getGarantitillegg_Art_50() {
        return hentYtelseskomponent(Garantitillegg_Art_50.class);
    }

    public void setGarantitillegg_Art_50(Garantitillegg_Art_50 g) {
        fjernEllerLeggTilYtelseskomponent(Garantitillegg_Art_50.class, g);
    }

    public Hjelpeloshetsbidrag getHjelpeloshetsbidrag() {
        return hentYtelseskomponent(Hjelpeloshetsbidrag.class);
    }

    public void setHjelpeloshetsbidrag(Hjelpeloshetsbidrag h) {
        fjernEllerLeggTilYtelseskomponent(Hjelpeloshetsbidrag.class, h);
    }

    public KrigOgGammelYrkesskade getKrigOgGammelYrkesskade() {
        return hentYtelseskomponent(KrigOgGammelYrkesskade.class);
    }

    public void setKrigOgGammelYrkesskade(KrigOgGammelYrkesskade k) {
        fjernEllerLeggTilYtelseskomponent(KrigOgGammelYrkesskade.class, k);
    }

    public Mendel getMendel() {
        return hentYtelseskomponent(Mendel.class);
    }

    public void setMendel(Mendel m) {
        fjernEllerLeggTilYtelseskomponent(Mendel.class, m);
    }

    public TilleggTilHjelpIHuset getTilleggTilHjelpIHuset() {
        return hentYtelseskomponent(TilleggTilHjelpIHuset.class);
    }

    public void setTilleggTilHjelpIHuset(TilleggTilHjelpIHuset t) {
        fjernEllerLeggTilYtelseskomponent(TilleggTilHjelpIHuset.class, t);
    }

    public BasisGrunnpensjon getBasisGrunnpensjon() {
        return hentYtelseskomponent(BasisGrunnpensjon.class);
    }

    public void setBasisGrunnpensjon(BasisGrunnpensjon b) {
        fjernEllerLeggTilYtelseskomponent(BasisGrunnpensjon.class, b);
    }

    public BasisTilleggspensjon getBasisTilleggspensjon() {
        return hentYtelseskomponent(BasisTilleggspensjon.class);
    }

    public void setBasisTilleggspensjon(BasisTilleggspensjon b) {
        fjernEllerLeggTilYtelseskomponent(BasisTilleggspensjon.class, b);
    }

    public BasisPensjonstillegg getBasisPensjonstillegg() {
        return hentYtelseskomponent(BasisPensjonstillegg.class);
    }

    public void setBasisPensjonstillegg(BasisPensjonstillegg b) {
        fjernEllerLeggTilYtelseskomponent(BasisPensjonstillegg.class, b);
    }

    public TemporarYtelseskomponent getTemporarYtelseskomponent() {
        return PREG_tpiYtelse;
    }

    public void setTemporarYtelseskomponent(TemporarYtelseskomponent t) {
        PREG_tpiYtelse = t;
    }

    public Arbeidsavklaringspenger getArbeidsavklaringspenger() {
        return hentYtelseskomponent(Arbeidsavklaringspenger.class);
    }

    public void setArbeidsavklaringspenger(Arbeidsavklaringspenger a) {
        fjernEllerLeggTilYtelseskomponent(Arbeidsavklaringspenger.class, a);
    }

    public ArbeidsavklaringspengerUT getArbeidsavklaringspengerUT() {
        return hentYtelseskomponent(ArbeidsavklaringspengerUT.class);
    }

    public void setArbeidsavklaringspengerUT(ArbeidsavklaringspengerUT a) {
        fjernEllerLeggTilYtelseskomponent(ArbeidsavklaringspengerUT.class, a);
    }

    public FasteUtgifterTilleggUT getFasteUtgifterTilleggUT() {
        return hentYtelseskomponent(FasteUtgifterTilleggUT.class);
    }

    public void setFasteUtgifterTilleggUT(FasteUtgifterTilleggUT f) {
        fjernEllerLeggTilYtelseskomponent(FasteUtgifterTilleggUT.class, f);
    }

    public Garantitillegg_Art_27_UT getGarantitillegg_Art_27_UT() {
        return hentYtelseskomponent(Garantitillegg_Art_27_UT.class);
    }

    public void setGarantitillegg_Art_27_UT(Garantitillegg_Art_27_UT g) {
        fjernEllerLeggTilYtelseskomponent(Garantitillegg_Art_27_UT.class, g);
    }

    public SkattefriGrunnpensjon getSkattefriGrunnpensjon() {
        return hentYtelseskomponent(SkattefriGrunnpensjon.class);
    }

    public void setSkattefriGrunnpensjon(SkattefriGrunnpensjon s) {
        fjernEllerLeggTilYtelseskomponent(SkattefriGrunnpensjon.class, s);
    }

    public SkattefriUforetrygdOrdiner getSkattefriUforetrygdOrdiner() {
        return hentYtelseskomponent(SkattefriUforetrygdOrdiner.class);
    }

    public void setSkattefriUforetrygdOrdiner(SkattefriUforetrygdOrdiner s) {
        fjernEllerLeggTilYtelseskomponent(SkattefriUforetrygdOrdiner.class, s);
    }

    public Sykepenger getSykepenger() {
        return hentYtelseskomponent(Sykepenger.class);
    }

    public void setSykepenger(Sykepenger s) {
        fjernEllerLeggTilYtelseskomponent(Sykepenger.class, s);
    }

    public SykepengerUT getSykepengerUT() {
        return hentYtelseskomponent(SykepengerUT.class);
    }

    public void setSykepengerUT(SykepengerUT s) {
        fjernEllerLeggTilYtelseskomponent(SykepengerUT.class, s);
    }

    public UforetilleggTilAlderspensjon getUforetilleggTilAlderspensjon() {
        return hentYtelseskomponent(UforetilleggTilAlderspensjon.class);
    }

    public void setUforetilleggTilAlderspensjon(UforetilleggTilAlderspensjon u) {
        fjernEllerLeggTilYtelseskomponent(UforetilleggTilAlderspensjon.class, u);
    }

    public GjenlevendetilleggAP getGjenlevendetilleggAP() {
        return hentYtelseskomponent(GjenlevendetilleggAP.class);
    }

    public void setGjenlevendetilleggAP(GjenlevendetilleggAP u) {
        fjernEllerLeggTilYtelseskomponent(GjenlevendetilleggAP.class, u);
    }

    public IFormelProvider[] getFormelProviderArray() {
        return ytelseskomponenter.stream().filter( yk -> yk instanceof IFormelProvider).map(yk -> (IFormelProvider)yk ).toArray(value -> new IFormelProvider[value]);
    }

    /**
     * @param <T>
     * @param classOfYtelseskomponent, angir klassen til ytelseskomponent man ønsker å hente
     * @return Ytelseskomponent av ønsket type
     */
    @SuppressWarnings("unchecked")
    public <T extends Ytelseskomponent> T hentYtelseskomponent(Class<T> classOfYtelseskomponent) {
        for (Ytelseskomponent yt : ytelseskomponenter) {
            if (classOfYtelseskomponent.isInstance(yt)) {
                return (T) yt;
            }
        }
        return null;
    }

    /**
     * Legger til en ytelseskomponent og oppdaterer properties ved å fyre av en property changed event
     * 
     * @param y
     */
    public void leggTilYtelseskomponent(Ytelseskomponent y) {
        Ytelseskomponent lagret = hentYtelseskomponent(y.getClass());
        if (lagret != null) {
            ytelseskomponenter.remove(lagret);
        }
        ytelseskomponenter.add(y);

        if (properties.containsKey(y.getClass())) {
            // Vi må fyre en property changed event slik at Blaze skal oppfatte at en gitt property skal oppdateres
            pcs.firePropertyChange(properties.get(y.getClass()), lagret, y);
            pcs.firePropertyChange("ytelseskomponenter", null, null);
            pcs.firePropertyChange("ytelseskomponenterAsArray", null, null);
        }
    }

    /**
     * Fjerner en ytelseskomponent basert på objekttypen
     * 
     * @param y, ytelseskomponent
     */
    public void fjernYtelseskomponent(Ytelseskomponent y) {
        fjernYtelseskomponent(y.getClass());
    }

    /**
     * Fjerner alle ytelseskomponenter og oppdaterer properties ved å fyre av en property changed event
     */
    public void fjernAlleYtelseskomponenter() {
        List<Ytelseskomponent> old = ytelseskomponenter;
        ytelseskomponenter.clear();
        totalbelopNetto = 0;
        totalbelopNettoAr = 0.0;
        for (Class<?> clazz : properties.keySet()) {
            pcs.firePropertyChange(properties.get(clazz), old, null);
        }
        pcs.firePropertyChange("ytelseskomponenter", null, null);
        pcs.firePropertyChange("ytelseskomponenterAsArray", null, null);
    }

    /**
     * Legger en listener til registeret av lyttere
     * 
     * @param listener
     */
    public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * Fjerner en listener i registeret for lyttere
     * 
     * @param listener
     */
    public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();

        buf.append(String.format("PensjonUnderUtbetaling formelKode=%s, totalbelopNetto=%s, totalbelopNettoAr=%s %s",
                formelKode,
                getTotalbelopNetto(),
                getTotalbelopNettoAr(),
                "\n"));
        for (Ytelseskomponent y : ytelseskomponenter) {
            buf.append(y.getBrutto()).append("  ").append(y.getNetto()).append("  ").append(y.getFradrag()).append("  ").append(y.getBruttoPerAr()).append("  ")
                    .append(y.getYtelsekomponentType().toString());
        }
        return buf.toString();
    }

    /**
     * Fjerner en ytelseskomponent, null safe
     * 
     * @param y
     */
    private void fjernEllerLeggTilYtelseskomponent(Class<? extends Ytelseskomponent> clazz, Ytelseskomponent y) {
        if (y == null) {
            fjernYtelseskomponent(clazz);
        } else {
            leggTilYtelseskomponent(y);
        }
    }

    /**
     * Fjerner en ytelseskomponent og oppdaterer properties ved å fyre av en property changed event
     * 
     * @param clazz
     */
    private void fjernYtelseskomponent(Class<? extends Ytelseskomponent> clazz) {
        boolean funnet = false;
        Ytelseskomponent tmpYtelseskomponent = null;
        for (Ytelseskomponent ytelseskomponent : ytelseskomponenter) {
            if (ytelseskomponent.getClass().equals(clazz)) {
                funnet = true;
                tmpYtelseskomponent = ytelseskomponent;
            }
        }
        if (funnet) {
            ytelseskomponenter.remove(tmpYtelseskomponent);
            if (properties.containsKey(clazz)) {
                // Vi må fyre en property changed event slik at Blaze skal oppfatte at en gitt property skal oppdateres
                pcs.firePropertyChange(properties.get(clazz), tmpYtelseskomponent, null);
                pcs.firePropertyChange("ytelseskomponenter", null, null);
                pcs.firePropertyChange("ytelseskomponenterAsArray", null, null);
            }
        }
    }

    /**
     * Metode som endrer forste bokstav til lowecase
     * 
     * @param input
     * @return string
     */
    private static String forbokstavTilLowercase(String input) {
        String forsteBokstav = input.substring(0, 1);
        String resten = input.substring(1);

        return forsteBokstav.toLowerCase() + resten;
    }

    /**
     * Metode som finner properties for ytelseskomponenter
     * og legger dem i hashmap
     * 
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    protected static HashMap<Class<?>, String> finnProperties() {
        HashMap<Class<?>, String> properties = new HashMap<Class<?>, String>();
        Method[] methods = PensjonUnderUtbetaling.class.getDeclaredMethods();
        for (Method method : methods) {
            Class<?> clazz = method.getReturnType();
            Class<?> superclass = null;
            if (clazz != null) {
                superclass = clazz.getSuperclass();
            }
            while (superclass != null) {
                if (superclass != null && superclass.equals(Ytelseskomponent.class)) {
                    String propertyName = method.getName().substring(3);
                    if (propertyName.toLowerCase().equals(clazz.getSimpleName().toLowerCase())) {
                        properties.put(clazz, forbokstavTilLowercase(propertyName));
                    }
                }
                superclass = superclass.getSuperclass();
            }
        }

        return properties;
    }
}
