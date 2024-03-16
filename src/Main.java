import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try(
                FileOutputStream fos = new FileOutputStream("src/FilePackage/TextFile")
                )
        {
            fos.write("Текст для проверки работы ".getBytes());
            System.out.println("FileOutputStream - работает");
        }
        catch (IOException e)
        {
            System.out.println("Ошибка ввода (FileOutputStream) ");
        }
        try(
                FileInputStream fis = new FileInputStream("src/FilePackage/TextFile");
        ){
            Scanner scan = new Scanner(fis);
            while(scan.hasNext()){
                String line = scan.nextLine();
                System.out.println(line);
            }
            System.out.println("FileInputStream - работает");
        }
        catch(IOException e){
            System.out.println("Ошибка вывода (FileInputStream) ");
        }
    }
}
class Main1{
    public static void main(String[] args) {

        try(
                FileWriter fiw = new FileWriter("src/FilePackage/TextFile2");
                )
        {
            BufferedWriter biw = new BufferedWriter(fiw);
            biw.write("Текст для проверки работы");
            biw.newLine();
            biw.write("Проверка вывода нескольких строк");
            biw.flush();
            System.out.println("File-/BufferedWriter - работает");
        }
        catch(IOException e)
        {
            System.out.println("Ошибка ввода (Buffered-/FileWriter) ");
        }
        try(
                FileReader fir = new FileReader("src/FilePackage/TextFile2")
                )
        {
            BufferedReader bir = new BufferedReader(fir);
            System.out.println(bir.readLine());
            bir.close();
            System.out.println("File-/BufferedReader - работает");
        }
        catch(IOException e){
            System.out.println("Ошбика вывода Buffered-/FileReader");
        }

    }
}
