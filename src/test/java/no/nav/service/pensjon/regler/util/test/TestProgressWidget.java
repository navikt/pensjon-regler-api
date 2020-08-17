package no.nav.service.pensjon.regler.util.test;

import no.nav.service.pensjon.regler.util.ProgressWidget;

import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;

/**
 *
 * @author ng28
 */
public class TestProgressWidget {
    public static void main(String args[]) {
        final ProgressWidget widget = new ProgressWidget();
        widget.setProgressLimit(50);
        widget.setTitle("Making progress ...");
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                widget.setVisible(true);
            }
        });
        
        for (int i=0; i <= 50; i++){
           final int j = i;
           final String txt = "Und so weiter " + i + "\n";
           SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                widget.setProgress(j);
                widget.setTextProgress(txt);
            }
           });
           try {
           TimeUnit.MILLISECONDS.sleep(100);
           } catch (InterruptedException ex){
               
           }
        }
    }
  
}
