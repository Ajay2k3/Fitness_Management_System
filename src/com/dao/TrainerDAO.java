package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Trainer;


public class TrainerDAO {

    Connection con = DBConnection.getConnection();

    // ADD TRAINER

    public boolean addTrainer(Trainer trainer) {

        boolean flag = false;

        try {

            String query =
                    "INSERT INTO trainer(name,specialization,contact,email,isActive) VALUES(?,?,?,?,?)";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setString(1, trainer.getTrainerName());

            pst.setString(2, trainer.getSpecialization());

            pst.setString(3, trainer.getContact());

            pst.setString(4, trainer.getEmail());

            pst.setBoolean(5, trainer.isActive());

          
            int rows = pst.executeUpdate();

            if (rows > 0) {

                flag = true;
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return flag;
    }

    // UPDATE TRAINER

    public boolean updateTrainerName(int trainerId, String name) {

        boolean flag = false;

        try {

            String query =
            "update trainer set name=? where trainerId=?";

            PreparedStatement pst =
            con.prepareStatement(query);

            pst.setString(1, name);
            pst.setInt(2, trainerId);

            int rows = pst.executeUpdate();

            if(rows > 0) {
                flag = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return flag;
    }

    // Update Specialization
    public boolean updateTrainerSpecialization(int trainerId,
                                               String specialization) {

        boolean flag = false;

        try {

            String query =
            "update trainer set specialization=? where trainerId=?";

            PreparedStatement pst =
            con.prepareStatement(query);

            pst.setString(1, specialization);
            pst.setInt(2, trainerId);

            int rows = pst.executeUpdate();

            if(rows > 0) {
                flag = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return flag;
    }

    // Update Contact
    public boolean updateTrainerContact(int trainerId,
                                        String contact) {

        boolean flag = false;

        try {

            String query =
            "update trainer set contact=? where trainerId=?";

            PreparedStatement pst =
            con.prepareStatement(query);

            pst.setString(1, contact);
            pst.setInt(2, trainerId);

            int rows = pst.executeUpdate();

            if(rows > 0) {
                flag = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return flag;
    }

    // Update Email
    public boolean updateTrainerEmail(int trainerId,
                                      String email) {

        boolean flag = false;

        try {

            String query =
            "update trainer set email=? where trainerId=?";

            PreparedStatement pst =
            con.prepareStatement(query);

            pst.setString(1, email);
            pst.setInt(2, trainerId);

            int rows = pst.executeUpdate();

            if(rows > 0) {
                flag = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return flag;
    }

    // Update Status
    public boolean updateTrainerStatus(int trainerId,
                                       boolean isActive) {

        boolean flag = false;

        try {

            String query =
            "update trainer set isActive=? where trainerId=?";

            PreparedStatement pst =
            con.prepareStatement(query);

            pst.setBoolean(1, isActive);
            pst.setInt(2, trainerId);

            int rows = pst.executeUpdate();

            if(rows > 0) {
                flag = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return flag;
    }

    // DEACTIVATE TRAINER

    public boolean deactivateTrainer(int trainerId) {

        boolean flag = false;

        try {

            String query =
                    "UPDATE trainer SET isActive=false WHERE trainerId=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, trainerId);

            int rows = pst.executeUpdate();

            if (rows > 0) {

                flag = true;
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return flag;
    }

    // VIEW TRAINER BY ID

    public void viewTrainerById(int trainerId) {

        try {

            String query =
                    "SELECT * FROM trainer WHERE trainerId=?";

            PreparedStatement pst =
                    con.prepareStatement(query);

            pst.setInt(1, trainerId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                System.out.println("\n========== TRAINER DETAILS ==========");

                System.out.println("Trainer ID : "
                        + rs.getInt("trainerId"));

                System.out.println("Trainer Name : "
                        + rs.getString("name"));

                System.out.println("Specialization : "
                        + rs.getString("specialization"));

                System.out.println("Contact : "
                        + rs.getString("contact"));

                System.out.println("Email : "
                        + rs.getString("email"));


                System.out.println("Status : "
                        + rs.getBoolean("isActive"));

            } else {

                System.out.println("Trainer Not Found");
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    // VIEW ALL TRAINERS

    public void viewAllTrainers() {

        try {

            String query = "SELECT * FROM trainer";

            PreparedStatement pst =
                    con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println("\n================================");

                System.out.println("Trainer ID : "
                        + rs.getInt("trainerId"));

                System.out.println("Trainer Name : "
                        + rs.getString("name"));

                System.out.println("Specialization : "
                        + rs.getString("specialization"));

                System.out.println("Contact : "
                        + rs.getString("contact"));

                System.out.println("Email : "
                        + rs.getString("email"));

 

                System.out.println("Status : "
                        + rs.getBoolean("isActive"));
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
