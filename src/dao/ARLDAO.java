package dao;



import modelo.ARL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ARLDAO {
    private static final String FILE_PATH = "src/backup/arl.txt";

    public static void guardarARL(ARL arl) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.write(arl.getNombre() + "," + arl.getCodigo());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ARL> listarARL() {
        List<ARL> arlList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String nombre = data[0];
                    String codigo = data[1];
                    ARL arl = new ARL(nombre, codigo);
                    arlList.add(arl);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arlList;
    }

    public static void actualizarARL(ARL arl) {
        List<ARL> arlList = listarARL();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (ARL oldARL : arlList) {
                if (oldARL.getNombre().equals(arl.getNombre()) && oldARL.getCodigo().equals(arl.getCodigo())) {
                    writer.write(arl.getNombre() + "," + arl.getCodigo());
                } else {
                    writer.write(oldARL.getNombre() + "," + oldARL.getCodigo());
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarARL(ARL arl) {
        List<ARL> arlList = listarARL();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (ARL oldARL : arlList) {
                if (!(oldARL.getNombre().equals(arl.getNombre()) && oldARL.getCodigo().equals(arl.getCodigo()))) {
                    writer.write(oldARL.getNombre() + "," + oldARL.getCodigo());
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
