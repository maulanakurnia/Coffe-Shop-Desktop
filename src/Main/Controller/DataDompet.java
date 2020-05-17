package Main.Controller;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataDompet {
    private static int saldo;
    private static String idDompet;

    public static void setIdDompet(String vIdDompet){
        idDompet = vIdDompet;
    }

    public static String getIdDompet(){
        return idDompet;
    }

    public static void setSaldo(int vsaldo){
        saldo = vsaldo;
    }

    public static void tambahSaldo(int vjumlah){
        saldo += vjumlah;
    }

    public static void kurangSaldo(int vsaldo){
        saldo -= vsaldo;
    }

    public static int getSaldo(){
        return saldo;
    }
}
