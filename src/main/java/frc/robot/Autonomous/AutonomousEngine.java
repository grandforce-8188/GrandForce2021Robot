package frc.robot.Autonomous;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AutonomousEngine {
    static String FileName = null; //The file url, this will be talked about more later.

    /**
     * Select the file to run instructions from
     * @param fileURL pass this the url of the file in the resources folder as a string
     */
    public static void initialize(String fileURL)
    {
        FileName = fileURL; //Sets the file that is to be run to the desired file passed into this void.
    }

    /**
     * Runs the engine for Autonomous, reads from the json file called by the initialize void. You must run the initialize void before calling this.
     * @return Returns an array containing each of the instructions in the JSON file, in the following formate. command/parameter
     */
    public static String[] runEngine() throws IOException {
        AutonomousEngine obj = new AutonomousEngine(); //Creates a new instance of this class
        StringBuilder out = new StringBuilder(); //Creates a simple StringBuilder

        InputStream inputStream = obj.getClass().getClassLoader().getResourceAsStream(FileName); //Creates an input stream for the desired file

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) { //Don't worry about this, it just turns the file from binary to text
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
        }

        String rawJSON = out.toString(); //Turn the file into a string
        rawJSON = rawJSON.replaceAll("\\s", ""); //Removes all spaces, otherwise you end up with about a million of them.

        String[] rawArray = rawJSON.split(Pattern.quote("["), 0); //Very crude method of separating everything that we don't care about from that which we do.
        // In the json file you may notice things that are not instructions, but just information about the JSON, or large scale syntax. This seperates those things
        String JSON = rawArray[1].substring(0, rawArray[1].length()-2); //Get only the things that care about

        JSON = JSON.replaceAll(Pattern.quote("},"), "}X"); //What this is replaces the commas between individual blocks in the JSON with an X to make it
        // easier to break the data into an array
        String[] tableOfInstructions = JSON.split("X", 0); //Turns the instructions into any array based off of the X that we previously added


        Gson gson = new Gson(); //Initialze GSON
        List<String> instructionList = new ArrayList<String>(); //Create a list to hold the instructions, this is done because it's way easier to manipulate lists, as arrays are more or less
        //Set in stone

        for(int i = 0; i<tableOfInstructions.length; i++) //For each object in array, add it's command and parameter to the list
        {
            Instruction command = gson.fromJson(tableOfInstructions[i], Instruction.class); //Turn the information contained in each JSON block into an Instruction Class(See bottom)
            instructionList.add(command.instruction + "/" + command.parameter); //Turn object into string. This is done for two reasons 1.) it's easier to work to with a string then
            // shipping objects all over the place, and 2.) It's more efficient than shipping objects all over the place.
        }

        String[] instructionArray = new String[instructionList.size()]; //Once the list has been created we are going to turn back into an array.
        //The easiest way to do this in java is to just create an array of the same size, then in a for loop just copy it over.

        for(int i = 0; i<instructionList.size();i++) //Previously mentioned for loop
        {
            instructionArray[i] = instructionList.get(i);
        }

        return instructionArray; //Returns the array
    }
}
class Instruction
{
    String instruction = null;
    Double parameter = null;
}