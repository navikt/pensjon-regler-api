package no.nav.domain.pensjon.regler;

import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.*;

/**
 * Liste wrapper med property change support
 * 
 * @author Torje Coldevin (TCA2812)
 * @param <T>
 */
class NotifyingListWrapper<T> implements List<T>, Serializable {


    private String propertyName;
    private String arrayName;
    private List<T> liste;
    private PropertyChangeSupport pcsWrapper;

    /**
     * @param propertyName, property som skal informeres. F.eks argumentListeAsArray for Merknader.
     * @param arrayName, navn på liste/property. F.eks argumentListe for Merknader.
     * @param pcs, PropertyChangeSupport implementasjon
     */
    public NotifyingListWrapper(String propertyName, String arrayName, PropertyChangeSupport pcs, List<T> liste) {
        this.propertyName = propertyName;
        this.arrayName = arrayName;
        this.liste = liste;
        this.pcsWrapper = pcs;
    }

    /**
     * @param propertyName, property som skal informeres. F.eks argumentListeAsArray for Merknader.
     * @param arrayName, navn på liste/property. F.eks argumentListe for Merknader.
     * @param pcs, PropertyChangeSupport implementasjon
     */
    public NotifyingListWrapper(String propertyName, String arrayName, PropertyChangeSupport pcs) {
        this(propertyName, arrayName, pcs, new ArrayList<T>());
    }

    /**
     * Copy Constructor
     * 
     * @param wrapperListe
     */
    public NotifyingListWrapper(NotifyingListWrapper<T> wrapperListe) {
        this.propertyName = wrapperListe.propertyName;
        this.arrayName = wrapperListe.arrayName;
        this.liste = wrapperListe.liste;
        this.pcsWrapper = wrapperListe.pcsWrapper;

    }

    public void setListe(List<T> merknadListe) {
        liste = merknadListe;
    }

    public List<T> getListe() {
        return liste;
    }

    @Override
    public boolean add(T object) {
        boolean result = liste.add(object);
        pcsWrapper.firePropertyChange(propertyName, null, object);
        pcsWrapper.firePropertyChange(arrayName, null, object);
        System.out.println("add: " + object);
        return result;
    }

    @Override
    public void add(int location, T object) {
        pcsWrapper.firePropertyChange(propertyName, null, object);
        pcsWrapper.firePropertyChange(arrayName, null, object);
        liste.add(object);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (Object o : collection) {
            pcsWrapper.firePropertyChange(propertyName, null, o);
            pcsWrapper.firePropertyChange(arrayName, null, o);
        }
        return liste.addAll(collection);
    }

    @Override
    public boolean addAll(int location, Collection<? extends T> collection) {
        for (Object o : collection) {
            pcsWrapper.firePropertyChange(propertyName, null, o);
            pcsWrapper.firePropertyChange(arrayName, null, o);
        }
        return liste.addAll(location, collection);
    }

    @Override
    public void clear() {
        liste.clear();
    }

    @Override
    public boolean contains(Object object) {
        return liste.contains(object);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return liste.containsAll(collection);
    }

    @Override
    public T get(int location) {
        return liste.get(location);
    }

    @Override
    public int indexOf(Object object) {
        return liste.indexOf(object);
    }

    @Override
    public boolean isEmpty() {
        return liste.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return liste.iterator();
    }

    @Override
    public int lastIndexOf(Object object) {
        return liste.lastIndexOf(object);
    }

    @Override
    public ListIterator<T> listIterator() {
        return liste.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int location) {
        return liste.listIterator(location);
    }

    @Override
    public T remove(int location) {
        pcsWrapper.firePropertyChange(propertyName, liste.get(location), null);
        pcsWrapper.firePropertyChange(arrayName, liste.get(location), null);
        return liste.remove(location);
    }

    @Override
    public boolean remove(Object object) {
        pcsWrapper.firePropertyChange(propertyName, object, null);
        pcsWrapper.firePropertyChange(arrayName, object, null);
        return liste.remove(object);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        for (Object o : collection) {
            pcsWrapper.firePropertyChange(propertyName, o, null);
            pcsWrapper.firePropertyChange(arrayName, o, null);
        }
        return liste.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return liste.retainAll(collection);
    }

    @Override
    public T set(int location, T object) {
        return liste.set(location, object);
    }

    @Override
    public int size() {
        return liste.size();
    }

    @Override
    public List<T> subList(int start, int end) {
        return liste.subList(start, end);
    }

    @Override
    public Object[] toArray() {
        return liste.toArray();
    }

    @Override
    @SuppressWarnings("hiding")
    public <T> T[] toArray(T[] array) {
        return liste.toArray(array);
    }
}
