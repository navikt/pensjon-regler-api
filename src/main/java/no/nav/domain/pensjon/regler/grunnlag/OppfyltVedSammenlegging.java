package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.AvtalelandCti;

import java.io.Serializable;

public class OppfyltVedSammenlegging implements Serializable {

    

    /**
     * Angir om kriteriet er oppfylt eller ikke.
     */
    boolean oppfylt;

    /**
     * Angir avtaleland.
     */
    AvtalelandCti avtaleland;

    /**
     * Copy Constructor
     * 
     * @param oppfyltVedSammenlegging a <code>OppfyltVedSammenlegging</code> object
     */
    public OppfyltVedSammenlegging(OppfyltVedSammenlegging oppfyltVedSammenlegging) {
        oppfylt = oppfyltVedSammenlegging.oppfylt;
        if (oppfyltVedSammenlegging.avtaleland != null) {
            avtaleland = new AvtalelandCti(oppfyltVedSammenlegging.avtaleland);
        }
    }

    public OppfyltVedSammenlegging() {
    }

    public OppfyltVedSammenlegging(boolean oppfylt, AvtalelandCti avtaleland) {
        super();
        this.oppfylt = oppfylt;
        this.avtaleland = avtaleland;
    }

    public AvtalelandCti getAvtaleland() {
        return avtaleland;
    }

    public void setAvtaleland(AvtalelandCti avtaleland) {
        this.avtaleland = avtaleland;
    }

    public boolean isOppfylt() {
        return oppfylt;
    }

    public void setOppfylt(boolean oppfylt) {
        this.oppfylt = oppfylt;
    }

}
