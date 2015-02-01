package Components;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import Social.Message;
import Social.SocialMemder;

public class GameObject extends SocialMemder {
    public ArrayList<ComponentBase> components;
    public GameObject() { components = new ArrayList<ComponentBase>(); }
    public static GameObject creat() { return new GameObject(); }
    public ComponentBase insertComponent(Class<? extends ComponentBase> _class) {
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getClass() == _class) {
                return null;
            }
        }
        ComponentBase _component = null;
        try {
            _component = _class.newInstance();
            _component.setOwner(this);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        components.add(_component);
        return _component;
    }
    public Boolean insertComponent(ComponentBase _component) {
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getClass() == _component.getClass()) {
                return false;
            }
        }
        _component.setOwner(this);
        components.add(_component);
        return true;
    }
    public ComponentBase getComponent(Class<? extends ComponentBase> _class) {
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getClass() == _class) {
                return components.get(i);
            }
        }
        return null;
    }

    @Override
    public void upDate() {
        for (int i = 0; i < components.size(); i++)
            components.get(i).upDate();
    }

    @Override
    public void mailBox(Message _message) {
        try {
            if (_message.recipients.getSuperclass() != ComponentBase.class) {
                if (_message.parameters != null) {
                    _message.recipients.getMethod(_message.message, _message.partypes).invoke(this, _message.parameters);
                } else {
                     _message.recipients.getMethod(_message.message).invoke(this);
                }
            } else {
                for (int i = 0; i < components.size(); i++) {
                    if (components.get(i).getClass() == _message.recipients || components.get(i).getClass().getSuperclass() == _message.recipients) {
                        if (_message.parameters != null) {
                            _message.recipients.getMethod(_message.message, _message.partypes).invoke(_message.recipients.cast(components.get(i)), _message.parameters);
                        } else {
                            _message.recipients.getMethod(_message.message).invoke(_message.recipients.cast(components.get(i)));
                        }
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}