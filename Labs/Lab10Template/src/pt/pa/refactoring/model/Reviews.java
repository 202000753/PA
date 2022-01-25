package pt.pa.refactoring.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author amfs
 */
public class Reviews implements Iterable {
    List<Review> reviewList;

    public Reviews() {
        this.reviewList = new ArrayList<>();
    }

    public int getTotal() {
        int total = 0;

        for (Review r : this.reviewList) {
            total += 1;
        }

        return total;
    }

    public double getAvgRating() {
        double sum = 0.0;

        for (Review r : this.reviewList) {
            sum += r.getRating();
        }

        double avgRating = (sum / getTotal());

        return avgRating;
    }

    @Override
    public Iterator iterator() {
        return reviewList.iterator();
    }

    public void add(Review review) {
        reviewList.add(review);
    }

    public List<Review> getReviewList() {
        return reviewList;
    }
}
