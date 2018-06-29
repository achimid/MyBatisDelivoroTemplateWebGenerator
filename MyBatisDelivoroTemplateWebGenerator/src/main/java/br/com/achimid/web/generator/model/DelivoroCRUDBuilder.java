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
    private Collection<String> clazzTableColumns;
    private String clazzTableIdColumn;

    private boolean generateHeader;
    private boolean generateNamespace;
    private boolean generateAlias;
    private boolean generateResultMap;
    private boolean generateSqlWhere;
    private boolean generateInsert;
    private boolean generateUpdate;
    private boolean generateListaPorExemplo;
    private boolean generateListaTodos;
    private boolean generateContaPorExemplo;
    private boolean generateContaTodos;
    private boolean generatePegaPorId;
    private boolean generateApagaPorId;
    private boolean generateFooter;


    public DelivoroCRUDBuilder(){
        generateHeader = true;
        generateNamespace = true;
        generateAlias = true;
        generateResultMap = true;
        generateSqlWhere = true;
        generateInsert = true;
        generateUpdate = true;
        generateListaPorExemplo = true;
        generateListaTodos = true;
        generateContaPorExemplo = true;
        generateContaTodos = true;
        generatePegaPorId = true;
        generateApagaPorId = true;
        generateFooter = true;
    }

    public DelivoroCRUDBuilder(String clazzPackage, String clazzNameFull, String clazzAlias){
        this();
        this.clazzNameFull = clazzNameFull;
        this.clazzNamespace = "manut." + clazzNameFull;
        this.clazzName =    StringUtil.getInstance().qualificaClazzName(clazzNameFull);
        this.clazzPackage = StringUtil.getInstance().adicionaNoFinal(clazzPackage, ".");
        this.clazzTable =   StringUtil.getInstance().getClazzTableFromClazzNameFull(clazzNameFull);
        this.clazzAlias =   clazzAlias;
    }




    public String getHeader(){
        if(generateHeader)
            return tHeader.toString();

        return null;
    }

    public String getNamespace(){
        if(generateNamespace)
            return tNamespace.toString().replaceAll(rClazzNamespace, clazzNamespace);

        return null;
    }

    public String getAlias(){
        if(generateAlias)
            return tAlias.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzPackage, clazzPackage)
                    .replaceAll(rClazzNameFull, clazzNameFull);
        return null;
    }

    public String getResultMap(){
        if(generateResultMap)
            return tResultMap.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzName, clazzName);
        return null;
    }

    public String getSqlWhere(){
        if(generateSqlWhere)
            return tSqlWhere.toString();
        return null;
    }

    public String getInsert(){
        if(generateInsert)
            return tInsert.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }

    public String getUpdate(){
        if(generateUpdate)
            return tUpdate.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }

    public String getApagaPorId(){
        if(generateApagaPorId)
            return tApagaPorId.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }
    public String getPegaPorId(){
        if(generatePegaPorId)
            return tPegaPorId.toString()
                    .replaceAll(rClazzName, clazzName)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }
    public String getListaTodos(){
        if(generateListaTodos)
            return tListaTodos.toString()
                    .replaceAll(rClazzName, clazzName)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }
    public String getListaPorExemplo(){
        if(generateListaPorExemplo)
            return tListaPorExemplo.toString()
                    .replaceAll(rClazzName, clazzName)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }
    public String getContaTodos(){
        if(generateContaTodos)
            return tContaTodos.toString()
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }
    public String getContaPorExemplo(){
        if(generateContaPorExemplo)
            return tContaPorExemplo.toString()
                    .replaceAll(rClazzAlias, clazzAlias)
                    .replaceAll(rClazzNameFull, clazzNameFull)
                    .replaceAll(rClazzTable, clazzTable);
        return null;
    }

    public String getFooter(){
        if(generateFooter)
            return tFooter.toString();
        return null;
    }

    public String getTemplate() {
        StringBuilder builder = new StringBuilder();

        builder.append(generateHeader ? getHeader() : "");
        builder.append(generateNamespace ? getNamespace() : "");
        builder.append(generateAlias ? getAlias() : "");
        builder.append(generateResultMap ? getResultMap() : "");
        builder.append(generateSqlWhere ? getSqlWhere() : "");
        builder.append(generateInsert ? getInsert() : "");
        builder.append(generateUpdate ? getUpdate() : "");
        builder.append(generateApagaPorId ? getApagaPorId() : "");
        builder.append(generateListaPorExemplo ? getPegaPorId() : "");
        builder.append(generateListaTodos ? getListaTodos() : "");
        builder.append(generateListaPorExemplo ? getListaPorExemplo() : "");
        builder.append(generateContaTodos ? getContaTodos() : "");
        builder.append(generateContaPorExemplo ? getContaPorExemplo() : "");
        builder.append(generateFooter ? getFooter() : "");

        return builder.toString();
    }


    public boolean isGenerateHeader() {
        return generateHeader;
    }

    public void setGenerateHeader(boolean generateHeader) {
        this.generateHeader = generateHeader;
    }

    public boolean isGenerateNamespace() {
        return generateNamespace;
    }

    public void setGenerateNamespace(boolean generateNamespace) {
        this.generateNamespace = generateNamespace;
    }

    public boolean isGenerateAlias() {
        return generateAlias;
    }

    public void setGenerateAlias(boolean generateAlias) {
        this.generateAlias = generateAlias;
    }

    public boolean isGenerateResultMap() {
        return generateResultMap;
    }

    public void setGenerateResultMap(boolean generateResultMap) {
        this.generateResultMap = generateResultMap;
    }

    public boolean isGenerateSqlWhere() {
        return generateSqlWhere;
    }

    public void setGenerateSqlWhere(boolean generateSqlWhere) {
        this.generateSqlWhere = generateSqlWhere;
    }

    public boolean isGenerateInsert() {
        return generateInsert;
    }

    public void setGenerateInsert(boolean generateInsert) {
        this.generateInsert = generateInsert;
    }

    public boolean isGenerateUpdate() {
        return generateUpdate;
    }

    public void setGenerateUpdate(boolean generateUpdate) {
        this.generateUpdate = generateUpdate;
    }

    public boolean isGenerateListaPorExemplo() {
        return generateListaPorExemplo;
    }

    public void setGenerateListaPorExemplo(boolean generateListaPorExemplo) {
        this.generateListaPorExemplo = generateListaPorExemplo;
    }

    public boolean isGenerateListaTodos() {
        return generateListaTodos;
    }

    public void setGenerateListaTodos(boolean generateListaTodos) {
        this.generateListaTodos = generateListaTodos;
    }

    public boolean isGenerateContaPorExemplo() {
        return generateContaPorExemplo;
    }

    public void setGenerateContaPorExemplo(boolean generateContaPorExemplo) {
        this.generateContaPorExemplo = generateContaPorExemplo;
    }

    public boolean isGenerateContaTodos() {
        return generateContaTodos;
    }

    public void setGenerateContaTodos(boolean generateContaTodos) {
        this.generateContaTodos = generateContaTodos;
    }

    public boolean isGeneratePegaPorId() {
        return generatePegaPorId;
    }

    public void setGeneratePegaPorId(boolean generatePegaPorId) {
        this.generatePegaPorId = generatePegaPorId;
    }

    public boolean isGenerateApagaPorId() {
        return generateApagaPorId;
    }

    public void setGenerateApagaPorId(boolean generateApagaPorId) {
        this.generateApagaPorId = generateApagaPorId;
    }

    public boolean isGenerateFooter() {
        return generateFooter;
    }

    public void setGenerateFooter(boolean generateFooter) {
        this.generateFooter = generateFooter;
    }
}