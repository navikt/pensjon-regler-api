package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.beregning.BeregningUforeperiode;
import no.nav.domain.pensjon.regler.grunnlag.Uforeperiode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* Ekstra informasjon til beregnet uf�retrygd. Brukes for at PREG skal beregne en uf�rehistorikk for uf�retrygd.
 * 
 * @author Swiddy de Louw (Capgemini) - PK-10228
 */
public class UforeEkstraUT implements Serializable {
    /*
     * Beregnede uf�reperioder for uf�retrygd.
     * Dette er uf�reperioder som beregnes av PREG, og ligger ved beregningen for en uf�retrygd.
     */
    private List<BeregningUforeperiode> beregnetUforeperiodeListe;

}
