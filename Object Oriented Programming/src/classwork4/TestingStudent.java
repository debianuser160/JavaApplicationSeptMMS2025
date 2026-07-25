
package classwork4;


public class TestingStudent {
    public static void main(String[] args){
        Student[] studentObj = {
            new UnderGraduateStudent(),
            new GraduateStudent()
        };
        
        for (Student student : studentObj){
            student.study();
        }
    }
}