package dao;


import modelo.EPS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EPSDAO {
    private static final String FILE_PATH = "src/backup/eps.txt";

    public static void guardarEPS(EPS eps) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.write(eps.getNombre() + "," + eps.getCodigo());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<EPS> listarEPS() {
        List<EPS> epsList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String nombre = data[0];
                    String codigo = data[1];
                    EPS eps = new EPS(nombre, codigo);
                    epsList.add(eps);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return epsList;
    }

    public static void actualizarEPS(EPS eps) {
        List<EPS> epsList = listarEPS();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (EPS oldEPS : epsList) {
                if (oldEPS.getNombre().equals(eps.getNombre()) && oldEPS.getCodigo().equals(eps.getCodigo())) {
                    writer.write(eps.getNombre() + "," + eps.getCodigo());
                } else {
                    writer.write(oldEPS.getNombre() + "," + oldEPS.getCodigo());
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarEPS(EPS eps) {
        List<EPS> epsList = listarEPS();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (EPS oldEPS : epsList) {
                if (!(oldEPS.getNombre().equals(eps.getNombre()) && oldEPS.getCodigo().equals(eps.getCodigo()))) {
                    writer.write(oldEPS.getNombre() + "," + oldEPS.getCodigo());
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


