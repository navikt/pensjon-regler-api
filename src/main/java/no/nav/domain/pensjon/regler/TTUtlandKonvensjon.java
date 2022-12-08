package no.nav.domain.pensjon.regler;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Trygdetid for utenlandssaker, men ikke EØS. Dvs nordisk konvensjon (artikkel
 * 10) og andre land med bilaterale avtaler.
 */
public class TTUtlandKonvensjon implements Serializable {

    /**
     * Brutto framtidig trygdetid i antall måneder etter Nordisk konvensjon.
     */
    private int ftt_A10_brutto;

    /**
     * Netto framtidig trygdetid i antall måneder etter Nordisk konvensjon.
     */
    private int ftt_A10_netto;

    /**
     * Om framtidig trygdetid etter Nordisk konvensjon er redusert etter
     * 4/5-dels regel.
     */
    private boolean ftt_A10_redusert;

    /**
     * Antall framtidige år, brukes ved bilaterale avtaler med UK og Nederland
     */
    private int ft_ar;

    /**
     * Faktisk trygdetid i antall måneder etter Nordisk konvensjon.
     */
    private int tt_A10_fa_mnd;

    /**
     * Faktisk trygdetid i antall år etter Nordisk konvensjon.
     */
    private int tt_A10_anv_aar;

    /**
     * Teller i Nordisk pro-rata brøk.
     */
    private int tt_A10_teller;

    /**
     * Nevner i Nordisk pro-rata brøk.
     */
    private int tt_A10_nevner;

    /**
     * Trygdetiden settes lik antall år som blir tastet inn i feltet.
     */
    private int tt_konvensjon_ar;

    /**
     * Trygdetid skal være like antall poeng år. Har bare betydning for personer
     * som har vært bosatt i utlandet.
     */
    private boolean tt_lik_pa;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;


}
