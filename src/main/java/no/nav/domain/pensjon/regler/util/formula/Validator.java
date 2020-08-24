package no.nav.domain.pensjon.regler.util.formula;

import no.nav.domain.pensjon.regler.error.InvalidFormulaException;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.Map;

public class Validator {

    public static void validate(Formel formel, Formler formler) {
        if (formel.isDomain()) {
            Field field = FieldUtils.getField(formler.getFormelProvider().getClass(), formel.getFelt(), true);
            if (field == null)
                error(formel.getNavn(), "Felt '" + formel.getFelt() + "' does not exist in '" + formler.getFormelProvider().getClass().getSimpleName() + "'.");
            if (formel.getResultat() != null)
                error(formel.getNavn(), "Domain formel may not specify a resultat ('" + formel.getResultat() + "').");
        }

        for (Map.Entry<String, Formel> pair : formel.getFormelVarMap().entrySet()) {
            if (pair.getValue() == null)
                error(formel.getNavn(), "SubFormel with '" + pair.getKey() + "' is null.");
            if (pair.getValue().isRenameAllowed()) {
                if (formel.getVarMap().containsKey(pair.getValue().getNavn()) && formel.getVarMap().get(pair.getValue().getNavn()).doubleValue() != pair.getValue().getResultat().doubleValue())
                    error(formel.getNavn(), "Variable '" + pair.getValue().getNavn() + ":" + pair.getValue().getResultat().doubleValue() + "' was already defined as '" + pair.getValue().getNavn() + ":" + formel.getVarMap().get(pair.getValue().getNavn()) + "'.");
            } else {
                if (pair.getValue().getNavn() == null)
                    error(formel.getNavn(), "SubFormel key '" + pair.getKey() + "' has no name and rename not allowed.");
                if (formel.getVarMap().containsKey(pair.getKey()) && formel.getVarMap().get(pair.getKey()).doubleValue() != pair.getValue().getResultat().doubleValue())
                    error(formel.getNavn(), "Variable '" + pair.getKey() + ":" + pair.getValue().getResultat().doubleValue() + "' was already defined as '" + pair.getKey() + ":" + formel.getVarMap().get(pair.getKey()) + "'.");
            }
        }

        /*
            Formel may not contain a subformel with a name that conflicts with other tokens in the notasjon expression.
         */
        formel.getFormelVarMap().forEach((subformelKey, subformel) -> {
            if (subformel.getNavn() == null && !subformel.isRenameAllowed()) {
                error(formel.getNavn(), "Subformel navn is NULL and rename not allowed.");
            }
            if (!subformel.isRenameAllowed() && !subformel.getNavn().equals(subformelKey) && formel.getTokenSet().contains(subformel.getNavn())) {
                error(formel.getNavn(), "Subformel name and token conflict: '" + subformel.getNavn() + "'.");
            }
        });
    }

    private static void error(String formelnavn, String msg) {
        throw new InvalidFormulaException("Formel '" + formelnavn + "' invalid. " + msg);
    }

}
