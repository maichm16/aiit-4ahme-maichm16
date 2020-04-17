/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Christoph-PC
 */
public class Server {
    private ServerSocket serversocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    private long timeOffset;
    private long startMillis;

    public void start(int port) throws IOException {        
        serversocket = new ServerSocket(port);
        Socket socket = null;
        
        while(true) {
            socket = serversocket.accept();
            final ConnectionHandler handler = new ConnectionHandler(socket);
            new Thread(handler).start();
            handlers.add(handler);
        }
    }
    
    public boolean isTimerRunning() {
        
    }
    
    public long getTimerMillis() {
        return timeOffset;
    }
    
    public static void main(String[] args) {
        new Server();
    }
    
    
    
            
            
            
            
    private class ConnectionHandler implements Runnable {
        private Socket socket;
        private boolean master;
         
        public ConnectionHandler(Socket socket) {
             this.socket = socket;
        }
         
        public boolean isClosed() {
             return socket.isClosed();
        }
         
        public boolean isMaster() {
            return master;
        }
         
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String req = reader.readLine();
            Gson gson = new Gson();
            Request r = gson.fromJson(req, Request.class);
        
            master = r.isMaster();
            
            if(r.isStart()) {
                
                
                
            }
        
            if(r.isStop()) {
                
                
                
            }
            
            if(r.isClear()) {
                
                
                
            }
            
            if(r.isEnd()) {
                socket.close();
            }                      
        }
         
         
     }
        
}
