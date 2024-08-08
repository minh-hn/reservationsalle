package fr.hn.reservation.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.hn.reservation.entity.Salle;
public interface IReservationRepository extends JpaRepository<Salle,Integer>{

}
