package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Billing;

public class BillingDAO {

	public boolean generateBill(Billing bill) {

	    try (Connection con = DBConnection.getConnection()) {

	        // STEP 1: CHECK ONLY MEMBER ID
	        String checkSql =
	        "SELECT billId FROM billing WHERE memberId=?";

	        PreparedStatement checkPs = con.prepareStatement(checkSql);
	        checkPs.setInt(1, bill.getMemberId());

	        ResultSet rs = checkPs.executeQuery();

	        if (rs.next()) {
	            System.out.println("❌ Bill already exists for this Member!");
	            return false;
	        }

	        // STEP 2: INSERT
	        String sql =
	        "INSERT INTO billing(memberId, packageId, billingDate, amount, paidAmount, balanceAmount, billingStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, bill.getMemberId());
	        ps.setInt(2, bill.getPackageId());
	        ps.setDate(3, Date.valueOf(bill.getBillingDate()));
	        ps.setDouble(4, bill.getAmount());
	        ps.setDouble(5, bill.getPaidAmount());
	        ps.setDouble(6, bill.getBalanceAmount());
	        ps.setString(7, bill.getBillingStatus());

	        return ps.executeUpdate() > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
    public double getPackageAmount(int packageId) {

        String sql = "SELECT price FROM package WHERE packageId = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, packageId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getDouble("price");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return 0;
    }

    public boolean updateBill(int billId, double payAmount) {

        try (Connection con = DBConnection.getConnection()) {

            // Get current bill details
            String selectSql =
            "SELECT amount, paidAmount, balanceAmount " +
            "FROM billing WHERE billId = ?";

            PreparedStatement selectPs =
            con.prepareStatement(selectSql);

            selectPs.setInt(1, billId);

            ResultSet rs = selectPs.executeQuery();

            if (rs.next()) {

                double totalAmount =
                rs.getDouble("amount");

                double currentPaid =
                rs.getDouble("paidAmount");

                double currentBalance =
                rs.getDouble("balanceAmount");

                // Already paid
                if (currentBalance == 0) {

                    System.out.println(
                    "Bill already fully paid");

                    return false;
                }

                // Extra payment check
                if (payAmount > currentBalance) {

                    System.out.println(
                    "Payment exceeds balance");

                    return false;
                }

                // New calculations
                double newPaid =
                currentPaid + payAmount;

                double newBalance =
                totalAmount - newPaid;

                String status;

             // No payment
             if (newPaid == 0) {

                 status = "Unpaid";
             }

             // Partial payment
             else if (newBalance > 0) {

                 status = "Pending";
             }

             // Fully paid
             else {

                 status = "Paid";
             }
                // Update query
                String updateSql =
                "UPDATE billing SET " +
                "paidAmount = ?, " +
                "balanceAmount = ?, " +
                "billingStatus = ? " +
                "WHERE billId = ?";

                PreparedStatement updatePs =
                con.prepareStatement(updateSql);

                updatePs.setDouble(1, newPaid);

                updatePs.setDouble(2, newBalance);

                updatePs.setString(3, status);

                updatePs.setInt(4, billId);

                return updatePs.executeUpdate() > 0;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    
    public Billing viewBillById(int billId) {

        String sql = "SELECT * FROM billing WHERE billId=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Billing b = new Billing();

                b.setBillId(rs.getInt("billId"));

                b.setMemberId(rs.getInt("memberId"));

                b.setPackageId(rs.getInt("packageId"));

                b.setBillingDate(
                rs.getDate("billingDate").toLocalDate());

                b.setAmount(rs.getDouble("amount"));

                b.setPaidAmount(rs.getDouble("paidAmount"));

                b.setBalanceAmount(
                rs.getDouble("balanceAmount"));

                b.setBillingStatus(
                rs.getString("billingStatus"));

                return b;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Billing> viewAllBills() {

        List<Billing> list = new ArrayList<>();

        String sql = "SELECT * FROM billing";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Billing b = new Billing();

                b.setBillId(rs.getInt("billId"));

                b.setMemberId(rs.getInt("memberId"));

                b.setPackageId(rs.getInt("packageId"));

                b.setBillingDate(
                rs.getDate("billingDate").toLocalDate());

                b.setAmount(rs.getDouble("amount"));

                b.setPaidAmount(rs.getDouble("paidAmount"));

                b.setBalanceAmount(
                rs.getDouble("balanceAmount"));

                b.setBillingStatus(
                rs.getString("billingStatus"));

                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<Billing> viewBillsByMemberId(int memberId) {

        List<Billing> list = new ArrayList<>();

        String sql = "SELECT * FROM billing WHERE memberId = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, memberId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Billing b = new Billing();

                b.setBillId(rs.getInt("billId"));

                b.setMemberId(rs.getInt("memberId"));

                b.setPackageId(rs.getInt("packageId"));

                b.setBillingDate(
                rs.getDate("billingDate").toLocalDate());

                b.setAmount(rs.getDouble("amount"));

                b.setPaidAmount(rs.getDouble("paidAmount"));

                b.setBalanceAmount(
                rs.getDouble("balanceAmount"));

                b.setBillingStatus(
                rs.getString("billingStatus"));

                list.add(b);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}