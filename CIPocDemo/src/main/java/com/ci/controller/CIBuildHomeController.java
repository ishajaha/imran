package com.ci.controller;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.ci.model.JobDetails;
import com.ci.service.JobService;




public class CIBuildHomeController extends MultiActionController {
	
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	 
			List<String> projectList = new ArrayList<String>();
			JobService jobSer = new JobService();
			projectList = jobSer.getAllProjects();
			ModelAndView model = new ModelAndView("projectlist");
			model.addObject("projects", projectList);
		
			return model;
	 
		}
	 
		public ModelAndView build(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			String paramVal = request.getParameter("jobname");
			scheduleBuild(paramVal);
			
			JobService jobSer = new JobService();
			JobDetails jobdetails = jobSer.getJobDetails(paramVal);
			
			ModelAndView model = new ModelAndView("jobdetails");
			model.addObject("jobdetails", jobdetails);
		
			return model;
	 
		}
		
		public ModelAndView details(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
				String paramVal = request.getParameter("jobname");
				JobService jobSer = new JobService();
				JobDetails jobdetails = jobSer.getJobDetails(paramVal);
				
				ModelAndView model = new ModelAndView("jobdetails");
				model.addObject("jobdetails", jobdetails);
			
				return model;
		 
			}
		
		public ModelAndView delete(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
				String paramVal = request.getParameter("jobname");
				JobService jobSer = new JobService();
				jobSer.deleteJob(paramVal);				
				List<String> projectList = new ArrayList<String>();
				projectList = jobSer.getAllProjects();
				ModelAndView model = new ModelAndView("projectlist");
				model.addObject("projects", projectList);
			
				return model;
		 
			}
		
		private void scheduleBuild(String jobName){
			try {
				 
				URL url = new URL("http://localhost:8080/job/"+jobName+"/build");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				if (conn.getResponseCode() != 201) {
					System.out.println("response code is "+conn.getResponseCode());
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
