package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat


class BeregnForsorgingstilleggResponse : ServiceResponse() {
    /**
     * Kopi av Brukerens originale beregning tillagt eventuelt nye ytelseskomponenter.
     * Vil bli returnert som resultat dersom denne kommer inn som input.
     */
    var beregningSoker: Beregning? = null

    /**
     * Det overordnete objektet som inneholder hele resultatet av beregningen tillagt eventuelt
     * nye ytelseskomponenter. Vil bli returnert som resultat dersom det ikke kom noen
     * type:Beregning som input.
     */
    var beregningsResultatSoker: AbstraktBeregningsResultat? = null
}