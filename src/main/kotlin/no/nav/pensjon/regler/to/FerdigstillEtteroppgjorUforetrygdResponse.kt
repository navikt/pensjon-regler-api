package no.nav.pensjon.regler.to


import no.nav.pensjon.regler.domain.vedtak.EtteroppgjorResultat


class FerdigstillEtteroppgjorUforetrygdResponse : ServiceResponse() {
    var etteroppgjorResultat: EtteroppgjorResultat? = null
}