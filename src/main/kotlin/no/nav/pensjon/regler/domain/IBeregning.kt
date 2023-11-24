package no.nav.pensjon.regler.domain

import no.nav.pensjon.regler.domain.beregning.BeregningRelasjon

/**
 * Felles interface for Beregning og Beregning2011 klasser.
 */
interface IBeregning {
    val delberegningsListe: MutableList<BeregningRelasjon>
}