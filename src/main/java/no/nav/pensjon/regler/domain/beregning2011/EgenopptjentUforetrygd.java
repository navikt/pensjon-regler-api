package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.GuiPrompt;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.trygdetid.AnvendtTrygdetid;

import java.io.Serializable;

/**
 * @author Steinar Hjellvik (Decisive) - PKPYTON-1746
 *
 */
public class EgenopptjentUforetrygd implements Serializable {

    private static final long serialVersionUID = -121347340388844508L;

    @GuiPrompt(prompt = "Faktor")
    private double faktor;

    @GuiPrompt(prompt = "Formel")
    private FormelKodeCti formelKode;

    @GuiPrompt(prompt = "�rsbel�p")
    private int arsbelop;

    @GuiPrompt(prompt = "Beregningsgrunnlag ordin�r")
    private AbstraktBeregningsgrunnlag beregningsgrunnlagOrdiner;

    @GuiPrompt(prompt = "Beregningsgrunnlag yrkesskade")
    private AbstraktBeregningsgrunnlag beregningsgrunnlagYrkesskade;

    @GuiPrompt(prompt = "Beregningsgrunnlag yrkesskade gunstigst")
    private boolean beregningsgrunnlagYrkesskadeBest;

    /**
     * Prosentsats brukt for p�slag.
     */
    @GuiPrompt(prompt = "SatsP�slag")
    private int konverteringsPaslagForRedGP;

    /**
     * P�slag pga �kt redusert grunnpensjon sats til egenopptjent uf�retrygd som ang�r konvertert uf�retidpunkt.
     */
    @GuiPrompt(prompt = "P�slag")
    private int konverteringsPaslagForRedGPSats;


    /**
     * Trygdetid som er brukt ved beregning av egenopptjent uf�retrygd.
     */
    @GuiPrompt(prompt = "Anvendt trygdetid")
    private AnvendtTrygdetid anvendtTrygdetid;

    public EgenopptjentUforetrygd() {
        super();
        setFaktor(0.66);
    }

    public EgenopptjentUforetrygd(EgenopptjentUforetrygd egenopptjentUforetrygd) {
        this();
        setFaktor(egenopptjentUforetrygd.getFaktor());
        setArsbelop(egenopptjentUforetrygd.getArsbelop());
        setBeregningsgrunnlagYrkesskadeBest(egenopptjentUforetrygd.isBeregningsgrunnlagYrkesskadeBest());
        setKonverteringsPaslagForRedGP(egenopptjentUforetrygd.getKonverteringsPaslagForRedGP());
        setKonverteringsPaslagForRedGPSats(egenopptjentUforetrygd.getKonverteringsPaslagForRedGPSats());
        if (egenopptjentUforetrygd.getFormelKode() != null) {
            setFormelKode(new FormelKodeCti(egenopptjentUforetrygd.getFormelKode()));
        }
        if (egenopptjentUforetrygd.getBeregningsgrunnlagOrdiner() != null) {
            if (egenopptjentUforetrygd.getBeregningsgrunnlagOrdiner() instanceof BeregningsgrunnlagOrdiner) {
                setBeregningsgrunnlagOrdiner(new BeregningsgrunnlagOrdiner((BeregningsgrunnlagOrdiner) egenopptjentUforetrygd.getBeregningsgrunnlagOrdiner()));
            } else if (egenopptjentUforetrygd.getBeregningsgrunnlagOrdiner() instanceof BeregningsgrunnlagKonvertert) {
                setBeregningsgrunnlagOrdiner(new BeregningsgrunnlagKonvertert((BeregningsgrunnlagKonvertert) egenopptjentUforetrygd.getBeregningsgrunnlagOrdiner()));
            }
        }
        if (egenopptjentUforetrygd.getBeregningsgrunnlagYrkesskade() != null) {
            if (egenopptjentUforetrygd.getBeregningsgrunnlagYrkesskade() instanceof BeregningsgrunnlagYrkesskade) {
                setBeregningsgrunnlagYrkesskade(new BeregningsgrunnlagYrkesskade((BeregningsgrunnlagYrkesskade) egenopptjentUforetrygd.getBeregningsgrunnlagYrkesskade()));
            } else if (egenopptjentUforetrygd.getBeregningsgrunnlagYrkesskade() instanceof BeregningsgrunnlagKonvertert) {
                setBeregningsgrunnlagYrkesskade(new BeregningsgrunnlagKonvertert((BeregningsgrunnlagKonvertert) egenopptjentUforetrygd.getBeregningsgrunnlagYrkesskade()));
            }
        }
        if (egenopptjentUforetrygd.anvendtTrygdetid != null){
            anvendtTrygdetid = new AnvendtTrygdetid(egenopptjentUforetrygd.anvendtTrygdetid);
        }
    }

    public AbstraktBeregningsgrunnlag getBeregningsgrunnlagOrdiner() {
        return beregningsgrunnlagOrdiner;
    }

    public void setBeregningsgrunnlagOrdiner(AbstraktBeregningsgrunnlag aBeregningsgrunnlag) {
        if (aBeregningsgrunnlag instanceof BeregningsgrunnlagOrdiner
                || aBeregningsgrunnlag instanceof BeregningsgrunnlagKonvertert) {
            this.beregningsgrunnlagOrdiner = aBeregningsgrunnlag;
        }
    }

    public AbstraktBeregningsgrunnlag getBeregningsgrunnlagYrkesskade() {
        return beregningsgrunnlagYrkesskade;
    }

    public void setBeregningsgrunnlagYrkesskade(AbstraktBeregningsgrunnlag aBeregningsgrunnlag) {
        if (aBeregningsgrunnlag instanceof BeregningsgrunnlagYrkesskade
                || aBeregningsgrunnlag instanceof BeregningsgrunnlagKonvertert) {
            this.beregningsgrunnlagYrkesskade = aBeregningsgrunnlag;
        }
    }

    public double getFaktor() {
        return faktor;
    }

    public void setFaktor(double faktor) {
        this.faktor = faktor;
    }

    public FormelKodeCti getFormelKode() {
        return formelKode;
    }

    public void setFormelKode(FormelKodeCti formelKode) {
        this.formelKode = formelKode;
    }

    public int getArsbelop() {
        return arsbelop;
    }

    public void setArsbelop(int arsbelop) {
        this.arsbelop = arsbelop;
    }

    public boolean isBeregningsgrunnlagYrkesskadeBest() {
        return beregningsgrunnlagYrkesskadeBest;
    }

    public void setBeregningsgrunnlagYrkesskadeBest(boolean beregningsgrunnlagYrkesskadeBest) {
        this.beregningsgrunnlagYrkesskadeBest = beregningsgrunnlagYrkesskadeBest;
    }

    public AnvendtTrygdetid getAnvendtTrygdetid() {
        return anvendtTrygdetid;
    }

    public void setAnvendtTrygdetid(AnvendtTrygdetid anvendtTrygdetid) {
        this.anvendtTrygdetid = anvendtTrygdetid;
    }

    public int getKonverteringsPaslagForRedGP() {
        return konverteringsPaslagForRedGP;
    }

    public void setKonverteringsPaslagForRedGP(int konverteringsPaslagForRedGP) {
        this.konverteringsPaslagForRedGP = konverteringsPaslagForRedGP;
    }

    public int getKonverteringsPaslagForRedGPSats() {
        return konverteringsPaslagForRedGPSats;
    }

    public void setKonverteringsPaslagForRedGPSats(int konverteringsPaslagForRedGPSats) {
        this.konverteringsPaslagForRedGPSats = konverteringsPaslagForRedGPSats;
    }
}
