/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class ConnectionWorker extends SwingWorker<String, Response> {
  
    @Override
    protected void process(List<Response> list) {
    }
    
    

    @Override
    protected void done() {
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String doInBackground() throws Exception {
        return "Ok";
    }
}
