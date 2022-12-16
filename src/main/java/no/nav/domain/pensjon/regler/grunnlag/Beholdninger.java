package no.nav.domain.pensjon.regler.grunnlag;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Beholdninger implements Serializable {

    private List<Beholdning> beholdninger = new ArrayList<Beholdning>();


}
