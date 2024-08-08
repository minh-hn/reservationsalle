package fr.hn.reservation.controller.admin;
import java.io.IOException;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.hn.reservation.entity.Salle;
import fr.hn.reservation.service.IAdminReservationService;
@RolesAllowed({ "ROLE_VIEWER", "ROLE_ADMIN" })
@RequestMapping({"admin/"})
@Controller
public class AdminReservationController {
	 @Autowired
	  private IAdminReservationService reservationService;
	  
	  @RequestMapping({"/uploadFiles"})
	  public String uploadFiles(HttpSession session, Model model, @RequestParam("file") MultipartFile file) throws IOException {
	    if (file != null) {
	    	List<Salle> salleList=reservationService.initSalles(file);
	    	model.addAttribute("salles", salleList);
	    	
	    	return "admin/show_salles";
	    } 
	    return "homepage";
	  }
	  
}
