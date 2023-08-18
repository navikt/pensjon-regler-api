package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.beregning.Sertillegg;
import no.nav.pensjon.regler.domain.kode.Fravik_19_3Cti;
import no.nav.pensjon.regler.domain.kode.PoengtilleggCti;

import java.io.Serializable;

/**
 * Generell historisk info for en bruker
 */
public class GenerellHistorikk implements Serializable {

    private static final long serialVersionUID = 5849795916324857224L;
    /**
     * Identifikasjon av den generelle historikken
     */
    private Long generellHistorikkId;
    /*
     * Koder som sier hvilken trygdetid som skal brukes i beregning n�r f�rste virk er f�r 1991.
     * Brukes i utenlandssaker der pensjonisten kan f� godskrevet trygdetid opptjent i utlandet f�r 1967.
     */
    private Fravik_19_3Cti fravik_19_3;
    /*
     * Gjennomsnittlig uf�regrad - E�S.
     */
    private Double fpp_eos;
    /**
     * Ventetilleggsgrunnlag
     */
    private Ventetilleggsgrunnlag ventetilleggsgrunnlag;

    private PoengtilleggCti poengtillegg;

    /*
     * Inneholder informasjon ang tidligere E�S beregninger. Brukes ved konvertering til AP.
     */
    private EosEkstra eosEkstra;

    /**
     * Innholder trygdetidsgarantien for ektefeller som g�r under gammel lov f�r 1.1.1991
     */
    private GarantiTrygdetid garantiTrygdetid;

    /* CR175446 - 1943 konvertert AP1967 til AP2011 */
    /* S�rtillegget brukeren hadde p� AP1967-ytelsen (settes lik null om han ikke hadde s�rtillegg) */
    private Sertillegg sertillegg1943kull;

    /* CR175446 - Gift eller tilsvarende med samme person siden 31.12.2010 */
    private boolean giftFor2011;

    /**
     * Copy Constructor
     * 
     * @param generellHistorikk a <code>GenerellHistorikk</code> object
     */
    public GenerellHistorikk(GenerellHistorikk generellHistorikk) {
        if (generellHistorikk.generellHistorikkId != null) {
            generellHistorikkId = new Long(generellHistorikk.generellHistorikkId);
        }
        if (generellHistorikk.fravik_19_3 != null) {
            fravik_19_3 = new Fravik_19_3Cti(generellHistorikk.fravik_19_3);
        }
        if (generellHistorikk.fpp_eos != null) {
            fpp_eos = new Double(generellHistorikk.fpp_eos);
        }
        if (generellHistorikk.ventetilleggsgrunnlag != null) {
            ventetilleggsgrunnlag = new Ventetilleggsgrunnlag(generellHistorikk.ventetilleggsgrunnlag);
        }
        if (generellHistorikk.poengtillegg != null) {
            poengtillegg = new PoengtilleggCti(generellHistorikk.poengtillegg);
        }
        if (generellHistorikk.eosEkstra != null) {
            eosEkstra = new EosEkstra(generellHistorikk.eosEkstra);
        }
        if (generellHistorikk.garantiTrygdetid != null) {
            garantiTrygdetid = new GarantiTrygdetid(generellHistorikk.garantiTrygdetid);
        }
        if (generellHistorikk.sertillegg1943kull != null) {
            sertillegg1943kull = new Sertillegg(generellHistorikk.sertillegg1943kull);
        }
        if (generellHistorikk.giftFor2011) {
            giftFor2011 = true;
        }
    }

    public GenerellHistorikk() {
        super();
    }

    public GenerellHistorikk(Long generellHistorikkId, Fravik_19_3Cti fravik_19_3, Double fpp_eos, Ventetilleggsgrunnlag ventetilleggsgrunnlag, PoengtilleggCti poengtillegg,
                             EosEkstra eosEkstra) {
        super();
        this.generellHistorikkId = generellHistorikkId;
        this.fravik_19_3 = fravik_19_3;
        this.fpp_eos = fpp_eos;
        this.ventetilleggsgrunnlag = ventetilleggsgrunnlag;
        this.poengtillegg = poengtillegg;
        this.eosEkstra = eosEkstra;
    }

    public Double getFpp_eos() {
        return fpp_eos;
    }

    public void setFpp_eos(Double fpp_eos) {
        this.fpp_eos = fpp_eos;
    }

    public Fravik_19_3Cti getFravik_19_3() {
        return fravik_19_3;
    }

    public void setFravik_19_3(Fravik_19_3Cti fravik_19_3) {
        this.fravik_19_3 = fravik_19_3;
    }

    public Long getGenerellHistorikkId() {
        return generellHistorikkId;
    }

    public void setGenerellHistorikkId(Long generellHistorikkId) {
        this.generellHistorikkId = generellHistorikkId;
    }

    public Ventetilleggsgrunnlag getVentetilleggsgrunnlag() {
        return ventetilleggsgrunnlag;
    }

    public void setVentetilleggsgrunnlag(Ventetilleggsgrunnlag ventetilleggsgrunnlag) {
        this.ventetilleggsgrunnlag = ventetilleggsgrunnlag;
    }

    public PoengtilleggCti getPoengtillegg() {
        return poengtillegg;
    }

    public void setPoengtillegg(PoengtilleggCti poengtillegg) {
        this.poengtillegg = poengtillegg;
    }

    public EosEkstra getEosEkstra() {
        return eosEkstra;
    }

    public void setEosEkstra(EosEkstra eosEkstra) {
        this.eosEkstra = eosEkstra;
    }

    public GarantiTrygdetid getGarantiTrygdetid() {
        return garantiTrygdetid;
    }

    public void setGarantiTrygdetid(GarantiTrygdetid garantiTrygdetid) {
        this.garantiTrygdetid = garantiTrygdetid;
    }

    public Sertillegg getSertillegg1943kull() {
        return sertillegg1943kull;
    }

    public void setSertillegg1943kull(Sertillegg sertillegg1943kull) {
        this.sertillegg1943kull = sertillegg1943kull;
    }

    public boolean isGiftFor2011() {
        return giftFor2011;
    }

    public void setGiftFor2011(boolean giftFor2011) {
        this.giftFor2011 = giftFor2011;
    }
}
