package no.nav.pensjon.regler.domain.grunnlag

import no.nav.pensjon.regler.domain.enum.YrkeYrkesskadeEnum
import no.nav.pensjon.regler.domain.kode.YrkeYrkesskadeCti
import java.io.Serializable
import java.util.*

/**
 * Grunnlagsdata for yrkesskade. Denne er et tillegg til Uforegrunnlag. Hvis
 * dette objektet finnes (!=null) må det finnes et Uforegrunnlag. Dersom dette
 * objektet er null og Uforegrunnlaget != null betyr det at personen ikke har
 * yrkesskade.
 */
class Yrkesskadegrunnlag : Serializable {
    /**
     * Dato for skadetidspunkt.
     */
    var yst: Date? = null

    /**
     * Uføregrad ved yrkesskade, heltall 0-100.Kan ikke være større enn
     * Uføregraden(ufg).For avdød pga yrkesskade settes yug til 100.
     */
    var yug = 0

    /**
     * Angir om yrkesskaden skyldes yrkessykdom.
     */
    var yrkessykdom = false

    /**
     * Det er en minimumsgaranti mht poengtall for som gjelder for spesielle
     * yrkesgrupper, f.eks fiskere,fangstmenn, militære,ungdom under utdanning
     * osv.
     */
    var yrke: YrkeYrkesskadeCti? = null
    var yrkeEnum: YrkeYrkesskadeEnum? = null

    /**
     * Bruker forsørget av avdød iht paragraf 17-12.2
     */
    var brukerForsorgetAvAnnen = false

    /**
     * Antatt årlig inntekt på skadetidspunktet.
     */
    var antattArligInntekt = 0

    /**
     * Angir om yrkesskadegrunnlaget brukes som grunnlag på kravet.
     */
    var bruk: Boolean = true
}