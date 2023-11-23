package br.com.detran.action.veiculo;

import java.io.IOException;
import java.io.Reader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import br.com.detran.dao.VeiculoDAO;
import br.com.detran.model.Veiculo;
import br.com.detran.model.form.VeiculoForm;

public class CadastrarVeiculoAction extends Action{
	
	public CadastrarVeiculoAction() throws IOException {
		super();
		
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 VeiculoForm veiculoForm = (VeiculoForm) form;
	        
	        VeiculoDAO veiculoDAO = new VeiculoDAO();
	        Veiculo veiculo = new Veiculo();
	        
	        veiculo.setPlaca(veiculoForm.getPlaca());
	        veiculo.setRenavam(veiculoForm.getRenavam());
	        veiculo.setId_prop(veiculoForm.getId_prop());
	        
	       
	        
	        String status = veiculoDAO.addVeiculo(veiculo);
	        request.setAttribute("message", status);

	        return mapping.findForward("success");
	}
}
