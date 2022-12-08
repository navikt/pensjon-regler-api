package no.nav.service.pensjon.regler.to;

import java.util.ArrayList;
import java.util.Date;

import no.nav.domain.pensjon.regler.beregning2011.BeregningsResultatAfpPrivat;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

public class BeregnAfpPrivatRequest extends ServiceRequest  { 

	private Kravhode kravhode;
	private ArrayList<VilkarsVedtak> vilkarsvedtakListe;
	private Date virkFom;
	private double ft;
	private int justeringsbelop;
	private int referansebelop;
	private double ftKompensasjonstillegg;
	private BeregningsResultatAfpPrivat sisteAfpPrivatBeregning;
	private Date virkFomAfpPrivatUttak;

}
