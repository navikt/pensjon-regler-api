package no.nav.service.pensjon.regler.to;

import java.util.Date;

import no.nav.domain.pensjon.regler.krav.Kravhode;

public class VilkarsprovAlderpensjonForsteUttakRequest extends ServiceRequest {
	

	private Kravhode kravhode;
	private Date fom;
	private int uttaksgrad;
	private double ft;
	private double ft67Soker;
	private double ft67SokerMinus1;
	private double ft67Virk;
	private double ft67VirkMinus1;


}
