import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class problem9 {


        public static void main(String[] args) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("F:\\MaryamWork\\University\\4th term2\\Theory of compution\\Assignmenta\\Assignment1.1\\Assignment1\\problem9file.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("output1.txt"));
                ValidURL(reader, writer, 1); // Assuming the line numbering starts from 1
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void ValidURL(BufferedReader reader, BufferedWriter writer, int lineNumber) throws IOException {
            String line;
            int urlCount = 0;
            while ((line = reader.readLine()) != null) {
                String regex = "(https?://\\S+)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    urlCount++;
                    writer.write("URL #" + urlCount + ": " + matcher.group() + "\n");
                    writer.write("Line: " + lineNumber + "\n");
                    writer.write("Start index: " + matcher.start() + ", End index: " + matcher.end() + "\n\n");
                }
                lineNumber++;
            }
            writer.write("x\n");
        }
    }

