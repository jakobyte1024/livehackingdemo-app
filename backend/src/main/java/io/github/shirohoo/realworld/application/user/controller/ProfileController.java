package io.github.shirohoo.realworld.application.user.controller;

import io.github.shirohoo.realworld.application.user.response.ProfileResponse;
import io.github.shirohoo.realworld.application.user.service.ProfileService;
import io.github.shirohoo.realworld.domain.user.ProfileVO;
import io.github.shirohoo.realworld.domain.user.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/api/profiles/{username}")
    public ProfileResponse getProfile(User me, @PathVariable("username") String to) {
        ProfileVO profile = profileService.getProfile(me, to);
        return new ProfileResponse(profile);
    }

    @PostMapping("/api/profiles/{username}/follow")
    public ProfileResponse follow(User me, @PathVariable("username") String to) {
        ProfileVO profile = profileService.follow(me, to);
        return new ProfileResponse(profile);
    }

    @DeleteMapping("/api/profiles/{username}/follow")
    public ProfileResponse unfollow(User me, @PathVariable("username") String to) {
        ProfileVO profile = profileService.unfollow(me, to);
        return new ProfileResponse(profile);
    }
}
