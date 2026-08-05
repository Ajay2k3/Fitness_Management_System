package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Plan;

public class PlanDAO {

	// ADD PLAN

	public boolean addPlan(Plan plan) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			String query = "insert into plan(name,description,duration_weeks) values(?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, plan.getName());
			pst.setString(2, plan.getDescription());
			pst.setInt(3, plan.getDurationWeeks());

			int rows = pst.executeUpdate();

			if (rows > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// Update Name
	public boolean updatePlanName(int planId, String name) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			String query = "update plan set name=? where planId=?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, name);
			pst.setInt(2, planId);

			int rows = pst.executeUpdate();

			if (rows > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// Update Description
	public boolean updatePlanDescription(int planId, String description) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			String query = "update plan set description=? where planId=?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, description);
			pst.setInt(2, planId);

			int rows = pst.executeUpdate();

			if (rows > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// Update Duration
	public boolean updatePlanDuration(int planId, int durationWeeks) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			String query = "update plan set duration_weeks=? where planId=?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, durationWeeks);
			pst.setInt(2, planId);

			int rows = pst.executeUpdate();

			if (rows > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}



	// VIEW PLAN BY ID

	public void viewPlanById(int id) {

		try {

			Connection con = DBConnection.getConnection();

			String query = "select * from plan where planId=?";

			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				System.out.println("Plan Id : " + rs.getInt("planId"));
				System.out.println("Name : " + rs.getString("name"));
				System.out.println("Description : " + rs.getString("description"));
				System.out.println("Duration Weeks : " + rs.getInt("duration_weeks"));
			} else {

				System.out.println("Plan Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// VIEW ALL PLANS

	public void viewAllPlans() {

		try {

			Connection con = DBConnection.getConnection();

			String query = "select * from plan";

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				System.out.println("--------------------");

				System.out.println("Plan Id : " + rs.getInt("planId"));

				System.out.println("Name : " + rs.getString("name"));

				System.out.println("Description : " + rs.getString("description"));

				System.out.println("Duration Weeks : " + rs.getInt("duration_weeks"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void allAvailablePlan() {

		try {

			Connection con = DBConnection.getConnection();

			String query = "select planId,name from plan";

			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				System.out.println("--------------------");

				System.out.println("Plan Id : " + rs.getInt("planId"));

				System.out.println("Name : " + rs.getString("name"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
