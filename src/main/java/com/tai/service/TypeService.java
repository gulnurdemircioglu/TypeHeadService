package com.tai.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Stateless
public class TypeService extends Type {

	private Type states=new Type();
	private String [] A = states.getStates();
	String val ="";
	static List<String> typeReturnList = new ArrayList();	
	//A = states.getStates();

	@GET
	@Path("/type_head")
	public Response getTypeHead(@QueryParam("value") String value) {
		val=value;
		typeReturnList.clear();
		for(int i = 0; i<A.length; i++)
		{
			if((A[i].toLowerCase()).contains(val))
			{ 
				typeReturnList.add(A[i]);
				
		
			}
			
		}
		return Response.ok(typeReturnList).build();
		//return Response.ok("Veri Bulunamadi!").build();
		
	}
	
	
	/*@POST
	@Path("/type_head")
	public Response postClient(String type)
	{
		val=type;
//		ResponseBuilder builder = Response.status(Status.CREATED);
		return Response.ok(type).header("Access-Control-Allow-Origin", "POST").build();
	}*/

	
}
