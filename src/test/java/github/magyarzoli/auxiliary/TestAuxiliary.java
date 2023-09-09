package github.magyarzoli.auxiliary;

import github.magyarzoli.Sorter;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static java.lang.Math.toIntExact;

public class TestAuxiliary {

    private static String pathProperties;

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> T[] classTypeArray(Class<T> classType, int length) {
        T[] array = (T[]) Array.newInstance(classType, length);
        for (int i = 0; i < length; i++) {
            array[i] = generateRandomElement(classType);
        }
        return array;
    }

    public static <T extends Comparable<T>> List<T> classTypeList(Class<T> classType, int length) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(generateRandomElement(classType));
        }
        return list;
    }

    private static <T extends Comparable<T>> T generateRandomElement(Class<T> classType) {
        Random random = new Random();
        if (classType == Byte.class) {
            return classType.cast((byte) random.nextInt());
        } else if (classType == Short.class) {
            return classType.cast((short) random.nextInt());
        } else if (classType == Integer.class) {
            return classType.cast(random.nextInt());
        } else if (classType == Long.class) {
            return classType.cast(random.nextLong());
        } else if (classType == Float.class) {
            return classType.cast(random.nextFloat());
        } else if (classType == Double.class) {
            return classType.cast(random.nextDouble());
        } else if (classType == String.class) {
            return classType.cast(Long.toString(random.nextLong()));
        } else if (classType == Character.class) {
            return classType.cast(Long.toString(random.nextLong()).toCharArray()[0]);
        } else if (classType == Boolean.class) {
            return classType.cast(random.nextBoolean());
        }
        throw new IllegalArgumentException("Unsupported class type: " + classType.getName());
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <S extends Sorter<Comparable>, T extends Comparable<T>> void writeArray(
            File file, Object[] sortClassParameters, int length, int increment, Class<T> classType,
            FunctionalAuxiliary<S, T> functional)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException,
            IllegalAccessException, IOException {
        List<String> sortName = new ArrayList<>();
        List<List<Long>> resultList = new ArrayList<>();
        for (Object sortClassParameter : sortClassParameters) {
            List<Long> result = new ArrayList<>();
            Class<T> sortClass = (Class<T>) sortClassParameter;
            String name = classTypeName(sortClass);
            Constructor<T> constructor = sortClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            S sorter = (S) constructor.newInstance();
            duration(length, increment, classType, sorter, name, result, functional);
            sortName.add(name);
            Collections.sort(result);
            resultList.add(result);
        }
        csvWriter( file,  sortName, resultList);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static <S extends Sorter<Comparable>, T extends Comparable<T>> void duration(
            int length, int increment, Class<T> classType, S sorter, String name, List<Long> result,
            FunctionalAuxiliary functional) {
        for (int j = increment; j <= length; j += increment) {
            T[] actualArray = classTypeArray(classType, j);
            T[] expectedArray = Arrays.copyOf(actualArray, actualArray.length);
            Arrays.sort(expectedArray);
            long duration;
            long startTime = System.nanoTime();
            functional.functional(sorter, actualArray);
            long endTime = System.nanoTime();
            duration = endTime - startTime;
            if (!Arrays.equals(actualArray, expectedArray)) {
                throw new RuntimeException("Wrong sorter: " + name);
            }
            result.add(duration);
        }
    }

    public static void csvWriter(File file, List<String> header, List<List<Long>> result)
            throws IOException {
        propertiesWrite();
        String path = pathSetSeparator(pathProperties + "csv");
        File folder = new File(path);
        folder.mkdirs();
        File newFile = new File(path + File.separator + file.getName());
        newFile.createNewFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
            writeHeader(writer, header, ",");
            writeResult(writer, result, ",");
        } catch (IOException e) {
            throw new IOException(newFile.getName() + " Cannot be written!");
        }
    }

    private static String pathSetSeparator(String path) {
        return path.replace("/", File.separator);
    }

    private static void writeHeader(BufferedWriter writer, List<String> header, String delimiter)
            throws IOException {
        for (String value : header) {
            writer.write(value + (value.equals(header.get(header.size() - 1)) ? "\n" : delimiter));
        }
    }

    private static void writeResult(BufferedWriter writer, List<List<Long>> result, String delimiter)
            throws IOException {
        for (int i = 0; i < result.get(0).size(); i++) {
            for (int j = 0; j < result.size(); j++) {
                writer.write(toIntExact(result.get(j).get(i))
                        + (j == (result.size() - 1) ? "\n" : delimiter));
            }
        }
    }

    private static void propertiesWrite() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("path.properties")) {
            properties.load(fileInputStream);
            pathProperties = properties.getProperty("path");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String classTypeName(Class<?> sortClass) {
        String[] splited = sortClass.getName().split("\\.");
        return splited[splited.length - 1];
    }
}