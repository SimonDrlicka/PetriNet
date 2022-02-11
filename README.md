# PetriNet
Petri siete s možnosťou pridavania hran, miest a prechodov s moznostou spustania prechodov

## Pridavanie miest a prechodov
* Pridavanie miest a prechodov do siete pomocou metody addComponent.
Napr. addComponent(new Place(String id)) alebo new Transition(String id)
* Pomocou metod addPlace(String id) a addTransition(String id)

## Nastavenie počiatočného značkovania
Pomocou metódy setTokens(ArrayList<Integer>), tento ArrayList musí obsahovat presný počet prvkov ako je počet Places PetrihoSiete


## Spustanie prechodov
Pomocou metody runTransition(String id)

## Vypisanie aktualneho znackovania
Pomocou metody getTokens()
