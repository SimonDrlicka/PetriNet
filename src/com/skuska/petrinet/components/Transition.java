package com.skuska.petrinet.components;

import com.skuska.petrinet.edges.Edge;

import java.util.ArrayList;

public class Transition extends Component{

    public Transition(String id) {
        super(id);
    }

    @Override
    public void addEdge(Edge e) {
        edges.add(e);
    }

    public void run(){
        if(isRunnable()){
            for(Edge e: edges){
                if(e.getTo() == this){
                    ((Place)e.getFrom()).reduce(e.getMultiplicity());
                    continue;
                }
                if(e.getFrom() == this){
                    ((Place)e.getTo()).add(e.getMultiplicity());
                }
            }
        }
    }
    private boolean isRunnable(){
        for(Edge e: edges){
            if(e.getTo() == this){
                if(((Place)e.getFrom()).getTokens() < e.getMultiplicity())
                    return false;
            }
        }
        return true;
    }

}
