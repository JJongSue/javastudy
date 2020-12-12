package main.java.JUnit;

import JUnit.StudyStatus;

public class Study {
//    private StudyStatus status;
    private StudyStatus status = StudyStatus.DRAFT;
    public StudyStatus getStatus() {
        return this.status;
    }

    public Study() {
    }
}
