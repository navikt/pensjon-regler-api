package no.nav.pensjon.regler.domain.util;

public class Avrunding {
    public static double avrundSpt(double d1, double d2) {
        double d, d3 = 0;

        d = d1 * 1000000 / d2; // Justerer resultatet slik at de seks første desimalene i resultatet kommer til venstre for desimalkomma
        d3 = d % 1;   // finner desimalene som er igjen
        d = d - d3; //Har et tall uten desimaler etter  den 5.
        d3 = d % 10000; //Finner de fire siste desimalene

        if (d3 == 4999.0) {
            d += 1; // sørger for justering
        }

        d = Math.round(d * 0.0001); //avrunder slik at vi bare har 2 desimaler
        d = d / 100; //justerer slik at desimalene er på høyre side av desimalpunktet
        return d;
    }

    public static double avrund2Desimaler(double d1) {
        return Avrunding.avrundSpt(d1, 1.0);
    }
}
