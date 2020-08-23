package no.nav.domain.pensjon.regler.beregning;

import no.nav.domain.pensjon.regler.Merknad;
import no.nav.domain.pensjon.regler.util.ToStringUtil;

import java.io.Serializable;
import java.util.*;

public class Poengrekke implements Serializable {

    private static final long serialVersionUID = 6673001634969134436L;

    /**
     * Antall poengår totalt. Kan være ikke være over 40.
     */
    private int pa;

    /**
     * Antall poengår før 1992.
     */
    private int pa_f92;

    /**
     * Antall poengår etter 1991.
     */
    private int pa_e91;

    /**
     * Faktiske poengår i Norge.
     */
    private int pa_fa_norge;

    /**
     * Tidligere pensjonsgivende inntekt.
     */
    private int tpi;

    /**
     * Liste av Poengtall
     */
    private List<Poengtall> poengtallListe;

    /**
     * Samlet antall poengår i Norge.
     */
    private int pa_no;

    /**
     * Framtidig pensjonspoengtall. Brukes ved beregning av
     * uførepensjon,gjenlevendepensjon og AFP.
     */
    private FramtidigPensjonspoengtall fpp;

    /**
     * Framtidig pensjonspoengtall, basert på omregnet poengrekke. Brukes ved
     * beregning av uførepensjon og gjenlevendepensjon.
     */
    private FramtidigPensjonspoengtall fpp_omregnet;

    /**
     * Siste poengår med framtidig pensjonspoeng.
     */
    private int siste_fpp_aar;

    /**
     * Tidligere pensjonsgivende inntekt, beregnet som en faktor.
     */
    private double tpi_faktor;

    /**
     * Brutto antall framtidige poengår i norden.
     */
    private int pa_nordisk_framt_brutto;

    /**
     * Netto antall framtidige poengår i norden.
     */
    private int pa_nordisk_framt_netto;

    /**
     * Poengtall ut fra antatt årlig inntekt.
     */
    private double paa;

    /**
     * Faktiske poengår i Norden.
     */
    private int pa_fa_norden;

    /**
     * Teoretiske poengår EØS. Dette begrepet brukes ved beregning av
     * tilleggspensjon etter EØS-reglene eller ved beregning etter de bilaterale
     * avtalene. Ved pro rata beregningen fastsettes det teoretiske antallet
     * poengår som det antall år vedkommende ville fått dersom all opptjening i
     * EØS-land hadde vært opptjent i Norge
     */
    private int pa_eos_teoretisk;

    /**
     * Pro-rata poengår EØS. Poengår som ikke skal inngå i pro-rata beregning er
     * utelatt.
     */
    private int pa_eos_pro_rata;

    /**
     * Teller i pro-rata brøk.
     */
    private int pa_pro_rata_teller;

    /**
     * Nevner i pro-rata brøk.
     */
    private int pa_pro_rata_nevner;

    /**
     * Antall fremtidige poengår.
     */
    private int fpa;

    /**
     * Liste av merknader.
     */
    private List<Merknad> merknadListe;

    /**
     * Angir om omregnet FPP skal benyttes i godskrivning av framtidige år.
     * Intern PREG variabel.
     */
    private boolean PREG_bevarFPPgrunnlag;

    /**
     * Angir hvilket år poengrekken regnes fra. Intern PREG variabel.
     */
    private int PREG_startar;

    /**
     * Angir hvilket år ordinære poeng regnes til. Intern PREG variabel.
     */
    private int PREG_tilar;

    /**
     * Angir hvilken dato ordinære poeng regnes til. Intern PREG variabel.
     */
    private Date PREG_tildato;

    /**
     * Angir hvilket år fremtidige poeng regnes til. Intern PREG variabel.
     */
    private int PREG_sluttar;

    /**
     * Angir om FPP skal beregnes. Intern PREG variabel.
     */
    private boolean PREG_vilkar3_17;

    /**
     * Angir om FPP ikke skal omregnes til under 5. Intern PREG variabel.
     */
    private boolean PREG_FPPomregnetGaranti;

    /**
     * Antall poengår etter 1991 og etter det 66. året. Intern PREG variabel.
     */
    private int PREG_pa_67_70_e91;

    /**
     * Antall reelle poengår totalt. Kan være over 40.
     */
    private int PREG_pa_fa;
    /**
     * Angir om avdøde er død før avgang AP.
     */
    private Boolean PREG_dodForAP;
	
