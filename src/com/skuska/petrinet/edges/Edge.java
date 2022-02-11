package com.skuska.petrinet.edges;

import com.skuska.petrinet.components.*;


public class Edge {
    private Component from;
    private Component to;
    private final int multiplicity;
    public Edge(Component from, Component to) throws EdgeException {
        if((from instanceof Place && to instanceof Place)|| (from instanceof Transition && to instanceof Transition) ){
            throw new EdgeException("Edges can be only P-T or T-P");
        }
        this.from = from;
        this.to = to;
        multiplicity = 1;
    }
    public Edge(Component from, Component to, int multiplicity) throws EdgeException {
        if((from instanceof Place && to instanceof Place)|| (from instanceof Transition && to instanceof Transition) ){
            throw new EdgeException("Edges can be only P-T or T-P");
        }
        this.from = from;
        this.to = to;
        this.multiplicity = multiplicity;
    }
}
