package by.it.academy.pojos;

/**
 * Created by USER on 13.05.2016.
 */
public class Person {
    private Long personId;
    private String name;
    private String surname;

    public Person() {

    }

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Person(Long personId, String name, String surname){
        this.personId = personId;
        this.name = name;
        this.surname = surname;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}