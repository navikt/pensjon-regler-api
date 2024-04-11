package no.nav.pensjon.regler.domain.beregning

import no.nav.pensjon.regler.domain.kode.FormelKodeCti
import org.junit.Test
import kotlin.test.assertEquals

class GrunnpensjonTest {

    @Test
    fun `Skal bevare formelKode ved bruk av copy-constructor`() {
        val gp = Grunnpensjon()

        assertEquals(gp.formelKode!!.kode, FormelKodeCti("GPx").kode)

        gp.formelKode = FormelKodeCti("BasGP1")

        val gpCopy = Grunnpensjon(gp)

        assertEquals(gpCopy.formelKode!!.kode, FormelKodeCti("BasGP1").kode)
    }
}