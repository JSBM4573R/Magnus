package com.system.reservation.magnus.controller;

import java.util.List;
import java.util.Optional;

import com.system.reservation.magnus.model.Reservations;
import com.system.reservation.magnus.reportes.ContadorClientes;
import com.system.reservation.magnus.reportes.StatusReservas;
import com.system.reservation.magnus.service.ReservationsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationsController {
    
    @Autowired
    private ReservationsService reservationsService;

    @GetMapping("/all")
    public List<Reservations>getReservations(){
        return reservationsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservations>getReservations(@PathVariable("id") int id){
        return reservationsService.getReservations(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations save(@RequestBody Reservations reservations){
        return reservationsService.save(reservations);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations update(Reservations reservations){
        return reservationsService.update(reservations);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int id){
        return reservationsService.deleteReservation(id);
    }

    @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return reservationsService.reporteStatusServicio();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservations> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
        return reservationsService.reporteTiempoServicio(dateOne, dateTwo);
    }
     
    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes(){
        return reservationsService.reporteClientesServicio();
    }
}
