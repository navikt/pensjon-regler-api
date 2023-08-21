package no.nav.pensjon.regler.domain.grunnlag;

import java.io.Serializable;

public class Delingstall implements Serializable, Comparable<Delingstall> {
    private static final long serialVersionUID = 5262268261836476326L;
    /**
     * Årskull delingstallet gjelder for. Eks. 1964.
     */
    private long arskull;
    /**
     * Alder for det gitte årskullet
     */
    private long alder;
    /*
     * Angir måned i året. 0 = januar, 11 = desember
     */
    private long maned;
    /**
     * Det gitte delingstall for et årskull, på en gitt alder, i en gitt måned.
     */
    private double delingstall;

    public Delingstall() {
        super();
    }

    public Delingstall(long arskull, long alder, long maned, double delingstall) {
        this();
        this.arskull = arskull;
        this.alder = alder;
        this.maned = maned;
        this.delingstall = delingstall;
    }

    public Delingstall(Delingstall f) {
        arskull = f.arskull;
        alder = f.alder;
        maned = f.maned;
        delingstall = f.delingstall;
    }

    public long getAlder() {
        return alder;
    }

    public void setAlder(long alder) {
        this.alder = alder;
    }

    public long getArskull() {
        return arskull;
    }

    public void setArskull(long arskull) {
        this.arskull = arskull;
    }

    public double getDelingstall() {
        return delingstall;
    }

    public void setDelingstall(double delingstall) {
        this.delingstall = delingstall;
    }

    public long getManed() {
        return maned;
    }

    public void setManed(long maned) {
        this.maned = maned;
    }

    /**
     * Comparator - for å kunne sortere på årskull, lavest først.
     */
    @Override
    public int compareTo(Delingstall o) {
        Delingstall p = o;
        return Double.compare(arskull, p.arskull);
    }
}
