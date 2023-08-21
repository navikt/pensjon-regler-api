package no.nav.pensjon.regler.domain.kode;

/**
 * @author Steinar Hjellvik (Decisive) - PK-11391
 */
public class BeregningGjelderTypeCti extends TypeCti {

    private static final long serialVersionUID = -3297680816990583767L;

    public BeregningGjelderTypeCti() {
        super();
    }

    public BeregningGjelderTypeCti(String kode) {
        super(kode);
    }

    public BeregningGjelderTypeCti(TypeCti typeCti) {
        super(typeCti);
    }
}
