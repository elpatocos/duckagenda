package ducktimer.funcion;

import ducktimer.tipo.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import javax.swing.SwingUtilities;

public class AlarmService extends Thread{
    private final CopyOnWriteArrayList<Time> alarms;
    private final Consumer<Time> onAlarm;
    private LocalDate firedDate;
    private final Set<String> firedTimes=new java.util.HashSet<>();

    public AlarmService(CopyOnWriteArrayList<Time> alarms,Consumer<Time> onAlarm){
        super("duckTimes-alarm-service");
        this.alarms=alarms;
        this.onAlarm=onAlarm;
        setDaemon(true);
    }

    @Override
    public void run(){
        while(!isInterrupted()){
            LocalTime now=LocalTime.now().withNano(0);
            LocalDate today=LocalDate.now();
            if(!today.equals(firedDate)){
                firedTimes.clear();
                firedDate=today;
            }
            for(Time alarm:alarms){
                if(alarm.getHours()==now.getHour()
                    && alarm.getMinuts()==now.getMinute()
                    && alarm.getSeconds()==now.getSecond()){
                    String key=alarm.getHours()+":"+alarm.getMinuts()+":"+alarm.getSeconds();
                    if(firedTimes.add(key)){
                        SwingUtilities.invokeLater(()->onAlarm.accept(alarm));
                    }
                }
            }
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                interrupt();
            }
        }
    }
}
