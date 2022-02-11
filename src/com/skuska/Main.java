package com.skuska;

import com.skuska.petrinet.PetriNet;
import com.skuska.petrinet.PetriNetException;
import com.skuska.petrinet.components.ComponentNotFound;
import com.skuska.petrinet.components.Place;
import com.skuska.petrinet.components.Transition;
import com.skuska.petrinet.edges.EdgeException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ComponentNotFound {
        PetriNet petriNet = new PetriNet();
        petriNet.addPlace("p1")
                .addPlace("p2")
                .addPlace("p3")
                .addTransition("t0")
                .addTransition("t1")
                .addTransition("t2")
                .addTransition("t3");
        try{
            petriNet.addEdge("p1", "t3")
                    .addEdge("t3", "p1",2)
                    .addEdge("p1", "t1")
                    .addEdge("p1", "t0")
                    .addEdge("t3", "p2")
                    .addEdge("p2", "t2")
                    .addEdge("t1", "p3")
                    .addEdge("t2", "p3")
                    .addEdge("p3", "t2")
                    .addEdge("p3", "t0");

        } catch (ComponentNotFound | EdgeException exception) {
            exception.printStackTrace();
        }
        try{
            petriNet.setTokens(new ArrayList<Integer>(){{
                add(1);
                add(0);
                add(0);
            }});

        }catch (PetriNetException e) {
            e.printStackTrace();
        }
        petriNet.runTransition("t3")
                .runTransition("t3")
                .runTransition("t3")
                .runTransition("t3")
                .runTransition("t3")
                .runTransition("t1")
                .runTransition("t1")
                .runTransition("t0")
                .runTransition("t0");


        System.out.println(petriNet.getTokens());
        System.out.println("Hotovo");

    }
}
