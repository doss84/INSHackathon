package org.tcs.hackathon;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.tcs.hackathon.client.LocationVO;
import org.tcs.hackathon.client.ProviderDetailsVO;
import org.tcs.hackathon.client.ResultsVO;
import org.tcs.hackathon.client.ServiceProvidersRequestVO;
import org.tcs.hackathon.client.ServiceProvidersResponseVO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
public class INSHackathonService 
{
	private static final String GOOGLE_API_KEY ="AIzaSyDIa1DX3KP-RGIomG_20GLe-4JFtef5ZHc";
	private static final String GOOGLE_GEO_LOCATION = "https://maps.googleapis.com/maps/api/geocode/json";

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() 
  {
	  System.out.println(">>>> Hi Friends");
    return "Hello Jersey";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
	  System.out.println(">>>> Hi Friends1111");
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
	  System.out.println(">>>> Hi Friends2222");
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/providers")
  public String getProviders(ServiceProvidersRequestVO request)
  {
	  ServiceProvidersResponseVO response= new ServiceProvidersResponseVO();
	  populateProviderDetails(response);
	  
	  Gson gson = new GsonBuilder().create();
	  return gson.toJson(response);
	  
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/trackingDetails")
  public String getTrackingDeatils(@QueryParam("trackingID") String trackingID)
  {
	  System.err.println("trackingID is " + trackingID);
	  LocationVO response= new LocationVO();
	  populateLocationDetails(response);
	  
	  Gson gson = new GsonBuilder().create();
	  return gson.toJson(response);
	  
  }
  
  private void populateLocationDetails(LocationVO response) 
  {
	response.setLatitude("29.5113804");
	response.setLongitude("-98.5376141000000");
	
  }

private ServiceProvidersResponseVO populateProviderDetails(ServiceProvidersResponseVO response)
  {
	  
	  List<ProviderDetailsVO> providersList = new ArrayList<ProviderDetailsVO>();
	  
	  ProviderDetailsVO provider = new ProviderDetailsVO();
	  String address = "11000 Interstate 10 Frontage Rd, San Antonio, TX 78230";
	  String name = "MIDAS Auto Centre";
	  provider.setAddress(address);
	  provider.setName(name);
	  LocationVO location = geoLocation(address);
	  provider.setLocation(location);
	  
	  providersList.add(provider);
	  
	  ProviderDetailsVO provider1 = new ProviderDetailsVO();
	  String address1 = "8780 Huebner Rd, San Antonio, TX 78240";
	  String name1 = "CARX Auto Centre";
	  provider1.setAddress(address1);
	  provider1.setName(name1);
	  LocationVO location1 = geoLocation(address1);
	  provider1.setLocation(location1);
	  
	  providersList.add(provider1);
	  
	  ProviderDetailsVO provider2 = new ProviderDetailsVO();
	  String address2 = "2707 NW Loop 410, San Antonio, TX 78230";
	  String name2 = "Discount Tire";
	  provider2.setAddress(address2);
	  provider2.setName(name2);
	  LocationVO location2 = geoLocation(address2);
	  provider2.setLocation(location2);
	  
	  providersList.add(provider2);
	  
	  response.setProviderDetails(providersList);
	 
	  return response;
  }

private LocationVO geoLocation(String address)
{
	Client client = ClientBuilder.newClient();
	WebTarget target = client.target(GOOGLE_GEO_LOCATION);
	String msg = target.queryParam("address", address).queryParam("key", GOOGLE_API_KEY).request(MediaType.APPLICATION_JSON).get(String.class);
	
	Gson gson = new GsonBuilder().create();
	ResultsVO geo = gson.fromJson(msg, ResultsVO.class);
	
	System.out.println(" The message is " + msg);
	System.out.println(" The message isss " + geo.getResults()[0].getGeometry().getLocation().getLat());
	System.out.println(" The message isss " + geo.getResults()[0].getGeometry().getLocation().getLng());
	LocationVO location = new LocationVO();
	location.setLatitude(String.valueOf(geo.getResults()[0].getGeometry().getLocation().getLat()));
	location.setLongitude(String.valueOf(geo.getResults()[0].getGeometry().getLocation().getLng()));
	return location;
}

}