package no.nav.service.pensjon.regler.to;

import java.util.Date;
import java.util.Vector;

import no.nav.domain.pensjon.regler.beregning.Beregning;
import no.nav.domain.pensjon.regler.beregning2011.AbstraktBeregningsResultat;
import no.nav.domain.pensjon.regler.beregning2011.AfpLivsvarig;
import no.nav.domain.pensjon.regler.beregning2011.BeregningsresultatUforetrygd;
import no.nav.domain.pensjon.regler.beregning2011.SisteAldersberegning2011;
import no.nav.domain.pensjon.regler.grunnlag.ForholdstallUtvalg;
import no.nav.domain.pensjon.regler.krav.Kravhode;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;
import no.stelvio.common.transferobject.ServiceRequest;

/**
 * @author PREG
 * @author Stian Kroknes (Accenture) PENPORT-1055
 * @author Nabil Safadi (Decisive) - PK-8518
 */
public class BeregnInstitusjonsoppholdRequest extends ServiceRequest {
	private static final long serialVersionUID = -5179568505316753324L;
	
	private Date fom;
	
	// bruker1 beregning1967
	private Beregning bruker1Beregning;
	private Kravhode bruker1Kravhode; 
	private Vector<VilkarsVedtak> bruker1VilkarsvedtakListe = new Vector<VilkarsVedtak>();
	
	// bruker1  beregningsResultat(dekker 2011,2016 og 2025)
	private AbstraktBeregningsResultat bruker1BeregningsResultat;
	private Kravhode bruker1Kravhode2011;
	private Vector<VilkarsVedtak> bruker1VilkarsvedtakListe2011 = new Vector<VilkarsVedtak>();
	private ForholdstallUtvalg bruker1ForholdstallUtvalg;
	private SisteAldersberegning2011 bruker1SisteAldersberegning2011;
    /* Informasjon om uføretrygdberegning for bruker1. Kun påkrevd dersom bruker1 har uføretrygd. */
    private BeregningsresultatUforetrygd bruker1BeregningsresultatUforetrygd;

    /* Informasjon om afpPrivatberegning for bruker1. Kun påkrevd dersom bruker1 har AfpPrivat. */
	private AfpLivsvarig bruker1afpLivsvarig;
	
	// bruker2 beregning1967
	private Beregning bruker2Beregning;
	private Kravhode bruker2Kravhode;
	private Vector<VilkarsVedtak> bruker2VilkarsvedtakListe = new Vector<VilkarsVedtak>();
	
	// bruker2  beregningsResultat(dekker 2011,2016 og 2025)
	private AbstraktBeregningsResultat bruker2BeregningsResultat;
	private Kravhode bruker2Kravhode2011;
	private Vector<VilkarsVedtak> bruker2VilkarsvedtakListe2011 = new Vector<VilkarsVedtak>();
	private ForholdstallUtvalg bruker2ForholdstallUtvalg;
	private SisteAldersberegning2011 bruker2SisteAldersberegning2011;

	/* Informasjon om afpPrivatberegning for bruker2. Kun påkrevd dersom bruker2 har AfpPrivat. */
	private AfpLivsvarig bruker2afpLivsvarig;
	
	public BeregnInstitusjonsoppholdRequest() {
		super();
	}

	public Beregning getBruker1Beregning() {
		return bruker1Beregning;
	}

	public void setBruker1Beregning(Beregning bruker1Beregning) {
		this.bruker1Beregning = bruker1Beregning;
	}

	public AbstraktBeregningsResultat getBruker1BeregningsResultat() {
		return bruker1BeregningsResultat;
	}

	public void setBruker1BeregningsResultat(
			AbstraktBeregningsResultat bruker1BeregningsResultat) {
		this.bruker1BeregningsResultat = bruker1BeregningsResultat;
	}

    public BeregningsresultatUforetrygd getBruker1BeregningsresultatUforetrygd() {
        return bruker1BeregningsresultatUforetrygd;
    }

    public void setBruker1BeregningsresultatUforetrygd(BeregningsresultatUforetrygd bruker1BeregningsresultatUforetrygd) {
        this.bruker1BeregningsresultatUforetrygd = bruker1BeregningsresultatUforetrygd;
    }

	public ForholdstallUtvalg getBruker1ForholdstallUtvalg() {
		return bruker1ForholdstallUtvalg;
	}

	public void setBruker1ForholdstallUtvalg(
			ForholdstallUtvalg bruker1ForholdstallUtvalg) {
		this.bruker1ForholdstallUtvalg = bruker1ForholdstallUtvalg;
	}

	public Kravhode getBruker1Kravhode() {
		return bruker1Kravhode;
	}

	public void setBruker1Kravhode(Kravhode bruker1Kravhode) {
		this.bruker1Kravhode = bruker1Kravhode;
	}

	public Kravhode getBruker1Kravhode2011() {
		return bruker1Kravhode2011;
	}

	public void setBruker1Kravhode2011(Kravhode bruker1Kravhode2011) {
		this.bruker1Kravhode2011 = bruker1Kravhode2011;
	}

	public Vector<VilkarsVedtak> getBruker1VilkarsvedtakListe() {
		return bruker1VilkarsvedtakListe;
	}

	public void setBruker1VilkarsvedtakListe(
			Vector<VilkarsVedtak> bruker1VilkarsvedtakListe) {
		this.bruker1VilkarsvedtakListe = bruker1VilkarsvedtakListe;
	}

	public Vector<VilkarsVedtak> getBruker1VilkarsvedtakListe2011() {
		return bruker1VilkarsvedtakListe2011;
	}

