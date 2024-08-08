package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.kode.FremskrevetMPNTypeCti

@Deprecated("Ikke i bruk")
interface Fremskriving {
    var teller: Int
    var nevner: Int
    var brok: Double
    var type: FremskrevetMPNTypeCti?
    // TODO Hva skal brukes her?
    var typeEnum: FremskrevetMPNTypeCti?
}