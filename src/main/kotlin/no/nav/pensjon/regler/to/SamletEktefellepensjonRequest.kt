package no.nav.pensjon.regler.to

import no.nav.pensjon.regler.domain.beregning.Beregning
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat
import no.nav.pensjon.regler.domain.krav.Kravhode
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak

class SamletEktefellepensjonRequest {
    var soker1Beregningsresultat: AbstraktBeregningsResultat? = null
    var soker2Beregningsresultat: AbstraktBeregningsResultat? = null
    var soker1Beregning: Beregning? = null
    var soker2Beregning: Beregning? = null
    var soker1BeregningsresultatAfpPrivat: BeregningsResultatAfpPrivat? = null
    var soker2BeregningsresultatAfpPrivat: BeregningsResultatAfpPrivat? = null
    var soker1Kravhode: Kravhode? = null
    var soker2Kravhode: Kravhode? = null
    var soker1Kravhode2011: Kravhode? = null
    var soker2Kravhode2011: Kravhode? = null
    var soker1VilkarsvedtakListe: MutableList<VilkarsVedtak> = mutableListOf()
    var soker2VilkarsvedtakListe: MutableList<VilkarsVedtak> = mutableListOf()
    var soker1VilkarsvedtakListe2011: MutableList<VilkarsVedtak> = mutableListOf()
    var soker2VilkarsvedtakListe2011: MutableList<VilkarsVedtak> = mutableListOf()
}