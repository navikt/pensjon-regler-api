package no.nav.pensjon.regler.domain.kode

class AFPetteroppgjorGruppeCti : TypeCti {
    constructor() : super()
    constructor(kode: String?) : super(kode)
    constructor(afpetteroppgjorGruppeCti: AFPetteroppgjorGruppeCti) : super(afpetteroppgjorGruppeCti)
}