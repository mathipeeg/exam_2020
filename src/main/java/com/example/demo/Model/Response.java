package com.example.demo.Model;

import java.util.List;

public class Response {
    List<Student> result;
    List<Supervisor> supervisor;
    List<Supervisor> supervisorsList;

    public List<Student> getResult() {
        return result;
    }

    public List<Supervisor> getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(List<Supervisor> supervisor) {
        this.supervisor = supervisor;
    }

    public List<Supervisor> getSupervisorsList() {
        return supervisorsList;
    }

    public void setSupervisorsList(List<Supervisor> supervisorsList) {
        this.supervisorsList = supervisorsList;
    }

    public void setResult(List<Student> result) {
        this.result = result;
    }
}
