package no.nav.domain.pensjon.regler.beregning2011;

import no.nav.domain.pensjon.regler.kode.JusteringsTypeCti;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class JusteringsInformasjon implements Serializable {
    

    private double totalJusteringsfaktor;
    private JusteringsTypeCti justeringsTypeCti;
    private List<IJustering> elementer = new ArrayList<IJustering>();

}
