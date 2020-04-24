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
import java.io.OutputStream;
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
            
            if(handlers.size() == 3) {
                serversocket.close();
            } else {
                serversocket.accept();
            }
        }
    }
    
    public boolean isTimerRunning() {
        if(startMillis == -1) {
            return false;
        } else {
            return true;
        }
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
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String req = reader.readLine();
                Gson gson = new Gson();
                Request r = gson.fromJson(req, Request.class);

                if(r.isMaster()) {
                    boolean setMasterTrue = true;
                    for(ConnectionHandler h : handlers) {
                        if(!h.equals(this) && h.isMaster() == true) {
                            setMasterTrue = false;
                        }
                    }
                    master = setMasterTrue;
                }
                
                if(r.isMaster()) {
                    if(r.isStart()) {
                        startMillis = System.currentTimeMillis();
                    }

                    if(r.isStop()) {
                        startMillis = -1;
                    } else {
                        timeOffset = System.currentTimeMillis() - startMillis;
                    }

                    if(r.isClear()) {
                        timeOffset = 0;
                    }

                    if(r.isEnd()) {
                        socket.close();
                        handlers.remove(this);
                    }        
                }

                
                
                //Response
                Response resp = new Response(master, , isTimerRunning(), getTimerMillis());
                String respString = gson.toJson(resp);
                
          
            } catch(Exception ex) {
                ex.printStackTrace();
            } 
        }
    }
}
