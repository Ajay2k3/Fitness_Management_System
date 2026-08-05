package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import com.model.Package;

public class PackageDAO {
	Connection con = DBConnection.getConnection();

    // ADD PACKAGE

    public boolean addPackage(Package p) {

        boolean status = false;

        try {

            

            String query =
            "insert into package(name,price,planIds) values(?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, p.getName());

            pst.setDouble(2, p.getPrice());

            pst.setString(3, p.getPlanIds());

            int rows = pst.executeUpdate();

            if(rows > 0) {

                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }

 

    // 1. Update Name
    public boolean updatePackageName(int packageId, String name) {

        boolean status = false;

        try {

            String query = "update package set name=? where packageId=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, name);
            pst.setInt(2, packageId);

            int rows = pst.executeUpdate();

            if(rows > 0) status = true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // 2. Update Price
    public boolean updatePackagePrice(int packageId, double price) {

        boolean status = false;

        try {

            String query = "update package set price=? where packageId=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setDouble(1, price);
            pst.setInt(2, packageId);

            int rows = pst.executeUpdate();

            if(rows > 0) status = true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // 3. Update PlanIds
    public boolean updatePackagePlanIds(int packageId, String planIds) {

        boolean status = false;

        try {

            String query = "update package set planIds=? where packageId=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, planIds);
            pst.setInt(2, packageId);

            int rows = pst.executeUpdate();

            if(rows > 0) status = true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    // VIEW PACKAGE BY ID

    public void viewPackageById(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "select * from package where packageId=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if(rs.next()) {

                System.out.println("----------------------");

                System.out.println("Package Id : "
                        + rs.getInt("packageId"));

                System.out.println("Package Name : "
                        + rs.getString("name"));

                System.out.println("Price : "
                        + rs.getDouble("price"));
                System.out.println("planIds : "+rs.getString("planIds"));

                String planIds =
                        rs.getString("planIds");

                String[] ids =
                        planIds.split(":");

                StringBuilder planNames =
                        new StringBuilder();

                for(String pid : ids) {

                    String planQuery =
                    "select name from plan where planId=?";

                    PreparedStatement ps2 =
                            con.prepareStatement(planQuery);

                    ps2.setInt(1,
                            Integer.parseInt(pid.trim()));

                    ResultSet rs2 =
                            ps2.executeQuery();

                    if(rs2.next()) {

                        planNames.append(
                                rs2.getString("name"))
                                .append(", ");
                    }
                }

                if(planNames.length() > 0) {

                    planNames.delete(
                            planNames.length()-2,
                            planNames.length());
                }

                System.out.println("Plans : "
                        + planNames);
            }
            else {

                System.out.println("Package Not Found");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // VIEW ALL PACKAGES

    public void viewAllPackages() {

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "select * from package";

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while(rs.next()) {

                System.out.println("----------------------");

                System.out.println("Package Id : "
                        + rs.getInt("packageId"));

                System.out.println("Package Name : "
                        + rs.getString("name"));

                System.out.println("Price : "
                        + rs.getDouble("price"));

                String planIds =
                        rs.getString("planIds");

                String[] ids =
                        planIds.split(":");

                StringBuilder planNames =
                        new StringBuilder();

                for(String pid : ids) {

                    String planQuery =
                    "select name from plan where planId=?";

                    PreparedStatement ps2 =
                            con.prepareStatement(planQuery);

                    ps2.setInt(1,
                            Integer.parseInt(pid.trim()));

                    ResultSet rs2 =
                            ps2.executeQuery();

                    if(rs2.next()) {

                        planNames.append(
                                rs2.getString("name"))
                                .append(", ");
                    }
                }

                if(planNames.length() > 0) {

                    planNames.delete(
                            planNames.length()-2,
                            planNames.length());
                }

                System.out.println("Plans : "
                        + planNames);
            }
            

        } catch(Exception e) {

            e.printStackTrace();
            }
        }
    
    public double amountForPackage(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "select price from package where packageId=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
            
            return rs.getDouble("price");
            }
            else {
            	System.out.println("Package Not available");
            	return -1;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }
		return 0;
    }
    }
