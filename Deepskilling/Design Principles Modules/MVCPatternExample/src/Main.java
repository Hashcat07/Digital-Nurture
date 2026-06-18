public class Main {
    public static void main(String[] args) {
        Student model = new Student();
        model.setName("Rohul Ray Edward");
        model.setId("001");
        model.setGrade("A");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentGrade("A+");

        System.out.println("\nAfter updating grade:");
        controller.updateView();
    }
}