package no.nav.pensjon.regler.domain.beregning2011

import no.nav.pensjon.regler.domain.enum.JusteringsTypeEnum
import java.io.Serializable
import java.lang.reflect.Constructor
import java.lang.reflect.InvocationTargetException

open class JusteringsInformasjon : Serializable {
    var totalJusteringsfaktor = 0.0
    var justeringsTypeEnum: JusteringsTypeEnum? = null

    var elementer: MutableList<IJustering> = mutableListOf()

    constructor()
    constructor(ji: JusteringsInformasjon) : this() {
        totalJusteringsfaktor = ji.totalJusteringsfaktor
        if (ji.justeringsTypeEnum != null) {
            justeringsTypeEnum = ji.justeringsTypeEnum
        }
        for (ij in ji.elementer) {
            val clazz: Class<out IJustering> = ij.javaClass
            try {
                val constructor: Constructor<*> = clazz.getConstructor(*arrayOf<Class<*>>(clazz))
                elementer.add((constructor.newInstance(ij) as IJustering))
            } catch (e: InvocationTargetException) {
                //Vil kastes hvis copy constructor f.eks. ledet til nullpointerexception.
                val cause = e.cause
                if (cause is RuntimeException) {
                    throw (cause as RuntimeException?)!!
                } else {
                    throw RuntimeException(e)
                }
            } catch (e: Exception) {
                //Vil kastes hvis f.eks. copy constructor ikke finnes for komponenten.
                throw RuntimeException(e)
            }
        }
    }

    constructor(
        totalJusteringsfaktor: Double = 0.0,
        justeringsTypeEnum: JusteringsTypeEnum? = null,
        elementer: MutableList<IJustering> = mutableListOf()
    ) {
        this.totalJusteringsfaktor = totalJusteringsfaktor
        this.justeringsTypeEnum = justeringsTypeEnum
        this.elementer = elementer
    }
}