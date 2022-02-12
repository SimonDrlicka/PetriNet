package com.skuska.petrinet.components;

import com.skuska.petrinet.edges.Edge;

import java.util.ArrayList;

public abstract class Component {
    protected String id;
    protected ArrayList<Edge> edges;
    Component(String id){
        edges = new ArrayList<>();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract void addEdge(Edge e);

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return id;
    }
}
