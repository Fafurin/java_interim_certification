import java.util.Date;

public class Raffle {

    private String filename = "Raffle";
    private final ToyFactory toyFactory;
    private final FileHandler fileHandler;

    private int roundQuantity = 20;

    public Raffle(ToyFactory toyFactory, FileHandler fileHandler) {
        this.toyFactory = toyFactory;
        this.fileHandler = fileHandler;
    }

    public void setRoundQuantity(int quantity) {
        this.roundQuantity = quantity;
    }

    private StringBuilder getRaffle() {

        float legoChance = this.toyFactory.createToy(ToyType.LEGO).getChance();
        float carChance = this.toyFactory.createToy(ToyType.CAR).getChance();
        float dollChance = this.toyFactory.createToy(ToyType.DOLL).getChance();
        float fluffyChance = this.toyFactory.createToy(ToyType.FLUFFY).getChance();

        StringBuilder result = new StringBuilder();

        String prize = "Поздравляем! Ваш приз: ";

        result.append("Дата и время тиража: ").append(new Date()).append("\n");

        for (int i = 1; i < this.roundQuantity + 1; i++) {
            int rnd = (int) (Math.random() * 100);

            result.append("Раунд: ").append(i).append("\n");

            if (rnd > 0 && rnd < 1 + legoChance) {

                result.append(prize).append(this.toyFactory.createToy(ToyType.LEGO)).append("\n");

            } else if (rnd >= 1 + legoChance && rnd < 1 + legoChance + carChance) {

                result.append(prize).append(this.toyFactory.createToy(ToyType.CAR)).append("\n");

            } else if (rnd >= 1 + legoChance + carChance && rnd < 1 + legoChance + carChance + dollChance) {

                result.append(prize).append(this.toyFactory.createToy(ToyType.DOLL)).append("\n");

            } else if (rnd >= 1 + legoChance + carChance + dollChance && rnd < 1 + legoChance + carChance + dollChance + fluffyChance) {

                result.append(prize).append(this.toyFactory.createToy(ToyType.FLUFFY)).append("\n");

            } else result.append("К сожалению, вы ничего не выиграли!").append("\n");
        }
        return result;
    }

    public void saveResult() {
        StringBuilder stringBuilder = this.getRaffle();
        String result = String.valueOf(stringBuilder);

        this.fileHandler.saveToFile(filename, result);
    }

    public void printResult() {
        this.fileHandler.readFile(filename);
    }

}
