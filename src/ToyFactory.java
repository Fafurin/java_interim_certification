public class ToyFactory {

    private Toy toy;

    public Toy createToy(ToyType type) {
        switch (type) {
            case FLUFFY -> toy = new Fluffy();
            case DOLL -> toy = new Doll();
            case CAR -> toy = new Car();
            case LEGO -> toy = new Lego();
        }
        return toy;
    }

}
