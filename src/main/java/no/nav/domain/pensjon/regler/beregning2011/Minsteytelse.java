package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.trygdetid.AnvendtTrygdetid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Steinar Hjellvik (Decisive) - PKPYTON-1746
 * @author Frederik Rønnevig (Decisive) - PK-18954 (Nytt felt eksportforbud)
 *
 */
public class Minsteytelse implements Serializable {

    

    private FormelKodeCti formelKode;

    private List<Merknad> merknadListe;

    private SatsMinsteytelse satsMinsteytelse;

    private int arsbelop;

    private boolean eksportforbud;

    /**
     * Trygdetid som er brukt ved beregning av minsteytelsen.
     */
    private AnvendtTrygdetid anvendtTrygdetid;


}
