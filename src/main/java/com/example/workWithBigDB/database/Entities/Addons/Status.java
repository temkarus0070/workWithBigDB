package com.example.workWithBigDB.database.Entities.Addons;

public enum Status {

    Scheduled("Scheduled"),
    OnTime("On Time"),
    Delayed("Delayed"),
    Departed("Departed"),
    Arrived("Arrived"),
    Cancelled("Cancelled");

    private final String text;

    /**
     * @param text
     */
    Status(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
