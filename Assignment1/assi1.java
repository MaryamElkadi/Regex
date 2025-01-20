import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class assi1 {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("F:\\MaryamWork\\University\\4th term2\\Theory of compution\\Assignmenta\\Assignment1.1\\Assignment1\\input.txt"));
            BufferedReader reader2 = new BufferedReader(new FileReader("F:\\MaryamWork\\University\\4th term2\\Theory of compution\\Assignmenta\\Assignment1.1\\Assignment1\\problem9file.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("end")) {
                    continue;
                }

                if (!line.matches("\\d+")) {
                   // writer.write("Invalid input: " + line + "\n");
                    continue;
                }

                int problemNumber = Integer.parseInt(line);
                switch (problemNumber) {
                    case 1:
                        validateEmails(reader, writer);
                        break;
                    case 2:
                        validatePhoneNumbers(reader, writer);
                        break;
                    case 3:
                        validateDates(reader, writer);
                        break;
                    case 4:
                        validateIPAddresses(reader,writer);
                        break;
                    case 5:
                        validateCppVariables(reader,writer);
                        break;
                    case 6:
                        validateNoTripleBStrings(reader,writer);
                        break;
                    case 7:
                        addAlpha(reader, writer);
                        break;
                    case 8:
                        validate3words(reader, writer);
                        break;
                    case 9:
                        ValidURL(reader2,writer,1);
                        break;
                    case 10:
                         ValidMathExpression(reader,writer);
                }
            }

            reader.close();
            reader2.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validateEmails(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        writer.write("1\n");
        while (!(line = reader.readLine()).equals("end")) {
            String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                writer.write("valid email\n");
            } else {
                writer.write("invalid email\n");
            }
        }
        writer.write("x\n");
    }

    private static void validatePhoneNumbers(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        writer.write("2\n");
        while (!(line = reader.readLine()).equals("end")) {
            String regex = "\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\)-\\d{3}-\\d{4}|\\d{3}\\.\\d{3}\\.\\d{4}|\\d{3} \\d{3} \\d{4}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                writer.write("valid phone number\n");
            } else {
                writer.write("invalid phone number\n");
            }
        }
        writer.write("x\n");
    }

    private static void validateDates(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        writer.write("3\n");
        while (!(line = reader.readLine()).equals("end")) {
            String regex = "(0?[1-9]|[12]\\d|3[01])[-/](0?[1-9]|1[0-2])[-/]\\d{4}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                writer.write("valid date\n");
            } else {
                writer.write("invalid date\n");
            }
        } 
        writer.write("x\n");
    }
    private static void validateIPAddresses(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        writer.write("4\n");
        while (!(line = reader.readLine()).equals("end")) {
            String regex = "^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                writer.write("valid IP address\n");
            } else {
                writer.write("invalid IP address\n");
            }
        }
        writer.write("x\n");
    }
    private static void validateCppVariables(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        writer.write("5\n");
        while (!(line = reader.readLine()).equals("end")) {
            String regex = "[a-zA-Z_][a-zA-Z0-9_]*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                writer.write("valid C++ variable name\n");
            } else {
                writer.write("invalid C++ variable name\n");
            }
        }
        writer.write("x\n");
    }
    private static void validateNoTripleBStrings(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        writer.write("6\n");
        while (!(line = reader.readLine()).equals("end")) {
            String regex = "(?i).*bbb.*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                writer.write("invalid string, has 3 consecutive b’s\n");
            } else {
                writer.write("valid string\n");
            }
        }
        writer.write("x\n");
    }

    private static void addAlpha(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        writer.write("7\n");
        while (!(line = reader.readLine()).equals("end")) {
            String regex = "(a(a*aa)*b(b*bb)*)"; // Regular expression pattern
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            int matchCount = 0;
            while (matcher.find()) {
                String substring = matcher.group();
                // Check if the substring has an odd number of 'a's and an odd number of 'b's
                int countA = substring.replaceAll("[^a]", "").length();
                int countB = substring.replaceAll("[^b]", "").length();
                if (countA % 2 == 1 && countB % 2 == 1) {
                    matchCount++;
                    writer.write("*" + substring + "*\n");
                    writer.write("number of matched substrings: " + matchCount + "\n");
                    writer.write("matched substring: " + substring + "\n");
                    writer.write("start index: " + matcher.start() + ", end index: " + matcher.end() + "\n\n");
                }
            }
        }
        writer.write("x\n");
    }
    private static void validate3words(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        writer.write("8\n");
        while (!(line = reader.readLine()).equals("end")) {
            String regex = "\\b\\w{3}\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            int matchCount = 0;
            while (matcher.find()) {
                matchCount++;
                writer.write("number of matched words: "+ matchCount  + "\n");
                writer.write("matched word: " + matcher.group() + "\n");
                writer.write("start index: " + matcher.start() + ", ");
                writer.write("end index: " + matcher.end() + "\n");
            }
            if (!line.matches(".*\\b\\w{3}\\b.*")) {
                writer.write("No Words Matches " + "\n");
            }
        }
        writer.write("x\n");
    }
    
   
    private static void ValidURL(BufferedReader reader2, BufferedWriter writer, int lineNumber) throws IOException {
        String line;
        int urlCount = 0;
        writer.write("9\n");
        while ((line = reader2.readLine()) != null) {
            String regex = "(https?://\\S+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                urlCount++;
                writer.write("URL :" + matcher.group() + "\n");
                writer.write("Line: " + lineNumber + "\n");
                writer.write("Start index: " + matcher.start() + ", End index: " + matcher.end() + "\n\n");
            }
            lineNumber++;
        }
        writer.write("Number of URLs: " + urlCount + "\n");
        writer.write("x\n");
    }
    
    
    private static void ValidMathExpression(BufferedReader reader, BufferedWriter writer) throws IOException {
        writer.write("10\n");
  
        String line;
        while(!(line = reader.readLine()).equals("end")) {
           if (line.matches("^[-+*/()0-9a-zA-Z]+=[-+*/()0-9a-zA-Z]+$")) {
              writer.write("valid mathematical expression\n");
           } else {
              writer.write("invalid mathematical expression\n");
           }
        }
  
        writer.write("x\n");
     }

}    