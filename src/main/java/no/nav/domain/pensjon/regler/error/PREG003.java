package no.nav.domain.pensjon.regler.error;

/**
 * Brukes internt i Blaze for å signalisere at det oppstod en kontrollert "kan ikke vilkårsprøve situasjon".
 */
public class PREG003 extends Exception {

    private static final long serialVersionUID = 7856491066272660736L;

    private String msg;

    public PREG003() {
        super();
    }

    public PREG003(String msg) {
        super(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
