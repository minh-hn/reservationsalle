package fr.hn.reservation.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.hn.reservation.entity.Salle;
public interface ISalleRepository extends JpaRepository<Salle,Integer>{
	@Query(value="select  s from Salle s inner join  s.equipements e where  e.nom = :equipementNom and s.nombrePlace >= :nombrePlace ")
	public List<Salle> findByEquipementNomAndTaille(@Param("equipementNom") String equipementNom, @Param("nombrePlace") int nombrePlace);
	
	
	public List<Salle> findByNombrePlaceGreaterThanEqual( int nombrePlace);

}
