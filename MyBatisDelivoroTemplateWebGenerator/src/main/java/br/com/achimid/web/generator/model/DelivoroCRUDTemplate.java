package br.com.achimid.web.generator.model;

public class DelivoroCRUDTemplate {


    protected static final String rClazzAlias = "#clazzAlias#";
    protected static final String rClazzPackage = "#clazzPackage#";
    protected static final String rClazzName = "#clazzName#";
    protected static final String rClazzNameFull = "#clazzNameFull#";
    protected static final String rClazzNamespace = "#clazzNamespace#";
    protected static final String rClazzTable = "#clazzTable#";

    protected StringBuilder tHeader = new StringBuilder(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<!DOCTYPE sqlMap PUBLIC \"-//iBATIS.com//DTD SQL MAP 2.0//EN\"\n" +
                    "  \"http://www.ibatis.com/dtd/sql-map-2.dtd\">\n"
    );

    protected StringBuilder tNamespace = new StringBuilder(
            "  <sqlMap namespace=\"" + rClazzNamespace + "\">\n" + "\n"
    );

    protected StringBuilder tAlias = new StringBuilder(
            "  <typeAlias alias=\"" + rClazzAlias + "\" type=\"" + rClazzPackage + rClazzNameFull + "\"/>\n" + "\n"
    );

    protected StringBuilder tResultMap = new StringBuilder(
            "  <resultMap id=\"" + rClazzName + "Result\" class=\"" + rClazzAlias + "\">\n" +
                    "   \t\t<result property=\"idPainelSenhasMonitor\"   \tcolumn=\"id_painel_senhas_monitor\"/>\n" +
                    "    \t<result property=\"idLoja\"   \t\t\t\tcolumn=\"loja_id_loja\"/>\n" +
                    "    \t<result property=\"idMonitorCozinha\"   \t\tcolumn=\"monitor_cozinha_id_monitor_cozinha\"/>\n" +
                    "    \t<result property=\"idPedido\"   \t\t\t\tcolumn=\"pedido_id_pedido\"/>\n" +
                    "    \t<result property=\"pedidoSenha\"   \t\t\tcolumn=\"pedido_senha\"/>\n" +
                    "    \t<result property=\"monitorNome\"   \t\t\tcolumn=\"monitor_nome\"/>\n" +
                    "    \t<result property=\"dataRegistro\"   \t\t\tcolumn=\"data_registro\"/>\n" +
                    "  </resultMap>\n" +
                    "\n"
    );

    protected StringBuilder tSqlWhere = new StringBuilder(
            "  <sql id=\"sqlWhere\">\n" +
                    "    <dynamic prepend=\"WHERE\">\n" +
                    "      <isNotEmpty property=\"idPainelSenhasMonitor\" prepend=\"AND\">\n" +
                    "        id_painel_senhas_monitor = #idPainelSenhasMonitor#\n" +
                    "      </isNotEmpty>\n" +
                    "      <isNotEmpty property=\"idLoja\" prepend=\"AND\">\n" +
                    "        loja_id_loja = #idLoja#\n" +
                    "      </isNotEmpty>\n" +
                    "      <isNotEmpty property=\"idPedido\" prepend=\"AND\">\n" +
                    "        pedido_id_pedido = #idPedido#\n" +
                    "      </isNotEmpty>\n" +
                    "      <isNotEmpty property=\"pedidoSenha\" prepend=\"AND\">\n" +
                    "        pedido_senha = #pedidoSenha#\n" +
                    "      </isNotEmpty>\n" +
                    "      <isNotEmpty property=\"monitorNome\" prepend=\"AND\">\n" +
                    "        monitor_nome = #monitorNome#\n" +
                    "      </isNotEmpty>\n" +
                    "      <isNotEmpty property=\"dataRegistro\" prepend=\"AND\">\n" +
                    "        data_registro = #dataRegistro#\n" +
                    "      </isNotEmpty>\n" +
                    "    </dynamic>\n" +
                    "  </sql>\n" +
                    "\n"
    );

