package com.coke.ice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coke.ice.domain.IceBoard;
import com.coke.ice.domain.IceFile;
import com.coke.ice.service.BoardService;
import com.coke.ice.service.FileService;


@Controller
public class FileController {
	
	@Autowired
	private FileService fileservice;
	
	@Autowired
	private BoardService boardservice;
	
	@RequestMapping(value = "file/filelist", method = RequestMethod.GET)
	public String filelist(Model model) {

		return "/file/filelist";
	}
	
	@RequestMapping(value = "file/filedownload", method = RequestMethod.GET)
	public String filedownload(Model model, HttpServletRequest request) {
		List<IceFile> list = fileservice.filedownload(request);
		
		model.addAttribute("filedownload", list);
		return "/file/filedownload";
	}
	@RequestMapping(value = "filedown/{filenum}", method = RequestMethod.GET)
	public String filedownload(Model model,HttpServletResponse response, @PathVariable("filenum") int filenum) {
//		System.out.println("파일 컨트롤러 ::::::" + "FLAG !!!");
		File downloadFile = fileservice.filedown(response, filenum);
		
		
		model.addAttribute("downloadFile", downloadFile);
		
//		System.out.println("파일 컨트롤러 ::::::" + downloadFile.toString());
		return "download";
		
	}
	
	
	@RequestMapping(value = "file/fileupload", method = RequestMethod.GET)
	public String fileupload(Model model) {
		
		return "/file/fileupload";
	}
	@RequestMapping(value = "/file/fileupload", method = RequestMethod.POST)
	public String fileupload(Model model, MultipartHttpServletRequest request) {
		
		System.err.println("파일 컨트롤러" + request.toString());
		boolean r =fileservice.fileupload(request);
		
		// r 이용해서 progress bar 만들때 ajax 사용하면 될 듯.
		return "/file/filelist";
	}
	
	@RequestMapping(value="/file/exceldownload.xls")
	public void exceldownload(HttpServletResponse response) {
		
//		System.out.println("컨트롤러 ::::::");
		List<IceBoard> boardlist = boardservice.boardlist();
		
//		System.out.println("컨트롤러 ::::::" + boardlist.toString());
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("게시판");
		
	    // 테이블 헤더용 스타일
	    CellStyle headStyle = wb.createCellStyle();
	    // 가는 경계선
	    headStyle.setBorderTop(BorderStyle.THIN);
	    headStyle.setBorderBottom(BorderStyle.THIN);
	    headStyle.setBorderLeft(BorderStyle.THIN);
	    headStyle.setBorderRight(BorderStyle.THIN);
	    // 데이터를 구분할 수 있는 경계선
	    CellStyle bodyStyle = wb.createCellStyle();
	    bodyStyle.setBorderTop(BorderStyle.THIN);
	    bodyStyle.setBorderBottom(BorderStyle.THIN);
	    bodyStyle.setBorderLeft(BorderStyle.THIN);
	    bodyStyle.setBorderRight(BorderStyle.THIN);
	    
//	    System.out.println("컨트롤러 :::::: FLAG1" );
	    Row row = null;
	    Cell cell = null;
	    int index = 0;
	    // 헤더 생성
	    row = sheet.createRow(index++);
	    cell = row.createCell(0);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("번호");
	    cell = row.createCell(1);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("제목");
	    cell = row.createCell(2);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("작성자");
	    cell = row.createCell(3);
	    cell.setCellStyle(headStyle);
	    cell.setCellValue("작성일/수정일");
//	    System.out.println("컨트롤러 :::::: FLAG2" );
	    
	    for(IceBoard tmp : boardlist) {
	        row = sheet.createRow(index++);
	        cell = row.createCell(0);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(tmp.getBoardnum());
	        cell = row.createCell(1);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(tmp.getBoardtitle());
	        cell = row.createCell(2);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(tmp.getNickname());
	        cell = row.createCell(3);
	        cell.setCellStyle(bodyStyle);
	        cell.setCellValue(tmp.getDispdate());
	        
	    }
	    
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd hh-mm-ss");
	    String today =sdf.format(cal.getTime());
	    
//	    System.out.println("컨트롤러 ::::::"+ today);
	    
	    String filename= "IceBoard" + today +".xls";
	    response.setContentType("ms-vnd/excel");
//	    System.out.println("컨트롤러 ::::::" + filename);
	    response.setHeader("Content-Disposition", "attachment;filename=" +filename);
	    
	    
	    try {
			wb.write(response.getOutputStream());
			wb.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
//	    https://offbyone.tistory.com/250 참고 소스.
	}
	
	@RequestMapping(value="filedelete/{filenum}" ,method=RequestMethod.GET)
	public String filedelete(Model model , @PathVariable("filenum") int filenum) {
		fileservice.filedelete(filenum);
		
		return "redirect:/file/filedownload";
	}
	
}
