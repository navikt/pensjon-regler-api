package no.nav.domain.pensjon.regler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Trygdetid for EØS-tilfeller.
 */
public class TTUtlandEOS implements Serializable {

    

    /**
     * Framtidig trygdetid EØS i antall måneder.
     */
    private int ftt_eos;

    /**
     * Om framtidig trygdetid EØS er redusert. Dersom faktisk trygdetid
     * medregnet tid i Norge og EØS er mindre enn 4/5 av opptjeningstiden skal
     * framtidig trygdetid for EØS beregnes med reduksjon.
     */
    private boolean ftt_eos_redusert;

    /**
     * Teoretisk trygdetid EØS i antall måneder.
     */
    private int tt_eos_anv_mnd;

    /**
     * Teoretisk trygdetid EØS i antall år.
     */
    private int tt_eos_anv_ar;

    /**
     * Pro-rata trygdetid i EØS land utenfor Norge i antall måneder.
     */
    private int tt_eos_pro_rata_mnd;

    /**
     * Teoretisk trygdetid i EØS land utenfor Norge i antall måneder.
     */
    private int tt_eos_teoretisk_mnd;

    /**
     * Teller i EØS pro-rata brøk, i antall måneder.
     */
    private int tt_eos_teller;

    /**
     * Nevner i EØS pro-rata brøk, i antall måneder.
     */
    private int tt_eos_nevner;

    // usikker på om disse skal ligge begge steder
    /**
     * Trygdetid skal være lik antall poengår. Har bare betydning for personer
     * som har vært bosatt i utlandet.
     */
    private boolean tt_lik_pa;

    /**
     * Trygdetiden settes lik antall år som blir tastet inn i feltet.
     */
    private int tt_konvensjon_ar;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;


}
