package frc.robot.Autonomous;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GrandForce_AutoEngine
{
        public String[] runEngine(String inputJSON) throws IOException {
            inputJSON = inputJSON.replaceAll("\\s", "");
            String[] rawArray = inputJSON.split(Pattern.quote("["), 0);
            String JSON = rawArray[1].substring(0, rawArray[1].length() - 2);
            JSON = JSON.replaceAll(Pattern.quote("},"), "}X");
            String[] tableOfInstructions = JSON.split("X", 0);
            Gson gson = new Gson();
            List<String> instructionList = new ArrayList<String>();

            for(int i = 0; i < tableOfInstructions.length; ++i) {
                Instruction command = (Instruction)gson.fromJson(tableOfInstructions[i], Instruction.class);
                instructionList.add(command.instruction + "/" + command.parameter);
            }

            String[] instructionArray = new String[instructionList.size()];

            for(int i = 0; i < instructionList.size(); i++) {
                instructionArray[i] = (String)instructionList.get(i);
            }

            return instructionArray;
        }
    }
class Instruction {
    String instruction = null;
    Double parameter = null;

    Instruction() {
    }
}
