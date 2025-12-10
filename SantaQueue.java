import java.util.*;

public class SantaQueue {
    private static Queue<Child> queue = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Santa's Naughty/Nice Queue");
            System.out.println("1. Add a child");
            System.out.println("2. Display all children");
            System.out.println("3. Show next child");
            System.out.println("4. Deliver present (remove child)");
            System.out.println("5. Search child by name");
            System.out.println("6. Count Nice vs Naughty children");
            System.out.println("7. Update child status/present");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addChild();
                case 2 -> displayChildren();
                case 3 -> showNextChild();
                case 4 -> deliverPresent();
                case 5 -> searchChild();
                case 6 -> countChildren();
                case 7 -> updateChild();
                case 0 -> System.out.println("Exiting program. Merry Christmas!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private static void addChild() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            System.out.print("Enter status (Naughty/Nice): ");
            String status = scanner.nextLine();
            System.out.print("Enter present: ");
            String present = scanner.nextLine();

            Child child = new Child(name, address, status, present);
            queue.add(child);
            System.out.println("Child added to Santa's queue!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayChildren() {
        if (queue.isEmpty()) {
            System.out.println("No children in queue.");
        } else {
            System.out.println("\nChildren waiting for presents:");
            List<Child> sortedList = new ArrayList<>(queue);
            sortedList.sort(Comparator.comparing(Child::getName));
            for (Child child : sortedList) {
                System.out.println(child);
            }
        }
    }

    private static void showNextChild() {
        Child next = queue.peek();
        if (next == null) {
            System.out.println("No children in queue.");
        } else {
            System.out.println("Next child to process:");
            System.out.println(next);
        }
    }

    private static void deliverPresent() {
        Child child = queue.poll();
        if (child == null) {
            System.out.println("No children in queue.");
        } else {
            System.out.println("Delivered present to " + child.getName() + "!");
        }
    }

    private static void searchChild() {
        System.out.print("Enter child name to search: ");
        String name = scanner.nextLine().trim();
        boolean found = false;
        for (Child child : queue) {
            if (child.getName().equalsIgnoreCase(name)) {
                System.out.println("Child found: " + child);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Child not found.");
    }

    private static void countChildren() {
        int nice = 0, naughty = 0;
        for (Child child : queue) {
            if (child.getNaughtyOrNice().equalsIgnoreCase("Nice")) nice++;
            else naughty++;
        }
        System.out.println("Nice children: " + nice);
        System.out.println("Naughty children: " + naughty);
    }

    private static void updateChild() {
        System.out.print("Enter child name to update: ");
        String name = scanner.nextLine().trim();
        for (Child child : queue) {
            if (child.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new status (Naughty/Nice): ");
                String status = scanner.nextLine();
                System.out.print("Enter new present: ");
                String present = scanner.nextLine();
                try {
                    child.setNaughtyOrNice(status);
                    child.setPresent(present);
                    System.out.println("Child updated successfully!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Child not found.");
    }
}
