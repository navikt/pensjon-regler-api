package no.nav.service.pensjon.regler.to;


import no.nav.domain.pensjon.regler.grunnlag.InntektKontrollGrunnlag;
import no.nav.domain.pensjon.regler.grunnlag.Persongrunnlag;
import no.nav.domain.pensjon.regler.kode.BeslutningsstotteTypeCti;
import no.nav.domain.pensjon.regler.kode.BorMedTypeCti;
import no.nav.domain.pensjon.regler.vedtak.VilkarsVedtak;

/**
 * @author Lars Hartviksen (Decisive), PK-7048
 * @author Swiddy de Louw (Capgemini) - PK-7973 - PKPYTON-526
 * @author Frederik R�nenvig (Decisive) - PK-14979
 */
public class BeslutningsstotteRequest extends ServiceRequest {


    private BeslutningsstotteTypeCti beslutningsstotteType;

    private Persongrunnlag persongrunnlag;

    /** Vilk�rsvedtaket for uf�retrygd */
    private VilkarsVedtak vilkarsvedtak;

    /** Vurdert sivilstand p� Kravhode.konverteringsgrunnlagUT.lopendeUFB.benyttetSivilstand */
    private BorMedTypeCti benyttetSivilstand;

    /** Inneholder n�dvendig informasjon for � beregne ny forventet inntekt ifbm l�pende inntektskontroll. */
    private InntektKontrollGrunnlag inntektKontrollGrunnlag;


}
