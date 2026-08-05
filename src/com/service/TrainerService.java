package com.service;

import com.dao.TrainerDAO;
import com.model.Trainer;

public class TrainerService {

    TrainerDAO dao = new TrainerDAO();

    public boolean addTrainer(Trainer trainer) {

        if (trainer.getContact().length() != 10) {

            System.out.println("Invalid Contact Number");

            return false;
        }

        if (!trainer.getEmail().contains("@")) {

            System.out.println("Invalid Email");

            return false;
        }

        return dao.addTrainer(trainer);
    }

    public boolean updateTrainerName(int trainerId, String name) {

        return dao.updateTrainerName(trainerId, name);
    }

    public boolean updateTrainerSpecialization(int trainerId,
                                               String specialization) {

        return dao.updateTrainerSpecialization(trainerId,
                                               specialization);
    }

    public boolean updateTrainerContact(int trainerId,
                                        String contact) {

        return dao.updateTrainerContact(trainerId,
                                        contact);
    }

    public boolean updateTrainerEmail(int trainerId,
                                      String email) {

        return dao.updateTrainerEmail(trainerId,
                                      email);
    }

    public boolean updateTrainerStatus(int trainerId,
                                       boolean isActive) {

        return dao.updateTrainerStatus(trainerId,
                                       isActive);
    }

    public boolean deactivateTrainer(int id) {

        return dao.deactivateTrainer(id);
    }

    public void viewTrainerById(int id) {

        dao.viewTrainerById(id);
    }

    public void viewAllTrainers() {

        dao.viewAllTrainers();
    }
}