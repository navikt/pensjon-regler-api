package no.nav.domain.pensjon.regler.util.formula;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;
import no.nav.domain.pensjon.regler.error.InvalidFormulaException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class Evaluator {
    private static final Logger logger = Logger.getLogger(Evaluator.class.getName());

    public static void verifyFormel(Formel f) throws InvalidFormulaException {
        logger.setLevel(Level.OFF);
        double evaluationResultNotasjon = evaluate(f.getNotasjon(), f.getVarMap());
        double evaluationResultInnhold = evaluate(f.getInnhold());
        logger.info("[Evaluator.verifyEvaluation] Formel '" + f.getNavn() + "' expected evaluation '" + f.getResultat() + "' actual: " + evaluationResultNotasjon + "/" + evaluationResultInnhold + " (notasjon/innhold). Requires validation: " + f.isRequiresValidation());
        if (evaluationResultNotasjon != evaluationResultInnhold) {
            throw new InvalidFormulaException("Formel '" + f.getNavn() + "' failed result validation. Notasjon evaluation '" + evaluationResultNotasjon + "' not equal to innhold evaluation '" + evaluationResultInnhold + "'.\n" + f.toString(0));
        }
        if (f.isRequiresValidation() && Math.abs(f.getResultat().doubleValue() - evaluationResultNotasjon) > CommonDefs.MARGIN_OF_ERROR) {
            throw new InvalidFormulaException("Formel '" + f.getNavn() + "' failed result validation. Expected evaluation '" + f.getResultat() + "' but got notasjon '" + evaluationResultNotasjon + "' and innhold '" + evaluationResultInnhold + "'.\n" + f.toString(0));
        }
    }

    static double evaluate(String exp) {
        return evaluate(exp, new HashMap<>());
    }

    static double evaluate(String exp, HashMap<String, Number> varMap) throws InvalidFormulaException {
        String[] variableNames = varMap.keySet().toArray(new String[0]);
        Expression expression = new ExpressionBuilder(exp)
                .functions(CommonDefs.functions)
                .operator(CommonDefs.operators)
                .variables(variableNames)
                .build();

        for (Map.Entry<String, Number> pair : varMap.entrySet()) {
            expression.setVariable(pair.getKey(), pair.getValue().doubleValue());
        }

        ValidationResult vr = expression.validate();
        if (!vr.isValid())
            throw new InvalidFormulaException("Expression '" + exp + "' failed integrity validation. Errors '" + vr.getErrors() + "'");

        return expression.evaluate();
    }
}
