package solutions.foodProj.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import solutions.foodProj.dao.ReservationDAO;
import solutions.foodProj.exceptions.AppException;
import solutions.foodProj.model.Reservation;

@Path("/Reservation")
public class reservationController {
	
	
	@GET
	@Path("/allReservations")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getAllReservations(){
		AppResponse resp = new AppResponse();
		
		ReservationDAO resDAO = new ReservationDAO();
		
		try {
			List<Reservation> resList = resDAO.getAllReservations();
			resp.setPayload(resList);
			
			
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
			
		}
		
		
		
		
		
		return resp;
		
		
		
	}
	
	
	@GET
	@Path("/codeReserve/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse getReservation(@PathParam("id") int reserveId){
		AppResponse resp = new AppResponse();
		
		
		try {
			ReservationDAO resDAO = new ReservationDAO();
			Reservation res = resDAO.getSelectedReservation(reserveId);
			resp.setPayload(res);
			
			
			
			
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
			
		}
		
		
		
		return resp;
		
	}
	
	@POST
	@Path("/addRes")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AppResponse addReservation(Reservation res){
		AppResponse resp = new AppResponse();
		
		ReservationDAO addData = new ReservationDAO();
		try {
			res = addData.addReservation(res);
			resp.setMessage("Employee has been added to the system");
			resp.setPayload(res);
			System.out.println("Inside add reservation function");
			
			
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.setStatus(AppResponse.ERROR);
			resp.setMessage(e.getMessage());
		}
		
		return resp;
	}
	
	

}
 