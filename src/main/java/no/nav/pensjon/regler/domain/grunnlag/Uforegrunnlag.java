package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.kode.YrkeCti;

import java.util.Date;

public class Uforegrunnlag implements java.io.Serializable {

    private static final long serialVersionUID = -512002248652736675L;
    /**
     * Uf�regrad, 0-100
     */
    private int ufg;

    /**
     * Dato for uf�retidspunktet.
     */
    private Date uft;

    /**
     * Virkningstidspunkt for hendelsen Uforegrunnlaget representerer.
     */
    private Date uftVirk;

    /**
     * Inntekt f�r uf�rhet.Normalinntekten personen ville hatt p�
     * uf�retidspunktet dersom personen ikke hadde blitt syk. Settes av saksbehandler.
     * ifu relaterer seg til f�rste uf�retidspunkt. Det er uforegrunnlag.uft ved f�rste gangs UP.
     * Ellers hentes den fra historikken.
     */
    private int ifu;

    /**
     * <p>
     * F�dsels�r for yngste barn. N�r denne variabelen er satt er det underforst�tt at bruker ogs� har omsorg for dette barnet ved UFT (barnet m� alts� v�re under 7 �r). Dette har
     * konsekvens for for godskriving av FPP (garanti grense p� 3.00 i perioden tom barnet fyller 6 �r).
     * </p>
     */
    private int fodselsArYngsteBarn;
    /**
     * Dato for rett til friinntekt.
     */
    private Date friinntektsDato;

    /**
     * Om tilfellet er en reaktivisering- f.eks har fors�kt � jobbe, men fors�ket feilet.
     */
    private boolean reaktivisering;
    /**
     * Dato n�r reaktivering startet
     */
    private Date PREG_reaktiviseringFomDato;

    /**
     * Opplysning om at uf�repensjonen skal utbetales til arbeidsgiver.
     */
    private boolean lonnstilskudd;

    /*
     * Forh�yelse av uf�regrad uten nytt uf�retidspunkt.
     * Brukes i skjermbildet for validering og mulighet til � gi feilmelding
     * dersom saksbehandler ikke har satt nytt uf�retidspunkt.
     */
    private boolean forhoyelseUtenNyttUft;

    /**
     * Angir om personen er "ung uf�r".Settes av saksbehandler.
     * Brukes ikke i PREG. Det er garantertTPUngUfor som brukes istedet.
     */
    private boolean ungUfor;

    /**
     * Angir on �rlig inntekt er st�rre enn G p� uf�retidspunktet.
     */
    private boolean arligInntektMinst1g;

    /**
     * Unntak for ventetid etter �12-12.
     */
    private boolean unntakVentetid12_12;
    /**
     * Kode for yrke til den uf�re.
     * Denne koden brukes til statstikk og for � beregne lovlig inntekt � 12-12
     * for kombinert yrkesaktiv/husmor, kode = 11,12,13 og 18.
     */
    private YrkeCti yrke;
    /**
     * Garantert tilleggspensjon til ung uf�r f�dt f�r 1940.
     */
    private boolean garantertTPUngUfor;
    /*
     * Alternativt uf�retidspunkt ung uf�r ved krav f�r 36 �r.
     */
    private Date altUftUngUfor;
    /**
     * Hele eller deler av uf�rheten skyldes yrkesskade.
     */
    private boolean uforhetSkyldesYrkesskade;
    /**
     * Angir om uf�regrunnlaget brukes som grunnlag p� kravet.
     */
    private boolean bruk;
    /**
     * Angir om uf�regrunnlaget brukes som grunnlag p� kravet.
     */
    private boolean PREG_nedsattUfg;

