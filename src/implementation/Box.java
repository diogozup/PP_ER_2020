/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implementation;

import order.packing.IBox;

/**
 * Nome: Diogo Sá Tinoco de Magalhães
 * Número: 8120336
 * Turma: turma1
 */
public class Box implements IBox{

    private int depth;
    private int height;
    private int length;

    /**
     *
     * @param depth
     * @param height
     * @param length
     */
    public Box(int depth, int height, int length) {
        this.depth = depth;
        this.height = height;
        this.length = length;
    }

    /**
     * Getter for depth
     * @return depth
     */
    @Override
    public int getDepth() {
        return this.depth;
    }

    /**
     * Getter for height
     * @return height
     */
    @Override
    public int getHeight() {
        return this.height;    
    }

    /**
     * Getter for lenght
     * @return
     */
    @Override
    public int getLenght() {
        return this.length;
    }

    /**
     * Getter for volume
     * @return
     */
    @Override
    public int getVolume() {
        return this.depth * this.length * this.height;
    }
    

}