	/**
	* Flagg som viser om oppustert grunnlag fra pensjonsberegning fra TP-ordning er benyttet
	*/
	private boolean AfpTpoUpGrunnlagAnvendt;
	
	/**
	* Det oppjusterte uførepensjonsgrunnlaget fra TP-ordningen som ble brukt i beregning av TPI
	*/
	private int AfpTpoUpGrunnlagOppjustert;
	
	/**
	* TPI beregnet etter hovedregelen
	*/
	private int tpiEtterHovedregel;
	

    /**
     * Copy Constructor
     * 
     * @param poengrekke a <code>Poengrekke</code> object
     */
    public Poengrekke(Poengrekke poengrekke) {
        pa = poengrekke.pa;
        pa_f92 = poengrekke.pa_f92;
        pa_e91 = poengrekke.pa_e91;
        pa_fa_norge = poengrekke.pa_fa_norge;
        tpi = poengrekke.tpi;
        poengtallListe = new ArrayList<Poengtall>();
        if (poengrekke.poengtallListe != null) {
            for (Poengtall poengtall : poengrekke.poengtallListe) {
                poengtallListe.add(new Poengtall(poengtall));
            }
        }
        pa_no = poengrekke.pa_no;
        if (poengrekke.fpp != null) {
            fpp = new FramtidigPensjonspoengtall(poengrekke.fpp);
        }
        if (poengrekke.fpp_omregnet != null) {
            fpp_omregnet = new FramtidigPensjonspoengtall(poengrekke.fpp_omregnet);
        }
        siste_fpp_aar = poengrekke.siste_fpp_aar;
        tpi_faktor = poengrekke.tpi_faktor;
        pa_nordisk_framt_brutto = poengrekke.pa_nordisk_framt_brutto;
        pa_nordisk_framt_netto = poengrekke.pa_nordisk_framt_netto;
        paa = poengrekke.paa;
        pa_fa_norden = poengrekke.pa_fa_norden;
        pa_eos_teoretisk = poengrekke.pa_eos_teoretisk;
        pa_eos_pro_rata = poengrekke.pa_eos_pro_rata;
        pa_pro_rata_teller = poengrekke.pa_pro_rata_teller;
        pa_pro_rata_nevner = poengrekke.pa_pro_rata_nevner;
        fpa = poengrekke.fpa;
		AfpTpoUpGrunnlagAnvendt = poengrekke.AfpTpoUpGrunnlagAnvendt;
		AfpTpoUpGrunnlagOppjustert = poengrekke.AfpTpoUpGrunnlagOppjustert;
		tpiEtterHovedregel = poengrekke.tpiEtterHovedregel;
        merknadListe = new ArrayList<Merknad>();
        if (poengrekke.merknadListe != null) {
            for (Merknad merknad : poengrekke.merknadListe) {
                merknadListe.add(new Merknad(merknad));
            }
        }
        PREG_bevarFPPgrunnlag = poengrekke.PREG_bevarFPPgrunnlag;
        PREG_startar = poengrekke.PREG_startar;
        PREG_tilar = poengrekke.PREG_tilar;
        if (poengrekke.PREG_tildato != null) {
            PREG_tildato = (Date) poengrekke.PREG_tildato.clone();
        }
        PREG_sluttar = poengrekke.PREG_sluttar;
        PREG_vilkar3_17 = poengrekke.PREG_vilkar3_17;
        PREG_FPPomregnetGaranti = poengrekke.PREG_FPPomregnetGaranti;
        PREG_pa_67_70_e91 = poengrekke.PREG_pa_67_70_e91;
        PREG_dodForAP = poengrekke.PREG_dodForAP;
        PREG_pa_fa = poengrekke.PREG_pa_fa;
    }

