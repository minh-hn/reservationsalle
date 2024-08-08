package fr.hn.reservation.service;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import fr.hn.reservation.entity.Salle;
import fr.hn.reservation.outil.PoiOutil;
import fr.hn.reservation.repository.ISalleRepository;
@Service
public class ClientReservationService implements IClientReservationService{
	
	@Autowired
	private ISalleRepository salleRepository;

	
	@Transactional
	public Map<String, List<Salle>> bookRoom(MultipartFile file) throws IOException {
		Map<String, List<Salle>> mapCompatible = new HashMap<String, List<Salle>> ();
		
		try {
		      XSSFWorkbook xSSFWorkbook=null;

		      if (file.getOriginalFilename().toLowerCase().indexOf("xlsx") == -1) {
		        HSSFWorkbook hSSFWorkbook = new HSSFWorkbook(file.getInputStream());
		      } else if (file.getOriginalFilename().toLowerCase().indexOf("xsl") == -1) {
		        xSSFWorkbook = new XSSFWorkbook(file.getInputStream());
		      } else {
		        return null;
		      } 
		      FormulaEvaluator formulaEvaluatorReader = xSSFWorkbook.getCreationHelper().createFormulaEvaluator();
		      Sheet worksheet = xSSFWorkbook.getSheetAt(0);
		      Row rowReader = worksheet.getRow(1);

		      for (int rowIndex = 1; rowIndex < 245; rowIndex++) {
		        rowReader = worksheet.getRow(rowIndex);
		        String reunion = PoiOutil.getCellStringValue(formulaEvaluatorReader, rowReader.getCell(0));
		        if(reunion == null || "".equals(reunion)) {
		        	break;
		        }
		        //String creneau = PoiOutil.getCellStringValue(formulaEvaluatorReader, rowReader.getCell(1));
		        String type = PoiOutil.getCellStringValue(formulaEvaluatorReader, rowReader.getCell(2));
		        int taille = PoiOutil.getCellIntegerValue(formulaEvaluatorReader, rowReader.getCell(3));
		        //String jour = PoiOutil.getCellStringValue(formulaEvaluatorReader, rowReader.getCell(4));
		        //int creneauInt=Integer.valueOf(creneau.substring(0, creneau.indexOf("h")));
		        
		        List<Salle> sallesTmp=null;
		       //TODO gérer toutes les règles et disponibilités...supression ou pas
		        //TODO gérer les déplacement des tableaux
        		switch (type) {
					case "RS":
						
						sallesTmp=salleRepository.findByNombrePlaceGreaterThanEqual( 3);
					       
						break;
					case "RC":
						
						sallesTmp=salleRepository.findByNombrePlaceGreaterThanEqual( taille);
					       
						break;
					case "SPEC":
						 
						sallesTmp=salleRepository.findByEquipementNomAndTaille("tableau", taille);
					       
						break;
					case "VC":
						 
						sallesTmp=salleRepository.findByEquipementNomAndTaille("webcam", taille);
					       
						break;
					default:
						sallesTmp=salleRepository.findAll();
						break;
				}	
		       
		        
		      } 
		      xSSFWorkbook.close();
		    } catch (Exception e) {		
		    	
		      
		    } 
		return mapCompatible;
	}
}
