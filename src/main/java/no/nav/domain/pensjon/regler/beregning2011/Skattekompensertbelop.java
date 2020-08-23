package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.GuiPrompt;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;

import java.io.Serializable;

/**
 * @author Aasmund Nordstoga (Accenture) PK-5549
 */
public class Skattekompensertbelop implements Serializable {

    private static final long serialVersionUID = 6675803833673448538L;

    @GuiPrompt(prompt = "Faktor")
    private double faktor;

    @GuiPrompt(prompt = "Formel")
    private FormelKodeCti formelKode;

    @GuiPrompt(prompt = "Årsbeløp")
    private double arsbelop;

    private Justertbelop justertbelop;

    @GuiPrompt(prompt = "Tillegg")
    private double tillegg;

    public Skattekompensertbelop() {
        super();
    }

    public Skattekompensertbelop(Skattekompensertbelop skattekompensertbelop) {
        this.faktor = skattekompensertbelop.faktor;
        if (skattekompensertbelop.formelKode != null) {
            this.formelKode = new FormelKodeCti(skattekompensertbelop.formelKode);
        }
        this.arsbelop = skattekompensertbelop.arsbelop;
        if (skattekompensertbelop.justertbelop != null){
            this.justertbelop = new Justertbelop(skattekompensertbelop.justertbelop);
        }
        this.tillegg = skattekompensertbelop.tillegg;
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

    public double getArsbelop() {
        return arsbelop;
    }

    public void setArsbelop(double arsbelop) {
        this.arsbelop = arsbelop;
    }

    public Justertbelop getJustertbelop() {
        return justertbelop;
    }

    public void setJustertbelop(Justertbelop justertbelop) {
        this.justertbelop = justertbelop;
    }

    public double getTillegg() {
        return tillegg;
    }

    public void setTillegg(double tillegg) {
        this.tillegg = tillegg;
    }
}
