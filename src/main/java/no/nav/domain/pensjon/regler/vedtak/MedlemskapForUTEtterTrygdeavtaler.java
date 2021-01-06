package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.grunnlag.OppfyltVedSammenlegging;

/**
 * @author Magnus Bakken (Accenture) PK-9695, PKPYTON-923
 */
public class MedlemskapForUTEtterTrygdeavtaler extends AbstraktVilkar{

    private static final long serialVersionUID = 397578692098996165L;

    /**
     * Inneholder informasjon om bruker har inngang gjennom sammenlegging av trygdetid i avtaleland og Norge.
     * Registreres manuelt av saksbehandler.
     */
    private OppfyltVedSammenlegging oppfyltVedSammenlegging;

    /**
     * Inneholder informasjon om bruker har inngang gjennom sammenlegging av trygdetid i avtaleland og Norge på minst 5 år.
     * Registreres manuelt av saksbehandler.
     */
    private OppfyltVedSammenlegging oppfyltVedSammenleggingFemAr;

    public MedlemskapForUTEtterTrygdeavtaler() {
        super();
    }

    /**
     * Kopikonstruktør
     * @param medlemskapForUTEtterTrygdeavtaler Objekt som skal kopieres.
     */
    public MedlemskapForUTEtterTrygdeavtaler(MedlemskapForUTEtterTrygdeavtaler medlemskapForUTEtterTrygdeavtaler) {
        super(medlemskapForUTEtterTrygdeavtaler);
        if(medlemskapForUTEtterTrygdeavtaler.oppfyltVedSammenlegging != null) {
            this.oppfyltVedSammenlegging = new OppfyltVedSammenlegging(medlemskapForUTEtterTrygdeavtaler.oppfyltVedSammenlegging);
        }
        if(medlemskapForUTEtterTrygdeavtaler.oppfyltVedSammenleggingFemAr != null) {
            this.oppfyltVedSammenleggingFemAr = new OppfyltVedSammenlegging(medlemskapForUTEtterTrygdeavtaler.oppfyltVedSammenleggingFemAr);
        }
    }

    public MedlemskapForUTEtterTrygdeavtaler(OppfyltVedSammenlegging oppfyltVedSammenlegging) {
        super();
        this.oppfyltVedSammenlegging = oppfyltVedSammenlegging;
    }

    /**
     *
     * @param abs MedlemskapForUTEtterTrygdeavtaler som skal kopieres.
     * @return Kopi av input dersom av klassen GarantertUngUforVilkar, null ellers.
     */
    @Override
    public AbstraktVilkar dypKopi(AbstraktVilkar abs) {
        MedlemskapForUTEtterTrygdeavtaler mut = null;
        if(abs.getClass() == MedlemskapForUTEtterTrygdeavtaler.class) {
            mut = new MedlemskapForUTEtterTrygdeavtaler((MedlemskapForUTEtterTrygdeavtaler) abs);
        }
        return mut;
    }

    public OppfyltVedSammenlegging getOppfyltVedSammenlegging() {
        return oppfyltVedSammenlegging;
    }

    public void setOppfyltVedSammenlegging(OppfyltVedSammenlegging oppfyltVedSammenlegging) {
        this.oppfyltVedSammenlegging = oppfyltVedSammenlegging;
    }

    public OppfyltVedSammenlegging getOppfyltVedSammenleggingFemAr() {
        return oppfyltVedSammenleggingFemAr;
    }

    public void setOppfyltVedSammenleggingFemAr(OppfyltVedSammenlegging oppfyltVedSammenleggingFemAr) {
        this.oppfyltVedSammenleggingFemAr = oppfyltVedSammenleggingFemAr;
    }
}
