package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.kode.FormelKodeCti;
import no.nav.pensjon.regler.domain.kode.GarantipenNivaCti;

import java.io.Serializable;

public class Garantipensjonsniva implements Serializable {
    private static final long serialVersionUID = 4872799871400507221L;
    protected boolean ektefelleInntektOver2G;
    private double belop;
    private double belopIkkeProratisert;
    private double sats;
    private GarantipenNivaCti satsType;
    private FormelKodeCti formelkode;
    private int pro_rata_teller_mnd;
    private int pro_rata_nevner_mnd;
    private double pro_rata_brok;
    private int tt_anv;
    private int faktisk_tt_avtaleland_mnd;

    private int benyttetYug;

    public Garantipensjonsniva() {
        super();
    }

    public Garantipensjonsniva(Garantipensjonsniva garPN) {
        this();
        belop = garPN.belop;
        sats = garPN.sats;
        belopIkkeProratisert = garPN.belopIkkeProratisert;
        if (garPN.satsType != null) {
            satsType = new GarantipenNivaCti(garPN.satsType);
        }
        if (garPN.formelkode != null) {
            this.formelkode = new FormelKodeCti(garPN.formelkode);
        }
        pro_rata_teller_mnd = garPN.pro_rata_teller_mnd;
        pro_rata_nevner_mnd = garPN.pro_rata_nevner_mnd;
        pro_rata_brok = garPN.pro_rata_brok;
        tt_anv = garPN.tt_anv;
        ektefelleInntektOver2G = garPN.ektefelleInntektOver2G;
        faktisk_tt_avtaleland_mnd = garPN.faktisk_tt_avtaleland_mnd;
        benyttetYug = garPN.benyttetYug;
    }

    public double getBelop() {
        return belop;
    }

    public void setBelop(double belop) {
        this.belop = belop;
    }

    public double getBelopIkkeProratisert() {
        return belopIkkeProratisert;
    }

    public void setBelopIkkeProratisert(double belopIkkeProratisert) {
        this.belopIkkeProratisert = belopIkkeProratisert;
    }

    public double getSats() {
        return sats;
    }

    public void setSats(double sats) {
        this.sats = sats;
    }

    public GarantipenNivaCti getSatsType() {
        return satsType;
    }

    public void setSatsType(GarantipenNivaCti satsType) {
        this.satsType = satsType;
    }

    public int getPro_rata_teller_mnd() {
        return pro_rata_teller_mnd;
    }

    public void setPro_rata_teller_mnd(int proRataTellerMnd) {
        pro_rata_teller_mnd = proRataTellerMnd;
    }

    public int getPro_rata_nevner_mnd() {
        return pro_rata_nevner_mnd;
    }

    public void setPro_rata_nevner_mnd(int proRataNevnerMnd) {
        pro_rata_nevner_mnd = proRataNevnerMnd;
    }

    public double getPro_rata_brok() {
        return pro_rata_brok;
    }

    public void setPro_rata_brok(double proRataBrok) {
        pro_rata_brok = proRataBrok;
    }

    public int getTt_anv() {
        return tt_anv;
    }

    public void setTt_anv(int tt_anv) {
        this.tt_anv = tt_anv;
    }

    public boolean isEktefelleInntektOver2G() {
        return ektefelleInntektOver2G;
    }

    public void setEktefelleInntektOver2G(boolean ektefelleInntektOver2G) {
        this.ektefelleInntektOver2G = ektefelleInntektOver2G;
    }

    public int getFaktisk_tt_avtaleland_mnd() {
        return faktisk_tt_avtaleland_mnd;
    }

    public void setFaktisk_tt_avtaleland_mnd(int faktisk_tt_avtaleland_mnd) {
        this.faktisk_tt_avtaleland_mnd = faktisk_tt_avtaleland_mnd;
    }

    public FormelKodeCti getFormelkode() {
        return formelkode;
    }

    public void setFormelkode(FormelKodeCti formelkode) {
        this.formelkode = formelkode;
    }

    public int getBenyttetYug() {
        return benyttetYug;
    }

    public void setBenyttetYug(int benyttetYug) {
        this.benyttetYug = benyttetYug;
    }
}
