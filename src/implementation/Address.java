/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implementation;

import order.base.IAddress;

/**
 * Nome: Diogo Sá Tinoco de Magalhães
 * Número: 8120336
 * Turma: turma1
 */
public class Address implements IAddress{
    
    private String city;
    private String country;
    private int number;
    private String state;
    private String street;

    public Address(String city, String country, int number, String state, String street) {
        this.city = city;
        this.country = country;
        this.number = number;
        this.state = state;
        this.street = street;
    }
    
        
    
    
    /**
     * Getter for city
     * @return city 
     */
    @Override
    public String getCity() {
        return this.city;
    }

     /**
     * Getter for county
     * @return county
     */
    @Override
    public String getCountry() {
        return this.country;
    }

     /**
     * Getter for number
     * @return number
     */
    @Override
    public int getNumber() {
        return this.number;
    }


     /**
     * Getter for state
     * @return state
     */
    @Override
    public String getState() {
        return this.state;
    }
    
     /**
     * Getter for street
     * @return street
     */
    @Override
    public String getStreet() {
        return this.street;
    }

    /**
     * Setter for city
     * @param string 
     */
    @Override
    public void setCity(String string) {
        this.city = string;
    }

    /**
     * Setter for country
     * @param string
     */
    @Override
    public void setCountry(String string) {
        this.country = string;
    }

    /**
     *
     * @param i
     */
    @Override
    public void setNumber(int i) {
        this.number = i;
    }

    /**
     *
     * @param string
     */
    @Override
    public void setState(String string) {
        this.state = string;
    }

    /**
     * 
     * @param string 
     */
    @Override
    public void setStreet(String string) {
        this.street = string;
    }
    

}
