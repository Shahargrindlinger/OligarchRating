package com.OligarchRating.services;

import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import com.OligarchRating.model.Oligarch;
import com.OligarchRating.repo.OligarchRepo;
import com.OligarchRating.request.FinancialAssets;
import com.OligarchRating.request.PersonInformation;

@Service
public class OligarchRatingServices {
	
    @Autowired
    private OligarchRepo oligarchRepo;

    @Value("${assets-valuation.url}")
    private String assetsValuationUrl;

    @Value("${oligarch-helper.url}")
    private String oligarchHelpeUrlr;
   
    public ResponseEntity<?> validateIfOligarch(Long id, PersonInformation personInformation, FinancialAssets financialAssets) {
    	double assetsValue = financialAssets.getCashAmount() + financialAssets.getBitcoinAmount()*getBitcoinValue();
    	double threshold = getOligarchThreshold(); 

        System.out.println("assetsValue = "+assetsValue);
        System.out.println("threshold = "+threshold);

    	if (assetsValue > threshold) {
            oligarchRepo.addNewOligarch(id, personInformation.getFirstName(), personInformation.getLastName(), assetsValue);
            System.out.println(id +"is Oligrach");
            return ResponseEntity.ok().build();
        } else {
        	System.out.println(id +"is not Oligrach");
        	return ResponseEntity.badRequest().build();
        }
    }

    public List<Oligarch> getAllOligarchs() {
        return oligarchRepo.getAllOligarchs();
    }

    public Oligarch getOligarchById(long id) {
        return oligarchRepo.getOligarchById(id);
     }

    public int getOligarchRankById(Long id) {
    	List<Long> oligarchListOrderByAssetsValue = oligarchRepo.getOligarchListOrderByAssetsValue();
    	return oligarchListOrderByAssetsValue.indexOf(id);
     }
    
    public double evaluateCash(double amount, String localCurrency) {
        String evaluateCashEndpoint = assetsValuationUrl + "/cash/evaluate?amount=" + amount + "&localCurrency=" + localCurrency;
        return performGetRequest(evaluateCashEndpoint, Double.class);
    }

    public double getBitcoinValue() {
        String bitcoinValueEndpoint = assetsValuationUrl + "/bitcoin/value";
        return performGetRequest(bitcoinValueEndpoint, Double.class);
    }

    public double getOligarchThreshold() {
        String oligarchThresholdEndpoint = oligarchHelpeUrlr + "/oligarch-threshold";
        return performGetRequest(oligarchThresholdEndpoint, Double.class);
    }
    
    private <T> T performGetRequest(String url, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, responseType);
    } 

}