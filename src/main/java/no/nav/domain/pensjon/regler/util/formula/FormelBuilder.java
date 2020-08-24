package no.nav.domain.pensjon.regler.util.formula;

import no.nav.domain.pensjon.regler.error.InvalidFormulaException;

import java.io.Serializable;

public class FormelBuilder implements Serializable {
    private static final long serialVersionUID = 1640700298940148634L;
    private Formler formler;
    private Formel formel = new Formel();

    public FormelBuilder() {

    }

    public FormelBuilder(Formler formler) {
        this.formler = formler;
    }

    public FormelBuilder emne(String emne) {
        formel.setEmne(emne);
        return this;
    }

    public FormelBuilder felt(String felt) {
        formel.setDomain(true);
        formel.setFelt(felt);
        return this;
    }

    public FormelBuilder notasjon(String notasjon) {
        formel.setNotasjon(notasjon);
        return this;
    }

    public FormelBuilder utvidNotasjon(String utvidelse) {
        formel.setNotasjon(formel.getNotasjon() + utvidelse);
        return this;
    }

    public FormelBuilder var(String var, double value) {
        formel.getVarMap().put(var, value);
        return this;
    }

    public FormelBuilder var(String var, int value) {
        formel.getVarMap().put(var, value);
        return this;
    }

    public FormelBuilder var(String var, Number value) {
        formel.getVarMap().put(var, value);
        return this;
    }

    public FormelBuilder var(String var, Formel subFormel) {
        return var(var, subFormel, false);
    }

    public FormelBuilder var(String var, Formel subFormel, boolean allowRenameSubFormel) {
        subFormel.setRenameAllowed(allowRenameSubFormel);
        formel.getFormelVarMap().put(var, subFormel);
        return this;
    }

    public FormelBuilder vekt(int vekt) {
        formel.setVekt(vekt);
        return this;
    }

    public FormelBuilder resultat(int expectedResult) {
        formel.setResultat(expectedResult);
        return this;
    }

    public FormelBuilder resultat(double expectedResult) {
        formel.setResultat(expectedResult);
        return this;
    }

    public FormelBuilder autoResolve() {
        formel.setAutoResolve(true);
        return this;
    }

    public Formel build() throws InvalidFormulaException {
        Resolver.resolve(formel, formler);
        return formel;
    }

    public Formel getFormel() {
        return formel;
    }

    public void setFormel(Formel formel) {
        this.formel = formel;
    }
}
