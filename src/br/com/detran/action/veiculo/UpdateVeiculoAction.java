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

public class UpdateVeiculoAction extends Action{
	private SqlMapClient sqlMapClient;

	public UpdateVeiculoAction() throws IOException {
		super();

		Reader reader = Resources.getResourceAsReader("ibatis-config.xml");
		sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
	}
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		VeiculoForm veiculoForm = (VeiculoForm)form;
		Veiculo veiculo = new Veiculo();
		String param = request.getParameter("param");
		if(param == null) {
			
			veiculo.setPlaca(veiculoForm.getPlaca());
			veiculo.setRenavam(veiculoForm.getRenavam());
			veiculo.setId_prop(veiculoForm.getId_prop());
			veiculo.setId(veiculoForm.getId());
			veiculoDAO.update(veiculo);
			return mapping.findForward("update");
		} else {
			veiculo = veiculoDAO.findById(veiculoForm.getId());
			request.setAttribute("veiculo", veiculo);
			return mapping.findForward("getBy");
		}
		
		
		
		
		
	}
	
	
}
