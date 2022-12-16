package no.nav.domain.pensjon.regler.gomregning;

import no.nav.domain.pensjon.regler.BatchStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KravFaktoromregningResultat implements Serializable {


    private Long kravId;
    private BatchStatus batchStatus;
    private List<PersongrunnlagOmregningResultat> persongrunnlagOmregningResultatListe;



}
