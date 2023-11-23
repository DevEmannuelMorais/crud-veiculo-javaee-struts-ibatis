package br.com.detran.action.veiculo;

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

import br.com.detran.action.proprietario.ListarProprietarioAction;
import br.com.detran.dao.ProprietarioDAO;
import br.com.detran.dao.Relatorio;
import br.com.detran.dao.VeiculoDAO;
import br.com.detran.model.Proprietario;
import br.com.detran.model.Veiculo;
import br.com.detran.model.form.VeiculoForm;

public class GerarRelatorioVeiculoAction extends Action{
	
	private Map<String, Object> param = new HashMap();
	private Relatorio relatorio = new Relatorio();
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		ListarVeiculoAction listarVeiculoAction = new ListarVeiculoAction();
		VeiculoForm veiculoForm = (VeiculoForm) form;
//		veiculoForm.setPlaca(null);
		String action = request.getParameter("action");
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão deste relatório? ","Atenção", JOptionPane.YES_NO_OPTION);
 		if(confirma == JOptionPane.YES_OPTION) {
				switch (action) {
				case "selectAll":
					param.put("nome", "");
					String relPath = "/home/emannuel/Documentos/relatorios/reportVeiculo1.jrxml";
					relatorio.gerarRelatorioVeiculo(relPath, param, response);
					break;
				case "relVeiculoPlaca":
					if(veiculoForm.getPlaca() != null) {
						param.put("PLACA", veiculoForm.getPlaca());
						String jrxmlPlaca = "/home/emannuel/Documentos/relatorios/relVeiculoPlaca.jrxml";
						relatorio.gerarRelatorioVeiculo(jrxmlPlaca, param, response);
						break;
					}else {
						request.setAttribute("ERROR", "A placa que você solicitou o relatório é inválida - " + veiculoForm.getPlaca());
						break;
					}
				default:
					System.out.println("Nada enviado como parametro");
					break;
				}
		}
//			listarVeiculoAction.execute(mapping, veiculoForm, request, response);
			
		List<Veiculo> veiculos = veiculoDAO.listarProprietario();
	    request.setAttribute("veiculos", veiculos);
		
		return mapping.findForward("listarVeiculos");
	}

}
