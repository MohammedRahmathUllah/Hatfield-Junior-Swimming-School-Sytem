package school;
import java.util.ArrayList;
import java.util.List;

public class LessonModel {
    private String day;
    private String time;
    private int grade;
    private CoachModel coachModel;
    private List<LearnerModel> learnerModels;

    // Constructor
    public LessonModel(String day, String time, int grade, CoachModel coachModel) {
        this.day = day;
        this.time = time;
        this.grade = grade;
        this.coachModel = coachModel;
        this.learnerModels = new ArrayList<>();
    }

    // Getter for day
    public String getDay() {
        return day;
    }

    // Setter for day
    public void setDay(String day) {
        this.day = day;
    }

    // Getter for time
    public String getTime() {
        return time;
    }

    // Setter for time
    public void setTime(String time) {
        this.time = time;
    }

    // Getter for grade
    public int getGrade() {
        return grade;
    }

    // Setter for grade
    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Getter for coach
    public CoachModel getCoach() {
        return coachModel;
    }

    // Setter for coach
    public void setCoach(CoachModel coachModel) {
        this.coachModel = coachModel;
    }

    // Getter for learners
    public List<LearnerModel> getLearners() {
        return new ArrayList<>(learnerModels); // Return a copy of the list to prevent external modification
    }

    // Method to check if there is vacancy
    public boolean hasVacancy() {
        return learnerModels.size() < 4;
    }

    // Method to add a learner
    public void addLearner(LearnerModel learnerModel) {
        if (learnerModel != null && hasVacancy() && !learnerModels.contains(learnerModel)) {
            learnerModels.add(learnerModel);
        }
    }
}
