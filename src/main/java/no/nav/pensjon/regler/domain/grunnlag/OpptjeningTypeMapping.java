package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.kode.OpptjeningPOPPTypeCti;

import java.io.Serializable;

public class OpptjeningTypeMapping implements Serializable {

    private static final long serialVersionUID = 1962065674443017560L;

    private OpptjeningPOPPTypeCti opptjeningPOPPTypeCti;

    public OpptjeningTypeMapping() {
    }

    //copy-constructor
    public OpptjeningTypeMapping(OpptjeningTypeMapping opptjeningTypeMapping) {
        if (opptjeningTypeMapping.opptjeningPOPPTypeCti != null) {
            opptjeningPOPPTypeCti = new OpptjeningPOPPTypeCti(opptjeningTypeMapping.getOpptjeningPOPPTypeCti());
        }
    }

    /**
     * @return the opptjeningPOPPTypeCti
     */
    public OpptjeningPOPPTypeCti getOpptjeningPOPPTypeCti() {
        return opptjeningPOPPTypeCti;
    }

    /**
     * @param opptjeningPOPPTypeCti the opptjeningPOPPTypeCti to set
     */
    public void setOpptjeningPOPPTypeCti(OpptjeningPOPPTypeCti opptjeningPOPPTypeCti) {
        this.opptjeningPOPPTypeCti = opptjeningPOPPTypeCti;
    }

}
