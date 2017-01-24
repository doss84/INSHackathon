package org.tcs.hackathon.client;

public class ResultsVO 
{
	private GeoLocationVO[] results;
	private String status;
	public GeoLocationVO[] getResults() {
		return results;
	}
	public void setResults(GeoLocationVO[] results) {
		this.results = results;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
