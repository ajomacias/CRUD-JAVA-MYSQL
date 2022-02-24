package com.ander.Database;

public enum Config {
    URL("jdbc:mysql://localhost:3306/mensajes_db?serverTimeZone=UTC"),
    USER("root"),
    PASS("");
    
    private final String data;

    private Config(String data){
        this.data = data;
        
    }

    public String getData(){
        return this.data;
    }
    
}
