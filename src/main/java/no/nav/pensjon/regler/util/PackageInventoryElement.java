package no.nav.pensjon.regler.util;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by H116437 on 07.12.2015.
 */
public class PackageInventoryElement {

    public String klasseNavn;
    public TreeSet<PackageInventoryProperty> properties = new TreeSet<PackageInventoryProperty>(new Comparator<PackageInventoryProperty>() {
        @Override
        public int compare(PackageInventoryProperty p1, PackageInventoryProperty p2) {
            return p1.propertyNavn.compareTo(p2.propertyNavn);
        }
    });
}
