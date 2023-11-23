package br.com.detran.action.proprietario;

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

import br.com.detran.dao.ProprietarioDAO;
import br.com.detran.model.form.ProprietarioForm;

public class DeletarProprietarioAction extends Action{
//	private SqlMapClient sqlMapClient;

	public DeletarProprietarioAction() throws IOException {
		super();
//
//		Reader reader = Resources.getResourceAsReader("ibatis-config.xml");
//		sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		ProprietarioForm proprietarioForm = (ProprietarioForm)form;
		proprietarioDAO.delete(proprietarioForm.getId());
		
		
		return mapping.findForward("delete");
	}
	
	

}
