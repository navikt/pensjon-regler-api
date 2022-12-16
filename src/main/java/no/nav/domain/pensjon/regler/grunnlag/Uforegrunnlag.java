package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.YrkeCti;

import java.util.Date;

public class Uforegrunnlag implements java.io.Serializable {

    /**
     * Uføregrad, 0-100
     */
    private int ufg;

    /**
     * Dato for uføretidspunktet.
     */
    private Date uft;

    /**
     * Virkningstidspunkt for hendelsen Uforegrunnlaget representerer.
     */
    private Date uftVirk;

    /**
     * Inntekt før uførhet.Normalinntekten personen ville hatt på
     * uføretidspunktet dersom personen ikke hadde blitt syk. Settes av saksbehandler.
     * ifu relaterer seg til første uføretidspunkt. Det er uforegrunnlag.uft ved første gangs UP.
     * Ellers hentes den fra historikken.
     */
    private int ifu;

    /**
     * <p>
     * Fødselsår for yngste barn. Når denne variabelen er satt er det underforstått at bruker også har omsorg for dette barnet ved UFT (barnet må altså være under 7 år). Dette har
     * konsekvens for for godskriving av FPP (garanti grense på 3.00 i perioden tom barnet fyller 6 år).
     * </p>
     */
    private int fodselsArYngsteBarn;
    /**
     * Dato for rett til friinntekt.
     */
    private Date friinntektsDato;

    /**
     * Om tilfellet er en reaktivisering- f.eks har forsøkt å jobbe, men forsøket feilet.
     */
    private boolean reaktivisering;

    /**
     * Opplysning om at uførepensjonen skal utbetales til arbeidsgiver.
     */
    private boolean lonnstilskudd;

    /*
     * Forhøyelse av uføregrad uten nytt uføretidspunkt.
     * Brukes i skjermbildet for validering og mulighet til å gi feilmelding
     * dersom saksbehandler ikke har satt nytt uføretidspunkt.
     */
    private boolean forhoyelseUtenNyttUft;

    /**
     * Angir om personen er "ung ufør".Settes av saksbehandler.
     * Brukes ikke i PREG. Det er garantertTPUngUfor som brukes istedet.
     */
    private boolean ungUfor;

    /**
     * Angir on årlig inntekt er større enn G på uføretidspunktet.
     */
    private boolean arligInntektMinst1g;

    /**
     * Unntak for ventetid etter §12-12.
     */
    private boolean unntakVentetid12_12;
    /**
     * Kode for yrke til den uføre.
     * Denne koden brukes til statstikk og for å beregne lovlig inntekt § 12-12
     * for kombinert yrkesaktiv/husmor, kode = 11,12,13 og 18.
     */
    private YrkeCti yrke;
    /**
     * Garantert tilleggspensjon til ung ufør født før 1940.
     */
    private boolean garantertTPUngUfor;
    /*
     * Alternativt uføretidspunkt ung ufør ved krav før 36 år.
     */
    private Date altUftUngUfor;
    /**
     * Hele eller deler av uførheten skyldes yrkesskade.
     */
    private boolean uforhetSkyldesYrkesskade;
    /**
     * Angir om uføregrunnlaget brukes som grunnlag på kravet.
     */
    private boolean bruk;

}
