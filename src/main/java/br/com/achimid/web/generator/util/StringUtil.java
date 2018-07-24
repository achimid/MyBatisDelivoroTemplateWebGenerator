package br.com.achimid.web.generator.util;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {
    private static StringUtil ourInstance = new StringUtil();

    public static StringUtil getInstance() {
        return ourInstance;
    }

    private StringUtil() {
    }

    public String qualificaClazzName(String clazzNameFull){
        StringBuilder strQualificado = new StringBuilder();
        for(String s : splitCamelCase(clazzNameFull)) strQualificado.append(strQualificado.length() == 0 ? s.toLowerCase() : s);
        return strQualificado.toString();
    }

    public String adicionaNoFinal(String str, String charFinal){
        if(!str.endsWith(charFinal)){
            str += charFinal;
        }
        return str;
    }

    private String[] splitCamelCase(String str){
        return str.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])");
    }

    public String getClazzTableFromClazzNameFull(String clazzNameFull){
        return toCamelCase(clazzNameFull);
    }

    public String toCamelCase(String str){
        StringBuilder output = new StringBuilder();
        for(String s : splitCamelCase(str)) output.append(output.length() == 0 ? s.toLowerCase() : "_".concat(s.toLowerCase()));
        return output.toString();
    }

    public String removeJavaExtension(String clazzFullName){
        if(clazzFullName.endsWith(".java")) return clazzFullName.replaceAll(".java", "");
        return clazzFullName;
    }
}
