package no.nav.pensjon.regler.domain.util;

public class Avrunding {
    // public static double avrundSpt(double d1, double d2) {
    //  double d = d1;
    //  if (d2 != 1.0)
    //   d= Math.round((100.0*d1)/d2)*0.01;
    //  
    //  BigDecimal bd = new BigDecimal( d );
    //  // Har problemer med Half_Down når desimalene etter 3. desimal er 0
    //  double d3 = d*10000;
    //  d3 =d3%10;
    //  if ( d3 == 0.0 )
    //   bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
    //  else
    //   bd = bd.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    //  
    //  //bd = bd.setScale(2, BigDecimal.ROUND_HALF_DOWN);
    //  //System.out.println("avrundSpt: " + d1 + " " + d2 + " " + bd + " " + bd.doubleValue() + " d " + d);
    //  return bd.doubleValue();
    // }
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
        //  //System.out.println(" d1 " + d1);
        //  if ( d1 <= 0.0 )
        //   return 0.0;
        //  double d;
        //  d1 = d1*1000;
        //  d = d1%10;
        //  //System.out.println(" d " + d + " d1 " + d);
        //  d1 = d1 - d;
        //  if ( d >= 5.0 )
        //   d1 += 10;    
        //  return d1/1000.0; 
        return Avrunding.avrundSpt(d1, 1.0);
    }
}
