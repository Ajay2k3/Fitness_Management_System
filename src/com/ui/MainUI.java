package com.ui;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import com.dao.PackageDAO;
import com.dao.PlanDAO;
import com.model.Billing;
import com.model.Member;
import com.model.Plan;
import com.model.Package;
import com.model.Schedule;
import com.model.Trainer;
import com.service.BillingService;
import com.service.MemberService;
import com.service.PackageService;
import com.service.PlanService;
import com.service.ScheduleService;
import com.service.TrainerService;

public class MainUI {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			MemberService service = new MemberService();
			TrainerService trainerservice = new TrainerService();
			PlanService planService = new PlanService();
			PackageService packageService = new PackageService();
			ScheduleService scheduleService = new ScheduleService();
			BillingService billingService = new BillingService();

			int choice, outchoice;

			do {
				System.out.print("\n=============================================");
				System.out.print("\n\t\tFitness Hub");
				System.out.println("\n=============================================\n");
				System.out.println("1.Member Details");
				System.out.println("2.Trainer Details");
				System.out.println("3.Plan Details");
				System.out.println("4.package Details");
				System.out.println("5.schedule Details");
				System.out.println("6.billing ");
				System.out.println("0.Exit");
				System.out.print("Enter Choice : ");
				outchoice = sc.nextInt();
				switch (outchoice) {
				case 1:
					do {
						System.out.println("\n__________________________________________");

						System.out.println("\n\t\tMEMBER MANAGEMENT       ");
						System.out.println("__________________________________________");

						System.out.println("1. Add Member");
						System.out.println("2. Update Member");
						System.out.println("3. Deactivate Member");
						System.out.println("4. View Member By ID");
						System.out.println("5. View All Members");
						System.out.println("6. Exit");

						System.out.print("Enter Choice : ");
						choice = sc.nextInt();

						switch (choice) {

						case 1:

							Member m1 = new Member();

							sc.nextLine();

							System.out.print("Enter Name : ");
							m1.setName(sc.nextLine());

							System.out.print("Enter Contact : ");
							m1.setContact(sc.nextLine());

							System.out.print("Enter Email : ");
							m1.setEmail(sc.nextLine());

							System.out.print("Enter Address : ");
							m1.setAddress(sc.nextLine());

							m1.setDate_joined(new Date(System.currentTimeMillis()));

							m1.setIsActive(true);

							if(!service.addMember(m1)) {
								System.out.println("Failed to add Member");
							}
					
							break;


						case 2:

							int updateChoice;
							Member member=new Member();
							System.out.println("------ Update Member Details ------");
							System.out.println("1. Update Name");
							System.out.println("2. Update Contact");
							System.out.println("3. Update Email");
							System.out.println("4. Update Address");

							System.out.print("Enter Choice : ");
							updateChoice = sc.nextInt();

							System.out.print("Enter Member ID : ");
							int memberId = sc.nextInt();

							sc.nextLine();

							switch (updateChoice) {
							case 1:

								System.out.print("Enter New Name : ");
								String newName = sc.nextLine();

								service.updateMemberName(memberId, newName);

								break;

							case 2:
								
								System.out.print("Enter New Contact : ");
								String newContact = sc.nextLine();
								member.setContact(newContact);
								if(service.updateMemberContact(memberId, newContact)) {
									System.out.println("Invalid Contact number");
								}

								break;

							case 3:

								System.out.print("Enter New Email : ");
								String newEmail = sc.nextLine();
								member.setEmail(newEmail);
								if(service.updateMemberEmail(memberId, newEmail)) {
									System.out.println("Invalid Email ");
								}

								break;

							case 4:

								System.out.print("Enter New Address : ");
								String newAddress = sc.nextLine();

								service.updateMemberAddress(memberId, newAddress);

								break;

							default:

								System.out.println("Invalid Choice");
							}

							break;

						case 3:

							System.out.print("Enter Member ID : ");

							int id = sc.nextInt();

							service.deactivateMember(id);

							break;

						case 4:

							System.out.print("Enter Member ID : ");

							int mid = sc.nextInt();

							service.viewMemberById(mid);

							break;

						case 5:

							service.viewAllMembers();

							break;

						case 6:

							System.out.println("Thank You");

							break;

						default:

							System.out.println("Invalid Choice");
						}
					} while (choice != 6);
					break;
				case 2:
					do {
						System.out.println("\n_________________________________________");
						System.out.println("\n\t\tTRAINER MANAGEMENT SYSTEM ");
						System.out.println("__________________________________________");
						System.out.println("1. Add Trainer");
						System.out.println("2. Update Trainer");
						System.out.println("3. Deactivate Trainer");
						System.out.println("4. View Trainer By ID");
						System.out.println("5. View All Trainers");
						System.out.println("6. Exit");
						System.out.print("Enter Choice : ");
						choice = sc.nextInt();
						sc.nextLine();
						switch (choice) {
						case 1:
							System.out.print("Enter Trainer Name : ");
							String name = sc.nextLine();
							System.out.print("Enter Specialization : ");
							String specialization = sc.nextLine();
							System.out.print("Enter Contact : ");
							String contact = sc.nextLine();
							System.out.print("Enter Email : ");
							String email = sc.nextLine();
							boolean isActive = true;
							Trainer trainer = new Trainer(name, specialization, contact, email, isActive);
							if (trainerservice.addTrainer(trainer)) {
								System.out.println("Trainer Added Successfully");
							} else {
								System.out.println("Failed to Add Trainer");
							}
							break;
						case 2:

						    int inchoice;
						    System.out.println("---------------------------------------------------");

						    System.out.println("\t\tUpdate Trainer ");
						    System.out.println("---------------------------------------------------");

						    System.out.println("1. Update Name");
						    System.out.println("2. Update Specialization");
						    System.out.println("3. Update Contact");
						    System.out.println("4. Update Email");
						    System.out.println("5. Update Status");

						    System.out.print("Enter Choice : ");
						    inchoice = sc.nextInt();

						    System.out.print("Enter Trainer ID : ");
						    int trainerId = sc.nextInt();

						    sc.nextLine();

						    switch(inchoice) {

						        case 1:

						            System.out.print("Enter New Name : ");
						            String tname = sc.nextLine();

						            if(trainerservice.updateTrainerName(trainerId, tname)) {

						                System.out.println("Name Updated Successfully");

						            } else {

						                System.out.println("Update Failed");
						            }

						            break;

						        case 2:

						            System.out.print("Enter New Specialization : ");
						            String tspecialization = sc.nextLine();

						            if(trainerservice.updateTrainerSpecialization(trainerId,
						                                                   tspecialization)) {

						                System.out.println("Specialization Updated Successfully");

						            } else {

						                System.out.println("Update Failed");
						            }

						            break;

						        case 3:

						            System.out.print("Enter New Contact : ");
						            String tcontact = sc.nextLine();

						            if(trainerservice.updateTrainerContact(trainerId,
						                                            tcontact)) {

						                System.out.println("Contact Updated Successfully");

						            } else {

						                System.out.println("Update Failed");
						            }

						            break;

						        case 4:

						            System.out.print("Enter New Email : ");
						            String temail = sc.nextLine();

						            if(trainerservice.updateTrainerEmail(trainerId,
						                                          temail)) {

						                System.out.println("Email Updated Successfully");

						            } else {

						                System.out.println("Update Failed");
						            }

						            break;

						        case 5:

						            System.out.print("Enter Status (true/false) : ");
						            boolean status = sc.nextBoolean();

						            if(trainerservice.updateTrainerStatus(trainerId,
						                                           status)) {

						                System.out.println("Status Updated Successfully");

						            } else {

						                System.out.println("Update Failed");
						            }

						            break;

						        default:

						            System.out.println("Invalid Choice");
						    }

						    break;
						case 3:
							System.out.print("Enter Trainer ID : ");
							int deactivateId = sc.nextInt();
							if (trainerservice.deactivateTrainer(deactivateId)) {
								System.out.println("Trainer Deactivated");
							} else {
								System.out.println("Operation Failed");
							}
							break;
						case 4:
							System.out.print("Enter Trainer ID : ");
							int searchId = sc.nextInt();
							trainerservice.viewTrainerById(searchId);
							break;
						case 5:
							trainerservice.viewAllTrainers();
							break;
						case 6:
							System.out.println("Thank You");
							break;
						default:
							System.out.println("Invalid Choice");
						}
					} while (choice != 6);
					break;
				case 3:
					do {
						System.out.println("\n__________________________________________");

						System.out.println("\n\t\tFITNESS CLUB PLAN         ");
						System.out.println("__________________________________________");

						System.out.println("1. Add Plan");
						System.out.println("2. Update Plan");
						System.out.println("3. View Plan By Id");
						System.out.println("4. View All Plans");
						System.out.println("6. Exit");

						System.out.println("Enter Choice : ");

						choice = sc.nextInt();

						switch (choice) {

						// ADD PLAN

						case 1:

							Plan plan = new Plan();

							sc.nextLine();

							System.out.println("Enter Plan Name : ");
							plan.setName(sc.nextLine());

							System.out.println("Enter Description : ");
							plan.setDescription(sc.nextLine());

							System.out.println("Enter Duration Weeks : ");
							plan.setDurationWeeks(sc.nextInt());

							boolean addPlanResult = planService.addPlan(plan);

							if (addPlanResult) {

								System.out.println("Plan Added Successfully");
							} else {

								System.out.println("Plan Not Added");
							}

							break;

						// UPDATE PLAN

						case 2:

							int updateChoice;

							System.out.println("------ Update Plan ------");
							System.out.println("1. Update Name");
							System.out.println("2. Update Description");
							System.out.println("3. Update Duration");

							System.out.print("Enter Choice : ");
							updateChoice = sc.nextInt();

							System.out.print("Enter Plan ID : ");
							int pid = sc.nextInt();

							sc.nextLine();

							switch (updateChoice) {

							case 1:

								System.out.print("Enter New Name : ");
								String name = sc.nextLine();

								if (planService.updatePlanName(pid, name)) {
									System.out.println("Name Updated Successfully");
								} else {
									System.out.println("Update Failed");
								}

								break;

							case 2:

								System.out.print("Enter New Description : ");
								String desc = sc.nextLine();

								if (planService.updatePlanDescription(pid, desc)) {
									System.out.println("Description Updated Successfully");
								} else {
									System.out.println("Update Failed");
								}

								break;

							case 3:

								System.out.print("Enter New Duration Weeks : ");
								int weeks = sc.nextInt();

								if (planService.updatePlanDuration(pid, weeks)) {
									System.out.println("Duration Updated Successfully");
								} else {
									System.out.println("Update Failed");
								}

								break;

							default:
								System.out.println("Invalid Choice");
							}

							break;

						// VIEW PLAN BY ID

						case 3:

							System.out.println("Enter Plan Id : ");

							int planId = sc.nextInt();

							planService.viewPlanById(planId);

							break;

						// VIEW ALL PLANS

						case 4:

							planService.viewAllPlans();

							break;
						case 0:
							System.out.println("Thank You");
							break;

						default:

							System.out.println("Invalid Choice");
						}
					} while (choice != 6);
					break;
				case 4:
					do {
						System.out.println("\n__________________________________________");

						System.out.println("\n\t\tFITNESS CLUB PACKAGE         ");
						System.out.println("__________________________________________");

						System.out.println("1. Add Package");
						System.out.println("2. Update Package");
						System.out.println("3. View Package By Id");
						System.out.println("4. View All Packages");
						System.out.println("5. Exit");

						System.out.println("Enter Choice : ");
						choice = sc.nextInt();
						switch (choice) {
						case 1:

							Package p = new Package();

							sc.nextLine();

							System.out.println("Enter Package Name : ");
							p.setName(sc.nextLine());

							PlanDAO plandao = new PlanDAO();

							plandao.allAvailablePlan();
							System.out.println("Enter Plan Ids (comma separated) : ");
							p.setPlanIds(sc.nextLine());
							System.out.println("Enter Price : ");
							p.setPrice(sc.nextDouble());
							sc.nextLine();

							boolean addPackageResult = packageService.addPackage(p);

							if (addPackageResult) {

								System.out.println("Package Added Successfully");
							} else {

								System.out.println("Package Not Added");
							}

							break;

						// UPDATE PACKAGE

						case 2:

						    int inchoice;

						    System.out.println("------ Update Package ------");

						    System.out.println("1. Update Name");
						    System.out.println("2. Update Price");
						    System.out.println("3. Update PlanIds");

						    System.out.print("Enter Choice : ");
						    inchoice = sc.nextInt();

						    System.out.print("Enter Package ID : ");
						    int updatepackageId = sc.nextInt();

						    sc.nextLine();

						    switch(inchoice) {

						        case 1:

						            System.out.print("Enter New Name : ");
						            String name = sc.nextLine();

						            if(packageService.updatePackageName(updatepackageId, name)) {
						                System.out.println("Name Updated Successfully");
						            } else {
						                System.out.println("Update Failed");
						            }

						            break;

						        case 2:

						            System.out.print("Enter New Price : ");
						            double price = sc.nextDouble();

						            if(packageService.updatePackagePrice(updatepackageId, price)) {
						                System.out.println("Price Updated Successfully");
						            } else {
						                System.out.println("Update Failed");
						            }

						            break;

						        case 3:

						            System.out.print("Enter New PlanIds : ");
						            String planIds = sc.nextLine();

						            if(packageService.updatePackagePlanIds(updatepackageId, planIds)) {
						                System.out.println("PlanIds Updated Successfully");
						            } else {
						                System.out.println("Update Failed");
						            }

						            break;

						        default:
						            System.out.println("Invalid Choice");
						    }

						    break;

						case 3:

							System.out.println("Enter Package Id : ");

							int packageId = sc.nextInt();

							packageService.viewPackageById(packageId);

							break;
						case 4:
							packageService.viewAllPackages();
							break;
						case 5:
							System.out.println("Thank You");
							break;
						default:
							System.out.println("Invalid choice");
						}
					} while (choice != 5);
					break;
				case 5:
					do {
						System.out.println("\n__________________________________________");

						System.out.println("\n\t\tSchedule Management        ");
						System.out.println("__________________________________________");

						System.out.println("1. Add Schedule");
						System.out.println("2. Update Schedule");
						System.out.println("3. View Schedule By ID");
						System.out.println("4. View Schedules By Member ID");
						System.out.println("5. View Schedules By Trainer ID");
						System.out.println("6. View All Schedules");
						System.out.println("7. Exit");
						System.out.print("Enter your choice: ");

						choice = sc.nextInt();

						try {

							switch (choice) {

							case 1:
								System.out.print("Enter Member ID: ");
								int memberId = sc.nextInt();

								System.out.print("Enter Trainer ID: ");
								int trainerId = sc.nextInt();

								System.out.print("Enter Session Date yyyy-mm-dd: ");
								String dateInput = sc.next();

								System.out.print("Enter Session Time hh:mm:ss: ");
								String timeInput = sc.next();

								System.out.print("Enter Duration Minutes: ");
								int duration = sc.nextInt();

								Date sessionDate = Date.valueOf(dateInput);
								Time sessionTime = Time.valueOf(timeInput);

								Schedule schedule = new Schedule(memberId, trainerId, sessionDate, sessionTime,
										duration);

								boolean added = scheduleService.addSchedule(schedule);

								if (added) {
									System.out.println("Schedule added successfully.");
								} else {
									System.out.println("Schedule not added.");
								}
								break;

							case 2:
								System.out.print("Enter Schedule ID: ");
								int scheduleId = sc.nextInt();

								System.out.print("Enter New Session Date yyyy-mm-dd: ");
								String newDateInput = sc.next();

								System.out.print("Enter New Session Time hh:mm:ss: ");
								String newTimeInput = sc.next();

								System.out.print("Enter New Duration Minutes: ");
								int newDuration = sc.nextInt();

								Date newSessionDate = Date.valueOf(newDateInput);
								Time newSessionTime = Time.valueOf(newTimeInput);

								Schedule updateSchedule = new Schedule();
								updateSchedule.setScheduleId(scheduleId);
								updateSchedule.setSessionDate(newSessionDate);
								updateSchedule.setSessionTime(newSessionTime);
								updateSchedule.setDurationMinutes(newDuration);

								boolean updated = scheduleService.updateSchedule(updateSchedule);

								if (updated) {
									System.out.println("Schedule updated successfully.");
								} else {
									System.out.println("Schedule not updated. Check Schedule ID.");
								}
								break;

							case 3:
								System.out.print("Enter Schedule ID: ");
								int searchScheduleId = sc.nextInt();

								Schedule foundSchedule = scheduleService.getScheduleById(searchScheduleId);

								if (foundSchedule != null) {
									System.out.println(foundSchedule);
								} else {
									System.out.println("Schedule not found.");
								}
								break;

							case 4:
								System.out.print("Enter Member ID: ");
								int searchMemberId = sc.nextInt();

								List<Schedule> memberSchedules = scheduleService.getSchedulesByMemberId(searchMemberId);

								if (memberSchedules.isEmpty()) {
									System.out.println("No schedules found for this member.");
								} else {
									System.out.println(
											"================================================================================================================");

									for (Schedule s : memberSchedules) {
										System.out.println(s);
										System.out.println(
												"================================================================================================================");

									}
								}
								break;

							case 5:
								System.out.print("Enter Trainer ID: ");
								int searchTrainerId = sc.nextInt();

								List<Schedule> trainerSchedules = scheduleService
										.getSchedulesByTrainerId(searchTrainerId);

								if (trainerSchedules.isEmpty()) {
									System.out.println("No schedules found for this trainer.");
								} else {
									System.out.println(
										"================================================================================================================");

									for (Schedule s : trainerSchedules) {
										System.out.println(s);
									}
									System.out.println(
											"================================================================================================================");

								}
								break;

							case 6:
								List<Schedule> allSchedules = scheduleService.getAllSchedules();

								if (allSchedules.isEmpty()) {
									System.out.println("No schedules available.");
								} else {
									System.out.println(
											"================================================================================================================");

									for (Schedule s : allSchedules) {
										System.out.println(s);
									}
									System.out.println(
											"================================================================================================================");

								}
								break;

							case 7:
								System.out.println("Thank you.");
								
								break;

							default:
								System.out.println("Invalid choice.");
							}

						} catch (Exception e) {
							System.out.println("Error: " + e.getMessage());
						}
					} while (choice != 7);
					break;
				case 6:
					do {
						System.out.println("\n__________________________________________");

						System.out.println("\n\t\tBilling Management ");
						System.out.println("__________________________________________");

						System.out.println("1. Generate Bill");
						System.out.println("2. Update Bill");
						System.out.println("3. View Bill By ID");
						System.out.println("4. View Bills By Member ID");
						System.out.println("5. View All Bills");
						System.out.println("6. Exit");
						System.out.println("Enter your choice:");

						choice = sc.nextInt();

						switch (choice) {

						case 1:
							try {
								PackageDAO pd = new PackageDAO();

								System.out.println("Enter Member ID:");
								int memberId = sc.nextInt();
								System.out.println("Enter Package ID:");
								int packageId = sc.nextInt();
								double amount = pd.amountForPackage(packageId);
								if (amount < 0) {
									break;
								}
								System.out.println("The Package amount is : " + amount);
								System.out.println("Enter the amount payed : ");
								double payamt = sc.nextDouble();
								double balanceamt;
								balanceamt = amount - payamt;
								System.out.println("Balance Amount : " + balanceamt);
								String status = "";
								if (balanceamt == 0) {
									status = "Paid";
								} else if (balanceamt > 0 && balanceamt < amount) {
									status = "Pending";
								} else if (balanceamt == amount) {
									status = "Unpaid";
								} else {
									System.out.println("Invalid amount details");
									break;
								}
								System.out.println("Payment Status : " + status);

								if (billingService.generateBill(memberId, packageId, amount, payamt, balanceamt,
										status)) {
									System.out.println("Bill generated successfully");
								} else {
									System.out.println("Bill not generated");
								}
								break;
							} catch (Exception e) {
								System.out.println("Error");
							}

						case 2:

							System.out.println("Enter Bill ID:");
							int billId = sc.nextInt();

							System.out.println("Enter Paying Amount:");
							double payAmount = sc.nextDouble();

							if (billingService.updateBill(billId, payAmount)) {

								System.out.println("Bill updated successfully");

							} else {

								System.out.println("Bill not updated");
							}

							break;

						case 3:

							System.out.println("Enter Bill ID:");
							int id = sc.nextInt();

							Billing bill = billingService.viewBillById(id);

							if (bill != null) {
								System.out.println(
										"\n================================================================================================================\n");
								System.out.println(bill);
								System.out.println(
										"================================================================================================================");

							} else {
								System.out.println("Bill not found");
							}
							break;

						case 4:

							System.out.println("Enter Member ID:");
							int mId = sc.nextInt();

							List<Billing> memberBills = billingService.viewBillsByMemberId(mId);

							if (memberBills.isEmpty()) {
								System.out.println("No bills found");
							} else {
								for (Billing b : memberBills) {
									System.out.println("================================================================================================================");

									System.out.println(b);
									System.out.println("================================================================================================================");

								}
							}
							break;

						case 5:
							List<Billing> bills = billingService.viewAllBills();
							if (bills.isEmpty()) {
								System.out.println("No bills found");
							} else {
								for (Billing b : bills) {
									System.out.println(
											"================================================================================================================");

									System.out.println(b);
									System.out.println(
											"================================================================================================================\n");

								}
							}
							break;
						case 6:
							System.out.println("Exit Billing Menu");
							break;
						default:
							System.out.println("Invalid choice");
						}

					} while (choice != 6);
					break;
				}
			} while (outchoice != 0);
			System.out.println("You are welcome again");

		}
	}
}
