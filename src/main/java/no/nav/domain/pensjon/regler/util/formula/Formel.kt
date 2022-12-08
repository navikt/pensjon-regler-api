package no.nav.domain.pensjon.regler.util.formula

import java.io.Serializable

class Formel(
    private val navn: String? = null,
    private val emne: String? = null,
    private val felt: String? = null,
    private val resultat: Number? = null,
    private val notasjon: String? = null,
    private val innhold: String? = null,
    private val subFormelList: List<Formel> = listOf()
) : Serializable
