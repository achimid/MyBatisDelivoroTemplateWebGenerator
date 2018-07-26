package br.com.achimid.web.generator.model;

import br.com.achimid.web.generator.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class DelivoroCRUDTemplate {

    protected static final String rClazzAlias = "#clazzAlias#";
    protected static final String rClazzPackage = "#clazzPackage#";
    protected static final String rClazzName = "#clazzName#";
    protected static final String rClazzNameFull = "#clazzNameFull#";
    protected static final String rClazzNamespace = "#clazzNamespace#";
    protected static final String rClazzTable = "#clazzTable#";

    protected static final String lResultMapProperties = "#resultMapProperties#";
    protected static final String lSqlWhereProperties = "#sqlWhereProperties#";

    private final String QUEBRA_LINHA = "\n";
    private final String TABULACAO = "\t";
    private final String TABULACAO_TAB = "\t\t\t";

    protected StringBuilder tHeader =
        new StringBuilder()
            .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(QUEBRA_LINHA)
            .append("<!DOCTYPE sqlMap PUBLIC \"-//iBATIS.com//DTD SQL MAP 2.0//EN\"").append(QUEBRA_LINHA)
            .append("\"http://www.ibatis.com/dtd/sql-map-2.dtd\">").append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);

    protected StringBuilder tNamespace =
        new StringBuilder()
            .append(TABULACAO)
                .append("<sqlMap namespace=\"")
                .append(rClazzNamespace)
                .append("\">")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);

    protected StringBuilder tAlias =
        new StringBuilder()
            .append(TABULACAO)
                .append("<typeAlias alias=\"")
                .append(rClazzAlias)
                .append("\" type=\"")
                .append(rClazzPackage)
                .append(rClazzNameFull)
                .append("\"/>")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);


    protected StringBuilder tResultMap =
        new StringBuilder()
            .append(TABULACAO)
                .append("<resultMap id=\"")
                .append(rClazzName)
                .append("Result\" class=\"")
                .append(rClazzAlias)
                .append("\">")
                .append(QUEBRA_LINHA)
            .append(lResultMapProperties)
            .append(TABULACAO)
                .append("</resultMap>")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);

    protected StringBuilder getResultMapProperty(DelivoroCRUDConfig config){
        StringBuilder sn = new StringBuilder();
        if(!config.getFields().isEmpty()){
            for(Map<String, String> m : config.getFields())
            sn.append(TABULACAO_TAB)
                .append(TABULACAO)
                    .append("<result property=\"")
                    .append(m.keySet().iterator().next())
                    .append("\"")
                    .append(TABULACAO_TAB)
                            .append("column=\"")
                            .append(StringUtil.getInstance().toCamelCase(m.keySet().iterator().next()))
                            .append("\"/>")
                    .append(QUEBRA_LINHA);
        }
        return sn;
    }

    protected StringBuilder tSqlWhere =
        new StringBuilder()
            .append(TABULACAO)
                .append("<sql id=\"sqlWhere\">")
                .append(QUEBRA_LINHA)
            .append(lSqlWhereProperties)
            .append(TABULACAO)
                .append("</sql>")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);


    protected StringBuilder getSqlWhereProperty(DelivoroCRUDConfig config) {
        StringBuilder sn = new StringBuilder();

        this.addExampleIfEmptyFiels(config, sn);

        sn.append(TABULACAO)
            .append(TABULACAO)
                .append("<dynamic prepend=\"WHERE\">")
                .append(QUEBRA_LINHA);

        for(Map<String, String> m : config.getFields())
            sn.append(TABULACAO)
                .append(TABULACAO)
                    .append(TABULACAO)
                        .append("<isNotEmpty property=\"")
                        .append(m.keySet().iterator().next())
                        .append("\" prepend=\"AND\">")
                        .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append(TABULACAO)
                        .append(TABULACAO)
                            .append(StringUtil.getInstance().toCamelCase(m.keySet().iterator().next()))
                            .append("=#")
                            .append(m.keySet().iterator().next())
                            .append("#")
                            .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append(TABULACAO)
                        .append("</isNotEmpty>")
                        .append(QUEBRA_LINHA);

        sn.append(TABULACAO)
            .append(TABULACAO)
                .append("</dynamic>")
                .append(QUEBRA_LINHA);

        return sn;
    }


    protected StringBuilder tInsert =
        new StringBuilder()
            .append(TABULACAO)
                .append("<insert id=\"insere")
                .append(rClazzNameFull)
                .append("\" parameterClass=\"")
                .append(rClazzAlias)
                .append("\" >")
                .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("<selectKey keyProperty=\"idExemplo\" type=\"post\" resultClass=\"int\">")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append(TABULACAO)
                        .append("SELECT last_insert_id() AS idExemplo")
                        .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("</selectKey>")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("INSERT INTO ")
                    .append(rClazzTable)
                    .append(" (")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO_TAB)
                .append("id_exemplo")
                .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append(") VALUES (")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO_TAB)
                .append("#idExemplo#")
                .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append(")")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append("</insert>")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);


    protected StringBuilder tUpdate =
        new StringBuilder()
            .append(TABULACAO)
                .append("<update id=\"atualiza")
                .append(rClazzNameFull)
                .append("\" parameterClass=\"")
                .append(rClazzAlias)
                .append("\">")
                .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("UPDATE ")
                    .append(rClazzTable)
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("SET")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO_TAB)
                    .append("exemplo_id_exemplo=#idExemplo#")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("WHERE id_exemplo = #idExemplo#")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append("</update>")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);


    protected StringBuilder tListaPorExemplo =
        new StringBuilder()
            .append(TABULACAO)
                .append("<select id=\"lista")
                .append(rClazzNameFull)
                .append("sPorExemplo\" resultMap=\"")
                .append(rClazzName)
                .append("Result\">")
                .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("SELECT *")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("FROM ")
                    .append(rClazzTable)
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("<include refid=\"sqlWhere\"/>")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append("</select>")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);


    protected StringBuilder tPegaPorId =
        new StringBuilder()
            .append(TABULACAO)
                .append("<select id=\"pega")
                .append(rClazzNameFull)
                .append("\" resultMap=\"")
                .append(rClazzName)
                .append("Result\">")
                .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("SELECT *")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("FROM ")
                    .append(rClazzTable)
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("WHERE id_exemplo = #idExemplo#")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append("</select>")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);

    protected StringBuilder tApagaPorId =
        new StringBuilder()
            .append(TABULACAO)
                .append("<delete id=\"apaga")
                .append(rClazzNameFull)
                .append("\" parameterClass=\"")
                .append(rClazzAlias)
                .append("\">")
                .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("DELETE")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("FROM ")
                    .append(rClazzTable)
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("WHERE id_exemplo = #idExemplo#")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append("</delete>")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);

    protected StringBuilder tContaTodos =
        new StringBuilder()
            .append(TABULACAO)
                .append("<select id=\"conta")
                .append(rClazzNameFull)
                .append("s\" resultClass=\"java.lang.Integer\">")
                .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("SELECT COUNT(*) FROM ")
                    .append(rClazzTable)
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append("</select>")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);

    protected StringBuilder tContaPorExemplo =
        new StringBuilder()
            .append(TABULACAO)
                .append("<select id=\"conta")
                .append(rClazzNameFull)
                .append("sPorExemplo\" resultClass=\"java.lang.Integer\" parameterClass=\"")
                .append(rClazzAlias)
                .append("\">")
                .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("SELECT COUNT(*) FROM ")
                    .append(rClazzTable)
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("<include refid=\"sqlWhere\"/>")
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append("</select>")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);


    protected StringBuilder tListaTodos =
        new StringBuilder()
            .append(TABULACAO)
                .append("<select id=\"lista")
                .append(rClazzNameFull)
                .append("s\" resultMap=\"")
                .append(rClazzName)
                .append("Result\">")
                .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append(TABULACAO)
                    .append("SELECT * FROM ")
                    .append(rClazzTable)
                    .append(QUEBRA_LINHA)
            .append(TABULACAO)
                .append("</select>")
                .append(QUEBRA_LINHA)
            .append(QUEBRA_LINHA);

    protected StringBuilder tFooter = new StringBuilder("</sqlMap>");



    private void addExampleIfEmptyFiels(DelivoroCRUDConfig config, StringBuilder sn){
        if (config.getFields().isEmpty()) {
            Map<String, String> example = new HashMap<>();
            example.put("idExemplo", "String");
            config.getFields().add(example);
        }
    }


}
