package main.java.collections;

public class Student implements Comparable<Student> {
   
    int id;
    String name;
    int age;
    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }  

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Student other) {
        return other.id - this.id; // Descending order by id
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Integer.hashCode(age);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering into equals method");
        if(this == obj) return true;
        System.out.println("equals called");
        if(obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return id == other.id && age == other.age && (name != null ? name.equals(other.name) : other.name == null);
    }
}
