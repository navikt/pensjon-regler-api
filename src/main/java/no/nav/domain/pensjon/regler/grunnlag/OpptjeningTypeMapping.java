package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.OpptjeningPOPPTypeCti;

import java.io.Serializable;

public class OpptjeningTypeMapping implements Serializable {



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
