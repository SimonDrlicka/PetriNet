package com.skuska.petrinet.components;

import com.skuska.petrinet.edges.EdgeRepair;

import java.util.ArrayList;

public abstract class Component {
    protected String id;
    protected ArrayList<Component> from;
    protected ArrayList<Component> to;
    Component(String id){
        from = new ArrayList<>();
        to = new ArrayList<>();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract void addFrom(Component c) throws ComponentNotFound;
    public abstract void addTo(Component c) throws ComponentNotFound;


}
