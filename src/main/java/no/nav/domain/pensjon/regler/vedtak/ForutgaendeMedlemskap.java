package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.grunnlag.Unntak;

/**
 * @author Magnus Bakken (Accenture), PK-9695, PKYPTON-923
 * @author Steinar Hjellvik Decisive,  PK-6559
 */
public class ForutgaendeMedlemskap extends AbstraktVilkar {

    
    /**
     * Minst tre �rs forutg�ende medlemskap i Norge med uf�retidspunkt FOM 01.01.1994
     */
    private Boolean minstTreArsFMNorge;

    /**
     * Minst fem �rs forutg�ende medlemskap i Norge med uf�retidspunkt FOM 01.01.1994 (regelpr�vd ved f�rsteKravFremsattDato fom 01.01.2021)
     */
    private Boolean minstFemArsFMNorge;

    /**
     * Avd�de har minst ett �rs forutg�ende medlemskap i Norge med d�dsdato f�r 01.01.1994 og virkningsdato FOM 01.01.1990
     */
    private Boolean minstEttArFMNorge;

    /**
     * Unntak fra forutg�ende medlemskap
     */
    private Unntak unntakFraForutgaendeMedlemskap;

    /**
     * Unntak fra forutg�ende trygdetid
     */
    private Unntak unntakFraForutgaendeTT;

    /**
     * Oppfylt etter gamle regler og virkningsdato f�r 01.01.1990
     */
    private Boolean oppfyltEtterGamleRegler;

    public ForutgaendeMedlemskap() {
    }

    public ForutgaendeMedlemskap(ForutgaendeMedlemskap aForutgaendeMedlemskap) {
        super(aForutgaendeMedlemskap);
        if (aForutgaendeMedlemskap.minstTreArsFMNorge != null){
            minstTreArsFMNorge = new Boolean(aForutgaendeMedlemskap.minstTreArsFMNorge);
        }
        if (aForutgaendeMedlemskap.minstEttArFMNorge != null){
            minstEttArFMNorge = new Boolean(aForutgaendeMedlemskap.minstEttArFMNorge);
        }
        if (aForutgaendeMedlemskap.oppfyltEtterGamleRegler != null){
            oppfyltEtterGamleRegler = new Boolean(aForutgaendeMedlemskap.oppfyltEtterGamleRegler);
        }
        if (aForutgaendeMedlemskap.unntakFraForutgaendeMedlemskap != null){
            unntakFraForutgaendeMedlemskap = new Unntak(aForutgaendeMedlemskap.unntakFraForutgaendeMedlemskap);
        }
        if (aForutgaendeMedlemskap.unntakFraForutgaendeTT != null){
            unntakFraForutgaendeMedlemskap = new Unntak(aForutgaendeMedlemskap.unntakFraForutgaendeTT);
        }
    }

    public Boolean getMinstTreArsFMNorge() {
        return minstTreArsFMNorge;
    }

    public Boolean getMinstFemArsFMNorge() {
        return minstFemArsFMNorge;
    }

    public void setMinstFemArsFMNorge(Boolean minstFemArsFMNorge) {
        this.minstFemArsFMNorge = minstFemArsFMNorge;
    }

    public void setMinstTreArsFMNorge(Boolean minstTreArsFMNorge) {
        this.minstTreArsFMNorge = minstTreArsFMNorge;
    }

    public Boolean getMinstEttArFMNorge() {
        return minstEttArFMNorge;
    }

    public void setMinstEttArFMNorge(Boolean minstEttArFMNorge) {
        this.minstEttArFMNorge = minstEttArFMNorge;
    }

    public Unntak getUnntakFraForutgaendeMedlemskap() {
        return unntakFraForutgaendeMedlemskap;
    }

    public void setUnntakFraForutgaendeMedlemskap(Unntak unntakFraForutgaendeMedlemskap) {
        this.unntakFraForutgaendeMedlemskap = unntakFraForutgaendeMedlemskap;
    }

    public Boolean getOppfyltEtterGamleRegler() {
        return oppfyltEtterGamleRegler;
    }

    public void setOppfyltEtterGamleRegler(Boolean oppfyltEtterGamleRegler) {
        this.oppfyltEtterGamleRegler = oppfyltEtterGamleRegler;
    }

    public Unntak getUnntakFraForutgaendeTT() {
        return unntakFraForutgaendeTT;
    }

    public void setUnntakFraForutgaendeTT(Unntak unntakFraForutgaendeTT) {
        this.unntakFraForutgaendeTT = unntakFraForutgaendeTT;
    }

    public AbstraktVilkar dypKopi(AbstraktVilkar abs) {
        ForutgaendeMedlemskap fm = null;
        if(abs.getClass() == ForutgaendeMedlemskap.class) {
            fm = new ForutgaendeMedlemskap((ForutgaendeMedlemskap) abs);
        }
        return fm;
    }
}
