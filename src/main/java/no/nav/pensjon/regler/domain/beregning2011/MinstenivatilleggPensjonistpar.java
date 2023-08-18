package no.nav.pensjon.regler.domain.beregning2011;

import no.nav.pensjon.regler.domain.beregning.Ytelseskomponent;
import no.nav.pensjon.regler.domain.kode.YtelsekomponentTypeCti;

/**
 * Endre navn fra "SamletEktefellerGarantitillegg" til "MinstenivatilleggPensjonistpar"
 */
public class MinstenivatilleggPensjonistpar extends Ytelseskomponent {
    private static final long serialVersionUID = -21825212890064833L;

    private BeregningsInformasjonMinstenivatilleggPensjonistpar bruker;
    private BeregningsInformasjonMinstenivatilleggPensjonistpar ektefelle;

    public MinstenivatilleggPensjonistpar() {
        super();
        ytelsekomponentType = new YtelsekomponentTypeCti("MIN_NIVA_TILL_PPAR");
    }

    public MinstenivatilleggPensjonistpar(MinstenivatilleggPensjonistpar mintpp) {
        super(mintpp);
        if (mintpp.ektefelle != null) {
            ektefelle = new BeregningsInformasjonMinstenivatilleggPensjonistpar(mintpp.ektefelle);
        }
        if (mintpp.bruker != null) {
            bruker = new BeregningsInformasjonMinstenivatilleggPensjonistpar(mintpp.bruker);
        }
        ytelsekomponentType = new YtelsekomponentTypeCti("MIN_NIVA_TILL_PPAR");
    }

    public BeregningsInformasjonMinstenivatilleggPensjonistpar getBruker() {
        return bruker;
    }

    public void setBruker(BeregningsInformasjonMinstenivatilleggPensjonistpar bruker) {
        this.bruker = bruker;
    }

    public BeregningsInformasjonMinstenivatilleggPensjonistpar getEktefelle() {
        return ektefelle;
    }

    public void setEktefelle(BeregningsInformasjonMinstenivatilleggPensjonistpar ektefelle) {
        this.ektefelle = ektefelle;
    }

}
