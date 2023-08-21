package no.nav.pensjon.regler.domain.util;

import java.lang.reflect.Field;

/**
 * toString-metoden som var kopiert til flere klasser.
 */
public class ToStringUtil {

    private static String newLine;

    public static String toString(Object instance) {
        StringBuilder result = new StringBuilder();

        Class<? extends Object> clazz = instance.getClass();
        result.append(clazz.getName());
        result.append(" Object {");
        result.append(getNewLine());

        // determine fields declared in this class only (no fields of
        // superclass)
        Field[] fields = clazz.getDeclaredFields();

        // print field names paired with their values
        for (Field field : fields) {
            String fieldName = field.getName();
            if (fieldName.compareTo("serialVersionUID") != 0 && !fieldName.startsWith("PREG")) {
                result.append("  ");
                result.append(fieldName);
                result.append(": ");
                try {
                    field.setAccessible(true);
                    result.append(field.get(instance));
                } catch (IllegalAccessException ex) {
                    result.append(ex);
                } catch (SecurityException e) {
                    result.append(e);
                }
                result.append(getNewLine());
            }
        }
        result.append("}");

        return result.toString();
    }

    private static String getNewLine() {
        return newLine == null ? newLine = System.getProperty("line.separator") : newLine;
    }
}
