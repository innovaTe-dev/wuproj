/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL6;


import java.io.PrintWriter;

/**
 *
 * @author cecil.schmidt
 */
public class ChatMember {

    public ChatMember(String name, PrintWriter writer) {
        this.setName(name);
        this.setWriter(writer);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o  instanceof ChatMember) {
            ChatMember c = (ChatMember) o;
            return c.name.equals(this.name);
        }
        else return false;
    }

    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the writer
     */
    public PrintWriter getWriter() {
        return writer;
    }

    /**
     * @param writer the writer to set
     */
    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }
    private String name;
    private PrintWriter writer;

}
