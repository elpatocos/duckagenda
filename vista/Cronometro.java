package ducktimer.vista;

import ducktimer.funcion.CronometroFuncion;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class Cronometro extends JInternalFrame{
    private final JLabel lbl_time;
    private final JLabel lbl_status;
    private final JButton btn_start;
    private final JButton btn_reset;
    private final CronometroFuncion cronometro;

    public Cronometro(){
        setTitle(null);
        setFrameIcon(null);
        setBorder(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        lbl_time=new JLabel("00:00:00.00");
        lbl_time.setFont(new Font("Arial",Font.BOLD,48));
        lbl_status=new JLabel("Cronómetro detenido");
        btn_start=new JButton("Iniciar");
        btn_reset=new JButton("Reiniciar");
        btn_start.setBorderPainted(false);
        btn_reset.setBorderPainted(false);

        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(10,10,10,10);
        gbc.gridx=0;
        gbc.gridy=0;
        add(lbl_time,gbc);
        gbc.gridy=1;
        add(lbl_status,gbc);

        JPanel pnl_buttons=new JPanel(new BorderLayout(20,0));
        pnl_buttons.setOpaque(false);
        pnl_buttons.add(btn_start,BorderLayout.WEST);
        pnl_buttons.add(btn_reset,BorderLayout.EAST);
        gbc.gridy=2;
        add(pnl_buttons,gbc);

        cronometro=new CronometroFuncion(this::updateTime);
        btn_start.addActionListener(e->toggleChronometer());
        btn_reset.addActionListener(e->resetChronometer());
        addInternalFrameListener(new javax.swing.event.InternalFrameAdapter(){
            @Override
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent e){
                cronometro.close();
            }
        });
        setVisible(true);
    }

    private void toggleChronometer(){
        if(cronometro.isRunning()){
            cronometro.pause();
            btn_start.setText("Continuar");
            lbl_status.setText("Cronómetro pausado");
        }else{
            cronometro.start();
            btn_start.setText("Pausar");
            lbl_status.setText("Cronómetro en marcha");
        }
    }

    private void resetChronometer(){
        cronometro.reset();
        btn_start.setText("Iniciar");
        lbl_status.setText("Cronómetro detenido");
    }

    private void updateTime(long elapsedMillis){
        long centiseconds=elapsedMillis/10;
        long hours=centiseconds/360000;
        long minutes=(centiseconds/6000)%60;
        long seconds=(centiseconds/100)%60;
        long hundredths=centiseconds%100;
        lbl_time.setText(String.format("%02d:%02d:%02d.%02d",hours,minutes,seconds,hundredths));
    }
}
