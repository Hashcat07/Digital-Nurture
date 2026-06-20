public class TaskList {

    private Node head;
    public void addTask(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Task searchById(int taskId) {
        Node current = head;

        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void deleteById(int taskId) {
        if (head == null) {
            return;
        }
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }
        Node previous = head;
        Node current = head.next;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public void displayTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
}