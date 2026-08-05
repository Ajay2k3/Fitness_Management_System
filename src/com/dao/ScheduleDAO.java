package com.dao;

import com.model.Schedule;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {

    public boolean isTrainerBooked(int trainerId, Date sessionDate, Time sessionTime) throws Exception {

        String sql = "SELECT * FROM schedule WHERE trainerId = ? AND session_date = ? AND session_time = ?";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, trainerId);
        ps.setDate(2, sessionDate);
        ps.setTime(3, sessionTime);

        ResultSet rs = ps.executeQuery();

        boolean booked = rs.next();

        rs.close();
       
        return booked;
    }

    public int addSchedule(Schedule schedule) throws Exception {

        String sql = "INSERT INTO schedule(memberId, trainerId, session_date, session_time, duration_minutes) VALUES (?, ?, ?, ?, ?)";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, schedule.getMemberId());
        ps.setInt(2, schedule.getTrainerId());
        ps.setDate(3, schedule.getSessionDate());
        ps.setTime(4, schedule.getSessionTime());
        ps.setInt(5, schedule.getDurationMinutes());

        int result = ps.executeUpdate();

      //  ps.close();
       // con.close();

        return result;
    }

    public int updateSchedule(Schedule schedule) throws Exception {

        String sql = "UPDATE schedule SET session_date = ?, session_time = ?, duration_minutes = ? WHERE scheduleId = ?";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDate(1, schedule.getSessionDate());
        ps.setTime(2, schedule.getSessionTime());
        ps.setInt(3, schedule.getDurationMinutes());
        ps.setInt(4, schedule.getScheduleId());

        int result = ps.executeUpdate();

        //ps.close();
        //con.close();

        return result;
    }

    public Schedule getScheduleById(int scheduleId) throws Exception {

        String sql = "SELECT * FROM schedule WHERE scheduleId = ?";

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, scheduleId);

        ResultSet rs = ps.executeQuery();

        Schedule schedule = null;

        if (rs.next()) {
            schedule = convertResultSetToSchedule(rs);
        }

        rs.close();
        //ps.close();
        //con.close();

        return schedule;
    }

    public List<Schedule> getSchedulesByMemberId(int memberId) throws Exception {

        String sql = "SELECT * FROM schedule WHERE memberId = ?";

        List<Schedule> scheduleList = new ArrayList<Schedule>();

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, memberId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Schedule schedule = convertResultSetToSchedule(rs);
            scheduleList.add(schedule);
        }

        rs.close();
       

        return scheduleList;
    }

    public List<Schedule> getSchedulesByTrainerId(int trainerId) throws Exception {

        String sql = "SELECT * FROM schedule WHERE trainerId = ?";

        List<Schedule> scheduleList = new ArrayList<Schedule>();

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, trainerId);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Schedule schedule = convertResultSetToSchedule(rs);
            scheduleList.add(schedule);
        }

        rs.close();
        

        return scheduleList;
    }

    public List<Schedule> getAllSchedules() throws Exception {

        String sql = "SELECT * FROM schedule";

        List<Schedule> scheduleList = new ArrayList<Schedule>();

        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Schedule schedule = convertResultSetToSchedule(rs);
            scheduleList.add(schedule);
        }

        //rs.close();
        //ps.close();
        //con.close();

        return scheduleList;
    }

    private Schedule convertResultSetToSchedule(ResultSet rs) throws Exception {

        Schedule schedule = new Schedule();

        schedule.setScheduleId(rs.getInt("scheduleId"));
        schedule.setMemberId(rs.getInt("memberId"));
        schedule.setTrainerId(rs.getInt("trainerId"));
        schedule.setSessionDate(rs.getDate("session_date"));
        schedule.setSessionTime(rs.getTime("session_time"));
        schedule.setDurationMinutes(rs.getInt("duration_minutes"));

        return schedule;
    }
}
