package ru.atikhonov.listsandsets.constants;

import ru.atikhonov.listsandsets.model.Employee;

public class ConstantsForEmployeeAndDepartmentServicesTests {
    public static final int employees7Department = 7;
    public static final int employees6Department = 6;
    public static final Employee EMPLOYEE1 = new Employee("Тихонов", "Александр", "Александрович", employees7Department, 150_000);
    public static final Employee EMPLOYEE2 = new Employee("Кожнов", "Роман", "Андреевич", employees7Department, 100_000);

    public static final Employee EMPLOYEE3 = new Employee("Насекин", "Евгений", "Альбертович", employees6Department, 100_000);


}
