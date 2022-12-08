package no.nav.service.pensjon.regler.to;

import no.nav.domain.pensjon.regler.krav.Kravhode;

import java.util.Date;

public class VilkarsprovForsorgingstilleggRequest extends ServiceRequest {
    private Kravhode kravhode;
    private Date virkFom;
    private Date virkTom;

}
