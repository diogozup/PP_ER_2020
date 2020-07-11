///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
////Class abstract VS class "normal"
//// "box" neste enunciado é abstract porq nunca se instancia
//package implementation;
//
//import java.util.Arrays;
//import java.util.Objects;
//import order.base.ICustomer;
//import order.base.IPerson;
//import order.base.OrderStatus;
////import order.exceptions.ContainerException;
////import order.exceptions.OrderException;
////import order.exceptions.PositionException;
//
//import exceptions.ContainerException;
//import exceptions.OrderException;
//import exceptions.PositionException;
//
//import order.packing.Color;
//import order.packing.IContainer;
//import order.packing.IItemPacked;
//import shippingorder.IShippingOrder;
////import shippingorder.IShippingOrder;
//
//
///**
// * Nome: Diogo Sá Tinoco de Magalhães Número: 8120336 Turma: turma1
// */
//public class ShippingOrder implements IShippingOrder {
//
//    private Container[] ic;
//    private int numOfContainers;
//    private IPerson destination;
//    private ICustomer customer;
//    private OrderStatus orderStatus = OrderStatus.AWAITS_TREATMENT;
//    private int Id;
//    private int numOfContainersMaximum = 20;
//
//    private double cost;
//
//            
//            
//    public ShippingOrder(IPerson destination, ICustomer customer) {
//        this.destination = destination;
//        this.customer = customer;
//        this.ic = new Container[numOfContainersMaximum];
//
//    }
//
//    @Override
//    public boolean addContainer(IContainer ic) throws OrderException, ContainerException {
//        //!1- comecar pelas excptions
//        //1.1 exption 1 do javadoc
//        if (ic == null) {
//            throw new ContainerException("parametro ic esta null");
//        }
//        //1.2 exption 2 do javadoc
//        if (ic.isClosed() == false) {
//            throw new ContainerException("Container ainda ta aberto dude!");
//        }
//        //1.3 excption "IN_TREATMENT"
//        if (this.orderStatus != OrderStatus.IN_TREATMENT) {
//            throw new OrderException("Order in treatment");
//        }
//
//        //!2- 
//        //2.1 fazer o return numero#2
//        if (this.existsContainer(ic)) {
//            return false;
//        }
//
//        //2.2 fazer o "return 1 do javadoc"
//        if (this.numOfContainers == this.numOfContainersMaximum) {
//            this.numOfContainersMaximum += 20;
//
//            Container[] container_aux = new Container[numOfContainersMaximum];
//
//            for (int j = 0; j < this.numOfContainers; j++) {
//                container_aux[j] = this.ic[j];
//            }
//
//            this.ic = container_aux;
//        }
//
//        this.ic[numOfContainers] = (Container) ic;
//        numOfContainers++;
//
//        return true;
//    }
//
//    @Override
//    public boolean removeContainer(IContainer ic) throws OrderException, ContainerException {
//        //1- fazer as expcoes
//        //1.1- ContainerException - if the parameter is null
//        if (ic == null) {
//            throw new ContainerException("container esta null.");
//        }
//        //1.2- OrderException - if the status is not IN_TREATMEN
//        if (this.orderStatus != OrderStatus.IN_TREATMENT) {
//            throw new OrderException("Order nao esta em IN_TREAMENT");
//        }
//
//        //1.3- false if the container doesn't exists in the shipping order.
//        if (this.existsContainer(ic) == false) {
//            return false;
//        }
//
//        //1.4- fazer o remove
//        int indexContainerFound = this.findContainer(ic.getReference());
//
//        for (int j = indexContainerFound; j < numOfContainers - 1; j++) {
//            this.ic[j] = this.ic[j + 1];
//        }
//
//        this.numOfContainers--;
//        this.ic[numOfContainers] = null;
//        return true;
//    }
//
//    @Override
//    public boolean existsContainer(IContainer ic) {
//        for (int i = 0; i < this.numOfContainers; i++) {
//            if (ic.equals(this.ic[i])) {
//                // ja existe este container 
//                return true;
//            }
//        }
//        return false;
//    }
//
////    @Override
////    public int hashCode() {
////        int hash = 7;
////        return hash;
////    }
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final ShippingOrder other = (ShippingOrder) obj;
//        if (this.Id != other.Id) {
//            return false;
//        }
//        if (!Arrays.deepEquals(this.ic, other.ic)) {
//            return false;
//        }
//        if (!Objects.equals(this.destination, other.destination)) {
//            return false;
//        }
//        if (!Objects.equals(this.customer, other.customer)) {
//            return false;
//        }
//        if (this.orderStatus != other.orderStatus) {
//            return false;
//        }
//        return true;
//    }
//
//    //------------------------------------------------------
//    @Override
//    public int findContainer(String string) {
//        for (int i = 0; i < this.numOfContainers; i++) {
//            if (string.equals(this.ic[i].getReference())) {
//                //ENCONTROU REF DESTE CONTAINER NO SHIPPINGORDER
//                return i;
//            }
//        }
//        return -1;
//
//    }
//
//    @Override
//    public IPerson getDestination() {
//        return this.destination;
//    }
//
//    @Override
//    public void setDestination(IPerson ip) {
//        this.destination = (Person) ip;
//    }
//
//    @Override
//    public ICustomer getCustomer() {
//        return this.customer;
//    }
//
//    @Override
//    public OrderStatus getStatus() {
//        return this.orderStatus;
//    }
//
//    @Override
//    public void setStatus(OrderStatus os) throws OrderException, ContainerException, PositionException {
////        this.orderStatus = os;
//        if (os == OrderStatus.IN_TREATMENT && this.getStatus() != OrderStatus.AWAITS_TREATMENT) {
//            //--
//            throw new OrderException("order status errado");
//
//        }
//
//        if (os == OrderStatus.CLOSED && (this.getStatus() != OrderStatus.IN_TREATMENT || (this.numOfContainers == 0))) {
//            //--
//            throw new OrderException("order status issue");
//        }
//
//        if (os == OrderStatus.SHIPPED && this.getStatus() != OrderStatus.CLOSED) {
//            //--
//            throw new OrderException("order status wrong");
//
//        }
//
//        this.validate();
//        this.orderStatus = os;
//
//    }
//
//    @Override
//    public int getId() {
//        return this.Id;
//    }
//
//    @Override
//    public IContainer[] getContainers() {
//
//        IContainer[] container1 = new Container[this.numOfContainers];
//        for (int i = 0; i < this.numOfContainers; i++) {
//            container1[i] = ic[i];
//
//        }
//        return container1;
//    }
//
//    @Override
//    public void validate() throws ContainerException, PositionException {
//
//        for (int i = 0; i < numOfContainers; i++) {
//            this.ic[i].validate();
//        }
//
//    }
//
//    @Override
//    public String toString() {
//        return "ShippingOrder{" + "ic=" + ic + ", numOfContainers=" + numOfContainers + ", destination=" + destination + ", customer=" + customer + ", orderStatus=" + orderStatus + ", Id=" + Id + ", numOfContainersMaximum=" + numOfContainersMaximum + '}';
//    }
//
//    //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  ESTOU AQUI
//    @Override
//    public String summary() {
//
//        //String text = "ShippingOrder{\n 'orderId:'" + Id + "";
//        String container = "ShippingOrder: " + this.Id + "\n"
//                + "\tContainers: \n";
//
//        for (int j = 0; j < this.numOfContainers; j++) {
//            container += "___________________________________________________________________________________________________________________\n"
//                    + "\t\tItemReference: " + this.ic[j].getPackedItems()[j].getItem().getReference() + "\n"
//                    + "\t\tNum of Items: " + this.ic[j].getNumberOfItems() + "\n"
//                    + "\t\tOccupiedVolume: " + this.ic[j].getOccupiedVolume() + "\n"
//                    + "\t\tDepth: " + this.ic[j].getDepth() + "\n"
//                    + "\t\tHeight: " + this.ic[j].getHeight() + "\n"
//                    + "\t\tLenght: " + this.ic[j].getLenght() + "\n"
//                    + "\t\tisClosed: " + this.ic[j].isClosed() + "\n"
//                    + "\t\tReference: " + this.ic[j].getReference() + "\n"
//                    + "\t\tColor: " + this.ic[j].getColor() + "\n"
//                    + "\t\tColorEdge: " + this.ic[j].getColorEdge() + "\n"
//                    + "\t\tItems: \n";
//            for (int i = 0; i < this.ic[0].getNumberOfItems(); i++) {
//                container += "\t\t\t---------------------------------------------------------------------------------------\n"
//                        + "\t\t\tItemReference: " + this.ic[j].getPackedItems()[i].getItem().getReference() + "\n"
//                        + "\t\t\tItemDescription: " + this.ic[j].getPackedItems()[i].getItem().getDescription() + "\n"
//                        + "\t\t\tItemDepth: " + this.ic[j].getPackedItems()[i].getItem().getDepth() + "\n"
//                        + "\t\t\tItemHeight: " + this.ic[j].getPackedItems()[i].getItem().getHeight() + "\n"
//                        + "\t\t\tItemLenght: " + this.ic[j].getPackedItems()[i].getItem().getLenght() + "\n"
//                        + "\t\t\tItemVolume: " + this.ic[j].getPackedItems()[i].getItem().getVolume() + "\n";
//            }
//        }
//        return container;
//    }
//
//    
//    
//    //-------------------------------------------------------- POSSIVEIS PERGUNTAS DEFESA --------------------------------------------------------
//    //1- return todos containers de cor red
//    //2- return da posicao dum item dentro duma shipping order algures num container
//    
//    //1___________________________________________________________________________________________
//    public Container[] containersWichAreColorRed(){
//        Container[] containers = new Container[this.numOfContainers];
//        int pos=0;
//
//        for(int i = 0 ; i < this.numOfContainers ; i++){
//            if(this.ic[i].getColor() == Color.red){
//                containers[pos] = ic[i];
//                pos++;
//                }
//        }
//        return containers;
//    }
//    
//    public int getNumOfContainers(){
//        return this.numOfContainers;
//    }
//    
//    //2___________________________________________________________________________________________
//    public Item findPositionOfItemInShippingOrder(){
//        
//        int smallSize = 0 ;
//        Item item1 = null; 
//        
//
//        for(int i = 0 ; i < this.numOfContainers; i++){
//            IItemPacked[] arrItems = ic[i].getPackedItems();
//            
//            
//            for(int j =0 ; j < arrItems.length ; j++){
//                smallSize = arrItems[j].getItem().getVolume();
//                item1 = (Item) arrItems[j].getItem();
//                
//                if (arrItems[j].getItem().getVolume() < smallSize){
//                    smallSize = arrItems[j].getItem().getVolume();
//                    item1 = (Item)arrItems[j].getItem();
//                }
//
//            } 
//            
//        }
//
//        return item1;
//    }
//   
//    
//    
//    
//    
//    
//    
//    
//    
//}
//
