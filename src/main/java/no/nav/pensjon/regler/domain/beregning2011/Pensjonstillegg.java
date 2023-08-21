package no.nav.pensjon.regler.domain.beregning2011;


import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.MinstepenNivaCti;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

public class Pensjonstillegg extends Ytelseskomponent {
    private static final long serialVersionUID = 488266051026387363L;


    protected double forholdstall67 = 0.0;


    protected double minstepensjonsnivaSats;


    protected MinstepenNivaCti minstepensjonsnivaSatsType;


    protected JustertMinstePensjonsniva justertMinstePensjonsniva;

    public Pensjonstillegg() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("PT");
        setFormelKode(new FormelKodeCti("PenTx"));
    }

    public Pensjonstillegg(Pensjonstillegg pt) {
        super(pt);

        forholdstall67 = pt.forholdstall67;
        minstepensjonsnivaSats = pt.minstepensjonsnivaSats;
        if (pt.minstepensjonsnivaSatsType != null) {
            minstepensjonsnivaSatsType = new MinstepenNivaCti(pt.minstepensjonsnivaSatsType);
        }
        if (pt.justertMinstePensjonsniva != null) {
            justertMinstePensjonsniva = new JustertMinstePensjonsniva(pt.justertMinstePensjonsniva);
        }
    }

    public double getForholdstall67() {
        return forholdstall67;
    }

    public void setForholdstall67(double forholdstall67) {
        this.forholdstall67 = forholdstall67;
    }

    public JustertMinstePensjonsniva getJustertMinstePensjonsniva() {
        return justertMinstePensjonsniva;
    }

    public void setJustertMinstePensjonsniva(JustertMinstePensjonsniva justertMinstePensjonsniva) {
        this.justertMinstePensjonsniva = justertMinstePensjonsniva;
    }

    public double getMinstepensjonsnivaSats() {
        return minstepensjonsnivaSats;
    }

    public void setMinstepensjonsnivaSats(double minstepensjonsnivaSats) {
        this.minstepensjonsnivaSats = minstepensjonsnivaSats;
    }

    public MinstepenNivaCti getMinstepensjonsnivaSatsType() {
        return minstepensjonsnivaSatsType;
    }

    public void setMinstepensjonsnivaSatsType(MinstepenNivaCti minstepensjonsnivaSatsType) {
        this.minstepensjonsnivaSatsType = minstepensjonsnivaSatsType;
    }

}
