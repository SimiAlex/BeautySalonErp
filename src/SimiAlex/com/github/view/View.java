package SimiAlex.com.github.view;

import SimiAlex.com.github.model.Appointment;

import java.util.List;

public class View
{
    public static void printMainMenu()
    {
        System.out.println("Welcome to American Nails");
        System.out.println("\tPress 1 to show appointment list");
        System.out.println("\tPress 2 to add appointment");
        System.out.println("\tPress 3 to delete appointment");
        System.out.println("\tPress 4 to modify appointment");
        System.out.println("\tPress 5 to exit");
    }

    public static void printList(List<Appointment> app)
    {
        System.out.println("\nid\t name\t time\t procedure\t price\n" );
        for (Appointment anAppointment:app)
        {
            System.out.println(anAppointment.toString());
        }
    }
}
