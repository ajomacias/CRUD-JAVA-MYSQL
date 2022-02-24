package com.ander;

import com.ander.Services.CRUD;

public class CrudMysqlMain{
    public static void main(String[] args) {
        CRUD.crearMensaje("Una clase de Java","Inserte este mensaje por java");
        CRUD.editarMensaje(1, "Una clase de Java", "Estoy editando un mensaje con java");
        CRUD.eliminarMensajePorId(1);
        CRUD.obtenerMensajes();
    }

}