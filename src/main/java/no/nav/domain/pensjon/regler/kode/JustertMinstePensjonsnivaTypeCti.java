package no.nav.domain.pensjon.regler.kode;

public class JustertMinstePensjonsnivaTypeCti extends TypeCti {

    private static final long serialVersionUID = 2562762958299802189L;

    public JustertMinstePensjonsnivaTypeCti() {
        super();
    }

    public JustertMinstePensjonsnivaTypeCti(String kode) {
        super(kode);
    }

    public JustertMinstePensjonsnivaTypeCti(JustertMinstePensjonsnivaTypeCti fremskrevetMPNTypeCti) {
        super(fremskrevetMPNTypeCti);
    }

}
