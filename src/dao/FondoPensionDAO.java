package dao;

import modelo.FondoPension;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FondoPensionDAO {
    private static final String FILE_PATH = "src/backup/fondoPension.txt";

    public static void guardarFondoPension(FondoPension fondoPension) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.write(fondoPension.getNombre() + "," + fondoPension.getCodigo());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<FondoPension> listarFondoPension() {
        List<FondoPension> fondoPensionList = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String nombre = data[0];
                    String codigo = data[1];
                    FondoPension fondoPension = new FondoPension(nombre, codigo);
                    fondoPensionList.add(fondoPension);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fondoPensionList;
    }

    public static void actualizarFondoPension(FondoPension fondoPension) {
        List<FondoPension> fondoPensionList = listarFondoPension();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (FondoPension oldFondoPension : fondoPensionList) {
                if (oldFondoPension.getNombre().equals(fondoPension.getNombre()) && oldFondoPension.getCodigo().equals(fondoPension.getCodigo())) {
                    writer.write(fondoPension.getNombre() + "," + fondoPension.getCodigo());
                } else {
                    writer.write(oldFondoPension.getNombre() + "," + oldFondoPension.getCodigo());
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarFondoPension(FondoPension fondoPension) {
        List<FondoPension> fondoPensionList = listarFondoPension();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (FondoPension oldFondoPension : fondoPensionList) {
                if (!(oldFondoPension.getNombre().equals(fondoPension.getNombre()) && oldFondoPension.getCodigo().equals(fondoPension.getCodigo()))) {
                    writer.write(oldFondoPension.getNombre() + "," + oldFondoPension.getCodigo());
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