    public Poengrekke(int pa, int pa_f92, int pa_e91, int pa_fa_norge, int tpi, List<Poengtall> poengtallListe, int pa_no, FramtidigPensjonspoengtall fpp,
                      FramtidigPensjonspoengtall fpp_omregnet, int siste_fpp_aar, double tpi_faktor, int pa_nordisk_framt_brutto, int pa_nordisk_framt_netto, double paa,
                      int pa_fa_norden, int pa_eos_teoretisk, int pa_eos_pro_rata, int pa_pro_rata_teller, int pa_pro_rata_nevner, int fpa, List<Merknad> merknadListe, boolean AfpTpoUpGrunnlagAnvendt, int AfpTpoUpGrunnlagOppjustert, int tpiEtterHovedregel) {
        super();
        this.pa = pa;
        this.pa_f92 = pa_f92;
        this.pa_e91 = pa_e91;
        this.pa_fa_norge = pa_fa_norge;
        this.tpi = tpi;
        this.poengtallListe = poengtallListe;
        this.pa_no = pa_no;
        this.fpp = fpp;
        this.fpp_omregnet = fpp_omregnet;
        this.siste_fpp_aar = siste_fpp_aar;
        this.tpi_faktor = tpi_faktor;
        this.pa_nordisk_framt_brutto = pa_nordisk_framt_brutto;
        this.pa_nordisk_framt_netto = pa_nordisk_framt_netto;
        this.paa = paa;
        this.pa_fa_norden = pa_fa_norden;
        this.pa_eos_teoretisk = pa_eos_teoretisk;
        this.pa_eos_pro_rata = pa_eos_pro_rata;
        this.pa_pro_rata_teller = pa_pro_rata_teller;
        this.pa_pro_rata_nevner = pa_pro_rata_nevner;
        this.fpa = fpa;
        this.merknadListe = merknadListe;
		this.AfpTpoUpGrunnlagAnvendt = AfpTpoUpGrunnlagAnvendt;
		this.AfpTpoUpGrunnlagOppjustert = AfpTpoUpGrunnlagOppjustert;
		this.tpiEtterHovedregel = tpiEtterHovedregel;
    }

    public Poengrekke() {
        super();
        poengtallListe = new ArrayList<Poengtall>();
        merknadListe = new ArrayList<Merknad>();
    }

    /**
     * @return Returns the pa.
     */
    public int getPa() {
        return pa;
    }

    /**
     * @param pa
     *            The pa to set.
     */
    public void setPa(int pa) {
        this.pa = pa;
    }

    /**
     * @return Returns the pa_e91.
     */
    public int getPa_e91() {
        return pa_e91;
    }

    /**
     * @param pa_e91
     *            The pa_e91 to set.
     */
    public void setPa_e91(int pa_e91) {
        this.pa_e91 = pa_e91;
    }

    /**
     * @return Returns the pa_f92.
     */
    public int getPa_f92() {
        return pa_f92;
    }

    /**
     * @param pa_f92
     *            The pa_f92 to set.
     */
    public void setPa_f92(int pa_f92) {
        this.pa_f92 = pa_f92;
    }

    /**
     * @return Returns the pa_fa_norge.
     */
    public int getPa_fa_norge() {
        return pa_fa_norge;
    }

    /**
     * @param pa_fa_norge
     *            The pa_fa_norge to set.
     */
    public void setPa_fa_norge(int pa_fa_norge) {
        this.pa_fa_norge = pa_fa_norge;
    }

    /**
     * @return Returns the poengtall.
     */
    public List<Poengtall> getPoengtallListe() {
        return poengtallListe;
    }

    /**
     * @param poengtall
     *            The poengtall to set.
     */
    public void setPoengtallListe(List<Poengtall> poengtall) {
        poengtallListe = poengtall;
    }

    /**
     * @deprecated
     * @return Returns the poengtall as array.
     */
    @Deprecated
    public Poengtall[] retrievePoengtallListeAsArray() {
        return poengtallListe.toArray(new Poengtall[0]);
    }

    /**
     * Read only property for poengtallListe as array.
     * 
     * @return array of Poengtall
     */
    public Poengtall[] getPoengtallListeAsArray() {
        return poengtallListe != null ? poengtallListe.toArray(new Poengtall[poengtallListe.size()]) : new Poengtall[0];
    }

    /**
     * @return Returns the tpi.
     */
    public int getTpi() {
        return tpi;
    }

    /**
     * @param tpi
     *            The tpi to set.
     */
    public void setTpi(int tpi) {
        this.tpi = tpi;
    }

    /**
     * @return Returns the merknad.
     */
    public List<Merknad> getMerknadListe() {
        return merknadListe;
    }

    /**
     * @param merknad
     *            The merknad to set.
     */
    public void setMerknadListe(List<Merknad> merknad) {
        merknadListe = merknad;
    }

    /**
     * @deprecated
     * @return Returns the merknad as array.
     */
    @Deprecated
    public Merknad[] retrieveMerknadListeAsArray() {
        return merknadListe.toArray(new Merknad[0]);
    }

    /**
     * Read only property for merknadListe as array.
     * 
     * @return array of Merknad
     */
    public Merknad[] getMerknadListeAsArray() {
        return merknadListe != null ? merknadListe.toArray(new Merknad[merknadListe.size()]) : new Merknad[0];
    }

