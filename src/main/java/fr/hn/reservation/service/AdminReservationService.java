package fr.hn.reservation.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.multipart.MultipartFile;

import fr.hn.reservation.entity.Equipement;
import fr.hn.reservation.entity.Salle;
import fr.hn.reservation.outil.PoiOutil;
import fr.hn.reservation.repository.IEquipementRepository;
import fr.hn.reservation.repository.ISalleRepository;
@Service
public class AdminReservationService implements IAdminReservationService{
	
	@Autowired
	private ISalleRepository salleRepository;
	
	@Autowired
	private IEquipementRepository equipementRepository;
	@Transactional
	public List<Salle> initSalles(MultipartFile file) throws IOException {
		List<Salle> listeSalle=new ArrayList<Salle>();
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

		      for (int rowIndex = 1; rowIndex < 13; rowIndex++) {
		        rowReader = worksheet.getRow(rowIndex);
		        String sallename = PoiOutil.getCellStringValue(formulaEvaluatorReader, rowReader.getCell(0));
		        if(sallename == null || "".equals(sallename)) {
		        	break;
		        }
		        int taille = PoiOutil.getCellIntegerValue(formulaEvaluatorReader, rowReader.getCell(1));
		        String equippements = PoiOutil.getCellStringValue(formulaEvaluatorReader, rowReader.getCell(2));
		        
		        Salle salleElt= new Salle();
		        salleElt.setNom(sallename);
		        salleElt.setNombrePlace(taille);
		        Salle salleBd=salleRepository.save(salleElt);
		        
		        if(equippements != null && !"".equals(equippements) && !"Néant".equals(equippements)) {
		        	//FIXME separateur 
		        	//enum 		        	

		        	 for(String elt : equippements.split("[+]")) {
				        	Equipement tmpEquipement =new Equipement();				        	
				        	tmpEquipement.setDescription(elt);
				        	tmpEquipement.setNom(elt);
				        	
				        	tmpEquipement.setSalle(salleBd);
				        	
				        	equipementRepository.save(tmpEquipement);
				        }
		        }
		       
		        
		      } 
		      xSSFWorkbook.close();
		    } catch (Exception e) {		
		    	
		      //throw new MultipartException("Innitialisations des salles en erreur");
		    } 
		return listeSalle;
	}
}
