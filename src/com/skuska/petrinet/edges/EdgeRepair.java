package com.skuska.petrinet.edges;

import com.skuska.petrinet.components.Component;

public class EdgeRepair {
    private Component c;
    private int multiplicity;

    public EdgeRepair(Component c, int multiplicity){
        this.c = c;
        this.multiplicity = multiplicity;
    }

}
