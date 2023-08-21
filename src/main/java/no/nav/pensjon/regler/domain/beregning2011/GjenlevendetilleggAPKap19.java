package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;
import no.nav.domain.pensjon.regler.trygdetid.Brok;
import no.nav.domain.pensjon.regler.util.formula.Formel;
import no.nav.domain.pensjon.regler.util.formula.IFormelProvider;
import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

import java.util.HashMap;
import java.util.Map;

public class GjenlevendetilleggAPKap19 extends Ytelseskomponent implements IFormelProvider {

    private static final long serialVersionUID = -1290580819165950453L;

    /**
     * Sum av GP, TP og PenT for AP2011 medregnet GJR.
     */
    private int apKap19MedGJR;

    /**
     * Sum av GP, TP og PenT for AP2011 uten GJR.
     */
    private int apKap19UtenGJR;

    /**
     * Referansebeløp beregnet av differanse mellom APKap19 med og uten GJR.
     */
    private int referansebelop;

    private Brok eksportfaktor;

    /**
     * Map av formler brukt i beregning av Tilleggspensjon.
     */
    private HashMap<String, Formel> formelMap;

    public GjenlevendetilleggAPKap19() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("AP_GJT_KAP19");
        formelMap = new HashMap<>( );
    }

    public GjenlevendetilleggAPKap19(GjenlevendetilleggAPKap19 gjtKap19) {
        super(gjtKap19);
        this.apKap19MedGJR = gjtKap19.apKap19MedGJR;
        this.apKap19UtenGJR = gjtKap19.apKap19UtenGJR;
        this.referansebelop = gjtKap19.referansebelop;
        this.eksportfaktor = gjtKap19.eksportfaktor;

        formelMap = new HashMap<>( );
        if (gjtKap19.formelMap != null && !gjtKap19.formelMap.isEmpty()) {
            for (Map.Entry<String, Formel> pair : gjtKap19.formelMap.entrySet()) {
                formelMap.put( pair.getKey(), new Formel( pair.getValue() ));
            }
        }
    }

    public int getApKap19MedGJR() {
        return apKap19MedGJR;
    }

    public void setApKap19MedGJR(int apKap19MedGJR) {
        this.apKap19MedGJR = apKap19MedGJR;
    }

    public int getApKap19UtenGJR() {
        return apKap19UtenGJR;
    }

    public void setApKap19UtenGJR(int apKap19UtenGJR) {
        this.apKap19UtenGJR = apKap19UtenGJR;
    }

    public int getReferansebelop() {
        return referansebelop;
    }

    public void setReferansebelop(int referansebelop) {
        this.referansebelop = referansebelop;
    }

    public Brok getEksportfaktor() {
        return eksportfaktor;
    }

    public void setEksportfaktor(Brok eksportfaktor) {
        this.eksportfaktor = eksportfaktor;
    }

    @Override
    public HashMap<String, Formel> getFormelMap() {
        return formelMap;
    }

    @Override
    public String getFormelPrefix() {
        return "GJT_Kap19";
    }
}
