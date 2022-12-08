package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.Pakkseddel;
import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegulerBeregningGrunnlag implements Serializable {
    private Beregning beregning1967;
    private Date virkFom;
    private List<Uttaksgrad> uttaksgradListe = new ArrayList<Uttaksgrad>();
    private List<VilkarsVedtak> brukersVilkarsvedtakListe = new ArrayList<VilkarsVedtak>();
    private Persongrunnlag sokersPersongrunnlag;
    private Persongrunnlag epsPersongrunnlag;
    private Pakkseddel pakkseddel;

}
