package com.skuska.petrinet.edges;

import com.skuska.petrinet.components.*;


public class Edge {
    //class variables
    private final Component from;
    private final Component to;

    private final int multiplicity;
    private final int type;
    //Edge types
    public static int NORMAL = 0;
    public static int RESET = 1;

    public Edge(Component from, Component to, int multiplicity) throws EdgeException {
        this(from, to, multiplicity,NORMAL);
    }
    public Edge(Component from, Component to, int multiplicity, int edgeType) throws EdgeException {
        if((from instanceof Place && to instanceof Place)|| (from instanceof Transition && to instanceof Transition) ){
            throw new EdgeException("Edges can be only P-T or T-P");
        }
        if((edgeType == RESET)&&(!(from instanceof Place))){
            throw new EdgeException("Reset Edges can only be P-T not T-P");
        }

        this.from = from;
        this.to = to;
        this.multiplicity = multiplicity;
        this.type = edgeType;

        from.addEdge(this); //from je component (place, tr)
        to.addEdge(this); //to je component(place, tr)

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
    public int getType(){
        return type;
    }
}
