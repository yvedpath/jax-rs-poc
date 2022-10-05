/**

 * Project resteasy-download-pdf

 * com.tests.resteasy.download

 * Author  Jose Luis Maieron

 * Date    20 sept. 2022

 */

package com;



import javax.ws.rs.core.Response;



/**



 *

 */

public interface RestProxyService {

  public Response downloadContent(String documentId);

  

}


