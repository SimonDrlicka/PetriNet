package com.skuska.petrinet;

import com.skuska.petrinet.components.Component;
import com.skuska.petrinet.components.ComponentNotFound;
import com.skuska.petrinet.components.Place;
import com.skuska.petrinet.components.Transition;
import com.skuska.petrinet.edges.Edge;
import com.skuska.petrinet.edges.EdgeException;

import java.util.ArrayList;

public class PetriNet {
    private String name;
    private ArrayList<Place> places;
    private ArrayList<Transition> transitions;
    private ArrayList<Integer> pz;
    private ArrayList<Edge> edges;

    public PetriNet(){
        places = new ArrayList<>();
        transitions = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public PetriNet addComponent(Component c){
        if(c instanceof Place){
            places.add((Place)c);
        }else{
            transitions.add((Transition) c);
        }

        return this;
    }

    public PetriNet runTransition(String id) throws ComponentNotFound {
        getTransition(id).run();
        update();
        return this;
    }
    private void update(){
        pz.clear();
        for (Place place : places) {
            pz.add(place.getTokens());
        }
    }

    public PetriNet addEdge(String from, String to) throws ComponentNotFound, EdgeException {
        return addEdge(from, to, 1);
    }
    public PetriNet addEdge(String from, String to, int multiplicity) throws ComponentNotFound, EdgeException {
        Component fr = getComponent(from);
        Component t = getComponent(to);
        edges.add(new Edge(fr, t, multiplicity));
        return this;
    }

    public void setPz(ArrayList<Integer> pz)throws PetriNetException{
        if(pz.size() != places.size())
            throw new PetriNetException("Wrong size of input array (arrays size must be equal to the sum of places)");
        this.pz = pz;
        for (int i = 0; i<this.pz.size(); i++){
            places.get(i).setTokens(this.pz.get(i));
        }
    }

    private Component getComponent(String id) throws ComponentNotFound {
        try{
            return getPlace(id);
        } catch (ComponentNotFound componentNotFound) {
            try{
                return getTransition(id);
            }catch (ComponentNotFound componentNotFound1){
                throw new ComponentNotFound("Component not found" + id);
            }
        }
    }
    private Place getPlace(String id) throws ComponentNotFound {
        for (Place p: places){
            if(p.getId().equals(id)){
                return p;
            }
        }
        throw new ComponentNotFound(id);
    }
    private Transition getTransition(String id) throws ComponentNotFound {
        for (Transition t: transitions) {
            if(t.getId().equals(id)){
                return t;
            }
        }
        throw new ComponentNotFound(id);
    }

    public ArrayList<Integer> getPz() {
        return pz;
    }
}
