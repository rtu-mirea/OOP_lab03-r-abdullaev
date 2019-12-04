package com.company;

import java.util.ArrayList;

public class Voting {
    private String title = "";
    private ArrayList<Candidate> candidates = new ArrayList<Candidate>();

    //public void setTitle(String title){ this.title = title + '\n';}
    public String getTitle(){return title;}
    public void addCandidate(String name){
        candidates.add(new Candidate(name));
        title += "[" + (candidates.size() - 1) + "] " +  name + '\n';
    }
    public void addVoise(int indexOfCandidate ){
        candidates.get(indexOfCandidate).addVoice();
    }
    public String getWinner() throws Exception{
        int max = 0;
        String winner = "No one";
        for (Candidate candidate: candidates) {
            if (max < candidate.getVotes()){
                max = candidate.getVotes();
                winner = candidate.getName();
            }
        }
        if (winner.compareTo("No one") == 0) throw new Exception("Голосование еще не было проведено");
        return winner;
    }
    public Boolean isNoCandidates(){return candidates.isEmpty();}

}
