package com.example.project.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.CompanyDetails;
import com.example.project.CompanyRepository;
import com.example.project.service.CompanyService;



@RestController 
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CompanyRepository companyRepo;
	
	
	@PostMapping("/companies")
	public String createCompany(@RequestBody CompanyDetails companyDetails) {
		companyRepo.save(companyDetails);
        return "company created successfully";
    }
	
	
	@GetMapping("/companies")
	public List<CompanyDetails> getAllCompanies(){
	    return companyRepo.findAll();
	}
	
	@GetMapping("/companies/sortedcompanies")
	public List<CompanyDetails> getTwoCompaniesWithLargestRent() {
		List<CompanyDetails> companyDetails = companyService.getTwoCompaniesWithLargestRent();
	    return companyDetails;
	}
	
	@PutMapping("/companies/{id}")
    public String updateCompany(@PathVariable("id") Long companyId,@RequestBody CompanyDetails companyDetails){         
		companyDetails.setId(companyId);                                                                              
		CompanyDetails updatedCompany = companyRepo.findById(companyDetails.getId()).get();
		updatedCompany.setName(companyDetails.getName());
		updatedCompany.setPhnNo(companyDetails.getPhnNo());
		updatedCompany.setEmailId(companyDetails.getEmailId());
		companyRepo.save(updatedCompany);
        return "company updated successfully";
    }

 
    @DeleteMapping("companies/{id}")
    public String deleteCompany(@PathVariable("id") Long companyId){
    	companyRepo.deleteById(companyId);
        return "Company deleted successfully";
    }
}


