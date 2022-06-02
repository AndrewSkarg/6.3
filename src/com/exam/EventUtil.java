package com.exam;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class EventUtil {
    public static final double PRICE_FOR_KM = 2.5;

    public static ArrayList<Scene> createConcertPlan(Scene[] scene) {
        LocalTime[] startTime = new LocalTime[scene.length];
        LocalTime[] finishTime = new LocalTime[scene.length];
        for (int i = 0; i < scene.length; i++) {
            startTime[i] = scene[i].event.getStart();
            finishTime[i] = scene[i].event.getFinish();
        }
        int n = scene.length;

        ArrayList<Scene> scenes = new ArrayList<>();
        int i, j;
        i = 0;
        for (j = 1; j < n; j++) {
            if (startTime[j].isAfter(finishTime[i]) || startTime[j].equals(finishTime[i])) {
                if(!scenes.contains(scene[i])) {
                    scenes.add(scene[i]);
                }
                scenes.add(scene[j]);

                i = j;
            }
        }


        return scenes;
    }


    public static int[] shortestPathBetweenScenes(LocationsMap Lm, int src) {
        int[] distance = new int[Lm.getNumOfScenes()];

        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[Lm.getNumOfScenes()];
        Arrays.fill(visited, false);
        distance[src] = 0;
        for (int i = 0; i < Lm.getNumOfScenes(); i++) {
            int closestVertex = getClosestLocation(distance, visited);
            visited[closestVertex] = true;
            for (int j = 0; j < Lm.getNumOfScenes(); j++) {
                if (!visited[j]) {
                    if (Lm.getAdjointMatrix()[closestVertex][j] != 0) {
                        int d = distance[closestVertex] + Lm.getAdjointMatrix()[closestVertex][j];
                        if (d < distance[j])
                            distance[j] = d;
                    }
                }
            }
        }
        return distance;
    }

    public static int getClosestLocation(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] < min)
                if (!visited[i]) {
                    min = distance[i];
                    minIdx = i;
                }
        }
        return minIdx;
    }

    public static double priceForAllEvents(ArrayList<Scene> scenes){
        double eventsPrice = scenes.stream().mapToDouble(x->x.event.getPrice())
                .reduce(0, (x, y) -> x + y);
        return eventsPrice;
    }
    public static double priceForTransfer(ArrayList<Scene> scenes,LocationsMap Lm){
        double transferPrice=0;
        for (int i=0;i<scenes.size();i++){
           int path[]=shortestPathBetweenScenes(Lm,scenes.get(i).sceneSpecification.getId());
           if (i+1<scenes.size()) {
               transferPrice += path[scenes.get(i + 1).sceneSpecification.getId()] * EventUtil.PRICE_FOR_KM;
           }
           else {
               break;
           }
        }

        return transferPrice;
    }


}