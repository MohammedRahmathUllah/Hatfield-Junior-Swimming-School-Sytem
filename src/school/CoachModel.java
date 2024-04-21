package school;
import java.util.ArrayList;
import java.util.List;

public class CoachModel {
    private String name;
    private List<ReviewModel> reviewModels;

    // Constructor
    public CoachModel(String name) {
        this.name = name;
        this.reviewModels = new ArrayList<>();
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for reviews
    public List<ReviewModel> getReviews() {
        return reviewModels;
    }

    // Add a review
    public void addReview(ReviewModel reviewModel) {
        if (reviewModel != null) {
            reviewModels.add(reviewModel);
        }
    }

    // Method to calculate average rating
    public double calculateAverageRating() {
        if (reviewModels.isEmpty()) {
            return 0.0; // Return 0 if there are no reviews
        }

        double total = 0;
        for (ReviewModel reviewModel : reviewModels) {
            total += reviewModel.getRating();
        }
        return total / reviewModels.size();
    }
}