    /**
     * @deprecated
     * @return Returns the poengtall as array, sorted by poeng (pp).
     */
    @Deprecated
    public Poengtall[] retrieveSortertPoengtallListeAsArray() {
        ArrayList<Poengtall> sortedPt = new ArrayList<Poengtall>(poengtallListe);
        Collections.sort(sortedPt, Collections.reverseOrder());
        return sortedPt.toArray(new Poengtall[0]);
    }

    /**
     * @return Returns the poengtallListe as array sorted by faktiske brutto pensjonspoeng (brp_fa).
     */
    public Poengtall[] retrieveSortertPoengtallListeByBRPFAAsArray() {
        if (poengtallListe != null) {
            ArrayList<Poengtall> sortedPt = new ArrayList<Poengtall>(poengtallListe);
            Comparator<Poengtall> comparator = (a, b) -> Double.compare(b.getPREG_brp_fa(), a.getPREG_brp_fa());
            Collections.sort(sortedPt, comparator);
            return sortedPt.toArray(new Poengtall[sortedPt.size()]);
        } else {
            return new Poengtall[0];
        }
    }

    /**
     * Read only property for poengtallListe as sorted array.
     * 
     * @return array of Poengtall, sorted by poeng (pp).
     */
    public Poengtall[] getSortertPoengtallListeAsArray() {
        if (poengtallListe != null) {
            ArrayList<Poengtall> sortedPt = new ArrayList<Poengtall>(poengtallListe);
            Collections.sort(sortedPt, Collections.reverseOrder());
            return sortedPt.toArray(new Poengtall[sortedPt.size()]);
        } else {
            return new Poengtall[0];
        }
    }

    public Poengtall[] sorterPoengtall(Poengtall[] pt) {
        List<Poengtall> ptList = Arrays.asList(pt);
        Collections.sort(ptList, Collections.reverseOrder());
        return ptList.toArray(new Poengtall[0]);
    }

    public Poengtall[] poengtallListeSortertPaaPoengaar(){
        if (poengtallListe != null) {
            List<Poengtall> poengtallList = new ArrayList<Poengtall>(poengtallListe);
            Comparator<Poengtall> comparator = (p1, p2) -> {
                if (p2.getAr() == p1.getAr()) {
                    return 0;
                } else if (p2.getAr() < p1.getAr()) {
                    return -1;
                } else {
                    return 1;
                }
            };
            Collections.sort(poengtallList, comparator);
            return poengtallList.toArray(new Poengtall[poengtallList.size()]);
        } else {
            return new Poengtall[0];
        }
    }

    public int getPa_no() {
        return pa_no;
    }

    public void setPa_no(int pa_no) {
        this.pa_no = pa_no;
    }

    public int getSiste_fpp_aar() {
        return siste_fpp_aar;
    }

    public void setSiste_fpp_aar(int siste_fpp_aar) {
        this.siste_fpp_aar = siste_fpp_aar;
    }

    public int getPa_nordisk_framt_brutto() {
        return pa_nordisk_framt_brutto;
    }

    public void setPa_nordisk_framt_brutto(int pa_nordisk_framt_brutto) {
        this.pa_nordisk_framt_brutto = pa_nordisk_framt_brutto;
    }

    public int getPa_nordisk_framt_netto() {
        return pa_nordisk_framt_netto;
    }

    public void setPa_nordisk_framt_netto(int pa_nordisk_framt_netto) {
        this.pa_nordisk_framt_netto = pa_nordisk_framt_netto;
    }

    public double getTpi_faktor() {
        return tpi_faktor;
    }

    public void setTpi_faktor(double tpi_factor) {
        tpi_faktor = tpi_factor;
    }

    public double getPaa() {
        return paa;
    }

    public void setPaa(double paa) {
        this.paa = paa;
    }

    public FramtidigPensjonspoengtall getFpp() {
        return fpp;
    }

    public void setFpp(FramtidigPensjonspoengtall fpp) {
        this.fpp = fpp;
    }

    public FramtidigPensjonspoengtall getFpp_omregnet() {
        return fpp_omregnet;
    }

    public void setFpp_omregnet(FramtidigPensjonspoengtall fpp_omregnet) {
        this.fpp_omregnet = fpp_omregnet;
    }

    public int getPa_eos_pro_rata() {
        return pa_eos_pro_rata;
    }

    public void setPa_eos_pro_rata(int pa_eos_pro_rata) {
        this.pa_eos_pro_rata = pa_eos_pro_rata;
    }

