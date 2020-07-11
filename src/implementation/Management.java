/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import order.base.ICustomer;
import order.exceptions.OrderException;
import order.management.IManagement;
import order.management.IOrder;

/**
 *
 * @author rubenmiguelcunhasimoes
 */
public class Management implements IManagement {
    
    private static double pricePerCubicVolumeUnit = 10;

    //Orders
    IOrder[] orders;
    int ordersMaxSize = 200;
    int ordersCurrentSize;

    @Override
    public boolean add(IOrder iorder) throws OrderException {
        if(iorder == null ){
            throw new exceptions.OrderException();
        }

        for(int i = 0 ; i < this.ordersCurrentSize; i++){
            if(orders[i].getId() ==  iorder.getId()){
                return false; 
            }
        }
        
        //!! FALTA FAZER O EXPANDE CAPACITY--------------------------------------->>>>>>>>>>>

        //add (nem precisa Cast!..sure)
        this.orders[this.ordersCurrentSize] = iorder;
        
        this.ordersCurrentSize++;
        return true;
    }

    @Override
    public boolean remove(IOrder iorder) throws OrderException {
        int indexOfOrder = -1;
        
        if(iorder == null ){
            throw new exceptions.OrderException();
        }
        
        //ve se encontra o order no orders
        for(int i = 0 ; i < this.ordersCurrentSize; i++){
            if(orders[i].getId() ==  iorder.getId()){
                indexOfOrder = i;
            }
        }

        //se nao encontrou da return false
        if(indexOfOrder == -1){
            return false;
        }
        
        //remove
        for(int i = indexOfOrder; i < this.ordersCurrentSize; i++){
            orders[i] = orders[i+1];
        }
        
        
        this.ordersCurrentSize--;
        return true;
    }

    @Override
    public IOrder[] getOrders(ICustomer ic) {
        int customerId = ic.getCustomerId();
        IOrder[] ordersOfCostumer = null;
        int ordersOfCostumerSize = 0;
        
        for(int i = 0 ; i < this.ordersCurrentSize; i++){
            if(this.orders[i].getCustomer().getCustomerId() == customerId){
                ordersOfCostumer[ordersOfCostumerSize] = this.orders[i];
            }
        }
        return ordersOfCostumer;
    }

    @Override
    public IOrder[] getOrders() {
        return this.orders;
    }

    public static double getPricePerCubicVolumeUnit() {
        return pricePerCubicVolumeUnit;
    }
    
    
}
