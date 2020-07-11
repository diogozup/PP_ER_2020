/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import exceptions.ContainerException;
import java.util.Arrays;
import java.util.Objects;
import exceptions.PositionException;
import order.packing.Color;
import order.packing.IContainer;
import order.packing.IItem;
import order.packing.IItemPacked;
import order.packing.IPosition;

/**
 * Nome: Diogo Sá Tinoco de Magalhães Número: 8120336 Turma: turma1
 */
public class Container extends Box implements IContainer {

    private ItemPacked[] ip;
    private int numberOfItems;
    private int occupiedVolume;
    private String reference;
    private boolean isClosed;
    private Color color; //esta no enunciado e nao no javadoc
    private Color colorEdge; //esta no enunciado e nao no javadoc
    private int numberOfItemsMaximum = 15; // fui eu que escolhi "15" random..

//    public Container(String reference) {
//        this.numberOfItems = 0;
//        this.occupiedVolume = 0;
//        this.reference = reference;
//        this.isClosed = false;
//    }
    public Container(String reference, Color color, Color colorEdge, int depth, int height, int length) {
        super(depth, height, length);
        this.ip = new ItemPacked[numberOfItemsMaximum];
        this.reference = reference;
        this.color = color;
        this.colorEdge = colorEdge;
    }

    @Override
    public boolean addItem(IItem iitem, IPosition ip, Color color) throws ContainerException {
        //!1- comecar pelas excptions
        //1.1 exption 1 do javadoc
        if (iitem == null || ip == null || color == null) {
            throw new ContainerException("Algum parametro esta a nul");
        }
        //1.2 exption 2 do javadoc
        if (this.isClosed) {
            throw new ContainerException("Container ja ta fechado dude!");
        }

        //!2- 
        //2.1 fazer o return numero#2
        if (this.getItem(iitem.getReference()) != null) {
            return false;
        }

        //2.2 fazer o return numero#1 do javadoc
        // dar aqui o insert
        if (this.numberOfItems == this.numberOfItemsMaximum) {
            //dizer q ta full e aumenta capacidade
            //expandCapacity();

            this.numberOfItemsMaximum += 10;

            ItemPacked[] new_ip = new ItemPacked[this.numberOfItemsMaximum];
            for (int i = 0; i < this.numberOfItems; i++) {
                new_ip[i] = this.ip[i];

            }
        }
        ItemPacked itempacked_aux = new ItemPacked(color, (Item) iitem, (Position) ip);
        this.ip[numberOfItems] = itempacked_aux;
        this.numberOfItems++;
        this.occupiedVolume += iitem.getVolume();
        return true;

    }

    @Override
    public boolean removeItem(IItem iitem) throws ContainerException {
        //ESTOU AQUI***
        //1- fazer as expcoes
        //1.1- parametros null
        if (iitem == null) {
            throw new ContainerException("iitem esta null.");
        }
        //1.2- container is closed
        if (this.isClosed == true) {
            throw new ContainerException("Container is closed.");
        }

        //2.1 return numero#2
        if (this.getItem(iitem.getReference()) == null) {
            return false;
        }

        //!!!.... REMOVE FOI MELHORADO COM A DICA DO PROF FABIO SILVA AQUI EM BAIXO .......................
        
        
        //2.2 return numero#1
        for (int i = 0; i < this.numberOfItems-1; i++) {
            if (iitem.getReference().equals(this.ip[i].getItem().getReference())) {
                ip[i] = ip[i + 1];
            }
        }
        this.numberOfItems--;
        this.occupiedVolume -= iitem.getVolume();
        return true;

    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    //mtdo equals criado por mim 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Container other = (Container) obj;
        if (this.numberOfItems != other.numberOfItems) {
            return false;
        }
        if (this.occupiedVolume != other.occupiedVolume) {
            return false;
        }
        if (this.isClosed != other.isClosed) {
            return false;
        }
        if (this.numberOfItemsMaximum != other.numberOfItemsMaximum) {
            return false;
        }
        if (!Objects.equals(this.reference, other.reference)) {
            return false;
        }
        if (!Arrays.deepEquals(this.ip, other.ip)) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        if (this.colorEdge != other.colorEdge) {
            return false;
        }
        return true;
    }

