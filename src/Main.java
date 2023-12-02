import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        showSystemProperties();
        showSystemPropertiesAsList();
        showProperty("java.home");
        showWarningLogMessage("This is a warning message");
        cloneObjects();
        compareObjects();
        instanceOfExample();
        arrayCopyExample();
        systemExitExample();
    }

    private static void systemExitExample() {
        System.out.println("testing System.exit(0)");
        System.exit(0);
        System.out.println("This will not be executed");
    }

    private static void arrayCopyExample() {
        int[] arr = {1, 2, 3, 4, 5, 6, 88, 45, 65, 78, 65};
        int[] arr2 = new int[11];

        System.arraycopy(arr, 0, arr2, 0, 11);
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("arr2: " + Arrays.toString(arr2));
        nl();
    }

    private static void instanceOfExample() {
        Vehicle vehicle = new Car();
        System.out.println("vehicle.getClass() = " + vehicle.getClass());
        System.out.println("vehicle instanceof Vehicle = " + (vehicle instanceof Vehicle));
        nl();
    }

    private static void compareObjects() {
        Person p1 = new Person(22, "Ivan");
        Person p2 = p1;
        System.out.println("p1.equals(p2) = " + p1.equals(p2));
        p2 = p1.clone();
        System.out.println("p1.equals(p2), after cloning = " + p1.equals(p2));

        // method equals could be overridden
        // Creating anonymous class for demonstration
        Person p3 = new Person(22, "Ivan"){
            @Override
            public boolean equals(Object obj) {
                //return super.equals(obj);
                Person personToCompare = (Person) obj;
                return this.getName().equals(personToCompare.getName()) && this.getAge() == personToCompare.getAge();
            }
        };
        System.out.println("p1: " + p1 + " hashCode: " + p1.hashCode());
        System.out.println("p3: " + p3 + " hashCode: " + p3.hashCode());
        // now, the method equals returns true, even when the hash codes are different
        System.out.println("p3.equals(p1) = " + p3.equals(p1));
        nl();
    }


    private static void cloneObjects() {
        Person p1 = new Person(22, "Ivan");
        Person p2 = p1;

        //this will also change the age of p2
        p1.setAge(23);
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p2.getAge() after p1.setAge(23): " + p2.getAge());

        System.out.println("p1.hashCode() = " + p1.hashCode());
        System.out.println("p2.hashCode() = " + p2.hashCode());
        System.out.println("Creating a clone of p1..  p2 = p1.clone()");
        p2 = p1.clone();
        System.out.println("p1.hashCode() = " + p1.hashCode());
        System.out.println("p2.hashCode() = " + p2.hashCode());
        System.out.println("Now they are different objects with the same content\n\n");
    }

    private static void showWarningLogMessage(String message) {
        System.Logger logger = System.getLogger("TestLogger");
        logger.log(System.Logger.Level.WARNING, message);
    }

    private static void nl() {
        System.out.println("\n\n");
    }

    private static void showSystemPropertiesAsList() {
        System.getProperties().list(System.out);
        nl();
    }

    private static void showProperty(String s) {
        System.out.println(s + " = " + System.getProperty(s));
        nl();
    }

    private static void showSystemProperties() {
        System.out.println(System.getProperties().toString());
        nl();
    }
}