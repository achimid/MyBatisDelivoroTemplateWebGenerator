package br.com.achimid.web.generator.util;

import br.com.achimid.web.generator.model.DelivoroCRUDConfig;

public interface BuilderInterface {

    String getTemplate();

    void setConfig(DelivoroCRUDConfig config);

}
