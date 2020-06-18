package fr.paris.lutece.plugins.oauth2.modules.franceconnect.business.service;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.plugins.oauth2.service.DataClientService;

/**
 * 
 * FranceConnectService
 *
 */
public class FranceConnectService {

	private static final String FRANCE_CONNECT_HANDLER_NAME="franceConnectHandler";
	/**
	 * Return the DataClient url to call for initialize FranceConnect Authentication Process
	 * @param request the {@link HttpServletRequest}
	 * @param dataClientName the data client Name
	 * @return the DataClient url to call for initialize FranceConnect Authentication Process
	 */
	public static String getFranceConnectDataClientUrl(HttpServletRequest request,String dataClientName)
	{
		
		return DataClientService.instance().getDataClientUrl(request, dataClientName, FRANCE_CONNECT_HANDLER_NAME);
		
	}
}
