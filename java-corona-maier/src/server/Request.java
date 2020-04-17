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
public class Request {
    
    private boolean  master;
    private boolean start;
    private boolean stop;
    private boolean clear;
    private boolean end;
    

    public boolean isMaster() {
        return master;
    }

    public boolean isStart() {
        return start;
    }

    public boolean isStop() {
        return stop;
    }

    public boolean isClear() {
        return clear;
    }

    public boolean isEnd() {
        return end;
    }
    
    
    
    
    
}
