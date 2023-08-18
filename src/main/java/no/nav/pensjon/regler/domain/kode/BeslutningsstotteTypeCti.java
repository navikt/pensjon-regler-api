package no.nav.pensjon.regler.domain.kode;

/**
 * Beskriver type besluttningsstøtte som skal eksekveres
 * 
 * @author Swiddy de Louw (Capgemini) - PK7973 - PKPYTON-526
 */

public class BeslutningsstotteTypeCti extends TypeCti {

    private static final long serialVersionUID = 5423160842906274730L;

    public BeslutningsstotteTypeCti() {
        super();
    }

    public BeslutningsstotteTypeCti(String kode) {
        super(kode);
    }

    public BeslutningsstotteTypeCti(BeslutningsstotteTypeCti beslutningsstotteTypeCti) {
        super(beslutningsstotteTypeCti);
    }
}
