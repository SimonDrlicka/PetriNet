package com.skuska.petrinet.components;

import com.skuska.petrinet.edges.Edge;

import java.util.ArrayList;

public class Transition extends Component{

    public Transition(String id) {
        super(id);
        from = new ArrayList<>();
        to = new ArrayList<>();
    }
    public void run(){
        for (Component c: from){
            ((Place) c).reduce();
        }
        for(Component c: to){
            ((Place) c).add();
        }
    }
    public void addFrom(Component c) throws ComponentNotFound {
        if(! (c instanceof Place))
            throw new ComponentNotFound("Wrong instance type");
        from.add(c);
    }

    @Override
    public void addTo(Component c) throws ComponentNotFound {
        if(! (c instanceof Place))
            throw new ComponentNotFound("Wrong instance type");
        to.add(c);
    }
}
