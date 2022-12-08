package no.nav.service.pensjon.regler.to;


import no.nav.domain.pensjon.regler.grunnlag.InntektKontrollGrunnlag;
import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.kode.BeslutningsstotteTypeCti;
import no.nav.domain.pensjon.regler.kode.BorMedTypeCti;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

/**
 * @author Lars Hartviksen (Decisive), PK-7048
 * @author Swiddy de Louw (Capgemini) - PK-7973 - PKPYTON-526
 * @author Frederik Rønenvig (Decisive) - PK-14979
 */
public class BeslutningsstotteRequest extends ServiceRequest {


    private BeslutningsstotteTypeCti beslutningsstotteType;

    private Persongrunnlag persongrunnlag;

    /** Vilkårsvedtaket for uføretrygd */
    private VilkarsVedtak vilkarsvedtak;

    /** Vurdert sivilstand på Kravhode.konverteringsgrunnlagUT.lopendeUFB.benyttetSivilstand */
    private BorMedTypeCti benyttetSivilstand;

    /** Inneholder nødvendig informasjon for å beregne ny forventet inntekt ifbm løpende inntektskontroll. */
    private InntektKontrollGrunnlag inntektKontrollGrunnlag;


}
