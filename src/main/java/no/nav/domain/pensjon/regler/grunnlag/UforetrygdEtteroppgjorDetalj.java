package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.GrunnlagsrolleCti;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UforetrygdEtteroppgjorDetalj implements Serializable {

    /**
     * Angir gyldighetsperioden for detaljen. Avgrenset av uf�reperioden og �ret som etteroppgj�rsgrunnlaget gjelder for.
     */
    private Date fomDato;

    /**
     * Liste over inntektsfratrekk for etteroppgj�ret (for perioder uten uf�retrygd og andre registrerte fradrag).
     */
    private List<Inntektsgrunnlag> fratrekk = new ArrayList<Inntektsgrunnlag>();

    /**
     * Kode som angir hvilken rolle personen har p� kravet. De ulike rollene er definert i Kodeverk, ark K_GRNL_ROLLE_T.
     */
    private GrunnlagsrolleCti grunnlagsrolle;

    /**
     * Liste over alle inntekter som skal benyttes i etteroppgj�ret.
     */
    private List<Inntektsgrunnlag> inntekter = new ArrayList<Inntektsgrunnlag>();

    /**
     * Angir gyldighetsperioden for detaljen. Avgrenset av uf�reperioden og �ret som etteroppgj�rsgrunnlaget gjelder for.
     */
    private Date tomDato;

}
