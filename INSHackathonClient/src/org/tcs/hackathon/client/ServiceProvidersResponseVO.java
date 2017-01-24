package org.tcs.hackathon.client;

import java.util.List;

public class ServiceProvidersResponseVO 
{
	private List<ProviderDetailsVO> providerDetails;

	public List<ProviderDetailsVO> getProviderDetails() {
		return providerDetails;
	}

	public void setProviderDetails(List<ProviderDetailsVO> providerDetails) {
		this.providerDetails = providerDetails;
	}
}
