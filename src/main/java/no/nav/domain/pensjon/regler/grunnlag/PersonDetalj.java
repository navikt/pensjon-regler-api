package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.PenPerson;
import no.nav.domain.pensjon.regler.kode.BorMedTypeCti;
import no.nav.domain.pensjon.regler.kode.GrunnlagKildeCti;
import no.nav.domain.pensjon.regler.kode.GrunnlagsrolleCti;
import no.nav.domain.pensjon.regler.kode.SivilstandTypeCti;

import java.io.Serializable;
import java.util.Date;

/**
 * PersonDetalj inneholder persondetaljer som er relevante for fastsettelse av vedtak i Pensjonsløsningen,
 * dvs detaljer om den faktiske rollen en bruker har i et krav, sivilstand , pensjonsfaglig vurdert
 * sivilstand og barn for en definert periode.
 */
public class PersonDetalj implements Serializable {
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

}