    @Override
    public void validate() throws ContainerException, PositionException {
        //1 exepcoes
        //1.1 containerexception 
        if (this.occupiedVolume > this.getVolume()) {
            throw new ContainerException("Volume é maior que capacidade max");
        }
        //1.2 positionExcption
        //--dimensoes do container
        for (int i = 0; i < this.numberOfItems; i++) {
            if (ip[i].getPosition().getX() + ip[i].getItem().getLenght() > this.getLenght()) {
                //Esta dentro em termos de lenght;                
                throw new PositionException("Este item ultrapassa o limite do container na coordenada X");
            }
            if (ip[i].getPosition().getY() + ip[i].getItem().getHeight() > this.getHeight()) {
                //Esta dentro em termos de height;
                throw new PositionException("Este item ultrapassa o limite do container na coordenada Y");
            }
            if (ip[i].getPosition().getZ() + ip[i].getItem().getDepth() > this.getDepth()) {
                //Esta dentro em termos de depth;
                throw new PositionException("Este item ultrapassa o limite do container na coordenada Z");
            }
        }

        for (int i = 0; i < this.numberOfItems; i++) {
            int x1min = ip[i].getPosition().getX();
            int x1max = ip[i].getPosition().getX() + ip[i].getItem().getLenght();

            int y1min = ip[i].getPosition().getY();
            int y1max = ip[i].getPosition().getY() + ip[i].getItem().getHeight();

            int z1min = ip[i].getPosition().getZ();
            int z1max = ip[i].getPosition().getZ() + ip[i].getItem().getDepth();

            for (int j = 0; j < this.numberOfItems; j++) {
                if (i != j) {
                    //para nao verificar o item se esta sobreposto em si mesmo
                    int x2min = ip[j].getPosition().getX();
                    int x2max = ip[j].getPosition().getX() + ip[j].getItem().getLenght();

                    int y2min = ip[j].getPosition().getY();
                    int y2max = ip[j].getPosition().getY() + ip[j].getItem().getHeight();

                    int z2min = ip[j].getPosition().getZ();
                    int z2max = ip[j].getPosition().getZ() + ip[j].getItem().getDepth();

                    if (x1min < x2max && x2min < x1max && y1min < y2max && y2min < y1max && z1min < z2max && z2min < z1max) {
                        //verifica se item i sobrepoe a item j
                        throw new PositionException("Item sobrepoe outro item");
                    }
                }

            }

        }

    }

    @Override
    public void close() throws ContainerException, PositionException {
        this.validate();
        this.isClosed = true;
    }

    @Override
    public IItem getItem(String string) {
        String itemref = string;

        for (int i = 0; i < numberOfItems; i++) {
            if (itemref.equals(ip[i].getItem().getReference())) {
                //encontrei e devolvo o item mas antes dou cast.. 
                return (IItem) ip[i].getItem();
            }
        }

        return null;

    }

    @Override
    public int getOccupiedVolume() {
        return this.occupiedVolume;
    }

    @Override
    public IItemPacked[] getPackedItems() {
        //return (IItemPacked[]) this.ip;
        IItemPacked[] ip = new IItemPacked[this.numberOfItems];
        for(int i = 0 ; i < this.numberOfItems; i++){
            ip[i] = this.ip[i];
        }
        
        return ip; //retorna a iterface.. tem os mtds daquela interface por iss q n precsa d cast. so precisa em SETTERS
    }

    @Override
    public String getReference() {
        return this.reference;
    }

    @Override
    public int getNumberOfItems() {
        return this.numberOfItems;
    }

    @Override
    public int getRemainingVolume() {
        return super.getVolume() - this.occupiedVolume;
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }

    @Override
    public int getDepth() {
        return super.getDepth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public int getLenght() {
        return super.getLenght();
    }

    @Override
    public int getVolume() {
        return super.getVolume();
    }

    @Override
    public Color getColorEdge() {
        return this.colorEdge;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setColorEdge(Color color) {
        this.colorEdge = color;
    }

}
