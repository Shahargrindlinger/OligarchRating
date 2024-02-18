package com.OligarchRating.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OligarchRating.request.FinancialAssets;
import com.OligarchRating.request.OligarchRequest;
import com.OligarchRating.request.PersonInformation;
import com.OligarchRating.model.*;
import com.OligarchRating.services.*;

@RestController
public class OligarchRatingController {
	
	
	@Autowired
    private OligarchRatingServices oligarchRatingServices;
	
	@PostMapping("/validateIfOligarch/{id}")
	public ResponseEntity<?> validateIfOligarch(@PathVariable Long id, @RequestBody OligarchRequest oligarchRequest) {
	    PersonInformation personInformation = oligarchRequest.getPersonInformation();
	    FinancialAssets financialAssets = oligarchRequest.getFinancialAssets();
	    return oligarchRatingServices.validateIfOligarch(id, personInformation, financialAssets);
	}
    
    @GetMapping("/getOligarchsList")
    public List<Oligarch> getAllOligarchs() {
        return oligarchRatingServices.getAllOligarchs();
    }

    @GetMapping("/getOligarchById")
    public Oligarch getOligarchById(@RequestParam Long id) {
        return oligarchRatingServices.getOligarchById(id);
    }

    @GetMapping("/getOligarchRankById/{id}")
    public int getOligarchRankById(@PathVariable Long id) {
    	int index = 1 + oligarchRatingServices.getOligarchRankById(id);
    	System.out.print(" Person ID "+id+" is ranked number "+index+" in the world’s oligarch list");
    	return index;
    }
    
}
