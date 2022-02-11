package com.skuska.petrinet.components;

import com.skuska.petrinet.edges.Edge;

public class Place extends Component{
    private int tokens;

    public Place(String id){
        super(id);
    }

    @Override
    public void addEdge(Edge e) {
        edges.add(e);
    }


    public void reduce(int pocet){
        tokens -= pocet;
    }
    public void add(int pocet){
        tokens+=pocet;
    }


    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
