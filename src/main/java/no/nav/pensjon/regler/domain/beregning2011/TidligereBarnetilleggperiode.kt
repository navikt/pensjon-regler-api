package no.nav.pensjon.regler.domain.beregning2011

class TidligereBarnetilleggperiode : AbstraktBarnetilleggperiode() {
    /**
     * Hva barnetillegget i tidligere periode faktisk ble avkortet med per år.
     */
    var faktiskFradragPerAr = 0.0

    /**
     * Periodens bidrag til avviksbeløp.
     */
    var avviksbelop = 0.0

}