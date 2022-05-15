package com.system.reservation.magnus.repository.crud;

import java.util.Date;
import java.util.List;

import com.system.reservation.magnus.model.Reservations;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationsCrudRepository extends CrudRepository <Reservations, Integer> {
    public List<Reservations> findAllByStatus (String status); 
    
    public List<Reservations> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reservations AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
    
}
