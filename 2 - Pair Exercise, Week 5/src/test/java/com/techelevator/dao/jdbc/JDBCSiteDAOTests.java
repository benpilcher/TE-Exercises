package com.techelevator.dao.jdbc;

import com.techelevator.dao.SiteDAO;
import com.techelevator.model.Site;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JDBCSiteDAOTests extends BaseDAOTests {

    private SiteDAO dao;

    @Before
    public void setup() {
        dao = new JDBCSiteDAO(dataSource);
    }

    @Test
    public void getSitesThatAllowRVs_Should_ReturnSites() {
        List<Site> sites = dao.getSitesThatAllowRVs(1);

        assertEquals(20,sites.size());
    }
    
    @Test
    public void getAvailableSites_Should_ReturnSites() {
    	List<Site> sites = dao.getSitesWithoutReservations (2, LocalDate.now());
    	
    	assertEquals(5, sites.size());
    }

    @Test
    public void getAvailableSitesDateRange_Should_ReturnSites() {
    	List<Site> sites = dao.getAvailableSitesDateRange(1, LocalDate.now(), LocalDate.now().plusDays(3));
    
    	assertEquals(21, sites.size());
    }
}
