package fr.hn.reservation.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import fr.hn.reservation.entity.Salle;

public interface IClientReservationService {
	public Map<String, List<Salle>> bookRoom(MultipartFile file) throws IOException ;
}
