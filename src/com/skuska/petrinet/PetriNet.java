package com.skuska.petrinet;

import com.skuska.petrinet.components.Component;
import com.skuska.petrinet.components.ComponentNotFound;
import com.skuska.petrinet.components.Place;
import com.skuska.petrinet.components.Transition;
import com.skuska.petrinet.edges.Edge;
import com.skuska.petrinet.edges.EdgeException;

import java.util.ArrayList;

public class PetriNet {
    private final ArrayList<Place> places;
    private final ArrayList<Transition> transitions;
    private ArrayList<Integer> tokens;
    private final ArrayList<Edge> edges;

    public PetriNet(){
        places = new ArrayList<>();
        transitions = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public PetriNet addPlace(String id){
        addComponent(new Place(id));
        return this;
    }
    public PetriNet addTransition(String id){
        addComponent(new Transition(id));
        return this;
    }
    private void addComponent(Component c){
        if(c instanceof Place){
            places.add((Place)c);
        }else{
            transitions.add((Transition) c);
        }
    }

    public PetriNet runTransition(String id) throws ComponentNotFound {
        getTransition(id).run();
        update();
        return this;
    }
    private void update(){
        tokens.clear();
        for (Place place : places) {
            tokens.add(place.getTokens());
        }
    }

    public PetriNet addEdge(String from, String to) throws ComponentNotFound, EdgeException {
        return addEdge(from, to, 1);
    }
    public PetriNet addEdge(String from, String to, int multiplicity) throws ComponentNotFound, EdgeException {

        Component fr = getComponent(from);
        Component t = getComponent(to);
        Edge e = new Edge(fr, t, multiplicity);
        edges.add(e);
        return this;

    }


    public PetriNet addResetEdge(String from, String to) throws ComponentNotFound, EdgeException {
        edges.add(new Edge(getComponent(from), getComponent(to), 1, Edge.RESET));
        return this;
    }

    public void setTokens(ArrayList<Integer> tokens)throws PetriNetException{
        if(tokens.size() != places.size())
            throw new PetriNetException("Wrong size of input array (arrays size must be equal to the sum of places)");
        this.tokens = tokens;
        for (int i = 0; i<this.tokens.size(); i++){
            places.get(i).setTokens(this.tokens.get(i));
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
    public Place getPlace(String id) throws ComponentNotFound {
        for (Place p: places){
            if(p.getId().equals(id)){
                return p;
            }
        }
        throw new ComponentNotFound(id);
    }
    public Transition getTransition(String id) throws ComponentNotFound {
        for (Transition t: transitions) {
            if(t.getId().equals(id)){
                return t;
            }
        }
        throw new ComponentNotFound(id);
    }

    public ArrayList<Integer> getTokens() {
        return tokens;
    }

}
