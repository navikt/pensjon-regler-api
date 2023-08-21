package no.nav.pensjon.regler.domain.grunnlag;

import java.io.Serializable;

public class Delingstall implements Serializable, Comparable<Delingstall> {
    private static final long serialVersionUID = 5262268261836476326L;
    /**
     * �rskull delingstallet gjelder for. Eks. 1964.
     */
    private long arskull;
    /**
     * Alder for det gitte �rskullet
     */
    private long alder;
    /*
     * Angir m�ned i �ret. 0 = januar, 11 = desember
     */
    private long maned;
    /**
     * Det gitte delingstall for et �rskull, p� en gitt alder, i en gitt m�ned.
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
     * Comparator - for � kunne sortere p� �rskull, lavest f�rst.
     */
    @Override
    public int compareTo(Delingstall o) {
        Delingstall p = o;
        return Double.compare(arskull, p.arskull);
    }
}
