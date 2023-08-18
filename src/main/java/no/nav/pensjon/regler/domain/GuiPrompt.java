package no.nav.pensjon.regler.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for domain classes to enable storing text for possible use as field prompt in GUI such as RMA.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GuiPrompt {
    String prompt();
}
