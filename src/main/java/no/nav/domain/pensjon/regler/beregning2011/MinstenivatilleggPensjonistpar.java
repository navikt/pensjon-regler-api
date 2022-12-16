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

}
