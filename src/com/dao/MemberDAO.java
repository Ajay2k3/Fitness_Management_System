package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Member;

public class MemberDAO {

	Connection con = DBConnection.getConnection();

	public void addMember(Member m) {

		try {

			String query = "insert into member(name,contact,email,address,date_joined,isActive) values(?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, m.getName());
			ps.setString(2, m.getContact());
			ps.setString(3, m.getEmail());
			ps.setString(4, m.getAddress());
			ps.setDate(5, m.getDate_joined());
			ps.setBoolean(6, true);

			int rows = ps.executeUpdate();
			String id = "select memberId from member where contact=? and email=?";
			PreparedStatement ps1 = con.prepareStatement(id);
			ps1.setString(1, m.getContact());
			ps1.setString(2, m.getEmail());

			ResultSet idnum = ps1.executeQuery();
			if (rows > 0) {
				idnum.next();

				System.out.println("Member Added Successfully : " + idnum.getInt(1));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

//    public void updateMember(Member m) {
//
//        try {
//
//            String query =
//            "update member set name=?,contact=?,email=?,address=? where memberId=?";
//
//            PreparedStatement ps =
//                    con.prepareStatement(query);
//
//            ps.setString(1, m.getName());
//            ps.setString(2, m.getContact());
//            ps.setString(3, m.getEmail());
//            ps.setString(4, m.getAddress());
//            ps.setInt(5, m.getMemberId());
//
//            int rows = ps.executeUpdate();
//
//            if (rows > 0) {
//
//                System.out.println(
//                "Member Updated Successfully");
//
//            } else {
//
//                System.out.println(
//                "Member ID Not Found");
//            }
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//    }

	public void updateMemberName(int memberId, String name) {
		try {
			String query = "update member set name=? where memberId=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, name);
			ps.setInt(2, memberId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Name Updated Successfully");
			} else {
				System.out.println("Member Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Update Contact
	public void updateMemberContact(int memberId, String contact) {
		try {
			String query = "update member set contact=? where memberId=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, contact);
			ps.setInt(2, memberId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Contact Updated Successfully");
			} else {
				System.out.println("Member Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Update Email
	public void updateMemberEmail(int memberId, String email) {
		try {
			String query = "update member set email=? where memberId=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, email);
			ps.setInt(2, memberId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Email Updated Successfully");
			} else {
				System.out.println("Member Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Update Address
	public void updateMemberAddress(int memberId, String address) {
		try {
			String query = "update member set address=? where memberId=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, address);
			ps.setInt(2, memberId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Address Updated Successfully");
			} else {
				System.out.println("Member Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deactivateMember(int id) {

		try {

			String query = "update member set isActive=false where memberId=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);

			int rows = ps.executeUpdate();

			if (rows > 0) {

				System.out.println("Member Deactivated");

			} else {

				System.out.println("Member ID Not Found");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void viewMemberById(int id) {

		try {

			String query = "select * from member where memberId=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				System.out.println("Member ID : " + rs.getInt("memberId"));

				System.out.println("Name : " + rs.getString("name"));

				System.out.println("Contact : " + rs.getString("contact"));

				System.out.println("Email : " + rs.getString("email"));

				System.out.println("Address : " + rs.getString("address"));

				System.out.println("Date Joined : " + rs.getDate("date_joined"));

				System.out.println("Active : " + rs.getBoolean("isActive"));

			} else {

				System.out.println("Member Not Found");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void viewAllMembers() {

		try {

			String query = "select * from member";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				System.out.println("------------------------");

				System.out.println("Member ID : " + rs.getInt("memberId"));

				System.out.println("Name : " + rs.getString("name"));

				System.out.println("Contact : " + rs.getString("contact"));

				System.out.println("Email : " + rs.getString("email"));

				System.out.println("Address : " + rs.getString("address"));

				System.out.println("Date Joined : " + rs.getDate("date_joined"));

				System.out.println("Active : " + rs.getBoolean("isActive"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}