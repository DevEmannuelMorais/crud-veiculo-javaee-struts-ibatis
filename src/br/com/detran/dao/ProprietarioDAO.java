package br.com.detran.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import br.com.detran.exception.Validator;
import br.com.detran.exception.ValidatorException;
import br.com.detran.model.Proprietario;

public class ProprietarioDAO {
	private  SqlMapClient sqlMapClient = null;
	

	public ProprietarioDAO() throws IOException {
		this.sqlMapClient = DAO.conectar();

		
	}
	public String addProprietario(Proprietario proprietario) {
		String status = "";
		try {
			
			proprietario.setCpf_cnpj(proprietario.getCpf_cnpj());
			
			Validator.validateNotNull(proprietario.getNome(), "Nome");
			Validator.validarCPF(proprietario.getCpf_cnpj());
			sqlMapClient.insert("Proprietario.insert", proprietario);
			status = "Proprietario Criado com sucesso";
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ValidatorException e) {
			System.err.println("Erro de validação: " + e.getMessage());
			status = "Erro de validação: " + e.getMessage();
		}
		return status;
		
	}
	@SuppressWarnings("unchecked")
	public List<Proprietario> listarProprietario() {

		List<Proprietario> proprietario = new ArrayList<Proprietario>();
		
		try {
			proprietario = sqlMapClient.queryForList("Proprietario.selectAll");
//			Collections.sort(proprietario, new Comparator<Proprietario>() {
//				@Override
//				public int compare(Proprietario p1, Proprietario p2) {
//					return Integer.compare(p1.getId(), p2.getId());
//				}
//			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return proprietario;
		
	}
	public void update(Proprietario proprietario) {
		
		try {
			sqlMapClient.update("Proprietario.update", proprietario);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("parametro invalido");
		}
		
	}
	public void delete(Integer id) {
		try {
			sqlMapClient.delete("Proprietario.delete", id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("id invalido");
		}
		
	}
	public Proprietario findById(Integer id) {
		Proprietario proprietario = null;
		try {
			 proprietario = (Proprietario)sqlMapClient.queryForObject("Proprietario.findById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proprietario;
	}
	public List<Proprietario> searchByNomeOrId(String nome) {
		List<Proprietario> proprietarios = null;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("nome", nome);
			params.put("cpf", nome);
			
			  proprietarios = sqlMapClient.queryForList("Proprietario.findByNomeOrCpf", params);
			 
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return proprietarios;
	}
	
	
	

}
