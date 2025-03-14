package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.enum.FormelKodeEnum
import org.junit.Test
import kotlin.test.assertEquals

class GrunnpensjonTest {

    @Test
    fun `Skal bevare formelKode ved bruk av copy-constructor`() {
        val gp = Grunnpensjon()

        assertEquals(gp.formelKodeEnum, FormelKodeEnum.GPx)

        val gpCopy = Grunnpensjon(gp)

        assertEquals(gpCopy.formelKodeEnum, FormelKodeEnum.GPx)
    }
}