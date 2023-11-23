package br.com.detran.exception;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import br.com.detran.dao.DAO;
import br.com.detran.model.Proprietario;
import br.com.detran.model.Veiculo;

public class Validator {
	private static SqlMapClient sqlMapClient;
	
	public Validator() {
		super();
		
	}
	public static void validarCPF(String cpfCnpj) throws ValidatorException, SQLException {
		sqlMapClient = DAO.conectar();
		Proprietario proprietario = (Proprietario) sqlMapClient.queryForObject("Proprietario.selectCpf", cpfCnpj);
		if(proprietario.getCpf_cnpj() != null) {
			throw new ValidatorException("Dados já existentes");
		}
		sqlMapClient.endTransaction();
		if(cpfCnpj == null || cpfCnpj.length() < 11 || cpfCnpj.length() > 14) {
			throw new ValidatorException("CPF ou CNPJ invalido");
		}
		
	}
	public static void validateNotNull(Object value, String fieldName) throws ValidatorException {
		if (value == null) {
			throw new ValidatorException(fieldName + " não pode ser nulo");
		}
	}
	public static void validatePlaca(String placa) throws ValidatorException, SQLException, NullPointerException{
		try {
			sqlMapClient = DAO.conectar();
			Veiculo veiculo = (Veiculo) sqlMapClient.queryForObject("Veiculo.findByVeiculoPlaca", placa);
			if (veiculo.getPlaca() != null) {
				throw new ValidatorException("Placa já existente");
			}
			sqlMapClient.endTransaction();
			if(placa == null || placa.length() != 7 ) {
				throw new ValidatorException("Placa invalida");
			}
		} catch (NullPointerException e) {
			System.out.println("Tudo certo pode criar");
		}
		
	}
	

}
