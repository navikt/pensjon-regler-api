package no.nav.domain.pensjon.regler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import no.nav.domain.pensjon.regler.grunnlag.AntallArMndDag;
import no.nav.domain.pensjon.regler.kode.RegelverkTypeCti;
import no.nav.domain.pensjon.regler.kode.TrygdetidGarantiTypeCti;
import no.nav.domain.pensjon.regler.kode.UtfallTypeCti;
import no.nav.domain.pensjon.regler.util.ToStringUtil;

/**
 * Trygdetid - framtidig trygdetid
 *
 * @author Lars Hartvigsen (Decisive), PK-12705
 * @author Lars Hartvigsen (Decisive), PK-5610
 * @author Magnus Bakken (Accenture), PK-18583
 */
public class Trygdetid implements Serializable {

    private static final long serialVersionUID = -2390648157600089847L;

    /**
     * Unik id for objektet, brukes ikke av PREG,og blir med ut uforandret.
     */
    private long trygdetidId;

    /**
     * Bestemmer hvilket regelverk objektet gjelder for
     * G_REG - gammelt regelverk
     * N_REG_G_OPPTJ - nytt regelverk, gammel opptjeningsmodell
     * N_REG_G_N_OPPTJ - nytt regelverk, gammel og ny opptjeningsmodell
     * N_REG_N_OPPTJ - nytt regelverk, ny opptjeningsmodell
     */
    @GuiPrompt(prompt = "Regelverktype")
    private RegelverkTypeCti regelverkType;

    /**
     * Samlet trygdetid i antall �r. Vanligvis lik tt_anv i Beregning. Unntaket
     * er n�r antall poeng�r er st�rre. I simulering er dette den eneste
     * trygdetiden som trengs.
     */
    @GuiPrompt(prompt = "Samlet trygdetid i antall �r")
    private int tt;

    /**
     * Framtidig trygdetid i antall m�neder.
     */
    @GuiPrompt(prompt = "Framtidig trygdetid i m�neder")
    private int ftt;

    /**
     * Om framtidig trygdetid er redusert i henhold til 4/5-dels regelen (�3-6
     * tredje ledd).
     */
    @GuiPrompt(prompt = "Redusert framtidig trygdetid")
    private boolean ftt_redusert;

    /**
     * Dato fremtidig trygdetid regnes fra.
     */
    @GuiPrompt(prompt = "Fremtidig trygdetid regnes fra dato")
    private Date ftt_fom;

    /**
     * Faktiske trygdetidsm�neder. Brukes etter E�S og land med bilaterale
     * avtaler. Utgj�r summen av all faktisk trygdetid i Norge og andre E�S-land
     * eller alternativt det landet vi har bilateral avtale med. M�neder.
     */
    @GuiPrompt(prompt = "Faktisk trygdetid i m�neder")
    private int tt_fa_mnd;

    /**
     * Trygdetid i antall �r p� grunnlag av poeng�r i det 67., 68. og 69.
     * leve�ret. Godskrives ved fylte 70 �r.
     */
    @GuiPrompt(prompt = "Trygdetid av poeng i 67. til 69. leve�r")
    private int tt_67_70;

    /**
     * Trygdetid beregnet for poeng�r opptjent fra og med kalender�ret bruker fylte 6 �r
     * til og med kalender�ret bruker fylte 75 �r.
     */
    @GuiPrompt(prompt = "Trygdetid av poeng i 67. til 75. leve�r")
    private int tt_67_75;

    /**
     * Summen av norsk faktisk trygdetid og eventuelle poeng�r opptjent fra �ret fyller 67.
     * Slike poeng�r vil kun legges til summen dersom vilk�r for at de skal kunne telle
     * med er oppfylt. I antall m�neder.
     */
    @GuiPrompt(prompt = "Sum faktisk trygdetid og poeng�r etter fylte 67")
    private int tt_faktisk;

    /**
     * Trygdetid etter 1966 i antall �r.
     */
    @GuiPrompt(prompt = "Trygdetid etter 1966")
    private int tt_E66;

    /**
     * Trygdetid f�r 1967 i antall �r.
     */
    @GuiPrompt(prompt = "Trygdetid f�r 1967")
    private int tt_F67;

