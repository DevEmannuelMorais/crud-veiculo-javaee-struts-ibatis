package br.com.detran.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class Relatorio {

	public void gerarRelatorio(String jrxml, Map<String, Object> param, HttpServletResponse response) throws SQLException {
		Connection connection = DAO.conectarJDBC();
		
		try {
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=\"relatorioProprietario.pdf\"");
			JasperPrint jasperPrint = null;
			JasperReport jasper = JasperCompileManager.compileReport(jrxml);
			String pdfFilePath = "/home/emannuel/Documentos/relatorioProprietario.pdf";
			jasperPrint = JasperFillManager.fillReport(jasper, param, DAO.conectarJDBC());
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
			exporter.exportReport();
			JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFilePath);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        DAO.conectarJDBC().close(); 
	}
		
	}
	public void gerarRelatorioVeiculo(String jrxml, Map<String, Object> param, HttpServletResponse response) throws SQLException {
		Connection connection = DAO.conectarJDBC();
		String pdfFilePath = "";
		
		try {
			if(param.get("PLACA")!= null) {
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=\"relatorioVeiculoPlaca.pdf\"");
				pdfFilePath = "/home/emannuel/Documentos/relatorioVeiculoPlaca.pdf";
			}else {
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=\"relatorioVeiculo.pdf\"");
				pdfFilePath = "/home/emannuel/Documentos/relatorioVeiculo.pdf";
			}
			JasperPrint jasperPrint = null;
			JasperReport jasper = JasperCompileManager.compileReport(jrxml);
			jasperPrint = JasperFillManager.fillReport(jasper, param, DAO.conectarJDBC());
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
			exporter.exportReport();
			JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFilePath);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        DAO.conectarJDBC().close(); 
	}
		
	}


}
