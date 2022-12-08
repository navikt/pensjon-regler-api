package no.nav.service.pensjon.regler.to;

import java.util.Date;


import no.nav.domain.pensjon.regler.kode.SatsTypeCti;

public class HentGyldigSatsRequest extends ServiceRequest {
	private Date fomDato;
	private Date tomDato;
	private SatsTypeCti satsType;
    private boolean beregnetSomGift;
    private boolean forsorgerEPSOver60;
    private boolean ungUfor;

}
