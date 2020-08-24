package no.nav.domain.pensjon.regler.util.formula;

import no.nav.domain.pensjon.regler.error.InvalidFormulaException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Resolver {
    private static final String EXPRESSION_TOKENIZER_REGEX = "\\*|\\/|\\+|\\-|\\(|\\)|,|\\[|]";
    private static final Pattern OPTIONAL_NOTASJON_PATTERN = Pattern.compile("\\[(.*?)]");

    // TODO Logging.
    private static final Logger logger = Logger.getLogger(Resolver.class.getName());

    public static void resolve(Formel f, Formler fm) throws InvalidFormulaException {
        logger.setLevel(Level.OFF);

        createName(f, fm);
        cleanup(f);
        tokenize(f);
        Validator.validate(f, fm);
        removeOptional(f);
        calculateVekt(f);
        Constructor.construct(f);
        determineResultat(f, fm);
        Evaluator.verifyFormel(f);
        saveFormelToDomain(f, fm);
    }

    private static void createName(Formel f, Formler fm) {
        String navn;

        if (!f.isDomain()) {
            navn = f.getEmne();
        } else {
            navn = fm.getFormelProvider().getFormelPrefix() + "_" + f.getFelt();
            if (f.getEmne() != null)
                navn = navn + "_" + f.getEmne();
        }
        f.setNavn(navn);
    }

    private static void saveFormelToDomain(Formel f, Formler fm) {
        if (f.isDomain())
            fm.getFormelProvider().getFormelMap().put(f.getFelt(), f);
    }

    private static void cleanup(Formel f) {
        String[] operators = {"+", "-", "/", "*"};
        String n = f.getNotasjon().trim();
        for (String operator : operators) {
            n = stripChar(n, operator);
        }
        f.setNotasjon(n);
    }

    private static String stripChar(String str, String c) {
        str = StringUtils.stripStart(str, c);
        str = StringUtils.stripEnd(str, c);
        return str.trim();
    }

    private static void determineResultat(Formel f, Formler fm) {
        if (f.isDomain()) {
            Field field = FieldUtils.getField(fm.getFormelProvider().getClass(), f.getFelt(), true);
            try {
                logger.info("Field '" + field.getName() + "' of type '" + field.getGenericType().getTypeName() + "' with value '" + field.get(fm.getFormelProvider()) + "'. Formula: '" + f.getNavn() + ":" + f.getResultat() + "'");
                f.setResultat((Number) field.get(fm.getFormelProvider()));
                f.setRequiresValidation(true);
            } catch (IllegalAccessException e) {
                throw new InvalidFormulaException("Formula '" + f.getNavn() + "' invalid. Cannot access domain field: '" + f.getFelt() + "'.");
            }
        } else if (f.getResultat() == null) {
            double evaluation = Evaluator.evaluate(f.getNotasjon(), f.getVarMap());
            if (evaluation % 1 == 0) {
                f.setResultat((int) evaluation);
            } else {
                f.setResultat(evaluation);
            }
            f.setRequiresValidation(false);
        } else if (f.getResultat() != null) {
            f.setRequiresValidation(true);
        }
        if (f.isAutoResolve()) {
            f.setNotasjon(f.getResultat().toString());
            f.setInnhold(f.getNotasjon());
            f.setRequiresValidation(false);
        }
    }

    private static void tokenize(Formel f) {
        Arrays.asList(f.getNotasjon().split(EXPRESSION_TOKENIZER_REGEX))
                .forEach(token -> {
                            token = token.trim();
                            if (token.length() > 0)
                                f.getTokenSet().add(token);
                        }
                );
    }

    private static void removeOptional(Formel f) {
        HashSet<String> removedVarTokenSet = new HashSet<>();
        Matcher m = OPTIONAL_NOTASJON_PATTERN.matcher(f.getNotasjon());
        while (m.find()) {
            String optionalExpression = m.group(1);

            List<String> tokens = Arrays.asList(optionalExpression.split(EXPRESSION_TOKENIZER_REGEX));
            tokens.forEach(token -> {
                        token = token.trim();
                        if (f.getFormelVarMap().containsKey(token))
                            throw new InvalidFormulaException("Formel '" + f.getNavn() + "' invalid. Optional expression token for Formel ('" + token + "') not supported.");
                    }
            );

            double evaluation = Evaluator.evaluate("1 " + optionalExpression, f.getVarMap());
            if (evaluation == 1.00) {
                logger.info("[FormelResolver.removeOptional] Optional notasjon: '" + optionalExpression + "' evaluated to '" + evaluation + "'. Discarding.");
                f.setNotasjon(f.getNotasjon().replaceAll("\\[" + Pattern.quote(optionalExpression) + "]", "").trim());

                tokens.forEach(token -> {
                            token = token.trim();
                            if (f.getVarMap().containsKey(token))
                                removedVarTokenSet.add(token);
                        }
                );
            } else {
                logger.info("[FormelResolver.removeOptional] Optional notasjon: '" + optionalExpression + "' evaluated to '" + evaluation + "'. Debracketing.");
                f.setNotasjon(f.getNotasjon().replaceAll("\\[" + Pattern.quote(optionalExpression) + "]", optionalExpression).trim());
            }
        }
        for (String token : removedVarTokenSet) {
            if (!f.getNotasjon().contains(token)) {
                logger.info("[FormelResolver.removeOptional] Optional var: '" + token + "' REMOVED from varMap.");
                f.getVarMap().remove(token);
            }
        }
    }

    private static void calculateVekt(Formel f) {
        f.setVekt(f.getVekt() + f.getNotasjon().length());
    }

}
