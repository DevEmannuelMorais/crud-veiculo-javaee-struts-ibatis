package br.com.detran.action.proprietario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.detran.dao.ProprietarioDAO;
import br.com.detran.dao.Relatorio;
import br.com.detran.model.Proprietario;



public class GerarRelatorioProprietarioAction extends Action {
	private Map<String, Object> param = new HashMap();
	private Relatorio relatorio = new Relatorio();
//	Connection con = null;
	
	public GerarRelatorioProprietarioAction() {
		super();
	}



	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		String action = request.getParameter("action");
	
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão deste relatório? ","Atenção", JOptionPane.YES_NO_OPTION);
		if(confirma == JOptionPane.YES_OPTION) {
			switch (action) {
			case "selectAll":
				param.put("nome", "");
				String relPath = "/home/emannuel/Documentos/relatorios/report1.jrxml";
				relatorio.gerarRelatorio(relPath, param, response);
				break;

			default:
				System.out.println("Nada enviado como parametro");
				break;
			}
		
		}else {
			List<Proprietario> proprietarios = proprietarioDAO.listarProprietario();
			request.setAttribute("proprietarios", proprietarios);
		}
		return mapping.findForward("sucess");
		
	}

		
}
