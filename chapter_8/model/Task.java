package chapter_8.model;

public class Task {
    private String title;
    private String description;
    private int priority;
    private boolean completed;
    private final String creationDate;
    private String completionDate;
    private static int totalTasksCreated;

    public Task(String title, String description, int priority) {
        this.creationDate = java.time.LocalDate.now().toString();
        if (title.isEmpty()) {
            System.out.println("ERRO: Título vazio");

        } else if (description.isEmpty()) {
            System.out.println("ERRO: Descrição vazia");

        } else if (priority < 1 || priority > 3) {
            System.out.println("ERRO: Opção de prioridade inexistente");
        
        } else {
            this.title = title;
            this.description = description;
            this.priority = priority;
            this.completed = false;
            totalTasksCreated++;
        }
    }

    public boolean complete() {
        this.completed = true;
        return true;
    }
    
    public boolean reopen() {
        this.completed = false;
        return true;
    }

    public boolean editTitle(String newTitle) {
        this.title = newTitle;
        return true;
    }

    public boolean editDescription(String newDescription) {
        this.description = newDescription;
        return true;
    }

    public boolean editPriority(int newPriority) {
        this.priority = newPriority;
        return true;
    }

    public void show() {
        System.out.printf("Title: %s\n", this.title);
        System.out.printf("Description: %s\n", this.description);
        System.out.printf("Priority: %d\n", this.priority);
        System.out.printf("Status: %b\n", (this.completed) ? "Completed" : "Not completed");
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public static int getTotalTasksCreated() {
        return totalTasksCreated;
    }
}
