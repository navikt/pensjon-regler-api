package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.enum.BorMedTypeEnum
import no.nav.pensjon.regler.domain.vedtak.InntektEtterUforhet
import no.nav.pensjon.regler.domain.vedtak.InntektForUforhet
import no.nav.pensjon.regler.domain.vedtak.Uforegrad
import no.nav.pensjon.regler.domain.vedtak.UngUfor
import java.time.LocalDate

class BeslutningsstotteBeregnIEUForJan2026Request(
    val inntektFørUførhet: InntektForUforhet,
    val virk: LocalDate,
    val uføregrad: Uforegrad,
    val inntektEtterUførhet: InntektEtterUforhet,
    val innUngUfør: UngUfor,
    val benyttetSivilstand: BorMedTypeEnum,
) : ServiceRequest()