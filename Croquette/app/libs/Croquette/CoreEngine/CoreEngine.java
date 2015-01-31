package CoreEngine;

import java.util.ArrayList;


public class CoreEngine {
    public ArrayList<ISystem> systems;
    public  CoreEngine() throws InstantiationException, IllegalAccessException {}
    public ISystem insertSystem(Class<? extends ISystem> _class) {
        for (int i = 0; i < systems.size(); i++) {
            if (systems.get(i).getClass() == _class) {
                return null;
            }
        }
        ISystem _system = null;
        try {
            _system = _class.newInstance();
            _system.setOwner(this);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        systems.add(_system);
        return _system;
    }
    public Boolean insertSystem(ISystem _system) {
        for (int i = 0; i < systems.size(); i++) {
            if (systems.get(i).getClass() == _system.getClass()) {
                return false;
            }
        }
        _system.setOwner(this);
        systems.add(_system);
        return true;
    }
    public ISystem getSystems(Class<? extends ISystem> _class) {
        for (int i = 0; i < systems.size(); i++) {
            if (systems.get(i).getClass() == _class) {
                return systems.get(i);
            }
        }
        return null;
    }
}
