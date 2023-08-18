package no.nav.pensjon.regler.to;

import no.nav.pensjon.regler.domain.krav.Kravhode;

import java.util.Date;

public class VilkarsprovForsorgingstilleggRequest extends ServiceRequest {
    private Kravhode kravhode;
    private Date virkFom;
    private Date virkTom;

    public VilkarsprovForsorgingstilleggRequest() {
        super();
    }

    public VilkarsprovForsorgingstilleggRequest(Kravhode kravhode, Date virkFom, Date virkTom) {
        super();
        this.kravhode = kravhode;
        this.virkFom = virkFom;
        this.virkTom = virkTom;
    }

    public Kravhode getKravhode() {
        return kravhode;
    }

    public void setKravhode(Kravhode kravhode) {
        this.kravhode = kravhode;
    }

    public Date getVirkFom() {
        return virkFom;
    }

    public void setVirkFom(Date virkFom) {
        this.virkFom = virkFom;
    }

    public Date getVirkTom() {
        return virkTom;
    }

    public void setVirkTom(Date virkTom) {
        this.virkTom = virkTom;
    }
}
