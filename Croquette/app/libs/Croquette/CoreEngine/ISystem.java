package CoreEngine;

import Social.SocialMemder;

public class ISystem extends SocialMemder {
    public ISystem() { type = 0; }
    public CoreEngine owner;
    public void setOwner(CoreEngine _owner) { owner = _owner; }
    public CoreEngine getOwner() { return owner; }
}
