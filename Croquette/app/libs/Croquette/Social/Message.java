package Social;

public class Message {
    public float delayTime;
    public Class recipients;
    public String message;
    public Object[] parameters;
    public Class[] partypes;
    public Message() { this(null, null, null, null, 0f); }
    public Message(Class _recipients, String _message) { this(_recipients, _message, 0f); }
    public Message(Class _recipients, String _message, float _delayTime) { this(_recipients, _message, null, null, _delayTime); }
    public Message(Class _recipients, String _message, Class[] _partypes, Object[] _parameters){ this(_recipients, _message, _partypes, _parameters, 0f); }
    public Message(Class _recipients, String _message, Class[] _partypes, Object[] _parameters, float _delayTime){ recipients = _recipients; message = _message; partypes = _partypes; parameters = _parameters; delayTime = _delayTime; }
    public static Message creat(){ return new Message(); }
    public static Message creat(Class _recipients, String _message){ return new Message(_recipients, _message); }
    public static Message creat(Class _recipients, String _message, float _delayTime){ return new Message(_recipients, _message, _delayTime); }
    public static Message creat(Class _recipients, String _message, Class[] _partypes, Object[] _parameters) { return new Message(_recipients, _message, _partypes, _parameters); }
    public static Message creat(Class _recipients, String _message, Class[] _partypes, Object[] _parameters, float _delayTime) { return new Message(_recipients, _message, _partypes, _parameters, _delayTime); }
}