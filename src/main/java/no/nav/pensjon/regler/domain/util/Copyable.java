package no.nav.pensjon.regler.domain.util;

public interface Copyable<T> {
    T deepCopy();
}
