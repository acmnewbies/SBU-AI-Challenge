package Replay;

import GameLogic.Cord;
import GameLogic.Movement;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class ReplayHandler {
    private static ReplayHandler ourInstance = new ReplayHandler();

    private String replayJsonPath;
    private Writer jsonWriter;
    private ArrayList<Movement> moves;

    public static ReplayHandler getInstance() {
        return ourInstance;
    }

    private ReplayHandler() {
    }

    public void initializeReplay(boolean isReplay){
        //replayJsonPath = this.getClass().getResource("/JsonMoveLog.json");
        this.replayJsonPath = "/home/amirali/Desktop/AICHALLENGE/SBU-AI-Challenge/Learning Requirements/GameMonitor/src/main/resources/JsonMoveLog.json";
        if (isReplay)
            this.loadReplay();
        else
            this.initializeReplaySaver();
    }


    private void loadReplay(){
        try {
            Reader reader = new FileReader(replayJsonPath);
            Gson gson = new Gson();
            TypeToken<ArrayList<Movement>> token = new TypeToken<>() {};
            this.moves = gson.fromJson(reader,token.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveReplay(){
            Gson gson = new Gson();
            gson.toJson(moves, jsonWriter);
            try {
                jsonWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

    }

    private void initializeReplaySaver(){
        this.moves = new ArrayList<>();
        try {
            this.jsonWriter = new OutputStreamWriter(new FileOutputStream(replayJsonPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Movement> getMoves() {
        return moves;
    }
}
