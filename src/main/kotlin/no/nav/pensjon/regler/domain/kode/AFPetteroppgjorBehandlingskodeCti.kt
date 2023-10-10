package no.nav.pensjon.regler.domain.kode

class AFPetteroppgjorBehandlingskodeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(afpEtteroppgjorBehandlingskodeCti: AFPetteroppgjorBehandlingskodeCti) : super(
        afpEtteroppgjorBehandlingskodeCti
    )
}