package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.Pakkseddel
import java.io.Serializable


abstract class ServiceResponse(
    open val pakkseddel: Pakkseddel = Pakkseddel(),
) : Serializable