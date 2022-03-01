package model;

import java.time.LocalDate;
import java.time.Month;

/* 
 * The Author class model a book's author.
 */
public class Author {
   // The private instance variables
   private String name;
   private char gender;   // 'm' or 'f'
   private LocalDate birthday;
 
   // The constructor
   public Author(String name, char gender) {
      this.name = name;
      this.gender = gender;
   }
 
   // The public getters and setters for the private instance variables.
   // No setter for name and gender as they are not designed to be changed.
   public String getName() {
      return name;
   }
   public char getGender() {
      return gender;
   }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String d) {
        int year = Integer.parseInt(d.substring(0, 4));
        int month = Integer.parseInt(d.substring(5, 7));
        int day = Integer.parseInt(d.substring(8, 10));
        this.birthday = LocalDate.of(year, month, day);
    }
   
   // The toString() describes itself
   public String toString() {
      if(birthday != null){
          return name + " (" + gender + ") " + birthday;
      }else{
          return name + " (" + gender + ")";
      }
      
   }
}