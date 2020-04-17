/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Christoph-PC
 */
public class Response {
    private boolean master;
    private boolean count;
    private boolean running;
    private long time;

    public Response(boolean master, boolean count, boolean running, long time) {
        this.master = master;
        this.count = count;
        this.running = running;
        this.time = time;
    }
    
    
}
