package ducktimer.funcion;

import ducktimer.tipo.CronometroEstado;
import java.util.function.LongConsumer;
import javax.swing.Timer;

public class CronometroFuncion{
    private final CronometroEstado estado=new CronometroEstado();
    private final LongConsumer listener;
    private final Timer timer;

    public CronometroFuncion(LongConsumer listener){
        this.listener=listener;
        this.timer=new Timer(10,e->notifyElapsed());
    }

    public void start(){
        estado.start();
        timer.start();
        notifyElapsed();
    }

    public void pause(){
        estado.pause();
        timer.stop();
        notifyElapsed();
    }

    public void reset(){
        estado.reset();
        timer.stop();
        notifyElapsed();
    }

    public boolean isRunning(){
        return estado.isRunning();
    }

    public void close(){
        estado.pause();
        timer.stop();
    }

    private void notifyElapsed(){
        listener.accept(estado.getElapsedMillis());
    }
}
