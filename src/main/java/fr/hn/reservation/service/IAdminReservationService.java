package fr.hn.reservation.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import fr.hn.reservation.entity.Salle;

public interface IAdminReservationService {
	public List<Salle> initSalles(MultipartFile file) throws IOException;
}
