package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.Merknad;
import no.nav.pensjon.regler.domain.beregning.Sluttpoengtall;

import java.util.List;

public interface IBeregningsInformasjon2011 extends IBeregningsInformasjon {

    public abstract boolean isAvdodesTilleggspensjonBrukt();

    public abstract void setAvdodesTilleggspensjonBrukt(boolean avdodesTilleggspensjonBrukt);

    public abstract boolean isAvdodesTrygdetidBrukt();

    public abstract void setAvdodesTrygdetidBrukt(boolean avdodesTrygdetidBrukt);

    public abstract double getForholdstall67();

    public abstract void setForholdstall67(double forholdstall67);

    public abstract double getForholdstallUttak();

    public abstract void setForholdstallUttak(double forholdstallUttak);

    public abstract boolean isGjenlevenderettAnvendt();

    public abstract void setGjenlevenderettAnvendt(boolean gjenlevenderettAnvendt);

    public abstract List<Merknad> getGpAvkortingsArsakList();

    public abstract void setGpAvkortingsArsakList(List<Merknad> gpAvkortingsArsakList);

    public abstract boolean isGrunnpensjonAvkortet();

    public abstract void setGrunnpensjonAvkortet(boolean grunnpensjonAvkortet);

    public abstract boolean isMottarMinstePensjonsniva();

    public abstract void setMottarMinstePensjonsniva(boolean mottarMinstePensjonsniva);

    public abstract String getMinstepensjonArsak();

    public abstract void setMinstepensjonArsak(String minstepensjonArsak);

    public abstract Sluttpoengtall getOpt();

    public abstract void setOpt(Sluttpoengtall opt);

    public abstract boolean isRettPaGjenlevenderett();

    public abstract void setRettPaGjenlevenderett(boolean rettPaGjenlevenderett);

    public abstract Sluttpoengtall getSpt();

    public abstract void setSpt(Sluttpoengtall spt);

    public abstract boolean isUngUfor();

    public abstract void setUngUfor(boolean ungUfor);

    public abstract boolean isUngUforAnvendt();

    public abstract void setUngUforAnvendt(boolean ungUforAnvendt);

    public abstract Sluttpoengtall getYpt();

    public abstract void setYpt(Sluttpoengtall ypt);

    public abstract boolean isYrkesskadeAnvendt();

    public abstract void setYrkesskadeAnvendt(boolean yrkesskadeAnvendt);

    public abstract int getYrkesskadegrad();

    public abstract void setYrkesskadegrad(int yrkesskadegrad);

    public abstract boolean isYrkesskadeRegistrert();

    public abstract void setYrkesskadeRegistrert(boolean yrkesskadeRegistrert);

}
