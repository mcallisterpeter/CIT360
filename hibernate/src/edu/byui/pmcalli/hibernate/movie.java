package edu.byui.pmcalli.hibernate;

import javax.persistence.*;

/** This Data Object class corresponds with movie table
 *  in database. */
@Entity
@Table(name = "movie")

public class movie {

    /** id is an identity type field in the database and the primary key */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private String rating;

    @Column(name = "studio")
    private String studio;

    @Column(name = "genre")
    private String genre;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStudio() {
        return studio;
    }
    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return Integer.toString(id) + " " + name + " " + rating + " " + studio + " " + genre;
    }
}
