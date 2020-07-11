/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implementation;

import order.base.IAddress;
import order.base.ICustomer;

/**
 * Nome: Diogo Sá Tinoco de Magalhães
 * Número: 8120336
 * Turma: turma1
 */
public class Customer extends Person implements ICustomer{

    private Address billingAddress; // var instancia <- cada costumer tem um "addres" proprio 
    private int id;                 // var instancia <- cada costumer tem um "id" proprio
    private static int customerCounter; // var classe <- porque tem o "static". Se alterar este valor para um "Costumer", esse valor altera para tods os "costumers"
    private String vat;

    public Customer(Address billingAddress, String name, Address address, String vat) {
        super(name, address);
        this.billingAddress = billingAddress;
        this.id = this.customerCounter;
        this.customerCounter++;
        this.vat = vat;
    }

    public Customer(String name, Address address) {
        super(name, address);
        this.billingAddress = address;
        this.id = this.customerCounter;
        this.customerCounter++;
        
    }

    
    
    @Override
    public IAddress getBillingAddress() {
        return this.billingAddress;
    }

    @Override
    public int getCustomerId() {
        return this.id;
    }

    @Override
    public void setBillingAddress(IAddress ia) {
        this.billingAddress = (Address) ia;
    }

    @Override
    public String getVat() {
        return this.vat;
    }

    @Override
    public void setVat(String string) {
        this.vat = string;
    }


}
