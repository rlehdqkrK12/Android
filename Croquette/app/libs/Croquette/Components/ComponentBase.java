package Components;

import Social.SocialMemder;

public class ComponentBase extends SocialMemder {
    public GameObject owner;
    public ComponentBase() {}
    public static ComponentBase creat() { return new ComponentBase(); }
    public void setOwner(GameObject _owner) { owner = _owner; }
    public GameObject getOwner() { return owner; }
    public void upDate() {}
}