    protected StringBuilder tInsert = new StringBuilder(
            "  <insert id=\"insere" + rClazzNameFull + "\" parameterClass=\"" + rClazzAlias + "\" >\n" +
                    "    <selectKey keyProperty=\"idPainelSenhasMonitor\" type=\"post\" resultClass=\"int\">\n" +
                    "      SELECT last_insert_id() AS idPainelSenhasMonitor\n" +
                    "    </selectKey>\n" +
                    "    INSERT INTO " + rClazzTable + " (\n" +
                    "\t\tloja_id_loja,\n" +
                    "\t\tmonitor_cozinha_id_monitor_cozinha,\n" +
                    "\t\tpedido_id_pedido,\n" +
                    "\t\tpedido_senha,\n" +
                    "\t\tmonitor_nome,\n" +
                    "\t\tdata_registro\n" +
                    "    ) VALUES (\n" +
                    "\t\t#idLoja#,\n" +
                    "\t\t#idMonitorCozinha#,\n" +
                    "\t\t#idPedido#,\n" +
                    "\t\t#pedidoSenha#,\n" +
                    "\t\t#monitorNome#,\n" +
                    "\t\t#dataRegistro#\n" +
                    "    )\n" +
                    "  </insert>\n" +
                    "\n"
    );

    protected StringBuilder tUpdate = new StringBuilder(
            "  <update id=\"atualiza" + rClazzNameFull + "\" parameterClass=\"" + rClazzAlias + "\">\n" +
                    "    UPDATE " + rClazzTable + "\n" +
                    "    SET\n" +
                    "\t\tloja_id_loja=##,\n" +
                    "\t\tmonitor_cozinha_id_monitor_cozinha=#idMonitorCozinha#,\n" +
                    "\t\tpedido_id_pedido=#idPedido#,\n" +
                    "\t\tpedido_senha=#pedidoSenha#,\n" +
                    "\t\tmonitor_nome=#monitorNome#,\n" +
                    "\t\tdata_registro=#dataRegistro#\n" +
                    "    WHERE id_painel_senhas_monitor = #idPainelSenhasMonitor#\n" +
                    "  </update>\n" +
                    "\n"
    );

    protected StringBuilder tListaPorExemplo = new StringBuilder(
            "  <select id=\"lista" + rClazzNameFull + "sPorExemplo\" resultMap=\"" + rClazzName + "Result\">\n" +
                    "    SELECT *\n" +
                    "    FROM " + rClazzTable + "\n" +
                    "    <include refid=\"sqlWhere\"/>\n" +
                    "  </select>\n" +
                    "\n"
    );

    protected StringBuilder tPegaPorId = new StringBuilder(
            "  <select id=\"pega" + rClazzNameFull + "\" resultMap=\"" + rClazzName + "Result\">\n" +
                    "\tSELECT *\n" +
                    "\tFROM " + rClazzTable + "\n" +
                    "\tWHERE id_painel_senhas_monitor = #idPainelSenhasMonitor#\n" +
                    "  </select>\n" +
                    "\n"
    );

    protected StringBuilder tApagaPorId = new StringBuilder(
            "  <delete id=\"apaga" + rClazzNameFull + "\" parameterClass=\"" + rClazzAlias + "\">\n" +
                    "    DELETE\n" +
                    "    FROM " + rClazzTable + "\n" +
                    "    WHERE id_painel_senhas_monitor = #idPainelSenhasMonitor#\n" +
                    "  </delete>\n" +
                    "\n"
    );

    protected StringBuilder tContaTodos = new StringBuilder(
            "  <select id=\"conta" + rClazzNameFull + "s\" resultClass=\"java.lang.Integer\">\n" +
                    "    SELECT COUNT(*) FROM " + rClazzTable + "\n" +
                    "  </select>\n" +
                    "\n"
    );

    protected StringBuilder tContaPorExemplo = new StringBuilder(
            "  <select id=\"conta" + rClazzNameFull + "sPorExemplo\" resultClass=\"java.lang.Integer\" parameterClass=\"" + rClazzAlias + "\">\n" +
                    "    SELECT COUNT(*) FROM " + rClazzTable + "\n" +
                    "    <include refid=\"sqlWhere\"/>\n" +
                    "  </select>\n" +
                    "\n"
    );

    protected StringBuilder tListaTodos = new StringBuilder(
            "  <select id=\"lista" + rClazzNameFull + "s\" resultMap=\"" + rClazzName + "Result\">\n" +
                    "    SELECT * FROM " + rClazzTable + "\n" +
                    "  </select>\n" +
                    "\n"
    );

    protected StringBuilder tFooter = new StringBuilder("</sqlMap>");



}
