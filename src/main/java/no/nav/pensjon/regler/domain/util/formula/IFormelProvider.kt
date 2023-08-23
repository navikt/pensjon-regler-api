package no.nav.pensjon.regler.domain.util.formula

interface IFormelProvider {
    val formelMap: HashMap<String, Formel>
    val formelPrefix: String
}