/**
* calculates the class grade for students.
* @author Perry Bunn
* @version 2/13/2017
*/
public class Grade {
   /**
   */
   private double exam1;
   private double exam2;
   private double finalExam;
   private double activityAvg;
   private double quizAvg;
   private double projectAvg;
   private String studentName;
   
   /**
   */
   public static final int EXAM_1 = 1, EXAM_2 = 2, FINAL = 3;
   private static final double EXAM_WEIGHT = 0.15,
      FINAL_WEIGHT = 0.30, ACT_WEIGHT = 0.05,
      QUIZ_WEIGHT = 0.10, PROJ_WEIGHT = 0.25;
   /**
   * @param studentNameIn sets the studentName.
   */
   public Grade(String studentNameIn) {
      studentName = studentNameIn;
   }
   /**
   * @param activityAvgIn sets the activityAvg.
   * @param quizAvgIn sets the quizAvg.
   */
   public void setLabAverages(double activityAvgIn, double quizAvgIn) {
      activityAvg = activityAvgIn;
      quizAvg = quizAvgIn;
   }
   /**
   * @param projectAvgIn sets the projectAvg.
   */
   public void setProjectAvg(double projectAvgIn) {
      projectAvg = projectAvgIn;
   }
   /**
   * @param examType sets teh exam type.
   * @param examScoreIn sets the examScore.
   */
   public void setExamScore(int examType, double examScoreIn) {
      if (examType == EXAM_1) {
         exam1 = examScoreIn;
      } else if (examType == EXAM_2) {
         exam2 = examScoreIn;
      } else if (examType == FINAL) {
         finalExam = examScoreIn;
      }
   }
   /**
   * @return returns grade.
   */
   public double calculateGrade() {
      double grade = exam1 * EXAM_WEIGHT + exam2 * EXAM_WEIGHT
         + finalExam * FINAL_WEIGHT
         + activityAvg * ACT_WEIGHT
         + quizAvg * QUIZ_WEIGHT
         + projectAvg * PROJ_WEIGHT;
      return grade;
   }
   /**
   * @return returns the studentName and grade.
   */
   public String toString() {
      return "Name: " + studentName + "\n"
         + "Course Grade: " + calculateGrade();
   }
}