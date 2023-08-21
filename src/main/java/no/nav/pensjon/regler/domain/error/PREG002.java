package no.nav.pensjon.regler.domain.error;

/**
 * Brukes internt i Blaze for å signalisere at det oppstod en kontrollert "kan ikke beregne situasjon".
 */
public class PREG002 extends Exception {

    private static final long serialVersionUID = 7856491066272660736L;

    private String msg;

    public PREG002() {
        super();
    }

    public PREG002(String msg) {
        super(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
