/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import java.time.LocalDate;
import order.base.ICustomer;
import order.base.IPerson;
import exceptions.ContainerException;
import exceptions.OrderException;
import exceptions.PositionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import order.management.IOrder;
import order.management.IShipping;
import order.management.ShipmentStatus;
import order.packing.Color;
import order.packing.IContainer;
import order.packing.IItem;

/**
 *
 * @author rubenmiguelcunhasimoes
 */
public class Order implements IOrder{
    
    IPerson destination;
    ICustomer customer;
    int id;
    LocalDate localDate;
    boolean isClosed;
    
    //items
    IItem[] items;
    int itemsMaxSize = 20-1;
    int itemsCurrentSize;

    //container
    IContainer container;
    int containersMaxSize;
    int containerCurrentSize;

    //shippings
    IShipping[] shippings;
    int shippingsMaxSize;
    int shippingsCurrentSize;
    
    
    
    @Override
    public IPerson getDestination() {
        return this.destination;
    }

    @Override
    public void setDestination(IPerson ip) {
        this.destination = ip;
    }

    @Override
    public ICustomer getCustomer() {
        return this.customer;
    }

    @Override
    public void setCustomer(ICustomer ic) {
        this.customer = ic;
    }

    @Override
    public IItem[] getItems() {
        return this.items;
    }

    @Override
    public void setId(int i) {
        this.id = i;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setDate(int i, int i1, int i2) {
        this.localDate = LocalDate.of(i, i1, i2);
    }

    @Override
    public LocalDate getDate() {
        return this.localDate;
    }

    @Override
    public boolean add(IItem iitem) throws OrderException {
        if(iitem == null){
            throw new OrderException();
        }
        if(this.containersMaxSize == this.containerCurrentSize){
            return false;
        }

        //addicionar item ao container
        this.items[this.itemsCurrentSize] = iitem;

        //finishing add case sucess
        this.containerCurrentSize++;
        return true;
    }

    
    @Override
    public IShipping[] getShippings() {
        return this.shippings;
    }

    @Override
    public boolean addShipping(IShipping is) throws OrderException {
        
        if(is == null || !this.isClosed){
            throw new OrderException("shipping null ou fechado");
        }
        //nao preciso fazer resize caso teja cheio 
        if(this.itemsCurrentSize == this.itemsMaxSize){
            return false;
        }
        //adicionar
        this.shippings[this.itemsCurrentSize] = is;
        itemsCurrentSize++;
        return true;
    }

    @Override
    public boolean removeShipping(IShipping is) throws OrderException {
        
        if(is == null || !this.isClosed){
            throw new OrderException(OrderException.shippmentError);
        }

        boolean isShipingFound = false;
        int shippingFoundIndex = -1;
        //pq preciso ver se ta null?-----------------------------------> DUVIDA_1
        if(is == null || this.isClosed ){
            throw new OrderException();
        }
        
        for(int i = 0 ; i < this.shippingsCurrentSize ; i++){
            if (this.shippings[i] == is){
                isShipingFound = true;
                shippingFoundIndex = i;
            }
        }
        if(isShipingFound == false){
            return false;
        }
        
        //remover shipping
        for(int i = shippingFoundIndex ; i < this.shippingsCurrentSize - 1 ;i++){
            this.shippings[shippingFoundIndex] = this.shippings[i+1];
        }

        this.shippingsCurrentSize--;
        return true;
    }

    @Override
    public int clean() {
        int numShippingsCanceled = 0;
        for(int i = 0 ; i < this.shippingsCurrentSize; i++){
            if( this.shippings[i].getShipmentStatus().equals(ShipmentStatus.CANCELLED)){
                try {
                    boolean removeShipping = this.removeShipping((IShipping)this.shippings[i]);
                    numShippingsCanceled++;
                } catch (OrderException ex) {
                    // nao sei fazer aqui!
                    //OrderException(OrderException.shippmentError);
                }
            }
        }
        return numShippingsCanceled;
    }

    @Override
    public void validate() throws OrderException, ContainerException, PositionException {
        for(int i = 0 ; i < this.shippingsCurrentSize; i++){
           ((Shipping) this.shippings[i]).validate();
        }        
    }

    @Override
    public void close() throws OrderException, ContainerException, PositionException {
        this.validate();

        for(int i = 0 ; i < this.shippingsCurrentSize; i++){
            if(this.shippings[0].getShipmentStatus() != ShipmentStatus.RECEIVED){
                ((Shipping) this.shippings[0]).setShipmentStatus(ShipmentStatus.CANCELLED);
            }
        }
    }

    @Override
    public boolean isClosed() {
        return this.isClosed == true;
    }

       
    @Override
    public double getCost() {
        double totalOfCost = 0;
        
        for(int i = 0 ; i < this.shippingsCurrentSize; i++){
            if(this.shippings[i].getShipmentStatus() == ShipmentStatus.RECEIVED ){
                totalOfCost += this.shippings[i].getCost();
            }
        }
       return totalOfCost;
    }

        //------------------------------------------------------------------------------------------------------------------------ FALTA FAZER SUMMARY
    @Override
    public String summary() {
        String orderText = "";
        
        for(int i = 0 ; i < this.shippingsCurrentSize; i++){
            orderText += "\n\n";
            orderText += "------------------------------------------- ShippingNo:" + i+1;
            for(int j = 0 ; j < this.shippings[i].getContainers().length; j++){
                orderText += "- - - - - - - - - - - - - - - - - - - - - -  ContainerNo:" + j+1;
                for(int k = 0 ; k < this.shippings[i].getContainers()[j].getPackedItems().length; k ++){
                    orderText += this.shippings[i].getContainers()[j].getPackedItems()[k].getItem().getReference();
                    orderText += this.shippings[i].getContainers()[j].getPackedItems()[k].getItem().getDescription();
                }
            }
        }

        return orderText;
    }

    @Override
    public int getNumberOfItems() {
        return this.itemsCurrentSize;
    }

    @Override
    public int getNumberOfRemaingItemsToSend() {
        int numberOfRemaingItemsToSend = 0 ;

        for(int i = 0 ; i < this.shippings.length; i++){
            if(this.shippings[i].getShipmentStatus() != ShipmentStatus.SHIPPED && this.shippings[i].getShipmentStatus() != ShipmentStatus.RECEIVED){
                for(int j = 0 ; j < this.shippings[i].getContainers().length; i++){
                    numberOfRemaingItemsToSend += this.shippings[i].getContainers()[j].getNumberOfItems();
                }
            }
        }
        
        return numberOfRemaingItemsToSend + this.itemsCurrentSize;
    }


    @Override
    public IItem[] getRemainingItemsToSend() {
        int ArrSize = getNumberOfRemaingItemsToSend();
        IItem[] itemsArr = new IItem[ArrSize];
        int numItemsAdded = 0 ;
        
        for(int i = 0 ; i < this.shippings.length; i++){
            if(this.shippings[i].getShipmentStatus() != ShipmentStatus.SHIPPED && this.shippings[i].getShipmentStatus() != ShipmentStatus.RECEIVED){
                for(int j = 0 ; j < this.shippings[i].getContainers().length; i++){
                    for(int k = 0 ; k < this.shippings[i].getContainers()[j].getNumberOfItems(); k++){
//                                String itemRefAux = this.shippings[i].getContainers()[j].getReference();
                                itemsArr[numItemsAdded++] =  this.shippings[i].getContainers()[j].getPackedItems()[k].getItem();
                   }
                        
                }
            }
        }
        return itemsArr;
    }
    
}
