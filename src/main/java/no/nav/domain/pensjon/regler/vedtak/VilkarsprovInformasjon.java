package no.nav.domain.pensjon.regler.vedtak;

import no.nav.domain.pensjon.regler.beregning2011.AfpLivsvarig;
import no.nav.domain.pensjon.regler.beregning2011.FremskrevetAfpLivsvarig;
import no.nav.domain.pensjon.regler.beregning2011.FremskrevetPensjonUnderUtbetaling;
import no.nav.domain.pensjon.regler.beregning2011.PensjonUnderUtbetaling;

import java.io.Serializable;

public abstract class VilkarsprovInformasjon implements Serializable {


    private boolean ektefelleInntektOver2g = false;
    private boolean flyktning = false;
    private FremskrevetPensjonUnderUtbetaling fullPensjonVed67;
    private PensjonUnderUtbetaling pensjonVedUttak;
    private FremskrevetAfpLivsvarig fremskrevetAfpLivsvarig;
    private AfpLivsvarig afpLivsvarigVedUttak;
    private boolean afpLivsvarigBrukt;
    private double fremskrevetPensjonVed67;
    private double samletPensjonVed67PerAr;



}
