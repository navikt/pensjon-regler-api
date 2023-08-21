package no.nav.pensjon.regler.domain.kode;

/**
 * Beskriver hvorvidt saksbehandler mener vilk�r er oppfylt.
 */
public class VilkarOppfyltUTCti extends TypeCti {

    private static final long serialVersionUID = -2622522900456746970L;

    public VilkarOppfyltUTCti() {
        super();
    }

    public VilkarOppfyltUTCti(String kode) {
        super(kode);
    }

    public VilkarOppfyltUTCti(VilkarOppfyltUTCti vilkarOppfyltUTCti) {
        super(vilkarOppfyltUTCti);
    }
}