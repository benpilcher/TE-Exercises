package com.techelevator.dao.jdbc;

import com.techelevator.dao.ReservationDAO;
import com.techelevator.model.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCReservationDAO implements ReservationDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCReservationDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) {
    
    	String sqlInsertReservation = "INSERT INTO reservation (site_id, name, from_date, to_date) " + 
    								  "VALUES (?, ?, ?, ?)" +
    								  "RETURNING reservation_id";
    	SqlRowSet getReservationId = jdbcTemplate.queryForRowSet(sqlInsertReservation, siteId, name, fromDate, toDate);
    	getReservationId.next();
    	int confirmationId = getReservationId.getInt("reservation_id");
		return confirmationId;		
    	
    }
     
    @Override
    public List<Reservation> getAllReservations (int parkId, LocalDate fromDate) {
		List<Reservation> allReservations = new ArrayList<>();
		String sqlAllReservations = "SELECT * " +
				 				   "FROM reservation JOIN site ON reservation.site_id = site.site_id " +
				 				   "JOIN campground ON site.campground_id = campground.campground_id " +
				 				   "JOIN park ON campground.park_id = park.park_id " +
				 				   "WHERE park.park_id = ? AND now() < reservation.from_date AND reservation.from_date IS NOT NULL";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllReservations, parkId);
		
		while (results.next()) {
			Reservation reservationResult = mapRowToReservation(results);
			allReservations.add(reservationResult);
		}
		
		return allReservations; 
    }
  
    private Reservation mapRowToReservation(SqlRowSet results) {
        Reservation r = new Reservation();
        r.setReservationId(results.getInt("reservation_id"));
        r.setSiteId(results.getInt("site_id"));
        r.setName(results.getString("name"));
        r.setFromDate(results.getDate("from_date").toLocalDate());
        r.setToDate(results.getDate("to_date").toLocalDate());
        r.setCreateDate(results.getDate("create_date").toLocalDate());
        return r;
    }

}
