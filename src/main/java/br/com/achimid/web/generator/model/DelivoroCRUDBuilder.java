package br.com.achimid.web.generator.model;

import br.com.achimid.web.generator.util.BuilderInterface;
import br.com.achimid.web.generator.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class DelivoroCRUDBuilder extends DelivoroCRUDTemplate implements BuilderInterface{

    private String clazzNameFull;
    private String clazzPackage;
    private String clazzName;
    private String clazzAlias;
    private String clazzNamespace;
    private String clazzTable;

    private DelivoroCRUDConfig config;

    public DelivoroCRUDBuilder(){
        config = new DelivoroCRUDConfig();
    }

    public DelivoroCRUDBuilder(String clazzPackage, String clazzNameFull, String clazzAlias){
        this();

        if(clazzPackage == null     || clazzPackage.isEmpty())  clazzPackage     = "br.com.model.template";
        if(clazzNameFull == null    || clazzNameFull.isEmpty()) clazzNameFull    = "OrderItem.java";
        if(clazzAlias == null       || clazzAlias.isEmpty())    clazzAlias       = "order";

        clazzNameFull = StringUtil.getInstance().removeJavaExtension(clazzNameFull);
        this.clazzNameFull = clazzNameFull;
        this.clazzNamespace = "manut." + clazzNameFull;
        this.clazzName =    StringUtil.getInstance().qualificaClazzName(clazzNameFull);
        this.clazzPackage = StringUtil.getInstance().adicionaNoFinal(clazzPackage, ".");
        this.clazzTable =   StringUtil.getInstance().getClazzTableFromClazzNameFull(clazzNameFull);
        this.clazzAlias =   clazzAlias;
    }


    public String getHeader(){
        if(config.isGenerateHeader())
            return tHeader.toString();

        return null;
    }

    public String getNamespace(){
        if(config.isGenerateNamespace())
            return tNamespace.toString().replaceAll(rClazzNamespace, clazzNamespace);

        return null;
    }

    public String getAlias(){
        if(config.isGenerateAlias())
            return tAlias.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzPackage, clazzPackage)
                    .replaceAll(rClazzNameFull, clazzNameFull);
        return null;
    }

    public String getResultMap(){
        if(config.isGenerateResultMap())
            return tResultMap.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzName, clazzName)
                    .replaceAll(lResultMapProperties, getResultMapProperty(config).toString());
        return null;
    }

    public String getSqlWhere(){
        if(config.isGenerateSqlWhere())
            return tSqlWhere.toString()
                    .replaceAll(lSqlWhereProperties, getSqlWhereProperty(config).toString());;
        return null;
    }

    public String getInsert(){
        if(config.isGenerateInsert())
            return tInsert.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }

    public String getUpdate(){
        if(config.isGenerateUpdate())
            return tUpdate.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }

    public String getApagaPorId(){
        if(config.isGenerateApagaPorId())
            return tApagaPorId.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }
    public String getPegaPorId(){
        if(config.isGeneratePegaPorId())
            return tPegaPorId.toString()
                    .replaceAll(rClazzName, clazzName)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }
    public String getListaTodos(){
        if(config.isGenerateListaTodos())
            return tListaTodos.toString()
                    .replaceAll(rClazzName, clazzName)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }
    public String getListaPorExemplo(){
        if(config.isGenerateListaPorExemplo())
            return tListaPorExemplo.toString()
                    .replaceAll(rClazzName, clazzName)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }
    public String getContaTodos(){
        if(config.isGenerateContaTodos())
            return tContaTodos.toString()
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }
    public String getContaPorExemplo(){
        if(config.isGenerateContaPorExemplo())
            return tContaPorExemplo.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }

    public String getFooter(){
        if(config.isGenerateFooter())
            return tFooter.toString();
        return null;
    }

    public String getTemplate() {
        StringBuilder builder = new StringBuilder();

        builder.append(config.isGenerateHeader() ? getHeader() : "");
        builder.append(config.isGenerateNamespace() ? getNamespace() : "");
        builder.append(config.isGenerateAlias() ? getAlias() : "");
        builder.append(config.isGenerateResultMap() ? getResultMap() : "");
        builder.append(config.isGenerateSqlWhere() ? getSqlWhere() : "");
        builder.append(config.isGenerateInsert() ? getInsert() : "");
        builder.append(config.isGenerateUpdate() ? getUpdate() : "");
        builder.append(config.isGenerateApagaPorId() ? getApagaPorId() : "");
        builder.append(config.isGenerateListaPorExemplo() ? getPegaPorId() : "");
        builder.append(config.isGenerateListaTodos() ? getListaTodos() : "");
        builder.append(config.isGenerateListaPorExemplo() ? getListaPorExemplo() : "");
        builder.append(config.isGenerateContaTodos() ? getContaTodos() : "");
        builder.append(config.isGenerateContaPorExemplo() ? getContaPorExemplo() : "");
        builder.append(config.isGenerateFooter() ? getFooter() : "");

        return builder.toString();
    }

    public DelivoroCRUDConfig getConfig() {
        return config;
    }

    public void setConfig(DelivoroCRUDConfig config) {
        this.config = config;
    }

}