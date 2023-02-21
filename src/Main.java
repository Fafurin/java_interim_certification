public class Main {
    public static void main(String[] args) {

        ToyFactory toyFactory = new ToyFactory();

        FileHandler fileHandler = new FileHandler();

        Raffle raffle = new Raffle(toyFactory, fileHandler);

        raffle.setRoundQuantity(15);

        raffle.saveResult();

        raffle.printResult();

    }
}