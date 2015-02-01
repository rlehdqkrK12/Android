package Components;

import Rest.Vector3;

public class PositionComponent extends ComponentBase{
    public Vector3 position;
    public PositionComponent() { super(); position = new Vector3(); }
    public static PositionComponent creat() { return new PositionComponent(); }
    public Vector3 getPosition() { return position; }
}
