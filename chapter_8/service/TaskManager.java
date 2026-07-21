package chapter_8.service;

import java.util.ArrayList;
import java.util.Scanner;
import chapter_8.model.Task;

public class TaskManager {

    private ArrayList<Task> tasks;
    private ArrayList<String> history;
    private Scanner consoleInput;
    private int[][] productivity;

    public TaskManager() {

        this.tasks = new ArrayList<Task>();
        this.consoleInput = new Scanner(System.in);
        this.productivity = new int[12][31];
        this.history = new ArrayList<String>();
    }

    public void addTask() {
        System.out.print("Title: ");
        String title = this.consoleInput.nextLine();

        System.out.print("Description: ");
        String description = this.consoleInput.nextLine();

        System.out.println("1 -> High");
        System.out.println("2 -> Medium");
        System.out.println("3 -> Low");
        System.out.print("Priority: ");
        int priority = this.consoleInput.nextInt();
        this.consoleInput.nextLine();

        Task task = new Task(title, description, priority);
        tasks.add(task);
        System.out.println("Task added");
        history.add("[INFO] Task \"" + title + "\" created.");
    }

    public boolean removeTask() {
        this.consoleInput.nextLine();
        System.out.print("Title: ");
        String title = this.consoleInput.nextLine();
        boolean status = false;

        for (Task task : this.tasks) {
            if (task.getTitle().equals(title)) {
                tasks.remove(task);
                status = true;
                history.add("[INFO] Task \"" + task.getTitle() + "\" removed");
            }
        }
        return status;
    }

    public void editTask() {
        this.consoleInput.nextLine();
        System.out.print("Title: ");
        String title = consoleInput.nextLine();
        
        boolean found = false;


        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                found = true;
            }
        }

        if (found) {
            System.out.print("New title: ");
            String newTitle = consoleInput.nextLine();
            System.out.print("New description: ");
            String newDescription = consoleInput.nextLine();
            System.out.print("New priority: ");
            int newPriority = consoleInput.nextInt();
            
            for (Task task : tasks) {
                if (task.getTitle().equalsIgnoreCase(title)) {
                    task.editTitle(newTitle);
                    task.editDescription(newDescription);
                    task.editPriority(newPriority);
                    this.history.add("[INFO] Task \"" + title + "\" edited to \"" + newTitle + "\"");
                }
            }
        } else {
            System.out.println("Book not found");
        }
    }

    public boolean searchTask() {
        this.consoleInput.nextLine();
        System.out.print("Title: ");
        String title = this.consoleInput.nextLine();
        boolean status = false;

        for (Task task : this.tasks) {
            if (task.getTitle().equals(title)) {
                task.show();
                status = true;
            }
        }
        return status;
    }

    public boolean completeTask() {
        System.out.print("Title: ");
        String title = this.consoleInput.nextLine();

        System.out.print("Concluded task month: ");
        int month = this.consoleInput.nextInt();
        System.out.print("Concluded task day: ");
        int day = this.consoleInput.nextInt();
        this.productivity[month - 1][day - 1]++;

        boolean status = false;

        for (Task task : this.tasks) {
            if (task.getTitle().equals(title)) {
                task.complete();
                status = true;
                this.history.add("[INFO] Task \"" + title + "\" completed");
            }
        }
        return status;
    }

    public boolean reopenTask() {
        this.consoleInput.nextLine();
        System.out.print("Title: ");
        String title = this.consoleInput.nextLine();
        boolean status = false;

        for (Task task : this.tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                task.reopen();
                status = true;
                this.history.add("[INFO] Task \"" + title + "\" completed");
            }
        }
        return status;
    }

    public void showTasks() {
        for (Task task : this.tasks) {
            task.show();
        }
    }

    public void showStatistics() {
        int concludedTasksSum = 0;
        for (Task task : this.tasks) {
            if (task.isCompleted()) {
                concludedTasksSum += 1;
            }
        }

        int pendingTasksSum = 0;
        for (Task task : this.tasks) {
            if (task.isCompleted() == false) {
                pendingTasksSum += 1;
            }
        }

        double concludedTasksPercent = (double) concludedTasksSum / this.tasks.getFirst().getTotalTasksCreated();
        
        int[] prioritySums = new int[3];
        String[] priorityNames = {"High", "Medium", "Low"};
        int maxValueIndex = 0;

        for (Task task : this.tasks) {
            if (task.getPriority() == 1) {
                prioritySums[0]++;
            
            } else if (task.getPriority() == 2) {
                prioritySums[1]++;
                
            } else if (task.getPriority() == 3) {
                prioritySums[2]++;
            }
        }

        for (int count = 1; count < prioritySums.length; count++) {
            if (prioritySums[count] > prioritySums[maxValueIndex]) {
                maxValueIndex = count;
            }
        }

        ArrayList<Task> highPriorityTasks = new ArrayList<Task>();
        ArrayList<Task> lowPriorityTasks = new ArrayList<Task>();
        for (Task task : this.tasks) {
            if (task.getPriority() == 1) {
                highPriorityTasks.add(task);
            } else if (task.getPriority() == 3) {
                lowPriorityTasks.add(task);
            }
        }

        System.out.println("=========================================================");
        System.out.printf("Total de tarefas: %d\n", this.tasks.getFirst().getTotalTasksCreated());
        System.out.printf("Total de tarefas concluídas: %d\n", concludedTasksSum);
        System.out.printf("Total de tarefas pendentes: %d\n", pendingTasksSum);
        System.out.printf("Tarefas concluídas (percentual): %%%.2f\n", concludedTasksPercent * 100);
        System.out.printf("Prioridade mais utilizada: %s\n", priorityNames[maxValueIndex]);
        System.out.print("Tarefas de alta prioridade: \n");
        highPriorityTasks.forEach(task -> task.show());
        System.out.print("Tarefas de menor prioridade: \n");
        lowPriorityTasks.forEach(task -> task.show());
    }

    public void showProductivityMatrix() {
        for (int i = 0; i < this.productivity.length; i++) {
            for (int j = 0; j < this.productivity[i].length; j++) {
                System.out.print(this.productivity[i][j] + " ");
            }
        }
    }

    public void showHistory() {
        this.history.forEach(log -> System.out.println(log));
    }
}
