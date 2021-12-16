import java.util.*;
public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int cash = 550;
    static Scanner scan=new Scanner(System.in);



    public boolean canMakeCoffee(int waterNeed, int milkNeed, int beansNeed) {
        if (water >= waterNeed) {
            if (milk >= milkNeed) {
                if (beans >= beansNeed) {
                    System.out.println("Making you a coffee!\n");
                    return true;
                } else {
                    System.out.println("Sorry, not enough beans!");
                    return false;
                }

            } else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    public void makeCoffee(int waterNeed, int milkNeed, int beansNeed, int amount){
        water -= waterNeed;
        beans -= beansNeed;
        milk -= milkNeed;
        cups--;
        cash += amount;
    }

    public void buy(){
        System.out.println();
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scan.next();
        switch (choice) {
            case "1": {
                if (canMakeCoffee(250, 0, 16)) {
                    makeCoffee(250, 0,16,4);
                    break;
                }
            }
            case "2": {
                if (canMakeCoffee(350, 75, 20)) {
                    makeCoffee(350, 75,20,7);
                    break;
                }
            }
            case "3": {
                if (canMakeCoffee(200, 100, 12)) {
                    makeCoffee(200, 100,12,6);
                    break;
                }

            }
            case "back": {
                break;
            }
            default: {
                break;
            }

        }

    }
    public void fill() {

        System.out.println("Write how many ml of water do you want to add: ");
        int waterAdd = scan.nextInt();

        System.out.println("Write how many ml of milk do you want to add: ");
        int milkAdd = scan.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int beansAdd = scan.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int cupsAdd = scan.nextInt();

        water += waterAdd;
        milk += milkAdd;
        beans += beansAdd;
        cups += cupsAdd;
    }

    public void collect() {
        System.out.println("Dispensing all cash from machine $" + cash +"\n");
        cash = 0;
    }

    public void remaining() {

        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(cash + " of cash");
        System.out.println();

    }


}

class Runner{
    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {

        boolean exit = false;
        do {

            System.out.print("Good Morning Sunshine ! What do you wish to do ?  (Buy Coffee, Fill Up Ingredients, Collect Money, Monitor Status, Exit): ");
            String action = scan.next();
            CoffeeMachine machine1 = new CoffeeMachine();
            switch (action) {
                case "buy":
                    machine1.buy();
                    break;
                case "fill":
                    machine1.fill();
                    break;
                case "take":
                    machine1.collect();
                    break;
                case "remaining":
                    machine1.remaining();
                    break;
                case "exit":
                    exit=true;
                    break;
            }
        } while (!exit);


    }
}