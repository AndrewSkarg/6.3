package com.exam;

import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scene Yel1=new Scene(SceneSpecification.YELLOW,new Event().of(LocalTime.of(16,0),LocalTime.of(18,20),"Iron Maiden",130));
        Scene Ora3=new Scene(SceneSpecification.ORANGE,new Event().of(LocalTime.of(18,50),LocalTime.of(20,20),"Metallica",110));
        Scene Bl4=new Scene(SceneSpecification.BLACK,new Event().of(LocalTime.of(19,30),LocalTime.of(22,20),"AC~DC",116));
        Scene Purp6=new Scene(SceneSpecification.PURPLE,new Event().of(LocalTime.of(17,0),LocalTime.of(19,30),"Guns N` Roses",78.5));
        Scene Pin2=new Scene(SceneSpecification.PINK,new Event().of(LocalTime.of(17,0),LocalTime.of(19,50),"Judas Priest",85.7));
        Scene Gr5=new Scene(SceneSpecification.GREEN,new Event().of(LocalTime.of(20,50),LocalTime.of(22,30),"RHCP",99));


        LocationsMap locationsMap = new LocationsMap(SceneSpecification.values().length);
        locationsMap.addRoad(SceneSpecification.YELLOW.getId(), SceneSpecification.PINK.getId(), 2);
        locationsMap.addRoad(SceneSpecification.PINK.getId(), SceneSpecification.ORANGE.getId(), 2);
        locationsMap.addRoad(SceneSpecification.ORANGE.getId(), SceneSpecification.BLACK.getId(), 3);
        locationsMap.addRoad(SceneSpecification.BLACK.getId(), SceneSpecification.GREEN.getId(), 2);
        locationsMap.addRoad(SceneSpecification.GREEN.getId(), SceneSpecification.ORANGE.getId(), 6);
        locationsMap.addRoad(SceneSpecification.GREEN.getId(), SceneSpecification.PINK.getId(), 3);
        locationsMap.addRoad(SceneSpecification.GREEN.getId(), SceneSpecification.YELLOW.getId(), 6);
        locationsMap.addRoad(SceneSpecification.GREEN.getId(), SceneSpecification.PURPLE.getId(), 2);
        locationsMap.addRoad(SceneSpecification.PURPLE.getId(), SceneSpecification.YELLOW.getId(), 3);
        locationsMap.shRoads(); //to show MATRIX
        //int[] dist = EventUtil.shortestPathBetweenScenes(locationsMap, 0);
        //System.out.println(Arrays.toString(dist));


        ArrayList<Scene>scenes=EventUtil.createConcertPlan(new Scene[]{Yel1,Pin2,Ora3,Bl4,Gr5,Purp6});
        scenes.stream().forEach(System.out::println);
        double evPr=EventUtil.priceForAllEvents(scenes);
        double trPr=EventUtil.priceForTransfer(scenes,locationsMap);
        double sum=evPr+trPr;
        System.out.println("price for all events: "+evPr+" $");
        System.out.println("price for transfer  : "+trPr+" $");
        System.out.println("total price         : "+sum+" $");




    }
}
