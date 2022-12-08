package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.beregning2011.SisteBeregning1967;
import no.nav.domain.pensjon.regler.grunnlag.InfoPavirkendeYtelse;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

import java.util.Date;
import java.util.Vector;

public class RevurderingYtelse1967Request extends ServiceRequest {


    private Date virkFom;
    private Kravhode kravhode;
    private Vector<VilkarsVedtak> vilkarsvedtakListe;
    private SisteBeregning1967 sisteBeregning1967;
    private InfoPavirkendeYtelse infoPavirkendeYtelse;
    private boolean epsMottarPensjon;
    private boolean beregnForsorgingstillegg;
    private boolean beregnInstitusjonsopphold;



}
