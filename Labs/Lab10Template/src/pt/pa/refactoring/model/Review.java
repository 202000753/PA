package pt.pa.refactoring.model;

import java.time.LocalDateTime;

/**
 * @author amfs
 */
public class Review {

    private String reviewer;
    private String text;
    private double rating;

    private LocalDateTime date;
    //private int day, month, year, hour, minute;

    public Review(String reviewer, String text, double rating) {
        this.reviewer = reviewer;
        this.text = text;
        this.rating = rating;


        date = LocalDateTime.now();

        /*this.day = date.getDayOfMonth();
        this.month = date.getMonthValue();
        this.year = date.getYear();
        this.hour = date.getHour();
        this.minute = date.getMinute();*/
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDay() {
        return date.getDayOfMonth();
    }

    public int getMonth() {
        return date.getMonthValue();
    }

    public int getYear() {
        return date.getYear();
    }

    public int getHour() {
        return date.getHour();
    }

    public int getMinute() {
        return date.getMinute();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Date: %d/%d/%d @ %d:%d ", this.date.getDayOfMonth(), this.date.getMonthValue(), this.date.getYear(), this.date.getHour(), this.date.getMinute()))
                .append(String.format("Reviewer: %s ", this.getReviewer()))
                .append(String.format("Rating: %.1f ", this.getRating()))
                .append(String.format("Comment: %s", this.getText()));

        return sb.toString();
    }
}
