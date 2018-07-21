package br.com.achimid.web.generator.DTO;

import br.com.achimid.web.generator.model.DelivoroCRUDConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class DelivoroCRUDParams extends DelivoroCRUDConfig {

    private String clazzNameFull;
    private String clazzPackage;
    private String clazzAlias;
    private List<String> fields;

}
