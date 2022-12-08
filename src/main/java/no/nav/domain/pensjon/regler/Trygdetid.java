package no.nav.domain.pensjon.regler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import no.nav.domain.pensjon.regler.grunnlag.AntallArMndDag;
import no.nav.domain.pensjon.regler.kode.RegelverkTypeCti;
import no.nav.domain.pensjon.regler.kode.TrygdetidGarantiTypeCti;
import no.nav.domain.pensjon.regler.kode.UtfallTypeCti;
/**
 * Trygdetid - framtidig trygdetid
 *
 * @author Lars Hartvigsen (Decisive), PK-12705
 * @author Lars Hartvigsen (Decisive), PK-5610
 * @author Magnus Bakken (Accenture), PK-18583
 */
public class Trygdetid implements Serializable {



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
    private RegelverkTypeCti regelverkType;

    /**
     * Samlet trygdetid i antall �r. Vanligvis lik tt_anv i Beregning. Unntaket
     * er n�r antall poeng�r er st�rre. I simulering er dette den eneste
     * trygdetiden som trengs.
     */
    private int tt;

    /**
     * Framtidig trygdetid i antall m�neder.
     */
    private int ftt;

    /**
     * Om framtidig trygdetid er redusert i henhold til 4/5-dels regelen (�3-6
     * tredje ledd).
     */
    private boolean ftt_redusert;

    /**
     * Dato fremtidig trygdetid regnes fra.
     */
    private Date ftt_fom;

    /**
     * Faktiske trygdetidsm�neder. Brukes etter E�S og land med bilaterale
     * avtaler. Utgj�r summen av all faktisk trygdetid i Norge og andre E�S-land
     * eller alternativt det landet vi har bilateral avtale med. M�neder.
     */
    private int tt_fa_mnd;

    /**
     * Trygdetid i antall �r p� grunnlag av poeng�r i det 67., 68. og 69.
     * leve�ret. Godskrives ved fylte 70 �r.
     */
    private int tt_67_70;

    /**
     * Trygdetid beregnet for poeng�r opptjent fra og med kalender�ret bruker fylte 6 �r
     * til og med kalender�ret bruker fylte 75 �r.
     */
    private int tt_67_75;

    /**
     * Summen av norsk faktisk trygdetid og eventuelle poeng�r opptjent fra �ret fyller 67.
     * Slike poeng�r vil kun legges til summen dersom vilk�r for at de skal kunne telle
     * med er oppfylt. I antall m�neder.
     */
    private int tt_faktisk;

    /**
     * Trygdetid etter 1966 i antall �r.
     */
    private int tt_E66;

    /**
     * Trygdetid f�r 1967 i antall �r.
     */
    private int tt_F67;

    /**
     * Faktisk trygdetid i antall �r, m�neder og dager f�r 2021.
     * Innf�rt ifbm overgangsregler for flyktninger.
     */
    private AntallArMndDag tt_fa_F2021;

    /**
     * Opptjeningstiden er tidsrommet i antall m�neder fra og med m�neden etter
     * fylte 16 �r til og med m�neden f�r st�nadstilfellet inntr�dte. Brukes til
     * � bestemme 4/5-dels krav til faktisk trygdetid (�3-6 tredje ledd).
     */
    private int opptjeningsperiode;

    /**
     * Trygdetid i E�S land unntatt Norge.
     */
    private TTUtlandEOS ttUtlandEos;

    /**
     * Trygdetid i land tilh�rende Nordisk konvensjon (artikkel 10) unntatt
     * Norge.
     */
    private TTUtlandKonvensjon ttUtlandKonvensjon;

    /**
     * Trygdetid i land med bilaterale avtaler.
     */
    private List<TTUtlandTrygdeavtale> ttUtlandTrygdeavtaler;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;

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
    private AntallArMndDag tt_fa;

    /**
     * Trygdetidens virkningsdato fom. Brukes ved fastsettelse av periodisert trygdetid for AP2011/AP2016 og AP2025
     */
    private Date virkFom;

    /**
     * Trygdetidens virkningsdato tom. Brukes ved fastsettelse av periodisert trygdetid for AP2011/AP2016 og AP2025
     */
    private Date virkTom;

    private UtfallTypeCti anvendtFlyktning;

}