package Codewars;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {

    public String decode(File messageFile) throws IOException {
        ArrayList<String> fileLines = (ArrayList<String>) Files.readAllLines(messageFile.toPath(), Charset.defaultCharset());
        ArrayList<String> pyramidLineEndIndices = generatePyramidEndIndices(fileLines.size());
        String[] decodedLines = calculateDecodedLines(fileLines, pyramidLineEndIndices);
        return getDecodedMessage(decodedLines);
    }

    private ArrayList<String> generatePyramidEndIndices(int fileLength) {
        ArrayList<String> pyramidLineEndIndices = new ArrayList<>();
        int n = 1;
        int interval = 2;
        while(n <= fileLength) {
            pyramidLineEndIndices.add(Integer.toString(n));
            n += interval;
            interval++;
        }
        return pyramidLineEndIndices;
    }

    private String[] calculateDecodedLines(ArrayList<String> fileLines, ArrayList<String> pyramidLineEndIndices) {
        String[] decodedLines = new String[pyramidLineEndIndices.size()];
        int linesFilledIn = 0;
        for (String fileLine : fileLines) {
            Pattern pattern = Pattern.compile("(\\d+) (\\D+)");
            Matcher matcher = pattern.matcher(fileLine);
            if(matcher.find()) {
                String lineNumber = matcher.group(1);
                int foundIndex = pyramidLineEndIndices.indexOf(lineNumber);
                if (foundIndex > -1) {
                    String lineContent = matcher.group(2);
                    decodedLines[foundIndex] = lineContent;
                    linesFilledIn++;
                    if(linesFilledIn == pyramidLineEndIndices.size()) {
                        break;
                    }
                }
            }
        }
        return decodedLines;
    }

    private String getDecodedMessage(String[] decodedLines) {
        String message = "";
        for(String line : decodedLines) {
            message += line + " ";
        }
        return message.stripTrailing();
    }

}