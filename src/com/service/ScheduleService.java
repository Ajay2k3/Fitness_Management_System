package com.service;

import com.dao.ScheduleDAO;
import com.exception.TrainerNotAvailableException;
import com.model.Schedule;

import java.util.List;

public class ScheduleService {

    private ScheduleDAO scheduleDAO = new ScheduleDAO();

    public boolean addSchedule(Schedule schedule) throws Exception {

        validateAddSchedule(schedule);

        boolean trainerBooked = scheduleDAO.isTrainerBooked(
                schedule.getTrainerId(),
                schedule.getSessionDate(),
                schedule.getSessionTime()
        );

        if (trainerBooked) {
            throw new TrainerNotAvailableException("Trainer already booked for this date and time.");
        }

        int result = scheduleDAO.addSchedule(schedule);

        return result > 0;
    }

    public boolean updateSchedule(Schedule schedule) throws Exception {

        validateUpdateSchedule(schedule);

        int result = scheduleDAO.updateSchedule(schedule);

        return result > 0;
    }

    public Schedule getScheduleById(int scheduleId) throws Exception {

        if (scheduleId <= 0) {
            throw new IllegalArgumentException("Invalid schedule ID.");
        }

        return scheduleDAO.getScheduleById(scheduleId);
    }

    public List<Schedule> getSchedulesByMemberId(int memberId) throws Exception {

        if (memberId <= 0) {
            throw new IllegalArgumentException("Invalid member ID.");
        }

        return scheduleDAO.getSchedulesByMemberId(memberId);
    }

    public List<Schedule> getSchedulesByTrainerId(int trainerId) throws Exception {

        if (trainerId <= 0) {
            throw new IllegalArgumentException("Invalid trainer ID.");
        }

        return scheduleDAO.getSchedulesByTrainerId(trainerId);
    }

    public List<Schedule> getAllSchedules() throws Exception {
        return scheduleDAO.getAllSchedules();
    }

    private void validateAddSchedule(Schedule schedule) {

        if (schedule == null) {
            throw new IllegalArgumentException("Schedule object cannot be null.");
        }

        if (schedule.getMemberId() <= 0) {
            throw new IllegalArgumentException("Member ID is required.");
        }

        if (schedule.getTrainerId() <= 0) {
            throw new IllegalArgumentException("Trainer ID is required.");
        }

        if (schedule.getSessionDate() == null) {
            throw new IllegalArgumentException("Session date is required.");
        }

        if (schedule.getSessionTime() == null) {
            throw new IllegalArgumentException("Session time is required.");
        }

        if (schedule.getDurationMinutes() <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0.");
        }
    }

    private void validateUpdateSchedule(Schedule schedule) {

        if (schedule == null) {
            throw new IllegalArgumentException("Schedule object cannot be null.");
        }

        if (schedule.getScheduleId() <= 0) {
            throw new IllegalArgumentException("Invalid schedule ID.");
        }

        if (schedule.getSessionDate() == null) {
            throw new IllegalArgumentException("Session date is required.");
        }

        if (schedule.getSessionTime() == null) {
            throw new IllegalArgumentException("Session time is required.");
        }

        if (schedule.getDurationMinutes() <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0.");
        }
    }
}