package ducktimer.funcion;


import java.time.LocalDateTime;
import java.util.function.Consumer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author terem
 */
public class ThreadTime extends Thread{
    private final Consumer<LocalDateTime> listener;

    public ThreadTime(Consumer<LocalDateTime> listener){
        super("duckTimes-clock");
        this.listener=listener;
        setDaemon(true);
    }
    
    @Override
    public void run(){
        
        while(!isInterrupted()){
            listener.accept(LocalDateTime.now());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                interrupt();
            }
        }
    }
}
