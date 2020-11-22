package com.techelevator.dao.jdbc;

import com.techelevator.dao.SiteDAO;
import com.techelevator.model.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCSiteDAO implements SiteDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCSiteDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getSitesThatAllowRVs(int parkId) {
        ArrayList<Site> sites = new ArrayList<>();
    	String sql = "SELECT s.site_id, s.campground_id, s.site_number, s.max_occupancy, s.accessible, s.max_rv_length, s.utilities" + 
    			" FROM site s JOIN campground c USING(campground_id)"
    			+" JOIN park p USING(park_id) WHERE p.park_id = ? AND s.max_rv_length > 0;";
    	SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);

    	while (results.next()) {
    		Site theSite = mapRowToSite(results);
    		sites.add(theSite);
    }
    	return sites;
    }
    

    @Override
    public List<Site> getSitesWithoutReservations (int parkId, LocalDate fromDate) {
        List<Site> sites = new ArrayList<>();
        String sqlSitesWithoutReservations = "SELECT * FROM site s JOIN reservation r USING(site_id) " + 
        									 "FULL OUTER JOIN campground c USING(campground_id) " + 
        									 "WHERE c.park_id = ? AND r.from_date < now() " + 
        									 "AND r.to_date > now() OR r.from_date IS NULL";      
        	
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSitesWithoutReservations, parkId);
        	
        while (results.next()) {
        	Site theSite = mapRowToSite(results);
        	sites.add(theSite);
        }
        	return sites;
    }
        
    @Override								
    public List<Site> getAvailableSitesDateRange (int parkId, LocalDate fromDate, LocalDate toDate) {
    	List<Site> availableSites = new ArrayList<>();
    	String sqlGetAvailableSites = "SELECT * FROM site FULL JOIN campground ON site.campground_id = campground.campground_id " +
    								  "FULL JOIN park ON campground.park_id = park.park_id " +
    								  "FULL JOIN reservation ON site.site_id = reservation.site_id " +
    								  "WHERE park.park_id = ? AND site.site_id NOT IN (" + 
    								  "SELECT reservation.site_id FROM reservation " +
    								  "WHERE (reservation.from_date BETWEEN ? AND ?) OR (reservation.to_date BETWEEN ? and ?) " +
    								  "OR (reservation.from_date > ? AND reservation.to_date < ?))";
    								  
    	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAvailableSites, parkId, fromDate, toDate, fromDate, toDate, fromDate, toDate);
		while (results.next()) {
			Site siteResult = mapRowToSite(results);
			availableSites.add(siteResult);
		}
		
		return availableSites;
    	
    }

    private Site mapRowToSite(SqlRowSet results) {
        Site site = new Site();
        site.setSiteId(results.getInt("site_id"));
        site.setCampgroundId(results.getInt("campground_id"));
        site.setSiteNumber(results.getInt("site_number"));
        site.setMaxOccupancy(results.getInt("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getInt("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        return site;
    }
}
