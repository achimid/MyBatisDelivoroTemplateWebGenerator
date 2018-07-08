package br.com.achimid.web.generator.model;

public class DelivoroCRUDConfig {

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

    public DelivoroCRUDConfig(){
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
