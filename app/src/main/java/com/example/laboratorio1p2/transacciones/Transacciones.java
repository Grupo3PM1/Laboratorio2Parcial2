package com.example.laboratorio1p2.transacciones;

public class Transacciones {

    /*TABLA*/
    public static final String tabla_fotos = "tbl_fotos";


    /*CAMPOS*/
    public static final String id = "id";
    public static final String image = "image";
    public static final String name = "name";
    public static final String horafecha = "horafecha";
    public static final String size = "size";
    public static final String formato = "formato";
    public static final String descripcion = "descripcion";


    /* tablas - CREATE , DROP */
    public static final String CreateTableFotos= "CREATE TABLE tbl_fotos( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, horafecha DATE, formato TEXT, size BIGINT, image BLOB, descripcion TEXT)";
    public static final String DropTableFotos = "DROP TABLE IF EXISTS tbl_fotos";


    /* Creacion del nombre de la base de datos */
    public static final String NameDataBase = "DBPWI";


}
