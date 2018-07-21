package br.com.achimid.web.generator.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
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

}
