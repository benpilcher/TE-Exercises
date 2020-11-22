package com.techelevator.dao.jdbc;

import com.techelevator.dao.ReservationDAO;
import com.techelevator.model.Reservation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JDBCReservationDAOTests extends BaseDAOTests {

    private ReservationDAO dao;

    @Before
    public void setup() {
        dao = new JDBCReservationDAO(dataSource);
    } 

    @Test
    public void createReservation_Should_ReturnNewReservationId() {
        int reservationCreated = dao.createReservation(1,
                "TEST NAME",
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(3));

        Assert.assertTrue(reservationCreated > 0);
    }
    
    @Test
    public void getAllReservations_returns_all_upcoming_reservations () {
    	List<Reservation> upcomingReservationsAtAcadia = dao.getAllReservations(1, LocalDate.now().plusDays(30));
    	
    	assertEquals(upcomingReservationsAtAcadia.size(), 13);
    	
    }

}
