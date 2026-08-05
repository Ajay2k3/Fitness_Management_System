package com.service;

import java.time.LocalDate;
import java.util.List;

import com.dao.BillingDAO;
import com.model.Billing;

public class BillingService {

    BillingDAO dao = new BillingDAO();

    public boolean generateBill(
            int memberId,
            int packageId,double amount,
            double payamt,double balanceamt,
            String status) {

        Billing bill = new Billing();

      

        if (amount == 0) {

            System.out.println("Invalid Package ID");
            return false;
        }

        bill.setMemberId(memberId);

        bill.setPackageId(packageId);

        bill.setAmount(amount);

        bill.setPaidAmount(payamt);

        bill.setBalanceAmount(balanceamt);

        bill.setBillingStatus(status);

        bill.setBillingDate(LocalDate.now());

        return dao.generateBill(bill);
    }

    public boolean updateBill(
            int billId,
            double payAmount) {

        return dao.updateBill(
                billId,
                payAmount);
    }

    public Billing viewBillById(int billId) {

        return dao.viewBillById(billId);
    }

    public List<Billing> viewBillsByMemberId(int memberId) {
        return dao.viewBillsByMemberId(memberId);
    }

	public List<Billing> viewAllBills() {
		// TODO Auto-generated method stub
		return dao.viewAllBills();
	}
}