    /**
     * Faktisk trygdetid i antall �r, m�neder og dager f�r 2021.
     * Innf�rt ifbm overgangsregler for flyktninger.
     */
    @GuiPrompt(prompt = "Faktisk trygdetid f�r 2021")
    private AntallArMndDag tt_fa_F2021;

    /**
     * Opptjeningstiden er tidsrommet i antall m�neder fra og med m�neden etter
     * fylte 16 �r til og med m�neden f�r st�nadstilfellet inntr�dte. Brukes til
     * � bestemme 4/5-dels krav til faktisk trygdetid (�3-6 tredje ledd).
     */
    @GuiPrompt(prompt = "Opptjeningsperiode")
    private int opptjeningsperiode;

    /**
     * Trygdetid i E�S land unntatt Norge.
     */
    @GuiPrompt(prompt = "Trygdetid i E�S unntatt Norge")
    private TTUtlandEOS ttUtlandEos;

    /**
     * Trygdetid i land tilh�rende Nordisk konvensjon (artikkel 10) unntatt
     * Norge.
     */
    @GuiPrompt(prompt = "Trygdetid i Nordisk konvensjonsland unntatt Norge")
    private TTUtlandKonvensjon ttUtlandKonvensjon;

    /**
     * Trygdetid i land med bilaterale avtaler.
     */
    @GuiPrompt(prompt = "Trygdetid i avtaleland")
    private List<TTUtlandTrygdeavtale> ttUtlandTrygdeavtaler;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;

    @GuiPrompt(prompt = "Trygdetid garantitype")
    private TrygdetidGarantiTypeCti garantiType;

    /**
     * Felt som blir brukt ved proratisering av pensjonsniv� ved
     * vilk�rspr�ving av tidliguttak av AP
     */
    private int prorataTellerVKAP;
    private int prorataNevnerVKAP;

    /**
     * Felt som blir brukt for � holde orden p� n�yaktig antall �r, m�neder og dager trygdetid
     * for � unng� avrundingsfeil p� grunn av dobbel avrunding.
     */
    @GuiPrompt(prompt = "Faktisk trygdetid uavrundet")
    private AntallArMndDag tt_fa;

    /**
     * Trygdetidens virkningsdato fom. Brukes ved fastsettelse av periodisert trygdetid for AP2011/AP2016 og AP2025
     */
    @GuiPrompt(prompt = "Virkningsdato fra og med")
    private Date virkFom;

    /**
     * Trygdetidens virkningsdato tom. Brukes ved fastsettelse av periodisert trygdetid for AP2011/AP2016 og AP2025
     */
    @GuiPrompt(prompt = "Virkningsdato til og med")
    private Date virkTom;

    private UtfallTypeCti anvendtFlyktning;

