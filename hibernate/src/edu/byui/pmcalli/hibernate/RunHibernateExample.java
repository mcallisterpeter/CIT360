package edu.byui.pmcalli.hibernate;

import java.util.*;

public class RunHibernateExample {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int mySelection = 0;
        String query = "from edu.byui.pmcalli.hibernate.movie where ";
        String where= "";
        TestDAO t = TestDAO.getInstance();

        System.out.println("The program allows you to to search my collection of movies.  " +
                "You can search for movies by the name, rating, studio or genre.\n\n");

        System.out.println("Select search criteria using the number associated:");
        System.out.println("1. Name\n2. Rating\n3. Studio\n4. Genre\n");
        System.out.print("Selection: ");
        mySelection = input.nextInt();
        input.nextLine();

        if (mySelection == 1) {
            System.out.print("Enter the Movie Name: ");
            where = "name='" + input.nextLine() + "'";
        } else if (mySelection == 2) {
            System.out.print("Enter the Rating: ");
            where = "rating='" + input.nextLine() + "'";
        } else if (mySelection == 3) {
            System.out.print("Enter the Studio: ");
            where = "studio='" + input.nextLine() + "'";
        } else if (mySelection == 4) {
            System.out.print("Enter the Genre: ");
            where = "genre='" + input.nextLine() + "'";
        }

        System.out.println("\n Here are the movies that meet your search criteria:\n");

        List<movie> c = t.getMovie(query, where);
        for (movie i : c) {
            System.out.println(i);
        }

    }
}
