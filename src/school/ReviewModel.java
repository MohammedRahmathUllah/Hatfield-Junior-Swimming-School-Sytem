package school;
public class ReviewModel {
    private LearnerModel learnerModel;
    private LessonModel lessonModel;
    private int rating;
    private String comments;

    public LearnerModel getLearner() {
        return learnerModel;
    }

    public void setLearner(LearnerModel learnerModel) {
        this.learnerModel = learnerModel;
    }

    public LessonModel getLesson() {
        return lessonModel;
    }

    public void setLesson(LessonModel lessonModel) {
        this.lessonModel = lessonModel;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    // Constructor, getters, and setters
}
