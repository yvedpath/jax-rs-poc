package com;
import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;



import org.apache.http.HttpStatus;

import org.apache.log4j.Logger;

import org.jboss.resteasy.annotations.providers.multipart.XopWithMultipartRelated;
@Path("/")
@Produces(MediaType.APPLICATION_XML)
public class RestProxyServiceImpl implements RestProxyService {
	private static final Logger log = Logger.getLogger(RestProxyServiceImpl.class);
	@GET
	@Produces({MediaType.MULTIPART_FORM_DATA, MediaType.APPLICATION_XML})
	@Path("/document/content/{documentId}")
	@XopWithMultipartRelated
	@Override
	public Response downloadContent(@PathParam("documentId") String documentId){
		log.info("downloadContent started...");
		System.out.println("download started");
		/*    String baseUrl  = com.RestProxyServiceImpl.class.getResource(".").getPath();
    String basePath = baseUrl.substring(0, baseUrl.indexOf("src/main/resources")); */
		 //String basePath="src/main/resource";
		String basePath="/home/yvedpath/NotBackedUp/Installation/jboss-eap-7.3.10/jboss-eap-7.3/";
		log.info("basePath="+basePath);
		byte[] pdfBuffer =null;
		try {
			System.out.println("Inside try");
			pdfBuffer = Utils.readFileToBytes(basePath+"demo.pdf");
			
		}catch(Exception e) {}
		ContentResponse response = new ContentResponse();
		response.setContent(pdfBuffer);
		response.setFileName("filename.pdf");
		response.setMimeType("application/pdf");
		log.info("downloadContent end!");
		//System.out.println(pdfBuffer.toString());
		return  Response.status(HttpStatus.SC_OK).entity(response).build();
	}
}


