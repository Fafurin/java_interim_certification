import java.io.*;

public class FileHandler {

    public void saveToFile(String filename, String content) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter = new FileWriter(filename, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
            printWriter.println(content);
            printWriter.close();
            System.out.println("Файл " + filename + " создан/дополнен.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (printWriter != null)
                printWriter.close();
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void readFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
