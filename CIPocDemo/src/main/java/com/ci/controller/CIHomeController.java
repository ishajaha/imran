package com.ci.controller;

import java.io.FileReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.ci.model.CIHome;
import com.ci.model.JobDetails;
import com.ci.service.JobService;

public class CIHomeController extends SimpleFormController{
	
	public CIHomeController(){
		setCommandClass(CIHome.class);
		setCommandName("CIInputForm");
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {

		CIHome jenkinsDetails = (CIHome)command;
		System.out.println(jenkinsDetails);
		
		URL url = new URL("http://localhost:8080/createItem?name="+jenkinsDetails.getJobName());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setInstanceFollowRedirects(false);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/xml");

		OutputStream os = connection.getOutputStream();

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		FileReader fileReader = new FileReader("C:\\config.xml");
		StreamSource source = new StreamSource(fileReader);
		StreamResult result = new StreamResult(os);
		transformer.transform(source, result);

		os.flush();
		System.out.println("status code is "+connection.getResponseCode());
		connection.disconnect();
		
		
		JobService jobSer = new JobService();
		JobDetails jobdetails = jobSer.getJobDetails("test2imran");
		ModelAndView model = new ModelAndView("jobdetails");
		model.addObject("jobdetails", jobdetails);
		return model;
	}
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {

		CIHome cust = new CIHome();
		cust.setGoal("\"clean\" \"install\" \"findbugs:findbugs\"");
		cust.setScm("svn");
		cust.setUrl("https://subversion.assembla.com/svn/testimran");
		
		return cust;
	}
	
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		
		Map referenceData = new HashMap();
	
		return referenceData;
	}
}