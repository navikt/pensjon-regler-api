package no.nav.pensjon.regler.domain.kode

import java.io.Serializable
import java.util.*

open class TypeCti : Serializable {
    var kode: String? = null
    var dekode: String? = null
    var dato_fom: Date? = null
    var dato_tom: Date? = null
    var er_gyldig = false
    var kommentar: String? = null

    constructor(typeCti: TypeCti) {
        kode = typeCti.kode
        dekode = typeCti.dekode
        if (typeCti.dato_fom != null) {
            dato_fom = typeCti.dato_fom!!.clone() as Date
        }
        if (typeCti.dato_tom != null) {
            dato_tom = typeCti.dato_tom!!.clone() as Date
        }
        er_gyldig = typeCti.er_gyldig
        kommentar = typeCti.kommentar
    }

    constructor() : super()
    constructor(kode: String?) : super() {
        this.kode = kode
        er_gyldig = true
    }

    /*
     * Simple version to print kode field only.
     * @see java.lang.Object#toString()
     */
    override fun toString(): String {
        val result = StringBuilder()
        val newLine = System.getProperty("line.separator")
        result.append(this.javaClass.simpleName)
        result.append(" { kode: ")
        result.append(kode)
        result.append(" }")
        result.append(newLine)
        return result.toString()
    }
}