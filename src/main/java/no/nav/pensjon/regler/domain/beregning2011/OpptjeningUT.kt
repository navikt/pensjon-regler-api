package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.Merknad
import no.nav.pensjon.regler.domain.Omsorgsopptjening
import no.nav.pensjon.regler.domain.grunnlag.OpptjeningTypeMapping
import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import java.io.Serializable

class OpptjeningUT : Serializable, Omsorgsopptjening {
    /**
     * Angir om avkortet mot 6*grunnbeløp ved virk.
     */
    @JvmField
    var avkortetBelop = 0.0

    /**
     * Angir om et av de tre årene som er brukt.
     */
    var isBrukt = false

    /**
     * Angir om det er inntekt i avtaleland som angår den konvensjon som beregningsgrunnlaget inngår i.
     */
    var inntektIAvtaleland = false

    /**
     * Inntekten for et år ganget med forholdet mellom grunnbeløpet ved virk
     * og gjennomsnittlig grunnbeløp for inntektsåret.
     */
    var justertBelop = 0.0

    /**
     * Pensjonsgivende inntekt.
     */
    var pgi = 0

    /**
     * Gjennomsnittlig G for inntektsåret.
     */
    var veietG = 0

    /**
     * Hvilket årstall.
     */
    @JvmField
    var ar = 0
    var merknadListe: List<Merknad> = mutableListOf()
    var formelkode: FormelKodeCti? = null

    /**
     * Opptjeningsgaranti ved Førstegangstjeneste.
     */
    var forstegangstjeneste = 0

    /**
     * Beregnet inntekt for året.
     */
    var belop = 0
    /**
     * @return Minste beløp for fastsettelse av justert PGI.
     */
    /**
     * @param garantiBelop Nytt minste beløp for fastsettelse av justert PGI.
     */
    /**
     * Minste beløp for fastsettelse av justert PGI.
     */
    var garantiBelop = 0

    /**
     * Angir om det finnes omsorgsopptjening for året.
     */
    var isOmsorgsar = false
    /**
     * @return the justertPGI
     */
    /**
     * @param justertPGI the justertPGI to set
     */
    /**
     * Pensjonsgivende inntekt justert i henhold til
     * gjennomsnittlig stillingsprosent for året.
     */
    var justertPGI = 0
    /**
     * @return the uforeopptjening
     */
    /**
     * @param uforeopptjening the uforeopptjening to set
     */
    /**
     * Opptjening fra uførepensjon eller uføretrygd
     */
    var uforeopptjening = 0.0

    /**
     * Inneholder alle inntektstyper for dette året
     */
    var pREG_opptjeningTypeListe: List<OpptjeningTypeMapping> = mutableListOf()

    /**
     * Maks Uføregrad for dette året.
     */
    var pREG_maksUforegrad = 0

    /**
     * Maks yrkesskadegrad for dette året.
     */
    var pREG_maksYrkesskadegrad = 0

    override fun getOpptjeningsar(): Int {
        return ar
    }

    override fun getVerdi(): Double {
        return avkortetBelop
    }

    override fun isOmsorg(): Boolean {
        return isOmsorgsar
    }
}