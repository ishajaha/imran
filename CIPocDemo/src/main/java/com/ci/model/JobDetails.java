package com.ci.model;

import java.util.ArrayList;
import java.util.List;

public class JobDetails {
	private String jobName = "";
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public List<Integer> getBuilds() {
		return builds;
	}

	public void setBuilds(List<Integer> builds) {
		this.builds = builds;
	}

	public int getFirstBuild() {
		return firstBuild;
	}

	public void setFirstBuild(int firstBuild) {
		this.firstBuild = firstBuild;
	}

	public String getHealthReport() {
		return healthReport;
	}

	public void setHealthReport(String healthReport) {
		this.healthReport = healthReport;
	}

	public int getLastBuild() {
		return lastBuild;
	}

	public void setLastBuild(int lastBuild) {
		this.lastBuild = lastBuild;
	}

	public int getLastCompletedBuild() {
		return lastCompletedBuild;
	}

	public void setLastCompletedBuild(int lastCompletedBuild) {
		this.lastCompletedBuild = lastCompletedBuild;
	}

	public int getLastFailedBuild() {
		return lastFailedBuild;
	}

	public void setLastFailedBuild(int lastFailedBuild) {
		this.lastFailedBuild = lastFailedBuild;
	}

	public int getLastStableBuild() {
		return lastStableBuild;
	}

	public void setLastStableBuild(int lastStableBuild) {
		this.lastStableBuild = lastStableBuild;
	}

	public int getLastSuccessfulBuild() {
		return lastSuccessfulBuild;
	}

	public void setLastSuccessfulBuild(int lastSuccessfulBuild) {
		this.lastSuccessfulBuild = lastSuccessfulBuild;
	}

	public int getLastUnstableBuild() {
		return lastUnstableBuild;
	}

	public void setLastUnstableBuild(int lastUnstableBuild) {
		this.lastUnstableBuild = lastUnstableBuild;
	}

	public int getLastUnsuccessfulBuild() {
		return lastUnsuccessfulBuild;
	}

	public void setLastUnsuccessfulBuild(int lastUnsuccessfulBuild) {
		this.lastUnsuccessfulBuild = lastUnsuccessfulBuild;
	}

	public int getNextBuildNumber() {
		return nextBuildNumber;
	}

	public void setNextBuildNumber(int nextBuildNumber) {
		this.nextBuildNumber = nextBuildNumber;
	}

	public String isInQueue() {
		return inQueue;
	}

	public void setInQueue(String inQueue) {
		this.inQueue = inQueue;
	}

	private String jobDescription = "";
	private List<Integer> builds = new ArrayList<Integer>();
	private int firstBuild = 0;
	private String healthReport = "";
	private int lastBuild = 0;
	private int lastCompletedBuild = 0;
	private int lastFailedBuild = 0;
	private int lastStableBuild = 0;
	private int lastSuccessfulBuild = 0;
	private int lastUnstableBuild = 0;
	private int lastUnsuccessfulBuild = 0;
	private int nextBuildNumber = 0;
	private String inQueue = "";
	
	public JobDetails(){
		
	}
}
