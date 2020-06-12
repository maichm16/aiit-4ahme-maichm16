/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;
import javax.swing.SwingWorker;
import server.Request;
import server.Response;

/**
 *
 * @author Christoph-PC
 */
public class ConnectionWorker extends SwingWorker<String, Integer>{
    private Socket socket;

    
    public ConnectionWorker(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }
    
    
    
    @Override
    protected String doInBackground() throws Exception {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            publish(1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            publish(2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        
        return "OK";

      
    }

    @Override
    protected void process(List<Integer> list) {
        for(Integer r : list) {
            //gui.handleResponse(r);
        
        }
    }
    
    

    @Override
    protected void done() {
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
}
