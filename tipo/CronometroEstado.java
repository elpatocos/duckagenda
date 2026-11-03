package ducktimer.tipo;

public class CronometroEstado{
    private long elapsedNanos;
    private long startedAtNanos;
    private boolean running;

    public void start(){
        if(!running){
            startedAtNanos=System.nanoTime();
            running=true;
        }
    }

    public void pause(){
        if(running){
            elapsedNanos+=System.nanoTime()-startedAtNanos;
            running=false;
        }
    }

    public void reset(){
        elapsedNanos=0;
        running=false;
    }

    public boolean isRunning(){
        return running;
    }

    public long getElapsedMillis(){
        long elapsed=elapsedNanos;
        if(running){
            elapsed+=System.nanoTime()-startedAtNanos;
        }
        return elapsed/1_000_000;
    }
}
