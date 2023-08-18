package no.nav.pensjon.regler.domain.error;

/**
 * Brukes internt i Blaze for å signalisere at det oppstod en kontrollert feil under kall til
 * KontrollerInformasjonsgrunnlag enten via tjenesten eller en annen tjeneste som kaller komponenten.
 * Det bygges opp en merknadliste som inneholder "PREG001" og returneres
 * til EJB-laget som deretter oppodaterer pakkseddelen.
 */
public class PREG001 extends Exception {

    private static final long serialVersionUID = 7856491066272660736L;

    private String msg;

    public PREG001() {
        super();
    }

    public PREG001(String msg) {
        super(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
