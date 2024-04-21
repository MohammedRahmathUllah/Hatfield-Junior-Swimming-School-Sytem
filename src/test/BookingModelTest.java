package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import school.BookingModel;
import school.CoachModel;
import school.LearnerModel;
import school.LessonModel;

class BookingModelTest {
    private BookingModel bookingModel;

    @BeforeEach
    void setUp() {
        bookingModel = new BookingModel();
    }

    @Test
    void testAddLearner() {
        LearnerModel learner = new LearnerModel("Liza", "Female", 10, "1234567890", 1);
        bookingModel.addLearner(learner);
        assertTrue(bookingModel.getLearnerModels().contains(learner));
    }

    @Test
    void testAddCoach() {
        CoachModel coach = new CoachModel("Maxwell");
        bookingModel.addCoach(coach);
        assertTrue(bookingModel.getCoaches().contains(coach));
    }

    @Test
    void testAddLesson() {
        LessonModel lesson = new LessonModel("Monday", "4-5pm", 1, new CoachModel("John"));
        bookingModel.addLesson(lesson);
        assertTrue(bookingModel.getLessonModels().contains(lesson));
    }

    @Test
    void testViewTimetableByDay() {
        // Add a lesson
        LessonModel lesson = new LessonModel("Monday", "4-5pm", 1, new CoachModel("Amelia"));
        bookingModel.addLesson(lesson);

        // Test viewing timetable by day
        bookingModel.viewTimetableByDay("Monday");
        // Add assertions based on your expected output
    }

    @Test
    void testViewTimetableByGrade() {
        // Add a lesson
        LessonModel lesson = new LessonModel("Monday", "4-5pm", 1, new CoachModel("Amelia"));
        bookingModel.addLesson(lesson);

        // Test viewing timetable by grade
        bookingModel.viewTimetableByGrade(1);
        // Add assertions based on your expected output
    }

    @Test
    void testViewTimetableByCoach() {
        // Add a lesson
        LessonModel lesson = new LessonModel("Monday", "4-5pm", 1, new CoachModel("Amelia"));
        bookingModel.addLesson(lesson);

        // Test viewing timetable by coach
        bookingModel.viewTimetableByCoach("Amelia");
        // Add assertions based on your expected output
    }
}