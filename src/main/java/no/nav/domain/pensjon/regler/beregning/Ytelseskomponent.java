package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.beregning2011.ReguleringsInformasjon;
import no.nav.domain.pensjon.regler.kode.FormelKodeCti;
import no.nav.domain.pensjon.regler.kode.SakTypeCti;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Superklasse for alle ytelser, Grunnpensjon, Sertillegg, AfpTillegg osv. For
 * alle ytelser gjelder at brutto - netto = fradrag.
 */
public abstract class Ytelseskomponent implements Serializable {
    /**
     * Brutto beløp.
     */
    protected int brutto = 0;

    /**
     * Netto beløp.
     */
    protected int netto = 0;

    /**
     * Fradraget: brutto - netto
     */
    protected int fradrag = 0;

    /**
     * Ikke avrundet beløp, gjelder for hele året.
     */
    protected double bruttoPerAr = 0.0;

    /**
     * Årlig netto utbetalt sum.
     */
    protected double nettoPerAr = 0.0;

    /**
     * Ytelsens fradrag per år.
     */
    protected double fradragPerAr = 0.0;

    /**
     * Type ytelse, verdi fra kodeverk.
     */
    protected YtelsekomponentTypeCti ytelsekomponentType;

    /**
     * Liste av merknader.
     */
    protected List<Merknad> merknadListe = new ArrayList<Merknad>();

    /**
     * Indikerer hvilken beregningsformel som ble brukt.
     */
    private FormelKodeCti formelKode;

    /**
     * Informasjon om regulering av ytelsen.
     */
    private ReguleringsInformasjon reguleringsInformasjon;

    /**
     * Angir om ytelseskomponenten går til utbetaling eller tilbakekreving.
     * Settes ikke i PREG, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    protected Boolean fradragsTransaksjon = false;

    /**
     * Angir om ytelseskomponenten er opphørt.
     * Settes ikke i PREG, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    protected Boolean opphort = false;

    /**
     * Angir sakentypen ytelseskomponenten er knyttet til.
     * Settes ikke i PREG, men mappes slik at vi ikke mister den ved kall til regeltjenester som returnerer kopier av innsendt ytelseskomponent (f.eks. faktoromregning).
     */
    protected SakTypeCti sakType;

}
