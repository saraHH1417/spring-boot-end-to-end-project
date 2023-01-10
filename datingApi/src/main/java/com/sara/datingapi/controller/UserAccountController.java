package com.sara.datingapi.controller;

import com.sara.datingapi.entities.Interest;
import com.sara.datingapi.entities.UserAccount;
import com.sara.datingapi.repos.InterestRepository;
import com.sara.datingapi.repos.UserAccountRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserAccountController {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private InterestRepository interestRepository;
    @PostMapping("/users/register-user")
    public UserAccount registerUser(@RequestBody UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @PostMapping("/interests/update")
    public Interest updateInterest(@RequestBody Interest interest) {
        Optional<UserAccount> userAccount = userAccountRepository.findById(interest.getUserAccountId());
        if (userAccount.isPresent()) {
            interest.setUserAccount(userAccount.get());
            interestRepository.save(interest);
            return interest;
        }
        return null;
    }

    @GetMapping("/users/get/all")
    public List<UserAccount> getUsers() {
        return userAccountRepository.findAll();
    }

    @DeleteMapping("interest/delete/{interestId}")
    public void deleteInterest(@PathVariable("interestId") int interestId) {
        interestRepository.deleteById(interestId);
    }

    @GetMapping("/users/matches/{id}")
    public List<UserAccount> findMatches(@PathVariable("id") int id) {
        Optional<UserAccount> optionaUser = userAccountRepository.findById(id);
        if (optionaUser.isPresent()) {
            UserAccount user = optionaUser.get();
            return userAccountRepository.findMatches(
                    user.getAge(),
                    user.getCity(),
                    user.getCountry(),
                    user.getId()
            );
        }
        return null;
    }
}
