package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");

        do {
            System.out.println();
            System.out.print("Choose option: ");
            int inputOption = Integer.parseInt(input.nextLine());

            if(inputOption == 1) {
                System.out.print("Pizza type: ");
                String inputtedPizzaType = input.nextLine();
                System.out.print("Quantity: ");
                int inputtedQuantity = Integer.parseInt(input.nextLine());

                if (inputtedQuantity > 0) {
                    addOrder(pizzas, quantities, inputtedPizzaType, inputtedQuantity);
                }
                else System.out.println("Quantity must be positive");

            } else if(inputOption == 2) {
                System.out.print("Order number to update: ");
                int orderNumberToUpdate = Integer.parseInt(input.nextLine());
                System.out.print("New quantity: ");
                int inputtedNewQuantity = Integer.parseInt(input.nextLine());

                if (inputtedNewQuantity > 0) {
                    updateOrder(quantities, orderNumberToUpdate - 1, inputtedNewQuantity);
                }
                else System.out.println("Quantity must be positive");
            } else if(inputOption == 3) {
                System.out.print("Order number to delete: ");
                int orderNumberToDelete = Integer.parseInt(input.nextLine());

                if (orderNumberToDelete > 0) {
                    removeOrder(pizzas, quantities, orderNumberToDelete - 1);
                }
                else System.out.println("Quantity must be positive");
            } else if(inputOption == 4) {
                printOrders(pizzas, quantities);
            } else if(inputOption == 5){
                System.out.println("---Thank you!---");
                break;
            }

        } while (true);

    }

    public static void addOrder(
            ArrayList<String> pizzas,
            ArrayList<Integer> quantities,
            String pizzaType,
            int quantity
    ) {
        if (quantity > 0) {
            pizzas.add(pizzaType);
            quantities.add(quantity);
        }
    }

    public static void updateOrder(
            ArrayList<Integer> quantities,
            int index,
            int newQuantity
    ) {
        if (!quantities.isEmpty() && newQuantity > 0) quantities.set(index, newQuantity);
    }

    public static void removeOrder(
            ArrayList<String> pizzas,
            ArrayList<Integer> quantities,
            int index
    ) {
        if (!pizzas.isEmpty()) {
            pizzas.remove(index);
            quantities.remove(index);
        }
    }

    public static void printOrders(
            ArrayList<String> pizzas,
            ArrayList<Integer> quantities
    ) {
        System.out.println();
        System.out.println("--- Current Orders ---");
        for (int i = 1; i <= pizzas.size(); i++) {
            System.out.println(i + ". " + pizzas.get(i - 1) + " x " + quantities.get(i - 1));
        }
    }
}