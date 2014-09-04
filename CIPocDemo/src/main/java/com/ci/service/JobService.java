package com.ci.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.ci.model.JobDetails;

public class JobService {
	public JobService(){
		
	}
	public List<String> getAllProjects(){
		List<String> projectList = new ArrayList<String>();
		
		try {
			 
			URL url = new URL("http://localhost:8080/api/json");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
	 
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
	 
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			String output;
			StringBuffer jsonOutput = new StringBuffer();
			while ((output = br.readLine()) != null) {
				jsonOutput.append(output);
			}
			conn.disconnect();
			projectList = JsonParserUtil.parseJsonOutput(jsonOutput.toString());
			
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		return projectList;
	}
	public JobDetails getJobDetails(String jobName){
		JobDetails jobDetails = new JobDetails();
		
		try {
			 
			URL url = new URL("http://localhost:8080/job/"+jobName+"/api/json");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			System.out.println("status code is "+conn.getResponseCode());
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
	 
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			String output;
			StringBuffer jsonOutput = new StringBuffer();
			while ((output = br.readLine()) != null) {
				jsonOutput.append(output);
			}
			conn.disconnect();
			System.out.println(jsonOutput.toString());
			jobDetails = JsonParserUtil.parseJobDetailsJsonOutput(jsonOutput.toString());
			System.out.println(jobDetails);
	 
		  } catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		return jobDetails;
	}
	
	public void deleteJob(String jobName){
		
		
		try {
			 
			URL url = new URL("http://localhost:8080/job/"+jobName+"/doDelete");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			System.out.println("status code is "+conn.getResponseCode());
			if (conn.getResponseCode() != 302) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			conn.disconnect();
		} catch (MalformedURLException e) {
	 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
	}
}
