package no.nav.pensjon.regler.domain.grunnlag;

import no.nav.pensjon.regler.domain.PenPerson;
import no.nav.pensjon.regler.domain.kode.BorMedTypeCti;
import no.nav.pensjon.regler.domain.kode.GrunnlagKildeCti;
import no.nav.pensjon.regler.domain.kode.GrunnlagsrolleCti;
import no.nav.pensjon.regler.domain.kode.SivilstandTypeCti;
import no.nav.pensjon.regler.domain.util.DateCompareUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * PersonDetalj inneholder persondetaljer som er relevante for fastsettelse av vedtak i Pensjonsløsningen,
 * dvs detaljer om den faktiske rollen en bruker har i et krav, sivilstand , pensjonsfaglig vurdert
 * sivilstand og barn for en definert periode.
 */
public class PersonDetalj implements Comparable<PersonDetalj>, Serializable {

    private static final long serialVersionUID = 3464084807339791932L;

    /**
     * Rollen denne personen har i kontekst av kravet.
     */
    private GrunnlagsrolleCti grunnlagsrolle;
    /**
     * Fra-og-med dato for rollens gyldighet.
     */
    private Date rolleFomDato;
    /**
     * Til-og-med dato for rollens gyldighet.
     */
    private Date rolleTomDato;

    /**
     * Representerer personens sivilstand i henhold til TPS.
     */
    private SivilstandTypeCti sivilstandType;
    /**
     * Eventuell angivelse av hvilken annen person som sivilstandType relaterer seg til,
     * for eksempel ektefelle eller samboer.
     */
    private PenPerson sivilstandRelatertPerson;
    /**
     * Representerer om og hvordan personen bor sammen med en annen person med persongrunnlag på kravet.
     * Refereres konseptuelt som pensjonsfaglig vurdert sivilstand.
     */
    private BorMedTypeCti borMed;
    /**
     * Detaljer om barnet hvis rolle=BARN. Angir om barnet bor med en annen forelder.
     */
    private BarnDetalj barnDetalj;

    /**
     * Angir om det er opprettet barne- eller ektefelletillegg kravlinje for persongrunnlaget
     * med gitt rolle.
     */
    private boolean tillegg;
    /**
     * Angir om persondetaljen brukes som grunnlag på kravet.
     */
    private boolean bruk;
    /**
     * Angir kilden til persondetaljen.
     */
    private GrunnlagKildeCti grunnlagKilde;

    private Boolean serskiltSatsUtenET;

    private Boolean epsAvkallEgenPensjon;

    /**
     * Copy Constructor
     * 
     * @param personDetalj a <code>PersonDetalj</code> object
     */
    public PersonDetalj(PersonDetalj personDetalj) {
        if (personDetalj.grunnlagsrolle != null) {
            grunnlagsrolle = new GrunnlagsrolleCti(personDetalj.grunnlagsrolle);
        }
        if (personDetalj.rolleFomDato != null) {
            rolleFomDato = (Date) personDetalj.rolleFomDato.clone();
        }
        if (personDetalj.rolleTomDato != null) {
            rolleTomDato = (Date) personDetalj.rolleTomDato.clone();
        }
        if (personDetalj.sivilstandType != null) {
            sivilstandType = new SivilstandTypeCti(personDetalj.sivilstandType);
        }
        if (personDetalj.sivilstandRelatertPerson != null) {
            sivilstandRelatertPerson = new PenPerson(personDetalj.sivilstandRelatertPerson);
        }
        if (personDetalj.borMed != null) {
            borMed = new BorMedTypeCti(personDetalj.borMed);
        }
        if (personDetalj.barnDetalj != null) {
            barnDetalj = new BarnDetalj(personDetalj.barnDetalj);
        }
        tillegg = personDetalj.tillegg;
        bruk = personDetalj.bruk;
        if (personDetalj.grunnlagKilde != null) {
            grunnlagKilde = new GrunnlagKildeCti(personDetalj.grunnlagKilde);
        }
        serskiltSatsUtenET = personDetalj.serskiltSatsUtenET;
    }

