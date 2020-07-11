/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package implementation;

import exceptions.PositionException;
import order.packing.IPosition;

/**
 * Nome: Diogo Sá Tinoco de Magalhães
 * Número: 8120336
 * Turma: turma1
 */
public class Position implements IPosition{
    
    private int x;
    private int y;
    private int z;

    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    
    
    
    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getZ() {
        return this.z;
    }

    @Override
    public void setX(int i) throws PositionException {
        if (i < 0){
            throw new PositionException("Valor de X tem que ser maior que 0");
        }
        this.x = i ;
    }

    @Override
    public void setY(int i) throws PositionException {
        if (i < 0){
            throw new PositionException("Valor de Y tem que ser maior que 0");
        }
        this.y = i ;
    }

    @Override
    public void setZ(int i) throws PositionException {
        if (i < 0){
            throw new PositionException("Valor de Z tem que ser maior que 0");
        }
        this.z = i ;
    }

    
    // address - postion -- person -         -----> fazer o "toString" e "Equals"
    
    
    
}
