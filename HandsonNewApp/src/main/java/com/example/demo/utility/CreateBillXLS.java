package com.example.demo.utility;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.model.ChildVisitTransaction;
import com.example.demo.model.Settings;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@SuppressWarnings("deprecation")
public class CreateBillXLS {
	
	public void addLabel(WritableSheet sheet, int column, int row, String s)throws WriteException, RowsExceededException {
		WritableCellFormat cellFormat = new WritableCellFormat();
	      cellFormat.setAlignment(Alignment.CENTRE);
		    Label label= new Label(column, row, s,cellFormat);		    
		    sheet.addCell(label);
		  }
	public void addLabelwithH(WritableSheet sheet, int column, int row, String s)throws WriteException, RowsExceededException {
		WritableCellFormat cellFormat = new WritableCellFormat();
	      cellFormat.setAlignment(Alignment.CENTRE);
		    Label label= new Label(column, row, s,createFormatCellStatus(true));
		    sheet.setColumnView(column, 40);
		    sheet.addCell(label);
		  }
	public WritableCellFormat createFormatCellStatus(boolean b) throws WriteException{
	    WritableFont wfontStatus = new WritableFont(WritableFont.createFont("Arial"), WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
	    WritableCellFormat fCellstatus = new WritableCellFormat(wfontStatus);

	    fCellstatus.setWrap(true);
	    fCellstatus.setAlignment(jxl.format.Alignment.CENTRE);
	    fCellstatus.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
	    return fCellstatus;
	}
	public String capitalizeFirstLetter(String original) {
	    if (original == null || original.length() == 0) {
	        return original;
	    }
	    return original.substring(0, 1).toUpperCase() + original.substring(1);
	}
	
	public String[] splitString(String s){
	        String arr[] = s.split(" ");
	        String s1[] = new String[2];
	        s1[0] = "";
	        s1[1] = arr[arr.length-1];
	       for(int i = 0 ; i<arr.length-1 ; i++) {
	           s1[0] = s1[0] + arr[i]+" ";
	       }
	      return s1;
	}
	
	public String splitByPosition(String s){
        return s.substring(40);
    
	}
	
	public Float parser(String s){
		return Float.parseFloat(s);
	}
	
	/*public void generateEventBill(HttpServletRequest request,EventTransaction et,ServicesConfig service){
		 WritableWorkbook myFirstWbook = null;
		 String path =request.getServletContext().getRealPath("report");
		 File file = new File(path+"/bill1.xls");
		 try {			
			 myFirstWbook = Workbook.createWorkbook(file);
			 WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);
			 excelSheet.mergeCells(0, 0, 1, 0);
			 excelSheet.mergeCells(0, 1, 1, 1);
			 excelSheet.mergeCells(0, 2, 1, 2);
			 //excelSheet.mergeCells(0, 3, 1, 3);
			 excelSheet.mergeCells(0, 4, 1, 4);
			 excelSheet.mergeCells(0, 11, 1, 11);	
			
			 addLabel(excelSheet, 0, 0, "                   Hand'sOn Child Discovery Center");
			 
			 addLabel(excelSheet, 0, 1, "         M: "+service.getPhone());
			 addLabel(excelSheet, 0, 2, "         GSTIN No:");
			 addLabel(excelSheet, 0, 3, "         Date: "+et.getDate());addLabel(excelSheet, 1, 3, "                                         BillNo: "+et.getId());
			 addLabel(excelSheet, 0, 4, "-------------------------------------------------------------------------------------------");
			 addLabel(excelSheet, 0, 5, "         Total Food Charge");addLabel(excelSheet, 1, 5, "                                                 "+(et.getTotal_food_charge_adult()+et.getTotal_food_charge_child()));
			 addLabel(excelSheet, 0, 6, "         Total Entry Charge"); addLabel(excelSheet, 1, 6, "                                                 "+(et.getTotal_entry_charge_adult()+et.getTotal_entry_charge_child()));
			 addLabel(excelSheet, 0, 7, "         Cafe Cost"); addLabel(excelSheet, 1, 7, "                                                 "+(et.getCafe()));
			 addLabel(excelSheet, 0, 8, "         Miscellaneous Cost"); addLabel(excelSheet, 1, 8, "                                                 "+(et.getMiscellaneous()));
			 addLabel(excelSheet, 0, 9, "         Catering Cost"); addLabel(excelSheet, 1, 9, "                                                 "+(et.getCatering()));
			 addLabel(excelSheet, 0, 10, "         Play Cost"); addLabel(excelSheet, 1, 10, "                                                 "+(et.getPlaycost()));

			 addLabel(excelSheet, 0, 11, "-------------------------------------------------------------------------------------------");
			 addLabel(excelSheet, 0, 12, "         Deposit");addLabel(excelSheet, 1, 12, "                                                 "+et.getDeposit());
			 addLabel(excelSheet, 0, 13, "         Total");addLabel(excelSheet, 1, 13, "                                                 "+et.getTotal_charge());
			 addLabel(excelSheet, 0, 14, "         CGST ("+service.getCgst()+"%) + SGST ("+service.getSgst()+"%)");addLabel(excelSheet, 1, 14, "                                                 "+et.getGst());
			 addLabel(excelSheet, 0, 15, "         Sub Total");addLabel(excelSheet, 1, 15, "                                                 "+et.getSub_total());
			 addLabel(excelSheet, 0, 16,"         Pay");addLabel(excelSheet, 1, 16, "                                                 "+et.getPay_amount());
			 addLabel(excelSheet, 0, 17,"         Return");addLabel(excelSheet, 1, 17, "                                                 "+et.getReturn_amount());
			 addLabel(excelSheet, 0, 18,"------------------------Thank You Visit Again-----------------------------------------------");
			 myFirstWbook.write();			 
		} catch (IOException | WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
        }
		 try {
				new TicketPrintPage(file).printTicketFile(file, 1);
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    
	}
	
	public void generateClassBill(HttpServletRequest request,ClassTransaction ct,ServicesConfig service){
		 WritableWorkbook myFirstWbook = null;
		 String path =request.getServletContext().getRealPath("report");
		 File file = new File(path+"/bill2.xls");
		 try {			
			myFirstWbook = Workbook.createWorkbook(file);
			WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);
			excelSheet.mergeCells(0, 0, 1, 0);
			excelSheet.mergeCells(0, 1, 1, 1);
			excelSheet.mergeCells(0, 2, 1, 2);
			//excelSheet.mergeCells(0, 3, 1, 3);
			excelSheet.mergeCells(0, 4, 1, 4);
			
			addLabel(excelSheet, 0, 0, "                   Hand'sOn Child Discovery Center");
			
			addLabel(excelSheet, 0, 1, "         M: "+service.getPhone());
			addLabel(excelSheet, 0, 2, "         GSTIN No:");
			addLabel(excelSheet, 0, 3, "         Date: "+ct.getDate());addLabel(excelSheet, 1, 3, "                                         BillNo: "+ct.getId());
			addLabel(excelSheet, 0, 4, "-------------------------------------------------------------------------------------------");
			addLabel(excelSheet, 0, 5, "         Class Name");addLabel(excelSheet, 1, 5, "                                                 Price");
			int i=6;
			for(ListOfClasses item:ct.getL_of_Classes()){
				addLabel(excelSheet, 0, i, "         "+item.getClass_name());addLabel(excelSheet, 1, i, "                                                 "+item.getCost());
				i++;
			}
			addLabel(excelSheet, 0, i, "-------------------------------------------------------------------------------------------");
			addLabel(excelSheet, 0, i+1, "         Total");addLabel(excelSheet, 1, i+1, "                                                 "+ct.getTotal());
			addLabel(excelSheet, 0, i+2, "         CGST("+service.getCgst()+"%) + SGST("+service.getSgst()+"%)");addLabel(excelSheet, 1, i+2, "                                                 "+ct.getGst());
			addLabel(excelSheet, 0, i+3, "         Sub Total");addLabel(excelSheet, 1, i+3, "                                                 "+ct.getgTotal());
			addLabel(excelSheet, 0, i+4, "------------------------Thank You Visit Again-----------------------------------------------");
			myFirstWbook.write();
		} catch (IOException | WriteException e){
			//TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

           if (myFirstWbook != null) {
               try {
                   myFirstWbook.close();
               } catch (IOException e) {
                   e.printStackTrace();
               } catch (WriteException e) {
                   e.printStackTrace();
               }
           }
       }
		 try {
				new TicketPrintPage(file).printTicketFile(file, 1);
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   
	}
	*/
	public void generateBill(HttpServletRequest request,ChildVisitTransaction cTransaction,Settings settings){
		 WritableWorkbook myFirstWbook = null;
		 String path =request.getServletContext().getRealPath("report");
		 File file = new File(path+"/bill.xls");
		 try {			
			 myFirstWbook = Workbook.createWorkbook(file);
			 WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);
			 excelSheet.mergeCells(0, 0, 1, 0);
			 excelSheet.mergeCells(0, 1, 1, 1);
			 excelSheet.mergeCells(0, 2, 1, 2);
			// excelSheet.mergeCells(0, 3, 1, 3);
			 excelSheet.mergeCells(0, 4, 1, 4);
			 excelSheet.mergeCells(0, 11, 1, 11);	
			
			 addLabel(excelSheet, 0, 0, "                   Hand'sOn Child Discovery Center");
			 
			 addLabel(excelSheet, 0, 1, "         M: "+settings.getPhone());
			 addLabel(excelSheet, 0, 2, "         GSTIN No:");
			 addLabel(excelSheet, 0, 3, "         Date: "+cTransaction.getDate());addLabel(excelSheet, 1, 3, "                                         BillNo: "+cTransaction.getId());
			 addLabel(excelSheet, 0, 4, "         Child Name: "+cTransaction.getChild_name());addLabel(excelSheet, 1, 4, "                                         TT: "+cTransaction.getTotal_time()+"(min)");
			 addLabel(excelSheet, 0, 5, "-------------------------------------------------------------------------------------------");
			 addLabel(excelSheet, 0, 6, "         Playzone Cost");addLabel(excelSheet, 1, 6, "                                                 "+cTransaction.getPlayzone_cost());
			 addLabel(excelSheet, 0, 7, "         Library Cost"); addLabel(excelSheet, 1, 7, "                                                 "+cTransaction.getLibrary_cost());
			 if(cTransaction.getMiscellaneous_cost()!=null && cTransaction.getMiscellaneous_cost()>0){
			 addLabel(excelSheet, 0, 8, "         "+cTransaction.getComment()); addLabel(excelSheet, 1, 8, "                                                 "+cTransaction.getMiscellaneous_cost());
			 }
			 addLabel(excelSheet, 0, 9, "-------------------------------------------------------------------------------------------");
			 addLabel(excelSheet, 0, 10, "         Advance");addLabel(excelSheet, 1, 10, "                                                 "+cTransaction.getPaid_amount());
			 addLabel(excelSheet, 0, 11, "         Total");addLabel(excelSheet, 1, 11, "                                                 "+cTransaction.getTotal_amount());
			 //addLabel(excelSheet, 0, 12,"         Pay");addLabel(excelSheet, 1, 12, "                                                 "+cTransaction.getExtra_amount());
			 addLabel(excelSheet, 0, 12,"         Return");addLabel(excelSheet, 1, 12, "                                                 "+cTransaction.getRefund_amount());
			 addLabel(excelSheet, 0, 13,"------------------------Thank You Visit Again-----------------------------------------------");
			 myFirstWbook.write();			 
		} catch (IOException | WriteException e) {
			e.printStackTrace();
		}finally {

           if (myFirstWbook != null) {
               try {
                   myFirstWbook.close();
               } catch (IOException e) {
                   e.printStackTrace();
               } catch (WriteException e) {
                   e.printStackTrace();
               }
           }
       }
		 try {
				new TicketPrintPage(file).printTicketFile(file, 1);
			} catch (PrinterException e) {
				e.printStackTrace();
			}
   
	}
	
	public void generateDailyVisitReport(HttpServletRequest request,HttpServletResponse response,
			List<ChildVisitTransaction> childVisitTransaction,Map<String, Object> model){
		try {			
			File jrxmlfile = new File(request.getServletContext().getRealPath("/jrxml/report2.jrxml"));
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(childVisitTransaction,false);
			System.out.println(model.toString());
			InputStream streamFile = new FileInputStream(jrxmlfile);
			JasperReport jasperReport = JasperCompileManager.compileReport(streamFile);
			JasperPrint print = JasperFillManager.fillReport(jasperReport,model,dataSource);
			//JasperViewer.viewReport(print, true);
			File outputReport = new File(request.getServletContext().getRealPath("/report/dailyReport.pdf"));			
			JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(outputReport));
			JRPdfExporter exporter = new JRPdfExporter();
		        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print); 
		        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream()); 
		        response.setContentType("application/pdf");
		        exporter.exportReport();
			System.out.println("reportGenrated");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
