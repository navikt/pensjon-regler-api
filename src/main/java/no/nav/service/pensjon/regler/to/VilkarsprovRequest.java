package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import no.nav.domain.pensjon.regler.beregning2011.SisteBeregning;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

public class VilkarsprovRequest extends ServiceRequest{
	private  Kravhode kravhode;
    private SisteBeregning sisteBeregning;
	private Date fom;
	private Date tom;
	private List<VilkarsVedtak>  vilkarsvedtakliste;

}
