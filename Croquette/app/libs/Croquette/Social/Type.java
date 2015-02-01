package Social;

import Components.ComponentBase;
import Components.GameObject;
import CoreEngine.ISystem;

public class Type {
    public static Class<ISystem> System = ISystem.class;
    public static Class<GameObject> Object = GameObject.class;
    public static Class<ComponentBase> Component = ComponentBase.class;
}