package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.Ytelseskomponent;
import no.nav.domain.pensjon.regler.kode.YtelsekomponentTypeCti;

/**
 * Endre navn fra "SamletEktefellerGarantitillegg" til "MinstenivatilleggPensjonistpar"
 */
public class MinstenivatilleggPensjonistpar extends Ytelseskomponent {


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
