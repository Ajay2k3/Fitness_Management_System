package com.service;


import com.dao.PackageDAO;
import com.model.Package;

public class PackageService {

    PackageDAO dao = new PackageDAO();

    public boolean addPackage(Package p) {
    	if(!p.getPlanIds().contains(":")) {
    		return false;
    	}

        return dao.addPackage(p);
    }


    public boolean updatePackageName(int packageId, String name) {
        return dao.updatePackageName(packageId, name);
    }

    public boolean updatePackagePrice(int packageId, double price) {
        return dao.updatePackagePrice(packageId, price);
    }

    public boolean updatePackagePlanIds(int packageId, String planIds) {
        return dao.updatePackagePlanIds(packageId, planIds);
    }


    public void viewPackageById(int id) {

        dao.viewPackageById(id);
    }

    public void viewAllPackages() {
        dao.viewAllPackages();
    }
}