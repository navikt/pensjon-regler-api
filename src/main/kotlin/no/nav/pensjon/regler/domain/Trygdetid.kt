package no.nav.pensjon.regler.domain

import no.nav.pensjon.regler.domain.grunnlag.AntallArMndDag
import no.nav.pensjon.regler.domain.kode.RegelverkTypeCti
import no.nav.pensjon.regler.domain.kode.TrygdetidGarantiTypeCti
import no.nav.pensjon.regler.domain.kode.UtfallTypeCti
import java.io.Serializable
import java.util.*

/**
 * Trygdetid - framtidig trygdetid
 */
class Trygdetid : Serializable {
    /**
     * Unik id for objektet, brukes ikke av pensjon-regler,og blir med ut uforandret.
     */
    var trygdetidId: Long = 0

    /**
     * Bestemmer hvilket regelverk objektet gjelder for
     * G_REG - gammelt regelverk
     * N_REG_G_OPPTJ - nytt regelverk, gammel opptjeningsmodell
     * N_REG_G_N_OPPTJ - nytt regelverk, gammel og ny opptjeningsmodell
     * N_REG_N_OPPTJ - nytt regelverk, ny opptjeningsmodell
     */
    var regelverkType: RegelverkTypeCti? = null

    /**
     * Samlet trygdetid i antall år. Vanligvis lik tt_anv i Beregning. Unntaket
     * er når antall poengår er større. I simulering er dette den eneste
     * trygdetiden som trengs.
     */
    var tt = 0

    /**
     * Framtidig trygdetid i antall måneder.
     */
    var ftt = 0

    /**
     * Om framtidig trygdetid er redusert i henhold til 4/5-dels regelen (3-6
     * tredje ledd).
     */
    var ftt_redusert = false

    /**
     * Dato fremtidig trygdetid regnes fra.
     */
    var ftt_fom: Date? = null

    /**
     * Faktiske trygdetidsmåneder. Brukes etter EØS og land med bilaterale
     * avtaler. utgjør summen av all faktisk trygdetid i Norge og andre EØS-land
     * eller alternativt det landet vi har bilateral avtale med. måneder.
     */
    var tt_fa_mnd = 0

    /**
     * Trygdetid i antall år på grunnlag av poengår i det 67., 68. og 69.
     * leveåret. Godskrives ved fylte 70 år.
     */
    var tt_67_70 = 0

    /**
     * Trygdetid beregnet for poengår opptjent fra og med kalenderåret bruker fylte 6 år
     * til og med kalenderåret bruker fylte 75 år.
     */
    var tt_67_75 = 0

    /**
     * Summen av norsk faktisk trygdetid og eventuelle poengår opptjent fra året fyller 67.
     * Slike poengår vil kun legges til summen dersom vilkår for at de skal kunne telle
     * med er oppfylt. I antall måneder.
     */
    var tt_faktisk = 0

    /**
     * Trygdetid etter 1966 i antall år.
     */
    var tt_E66 = 0

    /**
     * Trygdetid før 1967 i antall år.
     */
    var tt_F67 = 0

    /**
     * Faktisk trygdetid i antall år, måneder og dager før 2021.
     * Innført ifbm overgangsregler for flyktninger.
     */
    var tt_fa_F2021: AntallArMndDag? = null

    /**
     * Opptjeningstiden er tidsrommet i antall måneder fra og med måneden etter
     * fylte 16 år til og med måneden før stønadstilfellet inntrådte. Brukes til
     * å bestemme 4/5-dels krav til faktisk trygdetid (§3-6 tredje ledd).
     */
    var opptjeningsperiode = 0

    /**
     * Trygdetid i EØS land unntatt Norge.
     */
    var ttUtlandEos: TTUtlandEOS? = null

    /**
     * Trygdetid i land tilhørende Nordisk konvensjon (artikkel 10) unntatt
     * Norge.
     */
    var ttUtlandKonvensjon: TTUtlandKonvensjon? = null

    /**
     * Trygdetid i land med bilaterale avtaler.
     */
    var ttUtlandTrygdeavtaler: List<TTUtlandTrygdeavtale> = mutableListOf()

    /**
     * Liste av merknader.
     */
    var merknadListe: List<Merknad> = mutableListOf()
    var garantiType: TrygdetidGarantiTypeCti? = null

    /**
     * Felt som blir brukt ved proratisering av pensjonsnivå ved
     * vilkårsprøving av tidliguttak av AP
     */
    var prorataTellerVKAP = 0
    var prorataNevnerVKAP = 0

    /**
     * Felt som blir brukt for å holde orden på nøyaktig antall år, måneder og dager trygdetid
     * for å unngå avrundingsfeil på grunn av dobbel avrunding.
     */
    var tt_fa: AntallArMndDag? = null

    /**
     * Trygdetidens virkningsdato fom. Brukes ved fastsettelse av periodisert trygdetid for AP2011/AP2016 og AP2025
     */
    var virkFom: Date? = null

    /**
     * Trygdetidens virkningsdato tom. Brukes ved fastsettelse av periodisert trygdetid for AP2011/AP2016 og AP2025
     */
    var virkTom: Date? = null
    var anvendtFlyktning: UtfallTypeCti? = null
}