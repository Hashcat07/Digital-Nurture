public class Main {

    public static void main(String[] args) {
        TaskList tasks = new TaskList();
        tasks.addTask(new Task(1, "Design DB", "Pending"));
        tasks.addTask(new Task(2, "Write API", "In Progress"));
        tasks.addTask(new Task(3, "Test Login", "Pending"));

        System.out.println("All Tasks");
        tasks.displayTasks();

        System.out.println();
        System.out.println("Search Task 2");
        System.out.println(tasks.searchById(2));

        System.out.println();
        tasks.deleteById(1);
        tasks.deleteById(3);

        System.out.println("After Deletion");
        tasks.displayTasks();
    }
}