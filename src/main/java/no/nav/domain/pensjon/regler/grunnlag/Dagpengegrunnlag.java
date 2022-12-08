package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.DagpengeTypeCti;

import java.io.Serializable;

public class Dagpengegrunnlag implements Serializable {


    private int ar;
    private DagpengeTypeCti dagpengeType;
    private int uavkortetDagpengegrunnlag;
    private int utbetalteDagpenger;
    private int ferietillegg;
    private int barnetillegg;

    public Dagpengegrunnlag() {
        super();
    }

    public Dagpengegrunnlag(Dagpengegrunnlag d) {
        super();
        ar = d.ar;
        if (d.dagpengeType != null) {
            dagpengeType = new DagpengeTypeCti(d.dagpengeType);
        }
        uavkortetDagpengegrunnlag = d.uavkortetDagpengegrunnlag;
        utbetalteDagpenger = d.utbetalteDagpenger;
        ferietillegg = d.ferietillegg;
        barnetillegg = d.barnetillegg;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public DagpengeTypeCti getDagpengeType() {
        return dagpengeType;
    }

    public void setDagpengeType(DagpengeTypeCti dagpengeType) {
        this.dagpengeType = dagpengeType;
    }

    public int getUavkortetDagpengegrunnlag() {
        return uavkortetDagpengegrunnlag;
    }

    public void setUavkortetDagpengegrunnlag(int uavkortetDagpengegrunnlag) {
        this.uavkortetDagpengegrunnlag = uavkortetDagpengegrunnlag;
    }

    public int getUtbetalteDagpenger() {
        return utbetalteDagpenger;
    }

    public void setUtbetalteDagpenger(int utbetalteDagpenger) {
        this.utbetalteDagpenger = utbetalteDagpenger;
    }

    public int getFerietillegg() {
        return ferietillegg;
    }

    public void setFerietillegg(int ferietillegg) {
        this.ferietillegg = ferietillegg;
    }

    public int getBarnetillegg() {
        return barnetillegg;
    }

    public void setBarnetillegg(int barnetillegg) {
        this.barnetillegg = barnetillegg;
    }

}
