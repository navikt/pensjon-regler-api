package no.nav.domain.pensjon.regler;

import no.nav.domain.pensjon.regler.kode.AvtalelandCti;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Trygdetid for land med bilaterale avtaler.
 */
public class TTUtlandTrygdeavtale implements Serializable {
    /**
     * Framtidig trygdetid i avtaleland i antall m�neder.
     */
    private int ftt;

    /**
     * Om framtidig trygdetid er redusert etter 4/5-dels regel.
     */
    private boolean ftt_redusert;

    /**
     * Faktisk trygdetid i avtaleland i antall m�neder.
     */
    private int tt_fa_mnd;

    /**
     * Anvendt trygdetid i avtaleland i antall �r.
     */
    private int tt_anv_ar;

    /**
     * Anvendt trygdetid i avtaleland i antall m�neder.
     */
    private int tt_anv_mnd;

    /**
     * Teller i pro-rata br�k.
     */
    private int pro_rata_teller;

    /**
     * Nevner i pro-rata br�k.
     */
    private int pro_rata_nevner;

    /**
     * Avtaleland som trygdetid er opptjent i.
     */
    private AvtalelandCti avtaleland;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;

}
