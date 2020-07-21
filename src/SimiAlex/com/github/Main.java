package SimiAlex.com.github;
import SimiAlex.com.github.controller.Controller;
import SimiAlex.com.github.controller.DatabaseHandler;
import SimiAlex.com.github.view.View;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //load db from file
        DatabaseHandler db = DatabaseHandler.getInstance();
        db.loadDb();

        //print main menu
        View.printMainMenu();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a choice >> ");
        int menuOption = scanner.nextInt();

        while(menuOption != 5)
        {
            switch (menuOption)
            {
                case 1:
                    View.printList(db.getAppointments());
                    break;
                case 2:
                    Controller.addRecord();
                    break;
                case 3:
                    Controller.deleteRecord();
                    break;
                case 4:
                    Controller.updateRecord();
                    break;
                default:
                    System.out.println("invalid input");
            }
            System.out.print("Enter a choice >> ");
            menuOption = scanner.nextInt();
        }

        //save database to disk before exit
        db.saveDb();

    }
}
