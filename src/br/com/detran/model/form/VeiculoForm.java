package br.com.detran.model.form;

import org.apache.struts.action.ActionForm;

public class VeiculoForm extends ActionForm {
	private Integer id;
	private String placa;
	private String renavam;
	private Integer id_prop;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public Integer getId_prop() {
		return id_prop;
	}
	public void setId_prop(Integer id_prop) {
		this.id_prop = id_prop;
	}
	
	
	

}