    /**
     * Copy Constructor
     * 
     * @param uforegrunnlag a <code>Uforegrunnlag</code> object
     */
    public Uforegrunnlag(Uforegrunnlag uforegrunnlag) {
        ufg = uforegrunnlag.ufg;
        if (uforegrunnlag.uft != null) {
            uft = (Date) uforegrunnlag.uft.clone();
        }
        if (uforegrunnlag.uftVirk != null) {
            uftVirk = (Date) uforegrunnlag.uftVirk.clone();
        }
        ifu = uforegrunnlag.ifu;
        fodselsArYngsteBarn = uforegrunnlag.fodselsArYngsteBarn;
        if (uforegrunnlag.friinntektsDato != null) {
            friinntektsDato = (Date) uforegrunnlag.friinntektsDato.clone();
        }
        reaktivisering = uforegrunnlag.reaktivisering;
        if (uforegrunnlag.PREG_reaktiviseringFomDato != null) {
            PREG_reaktiviseringFomDato = (Date) uforegrunnlag.PREG_reaktiviseringFomDato.clone();
        }
        lonnstilskudd = uforegrunnlag.lonnstilskudd;
        forhoyelseUtenNyttUft = uforegrunnlag.forhoyelseUtenNyttUft;
        ungUfor = uforegrunnlag.ungUfor;
        arligInntektMinst1g = uforegrunnlag.arligInntektMinst1g;
        unntakVentetid12_12 = uforegrunnlag.unntakVentetid12_12;
        if (uforegrunnlag.yrke != null) {
            yrke = new YrkeCti(uforegrunnlag.yrke);
        }
        garantertTPUngUfor = uforegrunnlag.garantertTPUngUfor;
        if (uforegrunnlag.altUftUngUfor != null) {
            altUftUngUfor = (Date) uforegrunnlag.altUftUngUfor.clone();
        }
        uforhetSkyldesYrkesskade = uforegrunnlag.uforhetSkyldesYrkesskade;
        bruk = uforegrunnlag.bruk;
        PREG_nedsattUfg = uforegrunnlag.PREG_nedsattUfg;
    }

    public Uforegrunnlag(int ufg, Date uft, Date uftVirk, int ifu, int fodselsArYngsteBarn, Date friinntektsDato, boolean reaktivisering, boolean lonnstilskudd,
                         boolean forhoyelseUtenNyttUft, boolean ungUfor, boolean arligInntektMinst1g, boolean unntakVentetid12_12, YrkeCti yrke, boolean garantertTPUngUfor,
                         Date altUftUngUfor, boolean uforhetSkyldesYrkesskade, boolean bruk) {
        super();
        this.ufg = ufg;
        this.uft = uft;
        this.uftVirk = uftVirk;
        this.ifu = ifu;
        this.fodselsArYngsteBarn = fodselsArYngsteBarn;
        this.friinntektsDato = friinntektsDato;
        this.reaktivisering = reaktivisering;
        this.lonnstilskudd = lonnstilskudd;
        this.forhoyelseUtenNyttUft = forhoyelseUtenNyttUft;
        this.ungUfor = ungUfor;
        this.arligInntektMinst1g = arligInntektMinst1g;
        this.unntakVentetid12_12 = unntakVentetid12_12;
        this.yrke = yrke;
        this.garantertTPUngUfor = garantertTPUngUfor;
        this.altUftUngUfor = altUftUngUfor;
        this.uforhetSkyldesYrkesskade = uforhetSkyldesYrkesskade;
        this.bruk = bruk;
    }

    public Uforegrunnlag() {
        super();
        bruk = true;
    }

    public boolean isArligInntektMinst1g() {
        return arligInntektMinst1g;
    }

    public void setArligInntektMinst1g(boolean arligInntektMinst1g) {
        this.arligInntektMinst1g = arligInntektMinst1g;
    }

    public boolean isBruk() {
        return bruk;
    }

    public void setBruk(boolean bruk) {
        this.bruk = bruk;
    }

    public Date getFriinntektsDato() {
        return friinntektsDato;
    }

    public void setFriinntektsDato(Date friinntektsDato) {
        this.friinntektsDato = friinntektsDato;
    }

    public int getIfu() {
        return ifu;
    }

    public void setIfu(int ifu) {
        this.ifu = ifu;
    }

    public boolean isLonnstilskudd() {
        return lonnstilskudd;
    }

    public void setLonnstilskudd(boolean lonnstilskudd) {
        this.lonnstilskudd = lonnstilskudd;
    }

    public boolean isReaktivisering() {
        return reaktivisering;
    }

    public void setReaktivisering(boolean reaktivisering) {
        this.reaktivisering = reaktivisering;
    }

    public int getUfg() {
        return ufg;
    }

    public void setUfg(int ufg) {
        this.ufg = ufg;
    }

