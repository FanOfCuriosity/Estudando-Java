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
        if (title.isEmpty()) {
            System.out.println("ERRO: Título vazio");

        } else if (description.isEmpty()) {
            System.out.println("ERRO: Descrição vazia");

        } else if (priority < 1 || priority > 3) {
            System.out.println("ERRO: Opção de prioriedade inexistente");
        
        } else {
            this.title = title;
            this.description = description;
            this.priority = priority;
            this.completed = false;
            this.creationDate = java.time.LocalDate.now().toString();
            totalTasksCreated++;
        }

    }
}
