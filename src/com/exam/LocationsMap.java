package com.exam;

import java.util.Arrays;

public class LocationsMap {
    private int[][] adjointMatrix;
    private int numOfScenes;

    public int getNumOfScenes() {
        return numOfScenes;
    }

    public int[][] getAdjointMatrix() {
        return adjointMatrix;
    }

    public void setAdjointMatrix() {
        this.adjointMatrix = new int[numOfScenes][numOfScenes];
    }

    public LocationsMap(int numOfScenes) {
        this.numOfScenes = numOfScenes;
        setAdjointMatrix();
    }

    public void addRoad(int src, int dest, int distance) {
        adjointMatrix[src][dest] = distance;
        adjointMatrix[dest][src] = distance;


    }

    public void shRoads() {

        for (int i = 0; i < adjointMatrix.length; i++) {
            for (int j = 0; j < adjointMatrix[i].length; j++) {
                /*if (i != j && adjointMatrix[i][j] == 0) {
                    adjointMatrix[i][j] = -1;
                }*/
                System.out.printf("%5s", adjointMatrix[i][j]);
            }
            System.out.println();
        }

    }





}
