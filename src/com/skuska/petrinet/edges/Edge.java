package com.skuska.petrinet.edges;

import com.skuska.petrinet.components.*;


public class Edge {
    private Component from;
    private Component to;
    private final int multiplicity;
    public Edge(Component from, Component to, int multiplicity) throws EdgeException {
        if((from instanceof Place && to instanceof Place)|| (from instanceof Transition && to instanceof Transition) ){
            throw new EdgeException("Edges can be only P-T or T-P");
        }
        this.from = from;
        this.to = to;
        this.multiplicity = multiplicity;
        from.addEdge(this);
        to.addEdge(this);
    }

    public Component getFrom() {
        return from;
    }

    public Component getTo() {
        return to;
    }

    public int getMultiplicity() {
        return multiplicity;
    }
}
