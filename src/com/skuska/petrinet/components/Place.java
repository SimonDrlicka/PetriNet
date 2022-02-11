package com.skuska.petrinet.components;

public class Place extends Component{
    private int tokens;

    public Place(String id){
        super(id);
    }

    @Override
    public void addFrom(Component c) throws ComponentNotFound {
        if(! (c instanceof Transition))
            throw new ComponentNotFound("Wrong instance type");
        from.add(c);
    }
    public void reduce(){
        tokens--;
    }
    public void add(){
        tokens++;
    }

    @Override
    public void addTo(Component c) throws ComponentNotFound {
        if(! (c instanceof Transition))
            throw new ComponentNotFound("Wrong instance type");
        to.add(c);
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
