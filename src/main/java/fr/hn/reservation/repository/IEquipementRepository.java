package fr.hn.reservation.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.hn.reservation.entity.Equipement;

public interface IEquipementRepository extends JpaRepository<Equipement,Integer>{

}
