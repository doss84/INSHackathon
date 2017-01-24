package org.tcs.hackathon.client;

public class GeoLocationVO 
{
	private AddressComponentVO[] address_components;
	private String formatted_address;
	private GeometryVO geometry;
	private String place_id;
	private String[] types;
	private String[] postcode_localities;
	
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	public AddressComponentVO[] getAddress_components() {
		return address_components;
	}
	public void setAddress_components(AddressComponentVO[] address_components) {
		this.address_components = address_components;
	}
	public String[] getPostcode_localities() {
		return postcode_localities;
	}
	public void setPostcode_localities(String[] postcode_localities) {
		this.postcode_localities = postcode_localities;
	}
	public GeometryVO getGeometry() {
		return geometry;
	}
	public void setGeometry(GeometryVO geometry) {
		this.geometry = geometry;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	
	
}
