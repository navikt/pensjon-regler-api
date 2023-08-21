package no.nav.pensjon.regler.util;

import java.io.File;

/**
 * Metadata for each sourcefile found in Blaze Advisor rule repository.
 * Most fields are populated by reading the .innovator_attbs file.
 *
 * @author Steinar Hjellvik (Decisive AS)
 */
public class RepositoryElement implements Comparable<RepositoryElement> {

    public enum SourceCategory {
        RULESET, RULEFLOW, FUNCTION, CLASS, PROJECT
    };
    public SourceCategory sourceType;
    public String ideName;
    public String fileName;
    public String dirName;
    public String type;
    public String contentType;
    public String guid;
    public boolean testRole;
    public File file;
    public RepositoryElement project;


    @Override
    public int compareTo(RepositoryElement element) {
        return ideName.compareTo(element.ideName);
    }
}
