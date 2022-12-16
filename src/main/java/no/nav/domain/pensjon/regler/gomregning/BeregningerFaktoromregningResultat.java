package no.nav.domain.pensjon.regler.gomregning;

import no.nav.domain.pensjon.regler.BatchStatus;
import no.nav.domain.pensjon.regler.beregning.Beregning;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeregningerFaktoromregningResultat implements Serializable {

    
    private Long vedtakId;
    private BatchStatus batchStatus;
    private List<Beregning> beregningResultatListe;

}
