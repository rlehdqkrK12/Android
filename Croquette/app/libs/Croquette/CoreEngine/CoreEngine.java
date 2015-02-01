package CoreEngine;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import Components.GameObject;
import Social.Message;
import Social.Type;

public class CoreEngine {
    public ArrayList<ISystem> systems;
    public ArrayList<Message> messages;
    public ArrayList<GameObject> objects;
    public  CoreEngine() {
        systems = new ArrayList<ISystem>();
        messages = new ArrayList<Message>();
        objects = new ArrayList<GameObject>();
    }
    public void mailBox(Message _message) { messages.add(_message); }
    public void upDate(GL10 gl){
        for (int i = 0; i < systems.size(); i++)
            systems.get(i).upDate();
        for (int i = 0; i < objects.size(); i++)
            objects.get(i).upDate();
        processingMessage();
    }
    public void processingMessage() {
        for (int i = 0; i < messages.size(); i++){
            if (messages.get(i).delayTime <= 0f) {
                messages.get(i).delayTime -= 0.001f;
            }else {
                if(messages.get(i).recipients == Type.System) {
                    for (int j = 0; j < systems.size(); j++) {
                        systems.get(j).mailBox(messages.get(i));
                    }
                }else if(messages.get(i).recipients == Type.Object) {
                    for (int j = 0; j < objects.size(); j++) {
                        objects.get(j).mailBox(messages.get(i));
                    }
                }
                messages.remove(i);
                i--;
            }
        }
    }
}
