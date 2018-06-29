package br.com.achimid.web.generator.util;

import br.com.achimid.web.generator.model.BuilderType;
import br.com.achimid.web.generator.model.DelivoroCRUDBuilder;
import org.springframework.stereotype.Component;

@Component
public class BuilderFactory {

    public BuilderInterface getBuilderDelivoroCRUD(String clazzPackage, String clazzNameFull, String clazzAlias){

        return new DelivoroCRUDBuilder(clazzPackage, clazzNameFull, clazzAlias);
        //throw new RuntimeException("Builder undefined");
    }


}
