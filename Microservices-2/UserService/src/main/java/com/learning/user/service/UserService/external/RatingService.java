package com.learning.user.service.UserService.external;

import com.learning.user.service.UserService.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/users/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable String userId);
}
