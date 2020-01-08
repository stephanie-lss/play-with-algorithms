/**
 * @author LiSheng
 * @date 2020/1/8 21:35
 */
public class SelectionSort<E extends Comparable<E>> {

    public void selectionSort(E[] arr, int n) {
        for (int i = 0; i < n; i++) {
            //寻找[i,n]区间里的最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private void swap(E[] arr, int i, int minIndex) {
        E tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }

    public static void main(String[] args) {
        //test Integer
        int n = 10000;
        Integer[] a = SortTestHelper.generateRandomArray(n, 0, n);
        SelectionSort<Integer> sortInt = new SelectionSort<>();
        SortTestHelper.printArray(a);
        sortInt.selectionSort(a, a.length);
        SortTestHelper.printArray(a);
        System.out.println();

        //test Double
        Double[] b = {4.3, 3.3, 2.2, 1.1};
        SelectionSort<Double> sortDouble = new SelectionSort<>();
        sortDouble.selectionSort(b, b.length);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        //test String
        String[] c = {"D", "C", "B", "A"};
        SelectionSort<String> sortString = new SelectionSort<>();
        sortString.selectionSort(c, c.length);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();

        //test Student
        Student student1 = new Student("B", 60);
        Student student2 = new Student("A", 70);
        Student student3 = new Student("C", 50);
        Student student4 = new Student("E", 50);
        Student student5 = new Student("F", 100);
        Student[] students = {student1, student2, student3, student4, student5};
        SelectionSort<Student> sortStudent = new SelectionSort<>();
        sortStudent.selectionSort(students, students.length);
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i] + " ");
        }
        System.out.println();
    }
}
