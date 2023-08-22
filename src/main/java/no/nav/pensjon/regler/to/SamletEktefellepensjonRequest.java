package no.nav.pensjon.regler.to;


import java.util.ArrayList;
import java.util.List;

import no.nav.pensjon.regler.domain.beregning.Beregning;
import no.nav.pensjon.regler.domain.beregning2011.AbstraktBeregningsResultat;
import no.nav.pensjon.regler.domain.beregning2011.BeregningsResultatAfpPrivat;
import no.nav.pensjon.regler.domain.krav.Kravhode;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

public class SamletEktefellepensjonRequest extends ServiceRequest {
	private static final long serialVersionUID = 2620310836634304154L;
	private AbstraktBeregningsResultat soker1Beregningsresultat;
	private AbstraktBeregningsResultat soker2Beregningsresultat;
	private Beregning soker1Beregning;
	private Beregning soker2Beregning;
	private BeregningsResultatAfpPrivat soker1BeregningsresultatAfpPrivat;
	private BeregningsResultatAfpPrivat soker2BeregningsresultatAfpPrivat;
	private Kravhode soker1Kravhode;
	private Kravhode soker2Kravhode;
	private Kravhode soker1Kravhode2011;
	private Kravhode soker2Kravhode2011;
	private List<VilkarsVedtak> soker1VilkarsvedtakListe = new ArrayList<VilkarsVedtak>();
	private List<VilkarsVedtak> soker2VilkarsvedtakListe = new ArrayList<VilkarsVedtak>();
	private List<VilkarsVedtak> soker1VilkarsvedtakListe2011 = new ArrayList<VilkarsVedtak>();
	private List<VilkarsVedtak> soker2VilkarsvedtakListe2011 = new ArrayList<VilkarsVedtak>();
	 
	public Kravhode getSoker1Kravhode2011() {
		return soker1Kravhode2011;
	}

	public void setSoker1Kravhode2011(Kravhode soker1Kravhode2011) {
		this.soker1Kravhode2011 = soker1Kravhode2011;
	}

	public List<VilkarsVedtak> getSoker1VilkarsvedtakListe() {
		return soker1VilkarsvedtakListe;
	}

	public void setSoker1VilkarsvedtakListe(
			List<VilkarsVedtak> soker1VilkarsvedtakListe) {
		this.soker1VilkarsvedtakListe = soker1VilkarsvedtakListe;
	}

	public List<VilkarsVedtak> getSoker1VilkarsvedtakListe2011() {
		return soker1VilkarsvedtakListe2011;
	}

	public void setSoker1VilkarsvedtakListe2011(
			List<VilkarsVedtak> soker1VilkarsvedtakListe2011) {
		this.soker1VilkarsvedtakListe2011 = soker1VilkarsvedtakListe2011;
	}

	public Kravhode getSoker2Kravhode2011() {
		return soker2Kravhode2011;
	}

	public void setSoker2Kravhode2011(Kravhode soker2Kravhode2011) {
		this.soker2Kravhode2011 = soker2Kravhode2011;
	}

	public List<VilkarsVedtak> getSoker2VilkarsvedtakListe() {
		return soker2VilkarsvedtakListe;
	}

	public void setSoker2VilkarsvedtakListe(
			List<VilkarsVedtak> soker2VilkarsvedtakListe) {
		this.soker2VilkarsvedtakListe = soker2VilkarsvedtakListe;
	}

	public List<VilkarsVedtak> getSoker2VilkarsvedtakListe2011() {
		return soker2VilkarsvedtakListe2011;
	}

	public void setSoker2VilkarsvedtakListe2011(
			List<VilkarsVedtak> soker2VilkarsvedtakListe2011) {
		this.soker2VilkarsvedtakListe2011 = soker2VilkarsvedtakListe2011;
	}
	public BeregningsResultatAfpPrivat getSoker1BeregningsresultatAfpPrivat() {
		return soker1BeregningsresultatAfpPrivat;
	}

	public void setSoker1BeregningsresultatAfpPrivat(
			BeregningsResultatAfpPrivat soker1BeregningsresultatAfpPrivat) {
		this.soker1BeregningsresultatAfpPrivat = soker1BeregningsresultatAfpPrivat;
	}

	public BeregningsResultatAfpPrivat getSoker2BeregningsresultatAfpPrivat() {
		return soker2BeregningsresultatAfpPrivat;
	}

	public void setSoker2BeregningsresultatAfpPrivat(
			BeregningsResultatAfpPrivat soker2BeregningsresultatAfpPrivat) {
		this.soker2BeregningsresultatAfpPrivat = soker2BeregningsresultatAfpPrivat;
	}

	public Kravhode getSoker1Kravhode() {
		return soker1Kravhode;
	}

	public void setSoker1Kravhode(Kravhode soker1Kravhode) {
		this.soker1Kravhode = soker1Kravhode;
	}

	public Kravhode getSoker2Kravhode() {
		return soker2Kravhode;
	}

	public void setSoker2Kravhode(Kravhode soker2Kravhode) {
		this.soker2Kravhode = soker2Kravhode;
	}

	public SamletEktefellepensjonRequest() {
		
	}
	
	public AbstraktBeregningsResultat getSoker1Beregningsresultat() {
		return soker1Beregningsresultat;
	}
	
	public void setSoker1Beregningsresultat(AbstraktBeregningsResultat soker1BeregningsResultat) {
		this.soker1Beregningsresultat = soker1BeregningsResultat;
	}
	
	
	public AbstraktBeregningsResultat getSoker2Beregningsresultat() {
		return soker2Beregningsresultat;
	}
	
	public void setSoker2Beregningsresultat(AbstraktBeregningsResultat soker2BeregningsResultat) {
		this.soker2Beregningsresultat = soker2BeregningsResultat;
	}
	public Beregning getSoker1Beregning() {
		return soker1Beregning;
	}
	
	public void setSoker1Beregning(Beregning soker1Beregning) {
		this.soker1Beregning = soker1Beregning;
	}
	public Beregning getSoker2Beregning() {
		return soker2Beregning;
	}
	
	public void setSoker2Beregning(Beregning soker2Beregning) {
		this.soker2Beregning = soker2Beregning;
	}
	
}
