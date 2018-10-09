package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private long id;
    private long projectID;
    private long userID;
    private LocalDate date;
    private int hours;

    public TimeEntry(long projectID, long userID, LocalDate localDate, int hours) {

        this.projectID = projectID;
        this.userID = userID;
        this.date = localDate;
        this.hours = hours;
    }

    public TimeEntry(long id, long projectID, long userID, LocalDate localDate, int hours) {
        this.id = id;
        this.projectID = projectID;
        this.userID = userID;
        this.date = localDate;
        this.hours = hours;
    }

    public TimeEntry() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectID() {
        return projectID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "[" + this.id + "," + this.projectID + "," + this.userID + "," + this.date + "," + this.hours + "]";
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof TimeEntry)) {
            return false;
        }
        TimeEntry timeEntry = (TimeEntry) o;
        return this.id == timeEntry.getId()
                && this.projectID == timeEntry.projectID
                && this.userID == timeEntry.userID
                && Objects.equals(this.date, timeEntry.date)
                && this.hours == timeEntry.hours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectID, userID, date, hours);
    }
}