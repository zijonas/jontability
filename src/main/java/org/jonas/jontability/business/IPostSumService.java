package org.jonas.jontability.business;

import org.jonas.jontability.business.dto.MonthInfo;

import java.util.List;
import java.util.Optional;

public interface IPostSumService {
    Optional<List<MonthInfo>> getSumPerMonthForYear(int year);
}
