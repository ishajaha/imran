package com.ci.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.ci.model.JobDetails;

public class JsonParserUtil {
	public static List<String> parseJsonOutput(String response){
		List<String> jobList = new ArrayList<String>();
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(response);
			JSONArray dataArr = (JSONArray) jsonObject.get("jobs");
			Iterator i = dataArr.iterator();
			while (i.hasNext()) {
				JSONObject innerObj = (JSONObject) i.next();
				String name = (String)innerObj.get("name");
				jobList.add(name);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobList;
	}
	public static JobDetails parseJobDetailsJsonOutput(String response){
		JobDetails jobDetails = new JobDetails();
		System.out.println("inside the parsing API");
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(response);
			
			jobDetails.setJobName((String)jsonObject.get("name"));
			jobDetails.setJobDescription((String)jsonObject.get("description"));
			JSONObject innerObj;
			if(jsonObject.get("firstBuild") != null){
				innerObj = (JSONObject)jsonObject.get("firstBuild");
				jobDetails.setFirstBuild(((Number)innerObj.get("number")).intValue());
			}
			if(jsonObject.get("lastBuild") != null){
				innerObj = (JSONObject)jsonObject.get("lastBuild");
				jobDetails.setLastBuild(((Number)innerObj.get("number")).intValue());
			}
			
			if(jsonObject.get("lastCompletedBuild") != null){
				innerObj = (JSONObject)jsonObject.get("lastCompletedBuild");
				jobDetails.setLastCompletedBuild(((Number)innerObj.get("number")).intValue());
			}
			
			if(jsonObject.get("lastStableBuild") != null){
				innerObj = (JSONObject)jsonObject.get("lastStableBuild");
				jobDetails.setLastStableBuild(((Number)innerObj.get("number")).intValue());
			}
			
			if(jsonObject.get("lastSuccessfulBuild") != null){
				innerObj = (JSONObject)jsonObject.get("lastSuccessfulBuild");
				jobDetails.setLastSuccessfulBuild(((Number)innerObj.get("number")).intValue());
			}
			
			if(jsonObject.get("lastFailedBuild") != null){
				innerObj = (JSONObject)jsonObject.get("lastFailedBuild");
				jobDetails.setLastFailedBuild(((Number)innerObj.get("number")).intValue());
			}
			
			if(jsonObject.get("lastUnsuccessfulBuild") != null){
				innerObj = (JSONObject)jsonObject.get("lastUnstableBuild");
				jobDetails.setLastUnstableBuild(((Number)innerObj.get("number")).intValue());
			}
			
			if(jsonObject.get("lastUnsuccessfulBuild") != null){
				innerObj = (JSONObject)jsonObject.get("lastUnsuccessfulBuild");
				jobDetails.setLastUnsuccessfulBuild(((Number)innerObj.get("number")).intValue());
			}
			/*innerObj = (JSONObject)jsonObject.get("healthReport");
			jobDetails.setHealthReport((String)innerObj.get("description"));*/
			//jobDetails.setInQueue((boolean)jsonObject.get("inQueue"));
			if(jsonObject.get("nextBuildNumber") != null){
				jobDetails.setNextBuildNumber(((Number)jsonObject.get("nextBuildNumber")).intValue());
			}
			
			System.out.println("before parsing build");
			JSONArray dataArr = (JSONArray) jsonObject.get("builds");
			List<Integer> buildList = new ArrayList<Integer>();
			Iterator i = dataArr.iterator();
			while (i.hasNext()) {
				JSONObject jObj = (JSONObject) i.next();
				int buildNo = ((Number) jObj.get("number")).intValue();
				buildList.add(buildNo);
			}
			jobDetails.setBuilds(buildList);
			System.out.println("end of parsing API");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		}
		return jobDetails;
	}
}
