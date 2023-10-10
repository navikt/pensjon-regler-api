package no.nav.pensjon.regler.domain

import java.io.Serializable

class Uforeopptjening : Serializable {
    /*
     * beløp for hva Uføreopptjeningen utgjør.
     */
    var belop = 0.0

    /*
     * Angir hvorvidt opptjeningen baseres på en proRata beregnet uførepensjon.
     */
    var proRataBeregnetUP = false

    /*
     * Angir poengtallet som ligger til grunn utregningen.
     */
    var poengtall = 0.0

    /*
     * uførepensjonens Uføregrad.
     */
    var ufg = 0

    /*
     * Antatt Inntekt.
     */
    var antattInntekt = 0.0

    /*
     * Antatt Inntekt. ProRata variant.
     */
    var antattInntekt_proRata = 0.0

    /*
     * Angir hvor stor andel av opptjeningen kan benyttes i året (fra 0.00 til 1.00).
     */
    var andel_proRata = 0.0

    /*
     * Poengår teller for proRata brøk.
     */
    var poengarTeller_proRata = 0

    /*
     * Poengår nevner for proRata brøk.
     */
    var poengarNevner_proRata = 0

    /*
     * Antall fremtidige år, etter avkortning fra evt redFTT.
     */
    var antFremtidigeAr_proRata = 0

    /*
     * Angir yrkesskade delen av opptjeningen.
     */
    var yrkesskadeopptjening: Yrkesskadeopptjening? = null

    /**
     * Angir om opptjening er basert på uføretrygd (true) eller uførepensjon (false).
     */
    var uforetrygd = false

    /**
     * Angir om årets Uføreopptjening er relatert til Uføreperiode hvor uføretidspunktet er konvertert fra uførepensjon.
     */
    var konvertertUFT = false
}