    public PersonDetalj(GrunnlagsrolleCti grunnlagsrolle, Date rolleFomDato, Date rolleTomDato, SivilstandTypeCti sivilstandType, PenPerson sivilstandRelatertPerson,
                        BorMedTypeCti borMed, BarnDetalj barnDetalj, boolean tillegg, boolean bruk, GrunnlagKildeCti grunnlagKilde, boolean epsAvkallEgenPensjon) {
        super();
        this.grunnlagsrolle = grunnlagsrolle;
        this.rolleFomDato = rolleFomDato;
        this.rolleTomDato = rolleTomDato;
        this.sivilstandType = sivilstandType;
        this.sivilstandRelatertPerson = sivilstandRelatertPerson;
        this.borMed = borMed;
        this.barnDetalj = barnDetalj;
        this.tillegg = tillegg;
        this.bruk = bruk;
        this.grunnlagKilde = grunnlagKilde;
        this.epsAvkallEgenPensjon = epsAvkallEgenPensjon;
    }

    public PersonDetalj() {
        super();
        bruk = true;
    }

    public BarnDetalj getBarnDetalj() {
        return barnDetalj;
    }

    public void setBarnDetalj(BarnDetalj barnDetalj) {
        this.barnDetalj = barnDetalj;
    }

    public boolean isBruk() {
        return bruk;
    }

    public void setBruk(boolean bruk) {
        this.bruk = bruk;
    }

    public GrunnlagKildeCti getGrunnlagKilde() {
        return grunnlagKilde;
    }

    public void setGrunnlagKilde(GrunnlagKildeCti grunnlagKilde) {
        this.grunnlagKilde = grunnlagKilde;
    }

    public GrunnlagsrolleCti getGrunnlagsrolle() {
        return grunnlagsrolle;
    }

    public void setGrunnlagsrolle(GrunnlagsrolleCti grunnlagsrolle) {
        this.grunnlagsrolle = grunnlagsrolle;
    }

    public Date getRolleFomDato() {
        return rolleFomDato;
    }

    public void setRolleFomDato(Date rolleFomDato) {
        this.rolleFomDato = rolleFomDato;
    }

    public Date getRolleTomDato() {
        return rolleTomDato;
    }

    public void setRolleTomDato(Date rolleTomDato) {
        this.rolleTomDato = rolleTomDato;
    }

    public SivilstandTypeCti getSivilstandType() {
        return sivilstandType;
    }

    public void setSivilstandType(SivilstandTypeCti sivilstandType) {
        this.sivilstandType = sivilstandType;
    }

    public boolean isTillegg() {
        return tillegg;
    }

    public void setTillegg(boolean tillegg) {
        this.tillegg = tillegg;
    }

    public Boolean getEpsAvkallEgenPensjon() {
        return epsAvkallEgenPensjon;
    }

    public void setEpsAvkallEgenPensjon(Boolean epsAvkallEgenPensjon) {
        this.epsAvkallEgenPensjon = epsAvkallEgenPensjon;
    }

    public Boolean getSerskiltSatsUtenET() {
        return serskiltSatsUtenET;
    }

    public void setSerskiltSatsUtenET(Boolean serskiltSatsUtenET) {
        this.serskiltSatsUtenET = serskiltSatsUtenET;
    }

    @Override
    public String toString() {
        final String TAB = "    ";

        StringBuilder retValue = new StringBuilder();

        retValue.append("PersonDetalj ( ").append(super.toString()).append(TAB).append("grunnlagsrolle = ").append(grunnlagsrolle).append(TAB).append("rolleFomDato = ")
                .append(rolleFomDato).append(TAB).append("rolleTomDato = ").append(rolleTomDato).append(TAB).append("sivilstandType = ").append(sivilstandType).append(TAB)
                .append("borMed = ").append(borMed).append(TAB).append("barnDetalj = ").append(barnDetalj).append(TAB).append("tillegg = ").append(tillegg).append(TAB)
                .append("bruk = ").append(bruk).append(TAB).append("grunnlagKilde = ").append(grunnlagKilde).append(TAB).append(" )");

        return retValue.toString();
    }

    public PenPerson getSivilstandRelatertPerson() {
        return sivilstandRelatertPerson;
    }

    public void setSivilstandRelatertPerson(PenPerson sivilstandRelatertPerson) {
        this.sivilstandRelatertPerson = sivilstandRelatertPerson;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(PersonDetalj personDetalj) {
        return DateCompareUtil.compareTo(getRolleFomDato(), personDetalj.getRolleFomDato());
    }

    public BorMedTypeCti getBorMed() {
        return borMed;
    }

    public void setBorMed(BorMedTypeCti borMed) {
        this.borMed = borMed;
    }

}
