/**
 * @author LiSheng
 * @date 2020/1/8 21:53
 */
public class Student implements Comparable<Student> {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }


    @Override
    public int compareTo(Student student) {
        if (this.score - student.score > 0) {
            return -1;
        } else if (this.score - student.score < 0) {
            return 1;
        } else {
            System.out.println();
            return student.name.compareTo(this.name);
        }
    }

    @Override
    public String toString() {
        return "{" + name + " " + score + "}\n";
    }
}
