package br.com.detran.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import br.com.detran.exception.Validator;
import br.com.detran.exception.ValidatorException;
import br.com.detran.model.Veiculo;
import br.com.detran.model.VeiculoProprietario;

public class VeiculoDAO {
private  SqlMapClient sqlMapClient = null;
	

	public VeiculoDAO() throws IOException {
		this.sqlMapClient = DAO.conectar();

		
	}
public String addVeiculo(Veiculo veiculo) {
		String status = "";
		try {
			Validator.validateNotNull(veiculo.getRenavam(), "Renavam");
			Validator.validatePlaca(veiculo.getPlaca());
			sqlMapClient.insert("Veiculo.insert", veiculo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ValidatorException e) {
			System.err.println("Erro de validação: " + e.getMessage());
			status = "Erro de validação: " + e.getMessage();
		}
		return status;
		
	}
	public List<Veiculo> listarProprietario() {
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		
		try {
			veiculos = sqlMapClient.queryForList("Veiculo.selectAll");
			Collections.sort(veiculos, new Comparator<Veiculo>() {
				@Override
				public int compare(Veiculo p1, Veiculo p2) {
					return Integer.compare(p1.getId(), p2.getId());
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return veiculos;
		
	}
	public void update(Veiculo veiculo) {
		String status = "";
		try {
			
			Validator.validateNotNull(veiculo.getRenavam(), "Renavam");
			Validator.validatePlaca(veiculo.getPlaca());
			sqlMapClient.update("Veiculo.update", veiculo);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("parametro invalido");
		} catch (ValidatorException e) {
			System.err.println("Erro de validação: " + e.getMessage());
			status = "Erro de validação: " + e.getMessage();
		}
		
	}
	public void delete(Integer id) {
		try {
			sqlMapClient.delete("Veiculo.delete", id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("id invalido");
		}
		
	}
	public Veiculo findById(Integer id) {
		Veiculo veiculo = null;
		try {
			 veiculo = (Veiculo)sqlMapClient.queryForObject("Veiculo.findById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return veiculo;
	}
	
	
	public boolean validationPlaca(String placa) {
			Veiculo veiculo = null;
			boolean isPresent = false;
		try {
			veiculo = (Veiculo)sqlMapClient.queryForObject("Veiculo.findByVeiculoPlaca",placa);
			if(veiculo != null) {
				isPresent = true;
			}
			
		} catch (SQLException e) {
			System.out.println("Veiculo não existe " + e.getMessage());
		}
		return isPresent;
		
		
	}
	public List<Veiculo> searchByPlaca (String placa) {
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		try {
				veiculos = (List<Veiculo>)sqlMapClient.queryForList("Veiculo.findByPlaca", placa);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return veiculos;
	}
	public List<Veiculo> searchByPropId (Integer id_prop) {
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		try {
				veiculos = (List<Veiculo>)sqlMapClient.queryForList("Veiculo.findByPropId", id_prop);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return veiculos;
	}
	public List<VeiculoProprietario> searchPropPlaca(String placa) {
		List<VeiculoProprietario> veiculos = new ArrayList<VeiculoProprietario>();
		try {
				veiculos = (List<VeiculoProprietario>)sqlMapClient.queryForList("Veiculo.findPropPlaca", placa);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return veiculos;
	}

}
