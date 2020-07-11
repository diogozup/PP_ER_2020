/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import order.base.ICustomer;
import order.base.IPerson;
import exceptions.ContainerException;
import exceptions.OrderException;
import exceptions.PositionException;
import order.management.IShipping;
import order.management.ShipmentStatus;
import order.packing.IContainer;

import implementation.Management;

/**
 *
 * @author rubenmiguelcunhasimoes
 */
public class Shipping implements IShipping {
    
    private Container[] ic;
    private int numOfContainers;
    private IPerson destination;
    private ICustomer customer;
    private ShipmentStatus shipmentStatus = ShipmentStatus.AWAITS_TREATMENT;
    private int Id;
    private int numOfContainersMaximum = 20;

    private double cost;

    @Override
    public boolean addContainer(IContainer ic) throws OrderException, ContainerException {
        //!1- comecar pelas excptions
        //1.1 exption 1 do javadoc
        if (ic == null) {
            throw new ContainerException("parametro ic esta null");
        }
        //1.2 exption 2 do javadoc
        if (ic.isClosed() == false) {
            throw new ContainerException("Container ainda ta aberto dude!");
        }
        //1.3 excption "IN_TREATMENT"
        if (this.shipmentStatus != ShipmentStatus.IN_TREATMENT) {
            throw new OrderException("Order in treatment");
        }

        //!2- 
        //2.1 fazer o return numero#2
        if (this.existsContainer(ic)) {
            return false;
        }

        //2.2 fazer o "return 1 do javadoc"
        if (this.numOfContainers == this.numOfContainersMaximum) {
            this.numOfContainersMaximum += 20;

            Container[] container_aux = new Container[numOfContainersMaximum];

            for (int j = 0; j < this.numOfContainers; j++) {
                container_aux[j] = this.ic[j];
            }

            this.ic = container_aux;
        }

        this.ic[numOfContainers] = (Container) ic;
        numOfContainers++;

        return true;

    }

    @Override
    public boolean removeContainer(IContainer ic) throws OrderException, ContainerException {
        //1- fazer as expcoes
        //1.1- ContainerException - if the parameter is null
        if (ic == null) {
            throw new ContainerException("container esta null.");
        }
        //1.2- OrderException - if the status is not IN_TREATMEN
        if (this.shipmentStatus != ShipmentStatus.IN_TREATMENT) {
            throw new OrderException("Order nao esta em IN_TREAMENT");
        }

        //1.3- false if the container doesn't exists in the shipping order.
        if (this.existsContainer(ic) == false) {
            return false;
        }

        //1.4- fazer o remove
        int indexContainerFound = this.findContainer2(ic.getReference());

        for (int j = indexContainerFound; j < numOfContainers - 1; j++) {
            this.ic[j] = this.ic[j + 1];
        }

        this.numOfContainers--;
        this.ic[numOfContainers] = null;
        return true;
    }
    
    public int findContainer2(String string) {
        for (int i = 0; i < this.numOfContainers; i++) {
            if (string.equals(this.ic[i].getReference())) {
                //ENCONTROU REF DESTE CONTAINER NO SHIPPINGORDER
                return i;
            }
        }
        return -1;

    }
        
    @Override
    public boolean existsContainer(IContainer ic) {
        for (int i = 0; i < this.numOfContainers; i++) {
            if (ic.equals(this.ic[i])) {
                // ja existe este container 
                return true;
            }
        }
        return false;
    }

    @Override
    public IContainer findContainer(String string) {
        for (int i = 0; i < this.numOfContainers; i++) {
            if (string.equals(this.ic[i].getReference())) {
                //ENCONTROU REF DESTE CONTAINER NO SHIPPINGORDER
                return ic[i];
            }
        }
        return null;
    }

    @Override
    public ShipmentStatus getShipmentStatus() {
        return this.shipmentStatus;
    }

