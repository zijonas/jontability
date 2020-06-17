package org.jonas.jontability.api.endpoint.post;

import org.jonas.jontability.business.IPostSumService;
import org.jonas.jontability.business.dto.MonthInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostSumController {

    private final IPostSumService postSumService;

    public PostSumController(IPostSumService postSumService) {
        this.postSumService = postSumService;
    }

    @GetMapping("/post/sum-per-month-by-year/{year}")
    public ResponseEntity<List<MonthInfo>> getSumPerMonthAndYear(@PathVariable int year) {
        return ResponseEntity.of(postSumService.getSumPerMonthForYear(year));
    }
}