    public int getPa_eos_teoretisk() {
        return pa_eos_teoretisk;
    }

    public void setPa_eos_teoretisk(int pa_eos_teoretisk) {
        this.pa_eos_teoretisk = pa_eos_teoretisk;
    }

    public int getPa_fa_norden() {
        return pa_fa_norden;
    }

    public void setPa_fa_norden(int pa_fa_norden) {
        this.pa_fa_norden = pa_fa_norden;
    }

    public int getPa_pro_rata_teller() {
        return pa_pro_rata_teller;
    }

    public void setPa_pro_rata_teller(int pa_pro_rata_teller) {
        this.pa_pro_rata_teller = pa_pro_rata_teller;
    }

    public int getPa_pro_rata_nevner() {
        return pa_pro_rata_nevner;
    }

    public void setPa_pro_rata_nevner(int pa_pro_rata_nevner) {
        this.pa_pro_rata_nevner = pa_pro_rata_nevner;
    }

    public int getFpa() {
        return fpa;
    }

    public void setFpa(int fpa) {
        this.fpa = fpa;
    }

    public boolean isPREG_bevarFPPgrunnlag() {
        return PREG_bevarFPPgrunnlag;
    }

    public void setPREG_bevarFPPgrunnlag(boolean pgrunnlag) {
        PREG_bevarFPPgrunnlag = pgrunnlag;
    }

    public int getPREG_sluttar() {
        return PREG_sluttar;
    }

    public void setPREG_sluttar(int preg_sluttar) {
        PREG_sluttar = preg_sluttar;
    }

    public int getPREG_startar() {
        return PREG_startar;
    }

    public void setPREG_startar(int preg_startar) {
        PREG_startar = preg_startar;
    }

    public int getPREG_tilar() {
        return PREG_tilar;
    }

    public void setPREG_tilar(int preg_tilar) {
        PREG_tilar = preg_tilar;
    }

    public boolean isPREG_vilkar3_17() {
        return PREG_vilkar3_17;
    }

    public void setPREG_vilkar3_17(boolean preg_vilkar3_17) {
        PREG_vilkar3_17 = preg_vilkar3_17;
    }

    public Date getPREG_tildato() {
        return PREG_tildato;
    }

    public void setPREG_tildato(Date preg_tildato) {
        PREG_tildato = preg_tildato;
    }

    public boolean isPREG_FPPomregnetGaranti() {
        return PREG_FPPomregnetGaranti;
    }

    public void setPREG_FPPomregnetGaranti(boolean pomregnetGaranti) {
        PREG_FPPomregnetGaranti = pomregnetGaranti;
    }

    public int getPREG_pa_67_70_e91() {
        return PREG_pa_67_70_e91;
    }

    public void setPREG_pa_67_70_e91(int preg_pa_67_70_e91) {
        PREG_pa_67_70_e91 = preg_pa_67_70_e91;
    }

    public Boolean getPREG_dodForAP() {
        return PREG_dodForAP;
    }

    public void setPREG_dodForAP(Boolean forAP) {
        PREG_dodForAP = forAP;
    }

    @Override
    public String toString() {
        return ToStringUtil.toString(this);
    }

    public int getPREG_pa_fa() {
        return PREG_pa_fa;
    }

    public void setPREG_pa_fa(int preg_pa_fa) {
        PREG_pa_fa = preg_pa_fa;
    }

	public boolean isAfpTpoUpGrunnlagAnvendt() {
		return AfpTpoUpGrunnlagAnvendt;
		
	}
	
	public void setAfpTpoUpGrunnlagAnvendt(boolean AfpTpoUpGrunnlagAnvendt) {
		this.AfpTpoUpGrunnlagAnvendt = AfpTpoUpGrunnlagAnvendt;
	}
	
	public int getAfpTpoUpGrunnlagOppjustert() {
		return AfpTpoUpGrunnlagOppjustert;
		
	}
	
	public void setAfpTpoUpGrunnlagOppjustert(int AfpTpoUpGrunnlagOppjustert) {
		this.AfpTpoUpGrunnlagOppjustert = AfpTpoUpGrunnlagOppjustert;
	}
	
	public int getTpiEtterHovedregel()  {
		return tpiEtterHovedregel;
		
	}
	
	public void setTpiEtterHovedregel(int tpiEtterHovedregel) {
		this.tpiEtterHovedregel = tpiEtterHovedregel;
	}
	
	
	
}
