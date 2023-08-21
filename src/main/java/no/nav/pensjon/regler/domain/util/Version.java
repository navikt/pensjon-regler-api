package no.nav.pensjon.regler.domain.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Version {

    private static class VersionHolder {
        private static String version = "UNKNOWN_VERSION";

        static {
            InputStream is = null;
            try {
                is = Version.class.getResourceAsStream("/META-INF/maven/no.nav.preg-layers.domain/nav-domain-pensjon-regler-java/pom.properties");
                if (is == null) {
                    //kjøring fra eclipse
                    is = new FileInputStream("target/maven-archiver/pom.properties");
                }
                Properties props = new Properties();
                props.load(is);
                version = props.getProperty("version");
            } catch (Exception e) {
                System.out.println("Problemer med lesing av properties-fil, versjon settes til: " + version);
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
    }

    public static final String get() {
        return VersionHolder.version;
    }

}
