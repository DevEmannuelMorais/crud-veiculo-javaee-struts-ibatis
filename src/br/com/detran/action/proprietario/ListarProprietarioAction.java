package br.com.detran.action.proprietario;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.detran.dao.ProprietarioDAO;
import br.com.detran.model.Proprietario;
import br.com.detran.model.form.ProprietarioForm;

public class ListarProprietarioAction extends Action {

	
	public ListarProprietarioAction() {
		super();

	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String param = request.getParameter("param");
		ProprietarioForm proprietarioForm = (ProprietarioForm)form;
		ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		
		if(param == null) { 
			List<Proprietario> proprietarios = proprietarioDAO.listarProprietario();
	        request.setAttribute("proprietarios", proprietarios);
	        return mapping.findForward("listarProprietarios");
		}else {
			List<Proprietario> proprietarios = proprietarioDAO.searchByNomeOrId(proprietarioForm.getNome());
			if(proprietarios != null) {
				request.setAttribute("proprietarios", proprietarios);
				return mapping.findForward("listarProprietarios");
			}
			return mapping.findForward("failure");
			
			
		}
		
		
	}

}