    public boolean isUforhetSkyldesYrkesskade() {
        return uforhetSkyldesYrkesskade;
    }

    public void setUforhetSkyldesYrkesskade(boolean uforhetSkyldesYrkesskade) {
        this.uforhetSkyldesYrkesskade = uforhetSkyldesYrkesskade;
    }

    public Date getUft() {
        return uft;
    }

    public void setUft(Date uft) {
        this.uft = uft;
    }

    public Date getUftVirk() {
        return uftVirk;
    }

    public void setUftVirk(Date uftVirk) {
        this.uftVirk = uftVirk;
    }

    public boolean isUngUfor() {
        return ungUfor;
    }

    public void setUngUfor(boolean ungUfor) {
        this.ungUfor = ungUfor;
    }

    public boolean isUnntakVentetid12_12() {
        return unntakVentetid12_12;
    }

    public void setUnntakVentetid12_12(boolean unntakVentetid12_12) {
        this.unntakVentetid12_12 = unntakVentetid12_12;
    }

    public YrkeCti getYrke() {
        return yrke;
    }

    public void setYrke(YrkeCti yrke) {
        this.yrke = yrke;
    }

    public Date getAltUftUngUfor() {
        return altUftUngUfor;
    }

    public void setAltUftUngUfor(Date altUftUngUfor) {
        this.altUftUngUfor = altUftUngUfor;
    }

    public int getFodselsArYngsteBarn() {
        return fodselsArYngsteBarn;
    }

    public void setFodselsArYngsteBarn(int fodselsArYngsteBarn) {
        this.fodselsArYngsteBarn = fodselsArYngsteBarn;
    }

    public boolean isForhoyelseUtenNyttUft() {
        return forhoyelseUtenNyttUft;
    }

    public void setForhoyelseUtenNyttUft(boolean forhoyelseUtenNyttUft) {
        this.forhoyelseUtenNyttUft = forhoyelseUtenNyttUft;
    }

    public boolean isGarantertTPUngUfor() {
        return garantertTPUngUfor;
    }

    public void setGarantertTPUngUfor(boolean garantertTPUngUfor) {
        this.garantertTPUngUfor = garantertTPUngUfor;
    }

    public boolean isPREG_nedsattUfg() {
        return PREG_nedsattUfg;
    }

    public void setPREG_nedsattUfg(boolean ufg) {
        PREG_nedsattUfg = ufg;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     * 
     * @return a <code>String</code> representation
     *         of this object.
     */
    @Override
    public String toString() {
        final String TAB = "    ";

        StringBuilder retValue = new StringBuilder();

        retValue.append("Uforegrunnlag ( ").append(super.toString()).append(TAB).append("ufg = ").append(ufg).append(TAB).append("uft = ").append(uft).append(TAB).append("ifu = ")
                .append(ifu).append(TAB).append("fodselsArYngsteBarn = ").append(fodselsArYngsteBarn).append(TAB).append("friinntektsDato = ").append(friinntektsDato).append(TAB)
                .append("reaktivisering = ").append(reaktivisering).append(TAB).append("lonnstilskudd = ").append(lonnstilskudd).append(TAB).append("forhoyelseUtenNyttUft = ")
                .append(forhoyelseUtenNyttUft).append(TAB).append("ungUfor = ").append(ungUfor).append(TAB).append("arligInntektMinst1g = ").append(arligInntektMinst1g)
                .append(TAB).append("unntakVentetid12_12 = ").append(unntakVentetid12_12).append(TAB).append("yrke = ").append(yrke).append(TAB).append("garantertTPUngUfor = ")
                .append(garantertTPUngUfor).append(TAB).append("altUftUngUfor = ").append(altUftUngUfor).append(TAB).append("uforhetSkyldesYrkesskade = ")
                .append(uforhetSkyldesYrkesskade).append(TAB).append("bruk = ").append(bruk).append(TAB)

                .append(" )");

        return retValue.toString();
    }

    public Date getPREG_reaktiviseringFomDato() {
        return PREG_reaktiviseringFomDato;
    }

    public void setPREG_reaktiviseringFomDato(Date fomDato) {
        PREG_reaktiviseringFomDato = fomDato;
    }

}
