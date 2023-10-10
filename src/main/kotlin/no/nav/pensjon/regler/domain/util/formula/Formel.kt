package no.nav.pensjon.regler.domain.util.formula

import org.apache.commons.lang3.StringUtils
import java.io.Serializable

class Formel : Serializable {
    var navn: String? = null
    var emne: String = ""
    var prefix: String = ""
    var felt: String? = null
    var resultat: Number? = null
    var notasjon: String = ""
    var innhold: String = ""
    var vekt = 0
    var requiresValidation = false
    var renameAllowed = false
    var domain = false
    var autoResolve = false
    var varMap: HashMap<String, Number> = HashMap()
    var formelVarMap: HashMap<String, Formel> = HashMap()
    var subFormelList: ArrayList<Formel> = ArrayList()
    var tokenSet: HashSet<String> = HashSet()

    constructor()
    constructor(f: Formel) {
        navn = f.navn
        emne = f.emne
        prefix = f.prefix
        felt = f.felt
        resultat = f.resultat
        notasjon = f.notasjon
        innhold = f.innhold
        vekt = f.vekt
        this.requiresValidation = f.requiresValidation
        this.renameAllowed = f.renameAllowed
        this.domain = f.domain
        this.autoResolve = f.autoResolve
        tokenSet = HashSet(f.tokenSet)
        varMap = HashMap(f.varMap)
        formelVarMap = HashMap()
        if (f.formelVarMap.isNotEmpty()) {
            f.formelVarMap.forEach { (key, value) ->
                formelVarMap[key] = Formel(value)
            }
        }
        subFormelList = java.util.ArrayList()
        for (subFormel in f.subFormelList) {
            subFormelList.add(Formel(subFormel))
        }
    }

    override fun toString(): String {
        return toTreeString(0, Int.MAX_VALUE)
    }

    fun toString(maxLevel: Int): String {
        return toTreeString(0, maxLevel)
    }

    private fun toTreeString(level: Int, maxLevel: Int): String {
        val s = StringBuilder()
        s.append(StringUtils.repeat(' ', level * 2)).append(
            """Formelnavn: '$navn' felt: '${if (felt == null) "---" else felt}' domain: ${domain} level: $level resultat: ${if (resultat == null) "---" else resultat} vekt: $vekt ant.subFormler: ${subFormelList.size} hash: ${this.hashCode()}
"""
        )
        s.append(StringUtils.repeat(' ', level * 2)).append("    notasjon:\t'$notasjon'\n")
        s.append(StringUtils.repeat(' ', level * 2))
            .append("    innhold: \t'" + innhold + "'" + (if (resultat == null) "" else " = $resultat") + "\n")
        s.append(StringUtils.repeat(' ', level * 2)).append("    varMap:  \t$varMap\n")
        s.append(StringUtils.repeat(' ', level * 2)).append("    formelVarMap (keys):  \t" + formelVarMap.keys + "\n")
        if (level < maxLevel) {
            for (f in subFormelList) {
                s.append(f.toTreeString(level + 1, maxLevel))
            }
        }
        return s.toString()
    }

    fun toHTML(): String {
        return toTreeHTML(0, Int.MAX_VALUE)
    }

    fun toHTML(maxLevel: Int): String {
        return toTreeHTML(0, maxLevel)
    }

    fun toTreeHTML(level: Int, maxLevel: Int): String {
        val s = StringBuilder()
        s.append(StringUtils.repeat(' ', level * 2)).append(
            """
    <formel title='$navn' felt='${if (felt == null) "---" else felt}' domain='${domain}' level='$level' resultat='${if (resultat == null) "---" else resultat}' vekt='$vekt' antSubFormler='${subFormelList.size}' >
    
    """.trimIndent()
        )
        s.append(StringUtils.repeat(' ', level * 2 + 2)).append("<fl>$navn = $notasjon</fl>\n")
        s.append(StringUtils.repeat(' ', level * 2 + 2)).append("<fl>$navn = $innhold</fl>\n")
        s.append(StringUtils.repeat(' ', level * 2 + 2)).append("<fl>$navn = $resultat</fl>\n")
        if (level < maxLevel) {
            for (f in subFormelList) {
                s.append(f.toTreeHTML(level + 1, maxLevel))
            }
        }
        s.append(StringUtils.repeat(' ', level * 2)).append("</formel>\n")
        return s.toString()
    }

}