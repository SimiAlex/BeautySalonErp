package SimiAlex.com.github.controller;
import SimiAlex.com.github.model.Appointment;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Controller
{
    public static void addRecord()
    {
        Scanner input =  new Scanner(System.in);

        int id;
        String name;
        LocalDateTime time;
        String procedure;
        double price;

        System.out.println("\nAdd record");
        System.out.print("\tEnter id: ");
        id = input.nextInt();
        input.nextLine();
        System.out.print("\tEnter name: ");
        name = input.nextLine();
        System.out.print("\tEnter time: ");
        time = LocalDateTime.parse(input.nextLine());
        System.out.print("\tEnter procedure: ");
        procedure = input.nextLine();
        System.out.print("\tEnter price: ");
        price = input.nextDouble();
        input.nextLine();

        Appointment app = new Appointment(id, name, time, procedure, price);
        DatabaseHandler db = DatabaseHandler.getInstance();
        db.addRecord(app);
        System.out.println("record added");
    }

    public static void deleteRecord()
    {
        Scanner input =  new Scanner(System.in);

        int id;

        System.out.println("\nDelete record");
        System.out.println("Enter id");
        id = input.nextInt();
        input.nextLine();

        DatabaseHandler db = DatabaseHandler.getInstance();
        int index = findIndex(id, db.getAppointments());

        try
        {
            db.deleteRecord(index);
            System.out.println("record deleted");
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("id not found");
        }

    }

    private static int findIndex(int id, List<Appointment> app)
    {
        for(int i = 0; i < app.size(); i++)
        {
            if(id == app.get(i).getId())
            {
                return i;
            }
        }
        return -1;
    }

    public static void updateRecord()
    {
        Scanner input =  new Scanner(System.in);

        int id;
        String name;
        LocalDateTime time;
        String procedure;
        double price;

        System.out.println("\nUpdate record");
        System.out.print("\tEnter id: ");
        id = input.nextInt();
        input.nextLine();
        System.out.print("\tEnter name: ");
        name = input.nextLine();
        System.out.print("\tEnter time: ");
        time = LocalDateTime.parse(input.nextLine());
        System.out.print("\tEnter procedure: ");
        procedure = input.nextLine();
        System.out.print("\tEnter price: ");
        price = input.nextDouble();
        input.nextLine();

        Appointment app = new Appointment(id, name, time, procedure, price);
        DatabaseHandler db = DatabaseHandler.getInstance();
        int index = findIndex(id, db.getAppointments());

        try
        {
            db.updateRecord(index, app);
            System.out.println("record updated");
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("id not found");
        }
    }
}
