package br.com.achimid.web.generator.service;

import br.com.achimid.web.generator.model.BuilderType;
import br.com.achimid.web.generator.util.BuilderFactory;
import br.com.achimid.web.generator.util.BuilderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {

    @Autowired
    private BuilderFactory builderFactory;

    public String gerarTemplate(){
        BuilderInterface builder = builderFactory.getBuilderDelivoroCRUD("br.com.achimid.", "ItemPedido", "itemPedido");
        return builder.getTemplate();
    }

}
