package designPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ROKG
 * @Description 观察者模式
 * @Date: Created in 下午10:18 2018/9/16
 * @Modified By:
 */
public class Observer {
    public static void main(String[] args) {
        ConcreteObserverable observerable=new ConcreteObserverable();
        Event event1=new ConcreteEvent();
        Event event2=new ConcreteEvent();
        observerable.registerObserver(event1);
        observerable.registerObserver(event2);
        observerable.setMessage("hahaha");
    }
}
interface Observerable{
    void registerObserver(Event o);
    void removeObserver(Event o);
    void notifyObserver();
}
class ConcreteObserverable implements Observerable {
    List<Event> events=new ArrayList<>();
    String message;
    @Override
    public void registerObserver(Event o){
        events.add(o);
    }
    @Override
    public void removeObserver(Event o){
        if (!events.isEmpty()){
            events.remove(o);
        }
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObserver();
    }

    @Override
    public void notifyObserver(){
        for (Event e:events){
            e.update(message);
        }
    }
}
interface Event{
    void update(String message);
}
class ConcreteEvent implements Event{
    String message;
    @Override
    public void update(String message){
        this.message=message;
        System.out.println(this.message);
    }
}
