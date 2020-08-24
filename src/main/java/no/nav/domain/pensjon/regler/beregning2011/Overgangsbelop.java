package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;

import java.io.Serializable;

/**
 * @author Aasmund Nordstoga (Accenture) PK-5549
 */
public class Overgangsbelop implements Serializable {

    private static final long serialVersionUID = 2894452390016921661L;

    @GuiPrompt(prompt = "Formel")
    private FormelKodeCti formelKode;

    @GuiPrompt(prompt = "Grunnpensjon brutto")
    private int gpBrutto;

    @GuiPrompt(prompt = "Grunnpensjon sats")
    private double gpSats;

    @GuiPrompt(prompt = "Overgangsbeløp")
    private double overgangsbelop;

    @GuiPrompt(prompt = "Særtillegg brutto")
    private int stBrutto;

    @GuiPrompt(prompt = "Tilleggspensjon brutto")
    private int tpBrutto;

    public Overgangsbelop() {
        super();
    }

    public Overgangsbelop(Overgangsbelop overgangsbelop) {
        if (overgangsbelop.formelKode != null) {
            this.formelKode = new FormelKodeCti(overgangsbelop.formelKode);
        }
        this.gpBrutto = overgangsbelop.gpBrutto;
        this.gpSats = overgangsbelop.gpSats;
        this.overgangsbelop = overgangsbelop.overgangsbelop;
        this.stBrutto = overgangsbelop.stBrutto;
        this.tpBrutto = overgangsbelop.tpBrutto;
    }

    public FormelKodeCti getFormelKode() {
        return formelKode;
    }

    public void setFormelKode(FormelKodeCti formelKode) {
        this.formelKode = formelKode;
    }

    public int getGpBrutto() {
        return gpBrutto;
    }

    public void setGpBrutto(int gpBrutto) {
        this.gpBrutto = gpBrutto;
    }

    public double getGpSats() {
        return gpSats;
    }

    public void setGpSats(double gpSats) {
        this.gpSats = gpSats;
    }

    public double getOvergangsbelop() {
        return overgangsbelop;
    }

    public void setOvergangsbelop(double overgangsbelop) {
        this.overgangsbelop = overgangsbelop;
    }

    public int getStBrutto() {
        return stBrutto;
    }

    public void setStBrutto(int stBrutto) {
        this.stBrutto = stBrutto;
    }

    public int getTpBrutto() {
        return tpBrutto;
    }

    public void setTpBrutto(int tpBrutto) {
        this.tpBrutto = tpBrutto;
    }
}
