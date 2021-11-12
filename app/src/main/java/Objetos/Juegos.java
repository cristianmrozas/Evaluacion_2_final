package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Juegos {
    private int id;
    private String[] juegos = {"FIFA 2022", "FAR CRY 6", "GRAN TURISMO 7", "BATTLEFIELD 2042", "WWE 2K22", "GHOST OF STUSHIMA", "ELDEN RING"};
    private int[] precios = {40000, 35000, 15000, 20000, 25000, 24000, 50000};
    private int stock;

    public Juegos() {

        int id=0;

    }

    public Juegos(int id, String[] juegos, int[] precios, int stock) {
        this.id = id;
        this.juegos = juegos;
        this.precios = precios;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getJuegos() {
        return juegos;
    }

    public void setJuegos(String[] juegos) {
        this.juegos = juegos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Juegos juegos1 = (Juegos) o;
        return id == juegos1.id && stock == juegos1.stock && Arrays.equals(juegos, juegos1.juegos) && Arrays.equals(precios, juegos1.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, stock);
        result = 31 * result + Arrays.hashCode(juegos);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    @Override
    public String toString() {
        return "Juegos{" +
                "id=" + id +
                ", juegos=" + Arrays.toString(juegos) +
                ", precios=" + Arrays.toString(precios) +
                ", stock=" + stock +
                '}';
    }
    public int añadirAdicional(int valor, int adicional)
    {
        return valor + adicional;
    }
}