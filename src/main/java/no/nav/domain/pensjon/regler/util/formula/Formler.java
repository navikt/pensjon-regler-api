package no.nav.domain.pensjon.regler.util.formula;

import no.nav.domain.pensjon.regler.error.InvalidFormulaException;

import java.io.Serializable;
import java.util.Map;

public class Formler implements Serializable {
    private static final long serialVersionUID = 1302484267238570004L;

    /*
     * Referanse til det domeneobjekt som skal tilby formler.
     */
    private IFormelProvider formelProvider;

    public Formler(IFormelProvider fp) {
        formelProvider = fp;
    }

    public FormelBuilder ny() {
        return new FormelBuilder(this);
    }

    public FormelBuilder ny(String emne) {
        return new FormelBuilder(this).emne(emne);
    }

    public FormelBuilder copy(String felt) {
        return copy(find(felt));
    }

    public FormelBuilder copy(Formel formelToCopy) {
        if (formelToCopy == null)
            throw new InvalidFormulaException("Cannot copy. Formel is null.");
        Formel f = new Formel(formelToCopy);

        /* Formelkopi kan ikke videreføre resultatet fra original formel til ny formel. Ny formel må ha nytt felt og nytt resultat. */
        f.setResultat(null);

        /* Formelkopi vil selv konstruere listen av subformler etter build(); */
        f.getSubFormelList().clear();

        FormelBuilder fb = new FormelBuilder(this);
        fb.setFormel(f);

        return fb;
    }

    public FormelBuilder copyOrDefault(String felt) {
        return copyOrDefault(find(felt));
    }

    public FormelBuilder copyOrDefault(Formel formelToCopy) {
        if (formelToCopy != null)
            return copy(formelToCopy);
        else
            return new FormelBuilder(this).autoResolve();
    }

    public Formel find(String felt) {
        return formelProvider.getFormelMap().getOrDefault(felt, null);
    }

    public Formel findOrDefault(String felt) {
        if (formelProvider.getFormelMap().containsKey(felt)) {
            return formelProvider.getFormelMap().get(felt);
        } else {
            return this.ny().felt(felt).autoResolve().build();
        }
    }

    public void reset() {
        formelProvider.getFormelMap().clear();
    }

    public IFormelProvider getFormelProvider() {
        return formelProvider;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("IFormelProvider: '" + formelProvider.getClass().getSimpleName() + "'\tformelMap.size: " + formelProvider.getFormelMap().size() + "\n");
        for (Map.Entry<String, Formel> pair : formelProvider.getFormelMap().entrySet()) {
            s.append("DomainFormel [key:" + pair.getKey() + "]\n" + pair.getValue().toString());
        }
        return s.toString();
    }
}