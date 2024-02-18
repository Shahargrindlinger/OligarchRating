package com.OligarchRating;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.OligarchRating.controller.OligarchRatingController;
import com.OligarchRating.model.Oligarch;
import com.OligarchRating.request.FinancialAssets;
import com.OligarchRating.request.OligarchRequest;
import com.OligarchRating.request.PersonInformation;
import com.OligarchRating.services.OligarchRatingServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class OligarchRatingControllerTest {

    @Mock
    private OligarchRatingServices oligarchRatingServices;

    @InjectMocks
    private OligarchRatingController oligarchRatingController;

    @Test
    void validateIfOligarch() {
        // Create sample data
        Long id = 123456789L;
        OligarchRequest oligarchRequest = new OligarchRequest();
        oligarchRequest.setId(id);

        PersonInformation personInformation = new PersonInformation();
        personInformation.setFirstName("Bill");
        personInformation.setLastName("Gates");

        FinancialAssets financialAssets = new FinancialAssets();
        financialAssets.setCashAmount(16000000000.00);
        financialAssets.setCurrency("ILS");
        financialAssets.setBitcoinAmount(50);

        oligarchRequest.setPersonInformation(personInformation);
        oligarchRequest.setFinancialAssets(financialAssets);

        // Mock service method
        doNothing().when(oligarchRatingServices).validateIfOligarch(id, oligarchRequest.getPersonInformation(), oligarchRequest.getFinancialAssets());

        // Call the method
        ResponseEntity<?> response = (ResponseEntity<?>) oligarchRatingController.validateIfOligarch(id, oligarchRequest);

        // Verify service method is called
        verify(oligarchRatingServices, times(1)).validateIfOligarch(id, oligarchRequest.getPersonInformation(), oligarchRequest.getFinancialAssets());

        assertEquals(200, response.getStatusCodeValue());
    }

/*
    @Test
    void getAllOligarchs() {
    	Oligarch oligarch1 = new Oligarch();
    	oligarch1.setId(11111L);
    	oligarch1.setFirstName("Yael");
    	oligarch1.setLastName("Lev");
    	oligarch1.setAssetsValue(11000000.00);

    	Oligarch oligarch2 = new Oligarch();
    	oligarch2.setId(222222L);
    	oligarch2.setFirstName("Or");
    	oligarch2.setLastName("Gal");
    	oligarch2.setAssetsValue(15000000.00);
        // Mock service method
        List<Oligarch> mockOligarchs = Arrays.asList(oligarch1,oligarch2);

        when(oligarchRatingServices.getAllOligarchs()).thenReturn(mockOligarchs);

        // Call the method
        List<Oligarch> response = oligarchRatingController.getAllOligarchs();

        // Verify service method is called
        verify(oligarchRatingServices, times(1)).getAllOligarchs();

        assertEquals(mockOligarchs, response);
    }


    @Test
    void getOligarchById() {
        Long id = 123456789L;

        Oligarch mockOligarch = new Oligarch();
        mockOligarch.setId(id);
        
        when(oligarchRatingServices.getOligarchById(id)).thenReturn(mockOligarch);

        Oligarch response = oligarchRatingController.getOligarchById(id);

        verify(oligarchRatingServices, times(1)).getOligarchById(id);
        assertEquals(mockOligarch, response);
    }


    @Test
    void getOligarchRankById() {
        // Create sample data
        Long id = 123456789L;

        // Mock service method
        when(oligarchRatingServices.getOligarchRankById(id)).thenReturn(2);

        // Call the method
        Integer response = oligarchRatingController.getOligarchRankById(id);

        // Verify service method is called
        verify(oligarchRatingServices, times(1)).getOligarchRankById(id);

        // Assert the response
        assertEquals(2, response);
        // Add more assertions for the response body if needed
    }
*/
}
