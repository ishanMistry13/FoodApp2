package solutions.foodProj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import solutions.foodProj.DBUtil.DBUtil;
import solutions.foodProj.exceptions.AppException;
import solutions.foodProj.model.Reservation;

public class ReservationDAO {

	public Reservation addReservation(Reservation res) throws AppException {

		Connection con = DBUtil.connectToDB();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(
					"INSERT INTO RESERVATION(reserveDate,reserveTime,custName,custPhone,custEmail,custPartySize,custSpecialNeed) values (?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, res.getResDate());
			ps.setString(2, res.getResTime());
			ps.setString(3, res.getCustName());
			ps.setString(4, res.getCustPhone());
			ps.setString(5, res.getCustEmail());
			ps.setString(6, res.getPartySize());
			ps.setString(7, res.getSpecialNeed());
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (rs.next()) {

				res.setResId(rs.getInt(1));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error creating reservation.", e.getCause());
		} finally {
			DBUtil.closeResources(ps, rs, con);

		}

		return res;

	}

	public Reservation getSelectedReservation(int resCode) throws AppException {
		Reservation res = new Reservation();
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select * from reservation where reservationCode=?");
			ps.setInt(1, resCode);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				res.setCustEmail(rs.getString("custEmail"));
				res.setCustName(rs.getString("custName"));
				res.setCustPhone(rs.getString("custPhone"));
				res.setPartySize(rs.getString("custPartySize"));
				res.setResDate(rs.getString("reserveDate"));
				res.setResId(rs.getInt("reservationCode"));
				res.setResTime(rs.getString("reserveTime"));
				res.setSpecialNeed(rs.getString("custSpecialNeed"));
				
			}else{
				throw new AppException("Employee with ID=" + resCode + " does not exist in the system.");
				
				
				
			}
			
			

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in fetching the record", e.getCause());
		}
		
		

		return res;
	}

	public List<Reservation> getAllReservations() throws AppException {
		List<Reservation> resAll = new ArrayList<Reservation>();
		Connection con = DBUtil.connectToDB();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("select * from reservation");
			rs = ps.executeQuery();

			while (rs.next()) {
				Reservation res = new Reservation();

				res.setCustEmail(rs.getString("custEmail"));
				res.setCustName(rs.getString("custName"));
				res.setCustPhone(rs.getString("custPhone"));
				res.setPartySize(rs.getString("custPartySize"));
				res.setResDate(rs.getString("reserveDate"));
				res.setResId(rs.getInt("reservationCode"));
				res.setResTime(rs.getString("reserveTime"));
				res.setSpecialNeed(rs.getString("custSpecialNeed"));

				resAll.add(res);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("Error in fetching the record", e.getCause());
		} finally {

			DBUtil.closeResources(ps, rs, con);

		}

		return resAll;

	}

}
