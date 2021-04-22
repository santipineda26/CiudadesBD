package com.sp.entregabd;

public class Ciudad {

    private int id;
    private String nombre;
    private int poblacion;
    private int latitud;
    private int longitud;

    public Ciudad() {

    }

    public Ciudad(int id, String nombre, int poblacion, int latitud, int longitud) {
        this.setId(id);
        this.setNombre(nombre);
        this.setPoblacion(poblacion);
        this.setLatitud(latitud);
        this.setLongitud(longitud);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
}


