package no.nav.domain.pensjon.regler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Trygdetid for E�S-tilfeller.
 */
public class TTUtlandEOS implements Serializable {

    

    /**
     * Framtidig trygdetid E�S i antall m�neder.
     */
    private int ftt_eos;

    /**
     * Om framtidig trygdetid E�S er redusert. Dersom faktisk trygdetid
     * medregnet tid i Norge og E�S er mindre enn 4/5 av opptjeningstiden skal
     * framtidig trygdetid for E�S beregnes med reduksjon.
     */
    private boolean ftt_eos_redusert;

    /**
     * Teoretisk trygdetid E�S i antall m�neder.
     */
    private int tt_eos_anv_mnd;

    /**
     * Teoretisk trygdetid E�S i antall �r.
     */
    private int tt_eos_anv_ar;

    /**
     * Pro-rata trygdetid i E�S land utenfor Norge i antall m�neder.
     */
    private int tt_eos_pro_rata_mnd;

    /**
     * Teoretisk trygdetid i E�S land utenfor Norge i antall m�neder.
     */
    private int tt_eos_teoretisk_mnd;

    /**
     * Teller i E�S pro-rata br�k, i antall m�neder.
     */
    private int tt_eos_teller;

    /**
     * Nevner i E�S pro-rata br�k, i antall m�neder.
     */
    private int tt_eos_nevner;

    // usikker p� om disse skal ligge begge steder
    /**
     * Trygdetid skal v�re lik antall poeng�r. Har bare betydning for personer
     * som har v�rt bosatt i utlandet.
     */
    private boolean tt_lik_pa;

    /**
     * Trygdetiden settes lik antall �r som blir tastet inn i feltet.
     */
    private int tt_konvensjon_ar;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;


}
