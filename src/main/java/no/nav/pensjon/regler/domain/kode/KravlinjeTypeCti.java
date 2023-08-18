package no.nav.pensjon.regler.domain.kode;

public class KravlinjeTypeCti extends TypeCti {

    private static final long serialVersionUID = -2393857741445942723L;

    /**
     * Denne er true dersom kravet er en hovedytelse (AP, UP osv).Default false.
     */
    private boolean hovedKravlinje = false;

    /**
     * Copy Constructor
     * 
     * @param kravlinjeTypeCti a <code>KravlinjeTypeCti</code> object
     */
    public KravlinjeTypeCti(KravlinjeTypeCti kravlinjeTypeCti) {
        super(kravlinjeTypeCti);
        hovedKravlinje = kravlinjeTypeCti.hovedKravlinje;
    }

    public KravlinjeTypeCti() {
        super();
    }

    public KravlinjeTypeCti(String kode) {
        super(kode);
    }

    public boolean isHovedKravlinje() {
        return hovedKravlinje;
    }

    public void setHovedKravlinje(boolean hovedKravlinje) {
        this.hovedKravlinje = hovedKravlinje;
    }

}
