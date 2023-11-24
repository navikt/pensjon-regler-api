package no.nav.pensjon.regler

import org.junit.Ignore
import org.junit.Test
import java.io.File
import java.net.URLClassLoader

class PackageComparisonTest {

    private fun listKotlinFilesInDirectory(directoryPath: String): MutableList<String> {
        val listOfFilesPaths = mutableListOf<String>()
        val directory = File(directoryPath)

        if (directory.exists() && directory.isDirectory) {
            val kotlinFiles = directory.listFiles { file ->
                file.isFile && file.extension == "kt"
            }

            if (kotlinFiles != null) {
                for (file in kotlinFiles) {
                    listOfFilesPaths.add(file.absolutePath)
                }
            } else {
                println("No Kotlin files found in the directory.")
            }
        } else {
            println("The specified directory does not exist or is not a directory.")
        }

        return listOfFilesPaths

    }

    @Test
    @Ignore
    fun test() {
        val pregApi =
            listKotlinFilesInDirectory("C:\\data\\preg-api\\src\\main\\kotlin\\no\\nav\\pensjon\\regler\\domain")

        val pensjonRegler =
            listKotlinFilesInDirectory("C:\\data\\pensjon-regler\\system\\nav-system-pensjon-domain\\src\\main\\kotlin\\no\\nav\\pensjon\\regler\\domain")

        val pregList = mutableListOf<Class<*>>()
        val pensjonReglerList = mutableListOf<Class<*>>()
        pregApi.forEach {
            pregList.add(loadObjectFromKotlinClassFile(it))
        }
        pensjonRegler.forEach {
            pensjonReglerList.add(loadObjectFromKotlinClassFile(it))
        }

        println(pregApi)
    }

}

fun loadObjectFromKotlinClassFile(filePath: String): Class<*> {
    val file = File(filePath)
    if (!file.exists() || !file.isFile) {
        println("Class file not found: $filePath")
        throw IllegalArgumentException("Class file not file")
    }

    val fileName = filePath.split("\\").last().removeSuffix(".kt")

    val url = file.toURI().toURL()
    val classLoader = URLClassLoader(arrayOf(url))
    return Class.forName("no.nav.pensjon.regler.domain.$fileName", true, classLoader)
}