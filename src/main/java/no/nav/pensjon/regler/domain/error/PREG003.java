package no.nav.pensjon.regler.domain.error;

/**
 * Brukes internt i Blaze for � signalisere at det oppstod en kontrollert "kan ikke vilk�rspr�ve situasjon".
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
