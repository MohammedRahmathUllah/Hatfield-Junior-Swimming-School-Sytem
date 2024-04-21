package school;
import java.util.ArrayList;
import java.util.List;

public class BookingModel {
	private List<LessonModel> lessonModels;
	private List<LearnerModel> learnerModels;
	private List<CoachModel> coaches;

	public BookingModel() {
		this.lessonModels = new ArrayList<>();
		this.learnerModels = new ArrayList<>();
		this.coaches = new ArrayList<>();
	}

	// Methods for managing learners, lessons, bookings, and generating reports

	public void addLearner(LearnerModel learnerModel) {
		if (learnerModel != null && !learnerModels.contains(learnerModel)) {
			learnerModels.add(learnerModel);
		}
	}

	public void addCoach(CoachModel coachModel) {
		if (coachModel != null && !coaches.contains(coachModel)) {
			coaches.add(coachModel);
		}
	}

	public void addLesson(LessonModel lessonModel) {
		if (lessonModel != null && !lessonModels.contains(lessonModel)) {
			lessonModels.add(lessonModel);
		}
	}

	public void bookLesson(String learnerName, String day, String time, int grade) {
		for (LessonModel lessonModel : lessonModels) {
			if (lessonModel.getDay().equals(day) && lessonModel.getTime().equals(time)
					&& lessonModel.getGrade() == grade && lessonModel.hasVacancy()) {
				for (LearnerModel learnerModel : learnerModels) {
					if (learnerModel.getName().equals(learnerName)
							&& (learnerModel.getGrade() == grade || learnerModel.getGrade() + 1 == grade)) {
						lessonModel.addLearner(learnerModel);
						System.out.println("Booking successful for " + learnerName);
						return;
					}
				}
				System.out.println("No such learner found");
				return;
			}
		}
		System.out.println("No such lesson found");
	}

	// Method to view the timetable by day
	public void viewTimetableByDay(String day) {
		System.out.println("Timetable for " + day + ":");
		for (LessonModel lessonModel : lessonModels) {
			if (lessonModel.getDay().equalsIgnoreCase(day)) {
				System.out.println("Time: " + lessonModel.getTime() + ", Grade: " + lessonModel.getGrade() + ", Coach: "
						+ lessonModel.getCoach().getName() + ", Vacancy: " + (4 - lessonModel.getLearners().size()));
			}
		}
	}

	// Method to view the timetable by grade
	public void viewTimetableByGrade(int grade) {
		System.out.println("Timetable for Grade " + grade + ":");
		for (LessonModel lessonModel : lessonModels) {
			if (lessonModel.getGrade() == grade) {
				System.out.println("Day: " + lessonModel.getDay() + ", Time: " + lessonModel.getTime() + ", Coach: "
						+ lessonModel.getCoach().getName() + ", Vacancy: " + (4 - lessonModel.getLearners().size()));
			}
		}
	}

	// Method to view the timetable by coach
	public void viewTimetableByCoach(String coachName) {
		System.out.println("Timetable for Coach " + coachName + ":");
		for (LessonModel lessonModel : lessonModels) {
			if (lessonModel.getCoach().getName().equalsIgnoreCase(coachName)) {
				System.out.println("Day: " + lessonModel.getDay() + ", Time: " + lessonModel.getTime() + ", Grade: "
						+ lessonModel.getGrade() + ", Vacancy: " + (4 - lessonModel.getLearners().size()));
			}
		}
	}

	// Method to change a booking
	public void changeBooking(String learnerName, String oldDay, String oldTime, String newDay, String newTime,
			int newGrade) {
		// Find and remove the learner from the old lesson
		boolean removed = false;
		for (LessonModel lessonModel : lessonModels) {
			if (lessonModel.getDay().equals(oldDay) && lessonModel.getTime().equals(oldTime)) {
				for (LearnerModel learnerModel : lessonModel.getLearners()) {
					if (learnerModel.getName().equals(learnerName)) {
						lessonModel.getLearners().remove(learnerModel);
						removed = true;
						break; // Stop searching once the learner is found and removed
					}
				}
				if (removed)
					break; // Stop searching through lessons once the learner is removed from one
			}
		}
		// Add the learner to the new lesson if they were successfully removed from the
		// old one
		if (removed) {
			bookLesson(learnerName, newDay, newTime, newGrade);
		} else {
			System.out.println("Failed to change booking: No existing booking found.");
		}
	}

