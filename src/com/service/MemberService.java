package com.service;

import com.dao.MemberDAO;
import com.model.Member;
//
//
//public class MemberService {
//
//    MemberDAO dao = new MemberDAO();
//
//    public void addMember(Member m) {
//        dao.addMember(m);
//    }
//
//    public void updateMember(Member m) {
//        dao.updateMember(m);
//    }
//
//    public void deactivateMember(int id) {
//        dao.deactivateMember(id);
//    }
//
//    public void viewMemberById(int id) {
//        dao.viewMemberById(id);
//    }
//
//    public void viewAllMembers() {
//        dao.viewAllMembers();
//    }
//}

public class MemberService {

    MemberDAO dao = new MemberDAO();

    // ================= VALIDATION =================

    public boolean validateContact(String contact) {

        if (contact == null || contact.trim().isEmpty()) {
            System.out.println("Contact cannot be empty");
            return false;
        }

        if (!contact.matches("^[6789][0-9]{9}$")) {
            System.out.println("Invalid Contact Number");
            return false;
        }

        return true;
    }

    public boolean validateEmail(String email) {

        if (email == null || !email.contains("@")) {
            System.out.println("Invalid Email");
            return false;
        }

        return true;
    }

    // ================= ADD MEMBER =================

    public boolean addMember(Member m) {

        if (!validateContact(m.getContact())) {
            return false;
        }

        if (!validateEmail(m.getEmail())) {
            return false;
        }

        dao.addMember(m);
        return true;
    }

    // ================= UPDATE =================

    public boolean updateMemberContact(int memberId, String contact) {

        if (!validateContact(contact)) {
            return false;
        }

        dao.updateMemberContact(memberId, contact);
        return true;
    }

    public boolean updateMemberEmail(int memberId, String email) {

        if (!validateEmail(email)) {
            return false;
        }

        dao.updateMemberEmail(memberId, email);
        return true;
    }

    // ================= OTHER METHODS =================

    public void deactivateMember(int memberId) {
        dao.deactivateMember(memberId);
    }

    public void viewMemberById(int memberId) {
        dao.viewMemberById(memberId);
    }

    public void viewAllMembers() {
        dao.viewAllMembers();
    }

    public void updateMemberName(int memberId, String name) {
        dao.updateMemberName(memberId, name);
    }

    public void updateMemberAddress(int memberId, String address) {
        dao.updateMemberAddress(memberId, address);
    }
}
