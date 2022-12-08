package no.nav.domain.pensjon.regler.grunnlag;

import java.io.Serializable;

public class Forholdstall implements Serializable, Comparable<Forholdstall> {
    
    /**
     * Årskull forholdstallet gjelder for. Eks. 1964.
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
     * Det gitte forhodstall for et årskull, på en gitt alder, i en gitt måned.
     */
    private double forholdstall;

    public Forholdstall(long arskull, long alder, long maned, double forholdstall) {
        super();
        this.arskull = arskull;
        this.alder = alder;
        this.maned = maned;
        this.forholdstall = forholdstall;
    }

    public Forholdstall() {
        super();
    }

    public Forholdstall(Forholdstall f) {
        arskull = f.arskull;
        alder = f.alder;
        maned = f.maned;
        forholdstall = f.forholdstall;
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

    public double getForholdstall() {
        return forholdstall;
    }

    public void setForholdstall(double forholdstall) {
        this.forholdstall = forholdstall;
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
    public int compareTo(Forholdstall o) {
        Forholdstall p = o;
        return Double.compare(arskull, p.arskull);
    }
}
