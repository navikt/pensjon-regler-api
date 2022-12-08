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
     * Samlet trygdetid i antall år. Vanligvis lik tt_anv i Beregning. Unntaket
     * er når antall poengår er større. I simulering er dette den eneste
     * trygdetiden som trengs.
     */
    private int tt;

    /**
     * Framtidig trygdetid i antall måneder.
     */
    private int ftt;

    /**
     * Om framtidig trygdetid er redusert i henhold til 4/5-dels regelen (§3-6
     * tredje ledd).
     */
    private boolean ftt_redusert;

    /**
     * Dato fremtidig trygdetid regnes fra.
     */
    private Date ftt_fom;

    /**
     * Faktiske trygdetidsmåneder. Brukes etter EØS og land med bilaterale
     * avtaler. Utgjør summen av all faktisk trygdetid i Norge og andre EØS-land
     * eller alternativt det landet vi har bilateral avtale med. Måneder.
     */
    private int tt_fa_mnd;

    /**
     * Trygdetid i antall år på grunnlag av poengår i det 67., 68. og 69.
     * leveåret. Godskrives ved fylte 70 år.
     */
    private int tt_67_70;

    /**
     * Trygdetid beregnet for poengår opptjent fra og med kalenderåret bruker fylte 6 år
     * til og med kalenderåret bruker fylte 75 år.
     */
    private int tt_67_75;

    /**
     * Summen av norsk faktisk trygdetid og eventuelle poengår opptjent fra året fyller 67.
     * Slike poengår vil kun legges til summen dersom vilkår for at de skal kunne telle
     * med er oppfylt. I antall måneder.
     */
    private int tt_faktisk;

    /**
     * Trygdetid etter 1966 i antall år.
     */
    private int tt_E66;

    /**
     * Trygdetid før 1967 i antall år.
     */
    private int tt_F67;

    /**
     * Faktisk trygdetid i antall år, måneder og dager før 2021.
     * Innført ifbm overgangsregler for flyktninger.
     */
    private AntallArMndDag tt_fa_F2021;

    /**
     * Opptjeningstiden er tidsrommet i antall måneder fra og med måneden etter
     * fylte 16 år til og med måneden før stønadstilfellet inntrådte. Brukes til
     * å bestemme 4/5-dels krav til faktisk trygdetid (§3-6 tredje ledd).
     */
    private int opptjeningsperiode;

    /**
     * Trygdetid i EØS land unntatt Norge.
     */
    private TTUtlandEOS ttUtlandEos;

    /**
     * Trygdetid i land tilhørende Nordisk konvensjon (artikkel 10) unntatt
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
     * Felt som blir brukt ved proratisering av pensjonsnivå ved
     * vilkårsprøving av tidliguttak av AP
     */
    private int prorataTellerVKAP;
    private int prorataNevnerVKAP;

    /**
     * Felt som blir brukt for å holde orden på nøyaktig antall år, måneder og dager trygdetid
     * for å unngå avrundingsfeil på grunn av dobbel avrunding.
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