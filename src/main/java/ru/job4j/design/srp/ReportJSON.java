package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        var lib = new GsonBuilder().create();
        return lib.toJson(employees);
    }
}
