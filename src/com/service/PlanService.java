package com.service;

import com.dao.PlanDAO;
import com.model.Plan;

public class PlanService {

	PlanDAO dao = new PlanDAO();

	// ADD PLAN

	public boolean addPlan(Plan plan) {

		return dao.addPlan(plan);
	}

	public boolean updatePlanName(int planId, String name) {
		return dao.updatePlanName(planId, name);
	}

	public boolean updatePlanDescription(int planId, String description) {
		return dao.updatePlanDescription(planId, description);
	}

	public boolean updatePlanDuration(int planId, int durationWeeks) {
		return dao.updatePlanDuration(planId, durationWeeks);
	}

	// VIEW PLAN BY ID

	public void viewPlanById(int id) {

		dao.viewPlanById(id);
	}

	// VIEW ALL PLANS

	public void viewAllPlans() {

		dao.viewAllPlans();
	}
}