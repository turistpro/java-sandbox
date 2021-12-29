package com.github.turistpro.sandbox.interview.bank;

import java.util.List;

public interface OfficeBuilder {
    OfficeBuilder use(List<Employee> employees);

    Office buildOffice();
}
