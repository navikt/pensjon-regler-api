package no.nav.pensjon.regler.domain.kode;

/**
 * Tilsvarer kodeverktype K_JUST_PERIODE.
 */
public class JustertPeriodeCti extends TypeCti {

    private static final long serialVersionUID = -7989873544574196759L;

    public JustertPeriodeCti() {
        super();
    }

    public JustertPeriodeCti(String kode) {
        super(kode);
    }

    public JustertPeriodeCti(JustertPeriodeCti justertPeriodeCti) {
        super(justertPeriodeCti);
    }
}
