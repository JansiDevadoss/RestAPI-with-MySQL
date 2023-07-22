package com.example.project.service;

import java.util.Comparator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.CompanyDetails;
import com.example.project.CompanyRepository;
import com.example.project.service.CompanyService;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepo;
	
	public List<CompanyDetails> getTwoCompaniesWithLargestRent() {
        List<CompanyDetails> companies = companyRepo.findAll();
        companies.sort(Comparator.comparingInt(CompanyDetails::getRent).reversed());
        return companies.subList(0, 2);
    }

}
