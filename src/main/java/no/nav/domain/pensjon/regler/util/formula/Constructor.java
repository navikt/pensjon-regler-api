package no.nav.domain.pensjon.regler.util.formula;

import no.nav.domain.pensjon.regler.error.InvalidFormulaException;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *  Understands how to combine tokens in an expression with subformulas.
 */
public class Constructor {
    private static final int MAX_FORMEL_WEIGHT = 100;

    private static final Logger logger = Logger.getLogger(Constructor.class.getName());

    public static void construct(Formel f) {
        logger.setLevel(Level.OFF);
        f.setInnhold(f.getNotasjon());
        logger.info("[FormelResolver.construct] formula: '" + f.getNavn() + "' felt: '" + f.getFelt() + "' isDomain: " + f.isDomain() + " tokenSet: " + f.getTokenSet() + "\t notasjon: '" + f.getNotasjon() + "'\t vekt: " + f.getVekt() + "\tvars: " + f.getVarMap().toString());
        for (String token : f.getTokenSet()) {
            Formel subFormel = f.getFormelVarMap().get(token);
            if (subFormel != null) {
                /* Token is referencing a subFormel. */
                combine(token, f, subFormel);
            } else if (f.getVarMap().containsKey(token)) {
                /* Token is referencing a variable. */
                logger.info("[FormelResolver.construct] variable token '" + token + "'\tvar: " + f.getVarMap().get(token));
                f.setInnhold(f.getInnhold().replaceAll("\\b" + token + "\\b", f.getVarMap().get(token).toString()));
            }
        }
    }

    private static void combine(String token, Formel formel, Formel subFormel) {
        if (!checkCanConsume(formel, subFormel)) {
            if (subFormel.getResultat() == null)
                throw new InvalidFormulaException("SubFormula '" + subFormel.getNavn() + "' invalid. Result is null.");
            if (subFormel.isRenameAllowed()) {
                logger.info("[FormelResolver.combine] Formel '" + formel.getNavn() + "'. Subformel '" + subFormel.getNavn() + ":" + subFormel.getResultat() + "' not consumed. Referenced using '" + token + "' (subformel rename allowed).");
                subFormel.setNavn(token);
            } else {
                logger.info("[FormelResolver.combine] Formel '" + formel.getNavn() + "'. Subformel '" + subFormel.getNavn() + ":" + subFormel.getResultat() + "' not consumed. Token '" + token + "' replaced with '" + subFormel.getNavn() + "' (subformel rename not allowed).");
                formel.setNotasjon(formel.getNotasjon().replaceAll("\\b" + token + "\\b", subFormel.getNavn()));
                if (!token.equals(subFormel.getNavn())) {
                    Formel f = formel.getFormelVarMap().remove(token);
                    formel.getFormelVarMap().put(f.getNavn(), f);
                }
            }

            formel.setInnhold(formel.getInnhold().replaceAll("\\b" + token + "\\b", subFormel.getResultat().toString()));
            formel.getVarMap().put(subFormel.getNavn(), subFormel.getResultat());
            formel.getSubFormelList().add(subFormel);
        } else {
            formel.setVekt(formel.getVekt() + subFormel.getVekt());
            logger.info("[FormelResolver.combine] Formel '" + formel.getNavn() + "'. Subformel '" + subFormel.getNavn() + ":" + subFormel.getResultat() + "' consumed.  Token '" + token + "' replaced with '" + subFormel.getNotasjon() + "'");
            formel.setNotasjon(resolveSubexpression(token, formel.getNotasjon(), subFormel.getNotasjon()));
            formel.setInnhold(resolveSubexpression(token, formel.getInnhold(), subFormel.getInnhold()));
            for (Map.Entry<String, Number> pair : subFormel.getVarMap().entrySet()) {
                formel.getVarMap().put(pair.getKey(), pair.getValue());
            }
            formel.getSubFormelList().addAll(subFormel.getSubFormelList());
        }
    }

    private static boolean checkCanConsume(Formel formel, Formel subFormel) {
        int combinedWeight = formel.getVekt() + subFormel.getVekt();
        if (combinedWeight > MAX_FORMEL_WEIGHT) {
            logger.info("[FormelResolver.checkCanConsume] formula '" + formel.getNavn() + "' (" + formel.getVekt() + ") cannot consume subFormel '" + subFormel.getNavn() + "' (" + subFormel.getVekt() + "). Sum (" + combinedWeight + ") too heavy.");
            return false;
        } else {
            for (Map.Entry<String, Number> pair : subFormel.getVarMap().entrySet()) {
                if (formel.getVarMap().containsKey(pair.getKey()) && formel.getVarMap().get(pair.getKey()).doubleValue() != pair.getValue().doubleValue()) {
                    logger.info("[FormelResolver.checkCanConsume] formula '" + formel.getNavn() + "' cannot consume subFormel '" + subFormel.getNavn() + "'. Incompatible var " + pair.toString() + ". Original value: " + formel.getVarMap().get(pair.getKey()));
                    return false;
                }
            }
            logger.info("[FormelResolver.checkCanConsume] formula '" + formel.getNavn() + "' (" + formel.getVekt() + ") consuming subFormel '" + subFormel.getNavn() + "' (" + subFormel.getVekt() + "). Sum (" + combinedWeight + ") below threshold.");
            return true;
        }
    }

    private static String resolveSubexpression(String token, String expression, String subExpression) {
        Pattern tokenPattern = Pattern.compile("\\b" + token + "\\b");
        Matcher tokenMatcher = tokenPattern.matcher(expression);
        StringBuffer sb = new StringBuffer();
        while (tokenMatcher.find()) {
            String leftContext = expression.substring(0, tokenMatcher.start()).trim();
            String rightContext = expression.substring(tokenMatcher.end()).trim();
            if (needsParanthesis(leftContext, rightContext, subExpression)) {
                tokenMatcher.appendReplacement(sb, "(" + subExpression + ")");
            } else {
                tokenMatcher.appendReplacement(sb, subExpression);
            }
        }
        tokenMatcher.appendTail(sb);
        return sb.toString();
    }

    private static boolean needsParanthesis(String leftContext, String rightContext, String subExpression) {
        if (leftContext.endsWith("(") && rightContext.startsWith(")"))
            return false;
        if (leftContext.endsWith("*") || leftContext.endsWith("/") || rightContext.startsWith("*") || rightContext.startsWith("/")) {
            if (subExpression.contains("-") || subExpression.contains("+"))
                return true;
        }
        return leftContext.endsWith("-") && (subExpression.contains("-") || subExpression.contains("+"));
    }
}
