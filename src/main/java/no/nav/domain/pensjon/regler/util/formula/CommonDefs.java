package no.nav.domain.pensjon.regler.util.formula;

import net.objecthunter.exp4j.function.Function;
import net.objecthunter.exp4j.operator.Operator;

import java.util.ArrayList;

/*
 *  Holds functions names and their implementation and operators for commonly used functions in SRL.
 */
public class CommonDefs {
    public static final double MARGIN_OF_ERROR = 0.01;

    private static final Function avrundFunction = new Function("avrund", 1) {
        @Override
        public double apply(double... args) {
            return Math.round(args[0]);
        }
    };

    private static final Function afpAvrundBruttoFunction = new Function("afpAvrundBrutto", 1) {
        @Override
        public double apply(double... args) {
            double årsbeløp = Math.floor((args[0] + 0.005) * 100) / 100;
            return Math.floor(årsbeløp / 12 + 0.5);
        }
    };

    private static final Function afpAvrundNettoFunction = new Function("afpAvrundNetto", 2) {
        @Override
        public double apply(double... args) {
            double årsbeløp = Math.floor((args[0] + 0.005) * 100) / 100;
            return Math.floor(årsbeløp / 12 * args[1] / 100 + 0.5);
        }
    };

    private static final Function minFunction = new Function("min", 2) {
        @Override
        public double apply(double... args) {
            return Math.min(args[0], args[1]);
        }
    };

    private static final Function maxFunction = new Function("max", 2) {
        @Override
        public double apply(double... args) {
            return Math.max(args[0], args[1]);
        }
    };

    private static final Operator percentage = new Operator("%", 1, true, Operator.PRECEDENCE_POWER + 1) {
        @Override
        public double apply(double... args) {
            return args[0] / 100;
        }
    };

    static ArrayList<Function> functions = new ArrayList<Function>() {{
        add(avrundFunction);
        add(afpAvrundBruttoFunction);
        add(afpAvrundNettoFunction);
        add(minFunction);
        add(maxFunction);
    }};

    static ArrayList<Operator> operators = new ArrayList<Operator>() {{
        add(percentage);
    }};
}