	// Method to cancel a booking
	public void cancelBooking(String learnerName, String day, String time) {
		for (LessonModel lessonModel : lessonModels) {
			if (lessonModel.getDay().equals(day) && lessonModel.getTime().equals(time)) {
				for (int i = 0; i < lessonModel.getLearners().size(); i++) {
					if (lessonModel.getLearners().get(i).getName().equals(learnerName)) {
						lessonModel.getLearners().remove(i);
						System.out.println("Booking cancelled for " + learnerName);
						return;
					}
				}
				System.out.println("Failed to cancel booking: Learner not found in the specified lesson.");
				return;
			}
		}
		System.out.println("Failed to cancel booking: No such lesson found.");
	}

	public void printLessons() {
		for (LessonModel lessonModel : lessonModels) {
			System.out.println("Day: " + lessonModel.getDay() + ", Time: " + lessonModel.getTime() + ", Grade: "
					+ lessonModel.getGrade() + ", Coach: " + lessonModel.getCoach().getName() + ", Vacancy: "
					+ (4 - lessonModel.getLearners().size()));
		}
	}

	public void attendLesson(String learnerName, String day, String time) {
		for (LessonModel lessonModel : lessonModels) {
			if (lessonModel.getDay().equalsIgnoreCase(day) && lessonModel.getTime().equalsIgnoreCase(time)) {
				for (LearnerModel learnerModel : lessonModel.getLearners()) {
					if (learnerModel.getName().equalsIgnoreCase(learnerName)) {
						// This is where you'd typically log attendance. For now, we'll just print.
						System.out.println(learnerName + " attended the lesson on " + day + " at " + time);
						return;
					}
				}
				System.out.println("Learner " + learnerName + " is not enrolled in this lesson.");
				return;
			}
		}
		System.out.println("No lesson found for the given day and time.");
	}

	public void printMonthlyLearnerReport() {
		int i=1;
		System.out.println("Monthly Learner Report:");
		for (LearnerModel learnerModel : learnerModels) {
			
			System.out.println("Learner:" +i+ " "+learnerModel.getName());
			i++;
			System.out.println("Learner Grade: " +learnerModel.getGrade());
			System.out.println();
			for (LessonModel lessonModel : lessonModels) {
				if (lessonModel.getLearners().contains(learnerModel)) {
					System.out.println("Attended: " + lessonModel.getDay() + " " + lessonModel.getTime()
							+ " with Coach " + lessonModel.getCoach().getName());
				}
			}
		}
	}

	public void printMonthlyCoachReport() {
		int i=1;
		System.out.println("Monthly Coach Report:");
		for (CoachModel coachModel : coaches) {
			System.out.println("Coach: " + coachModel.getName());
			double averageRating = coachModel.calculateAverageRating();
			System.out.println("Average Rating: " + averageRating);
			System.out.println("Lessons conducted:");
			for (LessonModel lessonModel : lessonModels) {
				if (lessonModel.getCoach().equals(coachModel)) {
					System.out.println(
							lessonModel.getDay() + " " + lessonModel.getTime() + " - Grade " + lessonModel.getGrade());
				}
			}
			System.out.println("---End Coach "+i+"---");
			i++;
			System.out.println();
		}
	}

	public List<LearnerModel> getLearnerModels() {
		// TODO Auto-generated method stub
		return learnerModels;
	}

	public List<CoachModel> getCoaches() {
		// TODO Auto-generated method stub
		return coaches;
	}

	public List<LessonModel> getLessonModels() {
		// TODO Auto-generated method stub
		return lessonModels;
	}

}
