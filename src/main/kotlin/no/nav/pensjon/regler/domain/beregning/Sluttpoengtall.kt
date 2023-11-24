package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.Merknad
import java.io.Serializable

/**
 * Sluttpoengtall
 */
class Sluttpoengtall : Serializable {
    /**
     * sluttpoengtallet
     */
    var pt = 0.0

    /**
     * Obsolete:
     */
    private val pt_eos = 0.0
    private val pt_a10 = 0.0

    /**
     * poengtillegg - brukes før 01.04.1984. Legges til poengtallet
     */
    var poengTillegg = 0.0

    /**
     * Liste av merknader.
     */
    var merknadListe: MutableList<Merknad> = mutableListOf()

    /**
     * Beregnet gjennomsnittlig SPT*UFG for en som går fra UP over til AP og har
     * EØS-fordeler i UP.
     */
    var fpp_grad_eos = 0.0

    /**
     * Poengrekken som ligger til grunn for sluttpoengtallet.
     */
    var poengrekke: Poengrekke? = null

    constructor()
    constructor(sluttpoengtall: Sluttpoengtall) {
        pt = sluttpoengtall.pt
        poengTillegg = sluttpoengtall.poengTillegg
        merknadListe = mutableListOf()
        for (merknad in sluttpoengtall.merknadListe) {
            merknadListe.add(Merknad(merknad))
        }
        fpp_grad_eos = sluttpoengtall.fpp_grad_eos
        if (sluttpoengtall.poengrekke != null) {
            poengrekke = Poengrekke(sluttpoengtall.poengrekke!!)
        }
    }
}