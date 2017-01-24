package org.tcs.hackathon.client;

public class GeometryVO 
{
	private ViewPortVO location;
	private ViewPort viewport;
	private String location_type;
	public ViewPortVO getLocation() {
		return location;
	}
	public void setLocation(ViewPortVO location) {
		this.location = location;
	}
	public ViewPort getViewport() {
		return viewport;
	}
	public void setViewport(ViewPort viewport) {
		this.viewport = viewport;
	}
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	
}
