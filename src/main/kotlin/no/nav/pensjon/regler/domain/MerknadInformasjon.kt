package no.nav.pensjon.regler.domain

import java.io.Serializable

class MerknadInformasjon(
    val merknadskode: String,
    val bearbeidetTekst: String,
    val paragraf: String
) : Serializable