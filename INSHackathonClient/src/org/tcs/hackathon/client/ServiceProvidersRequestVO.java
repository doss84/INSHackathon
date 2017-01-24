package org.tcs.hackathon.client;

public class ServiceProvidersRequestVO 
{

	private String assistanceType;
	private LocationVO location;
	
	public LocationVO getLocation() {
		return location;
	}
	public void setLocation(LocationVO location) {
		this.location = location;
	}
	public String getAssistanceType() {
		return assistanceType;
	}
	public void setAssistanceType(String assistanceType) {
		this.assistanceType = assistanceType;
	}
	
	
}
