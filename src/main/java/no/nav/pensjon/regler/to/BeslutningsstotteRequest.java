package no.nav.pensjon.regler.to;


import no.nav.pensjon.regler.domain.grunnlag.InntektKontrollGrunnlag;
import no.nav.pensjon.regler.domain.grunnlag.Persongrunnlag;
import no.nav.pensjon.regler.domain.kode.BeslutningsstotteTypeCti;
import no.nav.pensjon.regler.domain.kode.BorMedTypeCti;
import no.nav.pensjon.regler.domain.vedtak.VilkarsVedtak;

/**
 * @author Lars Hartviksen (Decisive), PK-7048
 * @author Swiddy de Louw (Capgemini) - PK-7973 - PKPYTON-526
 * @author Frederik Rønenvig (Decisive) - PK-14979
 */
public class BeslutningsstotteRequest extends ServiceRequest {

    private static final long serialVersionUID = -5005325432005509170L;

    private BeslutningsstotteTypeCti beslutningsstotteType;

    private Persongrunnlag persongrunnlag;

    /** Vilkårsvedtaket for uføretrygd */
    private VilkarsVedtak vilkarsvedtak;

    /** Vurdert sivilstand på Kravhode.konverteringsgrunnlagUT.lopendeUFB.benyttetSivilstand */
    private BorMedTypeCti benyttetSivilstand;

    /** Inneholder nødvendig informasjon for å beregne ny forventet inntekt ifbm løpende inntektskontroll. */
    private InntektKontrollGrunnlag inntektKontrollGrunnlag;

    public BeslutningsstotteRequest() {
        super();
    }

    public BeslutningsstotteRequest(Persongrunnlag aPersongrunnlag) {
        persongrunnlag = aPersongrunnlag;
    }

    /**
     * @return the beslutningsstotteType
     */
    public BeslutningsstotteTypeCti getBeslutningsstotteType() {
        return beslutningsstotteType;
    }

    /**
     * @param beslutningsstotteType the beslutningsstotteType to set
     */
    public void setBeslutningsstotteType(BeslutningsstotteTypeCti beslutningsstotteType) {
        this.beslutningsstotteType = beslutningsstotteType;
    }

    /**
     * @return the vilkarsvedtak
     */
    public VilkarsVedtak getVilkarsvedtak() {
        return vilkarsvedtak;
    }

    /**
     * @param vilkarsvedtak the vilkarsvedtak to set
     */
    public void setVilkarsvedtak(VilkarsVedtak vilkarsvedtak) {
        this.vilkarsvedtak = vilkarsvedtak;
    }

    /**
     * @return the persongrunnlag
     */
    public Persongrunnlag getPersongrunnlag() {
        return persongrunnlag;
    }

    /**
     * @param persongrunnlag the persongrunnlag to set
     */
    public void setPersongrunnlag(Persongrunnlag persongrunnlag) {
        this.persongrunnlag = persongrunnlag;
    }

    /**
     * @return the benyttetSivilstand
     */
    public BorMedTypeCti getBenyttetSivilstand() {
        return benyttetSivilstand;
    }

    /**
     * @param benyttetSivilstand the benyttetSivilstand to set
     */
    public void setBenyttetSivilstand(BorMedTypeCti benyttetSivilstand) {
        this.benyttetSivilstand = benyttetSivilstand;
    }

    public InntektKontrollGrunnlag getInntektKontrollGrunnlag() {
        return inntektKontrollGrunnlag;
    }

    public void setInntektKontrollGrunnlag(InntektKontrollGrunnlag inntektKontrollGrunnlag) {
        this.inntektKontrollGrunnlag = inntektKontrollGrunnlag;
    }
}
