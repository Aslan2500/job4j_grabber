package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportDeveloper implements Report {

    private Store store;

    public ReportDeveloper(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html><table><body>"
                + "<tr>"
                + "<th>Name</th>"
                + "<th>Hired</th>"
                + "<th>Fired</th>"
                + "<th>Salary</th>"
                + "</tr>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr>")
                    .append("<td>").append(employee.getName()).append("</td>")
                    .append("<td>").append(employee.getHired()).append("</td>")
                    .append("<td>").append(employee.getFired()).append("</td>")
                    .append("<td>").append(employee.getSalary()).append("</td>")
                    .append("</tr>")
                    .append(System.lineSeparator());
        }
        text.append("</body></table></html>");
        return text.toString();
    }
}
