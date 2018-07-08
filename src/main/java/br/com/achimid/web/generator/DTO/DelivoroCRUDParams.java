package br.com.achimid.web.generator.DTO;

import br.com.achimid.web.generator.model.DelivoroCRUDConfig;

public class DelivoroCRUDParams extends DelivoroCRUDConfig {

    private String clazzNameFull;
    private String clazzPackage;
    private String clazzAlias;

    public String getClazzNameFull() {
        return clazzNameFull;
    }

    public void setClazzNameFull(String clazzNameFull) {
        this.clazzNameFull = clazzNameFull;
    }

    public String getClazzPackage() {
        return clazzPackage;
    }

    public void setClazzPackage(String clazzPackage) {
        this.clazzPackage = clazzPackage;
    }

    public String getClazzAlias() {
        return clazzAlias;
    }

    public void setClazzAlias(String clazzAlias) {
        this.clazzAlias = clazzAlias;
    }
}
