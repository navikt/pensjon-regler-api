package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegulerBeregningGrunnlag implements Serializable {
    private static final long serialVersionUID = 7659959862387049529L;

    private Beregning beregning1967;
    private Date virkFom;
    private List<Uttaksgrad> uttaksgradListe = new ArrayList<Uttaksgrad>();
    private List<VilkarsVedtak> brukersVilkarsvedtakListe = new ArrayList<VilkarsVedtak>();
    private Persongrunnlag sokersPersongrunnlag;
    private Persongrunnlag epsPersongrunnlag;
    private Pakkseddel pakkseddel;

    public RegulerBeregningGrunnlag() {
        super();
    }

    public RegulerBeregningGrunnlag(RegulerBeregningGrunnlag g) {
        if (g.beregning1967 != null) {
            beregning1967 = new Beregning(g.beregning1967);
        }
        if (g.virkFom != null) {
            virkFom = (Date) g.virkFom.clone();
        }
        if (g.uttaksgradListe.size() > 0) {
            for (Uttaksgrad u : g.uttaksgradListe) {
                uttaksgradListe.add(new Uttaksgrad(u));
            }
        }
        if (g.brukersVilkarsvedtakListe.size() > 0) {
            for (VilkarsVedtak v : g.brukersVilkarsvedtakListe) {
                brukersVilkarsvedtakListe.add(new VilkarsVedtak(v));
            }
        }
        if (g.sokersPersongrunnlag != null) {
            sokersPersongrunnlag = new Persongrunnlag(g.sokersPersongrunnlag);
        }
        if (g.epsPersongrunnlag != null) {
            epsPersongrunnlag = new Persongrunnlag(g.epsPersongrunnlag);
        }
        if (g.pakkseddel != null) {
            pakkseddel = new Pakkseddel(g.pakkseddel);
        }
    }

    public Beregning getBeregning1967() {
        return beregning1967;
    }

    public void setBeregning1967(Beregning beregning1967) {
        this.beregning1967 = beregning1967;
    }

    public Date getVirkFom() {
        return virkFom;
    }

    public void setVirkFom(Date virkFom) {
        this.virkFom = virkFom;
    }

    public List<Uttaksgrad> getUttaksgradListe() {
        return uttaksgradListe;
    }

    public void setUttaksgradListe(List<Uttaksgrad> uttaksgradListe) {
        this.uttaksgradListe = uttaksgradListe;
    }

    public Uttaksgrad[] getuttaksgradListeAsArray() {
        return uttaksgradListe != null ? uttaksgradListe.toArray(new Uttaksgrad[uttaksgradListe.size()]) : new Uttaksgrad[0];
    }

    public List<VilkarsVedtak> getBrukersVilkarsvedtakListe() {
        return brukersVilkarsvedtakListe;
    }

    public void setBrukersVilkarsvedtakListe(List<VilkarsVedtak> brukersVilkarsvedtakListe) {
        this.brukersVilkarsvedtakListe = brukersVilkarsvedtakListe;
    }

    public VilkarsVedtak[] getbrukersVilkarsvedtakListeAsArray() {
        return brukersVilkarsvedtakListe != null ? brukersVilkarsvedtakListe.toArray(new VilkarsVedtak[brukersVilkarsvedtakListe.size()]) : new VilkarsVedtak[0];
    }

    public Persongrunnlag getSokersPersongrunnlag() {
        return sokersPersongrunnlag;
    }

    public void setSokersPersongrunnlag(Persongrunnlag sokersPersongrunnlag) {
        this.sokersPersongrunnlag = sokersPersongrunnlag;
    }

    public Persongrunnlag getEpsPersongrunnlag() {
        return epsPersongrunnlag;
    }

    public void setEpsPersongrunnlag(Persongrunnlag epsPersongrunnlag) {
        this.epsPersongrunnlag = epsPersongrunnlag;
    }

    public Pakkseddel getPakkseddel() {
        return pakkseddel;
    }

    public void setPakkseddel(Pakkseddel pakkseddel) {
        this.pakkseddel = pakkseddel;
    }

}
