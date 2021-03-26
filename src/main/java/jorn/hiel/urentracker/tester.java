package jorn.hiel.urentracker;

import jorn.hiel.urentracker.business.DayState;

public class tester {


    public static void main(String[] args) {
        int tester=2;
        for(DayState state: DayState.values()){
            System.out.println(state.getValue());
            if (state.getValue() == tester) {
                System.out.println(state);

            }
        }
    }
}