    /**
     * Copy Constructor
     *
     * @param trygdetid
     * a <code>Trygdetid</code> object
     */
    public Trygdetid(Trygdetid trygdetid) {
        trygdetidId = trygdetid.trygdetidId;
        tt = trygdetid.tt;
        ftt = trygdetid.ftt;
        ftt_redusert = trygdetid.ftt_redusert;
        tt_fa_mnd = trygdetid.tt_fa_mnd;
        tt_67_70 = trygdetid.tt_67_70;
        tt_67_75 = trygdetid.tt_67_75;
        tt_E66 = trygdetid.tt_E66;
        tt_F67 = trygdetid.tt_F67;
        tt_faktisk = trygdetid.tt_faktisk;

        if (trygdetid.getTt_fa_F2021() != null) {
            tt_fa_F2021 = new AntallArMndDag(trygdetid.getTt_fa_F2021());
        }
        if (trygdetid.getFtt_fom() != null) {
            ftt_fom = new Date(trygdetid.getFtt_fom().getTime());
        }
        opptjeningsperiode = trygdetid.opptjeningsperiode;
        if (trygdetid.regelverkType != null) {
            regelverkType = new RegelverkTypeCti(trygdetid.regelverkType);
        }
        if (trygdetid.garantiType != null) {
            garantiType = new TrygdetidGarantiTypeCti(trygdetid.garantiType);
        }
        if (trygdetid.ttUtlandEos != null) {
            ttUtlandEos = new TTUtlandEOS(trygdetid.ttUtlandEos);
        }
        if (trygdetid.ttUtlandKonvensjon != null) {
            ttUtlandKonvensjon = new TTUtlandKonvensjon(trygdetid.ttUtlandKonvensjon);
        }
        ttUtlandTrygdeavtaler = new ArrayList<TTUtlandTrygdeavtale>();
        if (trygdetid.ttUtlandTrygdeavtaler != null) {
            for (TTUtlandTrygdeavtale ta : trygdetid.ttUtlandTrygdeavtaler) {
                ttUtlandTrygdeavtaler.add(new TTUtlandTrygdeavtale(ta));
            }
        }
        merknadListe = new ArrayList<Merknad>();
        if (trygdetid.merknadListe != null) {
            for (Merknad merknad : trygdetid.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
        prorataNevnerVKAP = trygdetid.prorataNevnerVKAP;
        prorataTellerVKAP = trygdetid.prorataTellerVKAP;

        if (trygdetid.getVirkFom() != null) {
            virkFom = new Date(trygdetid.getVirkFom().getTime());
        }

        if (trygdetid.getVirkTom() != null) {
            virkTom = new Date(trygdetid.getVirkTom().getTime());
        }
        if (trygdetid.getTt_fa() != null){
            tt_fa = new AntallArMndDag(trygdetid.getTt_fa());
        }
        if (trygdetid.anvendtFlyktning != null) {
            anvendtFlyktning = new UtfallTypeCti(trygdetid.anvendtFlyktning);
        }
    }

    public Trygdetid(long trygdetidId, int tt, int ftt, boolean ftt_redusert, int tt_etter_UFT, int tt_etter_dod, int tt_overfort, int tt_garanti, int tt_fa_mnd, int tt_67_70,
            int tt_E66, int tt_F67, int opptjeningsperiode, TTUtlandEOS ttUtlandEos, TTUtlandKonvensjon ttUtlandKonvensjon) {
        super();
        this.trygdetidId = trygdetidId;
        this.tt = tt;
        this.ftt = ftt;
        this.ftt_redusert = ftt_redusert;
        this.tt_fa_mnd = tt_fa_mnd;
        this.tt_67_70 = tt_67_70;
        this.tt_E66 = tt_E66;
        this.tt_F67 = tt_F67;
        this.opptjeningsperiode = opptjeningsperiode;
        this.ttUtlandEos = ttUtlandEos;
        this.ttUtlandKonvensjon = ttUtlandKonvensjon;
        merknadListe = new ArrayList<Merknad>();

    }

    public Trygdetid() {
        super();
        ttUtlandTrygdeavtaler = new ArrayList<TTUtlandTrygdeavtale>();
        merknadListe = new ArrayList<Merknad>();
    }

    public int getFtt() {
        return ftt;
    }

    public void setFtt(int ftt) {
        this.ftt = ftt;
    }

    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    public void setMerknadListe(List<Merknad> merknadListe) {
        this.merknadListe = merknadListe;
    }

    public int getTt() {
        return tt;
    }

    public void setTt(int tt) {
        this.tt = tt;
    }

    /**
     * @deprecated
     * @return Returns the merknad as array.
     */
    @Deprecated
    public Merknad[] retrieveMerknadListeAsArray() {
        return merknadListe.toArray(new Merknad[0]);
    }

    /**
     * Read only property for merknadListe.
     *
     * @return array of Merknad
     */
    public Merknad[] getMerknadListeAsArray() {
        return merknadListe != null ? merknadListe.toArray(new Merknad[merknadListe.size()]) : new Merknad[0];
    }

    public boolean isFtt_redusert() {
        return ftt_redusert;
    }

    public void setFtt_redusert(boolean ftt_redusert) {
        this.ftt_redusert = ftt_redusert;
    }

    public Date getFtt_fom() {
        return ftt_fom;
    }

    public void setFtt_fom(Date ftt_fom) {
        this.ftt_fom = ftt_fom;
    }

    /*
     * Generic version. Uses reflection to print field names and values.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public int getOpptjeningsperiode() {
        return opptjeningsperiode;
    }

    public void setOpptjeningsperiode(int opptjeningsperiode) {
        this.opptjeningsperiode = opptjeningsperiode;
    }

    public int getTt_67_70() {
        return tt_67_70;
    }

    public void setTt_67_70(int tt_67_70) {
        this.tt_67_70 = tt_67_70;
    }

    public int getTt_67_75() {
        return tt_67_75;
    }

    public void setTt_67_75(int tt_67_75) {
        this.tt_67_75 = tt_67_75;
    }

    public int getTt_E66() {
        return tt_E66;
    }

    public void setTt_E66(int tt_E66) {
        this.tt_E66 = tt_E66;
    }

    public int getTt_F67() {
        return tt_F67;
    }

    public void setTt_F67(int tt_F67) {
        this.tt_F67 = tt_F67;
    }

    public AntallArMndDag getTt_fa_F2021() {
        return tt_fa_F2021;
    }

    public void setTt_fa_F2021(AntallArMndDag tt_fa_F2021) {
        this.tt_fa_F2021 = tt_fa_F2021;
    }

    public int getTt_fa_mnd() {
        return tt_fa_mnd;
    }

    public void setTt_fa_mnd(int tt_fa_mnd) {
        this.tt_fa_mnd = tt_fa_mnd;
    }

    public TTUtlandEOS getTtUtlandEos() {
        return ttUtlandEos;
    }

    public void setTtUtlandEos(TTUtlandEOS ttUtlandEos) {
        this.ttUtlandEos = ttUtlandEos;
    }

    public TTUtlandKonvensjon getTtUtlandKonvensjon() {
        return ttUtlandKonvensjon;
    }

    public void setTtUtlandKonvensjon(TTUtlandKonvensjon ttUtlandKonvensjon) {
        this.ttUtlandKonvensjon = ttUtlandKonvensjon;
    }

    public long getTrygdetidId() {
        return trygdetidId;
    }

    public void setTrygdetidId(long trygdetidId) {
        this.trygdetidId = trygdetidId;
    }

    public List<TTUtlandTrygdeavtale> getTtUtlandTrygdeavtaler() {
        return ttUtlandTrygdeavtaler;
    }

    public void setTtUtlandTrygdeavtaler(List<TTUtlandTrygdeavtale> ttUtlandTrygdeavtaler) {
        this.ttUtlandTrygdeavtaler = ttUtlandTrygdeavtaler;
    }

    /**
     * @deprecated
     * @return
     */
    @Deprecated
    public TTUtlandTrygdeavtale[] retrieveTTUtlandTrygdeavtaleListeAsArray() {
        return ttUtlandTrygdeavtaler.toArray(new TTUtlandTrygdeavtale[0]);
    }

    /**
     * Read only property for TTUtlandTrygdeavtaleListe as array.
     *
     * @return array of TTUtlandTrygdeavtale
     */
    public TTUtlandTrygdeavtale[] getTTUtlandTrygdeavtaleListeAsArray() {
        return ttUtlandTrygdeavtaler != null ? ttUtlandTrygdeavtaler.toArray(new TTUtlandTrygdeavtale[ttUtlandTrygdeavtaler.size()]) : new TTUtlandTrygdeavtale[0];
    }

    public int getTt_faktisk() {
        return tt_faktisk;
    }

    public void setTt_faktisk(int tt_faktisk) {
        this.tt_faktisk = tt_faktisk;
    }

    public RegelverkTypeCti getRegelverkType() {
        return regelverkType;
    }

    public void setRegelverkType(RegelverkTypeCti regelverkType) {
        this.regelverkType = regelverkType;
    }

    public TrygdetidGarantiTypeCti getGarantiType() {
        return garantiType;
    }

    public void setGarantiType(TrygdetidGarantiTypeCti garantiType) {
        this.garantiType = garantiType;
    }

    public int getProrataTellerVKAP() {
        return prorataTellerVKAP;
    }

    public void setProrataTellerVKAP(int prorataTellerVKAP) {
        this.prorataTellerVKAP = prorataTellerVKAP;
    }

    public int getProrataNevnerVKAP() {
        return prorataNevnerVKAP;
    }

    public void setProrataNevnerVKAP(int prorataNevnerVKAP) {
        this.prorataNevnerVKAP = prorataNevnerVKAP;
    }

    public AntallArMndDag getTt_fa() {
        return tt_fa;
    }

    public void setTt_fa(AntallArMndDag tt_fa) {
        this.tt_fa = tt_fa;
    }

    public Date getVirkFom() {
        return virkFom;
    }

    public void setVirkFom(Date virkFom) {
        this.virkFom = virkFom;
    }

    public Date getVirkTom() {
        return virkTom;
    }

    public void setVirkTom(Date virkTom) {
        this.virkTom = virkTom;
    }

}