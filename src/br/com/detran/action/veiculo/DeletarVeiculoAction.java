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
import br.com.detran.model.form.VeiculoForm;

public class DeletarVeiculoAction extends Action{

	public DeletarVeiculoAction() throws IOException {
		super();

	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		VeiculoForm veiculoForm = (VeiculoForm)form;
		veiculoDAO.delete(veiculoForm.getId());
		
		
		return mapping.findForward("delete");
	}
	
	

}
