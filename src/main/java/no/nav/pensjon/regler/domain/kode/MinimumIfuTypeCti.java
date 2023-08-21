package no.nav.pensjon.regler.domain.kode;

/**
 * Kodeverk for IfuType. Angir om bruker kvalifiserer til Minste-IFU sats som ung ufør, enslig eller gift
 *
 *  @author Frederik Rønnevig (Decisive) - PK-14979
 */
public class MinimumIfuTypeCti extends TypeCti {

    private static final long serialVersionUID = -3402648374017362058L;

    public MinimumIfuTypeCti() {
        super();
    }

    public MinimumIfuTypeCti(String kode) {
        super(kode);
    }

    public MinimumIfuTypeCti(TypeCti typeCti) {
        super(typeCti);
    }
}
