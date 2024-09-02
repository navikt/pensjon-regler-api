package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.beregning.Sertillegg
import no.nav.pensjon.regler.domain.enum.Fravik_19_3_Enum
import no.nav.pensjon.regler.domain.enum.PoengtilleggEnum
import no.nav.pensjon.regler.domain.kode.Fravik_19_3Cti
import no.nav.pensjon.regler.domain.kode.PoengtilleggCti
import java.io.Serializable

/**
 * Generell historisk info for en bruker
 */
class GenerellHistorikk : Serializable {
    /**
     * Identifikasjon av den generelle historikken
     */
    var generellHistorikkId: Long? = null

    /*
     * Koder som sier hvilken trygdetid som skal brukes i beregning når Første virk er før 1991.
     * Brukes i utenlandssaker der pensjonisten kan få godskrevet trygdetid opptjent i utlandet før 1967.
     */
    var fravik_19_3: Fravik_19_3Cti? = null
    var fravik_19_3Enum: Fravik_19_3_Enum? = null

    /*
     * Gjennomsnittlig Uføregrad - EØS.
     */
    var fpp_eos: Double? = null

    /**
     * Ventetilleggsgrunnlag
     */
    var ventetilleggsgrunnlag: Ventetilleggsgrunnlag? = null
    var poengtillegg: PoengtilleggCti? = null
    var poengtilleggEnum: PoengtilleggEnum? = null

    /*
     * Inneholder informasjon ang tidligere EØS beregninger. Brukes ved konvertering til AP.
     */
    var eosEkstra: EosEkstra? = null

    /**
     * Innholder trygdetidsgarantien for ektefeller som går under gammel lov før 1.1.1991
     */
    var garantiTrygdetid: GarantiTrygdetid? = null

    /* CR175446 - 1943 konvertert AP1967 til AP2011 */ /* særtillegget brukeren hadde på AP1967-ytelsen (settes lik null om han ikke hadde særtillegg) */
    var sertillegg1943kull: Sertillegg? = null

    /* CR175446 - Gift eller tilsvarende med samme person siden 31.12.2010 */
    var giftFor2011 = false

}