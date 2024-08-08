package fr.hn.reservation.controller.client;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.hn.reservation.entity.Salle;
import fr.hn.reservation.service.IClientReservationService;
@RolesAllowed({ "ROLE_CLIENT", "ROLE_ADMIN" })
@RequestMapping({"client/"})
@Controller
public class ClientReservationController {
	 @Autowired
	  private IClientReservationService clientReservationService;
	  
	  @RequestMapping({"/uploadFiles"})
	  public String uploadFiles(HttpSession session, Model model, @RequestParam("file") MultipartFile file) throws IOException {
	    if (file != null) {
	    	Map<String, List<Salle>> mapReservation=clientReservationService.bookRoom(file);
	    	model.addAttribute("mapReservation", mapReservation);
	    	return "client/show_reservation";
	    } 
	    return "homepage";
	  }
	  
}
