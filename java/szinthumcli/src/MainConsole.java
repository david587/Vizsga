import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {
    //ide tároljuk a dolgozókat
    ArrayList<Employee> employeeList;
    //sort array
    ArrayList<Employee> smallSalary;

    public MainConsole() {
        //init
        this.employeeList = new ArrayList<>();
        this.smallSalary = new ArrayList<>();
        readContent();
        selectSmallSalary();
        writeFile();
    }

    public void readContent(){
        try {
            tryReadContent();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A file nem található");
        }
    }
    
    public void tryReadContent()throws FileNotFoundException{
        File file = new File("szinthum_dolgozok.csv");
        Scanner scanner = new Scanner(file,"utf-8");
        //ELSŐSOR mezőnév
        String firstLine = scanner.nextLine();
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String[] lineArray = line.split(",");
            Employee emp = new Employee(
                Integer.parseInt(lineArray[0]),
                lineArray[1],
                lineArray[2],
                Double.parseDouble(lineArray[3]),
                LocalDate.parse(lineArray[4])
                );
            //hozzáadjuk a listához    
            this.employeeList.add(emp);
        }
    }
    //szürjük a 200k nál kisebb fizetésű embereket
        public void selectSmallSalary(){
            for (Employee emp : this.employeeList) {
                if(emp.salary < 200000 ){
                    this.smallSalary.add(emp);
                }
            } 
        }

        //irjuk ezeket állományba
        public void writeFile() {
            try {
                tryWriteFile();
            } catch (IOException e) {
                System.err.println("Hiba! A fájlbaírás sikertelen");
            }
        }

        public void tryWriteFile() throws IOException{
            FileWriter fw = new FileWriter("keves.csv");
            for (Employee emp : this.smallSalary) {
                fw.write(emp.id.toString());
                fw.write(",");
                fw.write(emp.name);
                fw.write(",");
                fw.write(emp.city);
                fw.write(",");
                fw.write(emp.salary.toString());
                fw.write(",");
                fw.write(emp.birthdate.toString());
                fw.write("\n");
            }
            fw.close();
        }

}
