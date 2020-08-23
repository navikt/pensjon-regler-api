package no.nav.domain.pensjon.regler.error;

/**
 * Brukes internt i Blaze for å signalisere at det skal kastes en PREGOverlappendePerioderException i EJB-laget.
 */
public class PREG004 extends Exception {

    private static final long serialVersionUID = 7856491066272660736L;

    private String msg;

    public PREG004() {
        super();
    }

    public PREG004(String msg) {
        super(msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