    @Override
    public void setShipmentStatus(ShipmentStatus ss) throws OrderException, ContainerException, PositionException {
        //1
        if (ss == ShipmentStatus.IN_TREATMENT && this.getShipmentStatus() != ShipmentStatus.AWAITS_TREATMENT) {
            throw new OrderException("order status errado1");
        }
        //2
        if (ss == ShipmentStatus.CLOSED && (this.getShipmentStatus() != ShipmentStatus.IN_TREATMENT || (this.numOfContainers == 0))) {
            throw new OrderException("Shipment status issue2");
        }
        //3
        if (ss == ShipmentStatus.SHIPPED && this.getShipmentStatus() != ShipmentStatus.CLOSED) {
            throw new OrderException("Shipment status wrong3");
        }
        //4
        if (ss == ShipmentStatus.RECEIVED && this.getShipmentStatus() != ShipmentStatus.SHIPPED) {
            throw new OrderException("Shipment status wrong4");
        }        
        //5
        if (ss == ShipmentStatus.CANCELLED && this.getShipmentStatus() != ShipmentStatus.RECEIVED) {
            throw new OrderException("Shipment status wrong5");
        }        

        this.validate();
        this.shipmentStatus = ss;
    }

    @Override
    public IContainer[] getContainers() {
        return this.ic;
    }

    @Override
    public void validate() throws ContainerException, PositionException {
        for (int i = 0; i < numOfContainers; i++) {
            this.ic[i].validate();
        }
    }

    @Override
    public String summary() {
        //String text = "ShippingOrder{\n 'orderId:'" + Id + "";
        String container = "ShippingOrder: " + this.Id + "\n"
                + "\tContainers: \n";

        for (int j = 0; j < this.numOfContainers; j++) {
            container += "___________________________________________________________________________________________________________________\n"
                    + "\t\tItemReference: " + this.ic[j].getPackedItems()[j].getItem().getReference() + "\n"
                    + "\t\tNum of Items: " + this.ic[j].getNumberOfItems() + "\n"
                    + "\t\tOccupiedVolume: " + this.ic[j].getOccupiedVolume() + "\n"
                    + "\t\tDepth: " + this.ic[j].getDepth() + "\n"
                    + "\t\tHeight: " + this.ic[j].getHeight() + "\n"
                    + "\t\tLenght: " + this.ic[j].getLenght() + "\n"
                    + "\t\tisClosed: " + this.ic[j].isClosed() + "\n"
                    + "\t\tReference: " + this.ic[j].getReference() + "\n"
                    + "\t\tColor: " + this.ic[j].getColor() + "\n"
                    + "\t\tColorEdge: " + this.ic[j].getColorEdge() + "\n"
                    + "\t\tItems: \n";
            for (int i = 0; i < this.ic[0].getNumberOfItems(); i++) {
                container += "\t\t\t---------------------------------------------------------------------------------------\n"
                        + "\t\t\tItemReference: " + this.ic[j].getPackedItems()[i].getItem().getReference() + "\n"
                        + "\t\t\tItemDescription: " + this.ic[j].getPackedItems()[i].getItem().getDescription() + "\n"
                        + "\t\t\tItemDepth: " + this.ic[j].getPackedItems()[i].getItem().getDepth() + "\n"
                        + "\t\t\tItemHeight: " + this.ic[j].getPackedItems()[i].getItem().getHeight() + "\n"
                        + "\t\t\tItemLenght: " + this.ic[j].getPackedItems()[i].getItem().getLenght() + "\n"
                        + "\t\t\tItemVolume: " + this.ic[j].getPackedItems()[i].getItem().getVolume() + "\n";
            }
        }
        return container;
    
    }

    @Override
    public double getCost() {
        double totalCost=0;
        int totalVolumeOfContainers=0;
        double costPerUnit = Management.getPricePerCubicVolumeUnit() ;//n sei s ta certo como fiz
        
        for(int i = 0 ; i < this.numOfContainers; i++){
            totalVolumeOfContainers+= ic[i].getVolume();
        }
        
        
        totalCost = totalVolumeOfContainers * costPerUnit;
        return totalCost;
    }
    
}
