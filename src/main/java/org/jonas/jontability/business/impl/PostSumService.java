package org.jonas.jontability.business.impl;

import org.jonas.jontability.business.IPostSumService;
import org.jonas.jontability.business.dto.MonthInfo;
import org.jonas.jontability.persistence.IPostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostSumService implements IPostSumService {
    private final IPostRepository postRepository;

    public PostSumService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<List<MonthInfo>> getSumPerMonthForYear(int year) {
        Map<Integer, Double> perMonthByYear = postRepository.sumPerMonthByYear(year).stream().collect(Collectors.toMap(o -> (Integer) o[0], o -> (Double) o[1]));
        List<MonthInfo> monthInfo = new ArrayList<>(12);
        for (int i = 0; i < 12; i++) {
            monthInfo.add(new MonthInfo(i, perMonthByYear.getOrDefault(i + 1, 0d)));
        }
        return Optional.of(monthInfo);
    }
}
