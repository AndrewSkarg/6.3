package com.exam;

public class Scene {
    public SceneSpecification sceneSpecification;
    public Event event;
    public Scene(SceneSpecification sceneSpecification,Event event){
        this.sceneSpecification=sceneSpecification;
        this.event=event;
    }

    @Override
    public String toString() {
        return sceneSpecification +" "+ event;
    }
}
