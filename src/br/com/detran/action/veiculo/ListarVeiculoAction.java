package br.com.detran.action.veiculo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.detran.dao.ProprietarioDAO;
import br.com.detran.dao.VeiculoDAO;
import br.com.detran.model.Proprietario;
import br.com.detran.model.Veiculo;
import br.com.detran.model.VeiculoProprietario;
import br.com.detran.model.form.VeiculoForm;
import java_cup.production;

public class ListarVeiculoAction extends Action{
	private ProprietarioDAO prop = null;
	
	
	
	
	public ListarVeiculoAction() throws IOException {
		super();
		prop = new ProprietarioDAO();
	}




	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String forward = "";
		
		String param = request.getParameter("param");
		if(param == null) {
			param ="";
		}
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		VeiculoForm veiculoForm = (VeiculoForm)form;
		System.out.println(param);
		if(param.equalsIgnoreCase("")) {
			List<Veiculo> veiculos = veiculoDAO.listarProprietario();
	        request.setAttribute("veiculos", veiculos);
	        forward = "listarVeiculos";
	        }
		else if(param.equalsIgnoreCase("placa")) {
			List<Veiculo> veiculos = veiculoDAO.searchByPlaca(veiculoForm.getPlaca());
			if(veiculos != null) {
				request.setAttribute("veiculos", veiculos);
				forward = "listarVeiculos";
			}
	}if(param.equalsIgnoreCase("veiculos")== true){
		if(veiculoForm.getId_prop() != null && veiculoForm.getId_prop() != 0) {
			List<Veiculo> veiculos = veiculoDAO.searchByPropId(veiculoForm.getId_prop());
			request.setAttribute("veiculos", veiculos);
			forward = "veiculos";
		} else {
			String cpf = request.getParameter("cpf");
			List<Proprietario> proprietario = prop.searchByNomeOrId(cpf);
		
			List<Veiculo> veiculos = veiculoDAO.searchByPropId(proprietario.get(0).getId());
			request.setAttribute("veiculos", veiculos);
			forward = "veiculos";
		}
		
		
	}else if(param.equalsIgnoreCase("findPlaca")==true) {
		List<VeiculoProprietario> veiculoProprietarios = veiculoDAO.searchPropPlaca(veiculoForm.getPlaca());
		request.setAttribute("veiculoProp", veiculoProprietarios);
		forward = "veiculosProp";
		
	}
		return mapping.findForward(forward);
	
	}
		
	

}
