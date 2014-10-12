package structure;

import java.util.Arrays;

/**
 * Created by Claudiu on 10/11/2014
 */
public enum Modifier {
    PRIVATE("private"), PROTECTED("protected"), PUBLIC("public"), STATIC("static"), ABSTRACT("abstract"), FINAL("final"), SYNCHRONIZED("synchronized");

    public final String text;
    private Modifier(String text) {
        this.text = text;
    }

    public static Modifier fromString(String mod) {
        return Arrays.asList(values()).stream().filter(s -> s.text.equals(mod)).findFirst().get();
    }
}
