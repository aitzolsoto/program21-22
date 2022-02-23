/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exekutagarriak;

import model.Author;

/**
 *
 * @author root
 */
public class TestBirthday {
    public static void main(String[] args) {
        Author autore1 = new Author("Agatha Christie", 'f');
        Author autore2 = new Author("Francisco Ibañez", 'm');
        autore1.setBirthday("1890-09-15");
        System.out.println(autore1);
        System.out.println(autore2);
    }
    
}
