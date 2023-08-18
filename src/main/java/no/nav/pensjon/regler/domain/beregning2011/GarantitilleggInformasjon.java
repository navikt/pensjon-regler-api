package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.kode.BorMedTypeCti;

import java.io.Serializable;

public class GarantitilleggInformasjon implements Serializable {
    private static final long serialVersionUID = 1L;

    private BorMedTypeCti anvendtSivilstand;
    private double pensjonsbeholdningBelopVed67;
    private double garantipensjonsbeholdningBelopVed67;
    private int tt_kapittel20Ved67;
    private int tt_kapittel19Ved67;
    private int pa_f92Ved67;
    private int pa_e91Ved67;
    private double ftVed67;
    private double dtVed67;
    double sptVed67;
    private int tt_2009;
    private int pa_f92_2009;
    private int pa_e91_2009;
    private double spt_2009;
    private double ft67_1962;
    private double dt67_1962;

    /**
     * Indikerer om regeltjeneste har estimert trygdetid kapittel 19 basert på
     * trygdetidsgrunnlag for kapittel 20. Denne estimering gjøres i forbindelse med
     * beregning av garantitilleggsbeholdning BER3156. Ref. CR 216411.
     */
    private boolean estimertTTkap19Benyttet;

    public GarantitilleggInformasjon() {

    }

    public GarantitilleggInformasjon(GarantitilleggInformasjon gti) {
        if (gti.anvendtSivilstand != null) {
            anvendtSivilstand = new BorMedTypeCti(anvendtSivilstand);
        }
        pensjonsbeholdningBelopVed67 = gti.pensjonsbeholdningBelopVed67;
        garantipensjonsbeholdningBelopVed67 = gti.garantipensjonsbeholdningBelopVed67;
        tt_kapittel20Ved67 = gti.tt_kapittel20Ved67;
        tt_kapittel19Ved67 = gti.tt_kapittel19Ved67;
        pa_f92Ved67 = gti.pa_f92Ved67;
        pa_e91Ved67 = gti.pa_e91Ved67;
        ftVed67 = gti.ftVed67;
        dtVed67 = gti.dtVed67;
        tt_2009 = gti.tt_2009;
        pa_f92_2009 = gti.pa_f92_2009;
        pa_e91_2009 = gti.pa_e91_2009;
        spt_2009 = gti.spt_2009;
        ft67_1962 = gti.ft67_1962;
        dt67_1962 = gti.dt67_1962;
        sptVed67 = gti.sptVed67;
    }

    public BorMedTypeCti getAnvendtSivilstand() {
        return anvendtSivilstand;
    }

    public void setAnvendtSivilstand(BorMedTypeCti anvendtSivilstand) {
        this.anvendtSivilstand = anvendtSivilstand;
    }

    public double getDtVed67() {
        return dtVed67;
    }

    public double getSptVed67() {
        return sptVed67;
    }

    public void setSptVed67(double sptVed67) {
        this.sptVed67 = sptVed67;
    }

    public void setDtVed67(double dtVed67) {
        this.dtVed67 = dtVed67;
    }

    public double getDt67_1962() {
        return dt67_1962;
    }

    public void setDt67_1962(double dt67_1962) {
        this.dt67_1962 = dt67_1962;
    }

    public double getFt67_1962() {
        return ft67_1962;
    }

    public void setFt67_1962(double ft67_1962) {
        this.ft67_1962 = ft67_1962;
    }

    public double getFtVed67() {
        return ftVed67;
    }

    public void setFtVed67(double ftVed67) {
        this.ftVed67 = ftVed67;
    }

    public double getGarantipensjonsbeholdningBelopVed67() {
        return garantipensjonsbeholdningBelopVed67;
    }

    public void setGarantipensjonsbeholdningBelopVed67(double garantipensjonsbeholdningBelopVed67) {
        this.garantipensjonsbeholdningBelopVed67 = garantipensjonsbeholdningBelopVed67;
    }

    public int getPa_e91_2009() {
        return pa_e91_2009;
    }

    public void setPa_e91_2009(int pa_e91_2009) {
        this.pa_e91_2009 = pa_e91_2009;
    }

    public int getPa_e91Ved67() {
        return pa_e91Ved67;
    }

    public void setPa_e91Ved67(int pa_e91Ved67) {
        this.pa_e91Ved67 = pa_e91Ved67;
    }

    public int getPa_f92_2009() {
        return pa_f92_2009;
    }

    public void setPa_f92_2009(int pa_f92_2009) {
        this.pa_f92_2009 = pa_f92_2009;
    }

    public int getPa_f92Ved67() {
        return pa_f92Ved67;
    }

    public void setPa_f92Ved67(int pa_f92Ved67) {
        this.pa_f92Ved67 = pa_f92Ved67;
    }

    public double getPensjonsbeholdningBelopVed67() {
        return pensjonsbeholdningBelopVed67;
    }

    public void setPensjonsbeholdningBelopVed67(double pensjonsbeholdningBelopVed67) {
        this.pensjonsbeholdningBelopVed67 = pensjonsbeholdningBelopVed67;
    }

    public double getSpt_2009() {
        return spt_2009;
    }

    public void setSpt_2009(double spt_2009) {
        this.spt_2009 = spt_2009;
    }

    public int getTt_2009() {
        return tt_2009;
    }

    public void setTt_2009(int tt_2009) {
        this.tt_2009 = tt_2009;
    }

    public int getTt_kapittel19Ved67() {
        return tt_kapittel19Ved67;
    }

    public void setTt_kapittel19Ved67(int tt_kapittel19Ved67) {
        this.tt_kapittel19Ved67 = tt_kapittel19Ved67;
    }

    public int getTt_kapittel20Ved67() {
        return tt_kapittel20Ved67;
    }

    public void setTt_kapittel20Ved67(int tt_kapittel20Ved67) {
        this.tt_kapittel20Ved67 = tt_kapittel20Ved67;
    }

    public boolean isEstimertTTkap19Benyttet() {
        return estimertTTkap19Benyttet;
    }

    public void setEstimertTTkap19Benyttet(boolean estimertTTkap19Benyttet) {
        this.estimertTTkap19Benyttet = estimertTTkap19Benyttet;
    }

}
