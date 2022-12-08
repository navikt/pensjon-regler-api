package no.nav.domain.pensjon.regler.kode;

public class KravVelgTypeCti extends TypeCti {


    /**
     * Kode som angir detaljering av kravet.
     * Se K_KRAV_VELG_T
     */
    private boolean hovedKravlinje = false;

    /**
     * Copy Constructor
     * 
     * @param kravVelgTypeCti a <code>KravVelgTypeCti</code> object
     */
    public KravVelgTypeCti(KravVelgTypeCti kravVelgTypeCti) {
        super(kravVelgTypeCti);
        hovedKravlinje = kravVelgTypeCti.hovedKravlinje;
    }

    public KravVelgTypeCti() {
        super();
    }

    public KravVelgTypeCti(String kode) {
        super(kode);
    }

    public boolean isHovedKravlinje() {
        return hovedKravlinje;
    }

    public void setHovedKravlinje(boolean hovedKravlinje) {
        this.hovedKravlinje = hovedKravlinje;
    }

}
