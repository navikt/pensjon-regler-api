package no.nav.domain.pensjon.regler.grunnlag;

import no.nav.domain.pensjon.regler.kode.YrkeCti;

import java.util.Date;

public class Uforegrunnlag implements java.io.Serializable {

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

}