	public void setBruker1VilkarsvedtakListe2011(
			Vector<VilkarsVedtak> bruker1VilkarsvedtakListe2011) {
		this.bruker1VilkarsvedtakListe2011 = bruker1VilkarsvedtakListe2011;
	}

	public Beregning getBruker2Beregning() {
		return bruker2Beregning;
	}

	public void setBruker2Beregning(Beregning bruker2Beregning) {
		this.bruker2Beregning = bruker2Beregning;
	}

	public AbstraktBeregningsResultat getBruker2BeregningsResultat() {
		return bruker2BeregningsResultat;
	}

	public void setBruker2BeregningsResultat(
			AbstraktBeregningsResultat bruker2BeregningsResultat) {
		this.bruker2BeregningsResultat = bruker2BeregningsResultat;
	}

	public ForholdstallUtvalg getBruker2ForholdstallUtvalg() {
		return bruker2ForholdstallUtvalg;
	}

	public void setBruker2ForholdstallUtvalg(
			ForholdstallUtvalg bruker2ForholdstallUtvalg) {
		this.bruker2ForholdstallUtvalg = bruker2ForholdstallUtvalg;
	}

	public Kravhode getBruker2Kravhode() {
		return bruker2Kravhode;
	}

	public void setBruker2Kravhode(Kravhode bruker2Kravhode) {
		this.bruker2Kravhode = bruker2Kravhode;
	}

	public Kravhode getBruker2Kravhode2011() {
		return bruker2Kravhode2011;
	}

	public void setBruker2Kravhode2011(Kravhode bruker2Kravhode2011) {
		this.bruker2Kravhode2011 = bruker2Kravhode2011;
	}

	public Vector<VilkarsVedtak> getBruker2VilkarsvedtakListe() {
		return bruker2VilkarsvedtakListe;
	}

	public void setBruker2VilkarsvedtakListe(
			Vector<VilkarsVedtak> bruker2VilkarsvedtakListe) {
		this.bruker2VilkarsvedtakListe = bruker2VilkarsvedtakListe;
	}

	public Vector<VilkarsVedtak> getBruker2VilkarsvedtakListe2011() {
		return bruker2VilkarsvedtakListe2011;
	}

	public void setBruker2VilkarsvedtakListe2011(
			Vector<VilkarsVedtak> bruker2VilkarsvedtakListe2011) {
		this.bruker2VilkarsvedtakListe2011 = bruker2VilkarsvedtakListe2011;
	}

	public Date getFom() {
		return fom;
	}

	public void setFom(Date fom) {
		this.fom = fom;
	}

	public SisteAldersberegning2011 getBruker1SisteAldersberegning2011() {
		return bruker1SisteAldersberegning2011;
	}

	public void setBruker1SisteAldersberegning2011(SisteAldersberegning2011 bruker1SisteAldersberegning2011) {
		this.bruker1SisteAldersberegning2011 = bruker1SisteAldersberegning2011;
	}

	public SisteAldersberegning2011 getBruker2SisteAldersberegning2011() {
		return bruker2SisteAldersberegning2011;
	}

	public void setBruker2SisteAldersberegning2011(SisteAldersberegning2011 bruker2SisteAldersberegning2011) {
		this.bruker2SisteAldersberegning2011 = bruker2SisteAldersberegning2011;
	}

	public AfpLivsvarig getBruker1afpLivsvarig() {
		return bruker1afpLivsvarig;
	}

	public void setBruker1afpLivsvarig(AfpLivsvarig bruker1afpLivsvarig) {
		this.bruker1afpLivsvarig = bruker1afpLivsvarig;
	}

	public AfpLivsvarig getBruker2afpLivsvarig() {
		return bruker2afpLivsvarig;
	}

	public void setBruker2afpLivsvarig(AfpLivsvarig bruker2afpLivsvarig) {
		this.bruker2afpLivsvarig = bruker2afpLivsvarig;
	}

	/**
	 * Read only property for bruker1VilkarsvedtakListe as array
	 * @return array of VilkarsVedtak
	 */
	public VilkarsVedtak[] getBruker1VilkarsvedtakListeAsArray() {
		return (bruker1VilkarsvedtakListe != null ? this.bruker1VilkarsvedtakListe.toArray(new VilkarsVedtak[this.bruker1VilkarsvedtakListe.size()]) : new VilkarsVedtak[0]);
	}
	/**
	 * Read only property for bruker1VilkarsvedtakListe2011 as array
	 * @return array of VilkarsVedtak
	 */
	public VilkarsVedtak[] getBruker1VilkarsvedtakListe2011AsArray() {
		return (bruker1VilkarsvedtakListe2011 != null ? this.bruker1VilkarsvedtakListe2011.toArray(new VilkarsVedtak[this.bruker1VilkarsvedtakListe2011.size()]) : new VilkarsVedtak[0]);
	}
	/**
	 * Read only property for bruker2VilkarsvedtakListe as array
	 * @return array of VilkarsVedtak
	 */
	public VilkarsVedtak[] getBruker2VilkarsvedtakListeAsArray() {
		return (bruker2VilkarsvedtakListe != null ? this.bruker2VilkarsvedtakListe.toArray(new VilkarsVedtak[this.bruker2VilkarsvedtakListe.size()]) : new VilkarsVedtak[0]);
	}
	/**
	 * Read only property for bruker2VilkarsvedtakListe2011 as array
	 * @return array of VilkarsVedtak
	 */
	public VilkarsVedtak[] getBruker2VilkarsvedtakListe2011AsArray() {
		return (bruker2VilkarsvedtakListe2011 != null ? this.bruker2VilkarsvedtakListe2011.toArray(new VilkarsVedtak[this.bruker2VilkarsvedtakListe2011.size()]) : new VilkarsVedtak[0]);
	}
}