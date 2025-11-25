/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ie.trk.courseraspringboot.learn_spring_boot;


public class Course {
    
    private final int id;
    private final String name;
    private final String author;

    public Course(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author= author;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("Course(id: %s, name: %s, author %s)", id, name, author);
    }

}
