# PetriNet
Petri siete s možnosťou pridavania hran, miest a prechodov s moznostou spustania prechodov

## Pridavanie miest a prechodov
* Pridavanie miest a prechodov do siete pomocou metody addComponent.
Napr. addComponent(new Place(String id)) alebo new Transition(String id)
* Pomocou metod addPlace(String id) a addTransition(String id)

## Pridávanie hrán
Pomocou metód addEdge(String idFrom, String idTo, int multiplicity = 1) a addResetEdge(String from, String to)


## Nastavenie počiatočného značkovania
Pomocou metódy setTokens(ArrayList<Integer>), tento ArrayList musí obsahovat presný počet prvkov ako je počet Places PetrihoSiete


## Spustanie prechodov
Pomocou metody runTransition(String id)

## Vypisanie aktualneho znackovania
Pomocou metody getTokens()

### Priklad
```java
class Main{
    public static void main(String[] args) {
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
//Out: [2,5,1]
    }
}


```
