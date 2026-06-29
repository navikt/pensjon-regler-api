package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.vedtak.InntektEtterUforhet
import no.nav.pensjon.regler.domain.vedtak.InntektForUforhet

/**
 * Respons fra tjenesten som beregner inntekt etter uførhet (IEU) for beslutningsstøtte.
 *
 * **[inntektEtterUførhet]** kan ha tre tilstander etter at tjenesten er kjørt:
 * 1. Uendret – IEU er lik den som ble sendt inn til tjenesten (ingen endring har skjedd).
 * 2. Oppjustert til virk – IEU er oppjustert til virkningstidspunktet, men ikke beregnet av tjenesten
 *    da det ikke var nødvendig for å beholde en tidligere uføregrad. Flagget [ieuOppjustertTilVirk] vil da være `true`.
 * 3. Beregnet – IEU er beregnet av tjenesten for å oppnå et forhold mellom inntekt før uførhet og IEU
 *    som gjør at den tidligere gjeldende uføregraden på virkningstidspunktet videreføres.
 *    Flagget [ieuBeregnet] vil da være `true`.
 *
 * **[inntektFørUførhet]** kan ha to tilstander i responsen:
 * 1. Uendret – samme som input.
 * 2. Fastsatt på nytt og oppjustert til virk.
 *
 * @property ieuBeregnet `true` dersom IEU er beregnet av tjenesten for å videreføre tidligere gjeldende uføregrad.
 * @property ieuOppjustertTilVirk `true` dersom IEU er oppjustert til virkningstidspunktet uten ny beregning.
 * @property inntektEtterUførhet Inntekt etter uførhet – se klassedokumentasjonen for mulige tilstander.
 * @property inntektFørUførhet Inntekt før uførhet – enten uendret fra input eller fastsatt på nytt og oppjustert til virk.
 */
@Deprecated("Ikke lenger i bruk")
class BeslutningsstotteBeregnIEUForJan2026Response(
    val ieuBeregnet: Boolean,
    val ieuOppjustertTilVirk: Boolean,
    val inntektEtterUførhet: InntektEtterUforhet,
    val inntektFørUførhet: InntektForUforhet,
) : ServiceResponse()