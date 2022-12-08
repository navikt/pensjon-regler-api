package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.BeregningUforeperiode;
import no.nav.domain.pensjon.regler.grunnlag.Uforeperiode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* Ekstra informasjon til beregnet uføretrygd. Brukes for at PREG skal beregne en uførehistorikk for uføretrygd.
 * 
 * @author Swiddy de Louw (Capgemini) - PK-10228
 */
public class UforeEkstraUT implements Serializable {
    /*
     * Beregnede uføreperioder for uføretrygd.
     * Dette er uføreperioder som beregnes av PREG, og ligger ved beregningen for en uføretrygd.
     */
    private List<BeregningUforeperiode> beregnetUforeperiodeListe;

}
