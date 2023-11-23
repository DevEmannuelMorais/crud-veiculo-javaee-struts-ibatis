package br.com.detran.model;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;



public class TesteIbatis {

	public static void main(String[] args) throws IOException, SQLException {
		
		Reader reader = Resources.getResourceAsReader("ibatis-config.xml");
		SqlMapClient sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
		Proprietario novoProprietario = new Proprietario();
//        novoProprietario.setNome("Pedro");
//        novoProprietario.setCpfCnpj("08472930335");
//        novoProprietario.setEndereco("Rua Gustavo Sampaio");
//        sqlMapClient.insert("Proprietario.insert", novoProprietario);
//        
//        sqlMapClient.endTransaction();
		
        
        List<Proprietario> proprietarios = sqlMapClient.queryForList("Proprietario.selectAll");
        for (Proprietario prop : proprietarios) {
            System.out.println(prop.toString());
        }


	}

}
