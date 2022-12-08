package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.beregning.Sertillegg;
import no.nav.domain.pensjon.regler.kode.Fravik_19_3Cti;
import no.nav.domain.pensjon.regler.kode.PoengtilleggCti;

import java.io.Serializable;

/**
 * Generell historisk info for en bruker
 */
public class GenerellHistorikk implements Serializable {

    /**
     * Identifikasjon av den generelle historikken
     */
    private Long generellHistorikkId;
    /*
     * Koder som sier hvilken trygdetid som skal brukes i beregning når første virk er før 1991.
     * Brukes i utenlandssaker der pensjonisten kan få godskrevet trygdetid opptjent i utlandet før 1967.
     */
    private Fravik_19_3Cti fravik_19_3;
    /*
     * Gjennomsnittlig uføregrad - EØS.
     */
    private Double fpp_eos;
    /**
     * Ventetilleggsgrunnlag
     */
    private Ventetilleggsgrunnlag ventetilleggsgrunnlag;

    private PoengtilleggCti poengtillegg;

    /*
     * Inneholder informasjon ang tidligere EØS beregninger. Brukes ved konvertering til AP.
     */
    private EosEkstra eosEkstra;

    /**
     * Innholder trygdetidsgarantien for ektefeller som går under gammel lov før 1.1.1991
     */
    private GarantiTrygdetid garantiTrygdetid;

    /* CR175446 - 1943 konvertert AP1967 til AP2011 */
    /* Særtillegget brukeren hadde på AP1967-ytelsen (settes lik null om han ikke hadde særtillegg) */
    private Sertillegg sertillegg1943kull;

    /* CR175446 - Gift eller tilsvarende med samme person siden 31.12.2010 */
    private boolean giftFor2011;

}
