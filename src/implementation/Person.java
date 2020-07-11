/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import order.base.IAddress;
import order.base.IPerson;

/**
 * Nome: Diogo Sá Tinoco de Magalhães Número: 8120336 Turma: turma1
 */
public class Person implements IPerson {

    private String name;
    private Address address;

    
    
    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    
    
    
    
    
    /**
     * Getter for address
     * @return address
     */
    @Override
    public IAddress getAddress() {
        return this.address;
    }

    /**
     * Getter for name
     * @return name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Setter for address
     * @param ia
     */
    @Override
    public void setAddress(IAddress ia) {
        this.address = (Address) ia;
    }

    /**
     * Setter for name
     * @param string
     */
    @Override
    public void setName(String string) {
        this.name = string;
    }

}
