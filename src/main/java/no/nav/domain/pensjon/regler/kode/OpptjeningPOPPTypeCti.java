package no.nav.domain.pensjon.regler.kode;

/*
 * Inntektstyper som POPP kjenner, bruker kodeverket K_OPPTJN_POPP_T
 * 
 * @author Swiddy de Louw - PK-7973 PKPYTON-526
 */

public class OpptjeningPOPPTypeCti extends TypeCti {

    private static final long serialVersionUID = 2903516942493488921L;

    public OpptjeningPOPPTypeCti() {
        super();
    }

    public OpptjeningPOPPTypeCti(String kode) {
        super(kode);
    }

    public OpptjeningPOPPTypeCti(OpptjeningPOPPTypeCti opptjeningPOPPTypeCti) {
        super(opptjeningPOPPTypeCti);
    }

}
