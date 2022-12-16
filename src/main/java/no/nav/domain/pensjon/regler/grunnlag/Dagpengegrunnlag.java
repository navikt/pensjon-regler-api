package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.DagpengeTypeCti;

import java.io.Serializable;

public class Dagpengegrunnlag implements Serializable {


    private int ar;
    private DagpengeTypeCti dagpengeType;
    private int uavkortetDagpengegrunnlag;
    private int utbetalteDagpenger;
    private int ferietillegg;
    private int barnetillegg;

}
