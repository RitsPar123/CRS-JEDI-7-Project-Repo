/**
 * 
 */
package com.crs.flipkart.business;
import com.crs.flipkart.bean.Student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crs.flipkart.bean.ReportCard;
/**
 * @author srini
 *
 */
public class ReportCardService implements ReportCardServiceInterface {
	/*
	int id;
	HashMap<String,Double> m; // Subject Code, gpa
	double gpa; */
	private HashMap<String, ReportCard> report;
	
	public ReportCardService() {
		this.report= new HashMap<String,ReportCard>();
		report.put("1",new ReportCard(1,Arrays.asList("100", "102", "104","105"),Arrays.asList(3.0,4.1,3.5,3.6)));
		report.put("2",new ReportCard(2,Arrays.asList("101", "103", "102","105"),Arrays.asList(3.2,5.0,5.0,3.1)));
		report.put("3",new ReportCard(3,Arrays.asList("100", "103", "104","107"),Arrays.asList(2.4,4.2,3.7,3.8)));
	}
	
	public void ViewReportCard(String id) {
		ReportCard ViewCard = report.get(id); 
		System.out.println("Subject Code \t Grade");
		for(Map.Entry<String,Double> entry : ViewCard.getM().entrySet()) {
			System.out.println("Course ID: "+entry.getKey()+"\tGrade: "+entry.getValue());
		}
		System.out.println("Final GPA : "+String.format("%.4f", ViewCard.getGpa()));
	}

	
	
}
