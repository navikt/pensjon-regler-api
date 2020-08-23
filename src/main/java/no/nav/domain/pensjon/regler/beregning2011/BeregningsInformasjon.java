package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.beregning.Sluttpoengtall;
import no.nav.domain.pensjon.regler.kode.BeregningMetodeTypeCti;
import no.nav.domain.pensjon.regler.kode.JustertPeriodeCti;
import no.nav.domain.pensjon.regler.kode.LandCti;
import no.nav.domain.pensjon.regler.kode.ResultatTypeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeregningsInformasjon implements Serializable, IBeregningsInformasjon2011 {
    private static final long serialVersionUID = -5784632399698617450L;

    //Fra IBeregningsInformasjon2011
    private double forholdstallUttak;
    private double forholdstall67;
    private double delingstallUttak;
    private double delingstall67;
    private Sluttpoengtall spt;
    private Sluttpoengtall opt;
    private Sluttpoengtall ypt;
    private boolean grunnpensjonAvkortet = false;
    private List<Merknad> gpAvkortingsArsakList = new ArrayList<Merknad>();
    private boolean mottarMinstePensjonsniva;
    private String minstepensjonArsak;
    private boolean rettPaGjenlevenderett;
    private boolean gjenlevenderettAnvendt;
    private boolean avdodesTilleggspensjonBrukt;
    private boolean avdodesTrygdetidBrukt;
    private boolean ungUfor;
    private boolean ungUforAnvendt;
    private boolean yrkesskadeRegistrert;
    private boolean yrkesskadeAnvendt;
    private int yrkesskadegrad;

    // Fra IBeregningsInformasjon
    private PenPerson penPerson;
    private BeregningMetodeTypeCti beregningsMetode;
    private boolean eksport;
    private ResultatTypeCti resultatType;
    private List<TapendeBeregningsmetode> tapendeBeregningsmetodeListe = new ArrayList<TapendeBeregningsmetode>();
    private Integer trygdetid;
    private int tt_anv;
    private LandCti vurdertBosattland;
    private boolean ensligPensjonInstOpph;
    private JustertPeriodeCti instOppholdType;
    private boolean instOpphAnvendt;
    // Avdødes tilleggspensjon
    private double tp;
    private int ttBeregnetForGrunnlagsrolle;

    private boolean ungUforGarantiFrafalt;

    public BeregningsInformasjon() {
        super();
    }

    /**
     * Copy Constructor
     */
    public BeregningsInformasjon(BeregningsInformasjon bi) {
        this();
        if (bi.penPerson != null) {
            penPerson = new PenPerson(bi.penPerson);
        }
        if (bi.resultatType != null) {
            resultatType = new ResultatTypeCti(bi.resultatType);
        }
        if (bi.beregningsMetode != null) {
            beregningsMetode = new BeregningMetodeTypeCti(bi.beregningsMetode);
        }
        if (bi.tapendeBeregningsmetodeListe != null) {
            for (TapendeBeregningsmetode m : bi.tapendeBeregningsmetodeListe) {
                tapendeBeregningsmetodeListe.add(new TapendeBeregningsmetode(m));
            }
        }
        tt_anv = bi.tt_anv;
        if (bi.trygdetid != null) {
            trygdetid = bi.trygdetid;
        }
        delingstall67 = bi.delingstall67;
        delingstallUttak = bi.delingstallUttak;
        ensligPensjonInstOpph = bi.ensligPensjonInstOpph;
        instOppholdType = bi.instOppholdType;
        if (bi.instOppholdType != null) {
            instOppholdType = new JustertPeriodeCti(bi.instOppholdType);
        }
        instOpphAnvendt = bi.instOpphAnvendt;
        vurdertBosattland = bi.vurdertBosattland;

        forholdstall67 = bi.forholdstall67;
        forholdstallUttak = bi.forholdstallUttak;
        mottarMinstePensjonsniva = bi.mottarMinstePensjonsniva;
        minstepensjonArsak = bi.minstepensjonArsak;
        if (bi.spt != null) {
            spt = new Sluttpoengtall(bi.spt);
        }
        if (bi.opt != null) {
            opt = new Sluttpoengtall(bi.opt);
        }
        if (bi.ypt != null) {
            ypt = new Sluttpoengtall(bi.ypt);
        }
        grunnpensjonAvkortet = bi.grunnpensjonAvkortet;
        if (bi.gpAvkortingsArsakList != null) {
            for (Merknad m : bi.gpAvkortingsArsakList) {
                gpAvkortingsArsakList.add(new Merknad(m));
            }
        }
        rettPaGjenlevenderett = bi.rettPaGjenlevenderett;
        gjenlevenderettAnvendt = bi.gjenlevenderettAnvendt;
        avdodesTilleggspensjonBrukt = bi.avdodesTilleggspensjonBrukt;
        avdodesTrygdetidBrukt = bi.avdodesTrygdetidBrukt;
        ungUfor = bi.ungUfor;
        ungUforAnvendt = bi.ungUforAnvendt;
        yrkesskadeRegistrert = bi.yrkesskadeRegistrert;
        yrkesskadeAnvendt = bi.yrkesskadeAnvendt;
        yrkesskadegrad = bi.yrkesskadegrad;
        ttBeregnetForGrunnlagsrolle = bi.ttBeregnetForGrunnlagsrolle;
        ungUforGarantiFrafalt = bi.ungUforGarantiFrafalt;
        eksport = bi.eksport;
    }

    @Override
    public PenPerson getPenPerson() {
        return penPerson;
    }

    @Override
    public void setPenPerson(PenPerson penPerson) {
        this.penPerson = penPerson;
    }

    @Override
    public boolean isAvdodesTilleggspensjonBrukt() {
        return avdodesTilleggspensjonBrukt;
    }

    @Override
    public void setAvdodesTilleggspensjonBrukt(boolean avdodesTilleggspensjonBrukt) {
        this.avdodesTilleggspensjonBrukt = avdodesTilleggspensjonBrukt;
    }

    @Override
    public boolean isAvdodesTrygdetidBrukt() {
        return avdodesTrygdetidBrukt;
    }

    @Override
    public void setAvdodesTrygdetidBrukt(boolean avdodesTrygdetidBrukt) {
        this.avdodesTrygdetidBrukt = avdodesTrygdetidBrukt;
    }

    @Override
    public double getForholdstall67() {
        return forholdstall67;
    }

    @Override
    public void setForholdstall67(double forholdstall67) {
        this.forholdstall67 = forholdstall67;
    }

    @Override
    public double getForholdstallUttak() {
        return forholdstallUttak;
    }

    @Override
    public void setForholdstallUttak(double forholdstallUttak) {
        this.forholdstallUttak = forholdstallUttak;
    }

    @Override
    public boolean isGjenlevenderettAnvendt() {
        return gjenlevenderettAnvendt;
    }

    @Override
    public void setGjenlevenderettAnvendt(boolean gjenlevenderettAnvendt) {
        this.gjenlevenderettAnvendt = gjenlevenderettAnvendt;
    }

    @Override
    public List<Merknad> getGpAvkortingsArsakList() {
        return gpAvkortingsArsakList;
    }

    @Override
    public void setGpAvkortingsArsakList(List<Merknad> gpAvkortingsArsakList) {
        this.gpAvkortingsArsakList = gpAvkortingsArsakList;
    }

    @Override
    public boolean isGrunnpensjonAvkortet() {
        return grunnpensjonAvkortet;
    }

    @Override
    public void setGrunnpensjonAvkortet(boolean grunnpensjonAvkortet) {
        this.grunnpensjonAvkortet = grunnpensjonAvkortet;
    }

    @Override
    public boolean isMottarMinstePensjonsniva() {
        return mottarMinstePensjonsniva;
    }

    @Override
    public void setMottarMinstePensjonsniva(boolean mottarMinstePensjonsniva) {
        this.mottarMinstePensjonsniva = mottarMinstePensjonsniva;
    }

    @Override
    public String getMinstepensjonArsak() { return  minstepensjonArsak;  }

    @Override
    public void setMinstepensjonArsak(String minstepensjonArsak){
        this.minstepensjonArsak = minstepensjonArsak;
    }

    @Override
    public Sluttpoengtall getOpt() {
        return opt;
    }

    @Override
    public void setOpt(Sluttpoengtall opt) {
        this.opt = opt;
    }

    @Override
    public boolean isRettPaGjenlevenderett() {
        return rettPaGjenlevenderett;
    }

    @Override
    public void setRettPaGjenlevenderett(boolean rettPaGjenlevenderett) {
        this.rettPaGjenlevenderett = rettPaGjenlevenderett;
    }

    @Override
    public Sluttpoengtall getSpt() {
        return spt;
    }

    @Override
    public void setSpt(Sluttpoengtall spt) {
        this.spt = spt;
    }

    @Override
    public boolean isUngUfor() {
        return ungUfor;
    }

    @Override
    public void setUngUfor(boolean ungUfor) {
        this.ungUfor = ungUfor;
    }

    @Override
    public boolean isUngUforAnvendt() {
        return ungUforAnvendt;
    }

    @Override
    public void setUngUforAnvendt(boolean ungUforAnvendt) {
        this.ungUforAnvendt = ungUforAnvendt;
    }

    @Override
    public Sluttpoengtall getYpt() {
        return ypt;
    }

    @Override
    public void setYpt(Sluttpoengtall ypt) {
        this.ypt = ypt;
    }

    @Override
    public boolean isYrkesskadeAnvendt() {
        return yrkesskadeAnvendt;
    }

    @Override
    public void setYrkesskadeAnvendt(boolean yrkesskadeAnvendt) {
        this.yrkesskadeAnvendt = yrkesskadeAnvendt;
    }

    @Override
    public int getYrkesskadegrad() {
        return yrkesskadegrad;
    }

    @Override
    public void setYrkesskadegrad(int yrkesskadegrad) {
        this.yrkesskadegrad = yrkesskadegrad;
    }

    @Override
    public boolean isYrkesskadeRegistrert() {
        return yrkesskadeRegistrert;
    }

    @Override
    public void setYrkesskadeRegistrert(boolean yrkesskadeRegistrert) {
        this.yrkesskadeRegistrert = yrkesskadeRegistrert;
    }

    // Fra IBeregningsInformasjon
    @Override
    public BeregningMetodeTypeCti getBeregningsMetode() {
        return beregningsMetode;
    }

    @Override
    public void setBeregningsMetode(BeregningMetodeTypeCti beregningsMetode) {
        this.beregningsMetode = beregningsMetode;
    }

    @Override
    public boolean isEnsligPensjonInstOpph() {
        return ensligPensjonInstOpph;
    }

    @Override
    public void setEnsligPensjonInstOpph(boolean ensligPensjonInstOpph) {
        this.ensligPensjonInstOpph = ensligPensjonInstOpph;
    }

    @Override
    public JustertPeriodeCti getInstOppholdType() {
        return instOppholdType;
    }

    @Override
    public void setInstOppholdType(JustertPeriodeCti instOppholdType) {
        this.instOppholdType = instOppholdType;
    }

    @Override
    public boolean isInstOpphAnvendt() {
        return instOpphAnvendt;
    }

    @Override
    public void setInstOpphAnvendt(boolean instOpphAnvendt) {
        this.instOpphAnvendt = instOpphAnvendt;
    }

    @Override
    public ResultatTypeCti getResultatType() {
        return resultatType;
    }

    @Override
    public void setResultatType(ResultatTypeCti resultatType) {
        this.resultatType = resultatType;
    }

    @Override
    public Integer getTrygdetid() {
        return trygdetid;
    }

    @Override
    public void setTrygdetid(Integer trygdetid) {
        this.trygdetid = trygdetid;
    }

    @Override
    public int getTt_anv() {
        return tt_anv;
    }

    @Override
    public void setTt_anv(int tt_anv) {
        this.tt_anv = tt_anv;
    }

    @Override
    public LandCti getVurdertBosattland() {
        return vurdertBosattland;
    }

    @Override
    public void setVurdertBosattland(LandCti vurdertBosattland) {
        this.vurdertBosattland = vurdertBosattland;
    }

    @Override
    public boolean isEksport() {
        return eksport;
    }

    @Override
    public void setEksport(boolean eksport) {
        this.eksport = eksport;
    }

    public double getDelingstall67() {
        return delingstall67;
    }

    public void setDelingstall67(double delingstall67) {
        this.delingstall67 = delingstall67;
    }

    public double getDelingstallUttak() {
        return delingstallUttak;
    }

    public void setDelingstallUttak(double delingstallUttak) {
        this.delingstallUttak = delingstallUttak;
    }

    public double getTp() {
        return tp;
    }

    public void setTp(double tp) {
        this.tp = tp;
    }

    @Override
    public List<TapendeBeregningsmetode> getTapendeBeregningsmetodeListe() {
        return tapendeBeregningsmetodeListe;
    }

    @Override
    public void setTapendeBeregningsmetodeListe(List<TapendeBeregningsmetode> tapendeBeregningsmetodeListe) {
        this.tapendeBeregningsmetodeListe = tapendeBeregningsmetodeListe;
    }

    public void setTtBeregnetForGrunnlagsrolle(int ttBeregnetForGrunnlagsrolle) {
        this.ttBeregnetForGrunnlagsrolle = ttBeregnetForGrunnlagsrolle;
    }

    public int getTtBeregnetForGrunnlagsrolle() {
        return ttBeregnetForGrunnlagsrolle;
    }

    public boolean isUngUforGarantiFrafalt() {
        return ungUforGarantiFrafalt;
    }

    public void setUngUforGarantiFrafalt(boolean ungUforGarantiFrafalt) {
        this.ungUforGarantiFrafalt = ungUforGarantiFrafalt;
    }
}
