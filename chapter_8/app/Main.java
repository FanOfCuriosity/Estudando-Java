package chapter_8.app;

import java.util.Scanner;
import chapter_8.service.TaskManager;
import chapter_8.util.Console;


public class Main {
    public static void main(String[] args) {
        TaskManager tasks = new TaskManager();
        Scanner consoleInput = new Scanner(System.in);

        int option = 1;

        while (!(option == 0)) {
            Console.console();
            option = consoleInput.nextInt();
            if (option == 1) {
                tasks.addTask();
            } else if (option == 2) {
                tasks.editTask();
            } else if (option == 3) {
                tasks.completeTask();
            } else if (option == 4) {
                tasks.reopenTask();
            } else if (option == 5) {
                tasks.removeTask();
            } else if (option == 6) {
                tasks.searchTask();
            } else if (option == 7) {
                tasks.showTasks();
            } else if (option == 8) {
                tasks.showStatistics();
            } else if (option == 9) {
                tasks.showHistory();
            }
        }
    }
}
